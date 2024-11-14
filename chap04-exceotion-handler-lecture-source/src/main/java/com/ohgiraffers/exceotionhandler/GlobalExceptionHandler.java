package com.ohgiraffers.exceotionhandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice   // AOP 기능 중 Advice 기능과 유사
public class GlobalExceptionHandler {

    //@ExceptionHandler 의 우선순위는 해당 클래스에 핸들러가 있으면 클래스 레벨이 먼저 이다.
    @ExceptionHandler(NullPointerException.class)
    public String globalNull(NullPointerException exception){
        System.out.println("전역 레벨의 exception 처리");
        return "error/nullPointer";
    }

    @ExceptionHandler(NullPointerException.class)
    public String globalUser(Model model, MemberNotFoundException exception) {
        model.addAttribute("exception", exception);
        return "error/nullNotFound";
    }

    //부모 타입인 Exception 이용

    @ExceptionHandler(Exception.class)
    public String defaultException(Exception exception){
        return  "error/default";
    }
}
