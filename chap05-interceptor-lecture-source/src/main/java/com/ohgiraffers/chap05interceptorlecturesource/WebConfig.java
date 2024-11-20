package com.ohgiraffers.chap05interceptorlecturesource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    /*comment
    * Interceptor 는 만들었다고 해서 끝이 아니다.
    * webMvcConfigurer 를 통해서 만든 인터셉터를 을록하는 과정이 필요하다.*/

    @Autowired
    private HandleInterceptor handleInterceptor;

    //우리가 만든 인터셉터를 Registry = 저장소
    // 자정소에 등록하는 역활을 한다.
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(handleInterceptor)
                // 인터셉터가 어떤 요청에 동작할 것인지 정의
                .addPathPatterns("/*")
                // static (정적인요소) 파일을 풀러오는 것도
                //하나의 요청이다.
                //따라서 인터셉터가 간순화면 꾸미기 위한
                //요청에도 동작을 하는것은 비효율적이기 때문에
                //제외할 경로로 지정하는 것이 중요하다.
                .excludePathPatterns("/css/")
                .excludePathPatterns("/asset/*")
                .excludePathPatterns("/js/*")
                .excludePathPatterns("/image/*");
    }
}
