
package com.leduyanh.dao;

import com.leduyanh.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class UserDao {
    public User getUserById(int user_id) throws SQLException{
         
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.Users WHERE user_id = ?"; 
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user_id);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setLeve(rs.getInt("level"));
                user.setPhone(rs.getString("phone"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (rs != null) {
                rs.close();
            }
            if (preparedStatement != null) {
                rs.close();
            }
            if (connection != null) {
                rs.close();
            }
        }
        return null;
    }
    
    public List<User> getAllUser() throws SQLException{
        List<User> users = new ArrayList<User>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM dbo.Users ORDER BY status desc";    
       
        try {
            preparedStatement = connection.prepareStatement(sql); 
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setPhone(rs.getString("phone"));
                user.setLeve(rs.getInt("level"));
                user.setFlag(rs.getInt("status"));
                user.setUsername(rs.getString("username"));
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (rs != null) {
                rs.close();
            }
            if (preparedStatement != null) {
                rs.close();
            }
            if (connection != null) {
                rs.close();
            }
        }
        return users;
    }
    
    public void addUser(User user){
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "INSERT INTO dbo.Users(name, phone, level, username, password, status) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPhone());
            preparedStatement.setInt(3, user.getLeve());
            preparedStatement.setString(4, user.getUsername());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setInt(6, user.getFlag());
            int rs = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Boolean CheckUsername(String username){
         
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.Users WHERE username = ?";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            
            int count=0;
            while(rs.next()){
                count++;
            }
            if(count == 0){
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<User> searchUserFromName(String name){
        List<User> users = new ArrayList<User>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.Users where name LIKE ?";    
        
        StringBuffer stringBufferTile = new StringBuffer();
        stringBufferTile.append("%");
        stringBufferTile.append(name);
        stringBufferTile.append("%");
        String nameLike = stringBufferTile.toString();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nameLike);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setPhone(rs.getString("phone"));
                user.setLeve(rs.getInt("level"));
                user.setFlag(rs.getInt("status"));
                user.setUsername(rs.getString("username"));
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
    public List<User> searchUserFromUsername(String userName){
        List<User> users = new ArrayList<User>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.Users where username LIKE ?";    
        
        StringBuffer stringBufferTile = new StringBuffer();
        stringBufferTile.append("%");
        stringBufferTile.append(userName);
        stringBufferTile.append("%");
        String nameLike = stringBufferTile.toString();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nameLike);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setPhone(rs.getString("phone"));
                user.setLeve(rs.getInt("level"));
                user.setFlag(rs.getInt("status"));
                user.setUsername(rs.getString("username"));
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
    public void deleteUser(int user_id){
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "DELETE dbo.Users WHERE user_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user_id);
            ResultSet rs = preparedStatement.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void blockUser(int user_id){
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "UPDATE dbo.Users SET status=0 WHERE user_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user_id);
            int result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void unlockUser(int user_id){
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "UPDATE dbo.Users SET status=1 WHERE user_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user_id);
            preparedStatement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public User CheckLogin(String userName, String passWord){
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.Users WHERE username = ? AND password = ?";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, passWord);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setLeve(rs.getInt("level"));
                user.setPhone(rs.getString("phone"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFlag(rs.getInt("status"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public JTable StatisUserByName(){
        
        JTable table = new JTable();
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT name, COUNT(name) FROM dbo.Users GROUP BY name";    
       
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return table;
    }
    
    public JTable StatisUserByRole(){
        
        JTable table = new JTable();
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT level, COUNT(level) FROM dbo.Users GROUP BY level";    
       
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return table;
    }
}
