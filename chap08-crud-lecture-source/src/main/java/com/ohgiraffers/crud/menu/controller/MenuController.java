package com.ohgiraffers.crud.menu.controller;

import com.ohgiraffers.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import com.ohgiraffers.crud.menu.model.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;


@Controller
@RequestMapping("/menu/*")
public class MenuController {

private final MenuService menuService;

private final MessageSource messageSource;

    @Autowired
    public MenuController(MenuService menuService , MessageSource messageSource){
        this.menuService=menuService;
        this.messageSource = messageSource;
    }


    @GetMapping("list")
    public String findMenuList(Model model){

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

        menuService.registMenu(newMenu);
        rttr.addFlashAttribute("successMessage",messageSource
                .getMessage("regist",new Object[]{newMenu.getName(),newMenu.getPrice()},locale));

        return "redirect:/menu/list";


    }


}
