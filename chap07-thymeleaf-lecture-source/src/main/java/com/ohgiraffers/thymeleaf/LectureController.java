package com.ohgiraffers.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/lecture/*")
public class LectureController {


    @GetMapping("expression")
    public ModelAndView expression(ModelAndView mv){

        mv.addObject("member",new MemberDTO("킴남규",27,'남',"인천구월동"));

        mv.addObject("hello","hi~<h2>타임리프</h2>");

        mv.setViewName("/lecture/expression");

        return mv;
    }


    @GetMapping("conditional")
    public ModelAndView conditional(ModelAndView mv){
        mv.addObject("num",1);
        mv.addObject("str","바나나");

      ArrayList<MemberDTO> memberList =new ArrayList<>();
        memberList.add(new MemberDTO("핑",4,'여',"서울시 노진구"));
        memberList.add(new MemberDTO("점핑",7,'여',"서울시 이진구"));
        memberList.add(new MemberDTO("쇼핑",6,'여',"서울시 오진구"));
        memberList.add(new MemberDTO("키핑",10,'여',"서울시 저진구"));

        mv.addObject("memberList",memberList);

        mv.setViewName("lecture/conditional");


        return mv;

    }

    @GetMapping("etc")
    public ModelAndView etc(ModelAndView mv){

        SearchCriteria criteria= new SearchCriteria(1,10,3);

        mv.addObject(criteria);

        ArrayList<MemberDTO> memberList =new ArrayList<>();
        memberList.add(new MemberDTO("핑",4,'여',"서울시 노진구"));
        memberList.add(new MemberDTO("점핑",7,'여',"서울시 이진구"));
        memberList.add(new MemberDTO("쇼핑",6,'여',"서울시 오진구"));
        memberList.add(new MemberDTO("키핑",10,'여',"서울시 저진구"));

        mv.addObject("memberList",memberList);

        Map<String, MemberDTO> memberMap = new HashMap<>();
        memberMap.put("1", new MemberDTO("하츄핑", 4, '여', "서울시 노진구"));
        memberMap.put("2", new MemberDTO("시진핑", 76, '남', "베이징 사천구"));
        memberMap.put("3", new MemberDTO("티니핑", 8, '남', "서울시 광진구"));
        memberMap.put("4", new MemberDTO("핑구", 4, '남', "서울시 핑구"));
        mv.addObject("memberMap",memberMap);

        mv.setViewName("lecture/etc");

        return mv;

    }

    @GetMapping("fragment")
    public ModelAndView fragment(ModelAndView mv) {

        mv.addObject("test", "value");
        mv.addObject("test2", "value2");

        mv.setViewName("lecture/fragment");

        return mv;
    }


}
