
package com.leduyanh.controller;

import java.util.StringTokenizer;

public class XuLyNgayThang {
    public String takeMonth(String date){
        StringBuffer dateAfter = new StringBuffer();
        StringTokenizer token = new StringTokenizer(date,"/");
        token.nextToken();
        dateAfter.append(token.nextToken());
        dateAfter.append("/");
        dateAfter.append(token.nextToken());
        return dateAfter.toString();
    }
    
    public String takeYear(String date){
        StringBuffer dateAfter = new StringBuffer();
        StringTokenizer token = new StringTokenizer(date,"/");
        token.nextToken();
        token.nextToken();
        dateAfter.append(token.nextToken());
        return dateAfter.toString();
    }
    
}
