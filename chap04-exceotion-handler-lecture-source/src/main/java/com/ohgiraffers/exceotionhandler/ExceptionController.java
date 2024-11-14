package com.ohgiraffers.exceotionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionController {

    @GetMapping("nullpointer")
    public String nullpointerException(){
        String str = null;
        System.out.println(str.charAt(0));

        return "/";
    }

    //@ExceptionHandler  예외 발생시 동작하는 만들어 놓은 메서드
    @ExceptionHandler(NullPointerException.class)
    public String nullHandler(){
        System.out.println("controller 레벨에서 NullPointer 예외 처리 ");

        return "error/nullPointer";
    }

    @GetMapping("userexception")
    public String userException() throws MemberNotFoundException {
        boolean check = true ;  // 에러나오게 셋팅중..
        if(check){
            throw new MemberNotFoundException("모시 모시?");
        }
        return "/";
    }

    @ExceptionHandler(MemberNotFoundException.class)
    public String userException(Model model , MemberNotFoundException exception){
        model.addAttribute("exception", exception);
        return "error/memberNotFound";
    }

}
