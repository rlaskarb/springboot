package com.ohgiraffers.chap05interceptorlecturesource;

import org.springframework.stereotype.Service;

@Service
public class MenuService {
    /*comment
    * Interceptor 가 빈에 개입할수 있는걸 증명해주겠다 */

    public void method(){
        System.out.println("Service 계층의 메소드 호출");

    }
}
