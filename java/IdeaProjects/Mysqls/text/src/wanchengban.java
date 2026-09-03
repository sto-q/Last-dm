import java.sql.*;
import java.util.Scanner;

public class wanchengban {
    public static Scanner  sc = new Scanner(System.in);
    public static String url = "jdbc:mysql://localhost:3306/exercise?serverTimezone=Asia/Shanghai";
    public static void main(String[] args) {
        String username=new lianjie().getUsername();
        String password=new lianjie().getPassword();
        Connection conn=null;
        Mainmuin mainmuin=new Mainmuin();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             conn= DriverManager.getConnection(url,username, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        while(true){
            int choice=0;
            mainmuin.Mainshow();
            try{
                 choice = sc.nextInt();
                sc.nextLine(); // 消耗换行符

            }catch(Exception e){
                System.out.println("请输入有效数字");
                sc.nextLine();
                continue;
            }
            if (choice == 5) {
                System.out.println("退出系统");
                break;
            }
            switch (choice) {
                case 1:
                    chaName(conn);
                    break;
                    case 2:
                        chaKe(conn);
                        break;
                        case 3:
                            chaScore(conn);
                            break;
                            case 4:
                                chaTotal(conn);
                                break;
                                default:
                                    System.out.println("无效选择");
                                    continue;
            }
        }
        try{
            if(conn!=null&&!conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
        sc.close();
    }

    public static void chaKe(Connection conn){
        try {
            System.out.println("请输入查找课程:");
            String scores=sc.next();
            sc.nextLine();
            String sql= "SELECT id,stu_name,course,score FROM score WHERE course= ? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, scores);
            ResultSet rs = pstmt.executeQuery();
            show(rs);
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void chaName(Connection conn){
        try {
            System.out.println("请输入查找人:");
            String Name=sc.next();
            sc.nextLine();
            String sql= "SELECT id,stu_name,course,score FROM score WHERE stu_name LIKE ? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%"+Name+"%");
            ResultSet rs = pstmt.executeQuery();
            show(rs);
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void chaScore(Connection conn){
        try {
            System.out.println("请输入查找范围成绩内学生:");
            int score1=sc.nextInt();
            int score2=sc.nextInt();
            sc.nextLine();
            String sql= "SELECT id,stu_name,course,score FROM score WHERE score > ? and score < ? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            int min = Math.min(score1, score2);
            int max = Math.max(score1, score2);
            pstmt.setInt(1, min);
            pstmt.setInt(2, max);
            ResultSet rs = pstmt.executeQuery();
            show(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void chaTotal(Connection conn){
        try {
            Statement stmt = conn.createStatement();//创建一个sql执行语句
            System.out.println("所有内容:");
            String sql= "SELECT id,stu_name,course,score FROM score";
            ResultSet rs = stmt.executeQuery(sql);
            show(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void show(ResultSet rs) throws SQLException {
        boolean hasData = false;
        System.out.println("ID\t姓名\t\t课程\t\t分数");
        System.out.println("----------------------------");
        while(rs.next()){
            hasData = true;
            int id=rs.getInt(1);
            String stu_name=rs.getString(2);
            String course=rs.getString(3);
            int score=rs.getInt(4);
            String format = "Jsp".equals(course) ?
                    "%d\t%s\t%s\t\t%d" : "%d\t%s\t%s\t%d";
            System.out.println(String.format(format, id, stu_name, course, score));
        }
        if(!hasData){
            System.out.println("没有找到匹配的数据");
        }
    }
}
