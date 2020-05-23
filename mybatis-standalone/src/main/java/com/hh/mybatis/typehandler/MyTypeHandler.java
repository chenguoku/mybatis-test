package com.hh.mybatis.typehandler;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenguoku
 * @version 1.0.0
 * @ClassName MyTypeHandler.java
 * @Description 练习TypeHandler
 * @createTime 2020年05月23日
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
public class MyTypeHandler extends BaseTypeHandler<List<Integer>> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, List<Integer> list, JdbcType jdbcType) throws SQLException {
        // 往 数据库存储 修改
        String join = StringUtils.join(list, ",");
        preparedStatement.setString(i, join);
    }

    @Override
    public List<Integer> getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        // 取值的修改，获取空结果集(根据列名)，一般用这个
        List<Integer> list = new ArrayList<>();
        String dataSourceString = resultSet.getString(columnName);
        String[] split = dataSourceString.split(",");
        for (String s : split) {
            list.add(Integer.parseInt(s));
        }

        return list;
    }

    @Override
    public List<Integer> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        //取值的修改,获取空结果集(根据下标)

        return null;
    }

    @Override
    public List<Integer> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        // 取值的修改，存储过程用的

        return null;
    }


}
