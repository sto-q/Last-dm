import java.sql.*;

public class text4 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mmm?serverTimezone=Asia/Shanghai";
            con = DriverManager.getConnection(url, "root", "159951");
            String sql = "UPDATE selectCourse set studentName= ? WHERE studentNo= ? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, "董菲菲");
            ps.setString(2, "3");
            int rowCount= ps.executeUpdate();
            System.out.println(rowCount + " record(s) updated.");
            ps.close();
            con.close();
        }
        catch (Exception e) {
        }
    }
}