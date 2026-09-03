package com.cyx.jdbc.reflection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.*;

public class JdbcUtil {
    private static final String url ="jdbc:mysql://localhost:3306/lesson?serverTimezone=Asia/Shanghai";
    private static final String username = "root";
    private static final String password = "159951";
    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("没有驱动");
        }
    }
public static void main(String[] args) {
//    String sql="SELECT id,name,number,price ,agent_id agentId FROM goods WHERE name LIKE ? AND  price >?";
//    Object[] p={"%魅%",1000};
//    List<Goods> a =  query(sql,Goods.class,p);
//    a.forEach(System.out::println);
    String sql="SELECT id,name,region_id regionId FROM agent WHERE name LIKE ?";
    Object[] params = new Object[]{"%魅%"};
    List<Agent> agentList =query(sql,Agent.class,params);
    agentList.forEach(System.out::println);

}
public static int updata(String sql,Object... params){
        int result=0;
    Connection conn=null;
    PreparedStatement ps=null;
    try {
        conn=DriverManager.getConnection(url,username,password);
        ps=preparedStatement(conn,sql,params);
        result=ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }finally {
        close(conn,ps);
    }
    return result;
}
private static void close(AutoCloseable... closeable) {
        if (closeable != null&&closeable.length>0) {
            for (AutoCloseable closeable1 : closeable) {
                if (closeable1!=null) {
                    try{
                        closeable1.close();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
}
private static PreparedStatement preparedStatement(Connection conn,String sql,Object... params) throws SQLException {
    PreparedStatement ps=conn.prepareStatement(sql);
    if(params!=null&&params.length>0){
        for(int i=0;i<params.length;i++){
            ps.setObject(i+1,params[i]);
        }
    }
    return ps;
}
public static List<Agent> getAgents(){
//        String url ="jdbc:mysql://localhost:3306/lesson?serverTimezone=Asia/Shanghai";
//        String username = "root";
//        String password = "159951";
        List<Agent> agents=new ArrayList<Agent>();
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,username,password);
            String sql="SELECT id,name,region_id FROM agent WHERE name LIKE ?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,"%魅%");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Agent a=new Agent();
                a.setId(rs.getInt("id"));
                a.setName(rs.getString("name"));
                a.setRegionId(rs.getInt("region_id"));
                agents.add(a);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        agents.forEach(System.out::println);
    return agents;
}
public static List<Goods> getGoods(){
//    String url ="jdbc:mysql://localhost:3306/lesson?serverTimezone=Asia/Shanghai";
//    String username = "root";
//    String password = "159951";
    List<Goods> goods=new ArrayList<Goods>();
    try {
//        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=DriverManager.getConnection(url,username,password);
        String sql="SELECT id,name,number,price ,agent_id agentId FROM goods WHERE name LIKE ? AND  price >?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,"%魅%");
        ps.setDouble(2,1000.00);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Goods a=new Goods();
            a.setId(rs.getInt("id"));
            a.setName(rs.getString("name"));
            a.setNumber(rs.getInt("number"));
            a.setPrice(rs.getDouble("price"));
            a.setAgentId(rs.getInt("agent_id"));
            goods.add(a);
        }
        rs.close();
        ps.close();
        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
return goods;
}
private static<T> T createInstance(Class<T> clazz,ResultSet rs)throws Exception{
    Constructor<T> c=clazz.getConstructor();
    T t=c.newInstance();
    Field[] fields=clazz.getDeclaredFields();
    for(Field f:fields){
        String fieldname=f.getName();
        String methodname="set"+fieldname.substring(0,1).toUpperCase()+fieldname.substring(1);
        Method m=clazz.getDeclaredMethod(methodname,f.getType());
        try {
            Object value=rs.getObject(fieldname,f.getType());
            m.invoke(t,value);
        } catch (Exception e) {}

    }
    return t;
}
public   static <T> List<T> query(String sql,Class<T> clazz ,Object... params){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
    List<T> datalist=new ArrayList<>();
    try {
         conn=DriverManager.getConnection(url,username,password);
         ps=preparedStatement(conn,sql,params);
         rs=ps.executeQuery();
        ResultSetMetaData rsmd=rs.getMetaData();
        while(rs.next()){
            T t=createInstance(clazz,rs);
             datalist.add(t);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }finally {
        close(rs,conn,ps);
    }
    return datalist;
}
}
