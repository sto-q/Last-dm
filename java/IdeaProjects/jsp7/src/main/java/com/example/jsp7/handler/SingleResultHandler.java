package com.example.jsp7.handler;

import org.apache.commons.beanutils.BeanUtils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SingleResultHandler <T> implements ResultHandler{

private Class<T> clazz;

    public SingleResultHandler(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object handle(ResultSet rs) throws SQLException {
        int count=0;
        while(rs.next()){
            count++;
            if(count>1)throw new RuntimeException("查询结果存在多条数据"+count);
            try {
                if(clazz .isPrimitive()||Integer.class==clazz||Long.class==clazz){
                    return rs.getObject(1,clazz);
                }
                T t=clazz.newInstance();
                Map<String,Object> values=new HashMap<>();
                ResultSetMetaData rsmd=rs.getMetaData();
                int columnCount=rsmd.getColumnCount();
                for(int i=1;i<=columnCount;i++){
                    String columnLabel = rsmd.getColumnLabel(i);
                    Object columnValue = rs.getObject(columnLabel);
                    values.put(columnLabel,columnValue);
                }
                //使用工具类对我们的对象的属性值进行注入
                BeanUtils.populate(t,values);
                return  t;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
