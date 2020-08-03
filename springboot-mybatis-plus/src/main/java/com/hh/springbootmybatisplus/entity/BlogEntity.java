package com.hh.springbootmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author hh2016
 * @email hh2016@163.com
 * @date 2020-08-03 15:17:00
 */
@Data
@TableName("blog")
public class BlogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer bid;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private Integer authorId;

}
