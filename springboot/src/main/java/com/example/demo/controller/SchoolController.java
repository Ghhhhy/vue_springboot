package com.example.demo.controller;

import com.example.demo.entity.Major;
import com.example.demo.entity.School;
import com.example.demo.mapper.SchoolMapper;
import com.example.demo.request.Result;
import com.example.demo.vo.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SchoolController {
    @Resource
    SchoolMapper schoolMapper;

    @GetMapping("/school/info")
    public Result getSchool(@RequestParam(value = "id",required=false,defaultValue = "") Integer id){
        List<School> school= schoolMapper.findSchool(id);
        return Result.success(school);
    }

    @PostMapping("/school")
    public Result findSortSchool(@RequestParam(value = "name",required=false,defaultValue = "") String name,
                           @RequestParam(value = "address",required=false,defaultValue = "") String address,
                           @RequestParam(value = "form",required=false,defaultValue = "") String form,
                           @RequestParam(value = "pageNum",required=false,defaultValue = "1") Integer pageNum){
        Integer offset=(pageNum-1)*10;
        List<School> Sort= schoolMapper.findbySort(name,address,form,offset);
        Page<School> page=new Page<>();
        page.setDetail(Sort);

        Integer total=schoolMapper.countSchool(name,address,form);
        page.setTotal(total);
        page.setPageNum(pageNum);
        page.setPageSize(10);
        return Result.success(page);
    }
    @PostMapping("/select")
    public Result selectSchool(@RequestParam(value = "score",required=false,defaultValue = "") Integer score,
                               @RequestParam(value = "rank",required=false,defaultValue = "") Integer rank,
                               @RequestParam(value = "pageNum",required=false,defaultValue = "1") Integer pageNum){
        Integer offset=(pageNum-1)*10;
        List<School> select= schoolMapper.selectschool(score,rank,offset);
        select.sort(Comparator.comparingInt(School::getMinscore).reversed());
        Page<School> page=new Page<>();
        page.setDetail(select);

        Integer total=schoolMapper.countschool(score,rank);
        page.setTotal(total);
        page.setPageNum(pageNum);
        page.setPageSize(10);
        return Result.success(page);
    }
//    @GetMapping("/select/page")
//    public Page<School> findPage(@RequestParam(required=false,defaultValue = "1") Integer pageNum,
//                                  @RequestParam(required=false,defaultValue = "10") Integer pageSize){
//        Integer offset=(pageNum-1)*pageSize;
//        List<School> schoolData=schoolMapper.findbyPage(offset,pageSize);
//        Page<School> page=new Page<>();
//        page.setDetail(schoolData);
//
//        Integer total=schoolMapper.countSchool();
//        page.setTotal(total);
//        page.setPageNum(offset);
//        page.setPageSize(pageSize);
//        return page;
//    }
}
