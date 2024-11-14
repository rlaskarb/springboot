package com.ohgiraffers.handlermethod;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

@Controller
@RequestMapping("/request/*")
@SessionAttributes("id")
public class RequestController {


    @GetMapping("regist")
    public void regist(){}

    /*WebRequest 객체로 요청 파라미터 전달 받기*/
    /*스피링 프레임 워크는 내부적으로 Servlet 을 사용하고 있다*/

    @PostMapping("regist")
    public String registMenu(Model model , WebRequest request){
        String menuName = request.getParameter("name");
        int menuPrice = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));

        String message = menuName + "을(를) 신규 메뉴 목록 " +
                    categoryCode + "번 카테고리에 " + menuPrice +
                    "원으로 등록 !";
        model.addAttribute("message",message);

        return "request/printResult";
    }


    @GetMapping("modify")
    public void modify(){}

    /*name 속성이 일치하지 않으면 에러가 발생한다.
    * 이유는 Required 속성 기본값이 true 이기 때문이다.
    * 그렇다면 Required 기본 값을 false 로 변경하면 name 오류가 나면 null 로 나온다 */
    @PostMapping("modify")
    public String modifyMenu(Model model ,
                             @RequestParam(required = false) String name,
                             @RequestParam(defaultValue = "0") int price){
        String message = name + "의 가격을" + price + "으로 수정";

        model.addAttribute("message", message);

        return "request/printResult";

    }
    /**/

    @PostMapping("modifyAll")
    public String modifyAll(Model model ,
                            @RequestParam Map<String , String> parameters ){

        String menuName = parameters.get("modifyName2");
        int menuPrice = Integer.parseInt(parameters.get("modifyPrice2"));

        String message = menuName + " 의 가격을 " +
                menuPrice +  "원으로 등록 !";


        model.addAttribute("message",message);

        return "request/printResult";
    }



    @GetMapping("search")
    public void search(){}
    
    
    /*  @RequestParam 지금은 몇개 없어서 불편함 없이 작성이 가능하다
    *   그렇다 위에있는건 빌드업이다
    *  @ModelAttribute */
    @PostMapping("search")
    public String searchMenu(@ModelAttribute("menu") MenuDTO menu){

        System.out.println("menu = " + menu);
        
        return  "request/searchResult";
    }
    
    @GetMapping("login")
    public void login(){}

    /*HttpSession 객체 이용 요청 값 저장*/

    @PostMapping("login1")
    public String sessionTest(HttpSession session ,
                              @RequestParam String id){

        session.setAttribute("id",id);

        return "request/loginResult";

    }

    @GetMapping("logout1")
    public String logout1(HttpSession session){
        session.invalidate();
        return "request/loginResult";
    }

    /* @SessionAttributes 를 이용한 session 에 값 담기*/
    @PostMapping("login2")
    public String sessionTest2(Model model,
                               @RequestParam String id){

        model.addAttribute("id",id); // @SessionAttributes ("id")  <-- 클래스 위 여기 id 랑 일치해야한다.

        return "request/loginResult";
    }
    /*SessionAttributes 방식은 */
    @GetMapping("logout2")
    public String logout2(SessionStatus sessionStatus){
        sessionStatus.setComplete();

        return "request/loginResult";

    }

    @GetMapping("body")
    public void body(){}


    /*@RequestBody
    * key&값 key&값 <- 쿼리스트링
    * Jackson 컨버터 : 자바스크립트 객체 <--> 자바 객체
    * 자동변환 해주어 프론트 엔드(js 기반) 백엔드 서버(java 기반)
    * 간의 데이터 전송을 할수 있게 해준다. */
    @PostMapping("body")
    public void bodyTest(@RequestBody String body) throws UnsupportedEncodingException {
        System.out.println("body = " + body);
        //body 값을 알수없이 변환 되어 나타났따.
        //암호화 처리 같이 알수없는 단어로 변환한건 encoding 이다.
        //해석할려면 decoding 해야 한다.
        System.out.println(URLDecoder.decode(body,"UTF-8")); // decoding
    }



}
