package com.leduyanh.view.reader;

import com.leduyanh.controller.ExportFileBookStatis;
import com.leduyanh.controller.ExportFileExcel;
import com.leduyanh.controller.ExportFileReader;
import com.leduyanh.model.Category;
import com.leduyanh.service.CategoryService;
import com.leduyanh.service.ReaderService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StatisticalJFrame extends javax.swing.JFrame {

    DefaultTableModel defaultTableModel;
    CategoryService categoryService;
    ExportFileExcel exportFileExel;
    ReaderService readerService;

    public StatisticalJFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        categoryService = new CategoryService();
        readerService = new ReaderService();

        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép người dùng sửa dữ liệu
            }
        };
        statiJTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("STT");
        defaultTableModel.addColumn("Họ Và Tên");
        defaultTableModel.addColumn("Số Lượng");

        JTable table = new JTable();
        String[][] arrStatis = new String[table.getRowCount()][table.getColumnCount()];
        table = readerService.StatisReaderByName();

        for (int row = 0; row < table.getRowCount(); row++) {
            defaultTableModel.addRow(new Object[]{row+1, table.getValueAt(row, 0),table.getValueAt(row,1)});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        categoryButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        authorButton = new javax.swing.JButton();
        bookButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        statiJTable = new javax.swing.JTable();
        exportFileButton = new javax.swing.JButton();
        filenameTextField = new javax.swing.JTextField();
        typeStatis = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        categoryButton.setBackground(new java.awt.Color(0, 153, 0));
        categoryButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        categoryButton.setForeground(new java.awt.Color(255, 255, 255));
        categoryButton.setText("Theo Địa Chỉ");
        categoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryButtonActionPerformed(evt);
            }
        });

        backButton.setBackground(new java.awt.Color(153, 51, 0));
        backButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("Quay Lại");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 51, 255));
        jLabel8.setText("Lê Duy Anh - 20160089");

        authorButton.setBackground(new java.awt.Color(0, 153, 0));
        authorButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        authorButton.setForeground(new java.awt.Color(255, 255, 255));
        authorButton.setText("Theo Tên");
        authorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorButtonActionPerformed(evt);
            }
        });

        bookButton.setBackground(new java.awt.Color(0, 153, 0));
        bookButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bookButton.setForeground(new java.awt.Color(255, 255, 255));
        bookButton.setText("Theo Sách");
        bookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bookButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(authorButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(categoryButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(authorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        statiJTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(statiJTable);

        exportFileButton.setBackground(new java.awt.Color(153, 51, 0));
        exportFileButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        exportFileButton.setForeground(new java.awt.Color(255, 255, 255));
        exportFileButton.setText("Xuất File");
        exportFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportFileButtonActionPerformed(evt);
            }
        });

        filenameTextField.setText("Tên File");

        typeStatis.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        typeStatis.setText("Theo Tên");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(typeStatis, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filenameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(exportFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exportFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(typeStatis)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(filenameTextField))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void categoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryButtonActionPerformed
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép người dùng sửa dữ liệu
            }
        };
        statiJTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("STT");
        defaultTableModel.addColumn("Địa chỉ");
        defaultTableModel.addColumn("Số Lượng");

        JTable table = new JTable();
        String[][] arrStatis = new String[table.getRowCount()][table.getColumnCount()];
        table = readerService.StatisReaderByAddress();

        for (int row = 0; row < table.getRowCount(); row++) {
            defaultTableModel.addRow(new Object[]{row+1, table.getValueAt(row, 0),table.getValueAt(row,1)});
        }
        typeStatis.setText("Theo Địa Chỉ");
    }//GEN-LAST:event_categoryButtonActionPerformed

    private void authorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorButtonActionPerformed
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép người dùng sửa dữ liệu
            }
        };
        statiJTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("STT");
        defaultTableModel.addColumn("Họ Và Tên");
        defaultTableModel.addColumn("Số Lượng");

        JTable table = new JTable();
        String[][] arrStatis = new String[table.getRowCount()][table.getColumnCount()];
        table = readerService.StatisReaderByName();

        for (int row = 0; row < table.getRowCount(); row++) {
            defaultTableModel.addRow(new Object[]{row+1, table.getValueAt(row, 0),table.getValueAt(row,1)});
        }
        typeStatis.setText("Theo Tên");
    }//GEN-LAST:event_authorButtonActionPerformed

    private void exportFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportFileButtonActionPerformed
        ExportFileReader export = new ExportFileReader();
        StringBuffer path = new StringBuffer();
        path.append("C:\\Users\\Admin\\Desktop\\");
        path.append(filenameTextField.getText());
        path.append(".docx");
        String path2 = path.toString();
        if(typeStatis.getText().equals("Theo Tên")){
            export.ExportFileWordByName(statiJTable,path2);
        }
        else if(typeStatis.getText().equals("Theo Địa Chỉ")){
            export.ExportFileWordByAddress(statiJTable,path2);
        }
        else{
            export.ExportFileWordByBook(statiJTable,path2);
        }
        
        JOptionPane.showMessageDialog(null, "Lưu file thành công!");
    }//GEN-LAST:event_exportFileButtonActionPerformed

    private void bookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookButtonActionPerformed
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép người dùng sửa dữ liệu
            }
        };
        statiJTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("STT");
        defaultTableModel.addColumn("Mã Độc Giả");
        defaultTableModel.addColumn("Họ Và Tên");
        defaultTableModel.addColumn("Số Lượng Sách Mượn");

        JTable table = new JTable();
        String[][] arrStatis = new String[table.getRowCount()][table.getColumnCount()];
        table = readerService.StatisReaderByBook();

        for (int row = 0; row < table.getRowCount(); row++) {
            int readerId = Integer.valueOf(String.valueOf(table.getValueAt(row, 0)));
            defaultTableModel.addRow(new Object[]{row+1, table.getValueAt(row, 0),readerService.getReaderById(readerId).getName(),table.getValueAt(row,1)});
        }
        typeStatis.setText("Số Lượng Sách Mượn");
    }//GEN-LAST:event_bookButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton authorButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton bookButton;
    private javax.swing.JButton categoryButton;
    private javax.swing.JButton exportFileButton;
    private javax.swing.JTextField filenameTextField;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable statiJTable;
    private javax.swing.JLabel typeStatis;
    // End of variables declaration//GEN-END:variables
}
