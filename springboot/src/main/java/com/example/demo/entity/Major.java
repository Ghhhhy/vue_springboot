package com.example.demo.entity;

import lombok.Data;

@Data//实现下面那一堆代码
public class Major {
    private Integer id;
    private String majory;
    private String category;
    private String sort;
    private String detail;


//    public Integer getId() {
//        return id;
//    }
//
//    public void setCode(Integer code) {
//        this.code = code;
//    }
//
//    public String getMajory() {
//        return majory;
//    }
//
//    public void setMajory(String majory) {
//        this.majory = majory;
//    }
//
//    public String getSort() {
//        return sort;
//    }
//
//    public void setSort(String sort) {
//        this.sort = sort;
//    }
//
//    public String getDetail() {
//        return detail;
//    }
//
//    public void setDetail(String detail) {
//        this.detail = detail;
//    }
}
