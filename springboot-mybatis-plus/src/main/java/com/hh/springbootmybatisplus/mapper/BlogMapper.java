package com.hh.springbootmybatisplus.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hh.springbootmybatisplus.entity.BlogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author hh2016
 * @email hh2016@163.com
 * @date 2020-08-03 15:17:00
 */
@Mapper
public interface BlogMapper extends BaseMapper<BlogEntity> {

    IPage<BlogEntity> selectPageVo(Page<?> page, Integer authorId);

}
