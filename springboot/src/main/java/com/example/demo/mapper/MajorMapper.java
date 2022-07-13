package com.example.demo.mapper;

import com.example.demo.entity.Major;
import com.example.demo.entity.School;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MajorMapper {
    @Select("select * from major where id=#{id}")
    List<Major> findMajor(Integer id);

    @Select("select * from major where sort like concat('%',#{sort},'%') limit #{pageNum},10")
    List<Major> findbysort(String sort,Integer pageNum);

    @Select("select count(id) from major where sort like concat('%',#{sort},'%')")
    Integer countMajor(String sort);
//    @Update("INSERT INTO `major` (`id`, `majory`, `sort`,`detail`)VALUES(#{id}, #{majory}, #{sort},#{detail});")
//    @Transactional
//    void savemajor(Major major);
//
//    @Update("update major set majory=#{majory}, sort=#{sort}, detail=#{detail} where id=#{id}")
//    @Transactional
//    void updatebyId(Major major);
//
//    @Delete("delete from major where id=#{id}")
//    void deletebyID(Long id);
//
//    @Select("select * from major where id=#{id}")
//    Major findbyId(Long id);
//
//    @Select("select * from major limit #{pageNum},#{pageSize}")
//    List<Major> findbyPage(Integer pageNum, Integer pageSize);
//


}


