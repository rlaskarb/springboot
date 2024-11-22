package com.ohgiraffers.crud.menu.model.dao;

import com.ohgiraffers.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuAndCategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/*더 구체적인 기능을 가진 어노테이션이다. */
@Mapper
public interface MenuMapper {
    List<MenuDTO> findAllMenus();

    List<CategoryDTO> findAllCategory();

    void registNewMenu(MenuDTO newMenu);

    List<MenuAndCategoryDTO> findAllMenuAndCategory();

    void deleteMenu(int code);
}
