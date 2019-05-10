package com.leduyanh.view.bill;

import com.leduyanh.controller.ExportFileBill;
import com.leduyanh.view.book.*;
import com.leduyanh.controller.ExportFileBookStatis;
import com.leduyanh.controller.ExportFileExcel;
import com.leduyanh.controller.XuLyNgayThang;
import com.leduyanh.model.Category;
import com.leduyanh.service.BillService;
import com.leduyanh.service.CategoryService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StatisticalJFrame extends javax.swing.JFrame {

    DefaultTableModel defaultTableModel;
    CategoryService categoryService;
    ExportFileExcel exportFileExel;
    BillService billService;

    public StatisticalJFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        billService = new BillService();

        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép người dùng sửa dữ liệu
            }
        };

        statiJTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("STT");
        defaultTableModel.addColumn("Ngày");
        defaultTableModel.addColumn("Số Phiếu");
        defaultTableModel.addColumn("Tổng số sách cho mượn");

        JTable table = new JTable();
        String[][] arrStatis = new String[table.getRowCount()][table.getColumnCount()];
        table = billService.StatisUserByDate();

        for (int row = 0; row < table.getRowCount(); row++) {
            String date = String.valueOf(table.getValueAt(row, 0));
            defaultTableModel.addRow(new Object[]{row + 1, table.getValueAt(row, 0), table.getValueAt(row, 1), billService.getCountBookByDate(date)});
        }
        typeStatis.setText("Theo Ngày");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        byDateButton = new javax.swing.JButton();
        byyearButton = new javax.swing.JButton();
        bymonthButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        statiJTable = new javax.swing.JTable();
        exportFileButton = new javax.swing.JButton();
        filenameTextField = new javax.swing.JTextField();
        typeStatis = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        byDateButton.setBackground(new java.awt.Color(0, 153, 0));
        byDateButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        byDateButton.setForeground(new java.awt.Color(255, 255, 255));
        byDateButton.setText("Theo Ngày");
        byDateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byDateButtonActionPerformed(evt);
            }
        });

        byyearButton.setBackground(new java.awt.Color(0, 153, 0));
        byyearButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        byyearButton.setForeground(new java.awt.Color(255, 255, 255));
        byyearButton.setText("Theo Năm");
        byyearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byyearButtonActionPerformed(evt);
            }
        });

        bymonthButton.setBackground(new java.awt.Color(0, 153, 0));
        bymonthButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bymonthButton.setForeground(new java.awt.Color(255, 255, 255));
        bymonthButton.setText("Theo Tháng");
        bymonthButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bymonthButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(30, 30, 30)
                .addComponent(byDateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(bymonthButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(byyearButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(byDateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(byyearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bymonthButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        typeStatis.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        typeStatis.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(typeStatis, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void byyearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_byyearButtonActionPerformed
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép người dùng sửa dữ liệu
            }
        };
        statiJTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("STT");
        defaultTableModel.addColumn("Tháng");
        defaultTableModel.addColumn("Số Phiếu");
        defaultTableModel.addColumn("Tổng số sách cho mượn");

        XuLyNgayThang xuLy = new XuLyNgayThang();

        JTable table = new JTable();

        table = billService.StatisUserByDate();

        String[][] arrStatis = new String[table.getRowCount()][3];

        for (int row = 0; row < table.getRowCount(); row++) {
            arrStatis[row][0] = xuLy.takeYear(String.valueOf(table.getValueAt(row, 0)));
            arrStatis[row][1] = String.valueOf(table.getValueAt(row, 1));
            arrStatis[row][2] = String.valueOf(billService.getCountBookByDate(String.valueOf(table.getValueAt(row, 0))));
        }

        int index = 0;
        String[][] arrStatis2 = new String[table.getRowCount()][2];
        arrStatis2[0][0] = arrStatis[0][0];
        arrStatis2[0][1] = arrStatis[0][1];

        int count = 0;
        int count2 = 0;
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = i + 1; j < table.getRowCount(); j++) {
                if (arrStatis[i][0].equals(arrStatis[j][0])) {
                    //System.out.println("ok");
                    count = Integer.valueOf(arrStatis[i][1]);
                    count += Integer.valueOf(arrStatis[j][1]);
                    arrStatis[i][1] = String.valueOf(count);

                    count2 = Integer.valueOf(arrStatis[i][2]);
                    count2 += Integer.valueOf(arrStatis[j][2]);
                    arrStatis[i][2] = String.valueOf(count2);

                    arrStatis[j][0] = "null";
                }
            }

        }
        for (int row = 0; row < table.getRowCount(); row++) {
            if (!arrStatis[row][0].equals("null")) {
                defaultTableModel.addRow(new Object[]{row + 1, arrStatis[row][0], arrStatis[row][1], arrStatis[row][2]});
            }

        }

        typeStatis.setText("Theo Năm");
    }//GEN-LAST:event_byyearButtonActionPerformed

    private void byDateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_byDateButtonActionPerformed
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép người dùng sửa dữ liệu
            }
        };

        statiJTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("STT");
        defaultTableModel.addColumn("Ngày");
        defaultTableModel.addColumn("Số Phiếu");
        defaultTableModel.addColumn("Tổng số sách cho mượn");

        JTable table = new JTable();
        String[][] arrStatis = new String[table.getRowCount()][table.getColumnCount()];
        table = billService.StatisUserByDate();

        for (int row = 0; row < table.getRowCount(); row++) {
            String date = String.valueOf(table.getValueAt(row, 0));
            defaultTableModel.addRow(new Object[]{row + 1, table.getValueAt(row, 0), table.getValueAt(row, 1), billService.getCountBookByDate(date)});
        }
        typeStatis.setText("Theo Ngày");
    }//GEN-LAST:event_byDateButtonActionPerformed

    private void exportFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportFileButtonActionPerformed
        ExportFileBill export = new ExportFileBill();
        StringBuffer path = new StringBuffer();
        path.append("C:\\Users\\Admin\\Desktop\\");
        path.append(filenameTextField.getText());
        path.append(".docx");
        String path2 = path.toString();
        if (typeStatis.getText().equals("Theo Ngày")) {
            export.ExportFileBillByDate(statiJTable, path2);
        } else if (typeStatis.getText().equals("Theo Tháng")) {
            export.ExportFileBillByMonth(statiJTable, path2);
        } else {
            export.ExportFileBillByYear(statiJTable, path2);
        }

        JOptionPane.showMessageDialog(null, "Lưu file thành công!");
    }//GEN-LAST:event_exportFileButtonActionPerformed

    private void bymonthButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bymonthButtonActionPerformed
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép người dùng sửa dữ liệu
            }
        };
        statiJTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("STT");
        defaultTableModel.addColumn("Tháng");
        defaultTableModel.addColumn("Số Phiếu");
        defaultTableModel.addColumn("Tổng số sách cho mượn");

        XuLyNgayThang xuLy = new XuLyNgayThang();

        JTable table = new JTable();

        table = billService.StatisUserByDate();

        String[][] arrStatis = new String[table.getRowCount()][3];

        for (int row = 0; row < table.getRowCount(); row++) {
            arrStatis[row][0] = xuLy.takeMonth(String.valueOf(table.getValueAt(row, 0)));
            arrStatis[row][1] = String.valueOf(table.getValueAt(row, 1));
            arrStatis[row][2] = String.valueOf(billService.getCountBookByDate(String.valueOf(table.getValueAt(row, 0))));
        }

        int index = 0;
        String[][] arrStatis2 = new String[table.getRowCount()][2];
        arrStatis2[0][0] = arrStatis[0][0];
        arrStatis2[0][1] = arrStatis[0][1];

        int count = 0;
        int count2 = 0;
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = i + 1; j < table.getRowCount(); j++) {
                if (arrStatis[i][0].equals(arrStatis[j][0])) {
                    //System.out.println("ok");
                    count = Integer.valueOf(arrStatis[i][1]);
                    count += Integer.valueOf(arrStatis[j][1]);
                    arrStatis[i][1] = String.valueOf(count);

                    count2 = Integer.valueOf(arrStatis[i][2]);
                    count2 += Integer.valueOf(arrStatis[j][2]);
                    arrStatis[i][2] = String.valueOf(count2);

                    arrStatis[j][0] = "null";
                }
            }

        }
        for (int row = 0; row < table.getRowCount(); row++) {
            if (!arrStatis[row][0].equals("null")) {
                defaultTableModel.addRow(new Object[]{row + 1, arrStatis[row][0], arrStatis[row][1], arrStatis[row][2]});
            }

        }
        typeStatis.setText("Theo Tháng");
    }//GEN-LAST:event_bymonthButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton byDateButton;
    private javax.swing.JButton bymonthButton;
    private javax.swing.JButton byyearButton;
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
