package com.ohgiraffers.crud.menu.model.service;

import com.ohgiraffers.crud.menu.model.dao.MenuMapper;
import com.ohgiraffers.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuAndCategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class MenuService {
    private final MenuMapper menuMapper;

    @Autowired
    public MenuService(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    public List<MenuDTO> findAllMenus() {

        return menuMapper.findAllMenus();
    }

    public List<CategoryDTO> findAllCategory() {

        return menuMapper.findAllCategory();
    }

    /*스프링 프레임 워크에서 제공하는 트랙젝션 관리 어노테이션으로
     * 데이터 베이스의 상태를 변환시키는 작업(DML)을 하나의 단위로 묶는 것을 의미한다. 따라서 데이터 베이스 조작에 관련된 일이
     * 일어날때 메소드의 실행이 정상적으로 완료되면 commit 예외가 발생하면 rollback 을 수행하여
     * 데이터의 일관성을 유지하는데 사용된다. 내부적으로 AOP 기능을 사용하고 있다. */
    @Transactional
    public void registMenu(MenuDTO newMenu) {

        menuMapper.registNewMenu(newMenu);
    }


    public List<MenuAndCategoryDTO> findAllMenusAndCategory() {

        return menuMapper.findAllMenuAndCategory();
    }

    @Transactional
    public void deleteMenu(int code) {
        menuMapper.deleteMenu(code);
    }


    public List<MenuDTO> findAllMenusUrl() {

        return menuMapper.findAllMenus();
    }

}
