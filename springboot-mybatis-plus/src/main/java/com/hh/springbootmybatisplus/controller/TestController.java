package com.hh.springbootmybatisplus.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hh.springbootmybatisplus.entity.BlogEntity;
import com.hh.springbootmybatisplus.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: hh2016
 */
@RestController
public class TestController {

    @Autowired
    private BlogService blogService;

    /**
     * @Description 根据id查询
     * @Param id    blog的id
     * @Return blog对象
     * @Author chenguoku
     * @Date 2020-8-3
     */
    @GetMapping("test/{id}")
    public BlogEntity getBlog(@PathVariable("id") Integer id) {
        BlogEntity blogEntity = blogService.getById(id);
        return blogEntity;
    }

    @GetMapping("test/page/{id}")
    public List<BlogEntity> getBlogList(@PathVariable("id") Integer id) {
        Page<BlogEntity> page = new Page<>();
        page.setSize(2);
        page.setCurrent(2);
        IPage<BlogEntity> blogEntityIPage = blogService.selectPageVo(page, id);
        List<BlogEntity> records = blogEntityIPage.getRecords();
        return records;
    }

}
