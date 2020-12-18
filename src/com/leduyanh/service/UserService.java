
package com.leduyanh.service;

import com.leduyanh.dao.UserDao;
import com.leduyanh.model.User;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JTable;


public class UserService {
    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }
    
    public User getUserById(int user_id) throws SQLException{
        return userDao.getUserById(user_id);
    }
    
    public List<User> getAllUser() throws SQLException{
        return userDao.getAllUser();
    }
    
    public void addUser(User user){
        userDao.addUser(user);
    }
    
    public Boolean CheckUsername(String username){
        return userDao.CheckUsername(username);
    }
    
    public List<User> searchUserFromName(String name){
        return userDao.searchUserFromName(name);
    }
    
    public List<User> searchUserFromUsername(String userName){
        return userDao.searchUserFromUsername(userName);
    }
    
    public void deleteUser(int user_id){
        userDao.deleteUser(user_id);
    }
    
    public void blockUser(int user_id){
        userDao.blockUser(user_id);
    }
    
    public void unlockUser(int user_id){
        userDao.unlockUser(user_id);
    }
    
    public User CheckLogin(String userName, String passWord){
        return userDao.CheckLogin(userName, passWord);
    }
    
    public JTable StatisUserByName(){
        return userDao.StatisUserByName();
    }
    
    public JTable StatisUserByRole(){
        return userDao.StatisUserByRole();
    }
}
