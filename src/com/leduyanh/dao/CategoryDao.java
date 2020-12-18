
package com.leduyanh.dao;

import com.leduyanh.model.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryDao {
    public List<Category> getAllCategory(){
        List<Category> categories = new ArrayList<Category>();
       
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.Category";    
       
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Category category = new Category();
                category.setCategory_id(rs.getInt("category_id"));
                category.setCategory_name(rs.getString("category_name"));
                categories.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }
    
    public int getCategoryIdByValue(String value){
         
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.Category WHERE category_name = ?";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, value);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Category category = new Category();
                category.setCategory_id(rs.getInt("category_id"));
                
                return category.getCategory_id();
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public String getCategoryById(int category_id){
         
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.Category WHERE category_id = ?";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, category_id);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Category category = new Category();
                category.setCategory_name(rs.getString("category_name"));
                
                return category.getCategory_name();
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public int getCountBookByCategory(int category_id){
         
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.Book WHERE category_id = ?";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, category_id);
            ResultSet rs = preparedStatement.executeQuery();
            
            int index=0;
            while(rs.next()){
                index++;
            }
            
            return index;
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
     
     public int getCountBookByCategoryTotal(int category_id){
         
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.Book WHERE category_id = ?";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, category_id);
            ResultSet rs = preparedStatement.executeQuery();
            
            int total = 0;
            while(rs.next()){
                total += rs.getInt("amount");
            }
            
            return total;
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
}
