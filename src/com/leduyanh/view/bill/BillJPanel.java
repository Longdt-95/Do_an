
package com.leduyanh.view.bill;

import com.leduyanh.controller.ExportFileBill;
import com.leduyanh.controller.ExportFileExcel;
import com.leduyanh.model.Bill;
import com.leduyanh.model.User;
import com.leduyanh.service.BillService;
import com.leduyanh.service.ReaderService;
import com.leduyanh.service.UserService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class BillJPanel extends javax.swing.JPanel {

    DefaultTableModel defaultTableModel;
    private BillService billService;
    private Bill billModel;
    private User userModel;
    private UserService userService;
    private ReaderService readerService;
    private ExportFileExcel exportFileExcel;
    
    public BillJPanel() throws SQLException {
        initComponents();
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép người dùng sửa dữ liệu
            }
        };

        billTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("Mã phiếu");
        defaultTableModel.addColumn("Người mượn");
        defaultTableModel.addColumn("Nhân viên");
        defaultTableModel.addColumn("Ngày mượn");
        defaultTableModel.addColumn("Tiền cọc");
        
        billService = new BillService();
        userService = new UserService();
        readerService = new ReaderService();
        
        List<Bill> bills = billService.getAllBill();
        
        for(Bill bill : bills){
            defaultTableModel.addRow(new Object[]{bill.getBill_id(),readerService.getReaderById(bill.getReader_id()).getName(),userService.getUserById(bill.getUser_id()).getName(),bill.getDate(),bill.getDeposit()});
        }
        
        typeSearchJCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo độc giả", "Theo nhân viên", "Theo ngày"}));
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        billTable = new javax.swing.JTable();
        exportButtom = new javax.swing.JButton();
        exportFileTextField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        addBillJButton = new javax.swing.JButton();
        showBillDetailButton = new javax.swing.JButton();
        refeshButton = new javax.swing.JButton();
        typeSearchJCombobox = new javax.swing.JComboBox<>();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        statisButton = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(683, Short.MAX_VALUE))
        );

        billTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(billTable);

        exportButtom.setBackground(new java.awt.Color(102, 102, 0));
        exportButtom.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        exportButtom.setForeground(new java.awt.Color(255, 255, 255));
        exportButtom.setText("Xuất file");
        exportButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtomActionPerformed(evt);
            }
        });

        exportFileTextField.setText("Tên file");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 472, Short.MAX_VALUE)
                        .addComponent(exportFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exportButtom)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exportButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exportFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(128, 128, 128))
        );

        addBillJButton.setBackground(new java.awt.Color(51, 153, 0));
        addBillJButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        addBillJButton.setForeground(new java.awt.Color(255, 255, 255));
        addBillJButton.setText("Tạo Phiếu Mới");
        addBillJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBillJButtonActionPerformed(evt);
            }
        });

        showBillDetailButton.setBackground(new java.awt.Color(102, 102, 0));
        showBillDetailButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        showBillDetailButton.setForeground(new java.awt.Color(255, 255, 255));
        showBillDetailButton.setText("Chi Tiết");
        showBillDetailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBillDetailButtonActionPerformed(evt);
            }
        });

        refeshButton.setBackground(new java.awt.Color(0, 153, 153));
        refeshButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        refeshButton.setForeground(new java.awt.Color(255, 255, 255));
        refeshButton.setText("Reresh");
        refeshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refeshButtonActionPerformed(evt);
            }
        });

        typeSearchJCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        searchButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        searchButton.setText("Tìm Kiếm");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(153, 0, 0));
        deleteButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Xóa");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        statisButton.setBackground(new java.awt.Color(102, 102, 0));
        statisButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        statisButton.setForeground(new java.awt.Color(255, 255, 255));
        statisButton.setText("Thống Kê");
        statisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statisButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(statisButton)
                        .addGap(18, 18, 18)
                        .addComponent(refeshButton)
                        .addGap(18, 18, 18)
                        .addComponent(deleteButton)
                        .addGap(18, 18, 18)
                        .addComponent(showBillDetailButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(typeSearchJCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchTextField)))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addBillJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBillJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showBillDetailButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refeshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typeSearchJCombobox)
                    .addComponent(searchButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(searchTextField))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addBillJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBillJButtonActionPerformed
        //StringTokenizer readerToken = new StringTokenizer(String.valueOf());
        
       // billModel.setReader_id(Integer.valueOf(readerToken.nextToken()));
        new AddBillJFrame().setVisible(true);
    }//GEN-LAST:event_addBillJButtonActionPerformed

    private void refeshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refeshButtonActionPerformed
        defaultTableModel.setRowCount(0);
        List<Bill> bills = billService.getAllBill();
        
        for(Bill bill : bills){
            try {
                defaultTableModel.addRow(new Object[]{bill.getBill_id(),readerService.getReaderById(bill.getReader_id()).getName(),userService.getUserById(bill.getUser_id()).getName(),bill.getDate(),bill.getDeposit()});
            } catch (SQLException ex) {
                Logger.getLogger(BillJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_refeshButtonActionPerformed

    private void showBillDetailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showBillDetailButtonActionPerformed
        int row = billTable.getSelectedRow();
        if(row == -1){
            //JOptionPane.showMessageDialog(BillJPanel.this, "Vui lòng chọn sách trước!","Lỗi",JOptionPane.ERROR);
        }
        else{
            int billId = Integer.valueOf(String.valueOf(billTable.getValueAt(row, 0)));
            new ShowBillDetailJFrame(billId).setVisible(true);
        }
    }//GEN-LAST:event_showBillDetailButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        String searchKeyWord;
        searchKeyWord = searchTextField.getText();
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép người dùng sửa dữ liệu
            }        
        };
         
        billTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("Mã phiếu");
        defaultTableModel.addColumn("Người mượn");
        defaultTableModel.addColumn("Nhân viên");
        defaultTableModel.addColumn("Ngày mượn");
        defaultTableModel.addColumn("Tiền cọc");
        
        String typeSearch = String.valueOf(typeSearchJCombobox.getSelectedItem());
        List<Bill> bills;
        if(typeSearch.equals("Theo độc giả")){
            bills = billService.searchBillFromReader(searchKeyWord);
        }
        else if(typeSearch.equals("Theo nhân viên")){
            bills = billService.searchBillFromUser(searchKeyWord);
        }
        else{
            bills = billService.searchBillFromDate(searchKeyWord);
        }
            
        for(Bill bill : bills){
            try {
                defaultTableModel.addRow(new Object[]{bill.getBill_id(),readerService.getReaderById(bill.getReader_id()).getName(),userService.getUserById(bill.getUser_id()).getName(),bill.getDate(),bill.getDeposit()});
            } catch (SQLException ex) {
                Logger.getLogger(BillJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void exportButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtomActionPerformed
        ExportFileBill export = new ExportFileBill();
        StringBuffer path = new StringBuffer();
        path.append("C:\\Users\\Admin\\Desktop\\");
        path.append(exportFileTextField.getText());
        path.append(".docx");
        String path2 = path.toString();

        export.ExportFileWord(billTable,path2);
        //exportFileExel.writeToExcell(bookTable,path2);
        JOptionPane.showMessageDialog(null, "Lưu file thành công!");
    }//GEN-LAST:event_exportButtomActionPerformed

    private void statisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statisButtonActionPerformed
        new StatisticalJFrame().setVisible(true);
    }//GEN-LAST:event_statisButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBillJButton;
    private javax.swing.JTable billTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton exportButtom;
    private javax.swing.JTextField exportFileTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refeshButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JButton showBillDetailButton;
    private javax.swing.JButton statisButton;
    private javax.swing.JComboBox<String> typeSearchJCombobox;
    // End of variables declaration//GEN-END:variables
}
