package com.ohgiraffers.exceotionhandler;

import org.springframework.web.bind.annotation.GetMapping;

public class GlobalTestController {

    @GetMapping("global-nullpointer")
    public String globalNull(){
        String str = null;
        System.out.println(str.charAt(0));

        return "/";
    }

    @GetMapping("global-userexception")
    public String globalUserException() throws MemberNotFoundException {
            boolean check = true ;  // 에러나오게 셋팅중..
            if(check){
                throw new MemberNotFoundException("?????????");
            }
            return "/";
    }

    @GetMapping("global-default")
    public String manyException(){
        double[] array = new double[0];
        //배열의 크기를 0으로 만들어 두고
        // 1번쨰 데이터 출력할려고 할때
        System.out.println(array[0]);

        return "/";
    }
}
