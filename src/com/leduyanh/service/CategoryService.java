
package com.leduyanh.service;

import com.leduyanh.dao.CategoryDao;
import com.leduyanh.model.Category;
import java.util.List;

public class CategoryService {
    
    private CategoryDao catetgoryDao;

    public CategoryService() {
        catetgoryDao = new CategoryDao();
    }
    
    public List<Category> getAllCategory(){
        return catetgoryDao.getAllCategory();
    }
    
    public int getCategoryIdByValue(String value){
        return catetgoryDao.getCategoryIdByValue(value);
    }
    
    public String getCategoryById(int category_id){
        return catetgoryDao.getCategoryById(category_id);
    }
}
