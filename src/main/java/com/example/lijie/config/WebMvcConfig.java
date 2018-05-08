package com.example.lijie.config;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.example.lijie.config.interceptor.LoginInterceptor;
import com.example.lijie.config.interceptor.SignInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.example.lijie.web", "com.example.lijie.itf"})
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Autowired
    private SignInterceptor signInterceptor;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/styles/**").addResourceLocations("/styles/");
		registry.addResourceHandler("/images/**").addResourceLocations("/images/");
		registry.addResourceHandler("/scripts/**").addResourceLocations("/scripts/");
        registry.addResourceHandler("/views/**").addResourceLocations("/views/");;
    }
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		ByteArrayHttpMessageConverter byteArrayMessageConverter = new ByteArrayHttpMessageConverter();
		converters.add(byteArrayMessageConverter);

        FastJsonHttpMessageConverter4 httpMessageConverter = new FastJsonHttpMessageConverter4();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.WriteNullStringAsEmpty);
        httpMessageConverter.setFastJsonConfig(fastJsonConfig);
        SerializeConfig serializeConfig = new SerializeConfig();
        serializeConfig.put(java.util.Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
        fastJsonConfig.setSerializeConfig(serializeConfig);
		List<MediaType> supportedMediaTypes = new ArrayList<>();
		supportedMediaTypes.add(new MediaType("application", "json"));
        httpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
        converters.add(httpMessageConverter);

	}

	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver view = new InternalResourceViewResolver();
        view.setPrefix("/views/");
        view.setSuffix(".html");
        view.setContentType("text/html");
        view.setCache(false);
		return view;
	}


    @Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("utf-8");
        multipartResolver.setMaxUploadSize(20 * 1048576);
		return multipartResolver;
	}

    @Override
	public void addInterceptors(InterceptorRegistry registry) {
	    // 登陆拦截
        InterceptorRegistration registration = registry.addInterceptor(loginInterceptor);
        registration.excludePathPatterns(this.adaptPathPatterns(new String[] {"login/login","/login.html"}))
                .excludePathPatterns(this.adaptPathPatterns(new String[] {"/itf/*"}));
        // 接口签名校验拦截
        registry.addInterceptor(signInterceptor).addPathPatterns(this.adaptPathPatterns(new String[] {"/itf/*"}));

	}

	private String[] adaptPathPatterns(String[] paths) {
        String[] patterns = new String[paths.length];
        for (int i = 0; i < paths.length; i++) {
            String path = paths[i];
            if(path.endsWith("*")) {
                path += "*";
            }
            patterns[i] = path;
        }
        return patterns;
    }
}