package com.ohgiraffers.viewresolver;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ResolverController {

    /*
    * 핸들러 메소드에서 마지막으로 해야 할 일은
    * client 에게 응답을 해야 할 페이지를 리턴하는 것이다.
    * 스프링에서는 다양한 전략에 맞게 뷰를 해설할수 있는
    * viewResolver 구현체가 존재한다.
    * 우리가 Thymeleaf 의존성을 추가하게 된다면
    * 뷰리졸버는 타임리프 문법을 해석할 수 있는
    * ThymeleafViewResolver 로 전환되며
    * 이는 pre(이전에)fix(고정해준다) 로 resource/templates/
    * suffix 로 .html 을 자동으로 붙여주게 된다.*/

    @GetMapping("string")
    public String stringReturn(Model model){

        model.addAttribute("forwardMessage"
                            ,"문자열로 view 반환하기!" );

        return "result";
    }

    @GetMapping("string-redirect")
    public String stringRedirect(){
        /*그동안  default 로  forward 방식이다.
        * redirect 를 하는 방법은 접두사로
        * redirect : 를 붙이면 된다.*/

        return "redirect:/";
    }

    @GetMapping("string-redirect-attr")
    public String redirectAttr(RedirectAttributes attr){

        attr.addFlashAttribute("flashMessage",
                                "리다이랙트 시 값 유지!!!");     // 잠깐 넣다가 뺀다.(소멸식)

        return "redirect:/";

    }
    /*Model 과 View 를 합친 개념이다.
    * 값을 집어 넣을 수도 있고 , 화면을 결정 지을 수 도 있다.*/
    @GetMapping("modelandview")
    private ModelAndView modelAndView(ModelAndView mv){

        mv.addObject("forwardMessage",
                        "ModelAmdView 를 이용해서 반환!!!");
        //문자열로 이동하고 싶은 view 페이지를 지정할수 있다.
        mv.setViewName("result");

        return mv;
    }

    @GetMapping("modelandview-redirect-attr")
    public ModelAndView mvRedirectAttr(ModelAndView mv,RedirectAttributes attr){
        attr.addFlashAttribute("flashMessage2",
                                "ModelAndView 리다이랙트 시 값 유지");
        mv.setViewName("redirect:/");

        return mv;
    }

}
