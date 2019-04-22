
package com.leduyanh.view.user;

import com.leduyanh.controller.ExportFileExcel;
import com.leduyanh.model.User;
import com.leduyanh.service.UserService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UserJPanel extends javax.swing.JPanel {

    UserService userService;
    DefaultTableModel defaultTableModel;
    ExportFileExcel exportFileExel;
    
    public UserJPanel() {
        initComponents();
        userService = new UserService();
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép người dùng sửa dữ liệu
            }        
        };
        
        typeSearchJCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo tên", "Theo tài khoản"}));
        
        userTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("Mã nv");
        defaultTableModel.addColumn("Họ và tên");
        defaultTableModel.addColumn("Tài khoản");
        defaultTableModel.addColumn("Số điện thoại");
        defaultTableModel.addColumn("Chức vụ");
        defaultTableModel.addColumn("Tình trạng");
        
        List<User> users = userService.getAllUser();
        
        String chucVu;
        String tinhTrang;
        for(User user : users){
            if(user.getLeve() == 1){
                chucVu = "Quản trị viên";
            }
            else{
                chucVu = "Nhân viên";
            }
            if(user.getFlag() == 0){
                tinhTrang = "Bị khóa!";
            }
            else{
                tinhTrang = "Hoạt động";
            }
            defaultTableModel.addRow(new Object[]{user.getUser_id(),user.getName(),user.getUsername(),user.getPhone(),chucVu,tinhTrang});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        typeSearchJCombobox = new javax.swing.JComboBox<>();
        searchJTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        exportButtom = new javax.swing.JButton();
        exportFileTextField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        blockButton = new javax.swing.JButton();
        refeshButton = new javax.swing.JButton();
        addUserbutton = new javax.swing.JButton();
        unlockButton = new javax.swing.JButton();

        userTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã nv", "Họ và tên", "Tài khoản", "Số điện thoại", "Chức vụ", "Tình trạng"
            }
        ));
        jScrollPane1.setViewportView(userTable);

        typeSearchJCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        searchJTextField.setText("Nhập từ khóa tìm kiếm.");
        searchJTextField.setToolTipText("");

        searchButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        searchButton.setText("Tìm Kiếm");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(typeSearchJCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(exportFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(exportButtom)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchJTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(typeSearchJCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exportButtom, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(exportFileTextField))
                .addContainerGap())
        );

        blockButton.setBackground(new java.awt.Color(255, 51, 51));
        blockButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        blockButton.setForeground(new java.awt.Color(255, 255, 255));
        blockButton.setText("Block");
        blockButton.setBorderPainted(false);
        blockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blockButtonActionPerformed(evt);
            }
        });

        refeshButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        refeshButton.setText("Refesh");
        refeshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refeshButtonActionPerformed(evt);
            }
        });

        addUserbutton.setBackground(new java.awt.Color(0, 153, 0));
        addUserbutton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        addUserbutton.setForeground(new java.awt.Color(255, 255, 255));
        addUserbutton.setText("Thêm Nhân viên");
        addUserbutton.setBorderPainted(false);
        addUserbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserbuttonActionPerformed(evt);
            }
        });

        unlockButton.setBackground(new java.awt.Color(0, 153, 0));
        unlockButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        unlockButton.setForeground(new java.awt.Color(255, 255, 255));
        unlockButton.setText("Unlock");
        unlockButton.setBorderPainted(false);
        unlockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unlockButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(blockButton)
                .addGap(18, 18, 18)
                .addComponent(unlockButton)
                .addGap(18, 18, 18)
                .addComponent(refeshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addUserbutton)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addUserbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refeshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(blockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unlockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 758, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 762, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

        String searchKeyWord;
        searchKeyWord = searchJTextField.getText();
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép người dùng sửa dữ liệu
            }
        };
        userTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("Mã nv");
        defaultTableModel.addColumn("Họ và tên");
        defaultTableModel.addColumn("Tài khoản");
        defaultTableModel.addColumn("Số điện thoại");
        defaultTableModel.addColumn("Chức vụ");
        defaultTableModel.addColumn("Tình trạng");

        String typeSearch = String.valueOf(typeSearchJCombobox.getSelectedItem());
        
        List<User> users;
        if(typeSearch.equals("Theo tên")){
            users = userService.searchUserFromName(searchKeyWord);
        }

       else{
            users = userService.searchUserFromUsername(searchKeyWord);
        }

        String chucVu;
        String tinhTrang;
        for(User user : users){
            if(user.getLeve() == 1){
                chucVu = "Quản trị viên";
            }
            else{
                chucVu = "Nhân viên";
            }
            if(user.getFlag() == 0){
                tinhTrang = "Bị khóa!";
            }
            else{
                tinhTrang = "Hoạt động";
            }
            defaultTableModel.addRow(new Object[]{user.getUser_id(),user.getName(),user.getUsername(),user.getPhone(),chucVu,tinhTrang});
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void exportButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtomActionPerformed
        exportFileExel = new ExportFileExcel();
        StringBuffer path = new StringBuffer();
        path.append("C:\\Users\\Admin\\Desktop\\");
        path.append(exportFileTextField.getText());
        path.append(".xlsx");
        String path2 = path.toString();
        
        try {
            exportFileExel.writeToExcell(userTable,path2);
            JOptionPane.showMessageDialog(null, "Lưu file thành công!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Lưu file không thành công!");
            Logger.getLogger(UserJPanel.class.getName()).log(Level.SEVERE, null, ex);
            
        }      
    }//GEN-LAST:event_exportButtomActionPerformed

    private void refeshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refeshButtonActionPerformed
        defaultTableModel.setRowCount(0);
        List<User> users = userService.getAllUser();
        
        String chucVu;
        String tinhTrang;
        for(User user : users){
            if(user.getLeve() == 1){
                chucVu = "Quản trị viên";
            }
            else{
                chucVu = "Nhân viên";
            }
            if(user.getFlag() == 0){
                tinhTrang = "Bị khóa!";
            }
            else{
                tinhTrang = "Hoạt động";
            }
            defaultTableModel.addRow(new Object[]{user.getUser_id(),user.getName(),user.getUsername(),user.getPhone(),chucVu,tinhTrang});
        }
    }//GEN-LAST:event_refeshButtonActionPerformed

    private void addUserbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserbuttonActionPerformed
        new AddUserJFrame().setVisible(true);
    }//GEN-LAST:event_addUserbuttonActionPerformed

    private void blockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blockButtonActionPerformed
        int row = userTable.getSelectedRow();
        int userId = Integer.valueOf(String.valueOf(userTable.getValueAt(row, 0)));
        userService.blockUser(userId);
        JOptionPane.showMessageDialog(null, "Đã khóa tài khoản!");
    }//GEN-LAST:event_blockButtonActionPerformed

    private void unlockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unlockButtonActionPerformed
        int row = userTable.getSelectedRow();
        int userId = Integer.valueOf(String.valueOf(userTable.getValueAt(row, 0)));
        userService.unlockUser(userId);
        JOptionPane.showMessageDialog(null, "Đã mở khóa tài khoản!");
    }//GEN-LAST:event_unlockButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUserbutton;
    private javax.swing.JButton blockButton;
    private javax.swing.JButton exportButtom;
    private javax.swing.JTextField exportFileTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refeshButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchJTextField;
    private javax.swing.JComboBox<String> typeSearchJCombobox;
    private javax.swing.JButton unlockButton;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}
