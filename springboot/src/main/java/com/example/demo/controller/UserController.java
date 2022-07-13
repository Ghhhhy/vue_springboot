package com.example.demo.controller;

import com.example.demo.entity.Center;
import com.example.demo.entity.CenterInfo;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.request.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Resource
    private UserMapper userMapper;

    @PostMapping("/login")
    public Result getuser(@RequestParam(value = "username",required=false,defaultValue = "") String username,
                          @RequestParam(value = "password",required=false,defaultValue = "") String password){
        User user=userMapper.verifyuser(username,password);
        if(user==null){
            return  Result.fail("用户不存在或密码错误");
        }
        return Result.success("登录成功");
    }
    @PostMapping("/register")
    public Result adduser(@RequestParam(value = "username",required=false,defaultValue = "") String username,
                          @RequestParam(value = "password",required=false,defaultValue = "") String password){
        User user=userMapper.finduser(username);
        if(user!=null){
            return Result.fail("已有用户");
        }else{
            userMapper.adduser(username,password);
            return Result.success("注册成功");
        }
    }
    @PostMapping("/addcenter")
    public Result addcenter(@RequestParam(value = "username",required=false,defaultValue = "") String username,
                          @RequestParam(value = "id",required=false,defaultValue = "") Integer id){
        User center=userMapper.findcenter(username,id);
        if(center!=null){
            return Result.fail("已添加");
        }else{
            userMapper.addcenter(username,id);
            return Result.success("添加成功");
        }
    }
    @PostMapping("/center")
    public Result Listcenter(@RequestParam(value = "username",required=false,defaultValue = "") String username){
       List<CenterInfo> centerinfo=userMapper.Listcenter(username);
       return Result.success(centerinfo);
    }
    @PostMapping("/delete")
    public Result deletecenter(@RequestParam(value = "username",required=false,defaultValue = "") String username,
                               @RequestParam(value = "id",required=false,defaultValue = "") Integer id){
        User center=userMapper.findcenter(username,id);
        if(center==null){
            return Result.fail("未找到");
        }else{
            userMapper.deletecenter(username,id);
            return Result.success("现已删除");
        }
    }
}
