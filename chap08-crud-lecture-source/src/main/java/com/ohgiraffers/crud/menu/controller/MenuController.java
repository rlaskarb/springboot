package com.ohgiraffers.crud.menu.controller;

import com.ohgiraffers.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuAndCategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import com.ohgiraffers.crud.menu.model.service.MenuService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.Locale;

@Controller// 요청을 처리하는 클래스
@RequestMapping("/menu/*") // /menu/* 시작하는 URL 을 처리.
public class MenuController {

    //* Logging : 우리가 들어온 흔적을 남기는것 -개발자를 위한
    // * 애플리케이션이 실행 중 발생 하는 이벤트 ( 정보 , 경고 , 오류) 등을 기록하는 과정.
    private static final Logger logger = LogManager.getLogger(MenuController.class);

    private final MenuService menuService;
    private final MessageSource messageSource;

    @Autowired // 의존성 주입을 담당 ( 필요하다면 빌려는 드릴께 말만해)
    public MenuController(MenuService menuService , MessageSource messageSource){
        this.menuService=menuService;
        this.messageSource = messageSource;
    }


    @GetMapping("list")
    public String findMenuList(Model model){ // Model 객체는 데이터를 뷰로 전달하는 역활

        List<MenuDTO> menuList= menuService.findAllMenus();
        for(MenuDTO menu : menuList){
            System.out.println("menu = " + menu);;
        }
        model.addAttribute("menuList",menuList);

    return "menu/list";
    }


    @GetMapping("regist")
    public void registPage(){}


    @GetMapping(value = "category",produces = "application/json; charset=UTF-8") // json -> 자바스크립트 객체 표기법을 의미한다.
    @ResponseBody // 리턴구문이 뷰가 아니라 데이터 이다.
    public List<CategoryDTO>findCategoryList(){
        return menuService.findAllCategory();
    }


    @PostMapping("regist")
    public String registMenu(@ModelAttribute MenuDTO newMenu, RedirectAttributes rttr , Locale locale){

        /*@ModelAttribute : form 태그로 묶어서 넘오는 값을 클래스 자료형에 담기 위해 작성하는 어노테이션
        * RedirectAttributes : 리다이렉트 시 저장할 값이 있으면 사용하는 객체*/

        /*comment
        * TRACE: 상세한 디버깅 정보
        * DEBUG: 개발중 디버깅용 정보
        * INFO: 일반적인 실행정보
        * WARN: 잠재적인 문제경고
        * ERROR: 실행중 발생한 오류
        * */

        logger.info("Locale : {}",locale); //
        logger.info("newMenu : {}",newMenu);

        menuService.registMenu(newMenu);
        rttr.addFlashAttribute("successMessage",messageSource
                .getMessage("regist",new Object[]{newMenu.getName(),newMenu.getPrice()},locale));

        return "redirect:/menu/list";
    }


    @GetMapping("join/list")
    public String menuAndCategoryList(Model model){

        List<MenuAndCategoryDTO> joinList
                = menuService.findAllMenusAndCategory();

        model.addAttribute("joinList", joinList);

        return "menu/join";
    }


    @GetMapping("delete")
    public String deletePage(){
        return "menu/delete";
    }

    @PostMapping("delete")
    public String deleteMenu(@RequestParam int code, RedirectAttributes rttr, Locale locale){

        menuService.deleteMenu(code);

        rttr.addFlashAttribute("successMessage" ,
                messageSource.getMessage("delete", new Object[]{code},locale));
        return "redirect:/menu/list";
    }

}
