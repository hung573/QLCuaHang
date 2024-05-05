package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class QuanLyHoaDon_GUI extends javax.swing.JPanel {
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbQuanLyNhanVien = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txfTimKiem = new javax.swing.JTextField();
        cbbTimKiem = new javax.swing.JComboBox<>();
        btnXoaHD = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCTHD = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        pnXuatHoaDon = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnXuatHoaDon = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));

        lbQuanLyNhanVien.setBackground(new java.awt.Color(102, 102, 255));
        lbQuanLyNhanVien.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        lbQuanLyNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-receipt-26.png"))); // NOI18N
        lbQuanLyNhanVien.setText("QUẢN LÝ HÓA ĐƠN");
        lbQuanLyNhanVien.setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblHoaDon.setAutoCreateRowSorter(true);
        tblHoaDon.setBackground(new java.awt.Color(255, 153, 255));
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Mã nhân viên", "Mã khách hàng", "Ngày lập HD", "Tổng tiền HD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        tblHoaDon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblHoaDonKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 101, 560, 260));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/tt.png"))); // NOI18N
        jLabel2.setText("Danh sách hóa đơn");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 1, 220, 28));

        jLabel3.setText("Lọc:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 60, 20));

        jLabel4.setText("từ ngày");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 60, 20));

        jLabel5.setText("đến ngày");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 50, 20));

        jLabel6.setText("Tìm kiếm:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 60, 30));

        txfTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfTimKiemKeyReleased(evt);
            }
        });
        jPanel1.add(txfTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 210, 30));

        cbbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã hóa đơn", "Mã nhân viên", "Mã khách hàng" }));
        cbbTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTimKiemActionPerformed(evt);
            }
        });
        jPanel1.add(cbbTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 150, 30));

        btnXoaHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-delete-20.png"))); // NOI18N
        btnXoaHD.setText("Xóa");
        btnXoaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHDActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoaHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 80, 30));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblCTHD);
        if (tblCTHD.getColumnModel().getColumnCount() > 0) {
            tblCTHD.getColumnModel().getColumn(1).setMinWidth(150);
            tblCTHD.getColumnModel().getColumn(1).setMaxWidth(150);
            tblCTHD.getColumnModel().getColumn(2).setMinWidth(50);
            tblCTHD.getColumnModel().getColumn(2).setMaxWidth(50);
            tblCTHD.getColumnModel().getColumn(4).setMinWidth(80);
            tblCTHD.getColumnModel().getColumn(4).setMaxWidth(80);
        }

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-more-details-20.png"))); // NOI18N
        jLabel1.setText("Chi tiết hóa đơn");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnXuatHoaDon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnXuatHoaDon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnXuatHoaDon.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btnXuatHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-pdf-24.png"))); // NOI18N
        btnXuatHoaDon.setText("Xuất hóa đơn");
        btnXuatHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(147, Short.MAX_VALUE)
                .addComponent(btnXuatHoaDon)
                .addGap(144, 144, 144))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnXuatHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnXuatHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbQuanLyNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(368, 368, 368))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbQuanLyNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnXuatHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
     
        
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void tblHoaDonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblHoaDonKeyReleased
   
    }//GEN-LAST:event_tblHoaDonKeyReleased

    private void btnXuatHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatHoaDonActionPerformed
       
    }//GEN-LAST:event_btnXuatHoaDonActionPerformed

    private void txfTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTimKiemKeyReleased
       
    }//GEN-LAST:event_txfTimKiemKeyReleased

    private void cbbTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTimKiemActionPerformed
       
    }//GEN-LAST:event_cbbTimKiemActionPerformed

    private void jdTuNgayPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdTuNgayPropertyChange
        
    }//GEN-LAST:event_jdTuNgayPropertyChange

    private void jdDenNgayPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdDenNgayPropertyChange
        
    }//GEN-LAST:event_jdDenNgayPropertyChange

    private void btnXoaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHDActionPerformed
     
    }//GEN-LAST:event_btnXoaHDActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXoaHD;
    private javax.swing.JButton btnXuatHoaDon;
    private javax.swing.JComboBox<String> cbbTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbQuanLyNhanVien;
    private javax.swing.JPanel pnXuatHoaDon;
    private javax.swing.JTable tblCTHD;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txfTimKiem;
    // End of variables declaration//GEN-END:variables
}
