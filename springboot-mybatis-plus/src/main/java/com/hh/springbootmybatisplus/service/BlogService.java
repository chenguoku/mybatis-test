package com.hh.springbootmybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hh.springbootmybatisplus.entity.BlogEntity;

/**
 * @author hh2016
 * @email hh2016@163.com
 * @date 2020-08-03 15:31:04
 */
public interface BlogService extends IService<BlogEntity> {
    /**
     * <p>
     * 查询 : 根据authorId查询文章列表，分页显示
     * </p>
     *
     * @param page     分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @param authorId 作者id
     * @return 分页对象
     */
    IPage<BlogEntity> selectPageVo(Page<?> page, Integer authorId);
}

