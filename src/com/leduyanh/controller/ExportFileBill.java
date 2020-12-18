
package com.leduyanh.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TableRowAlign;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class ExportFileBill {
    public void ExportFileWord(JTable table,String fileName) {
        
        try {

            //Bước 1: Khởi tạo đối tượng để sinh ra file word
            XWPFDocument document = new XWPFDocument();

            //Bước 2: Tạo tiêu đề bài viết
            XWPFParagraph titleGraph = document.createParagraph();
            
            //titleGraph.setAlignment(ParagraphAlignment.CENTER);
            
            String quocHieu = "THƯ VIỆN TẠ QUANG BỬU      		          CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM";
            
            XWPFRun titleRun = titleGraph.createRun();
            
            titleRun.setBold(true);
            
            titleRun.setText(quocHieu);
            titleRun.setFontSize(12);
            titleRun.setFontFamily("Times New Roman");

            
            XWPFParagraph paragraph1 = document.createParagraph();
            XWPFRun run = paragraph1.createRun();
            run.setText("              LÊ DUY ANH				     Độc lập - Tự do – Hạnh phúc");
            run.setFontSize(12);
            run.setBold(true);
            run.setFontFamily("Times New Roman");
            
            XWPFParagraph ngayThang = document.createParagraph();
            XWPFRun run2 = ngayThang.createRun();
            ngayThang.setAlignment(ParagraphAlignment.RIGHT);
            run2.setText("Ngày 16 tháng 5 năm 2019       ");
            run2.setFontSize(12);
            run2.setItalic(true);
            run2.setFontFamily("Times New Roman");
            
            XWPFParagraph khoangTrang = document.createParagraph();
            XWPFRun run3 = ngayThang.createRun();
            run3.setText("");

            XWPFParagraph tenBieuMau = document.createParagraph();
            XWPFRun run4 = tenBieuMau.createRun();
            tenBieuMau.setAlignment(ParagraphAlignment.CENTER);
            run4.setText("\n\nTHỐNG KÊ PHIẾU MƯỢN TRẢ  \n\n");
            run4.setFontSize(12);
            run4.setFontFamily("Times New Roman");
            run4.setBold(true);
            
            XWPFParagraph khoangTrang2 = document.createParagraph();
            XWPFRun run5 = ngayThang.createRun();
            run5.setText("");
            
            XWPFTable createTable = document.createTable();
            createTable.setTableAlignment(TableRowAlign.CENTER);
            createTable.getCellMarginLeft();
            //create first row
            XWPFTableRow tableRowOne = createTable.getRow(0);
            tableRowOne.getCell(0).setText(" STT ");
            tableRowOne.addNewTableCell().setText(" MÃ PHIẾU ");
            tableRowOne.addNewTableCell().setText(" NGƯỜI MƯỢN ");
            tableRowOne.addNewTableCell().setText(" NHÂN VIÊN ");
            tableRowOne.addNewTableCell().setText(" NGÀY MƯỢN ");
            tableRowOne.addNewTableCell().setText(" TIỀN ĐẶT CỌC");

            TableModel model = table.getModel();
            
            int stt=1;
            for(int rows = 0; rows < model.getRowCount(); rows++){ //For each table row
                XWPFTableRow tableRowTwo = createTable.createRow();
                tableRowTwo.getCell(0).setText(" "+String.valueOf(stt));
                for(int cols = 0; cols < table.getColumnCount(); cols++){ //For each table column
                    tableRowTwo.getCell(cols+1).setText(" "+model.getValueAt(rows, cols).toString());
                } 
                stt++;
            }
            
            XWPFParagraph khoangTrang3 = document.createParagraph();
            XWPFRun run6 = khoangTrang3.createRun();
            run6.setText("");
            
            XWPFParagraph chuKy = document.createParagraph();
            XWPFRun run7 = chuKy.createRun();
            run7.setText("Người lập \n														                                Xác nhận của thủ thư");
            run7.setFontSize(12);
            run7.setFontFamily("Times New Roman");
            run7.setBold(true);
            chuKy.setAlignment(ParagraphAlignment.CENTER);
            
            //Ghi dữ liệu ra file word
            FileOutputStream out = new FileOutputStream(fileName);
            
            document.write(out);
            
            out.close();
            
            document.close();
            
        } catch (IOException ex) {
            
            Logger.getLogger(ExportFileBook.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
    public void ExportFileBillByDate(JTable table,String fileName) {
        
        try {

            //Bước 1: Khởi tạo đối tượng để sinh ra file word
            XWPFDocument document = new XWPFDocument();

            //Bước 2: Tạo tiêu đề bài viết
            XWPFParagraph titleGraph = document.createParagraph();
            
            //titleGraph.setAlignment(ParagraphAlignment.CENTER);
            
            String quocHieu = "THƯ VIỆN TẠ QUANG BỬU      		          CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM";
            
            XWPFRun titleRun = titleGraph.createRun();
            
            titleRun.setBold(true);
            
            titleRun.setText(quocHieu);
            titleRun.setFontSize(12);
            titleRun.setFontFamily("Times New Roman");

            
            XWPFParagraph paragraph1 = document.createParagraph();
            XWPFRun run = paragraph1.createRun();
            run.setText("              LÊ DUY ANH				     Độc lập - Tự do – Hạnh phúc");
            run.setFontSize(12);
            run.setBold(true);
            run.setFontFamily("Times New Roman");
            
            XWPFParagraph ngayThang = document.createParagraph();
            XWPFRun run2 = ngayThang.createRun();
            ngayThang.setAlignment(ParagraphAlignment.RIGHT);
            run2.setText("Ngày 16 tháng 5 năm 2019       ");
            run2.setFontSize(12);
            run2.setItalic(true);
            run2.setFontFamily("Times New Roman");
            
            XWPFParagraph khoangTrang = document.createParagraph();
            XWPFRun run3 = ngayThang.createRun();
            run3.setText("");

            XWPFParagraph tenBieuMau = document.createParagraph();
            XWPFRun run4 = tenBieuMau.createRun();
            tenBieuMau.setAlignment(ParagraphAlignment.CENTER);
            run4.setText("\n\nTHỐNG KÊ PHIẾU THEO NGÀY \n\n");
            run4.setFontSize(12);
            run4.setFontFamily("Times New Roman");
            run4.setBold(true);
            
            XWPFParagraph khoangTrang2 = document.createParagraph();
            XWPFRun run5 = ngayThang.createRun();
            run5.setText("");
            
            XWPFTable createTable = document.createTable();
            createTable.setTableAlignment(TableRowAlign.CENTER);
            createTable.getCellMarginLeft();
            //create first row
            XWPFTableRow tableRowOne = createTable.getRow(0);

            tableRowOne.addNewTableCell().setText(" STT ");
            tableRowOne.addNewTableCell().setText(" NGÀY ");
            tableRowOne.addNewTableCell().setText(" TỔNG SỐ PHIẾU ");
            tableRowOne.addNewTableCell().setText(" TỔNG SỐ SÁCH CHO MƯỢN ");

            TableModel model = table.getModel();
            

            for(int rows = 0; rows < model.getRowCount(); rows++){ //For each table row
                XWPFTableRow tableRowTwo = createTable.createRow();
                for(int cols = 0; cols < table.getColumnCount(); cols++){ //For each table column
                    tableRowTwo.getCell(cols+1).setText(" "+model.getValueAt(rows, cols).toString());
                } 
            }
            
            XWPFParagraph khoangTrang3 = document.createParagraph();
            XWPFRun run6 = khoangTrang3.createRun();
            run6.setText("");
            
            XWPFParagraph chuKy = document.createParagraph();
            XWPFRun run7 = chuKy.createRun();
            run7.setText("Người lập \n														                                Xác nhận của thủ thư");
            run7.setFontSize(12);
            run7.setFontFamily("Times New Roman");
            run7.setBold(true);
            chuKy.setAlignment(ParagraphAlignment.CENTER);
            
            //Ghi dữ liệu ra file word
            FileOutputStream out = new FileOutputStream(fileName);
            
            document.write(out);
            
            out.close();
            
            document.close();
            
        } catch (IOException ex) {
            
            Logger.getLogger(ExportFileBook.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
    public void ExportFileBillByMonth(JTable table,String fileName) {
        
        try {

            //Bước 1: Khởi tạo đối tượng để sinh ra file word
            XWPFDocument document = new XWPFDocument();

            //Bước 2: Tạo tiêu đề bài viết
            XWPFParagraph titleGraph = document.createParagraph();
            
            //titleGraph.setAlignment(ParagraphAlignment.CENTER);
            
            String quocHieu = "THƯ VIỆN TẠ QUANG BỬU      		          CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM";
            
            XWPFRun titleRun = titleGraph.createRun();
            
            titleRun.setBold(true);
            
            titleRun.setText(quocHieu);
            titleRun.setFontSize(12);
            titleRun.setFontFamily("Times New Roman");

            
            XWPFParagraph paragraph1 = document.createParagraph();
            XWPFRun run = paragraph1.createRun();
            run.setText("              LÊ DUY ANH				     Độc lập - Tự do – Hạnh phúc");
            run.setFontSize(12);
            run.setBold(true);
            run.setFontFamily("Times New Roman");
            
            XWPFParagraph ngayThang = document.createParagraph();
            XWPFRun run2 = ngayThang.createRun();
            ngayThang.setAlignment(ParagraphAlignment.RIGHT);
            run2.setText("Ngày 16 tháng 5 năm 2019       ");
            run2.setFontSize(12);
            run2.setItalic(true);
            run2.setFontFamily("Times New Roman");
            
            XWPFParagraph khoangTrang = document.createParagraph();
            XWPFRun run3 = ngayThang.createRun();
            run3.setText("");

            XWPFParagraph tenBieuMau = document.createParagraph();
            XWPFRun run4 = tenBieuMau.createRun();
            tenBieuMau.setAlignment(ParagraphAlignment.CENTER);
            run4.setText("\n\nTHỐNG KÊ PHIẾU THEO THÁNG \n\n");
            run4.setFontSize(12);
            run4.setFontFamily("Times New Roman");
            run4.setBold(true);
            
            XWPFParagraph khoangTrang2 = document.createParagraph();
            XWPFRun run5 = ngayThang.createRun();
            run5.setText("");
            
            XWPFTable createTable = document.createTable();
            createTable.setTableAlignment(TableRowAlign.CENTER);
            createTable.getCellMarginLeft();
            //create first row
            XWPFTableRow tableRowOne = createTable.getRow(0);

            tableRowOne.addNewTableCell().setText(" STT ");
            tableRowOne.addNewTableCell().setText(" THÁNG ");
            tableRowOne.addNewTableCell().setText(" TỔNG SỐ PHIẾU ");
            tableRowOne.addNewTableCell().setText(" TỔNG SỐ SÁCH CHO MƯỢN ");

            TableModel model = table.getModel();
            

            for(int rows = 0; rows < model.getRowCount(); rows++){ //For each table row
                XWPFTableRow tableRowTwo = createTable.createRow();
                for(int cols = 0; cols < table.getColumnCount(); cols++){ //For each table column
                    tableRowTwo.getCell(cols+1).setText(" "+model.getValueAt(rows, cols).toString());
                } 
            }
            
            XWPFParagraph khoangTrang3 = document.createParagraph();
            XWPFRun run6 = khoangTrang3.createRun();
            run6.setText("");
            
            XWPFParagraph chuKy = document.createParagraph();
            XWPFRun run7 = chuKy.createRun();
            run7.setText("Người lập \n														                                Xác nhận của thủ thư");
            run7.setFontSize(12);
            run7.setFontFamily("Times New Roman");
            run7.setBold(true);
            chuKy.setAlignment(ParagraphAlignment.CENTER);
            
            //Ghi dữ liệu ra file word
            FileOutputStream out = new FileOutputStream(fileName);
            
            document.write(out);
            
            out.close();
            
            document.close();
            
        } catch (IOException ex) { 
            Logger.getLogger(ExportFileBook.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    
    public void ExportFileBillByYear(JTable table,String fileName) {
        
        try {

            //Bước 1: Khởi tạo đối tượng để sinh ra file word
            XWPFDocument document = new XWPFDocument();

            //Bước 2: Tạo tiêu đề bài viết
            XWPFParagraph titleGraph = document.createParagraph();
            
            //titleGraph.setAlignment(ParagraphAlignment.CENTER);
            
            String quocHieu = "THƯ VIỆN TẠ QUANG BỬU      		          CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM";
            
            XWPFRun titleRun = titleGraph.createRun();
            
            titleRun.setBold(true);
            
            titleRun.setText(quocHieu);
            titleRun.setFontSize(12);
            titleRun.setFontFamily("Times New Roman");

            
            XWPFParagraph paragraph1 = document.createParagraph();
            XWPFRun run = paragraph1.createRun();
            run.setText("              LÊ DUY ANH				     Độc lập - Tự do – Hạnh phúc");
            run.setFontSize(12);
            run.setBold(true);
            run.setFontFamily("Times New Roman");
            
            XWPFParagraph ngayThang = document.createParagraph();
            XWPFRun run2 = ngayThang.createRun();
            ngayThang.setAlignment(ParagraphAlignment.RIGHT);
            run2.setText("Ngày 16 tháng 5 năm 2019       ");
            run2.setFontSize(12);
            run2.setItalic(true);
            run2.setFontFamily("Times New Roman");
            
            XWPFParagraph khoangTrang = document.createParagraph();
            XWPFRun run3 = ngayThang.createRun();
            run3.setText("");

            XWPFParagraph tenBieuMau = document.createParagraph();
            XWPFRun run4 = tenBieuMau.createRun();
            tenBieuMau.setAlignment(ParagraphAlignment.CENTER);
            run4.setText("\n\nTHỐNG KÊ PHIẾU THEO NĂM \n\n");
            run4.setFontSize(12);
            run4.setFontFamily("Times New Roman");
            run4.setBold(true);
            
            XWPFParagraph khoangTrang2 = document.createParagraph();
            XWPFRun run5 = ngayThang.createRun();
            run5.setText("");
            
            XWPFTable createTable = document.createTable();
            createTable.setTableAlignment(TableRowAlign.CENTER);
            createTable.getCellMarginLeft();
            //create first row
            XWPFTableRow tableRowOne = createTable.getRow(0);

            tableRowOne.addNewTableCell().setText(" STT ");
            tableRowOne.addNewTableCell().setText(" NĂM ");
            tableRowOne.addNewTableCell().setText(" TỔNG SỐ PHIẾU ");
            tableRowOne.addNewTableCell().setText(" TỔNG SỐ SÁCH CHO MƯỢN ");

            TableModel model = table.getModel();
            

            for(int rows = 0; rows < model.getRowCount(); rows++){ //For each table row
                XWPFTableRow tableRowTwo = createTable.createRow();
                for(int cols = 0; cols < table.getColumnCount(); cols++){ //For each table column
                    tableRowTwo.getCell(cols+1).setText(" "+model.getValueAt(rows, cols).toString());
                } 
            }
            
            XWPFParagraph khoangTrang3 = document.createParagraph();
            XWPFRun run6 = khoangTrang3.createRun();
            run6.setText("");
            
            XWPFParagraph chuKy = document.createParagraph();
            XWPFRun run7 = chuKy.createRun();
            run7.setText("Người lập \n														                                Xác nhận của thủ thư");
            run7.setFontSize(12);
            run7.setFontFamily("Times New Roman");
            run7.setBold(true);
            chuKy.setAlignment(ParagraphAlignment.CENTER);
            
            //Ghi dữ liệu ra file word
            FileOutputStream out = new FileOutputStream(fileName);
            
            document.write(out);
            
            out.close();
            
            document.close();
            
        } catch (IOException ex) {
            
            Logger.getLogger(ExportFileBook.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
}
