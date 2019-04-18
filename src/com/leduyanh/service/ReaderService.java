
package com.leduyanh.service;

import com.leduyanh.dao.ReaderDao;
import com.leduyanh.model.Reader;
import com.leduyanh.model.User;

public class ReaderService {
    private ReaderDao readerDao;

    public ReaderService() {
        readerDao = new ReaderDao();
    }
    
    public Reader getReaderById(int reader_id){
        return readerDao.getReaderById(reader_id);
    }
}
