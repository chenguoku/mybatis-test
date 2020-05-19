package com.hh.mybatis.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: hanhou2016
 */
@Data
public class Blog implements Serializable {
    /**
     * 文章ID
     */
    Integer bid;

    /**
     * 文章标题
     */
    String name;

    /**
     * 文章作者ID
     */
    Integer authorId;
}
