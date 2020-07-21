package com.hh.mybatisspringboot.mapper;


import com.hh.mybatisspringboot.entity.Blog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: hh2016
 */
@Mapper
public interface BlogMapper {

    /**
     * 通过id 查询文字
     */
    Blog selectBlogById(Integer bid);

}
