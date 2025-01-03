package com.ohgiraffers.crud.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@Configuration //ps 싱글톤 빈의 중복생성방지
@ComponentScan(basePackages = "com.ohgiraffers.crud") //ps 패키지를 스캔하여 스프링 빈으로 등록
@MapperScan(basePackages = "com.ohgiraffers.crud",annotationClass = Mapper.class) // MyBatis Mapper 인터페이스 스캔
public class ContextConfig {

    @Bean// 스프링 켄테이너에 의해 관리되는 빈을 생성
    public ReloadableResourceBundleMessageSource messageSource(){

        //스프링 애플리케이션에서 국제화 된 메세지를 관리하기 위해 사용
        ReloadableResourceBundleMessageSource source =
                new ReloadableResourceBundleMessageSource();

        // classpath:->src/main/resource , src/main/java 를 의미한다.
        source.setBasename("classpath:/messages/message");
        source.setDefaultEncoding("UTF-8");

        /* 제공하지 않는 언어로 요청 시에 사용할 메세지 설정 */
        Locale.setDefault(Locale.KOREA);

        return source;
    }
}
