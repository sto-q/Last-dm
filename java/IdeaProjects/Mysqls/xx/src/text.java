import java.sql.*;

public class text {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/lesson?serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "159951";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connection连接数据库  DriverManager获取数据库中对象Connection
            Connection conn= DriverManager.getConnection(url,username, password);
            Statement stmt = conn.createStatement();//创建一个sql执行语句
            String sql1 = "SELECT account,balance,state FROM account";
            ResultSet rs = stmt.executeQuery(sql1);//执行语句并获取结果
            while(rs.next()){
                String account = rs.getString("account");
                double balance = rs.getDouble("balance");
                int state = rs.getInt("state");
                System.out.println(account+"\t"+balance+"\t"+state);
            }
            stmt.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
