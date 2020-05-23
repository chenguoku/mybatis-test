package com.hh.mybatis;

import com.hh.mybatis.domain.Blog;
import com.hh.mybatis.domain.BlogHandler;
import com.hh.mybatis.mapper.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenguoku
 * @version 1.0.0
 * @ClassName MyBatisTest.java
 * @Description MyBatis测试
 * @createTime 2020年05月19日 22:05:00
 */
public class MyBatisTest {

    /**
     * 最原始的使用
     */
    @Test
    public void baseUse() throws IOException {
        String resource = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Blog blog = mapper.selectBlogById(1);
            System.out.println(blog);
        } finally {
            session.close();
        }
    }

    /**
     * 测试TypeHandler插入
     */
    @Test
    public void testTypeHandlerInsert() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        BlogHandler blogHandler = new BlogHandler(3, list, 1001);

        SqlSession sqlSession = getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        int i = mapper.insertBlogHanler(blogHandler);

        sqlSession.commit();
        sqlSession.close();

        System.out.println(i);
    }

    /**
     * 测试TypeHandler查询
     */
    @Test
    public void testSelectTypeHandler() {
        SqlSession sqlSession = getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        BlogHandler blogHandler = mapper.getBlogHandler(3);
        System.out.println(blogHandler.toString());
    }

    /**
     * 测试自定义的ObjectFactory
     * 可以设置 生成对象的一些默认属性
     */
    @Test
    public void testMyObjectFactory() {
        SqlSession sqlSession = getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = mapper.selectBlogById(4);
        System.out.println(blog);
    }


    private SqlSession getSqlSession() {
        String resource = "mybatis-config.xml";

        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        return session;
    }

}
