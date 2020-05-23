package com.hh.mybatis.mapper;

import com.hh.mybatis.domain.Blog;
import com.hh.mybatis.domain.BlogHandler;

/**
 * @Author: hh2016
 */
public interface BlogMapper {

    /**
     * 通过id 查询文字
     */
    Blog selectBlogById(Integer bid);

    /**
     * 插入一个文字，测试typehandler
     */
    int insertBlogHanler(BlogHandler blogHandler);

    /**
     * 测试查询 TypeHandler
     */
    BlogHandler getBlogHandler(Integer bid);
}
