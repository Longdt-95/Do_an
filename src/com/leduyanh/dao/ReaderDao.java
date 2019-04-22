
package com.leduyanh.dao;

import com.leduyanh.model.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReaderDao {
    public Reader getReaderById(int reader_id){
         
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.Reader WHERE reader_id = ?";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, reader_id);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Reader reader = new Reader();
                reader.setReader_id(rs.getInt("reader_id"));
                reader.setAddress(rs.getString("address"));
                reader.setEmail(rs.getString("email"));
                reader.setName(rs.getString("name"));
                reader.setPhone(rs.getString("phone"));
                return reader;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Reader> getAllReader(){
        List<Reader> readers = new ArrayList<Reader>();
       
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.Reader";    
       
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Reader reader = new Reader();
                reader.setReader_id(rs.getInt("reader_id"));
                reader.setName(rs.getString("name"));
                reader.setAddress(rs.getString("address"));
                reader.setEmail(rs.getString("email"));
                reader.setPhone(rs.getString("phone"));
                readers.add(reader);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return readers;
    }
    
    public void deleteReader(int reader_id){
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql2 = "DELETE dbo.Reader WHERE reader_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setInt(1, reader_id);
            ResultSet rs = preparedStatement.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void addReader(Reader reader){
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "INSERT INTO dbo.Reader(name, address, email, phone) VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, reader.getName());
            preparedStatement.setString(2, reader.getAddress());
            preparedStatement.setString(3, reader.getEmail());
            preparedStatement.setString(4, reader.getPhone());
            int rs = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateReader(Reader reader){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE dbo.Reader SET name=?,address=?,email=?,phone=? WHERE reader_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, reader.getName());
            preparedStatement.setString(2, reader.getAddress());
            preparedStatement.setString(3, reader.getEmail());
            preparedStatement.setString(4, reader.getPhone());
            preparedStatement.setInt(5, reader.getReader_id());
            int rs = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Reader> searchReaderFromName(String name){
        List<Reader> readers = new ArrayList<Reader>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.Reader where name LIKE ?";    
        
        StringBuffer stringBufferTile = new StringBuffer();
        stringBufferTile.append("%");
        stringBufferTile.append(name);
        stringBufferTile.append("%");
        String titleLike = stringBufferTile.toString();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, titleLike);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Reader reader = new Reader();
                reader.setReader_id(rs.getInt("reader_id"));
                reader.setName(rs.getString("name"));
                reader.setAddress(rs.getString("address"));
                reader.setEmail(rs.getString("email"));
                reader.setPhone(rs.getString("phone"));
                readers.add(reader);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return readers;
    }
    
    public List<Reader> searchReaderFromEmail(String email){
        List<Reader> readers = new ArrayList<Reader>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.Reader where email LIKE ?";    
        
        StringBuffer stringBufferTile = new StringBuffer();
        stringBufferTile.append("%");
        stringBufferTile.append(email);
        stringBufferTile.append("%");
        String titleLike = stringBufferTile.toString();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, titleLike);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Reader reader = new Reader();
                reader.setReader_id(rs.getInt("reader_id"));
                reader.setName(rs.getString("name"));
                reader.setAddress(rs.getString("address"));
                reader.setEmail(rs.getString("email"));
                reader.setPhone(rs.getString("phone"));
                readers.add(reader);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return readers;
    }
    
    public List<Reader> searchReaderFromPhone(String phone){
        List<Reader> readers = new ArrayList<Reader>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.Reader where phone LIKE ?";    
        
        StringBuffer stringBufferTile = new StringBuffer();
        stringBufferTile.append("%");
        stringBufferTile.append(phone);
        stringBufferTile.append("%");
        String titleLike = stringBufferTile.toString();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, titleLike);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Reader reader = new Reader();
                reader.setReader_id(rs.getInt("reader_id"));
                reader.setName(rs.getString("name"));
                reader.setAddress(rs.getString("address"));
                reader.setEmail(rs.getString("email"));
                reader.setPhone(rs.getString("phone"));
                readers.add(reader);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return readers;
    }
}
