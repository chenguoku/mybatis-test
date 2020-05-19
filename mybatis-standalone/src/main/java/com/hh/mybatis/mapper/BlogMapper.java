package com.hh.mybatis.mapper;

import com.hh.mybatis.domain.Blog;

/**
 * @Author: hh2016
 */
public interface BlogMapper {

    /**
     * 通过id 查询文字
     */
    Blog selectBlogById(Integer bid);


}
