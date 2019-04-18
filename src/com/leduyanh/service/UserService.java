
package com.leduyanh.service;

import com.leduyanh.dao.UserDao;
import com.leduyanh.model.User;
import java.util.List;


public class UserService {
    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }
    
    public User getUserById(int user_id){
        return userDao.getUserById(user_id);
    }
}
