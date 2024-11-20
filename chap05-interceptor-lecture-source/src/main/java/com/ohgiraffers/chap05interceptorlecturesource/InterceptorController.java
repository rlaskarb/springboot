package com.ohgiraffers.chap05interceptorlecturesource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterceptorController {

    @GetMapping("stopwatch")
    public String handlerMethod() throws InterruptedException {
        System.out.println("Controller 핸들러 호출");

        // 2 초간 아무것도 작동하지 않게 만드는 sleep 메소드
        Thread.sleep(2000);

        return "result";
    }

}
