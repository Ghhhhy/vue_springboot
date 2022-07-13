package com.example.demo.mapper;

import com.example.demo.entity.School;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SchoolMapper {
    @Select("select * from school where id=#{id}")
    List<School> findSchool(Integer id);

    @Select("select * from school where name like concat('%',#{name},'%') and address like concat('%',#{address},'%') and form like concat('%',#{form},'%') limit #{pageNum},10")
    List<School> findbySort(String name,String address,String form,Integer pageNum);

    @Select("select count(id) from school where name like concat('%',#{name},'%') and address like concat('%',#{address},'%') and form like concat('%',#{form},'%')")
    Integer countSchool(String name,String address,String form);

    @Select("select * from school where (Maxscore>=#{score} and Minscore<=#{score}) or (Maxrank<=#{rank} and Minrank>=#{rank}) limit #{pageNum},10")
    List<School> selectschool(Integer score, Integer rank,Integer pageNum);

    @Select("select count(id) from school where (Maxscore>=#{score} and Minscore<=#{score}) or (Maxrank<=#{rank} and Minrank>=#{rank})")
    Integer countschool(Integer score, Integer rank);

    //    @Select("select * from school where name like concat('%',#{name},'%') ")
//    List<School> findbySort(String name);
//    @Select("select * from school limit #{pageNum},#{pageSize}")
//    List<School> findbyPage(Integer pageNum, Integer pageSize);
}
