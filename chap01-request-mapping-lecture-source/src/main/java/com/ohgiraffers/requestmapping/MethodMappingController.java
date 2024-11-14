package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*comment
* Spring Boot 는 Servlet 이 내장되어 있다.
* 지금까지 요청을 처리할 서블릿이 동작을 했다면
* 이제는 Servlet 은 요청을 즉시 @Controller 어노테이션이
* 달린 클래스에 처리를 위임한다.*/
@Controller
public class MethodMappingController {
    /* 1.메소드 방식 미지정 */
    // 사용자의 요청을 메칭시킬 메소드

    @RequestMapping("/menu/regist")
    public String registMenu(Model model){

        /* comment
        * Model 객체는 값을 담을 수 있는 공간이다.
        * key 와 value 형식으로 값을 담게 되며, 추후 응답시
        * view 에서 사용할 수 있게 된다. -> 나중에 더 다룰 예정
        * addAttribute 라는 메소드를 사용해서 값을 담을 수 있다.
        *  */
        model.addAttribute("message","메뉴 등록용 핸들러 메소드 동작 확인");
        /*comment
        * Controller 계층의 마지막 임무는 사용자에게 어떻게 응답을 해줄것인지 이다.
        * 메소드의 반환 타입을 String 으로 해서 문자열을 전달하면
        * resources / templates 하위 경로의 파일을 탐색하게 된다.
        * */

        return "mappingResult";

    }

    /*2 메소드 방식 지정*/
    // 요청 url 을 value 속성, 요청방식을 method 속성에 지정
    // GET 방식의 요청만 받게 명시를 하였다.
    // 그렇기 때문에 URL 이 같더라도 POST 방식의 요청은 받을 수 없다.
    @RequestMapping(value = "/menu/modify" , method = RequestMethod.GET)
    public String modifyMenu(Model model){
        model.addAttribute("message","GET 방식만 허용하는 메뉴 수정 핸들러 메소드 호출");

        return "mappingResult";
    }


    /*요청 메소드      어노테이션
    *  post             @PostMapping
    *  GET              @GetMapping
    *  PUT              @PutMapping
    *  DELETE           @DeleteMapping
    * */
    @GetMapping("/menu/delete")
    public String getDeleteMenu(Model model){
       model.addAttribute("message","get 방식의 메뉴 삭제용 핸들러 메소드");
        return "mappingResult";
    }


    @PostMapping("/menu/delete")
    public String postDeleteMenu(Model model){
        model.addAttribute("message","post 방식의 메뉴 삭제용 핸들러 메소드");
        return "mappingResult";
    }
}
