
package com.leduyanh.service;

import com.leduyanh.dao.BillDetailDao;
import com.leduyanh.model.BillDetail;
import java.util.List;

public class BillDetailService {
    private BillDetailDao billDetailDao;

    public BillDetailService() {
        billDetailDao = new BillDetailDao();
    }
    
    public void addBook(List<Integer> book_ids, int bill_id){
        billDetailDao.addBook(book_ids, bill_id);
    }
    
    public List<BillDetail> getAllBillDetail(int billId){
        return billDetailDao.getAllBillDetail(billId);
    }
    
}
