
package com.leduyanh.service;

import com.leduyanh.dao.BillDao;
import com.leduyanh.model.Bill;
import java.util.List;

public class BillService {
    private BillDao billDao;

    public BillService() {
        billDao = new BillDao();
    }
    
    public List<Bill> getAllBill(){
        return billDao.getAllBill();
    }
    
    public void addBill(Bill bill){
        billDao.addBill(bill);
    }
    
    public int getBillIdNew(){
        return billDao.getBillIdNew();
    }
    
    public Bill getBillById(int bill_id){
        return billDao.getBillById(bill_id);
    }
    
    public List<Bill> searchBillFromReader(String searchKeyWord){
        return billDao.searchBillFromReader(searchKeyWord);
    }
    
    public List<Bill> searchBillFromUser(String searchKeyWord){
        return billDao.searchBillFromUser(searchKeyWord);
    }
    
    public List<Bill> searchBillFromDate(String searchKeyWord){
        return billDao.searchBillFromDate(searchKeyWord);
    }
}
