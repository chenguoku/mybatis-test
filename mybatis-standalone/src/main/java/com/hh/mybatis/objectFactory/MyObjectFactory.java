package com.hh.mybatis.objectFactory;

import com.hh.mybatis.domain.Blog;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

/**
 * @author chenguoku
 * @version 1.0.0
 * @ClassName MyObjectFactory.java
 * @Description 对象工厂（objectFactory），可以设置 生成类的一些默认属性
 * @createTime 2020年05月23日 19:08:00
 */
public class MyObjectFactory extends DefaultObjectFactory {

    @Override
    public <T> T create(Class<T> type) {
        System.out.println("###使用自己的 ObjectFactory创建对象");
        if (type.equals(Blog.class)) {
            Blog blog = (Blog) super.create(type);
            blog.setBid(1);
            blog.setName("测试ObjectFactory");
            blog.setAuthorId(2);
            return (T) blog;
        }

        return super.create(type);
    }
}
