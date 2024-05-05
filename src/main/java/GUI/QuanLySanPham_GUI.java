package GUI;
import java.awt.Color;
import java.awt.Image;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class QuanLySanPham_GUI extends javax.swing.JPanel {

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbMaSanPham = new javax.swing.JLabel();
        txfMaSanPham = new javax.swing.JTextField();
        lblLoaiSanPham = new javax.swing.JLabel();
        txfMaDanhMuc = new javax.swing.JTextField();
        lblTenSanPham = new javax.swing.JLabel();
        txfTenSanPham = new javax.swing.JTextField();
        lblMieuTaSanPham = new javax.swing.JLabel();
        txfDonGia = new javax.swing.JTextField();
        lblDonGia = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txfMieuTaSanPham = new javax.swing.JTextArea();
        lblImageSP = new javax.swing.JLabel();
        lblAnhSanPham = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnXoaInput = new javax.swing.JButton();
        cbxNhaCC = new javax.swing.JComboBox<>();
        txfMaNhaCungCap = new javax.swing.JTextField();
        lblLoaiSanPham1 = new javax.swing.JLabel();
        cbxDanhMuc = new javax.swing.JComboBox<>();
        btnChonAnh = new javax.swing.JButton();
        lbTimKiem = new javax.swing.JLabel();
        txfTimKiem = new javax.swing.JTextField();
        cbbTimKiem = new javax.swing.JComboBox();
        btnExcelExport = new javax.swing.JButton();
        lbLocTheoMa = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txfMa1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txfMa2 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(102, 255, 102));

        jLabel1.setBackground(new java.awt.Color(51, 204, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cc.png"))); // NOI18N
        jLabel1.setText("QUẢN LÝ SẢN PHẨM");
        jLabel1.setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(255, 153, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(909, 714));

        lbMaSanPham.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lbMaSanPham.setText("Mã sản phẩm:");

        txfMaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfMaSanPhamActionPerformed(evt);
            }
        });

        lblLoaiSanPham.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblLoaiSanPham.setText("Mã nhà cung cấp:");

        txfMaDanhMuc.setEnabled(false);
        txfMaDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfMaDanhMucActionPerformed(evt);
            }
        });

        lblTenSanPham.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblTenSanPham.setText("Tên sản phẩm:");

        lblMieuTaSanPham.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblMieuTaSanPham.setText("Miêu tả sản phẩm:");

        txfDonGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfDonGiaActionPerformed(evt);
            }
        });

        lblDonGia.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblDonGia.setText("Đơn giá:");

        txfMieuTaSanPham.setColumns(20);
        txfMieuTaSanPham.setRows(5);
        jScrollPane2.setViewportView(txfMieuTaSanPham);

        lblImageSP.setBackground(new java.awt.Color(153, 255, 255));
        lblImageSP.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblImageSP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImageSP.setText("Hình ảnh ở đây");

        lblAnhSanPham.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblAnhSanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnhSanPham.setText("Ảnh sản phẩm:");

        btnXoa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-delete-27.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setPreferredSize(new java.awt.Dimension(104, 27));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnCapNhat.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-update-left-rotation-27.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-add-27.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setPreferredSize(new java.awt.Dimension(104, 27));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Mã nhà cung cấp", "Mã danh mục", "Tên sản phẩm", "Số lượng", "Đơn giá", "Ảnh sản phẩm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        tblSanPham.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblSanPhamKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);
        if (tblSanPham.getColumnModel().getColumnCount() > 0) {
            tblSanPham.getColumnModel().getColumn(0).setResizable(false);
            tblSanPham.getColumnModel().getColumn(1).setResizable(false);
            tblSanPham.getColumnModel().getColumn(2).setResizable(false);
            tblSanPham.getColumnModel().getColumn(3).setResizable(false);
            tblSanPham.getColumnModel().getColumn(4).setResizable(false);
            tblSanPham.getColumnModel().getColumn(5).setResizable(false);
            tblSanPham.getColumnModel().getColumn(6).setResizable(false);
            tblSanPham.getColumnModel().getColumn(7).setResizable(false);
            tblSanPham.getColumnModel().getColumn(8).setResizable(false);
        }

        btnXoaInput.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnXoaInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/clean-icon3.png"))); // NOI18N
        btnXoaInput.setPreferredSize(new java.awt.Dimension(104, 27));
        btnXoaInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaInputActionPerformed(evt);
            }
        });

        cbxNhaCC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbxNhaCC.setMaximumRowCount(10);
        cbxNhaCC.setToolTipText("");
        cbxNhaCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxNhaCCMouseClicked(evt);
            }
        });
        cbxNhaCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNhaCCActionPerformed(evt);
            }
        });

        txfMaNhaCungCap.setEnabled(false);

        lblLoaiSanPham1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblLoaiSanPham1.setText("Mã danh mục:");

        cbxDanhMuc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbxDanhMuc.setMaximumRowCount(10);
        cbxDanhMuc.setToolTipText("");
        cbxDanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxDanhMucMouseClicked(evt);
            }
        });
        cbxDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDanhMucActionPerformed(evt);
            }
        });

        btnChonAnh.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnChonAnh.setText("Chọn ảnh");
        btnChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAnhActionPerformed(evt);
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfTimKiemKeyReleased(evt);
            }
        });

        cbbTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTimKiemActionPerformed(evt);
            }
        });
        cbbTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbbTimKiemKeyReleased(evt);
            }
        });

        btnExcelExport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExcelExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-export-excel-27.png"))); // NOI18N
        btnExcelExport.setText("Xuất Excel");
        btnExcelExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelExportActionPerformed(evt);
            }
        });

        lbLocTheoMa.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbLocTheoMa.setText("Lọc theo mã:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Từ");

        txfMa1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfMa1KeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Tới");

        txfMa2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfMa2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(lblLoaiSanPham1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lbMaSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(cbxNhaCC, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(txfMaNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(txfMaSanPham)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(cbxDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(txfMaDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(457, 457, 457)
                                            .addComponent(btnXoaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(lblTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txfTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblMieuTaSanPham))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txfDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(52, 52, 52)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(btnChonAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btnCapNhat)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addComponent(lblImageSP, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(164, 164, 164)
                                        .addComponent(lblAnhSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbLocTheoMa)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txfMa1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txfMa2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbTimKiem)
                                        .addGap(31, 31, 31)
                                        .addComponent(txfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(101, 101, 101)
                                        .addComponent(btnExcelExport)))))
                        .addGap(0, 58, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnXoaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbMaSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txfMaSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbxNhaCC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txfMaNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblLoaiSanPham1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txfMaDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txfTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMieuTaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(txfDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblAnhSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblImageSP, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnChonAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbTimKiem)
                        .addComponent(cbbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnExcelExport, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfMa2)
                    .addComponent(txfMa1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(lbLocTheoMa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1023, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(306, 306, 306))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed

    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaInputActionPerformed

    }//GEN-LAST:event_btnXoaInputActionPerformed

    private void cbxNhaCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNhaCCActionPerformed

    }//GEN-LAST:event_cbxNhaCCActionPerformed

    private void txfMaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfMaSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfMaSanPhamActionPerformed

    private void txfMaDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfMaDanhMucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfMaDanhMucActionPerformed

    private void cbxDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDanhMucActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbxDanhMucActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void cbxNhaCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxNhaCCMouseClicked
        // TODO add your handling code here:
  
    }//GEN-LAST:event_cbxNhaCCMouseClicked

    private void cbxDanhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxDanhMucMouseClicked
        // TODO add your handling code here:
 
    }//GEN-LAST:event_cbxDanhMucMouseClicked

    private void btnChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonAnhActionPerformed
 
    }//GEN-LAST:event_btnChonAnhActionPerformed

    private void txfTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTimKiemKeyReleased
    
    }//GEN-LAST:event_txfTimKiemKeyReleased

    private void cbbTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTimKiemActionPerformed
      
    }//GEN-LAST:event_cbbTimKiemActionPerformed

    private void tblSanPhamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblSanPhamKeyReleased
      
    }//GEN-LAST:event_tblSanPhamKeyReleased

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

    }//GEN-LAST:event_btnXoaActionPerformed

    private void txfDonGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfDonGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfDonGiaActionPerformed

    private void btnExcelExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelExportActionPerformed

    }//GEN-LAST:event_btnExcelExportActionPerformed

    private void txfMa1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfMa1KeyReleased
 
    }//GEN-LAST:event_txfMa1KeyReleased

    private void txfMa2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfMa2KeyReleased
       
    }//GEN-LAST:event_txfMa2KeyReleased

    private void cbbTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbTimKiemKeyReleased
       
    }//GEN-LAST:event_cbbTimKiemKeyReleased

    private void txfTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfTimKiemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnChonAnh;
    private javax.swing.JButton btnExcelExport;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaInput;
    private javax.swing.JComboBox cbbTimKiem;
    private javax.swing.JComboBox<String> cbxDanhMuc;
    private javax.swing.JComboBox<String> cbxNhaCC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbLocTheoMa;
    private javax.swing.JLabel lbMaSanPham;
    private javax.swing.JLabel lbTimKiem;
    private javax.swing.JLabel lblAnhSanPham;
    private javax.swing.JLabel lblDonGia;
    private javax.swing.JLabel lblImageSP;
    private javax.swing.JLabel lblLoaiSanPham;
    private javax.swing.JLabel lblLoaiSanPham1;
    private javax.swing.JLabel lblMieuTaSanPham;
    private javax.swing.JLabel lblTenSanPham;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txfDonGia;
    private javax.swing.JTextField txfMa1;
    private javax.swing.JTextField txfMa2;
    private javax.swing.JTextField txfMaDanhMuc;
    private javax.swing.JTextField txfMaNhaCungCap;
    private javax.swing.JTextField txfMaSanPham;
    private javax.swing.JTextArea txfMieuTaSanPham;
    private javax.swing.JTextField txfTenSanPham;
    private javax.swing.JTextField txfTimKiem;
    // End of variables declaration//GEN-END:variables

}
