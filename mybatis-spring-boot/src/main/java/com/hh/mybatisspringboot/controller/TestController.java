package com.hh.mybatisspringboot.controller;

import com.hh.mybatisspringboot.entity.Blog;
import com.hh.mybatisspringboot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hh2016
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("test/{id}")
    public Blog getBlog(@PathVariable("id") Integer id) {
        Blog blog = testService.getBlog(id);
        return blog;
    }

}
