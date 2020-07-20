package com.hh.mybatis;

import com.hh.mybatis.domain.Blog;
import com.hh.mybatis.mapper.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author chenguoku
 * @version 1.0.0
 * @ClassName MyBatisTest.java
 * @Description MyBatis插件测试
 * @createTime 2020年07月20日
 */
public class MyBatisPluginTest {


    /**
     * 测试自定义的ObjectFactory
     * 可以设置 生成对象的一些默认属性
     */
    @Test
    public void testSqlInterceptor() {
        SqlSession sqlSession = getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = mapper.selectBlogById(1);
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
