package com.example.demo.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    private int code;
    private String msg;
    private  Object data;

    public static Result success(String msg){
        return success(200,msg,null);
    }
    public static Result success(Object data){
        return success(200,"操作成功",data);
    }

    public static Result success(int code,String msg,Object data){
        Result suc=new Result();
        suc.setCode(code);
        suc.setMsg(msg);
        suc.setData(data);
        return suc;
    }
    public static Result fail(String msg){
        return fail(400,msg,null);
    }
    public static Result fail(String msg,Object data){
        return fail(400,msg,data);
    }
    public static Result fail(int code,String msg,Object data){
        Result fail=new Result();
        fail.setCode(code);
        fail.setMsg(msg);
        fail.setData(data);
        return fail;
    }
}
