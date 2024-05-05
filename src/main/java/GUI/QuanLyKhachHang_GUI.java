package GUI;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import DTO.*;
import DAO.*;
import BUS.*;
import java.beans.Customizer;
import java.sql.Date;
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class QuanLyKhachHang_GUI extends javax.swing.JPanel {

    private DefaultTableModel jtbKhachHangmodel;
    private KhachHangBUS khachhangBUS = new KhachHangBUS();
    private KhachHang khachhangUpdate = new KhachHang();
    private KhachHang khachhangDelete = new KhachHang();
    private int khachhangid;

    public QuanLyKhachHang_GUI() {
        this.setVisible(true);
        initComponents();
        initTable();
        loadData();
    }

    private void initTable() {
        jtbKhachHangmodel = new DefaultTableModel();
        jtbKhachHangmodel.setColumnIdentifiers(new String[]{"ID", "TenKhachHang", "GioiTinh", "NgaySinh", "SoDienThoai", "Email", "DiaChi"});
        jtbKhachHang.setModel(jtbKhachHangmodel);
    }

    private void loadData() {
        try {
            KhachHangBUS khachhangBUS = new KhachHangBUS();
            List<KhachHang> list = khachhangBUS.LoadKhachHang(WIDTH);
            jtbKhachHangmodel.setRowCount(0);
            for (KhachHang kh : list) {
                jtbKhachHangmodel.addRow(new Object[]{
                    kh.getID(), kh.getTenKhachHang(), kh.getGioiTinh(), kh.getNgaySinh(), kh.getSoDienThoai(), kh.getEmail(), kh.getDiaChi()
                });
            }
            jtbKhachHangmodel.fireTableDataChanged();
            khachhangid = list.size() + 1;
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

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbDiaChi = new javax.swing.JLabel();
        lbHoTen = new javax.swing.JLabel();
        lbCMND = new javax.swing.JLabel();
        lbSDT = new javax.swing.JLabel();
        lbGioiTinh = new javax.swing.JLabel();
        jtfTenKhachHang = new javax.swing.JTextField();
        jtfGioiTinh = new javax.swing.JTextField();
        jtfSoDienThoai = new javax.swing.JTextField();
        lbTimKiem = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txfTimKiem = new javax.swing.JTextField();
        btnXoaInput = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbKhachHang = new javax.swing.JTable();
        btnExcelExport = new javax.swing.JButton();
        jtfDiaChi = new javax.swing.JTextField();
        lbGioiTinh1 = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jdcNgaySinh = new com.toedter.calendar.JDateChooser();
        jbtTimKiem = new javax.swing.JButton();
        lbQuanLyNhanVien = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));
        setForeground(new java.awt.Color(0, 153, 153));
        setPreferredSize(new java.awt.Dimension(983, 650));
        setVerifyInputWhenFocusTarget(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        lbDiaChi.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lbDiaChi.setText("Giới tính:");

        lbHoTen.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lbHoTen.setText("Họ tên:");

        lbCMND.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lbCMND.setText("Số điện thoại:");

        lbSDT.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lbSDT.setText("Ngày sinh:");

        lbGioiTinh.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lbGioiTinh.setText("Email:");

        jtfTenKhachHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfTenKhachHangKeyPressed(evt);
            }
        });

        jtfGioiTinh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfGioiTinhKeyPressed(evt);
            }
        });

        jtfSoDienThoai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfSoDienThoaiKeyPressed(evt);
            }
        });

        lbTimKiem.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbTimKiem.setText("Tìm kiếm:");

        txfTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfTimKiemActionPerformed(evt);
            }
        });
        txfTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfTimKiemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfTimKiemKeyReleased(evt);
            }
        });

        btnXoaInput.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnXoaInput.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\clean-icon3.png"));
        btnXoaInput.setText("Reset");
        btnXoaInput.setPreferredSize(new java.awt.Dimension(104, 27));
        btnXoaInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaInputActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\icons8-add-27.png"));
        btnThem.setText("Thêm");
        btnThem.setPreferredSize(new java.awt.Dimension(104, 27));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapNhat.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCapNhat.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\icons8-update-left-rotation-27.png"));
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\icons8-delete-27.png"));
        btnXoa.setText("Xóa");
        btnXoa.setPreferredSize(new java.awt.Dimension(104, 27));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jtbKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Họ tên", "Giới tính", "Ngày sinh", "Số điện thoại", "Email", "Địa chỉ"
            }
        ));
        jtbKhachHang.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jtbKhachHangAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jtbKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbKhachHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jtbKhachHangMouseEntered(evt);
            }
        });
        jtbKhachHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbKhachHangKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtbKhachHangKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtbKhachHang);

        btnExcelExport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExcelExport.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\icons8-microsoft-excel-27.png"));
        btnExcelExport.setText("Xuất Excel");
        btnExcelExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelExportActionPerformed(evt);
            }
        });

        jtfDiaChi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfDiaChiKeyPressed(evt);
            }
        });

        lbGioiTinh1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lbGioiTinh1.setText("Địa chỉ:");

        jtfEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfEmailKeyPressed(evt);
            }
        });

        jbtTimKiem.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\icons8-search-27.png"));
        jbtTimKiem.setText("Tìm");
        jbtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtTimKiemActionPerformed(evt);
            }
        });
        jbtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jbtTimKiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 139, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTimKiem)
                                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbGioiTinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47)
                                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(btnXoaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jtfSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jtfDiaChi)
                                            .addComponent(jtfEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(27, 27, 27)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtfGioiTinh)
                                        .addComponent(jdcNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lbHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                                    .addComponent(jtfTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExcelExport, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                        .addGap(198, 198, 198))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdcNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbGioiTinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCapNhat)
                    .addComponent(btnXoaInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcelExport, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );

        lbQuanLyNhanVien.setBackground(new java.awt.Color(102, 102, 255));
        lbQuanLyNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lbQuanLyNhanVien.setText("QUẢN LÝ KHÁCH HÀNG");
        lbQuanLyNhanVien.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(lbQuanLyNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbQuanLyNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtfTenKhachHangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTenKhachHangKeyPressed

    }//GEN-LAST:event_jtfTenKhachHangKeyPressed

    private void jtfGioiTinhKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfGioiTinhKeyPressed

    }//GEN-LAST:event_jtfGioiTinhKeyPressed

    private void jtfSoDienThoaiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSoDienThoaiKeyPressed

    }//GEN-LAST:event_jtfSoDienThoaiKeyPressed

    private void txfTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTimKiemKeyPressed

    }//GEN-LAST:event_txfTimKiemKeyPressed

    private void btnXoaInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaInputActionPerformed
        jtfTenKhachHang.setText("");
        jtfGioiTinh.setText("");
        jtfSoDienThoai.setText("");
        jtfEmail.setText("");
        jtfDiaChi.setText("");
        jdcNgaySinh.setCalendar(null);
    }//GEN-LAST:event_btnXoaInputActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (jtfTenKhachHang.getText().isBlank() || jtfGioiTinh.getText().isBlank() || jdcNgaySinh.getDate() == null
                || jtfSoDienThoai.getText().isBlank() || jtfEmail.getText().isBlank() || jtfDiaChi.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Không được điền thiếu thông tin nhân viên");
            return;
        }
        try {
            if (!Email()) {
                JOptionPane.showMessageDialog(this, "Sai dinh dang Email");
                return;
            }
            KhachHang kh = new KhachHang();
            kh.setID(khachhangid);
            kh.setTenKhachHang(jtfTenKhachHang.getText());
            kh.setGioiTinh(jtfGioiTinh.getText());
//                nhanVien.setNgaySinh(Date.valueOf(jtfNgaysinhNhanvien.getDate().toString()));
//                nhanVien.setNgaySinh(String.valueOf(jtfNgaysinhNhanvien.getText()));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String finddate = sdf.format(jdcNgaySinh.getDate()).toString();
            kh.setNgaySinh(Date.valueOf(finddate));
            kh.setSoDienThoai(jtfSoDienThoai.getText());

            kh.setEmail(jtfEmail.getText());
            kh.setDiaChi(jtfDiaChi.getText());
            KhachHangBUS khachhangBUS = new KhachHangBUS();
            if (khachhangBUS.saveKhachHang(kh) > 0) {
                JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công");
                jtfTenKhachHang.setText("");
                jtfGioiTinh.setText("");
                //jdtNgaySinh.setDate("");
                jdcNgaySinh.cleanup();
                jtfSoDienThoai.setText("");
                jtfEmail.setText("");
                jtfDiaChi.setText("");
                loadData();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        try {
            if (!Email()) {
                JOptionPane.showMessageDialog(this, "Sai dinh dang Email");
                return;
            }
            KhachHang kh = new KhachHang();
            kh = this.khachhangUpdate;
            kh.setTenKhachHang(jtfTenKhachHang.getText());
            kh.setGioiTinh(jtfGioiTinh.getText());
//            kh.setNgaySinh(jtfNgaysinhNhanvien.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String finddate = sdf.format(jdcNgaySinh.getDate()).toString();
            kh.setNgaySinh(Date.valueOf(finddate));
            kh.setSoDienThoai(jtfSoDienThoai.getText());
            kh.setEmail(jtfEmail.getText());
            kh.setDiaChi(jtfDiaChi.getText());

            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn Update không?", "Hỏi",
                     JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION) {
                return;
            }
            KhachHangBUS khachhangBUS = new KhachHangBUS();
            if (khachhangBUS.updateKhachHang(kh) > 0) {
                JOptionPane.showMessageDialog(null, "Update thành công");
                jtfTenKhachHang.setText("");
                jtfGioiTinh.setText("");
                jdcNgaySinh.cleanup();
                jtfSoDienThoai.setText("");
                jtfEmail.setText("");
                jtfDiaChi.setText("");
                loadData();
            } else {
                JOptionPane.showMessageDialog(null, "Update thất bại");
            }
        } catch (Exception e) {
            Logger.getLogger(NhanVienJFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?", "Hỏi"
            , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION){
            return;
            }
            KhachHangBUS khachhangBUS = new KhachHangBUS();
            if(khachhangBUS.deleteKhachHang(khachhangDelete)){
                JOptionPane.showMessageDialog(null, "Xóa thành công");
                loadData();
            }
            else{
                JOptionPane.showMessageDialog(null, "Xóa thất bại");
            }
        } catch (Exception e) {
            Logger.getLogger(NhanVienJFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void jtbKhachHangAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jtbKhachHangAncestorAdded

    }//GEN-LAST:event_jtbKhachHangAncestorAdded

    private void jtbKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbKhachHangMouseClicked
        try {
            int row = jtbKhachHang.getSelectedRow();
            if (row >= 0) {
                int id = (Integer) jtbKhachHang.getValueAt(row, 0);
                KhachHangBUS khachhangBUS = new KhachHangBUS();
                KhachHang kh = khachhangBUS.getKhachHang(id);
                khachhangUpdate = this.khachhangBUS.getKhachHang(id);
                khachhangDelete = this.khachhangBUS.getKhachHang(id);
                if (kh != null) {
                    jtfTenKhachHang.setText(kh.getTenKhachHang());
                    jtfGioiTinh.setText(kh.getGioiTinh());
                    jdcNgaySinh.setDate(kh.getNgaySinh());
                    jtfSoDienThoai.setText(kh.getSoDienThoai());
                    jtfEmail.setText(kh.getEmail());
                    jtfDiaChi.setText(kh.getDiaChi());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jtbKhachHangMouseClicked

    private void jtbKhachHangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbKhachHangKeyPressed

    }//GEN-LAST:event_jtbKhachHangKeyPressed

    private void btnExcelExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelExportActionPerformed

    }//GEN-LAST:event_btnExcelExportActionPerformed

    private void txfTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfTimKiemActionPerformed

    }//GEN-LAST:event_txfTimKiemActionPerformed

    private void jtbKhachHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbKhachHangMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbKhachHangMouseEntered

    private void jtbKhachHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbKhachHangKeyReleased

    }//GEN-LAST:event_jtbKhachHangKeyReleased

    private void txfTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTimKiemKeyReleased
        try {
            KhachHangBUS khachhangBUS = new KhachHangBUS();
            List<KhachHang> list = khachhangBUS.findKhachHang(txfTimKiem.getText());
            initTable();
            for(KhachHang kh : list){
                jtbKhachHangmodel.addRow(new Object[]{
                    kh.getID(),kh.getTenKhachHang(),kh.getGioiTinh(),kh.getNgaySinh(),kh.getSoDienThoai(),
                    kh.getEmail(),kh.getDiaChi()
                });
            }
        } catch (Exception e) {
             e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Khách hàng không tồn tại" , "Cảnh báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txfTimKiemKeyReleased

    private void jtfDiaChiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDiaChiKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDiaChiKeyPressed

    private void jtfEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEmailKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfEmailKeyPressed

    private void jbtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtTimKiemActionPerformed
        try {
            KhachHangBUS khachhangBUS = new KhachHangBUS();
            List<KhachHang> list = khachhangBUS.findKhachHang(txfTimKiem.getText());
            
            if(list.isEmpty()){
                JOptionPane.showMessageDialog(this,"Khách hàng không tồn tại" , "Cảnh báo", JOptionPane.ERROR_MESSAGE);
            }
            else{
                for(KhachHang kh : list){
                    jtfTenKhachHang.setText(kh.getTenKhachHang());
                    jtfGioiTinh.setText(kh.getGioiTinh());
                    jdcNgaySinh.setDate(kh.getNgaySinh());
                    jtfSoDienThoai.setText(kh.getSoDienThoai());
                    jtfEmail.setText(kh.getEmail());
                    jtfDiaChi.setText(kh.getDiaChi());
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Khách hàng không tồn tại" , "Cảnh báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtTimKiemActionPerformed

    private void jbtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtTimKiemKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtTimKiemKeyReleased

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TableNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyKhachHang_GUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnExcelExport;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaInput;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbtTimKiem;
    private com.toedter.calendar.JDateChooser jdcNgaySinh;
    private javax.swing.JTable jtbKhachHang;
    private javax.swing.JTextField jtfDiaChi;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfGioiTinh;
    private javax.swing.JTextField jtfSoDienThoai;
    private javax.swing.JTextField jtfTenKhachHang;
    private javax.swing.JLabel lbCMND;
    private javax.swing.JLabel lbDiaChi;
    private javax.swing.JLabel lbGioiTinh;
    private javax.swing.JLabel lbGioiTinh1;
    private javax.swing.JLabel lbHoTen;
    private javax.swing.JLabel lbQuanLyNhanVien;
    private javax.swing.JLabel lbSDT;
    private javax.swing.JLabel lbTimKiem;
    private javax.swing.JTextField txfTimKiem;
    // End of variables declaration//GEN-END:variables

}
