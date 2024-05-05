/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import DTO.NguonHang;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import BUS.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author MSI VN
 */
public class QuanLyNguonHang_GUI extends javax.swing.JPanel {

    private DefaultTableModel jtbNguonHangmodel;
    private NguonHangBus nguonhangBUS = new NguonHangBus();
    private NguonHang nguonhangUpdate = new NguonHang();
    private NguonHang nguonhangDelete = new NguonHang();
    private int nguonhangid;
    
    public QuanLyNguonHang_GUI() {
        this.setLayout(null);
        initComponents();
        this.setVisible(true);
        initTable();
        loadData();
    }

    private void initTable() {
        jtbNguonHangmodel = new DefaultTableModel();
        jtbNguonHangmodel.setColumnIdentifiers(new String[]{"ID", "Tên nguồn hàng", "Số điện thoại", "Email", "Địa chỉ", "Ngày tạo", "Người đại diện"});
        jtbNguonHang.setModel(jtbNguonHangmodel);
    }

    private void loadData() {
        try {
            NguonHangBus nguonhangBUS = new NguonHangBus();
            List<NguonHang> list = nguonhangBUS.LoadNguonHang(WIDTH);
            jtbNguonHangmodel.setRowCount(0);
            for (NguonHang nh : list) {
                jtbNguonHangmodel.addRow(new Object[]{
                    nh.getID(), nh.getTenNguonHang(), nh.getSoDienThoai(), nh.getEmail(), nh.getDiaChi(), nh.getNgayTao(), nh.getNguoiDaiDien()
                });
            }
            jtbNguonHangmodel.fireTableDataChanged();
            nguonhangid = list.size() + 1;
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    
    private boolean Email() {
        String Email;
        Email = jtfEmail.getText();
        String check = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        if (!Email.matches(check)) {
            return false;
        } else {
            return true;
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfTenNguonHang = new javax.swing.JTextField();
        jtfSoDienThoai = new javax.swing.JTextField();
        jtfEmail = new javax.swing.JTextField();
        jtfDiaChi = new javax.swing.JTextField();
        jtfNguoiDaiDien = new javax.swing.JTextField();
        jdcNgayTao = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbNguonHang = new javax.swing.JTable();
        jtfTimKiem = new javax.swing.JTextField();
        jbtThem = new javax.swing.JButton();
        jbtSua = new javax.swing.JButton();
        jbtXoa = new javax.swing.JButton();
        jbtReset = new javax.swing.JButton();
        jbtTim = new javax.swing.JButton();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(983, 650));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý nguồn hàng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(204, 0, 204))); // NOI18N
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setPreferredSize(new java.awt.Dimension(983, 650));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel2.setText("Tên nguồn hàng");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel3.setText("Email");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel4.setText("Số điện thoại");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel5.setText("Địa chỉ");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel6.setText("Ngày tạo");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel7.setText("Người đại diện");

        jtbNguonHang.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbNguonHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbNguonHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbNguonHang);

        jtfTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfTimKiemKeyPressed(evt);
            }
        });

        jbtThem.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\icons8-add-27.png"));
        jbtThem.setText("Thêm");
        jbtThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtThemActionPerformed(evt);
            }
        });

        jbtSua.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\icons8-update-left-rotation-27.png"));
        jbtSua.setText("Sửa");
        jbtSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSuaActionPerformed(evt);
            }
        });

        jbtXoa.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\icons8-delete-27.png"));
        jbtXoa.setText("Xóa");
        jbtXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtXoaActionPerformed(evt);
            }
        });

        jbtReset.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\clean-icon3.png"));
        jbtReset.setText("Reset");
        jbtReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtResetActionPerformed(evt);
            }
        });

        jbtTim.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\icons8-search-27.png"));
        jbtTim.setText("Tìm");
        jbtTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGap(42, 42, 42))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(90, 90, 90)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(52, 52, 52)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfNguoiDaiDien, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(jdcNgayTao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfSoDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(jtfEmail)
                    .addComponent(jtfDiaChi)
                    .addComponent(jtfTenNguonHang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtThem)
                        .addGap(18, 18, 18)
                        .addComponent(jbtSua, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtfTimKiem))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtReset)
                    .addComponent(jbtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jtfTenNguonHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jbtSua, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbtXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbtReset, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(4, 4, 4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtfSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jdcNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNguoiDaiDien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtfTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTimKiemKeyPressed
        try {
            NguonHangBus nguonhangBUS = new NguonHangBus();
            List<NguonHang> list = nguonhangBUS.findNguonHang(jtfTimKiem.getText());
            initTable();
            for (NguonHang nh : list) {
                jtbNguonHangmodel.addRow(new Object[]{
                    nh.getID(), nh.getTenNguonHang(), nh.getSoDienThoai(),
                    nh.getEmail(), nh.getDiaChi(), nh.getNgayTao(), nh.getNguoiDaiDien()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Khách hàng không tồn tại", "Cảnh báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtfTimKiemKeyPressed

    private void jtbNguonHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbNguonHangMouseClicked
        try {
            int row = jtbNguonHang.getSelectedRow();
            if (row >= 0) {
                int id = (Integer) jtbNguonHang.getValueAt(row, 0);
                NguonHangBus nguonhangBUS = new NguonHangBus();
                NguonHang nh = nguonhangBUS.getNguonHang(id);
                nguonhangUpdate = this.nguonhangBUS.getNguonHang(id);
                nguonhangDelete = this.nguonhangBUS.getNguonHang(id);
                if (nh != null) {
                    jtfTenNguonHang.setText(nh.getTenNguonHang());
                    jtfSoDienThoai.setText(nh.getSoDienThoai());
                    jtfEmail.setText(nh.getEmail());
                    jtfDiaChi.setText(nh.getDiaChi());
                    jdcNgayTao.setDate(nh.getNgayTao());
                    jtfNguoiDaiDien.setText(nh.getNguoiDaiDien());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtbNguonHangMouseClicked

    private void jbtThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtThemActionPerformed
         if (jtfTenNguonHang.getText().isBlank() || jtfNguoiDaiDien.getText().isBlank() || jdcNgayTao.getDate() == null
            || jtfSoDienThoai.getText().isBlank() || jtfEmail.getText().isBlank() || jtfDiaChi.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Không được điền thiếu thông tin nguồn hàng");
            return;
        }
        try {
            if (!Email()) {
                JOptionPane.showMessageDialog(this, "Sai dinh dang Email");
                return;
            }
            NguonHang nh = new NguonHang();
            nh.setID(nguonhangid);
            nh.setTenNguonHang(jtfTenNguonHang.getText());
            nh.setSoDienThoai(jtfSoDienThoai.getText());
            nh.setEmail(jtfEmail.getText());
            nh.setDiaChi(jtfDiaChi.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String finddate = sdf.format(jdcNgayTao.getDate()).toString();
            nh.setNgayTao(Date.valueOf(finddate));
            nh.setNguoiDaiDien(jtfNguoiDaiDien.getText());
            KhachHangBUS khachhangBUS = new KhachHangBUS();
            if (nguonhangBUS.saveNguonHang(nh) > 0) {
                JOptionPane.showMessageDialog(this, "Thêm nguồn hàng thành công");
                jtfTenNguonHang.setText("");
                jtfSoDienThoai.setText("");
                jtfEmail.setText("");
                jtfDiaChi.setText("");
                jdcNgayTao.setCalendar(null);
                jtfNguoiDaiDien.setText("");
                loadData();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm nguồn hàng thất bại");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Thêm nguồn hàng thất bại");
        }
    }//GEN-LAST:event_jbtThemActionPerformed

    private void jbtSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSuaActionPerformed
        try {
            if (!Email()) {
                JOptionPane.showMessageDialog(this, "Sai dinh dang Email");
                return;
            }
            NguonHang nh = new NguonHang();
            nh = this.nguonhangUpdate;
            nh.setTenNguonHang(jtfTenNguonHang.getText());
            nh.setSoDienThoai(jtfSoDienThoai.getText());
            nh.setEmail(jtfEmail.getText());
            nh.setDiaChi(jtfDiaChi.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String finddate = sdf.format(jdcNgayTao.getDate()).toString();
            nh.setNgayTao(Date.valueOf(finddate));
            nh.setNguoiDaiDien(jtfNguoiDaiDien.getText());

            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn Update không?", "Hỏi",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION) {
            return;
        }
        NguonHangBus nguonhangBUS = new NguonHangBus();
        if (nguonhangBUS.updateNguonHang(nh) > 0) {
            JOptionPane.showMessageDialog(null, "Update thành công");
            jtfTenNguonHang.setText("");
            jtfSoDienThoai.setText("");
            jtfEmail.setText("");
            jtfDiaChi.setText("");
            jdcNgayTao.setCalendar(null);
            jtfNguoiDaiDien.setText("");
            loadData();
        } else {
            JOptionPane.showMessageDialog(null, "Update thất bại");
        }
        } catch (Exception e) {
            Logger.getLogger(NhanVienJFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jbtSuaActionPerformed

    private void jbtXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtXoaActionPerformed
        try {
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?", "Hỏi",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION) {
            return;
        }
        NguonHangBus nguonhangBUS = new NguonHangBus();
        if (nguonhangBUS.deleteNguonHang(nguonhangDelete)) {
            JOptionPane.showMessageDialog(null, "Xóa thành công");
            loadData();
        } else {
            JOptionPane.showMessageDialog(null, "Xóa thất bại");
        }
        } catch (Exception e) {
            Logger.getLogger(NhanVienJFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jbtXoaActionPerformed

    private void jbtResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtResetActionPerformed
        jtfTenNguonHang.setText("");
        jtfSoDienThoai.setText("");
        jtfEmail.setText("");
        jtfDiaChi.setText("");
        jdcNgayTao.setCalendar(null);
        jtfNguoiDaiDien.setText("");
    }//GEN-LAST:event_jbtResetActionPerformed

    private void jbtTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtTimActionPerformed
        try {
            NguonHangBus nguonhangBUS = new NguonHangBus();
            List<NguonHang> list = nguonhangBUS.findNguonHang(jtfTimKiem.getText());

            if (list.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Khách hàng không tồn tại", "Cảnh báo", JOptionPane.ERROR_MESSAGE);
            } else {
                for (NguonHang nh : list) {
                    jtfTenNguonHang.setText(nh.getTenNguonHang());
                    jtfSoDienThoai.setText(nh.getSoDienThoai());
                    jtfEmail.setText(nh.getEmail());
                    jtfDiaChi.setText(nh.getDiaChi());
                    jdcNgayTao.setDate(nh.getNgayTao());
                    jtfNguoiDaiDien.setText(nh.getNguoiDaiDien());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Khách hàng không tồn tại", "Cảnh báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtTimActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtReset;
    private javax.swing.JButton jbtSua;
    private javax.swing.JButton jbtThem;
    private javax.swing.JButton jbtTim;
    private javax.swing.JButton jbtXoa;
    private com.toedter.calendar.JDateChooser jdcNgayTao;
    private javax.swing.JTable jtbNguonHang;
    private javax.swing.JTextField jtfDiaChi;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfNguoiDaiDien;
    private javax.swing.JTextField jtfSoDienThoai;
    private javax.swing.JTextField jtfTenNguonHang;
    private javax.swing.JTextField jtfTimKiem;
    // End of variables declaration//GEN-END:variables
}
