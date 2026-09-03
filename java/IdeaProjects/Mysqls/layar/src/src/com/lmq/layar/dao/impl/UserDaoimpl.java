package src.com.lmq.layar.dao.impl;
import com.cyx.jdbc.reflection.JdbcUtil;
import src.com.lmq.layar.dao.UserDao;
import src.com.lmq.layar.mondel.User;
import java.sql.*;
import java.util.List;

public class UserDaoimpl implements UserDao {

    @Override
    public int saveUser(String username, String password, String satl) {
        String sql ="INSERT INTO .`user` (`username`, `password`, `salt`) VALUES (?, ?, ?)";
        Object[] params = {username, password, satl};
        return  JdbcUtil.updata(sql,params);
    }

    @Override
    public User getUserByUsername(String username) {
        String sql = "select username,password.salt from users where username=?";
        List<User> users = JdbcUtil.query(sql,User.class,username);
        return users.size()==0?null:users.get(0);
    }
}
