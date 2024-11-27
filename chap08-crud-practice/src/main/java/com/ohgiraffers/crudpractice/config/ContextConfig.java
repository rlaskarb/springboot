package com.ohgiraffers.crudpractice.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@Configuration//ps 싱글톤 빈의 중복생성 방지.
@ComponentScan(basePackages = "com.ohgiraffers.crudpractice") //ps 스캔할 패키지 설정
@MapperScan(basePackages = "com.ohgiraffers.crudpractice" , annotationClass = Mapper.class) //ps MyBatis / 지정된 모든 Mapper 를 사용할수 있다.
public class ContextConfig {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource(){

        ReloadableResourceBundleMessageSource source =
                new ReloadableResourceBundleMessageSource();

        source.setBasename("classpath:/messages/message");
        source.setDefaultEncoding("UTF-8");

        Locale.setDefault(Locale.KOREA);

        return source;
    }

}
