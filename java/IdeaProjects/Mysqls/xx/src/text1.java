import java.sql.*;

public class text1 {
    static Connection con = null;
    static Statement st = null;

    public static void main(String[] para) {
        String url = "jdbc:mysql://localhost:3306/mmm?serverTimezone=Asia/Shanghai";
        String user = "root";
        String password = "159951";
        String sql = "create table selectCourse(id int auto_increment primary key, studentNo char(10) not null, studentName varchar(20) not null, courseNo varchar(10))";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            st.executeUpdate(sql);
            System.out.println("successfully create a table.");
            if (st != null)
                st.close();
            if (con != null)
                con.close();
        } catch (ClassNotFoundException e1) {
            System.out.println("fail to create a table.");
        } catch (SQLException e2) {
            System.out.println("fail to create a table.");
        }
    }
}