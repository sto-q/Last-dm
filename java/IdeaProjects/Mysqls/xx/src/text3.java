import java.sql.*;

public class text3 {
    static Connection con = null;
    static Statement st = null;
    static ResultSet rs = null;

    public static void main(String[] para) {
        String url = "jdbc:mysql://localhost:3306/mmm?serverTimezone=Asia/Shanghai";
        String user = "root";
        String password = "159951";
        String sql = "select * from selectcourse";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()) {
                String s1 = rs.getString(1);
                String s2 = rs.getString(2);
                String s3 = rs.getString(3);
                String s4 = rs.getString(4);

                System.out.print(s1);
                System.out.print("    " + s2);
                System.out.print("    " + s3);
                System.out.println("    " + s4);
            }

            if(st != null)
                st.close();
            if(con != null)
                con.close();
        }
        catch(ClassNotFoundException e1) {
            System.out.println(e1.getMessage());
        }
        catch(SQLException e2) {
            System.out.println(e2.getMessage());
        }
    }
}