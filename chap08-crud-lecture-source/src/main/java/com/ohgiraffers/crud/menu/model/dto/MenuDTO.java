package com.ohgiraffers.crud.menu.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MenuDTO {
   /* DTO 는 DateBase 컬럼과 일치하게 작성하거나
   * 화면상에서 request 하는 데이터를 작성한다.*/

    private int code;
    private String name;
    private int price;
    private int categoryCode;
    private String orderableStatus;
    private String detailUrl;
    private int id;


}
