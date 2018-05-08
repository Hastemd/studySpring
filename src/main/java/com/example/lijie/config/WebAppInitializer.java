package com.example.lijie.config;

import com.example.lijie.config.filter.BodyReaderRequestWrapper;
import com.example.lijie.config.filter.RequestWrapperFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.util.WebAppRootListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * auther lijie  2018/5/8.
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        registerEncodingFilter(servletContext);
        registerWrapperFilter(servletContext);

        servletContext.addListener(WebAppRootListener.class);
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {ApplicationConfig.class};

    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    /**
     * 字符编码过滤器
     * @param servletContext 上下文
     */
    private void registerEncodingFilter(ServletContext servletContext) {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        servletContext.addFilter("CharacterEncodingFilter", characterEncodingFilter)
                .addMappingForUrlPatterns(null, false, "/*");
    }

    /**
     * 该过滤器将需要从请求流中读取参数进行拦截校验的请求重新包装<br>
     * 原因：请求流只能读一次，重新包装以便校验读取之后真正使用参数时能再次读取<br>
     * 只用于对外接口
     * @see BodyReaderRequestWrapper
     * @param servletContext 上下文
     */
    private void registerWrapperFilter(ServletContext servletContext) {
        servletContext.addFilter("RequestWrapperFilter", new RequestWrapperFilter())
                .addMappingForUrlPatterns(null, false, "/itf/*");
    }
}