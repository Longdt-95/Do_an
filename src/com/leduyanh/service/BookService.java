/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leduyanh.service;

import com.leduyanh.dao.BookDao;
import com.leduyanh.model.Book;
import java.util.List;

/**
 *
 * @author Admin
 */
public class BookService {
    private BookDao bookDao;

    public BookService() {
        bookDao = new BookDao();
    }
    
    public List<Book> getAllBook(){
        return bookDao.getAllBook();
    }
    
    public void addBook(Book book){
        bookDao.addBook(book);
    }
    
    public Book getBookById(int book_id){
        return bookDao.getBookById(book_id);
    }
    
    public void updateBook(Book book){
        bookDao.updateBook(book);
    }
    
    public List<Book> searchBookFromTitle(String title){
        return bookDao.searchBookFromTitle(title);
    }
    
    public List<Book> searchBookFromAuthor(String author){
        return bookDao.searchBookFromAuthor(author);
    }
    
    public List<Book> searchBookFromCategory(String category){
        return bookDao.searchBookFromCategory(category);
    }
    public void deleteBook(int book_id){
        bookDao.deleteBook(book_id);
    }
}
