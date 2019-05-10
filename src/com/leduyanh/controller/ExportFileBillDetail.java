
package com.leduyanh.controller;

import com.leduyanh.model.Bill;
import com.leduyanh.service.ReaderService;
import com.leduyanh.service.UserService;
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

public class ExportFileBillDetail {
    public void ExportFileWord(JTable table,String fileName,Bill billModel,String fined) {
        
        ReaderService readerService = new ReaderService();
        UserService userService = new UserService();
        
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
            run4.setText("\n\nPHIẾU MƯỢN TRẢ  \n\n");
            run4.setFontSize(12);
            run4.setFontFamily("Times New Roman");
            run4.setBold(true);
            
            XWPFParagraph khoangTrang2 = document.createParagraph();
            XWPFRun run5 = ngayThang.createRun();
            run5.setText("");
            
            XWPFParagraph maMuonTra = document.createParagraph();
            XWPFRun run8 = maMuonTra.createRun();
            //tenBieuMau.setAlignment(ParagraphAlignment.CENTER);
            run8.setText("Mã mượn trả: "+billModel.getBill_id());
            run8.setFontSize(12);
            run8.setFontFamily("Times New Roman");
            
            XWPFParagraph maDocGia = document.createParagraph();
            XWPFRun run9 = maDocGia.createRun();
            run9.setText("Mã độc giả: "+billModel.getReader_id()+" - "+readerService.getReaderById(billModel.getReader_id()).getName());
            run9.setFontSize(12);
            run9.setFontFamily("Times New Roman");
            
            XWPFParagraph maNhanVien = document.createParagraph();
            XWPFRun run10 = maNhanVien.createRun();
            run10.setText("Mã nhân viên: "+billModel.getUser_id()+" - "+userService.getUserById(billModel.getUser_id()).getName());
            run10.setFontSize(12);
            run10.setFontFamily("Times New Roman");
            
            XWPFParagraph ngayMuon = document.createParagraph();
            XWPFRun run11 = ngayMuon.createRun();
            run11.setText("Ngày mượn: "+billModel.getDate());
            run11.setFontSize(12);
            run11.setFontFamily("Times New Roman");
            
            XWPFParagraph ngayhenTra = document.createParagraph();
            XWPFRun run12 = ngayhenTra.createRun();
            run12.setText("Ngày hẹn trả: "+billModel.getDate_hen());
            run12.setFontSize(12);
            run12.setFontFamily("Times New Roman");
            
            XWPFParagraph tienCoc = document.createParagraph();
            XWPFRun run13 = tienCoc.createRun();
            run13.setText("Tiền đặt cọc: "+billModel.getDeposit()+" VNĐ");
            run13.setFontSize(12);
            run13.setFontFamily("Times New Roman");
            
            XWPFParagraph tienPhat = document.createParagraph();
            XWPFRun run14 = tienPhat.createRun();
            run14.setText("Tiền phạt: "+fined);
            run14.setFontSize(12);
            run14.setFontFamily("Times New Roman");
            
            XWPFParagraph khoangTrang4 = document.createParagraph();
            XWPFRun run15 = khoangTrang4.createRun();
            run15.setText("");
            
            XWPFTable createTable = document.createTable();
            createTable.setTableAlignment(TableRowAlign.CENTER);
            createTable.getCellMarginLeft();
            //create first row
            XWPFTableRow tableRowOne = createTable.getRow(0);
            tableRowOne.getCell(0).setText(" STT ");
            tableRowOne.addNewTableCell().setText(" MÃ SÁCH ");
            tableRowOne.addNewTableCell().setText(" TÊN SÁCH ");
            tableRowOne.addNewTableCell().setText(" TÊN TÁC GIẢ ");
            tableRowOne.addNewTableCell().setText(" THỂ LOẠI ");
            tableRowOne.addNewTableCell().setText(" NGÀY TRẢ");
            tableRowOne.addNewTableCell().setText(" TIỀN PHẠT");

            TableModel model = table.getModel();
            
    
            for(int rows = 0; rows < model.getRowCount(); rows++){ //For each table row
                XWPFTableRow tableRowTwo = createTable.createRow();
                //tableRowTwo.getCell(0).setText(String.valueOf(stt));
                for(int cols = 0; cols < table.getColumnCount(); cols++){ //For each table column
                    tableRowTwo.getCell(cols).setText(" "+model.getValueAt(rows, cols).toString());
                } 
                //stt++;
            }
            
            XWPFParagraph khoangTrang3 = document.createParagraph();
            XWPFRun run6 = khoangTrang3.createRun();
            run6.setText("");
            
            XWPFParagraph chuKy = document.createParagraph();
            XWPFRun run7 = chuKy.createRun();
            run7.setText("Người lập														                                Xác nhận của thủ thư");
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
