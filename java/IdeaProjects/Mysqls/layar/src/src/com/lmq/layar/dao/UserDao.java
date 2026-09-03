package src.com.lmq.layar.dao;

import src.com.lmq.layar.mondel.User;

public interface UserDao {
    int saveUser(String username, String password, String satl);
    User getUserByUsername(String username);


}
