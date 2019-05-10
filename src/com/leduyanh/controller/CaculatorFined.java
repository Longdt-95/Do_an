
package com.leduyanh.controller;

import java.util.StringTokenizer;

public class CaculatorFined {
    
    public int Caulator(String ngayHen){
        int arrNgayHen[];
        int arrNgayTra[];
        int countDate=0;
        arrNgayHen = new int[3];
        arrNgayTra = new int[3];
        
        long millis=System.currentTimeMillis();  
        java.sql.Date date = new java.sql.Date(millis); 
        
        StringTokenizer tokenHen = new StringTokenizer(ngayHen,"/");
        
        int i = 0;
        while(tokenHen.hasMoreTokens()){
        	arrNgayHen[i] = Integer.valueOf(tokenHen.nextToken());
                i++;
        }
        
        String ngayTra = date.toString();
        StringTokenizer tokenTra = new StringTokenizer(ngayTra,"-");
        int j = 0;
        while(tokenTra.hasMoreTokens()){
        	arrNgayTra[j] = Integer.valueOf(tokenTra.nextToken());
                j++;
        }
        
        countDate = (arrNgayTra[0] - arrNgayHen[2])*365 + (arrNgayTra[1] - arrNgayHen[1])*30 + arrNgayTra[2] - arrNgayHen[0];
        
        countDate *= 5000;
        
        if(countDate < 0){
            return 0;
        }
        return countDate;
        
    }
}
