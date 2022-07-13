package com.example.demo.entity;
import lombok.Data;

@Data//实现下面那一堆代码
public class CenterInfo {
    private String username;
    private Integer id;
    private String name;
    private String level;
    private String address;
    private String form;
    private String number;
    private String urllink;
    private String urlImg;
    private Integer Maxscore;
    private Integer Minscore;
    private Integer Maxrank;
    private Integer Minrank;
    private String detail;
}
