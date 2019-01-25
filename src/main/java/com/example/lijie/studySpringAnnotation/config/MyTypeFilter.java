package com.example.lijie.studySpringAnnotation.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * auther lijie  2019/1/25.
 */
public class MyTypeFilter implements TypeFilter {

    /**
     * MetadataReader : 当前类信息
     * MetadataReaderFactory : 可以获取到其他任何类信息
     * @Author 李杰 lijie@ane56.com
     * @Date 2019/1/25 5:09 PM
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描的类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类资源(类的路径)
        Resource resource = metadataReader.getResource();
        String className = classMetadata.getClassName();
        System.out.println("---> " + className);
        if(className.contains("er")){
            return true;
        }
        return false;
    }
}