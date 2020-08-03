package com.hh.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hh.springbootmybatisplus.entity.BlogEntity;
import com.hh.springbootmybatisplus.mapper.BlogMapper;
import com.hh.springbootmybatisplus.service.BlogService;
import org.springframework.stereotype.Service;

/**
 * 实现类
 *
 * @author hh2016
 * @email hh2016@163.com
 * @date 2020-08-03 15:31:04
 */
@Service("blogService")
public class BlogServiceImpl extends ServiceImpl<BlogMapper, BlogEntity> implements BlogService {


    @Override
    public IPage<BlogEntity> selectPageVo(Page<?> page, Integer authorId) {
        IPage<BlogEntity> blogEntityIPage = this.baseMapper.selectPageVo(page, authorId);
        return blogEntityIPage;
    }
}