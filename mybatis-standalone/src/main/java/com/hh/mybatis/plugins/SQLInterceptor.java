package com.hh.mybatis.plugins;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;

import java.sql.Statement;
import java.util.Properties;

/**
 * @author chenguoku
 * @version 1.0.0
 * @ClassName SQLInterceptor.java
 * @Description 拦截记录sql执行时间
 * @createTime 2020年07月20日
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class})})
public class SQLInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        long startTime = System.currentTimeMillis();
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        String sql = boundSql.getSql();
        System.out.println("获取到SQL语句：" + sql);

        try {
            return invocation.proceed();
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("SQL执行耗时：" + (endTime - startTime) + "ms");
        }

    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        String hh = properties.getProperty("hh");
        System.out.println("获取到的参数：" + hh);
    }
}