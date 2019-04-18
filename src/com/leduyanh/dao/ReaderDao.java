
package com.leduyanh.dao;

import com.leduyanh.model.Reader;
import com.leduyanh.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    
}
