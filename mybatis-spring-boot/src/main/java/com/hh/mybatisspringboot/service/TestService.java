package com.hh.mybatisspringboot.service;

import com.hh.mybatisspringboot.entity.Blog;
import com.hh.mybatisspringboot.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: hh2016
 */
@Service
public class TestService {

    @Autowired
    private BlogMapper blogMapper;

    public Blog getBlog(Integer id) {
        Blog blog = blogMapper.selectBlogById(id);
        return blog;
    }

}
