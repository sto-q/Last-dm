import java.sql.*;

public class text2 {
    static Connection con = null;
    static Statement st = null;

    public static void main(String[] para) {
        String url = "jdbc:mysql://localhost:3306/mmm?serverTimezone=Asia/Shanghai";
        String user = "root";
        String password = "159951";
        int insertNumber = 0;
        String sql1 = "insert into selectCourse(studentNo,studentName,courseNo) values('1','董飞','11'); ";
        String sql2 = "insert into selectCourse(studentNo,studentName,courseNo) values('2','董飞','22'); ";
        String sql3 = "insert into selectCourse(studentNo,studentName,courseNo) values('3','韩飞','33'); ";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            insertNumber += st.executeUpdate(sql1);
            insertNumber += st.executeUpdate(sql2);
            insertNumber += st.executeUpdate(sql3);
            System.out.println("successfully insert " + insertNumber + " records.");

            if (st != null)
                st.close();
            if (con != null)
                con.close();
        } catch (ClassNotFoundException e1) {
            System.out.println(e1.getMessage());
        } catch (SQLException e2) {
            System.out.println(e2.getMessage());
        }
    }
}