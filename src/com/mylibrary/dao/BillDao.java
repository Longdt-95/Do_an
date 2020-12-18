
package com.leduyanh.dao;

import com.leduyanh.model.Bill;
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

/**
 *
 * @author Admin
 */
public class BillDao {
    public List<Bill> getAllBill(){
        List<Bill> bills = new ArrayList<Bill>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.Bill";    
       
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Bill bill = new Bill();
                bill.setBill_id(rs.getInt("bill_id"));
                bill.setReader_id(rs.getInt("reader_id"));
                bill.setUser_id(rs.getInt("user_id"));
                bill.setDate(rs.getString("date"));
                bill.setDeposit(rs.getString("deposit"));
                bills.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bills;
    }
    
    public void addBill(Bill bill){
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "INSERT INTO dbo.Bill(reader_id, user_id, deposit, date, date_hen) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bill.getReader_id());
            preparedStatement.setInt(2, bill.getUser_id());
            preparedStatement.setString(3, bill.getDeposit());
            preparedStatement.setString(4, bill.getDate());
            preparedStatement.setString(5, bill.getDate_hen());
            int rs = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(BillDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getBillIdNew(){
         
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT TOP(1) * FROM dbo.Bill ORDER BY bill_id desc";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Bill bill = new Bill();
                bill.setBill_id(rs.getInt("bill_id"));
                
                return bill.getBill_id();
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    
    public Bill getBillById(int bill_id){
         
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.Bill WHERE bill_id = ?";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bill_id);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Bill bill = new Bill();
                bill.setBill_id(rs.getInt("bill_id"));
                bill.setUser_id(rs.getInt("user_id"));
                bill.setReader_id(rs.getInt("reader_id"));
                bill.setDeposit(rs.getString("deposit"));
                bill.setDate_hen(rs.getString("date_hen"));
                bill.setDate(rs.getString("date"));
                return bill;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Bill> searchBillFromReader(String searchKeyWord){
        List<Bill> bills = new ArrayList<Bill>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.Bill INNER JOIN dbo.Reader ON dbo.Bill.reader_id = dbo.Reader.reader_id where name LIKE ?";    
        
        StringBuffer stringBufferTile = new StringBuffer();
        stringBufferTile.append("%");
        stringBufferTile.append(searchKeyWord);
        stringBufferTile.append("%");
        String searchKeyWordLike = stringBufferTile.toString();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, searchKeyWordLike);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Bill bill = new Bill();
                bill.setBill_id(rs.getInt("bill_id"));
                bill.setReader_id(rs.getInt("reader_id"));
                bill.setUser_id(rs.getInt("user_id"));
                bill.setDeposit(rs.getString("deposit"));
                bill.setDate(rs.getString("date"));
                bill.setDate_hen(rs.getString("date_hen"));
                bills.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bills;
    }
    
    public List<Bill> searchBillFromUser(String searchKeyWord){
        List<Bill> bills = new ArrayList<Bill>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.Bill INNER JOIN dbo.Users ON dbo.Bill.user_id = dbo.Users.user_id where name LIKE ?";    
        
        StringBuffer stringBufferTile = new StringBuffer();
        stringBufferTile.append("%");
        stringBufferTile.append(searchKeyWord);
        stringBufferTile.append("%");
        String searchKeyWordLike = stringBufferTile.toString();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, searchKeyWordLike);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Bill bill = new Bill();
                bill.setBill_id(rs.getInt("bill_id"));
                bill.setReader_id(rs.getInt("reader_id"));
                bill.setUser_id(rs.getInt("user_id"));
                bill.setDeposit(rs.getString("deposit"));
                bill.setDate(rs.getString("date"));
                bill.setDate_hen(rs.getString("date_hen"));
                bills.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bills;
    }
    
    public List<Bill> searchBillFromDate(String searchKeyWord){
        List<Bill> bills = new ArrayList<Bill>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.Bill where date LIKE ?";    
        
        StringBuffer stringBufferTile = new StringBuffer();
        stringBufferTile.append("%");
        stringBufferTile.append(searchKeyWord);
        stringBufferTile.append("%");
        String searchKeyWordLike = stringBufferTile.toString();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, searchKeyWordLike);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Bill bill = new Bill();
                bill.setBill_id(rs.getInt("bill_id"));
                bill.setReader_id(rs.getInt("reader_id"));
                bill.setUser_id(rs.getInt("user_id"));
                bill.setDeposit(rs.getString("deposit"));
                bill.setDate(rs.getString("date"));
                bill.setDate_hen(rs.getString("date_hen"));
                bills.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bills;
    }
    
    public JTable StatisUserByDate(){
        
        JTable table = new JTable();
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT date, COUNT(date) FROM dbo.Bill GROUP BY date";    
       
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return table;
    }
    
    public int getCountBookByDate(String date){
         
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.Bill INNER JOIN dbo.bill_detail ON dbo.Bill.bill_id = dbo.bill_detail.bill_id where date = ? ORDER BY date desc";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, date);
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
}
