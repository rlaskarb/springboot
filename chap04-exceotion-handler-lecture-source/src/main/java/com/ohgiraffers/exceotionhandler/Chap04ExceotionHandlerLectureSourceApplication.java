package com.ohgiraffers.exceotionhandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chap04ExceotionHandlerLectureSourceApplication {

    /*다른 클래스에서 @ExceptionHandler 메소드를 작성 해두었다고 해서 지금 클래스에서 발생하는 예외를 처리할 수는 없다
    * 왜냐고 연관이 없으니까 */
    public static void main(String[] args) {
        SpringApplication.run(Chap04ExceotionHandlerLectureSourceApplication.class, args);
    }

}
