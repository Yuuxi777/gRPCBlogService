package com.example.blogService.mapper;

import com.example.blogService.entity.Blog;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BlogMapper {

    @ResultType(Blog.class)
    @Select("SELECT * FROM blog WHERE 1=1 AND id = #{id}")
    Blog getBlogById(@Param("id") Integer id);

}
