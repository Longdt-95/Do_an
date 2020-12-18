
package com.leduyanh.dao;

import com.leduyanh.model.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BookDao {
    public List<Book> getAllBook(){
        List<Book> books = new ArrayList<Book>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.Book ORDER BY book_id desc";    
       
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Book book = new Book();
                book.setBook_id(rs.getInt("book_id"));
                book.setAmount(rs.getInt("amount"));
                book.setAuthor(rs.getString("author"));
                book.setCategory_id(rs.getInt("category_id"));
                book.setTitle(rs.getString("title"));
                book.setIntroduce(rs.getString("introduce"));
                books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }
    
    public void addBook(Book book){
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "INSERT INTO dbo.Book(title, author, amount, introduce, category_id) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setInt(3, book.getAmount());
            preparedStatement.setString(4, book.getIntroduce());
            preparedStatement.setInt(5, book.getCategory_id());
            int rs = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Book getBookById(int book_id){
         
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.Book WHERE book_id = ?";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, book_id);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Book book = new Book();
                book.setBook_id(rs.getInt("book_id"));
                book.setAmount(rs.getInt("amount"));
                book.setAuthor(rs.getString("author"));
                book.setCategory_id(rs.getInt("category_id"));
                book.setTitle(rs.getString("title"));
                book.setIntroduce(rs.getString("introduce"));
                return book;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void updateBook(Book book){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE dbo.Book SET title=?,author=?,amount=?,introduce=?,category_id=? WHERE book_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setInt(3, book.getAmount());
            preparedStatement.setString(4, book.getIntroduce());
            preparedStatement.setInt(5, book.getCategory_id());
            preparedStatement.setInt(6, book.getBook_id());
            int rs = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Book> searchBookFromTitle(String title){
        List<Book> books = new ArrayList<Book>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.Book where title LIKE ?";    
        
        StringBuffer stringBufferTile = new StringBuffer();
        stringBufferTile.append("%");
        stringBufferTile.append(title);
        stringBufferTile.append("%");
        String titleLike = stringBufferTile.toString();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, titleLike);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Book book = new Book();
                book.setBook_id(rs.getInt("book_id"));
                book.setAmount(rs.getInt("amount"));
                book.setAuthor(rs.getString("author"));
                book.setCategory_id(rs.getInt("category_id"));
                book.setTitle(rs.getString("title"));
                book.setIntroduce(rs.getString("introduce"));
                books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }
    
    public List<Book> searchBookFromAuthor(String author){
        List<Book> books = new ArrayList<Book>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.Book where author LIKE ?";    
        
        StringBuffer stringBufferTile = new StringBuffer();
        stringBufferTile.append("%");
        stringBufferTile.append(author);
        stringBufferTile.append("%");
        String authorLike = stringBufferTile.toString();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, authorLike);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Book book = new Book();
                book.setBook_id(rs.getInt("book_id"));
                book.setAmount(rs.getInt("amount"));
                book.setAuthor(rs.getString("author"));
                book.setCategory_id(rs.getInt("category_id"));
                book.setTitle(rs.getString("title"));
                book.setIntroduce(rs.getString("introduce"));
                books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }
    
    public List<Book> searchBookFromCategory(String category){
        List<Book> books = new ArrayList<Book>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.Book INNER JOIN dbo.Category ON dbo.Book.category_id = dbo.Category.category_id where category_name LIKE ?";    
        
        StringBuffer stringBufferTile = new StringBuffer();
        stringBufferTile.append("%");
        stringBufferTile.append(category);
        stringBufferTile.append("%");
        String categoryLike = stringBufferTile.toString();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, categoryLike);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Book book = new Book();
                book.setBook_id(rs.getInt("book_id"));
                book.setAmount(rs.getInt("amount"));
                book.setAuthor(rs.getString("author"));
                book.setCategory_id(rs.getInt("category_id"));
                book.setTitle(rs.getString("title"));
                book.setIntroduce(rs.getString("introduce"));
                books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }
    
    public void deleteBook(int book_id){
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql2 = "DELETE dbo.bill_detail WHERE book_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setInt(1, book_id);
            ResultSet rs = preparedStatement.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sql1 = "DELETE dbo.Book WHERE book_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setInt(1, book_id);
            ResultSet rs = preparedStatement.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
