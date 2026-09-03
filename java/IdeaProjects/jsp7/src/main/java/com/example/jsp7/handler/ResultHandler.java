package com.example.jsp7.handler;

import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;

/**
 * 对查询的接口集进行处理的接口，怎么实现根据用户处理
 * @param <T>
 */
public interface ResultHandler<T> {
    T handle(ResultSet rs) throws SQLException;
}
