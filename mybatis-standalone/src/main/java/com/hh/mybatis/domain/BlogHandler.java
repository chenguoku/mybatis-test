package com.hh.mybatis.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: hanhou2016
 */
@Data
public class BlogHandler implements Serializable {
    /**
     * 文章ID
     */
    Integer bid;

    /**
     * 文章标题
     */
    List<Integer> name;

    /**
     * 文章作者ID
     */
    Integer authorId;

    public BlogHandler() {
    }

    public BlogHandler(Integer bid, List<Integer> name, Integer authorId) {
        this.bid = bid;
        this.name = name;
        this.authorId = authorId;
    }
}
