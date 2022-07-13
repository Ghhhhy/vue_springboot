package com.example.demo.controller;

import com.example.demo.entity.Major;

import com.example.demo.entity.School;
import com.example.demo.mapper.MajorMapper;
import com.example.demo.request.Result;
import com.example.demo.vo.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MajorController {

    @Resource
    MajorMapper majorMapper;

    @GetMapping("/major/info")
    public Result getAllMajor(@RequestParam(value = "id",required=false,defaultValue = "") Integer id){
        List<Major> major= majorMapper.findMajor(id);
        return Result.success(major);
    }
    @PostMapping("/major")
    public Result getSortMajor(@RequestParam(value = "sort",required=false,defaultValue = "") String sort,
                               @RequestParam(value = "pageNum",required=false,defaultValue = "1") Integer pageNum){
        Integer offset=(pageNum-1)*10;
        List<Major> Sort=majorMapper.findbysort(sort,offset);
//        Sort.sort(Comparator.comparingInt(Major::getId).reversed());
        Page<Major> page=new Page<>();
        page.setDetail(Sort);

        Integer total=majorMapper.countMajor(sort);
        page.setTotal(total);
        page.setPageNum(pageNum);
        page.setPageSize(10);
        return Result.success(page);
    }

//    @PostMapping("/major")
//    public String addMajor(@RequestBody Major major){
//        majorMapper.savemajor(major);
//        return "success";
//    }
//    @PutMapping("/major")
//    public String updateMajor(@RequestBody Major major){
//        majorMapper.updatebyId(major);
//        return "success";
//    }
//    @DeleteMapping("/major/{id}")
//    public String deleteMajor(@PathVariable("id") Long id){
//        majorMapper.deletebyID(id);
//        return "success";
//}
//    @GetMapping("/major/{id}")
//    public Major findbyId(@PathVariable("id") Long id){
//        return majorMapper.findbyId(id);
//    }
//
//    @GetMapping("/major/page")
//    public Page<Major> findbyPage(@RequestParam(defaultValue = "1") Integer pageNum,
//                                  @RequestParam(defaultValue = "10") Integer pageSize){
//        Integer offset=(pageNum-1)*pageSize;
//        List<Major> majorData=majorMapper.findbyPage(offset,pageSize);
//        Page<Major> page=new Page<>();
//        page.setData(majorData);
//
//        Integer total=majorMapper.countMajor();
//        page.setTotal(total);
//        page.setPageNum(offset);
//        page.setPageSize(pageSize);
//        return page;
//    }
}
