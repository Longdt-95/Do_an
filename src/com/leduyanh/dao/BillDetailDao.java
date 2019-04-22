
package com.leduyanh.dao;

import com.leduyanh.model.BillDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BillDetailDao {
    public void addBook(List<Integer> book_ids, int bill_id){
       Connection connection = JDBCConnection.getJDBCConnection();
       
        for(Integer book_id : book_ids){
            String sql = "INSERT INTO dbo.bill_detail(bill_id, book_id, fined) VALUES (?,?,?)";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, bill_id);
                preparedStatement.setInt(2, book_id);
                preparedStatement.setString(3, "0");

                int rs = preparedStatement.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(BillDetailDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }
    
    public List<BillDetail> getAllBillDetail(int billId){
        List<BillDetail> billdts = new ArrayList<BillDetail>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.bill_detail where bill_id = ?";    
       
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, billId);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                BillDetail billdt = new BillDetail();
                billdt.setBill_detail_id(rs.getInt("bill_detail_id"));
                billdt.setBill_id(billId);
                billdt.setBook_id(rs.getInt("book_id"));
                billdt.setDate_pay(rs.getString("date_pay"));
                billdt.setFined(rs.getString("fined"));
                billdts.add(billdt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return billdts;
    }
}
