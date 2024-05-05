/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import DTO.DonHangMua;
import BUS.NguonHangBus;
import DTO.ChiTietDonHangMua;
import DAO.*;
import BUS.*;
import DTO.NguonHang;
import DTO.NhanVien;
import DTO.SanPham;
import DTO.TrangThaiMua;
import java.awt.event.KeyEvent;
import java.beans.Customizer;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author tranconghung
 */
public class DonHangMuaJPanel extends javax.swing.JPanel {
    
    private DefaultTableModel jtbDonHangMuamodel;
    private  DonHangMuaBUS donHangBUS = new DonHangMuaBUS();
    private DonHangMua donHangUpdate = new DonHangMua();
    private DonHangMua donHangDelete = new DonHangMua();
    private int donhangmuaid;
    
    private DefaultTableModel jtbChiTietDonHangMuamodel;
    private  ChiTietDonHangMuaBUS chiTietBUS = new ChiTietDonHangMuaBUS();
    private ChiTietDonHangMua chiTietUpdate = new ChiTietDonHangMua();
    private ChiTietDonHangMua chiTietDelete = new ChiTietDonHangMua();
    private int chitietdonhangmuaid;
    
    private DefaultTableModel jtbSanPhammodel;
    
    DecimalFormat DecimalFormat = new DecimalFormat("#");
    /**
     * Creates new form DonHangMuaJPanel
     */
    public DonHangMuaJPanel() {
        initComponents();
        initTable();
        loadData();  
        loadDataSanPham();
    }
    
    private void initTable(){
        jtbDonHangMuamodel = new DefaultTableModel();
        jtbDonHangMuamodel.setColumnIdentifiers(new String[] {"ID","idNhanVien","TenNguonHang","idTrangThai","TenTrangThai","NgayLap","TongTien"});
        jtbDonHangMua.setModel(jtbDonHangMuamodel);
        
        jtbChiTietDonHangMuamodel = new DefaultTableModel();
        jtbChiTietDonHangMuamodel.setColumnIdentifiers(new String[] {"ID","idDonHangMua","TenSanPham","SoLuong","DonGiaApDung","ThanhTien"});
        jtbChiTietDonHangMua.setModel(jtbChiTietDonHangMuamodel);
        
        jtbSanPhammodel = new DefaultTableModel();
        jtbSanPhammodel.setColumnIdentifiers(new String[] {"ID","Tên Sản Phẩm","Loại Sản Phẩm"});
        jtbSanPham.setModel(jtbSanPhammodel);
    }
    private void loadDataSanPham(){
        try {
            SanPhamBUS sanPhamBUS = new SanPhamBUS();
            List<SanPham> list = sanPhamBUS.LoadSanPham(WIDTH);
            jtbSanPhammodel.setRowCount(0);
            for(SanPham sp : list){
                jtbSanPhammodel.addRow(new Object[]{
                    sp.getID(),sp.getTenSanPham(),sp.getIdLoaiSanPham()
                });
                jtbSanPhammodel.fireTableDataChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void loadData(){
        try {
            DonHangMuaBUS donHangMuaBUS = new DonHangMuaBUS();
            List<DonHangMua> list = donHangMuaBUS.LoadDonHangMua(WIDTH);

            NguonHangBus khachHangBUS = new NguonHangBus();
            List<NguonHang> listkh = khachHangBUS.LoadNguonHang(WIDTH);

            TrangThaiMuaBUS trangThaiBUS = new TrangThaiMuaBUS();
            List<TrangThaiMua> listtt = trangThaiBUS.LoadTrangThaiMua(WIDTH);
            
            
            jtbDonHangMuamodel.setRowCount(0);
            for (DonHangMua dh : list) {
                List<String> customerNames = new ArrayList<>();
                List<String> trangThaiMua = new ArrayList<>();
                // Find all customers with the same ID as the current order's customer ID
                for (NguonHang kh : listkh) {
                    if (kh.getID() == dh.getIdNguonHang()) {
                        customerNames.add(kh.getTenNguonHang());
                    }
                }
                for (TrangThaiMua tt : listtt) {
                    if (tt.getID() == dh.getIdTrangThai()) {
                        trangThaiMua.add(tt.getTenTrangThai());
                    }
                }

                // Add the customer names and order details to the table
                if (!customerNames.isEmpty() || !trangThaiMua.isEmpty()) {
                    String customerName = String.join(" ", customerNames);
                    String statusName = String.join(" ", trangThaiMua);
                    jtbDonHangMuamodel.addRow(new Object[]{
                        dh.getID(), dh.getIdNhanVienLap(),customerName,dh.getIdTrangThai(), statusName, dh.getNgayLap(), DecimalFormat.format(dh.getTongTien())
                    });
                }
            }
            jtbDonHangMuamodel.fireTableDataChanged();
            donhangmuaid = list.size() + 1;
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void XuatExcel() {
       JFileChooser file = new JFileChooser(); //Khởi tạo JFileChooser
        file.setCurrentDirectory(new File(System.getProperty("user.home"))); 
        
        int result = file.showSaveDialog(null);
        if ( result == JFileChooser.APPROVE_OPTION){
            XSSFWorkbook excelWorkbook = new XSSFWorkbook();
            XSSFSheet excelSheet = excelWorkbook.createSheet("CHI TIET HOA DON");
            
            XSSFRow row = null;
            Cell cell = null;
            
            row = excelSheet.createRow((short) 2);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("CHI TIET HOA DON");

            row = excelSheet.createRow((short) 3);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("ID DON HANG");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("ID SAN PHAM");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("SO LUONG");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("DON GIA");
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("THANH TIEN"); 
            for (int i = 0; i < jtbChiTietDonHangMua.getRowCount(); i++){
                row = excelSheet.createRow((short) 4 + i);
                row.setHeight((short) 400);
                for (int j = 0; j < jtbChiTietDonHangMua.getColumnCount(); j++){
                    row.createCell(j).setCellValue(jtbChiTietDonHangMua.getValueAt(i, j).toString());
                }
            }          
            FileOutputStream excelFOS;
            BufferedOutputStream excelBOS;
            try{
                excelFOS = new FileOutputStream(new File(file.getSelectedFile() + ".xlsx"));
                excelBOS = new BufferedOutputStream(excelFOS);
                excelWorkbook.write(excelBOS);
                JOptionPane.showMessageDialog(null, "Xuất file excel thành công!");
                excelBOS.close();
                excelWorkbook.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfidNhanVienLap = new javax.swing.JTextField();
        jtfidNguonHang = new javax.swing.JTextField();
        jtfidTrangThai = new javax.swing.JTextField();
        jtfTongTien = new javax.swing.JTextField();
        jtfTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        jdtNgayLap = new com.toedter.calendar.JDateChooser();
        btnExcel = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbDonHangMua = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtfidDonHangMua = new javax.swing.JTextField();
        jtfidSanPham = new javax.swing.JTextField();
        jtfSoLuong = new javax.swing.JTextField();
        jtfDonGia = new javax.swing.JTextField();
        jtfThanhTien = new javax.swing.JTextField();
        btnThemChiTiet = new javax.swing.JButton();
        btnXoaChiTiet = new javax.swing.JButton();
        btnCapNhatChiTiet = new javax.swing.JButton();
        btnResetChiTiet = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbChiTietDonHangMua = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbSanPham = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 255, 204));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đơn Hàng Mua", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(204, 0, 204))); // NOI18N
        setPreferredSize(new java.awt.Dimension(983, 650));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đơn Hàng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(204, 0, 204))); // NOI18N

        jLabel1.setText("id nhân viên lập");

        jLabel3.setText("id khách hàng");

        jLabel4.setText("id trạng thái");

        jLabel5.setText("Ngày lập");

        jLabel6.setText("Tổng tiền");

        jtfidNhanVienLap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfidNhanVienLapActionPerformed(evt);
            }
        });

        jtfidNguonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfidNguonHangActionPerformed(evt);
            }
        });

        jtfidTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfidTrangThaiActionPerformed(evt);
            }
        });

        jtfTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTongTienActionPerformed(evt);
            }
        });

        jtfTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTimKiemActionPerformed(evt);
            }
        });
        jtfTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfTimKiemKeyReleased(evt);
            }
        });

        btnTimKiem.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\icons8-search-27.png"));
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnCapNhat.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\icons8-update-left-rotation-27.png"));
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.setActionCommand("jButton2");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\icons8-delete-27.png"));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLuu.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\icons8-add-27.png"));
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnExcel.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\icons8-microsoft-excel-27.png"));
        btnExcel.setText("Xuất Excel");
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        btnReset.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\clean-icon3.png"));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtbDonHangMua.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbDonHangMua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbDonHangMuaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbDonHangMua);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfidNguonHang)
                            .addComponent(jtfidTrangThai, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfidNhanVienLap, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnCapNhat)
                                        .addGap(51, 51, 51)
                                        .addComponent(btnXoa))
                                    .addComponent(jtfTongTien, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jdtNgayLap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))))
                        .addGap(174, 174, 174))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnExcel))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jtfTimKiem)
                            .addGap(18, 18, 18)
                            .addComponent(btnTimKiem))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfidNhanVienLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfidNguonHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfidTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu)
                    .addComponent(btnCapNhat)
                    .addComponent(btnXoa))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcel)
                    .addComponent(btnReset))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi Tiết Đơn Hàng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(204, 0, 204))); // NOI18N

        jLabel7.setText("id đơn hàng");

        jLabel8.setText("id sản phẩm");

        jLabel9.setText("Số lượng");

        jLabel10.setText("Đơn giá ");

        jLabel11.setText("Thành tiền");

        jtfidDonHangMua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfidDonHangMuaActionPerformed(evt);
            }
        });

        jtfidSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfidSanPhamActionPerformed(evt);
            }
        });
        jtfidSanPham.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfidSanPhamKeyPressed(evt);
            }
        });

        jtfSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSoLuongActionPerformed(evt);
            }
        });
        jtfSoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfSoLuongKeyPressed(evt);
            }
        });

        jtfDonGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDonGiaActionPerformed(evt);
            }
        });

        jtfThanhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfThanhTienActionPerformed(evt);
            }
        });

        btnThemChiTiet.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\icons8-add-27.png"));
        btnThemChiTiet.setText("Thêm");
        btnThemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemChiTietActionPerformed(evt);
            }
        });

        btnXoaChiTiet.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\icons8-delete-27.png"));
        btnXoaChiTiet.setText("Xóa");
        btnXoaChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaChiTietActionPerformed(evt);
            }
        });

        btnCapNhatChiTiet.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\icons8-update-left-rotation-27.png"));
        btnCapNhatChiTiet.setText("Cập nhật");
        btnCapNhatChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatChiTietActionPerformed(evt);
            }
        });

        btnResetChiTiet.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\clean-icon3.png"));
        btnResetChiTiet.setText("Reset");
        btnResetChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetChiTietActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtbChiTietDonHangMua.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbChiTietDonHangMua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbChiTietDonHangMuaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbChiTietDonHangMua);

        jtbSanPham.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jtbSanPham);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnThemChiTiet)
                                .addGap(54, 54, 54)
                                .addComponent(btnXoaChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(23, 23, 23)
                                .addComponent(jtfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCapNhatChiTiet)
                        .addGap(47, 47, 47)
                        .addComponent(btnResetChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfDonGia, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                    .addComponent(jtfidDonHangMua))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfidSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                    .addComponent(jtfThanhTien))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jtfidDonHangMua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jtfDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfidSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jtfThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemChiTiet)
                    .addComponent(btnXoaChiTiet)
                    .addComponent(btnCapNhatChiTiet)
                    .addComponent(btnResetChiTiet))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtfidNhanVienLapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfidNhanVienLapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfidNhanVienLapActionPerformed

    private void jtfidNguonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfidNguonHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfidNguonHangActionPerformed

    private void jtfidTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfidTrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfidTrangThaiActionPerformed

    private void jtfTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTongTienActionPerformed

    private void jtfTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTimKiemActionPerformed

    private void jtfTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTimKiemKeyReleased
        // TODO add your handling code here:
        try {
            DonHangMuaBUS donHangBUS = new DonHangMuaBUS();
            List<DonHangMua> list = donHangBUS.findDonHangMua(jtfTimKiem.getText());
            initTable();
            for(DonHangMua donHang : list){
                jtbDonHangMuamodel.addRow(new Object[]{
                    donHang.getID(),donHang.getIdNhanVienLap(),donHang.getIdNguonHang(),donHang.getIdTrangThai(),donHang.getNgayLap(),
                    donHang.getTongTien()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Đơn hàng bán không tồn tại" , "Cảnh báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtfTimKiemKeyReleased

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        try {
            DonHangMuaBUS donHangBUS = new DonHangMuaBUS();
            List<DonHangMua> list = donHangBUS.findDonHangMua(jtfTimKiem.getText());

            if(list.isEmpty()){
                JOptionPane.showMessageDialog(this,"Đơn hàng bán không tồn tại" , "Cảnh báo", JOptionPane.ERROR_MESSAGE);
            }
            else{
                for(DonHangMua dh : list){
                    jtfidNhanVienLap.setText(String.valueOf(dh.getIdNhanVienLap()));
                    jtfidNguonHang.setText(String.valueOf(dh.getIdNguonHang()));
                    jtfidTrangThai.setText(String.valueOf(dh.getIdTrangThai()));
                    jdtNgayLap.setDate(dh.getNgayLap());
                    jtfTongTien.setText(String.valueOf(dh.getTongTien()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Đơn hàng bán không tồn tại" , "Cảnh báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        DonHangMua donHang = new DonHangMua();
        try {
            if(jtfidNguonHang.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Nhập lại");
                return;
            }

            donHang = this.donHangUpdate;
            donHang.setIdNhanVienLap(Integer.parseInt(jtfidNhanVienLap.getText()));
            donHang.setIdNguonHang(Integer.parseInt(jtfidNguonHang.getText()));
            donHang.setIdTrangThai(Integer.parseInt(jtfidTrangThai.getText()));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String finddate =  sdf.format(jdtNgayLap.getDate());
            donHang.setNgayLap( Date.valueOf(finddate));
            donHang.setTongTien(Float.parseFloat(jtfTongTien.getText()));

            if(JOptionPane.showConfirmDialog(this, "Bạn có muốn Update không?", "Hỏi"
                , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION){
            return;
        }
        DonHangMuaBUS donHangBUS = new DonHangMuaBUS();
        if(donHangBUS.updateDonHangMua(donHang)>0){
            JOptionPane.showMessageDialog(null, "Update thành công");
            jtfidNhanVienLap.setText("");
            jtfidNguonHang.setText("");
            jtfidTrangThai.setText("");
            jdtNgayLap.cleanup();
            jtfTongTien.setText("");
            loadData();
        }
        else{
            JOptionPane.showMessageDialog(null, "Update thất bại");
        }
        } catch (Exception e) {
            Logger.getLogger(DonHangMuanJFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        try {
            if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?", "Hỏi"
                , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION){
            return;
        }
        DonHangMuaBUS donHangBUS = new DonHangMuaBUS();
        if(donHangBUS.deleteDonHangMua(donHangDelete)){
            JOptionPane.showMessageDialog(null, "Xóa thành công");
            loadData();
        }
        else{
            JOptionPane.showMessageDialog(null, "Xóa thất bại");
        }
        } catch (Exception e) {
            Logger.getLogger(DonHangMuanJFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        DonHangMua donHang = new DonHangMua();
        if(jtfidNhanVienLap.getText().isBlank()|| jtfidNguonHang.getText().isBlank() || jdtNgayLap.getDate()== null
            || jtfidTrangThai.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Không được điền thiếu thông tin nhân viên");
            return;
        }
        try {
            if(jtfidTrangThai.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "nhập lại");
                return;
            }
            donHang.setID(donhangmuaid);
            donHang.setIdNhanVienLap(Integer.parseInt(jtfidNhanVienLap.getText()));
            donHang.setIdNguonHang(Integer.parseInt(jtfidNguonHang.getText()));
            donHang.setIdTrangThai(Integer.parseInt(jtfidTrangThai.getText()));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String finddate =  sdf.format(jdtNgayLap.getDate()).toString();
            donHang.setNgayLap( Date.valueOf(finddate));
            donHang.setTongTien(Float.parseFloat(jtfTongTien.getText()));
            DonHangMuaBUS donHangBUS = new DonHangMuaBUS();
            if(donHangBUS.saveDonHangMua(donHang) > 0){
                JOptionPane.showMessageDialog(this, "Thêm đơn hàng bán thành công");
                jtfidNhanVienLap.setText("");
                jtfidNguonHang.setText("");
                jtfidTrangThai.setText("");
                jdtNgayLap.cleanup();
                jtfTongTien.setText("");
                loadData();
            }
            else{
                JOptionPane.showMessageDialog(this, "Thêm đơn hàng bán thất bại");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Thêm đơn hàng bán thất bại");
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        XuatExcel();
    }//GEN-LAST:event_btnExcelActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        jtfidNhanVienLap.setText("");
        jtfidNguonHang.setText("");
        jtfidTrangThai.setText("");
        jdtNgayLap.cleanup();
        jtfTongTien.setText("");
        loadData();
    }//GEN-LAST:event_btnResetActionPerformed

    private void jtbDonHangMuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbDonHangMuaMouseClicked
        // TODO add your handling code here:
        try {
            int row = jtbDonHangMua.getSelectedRow();
            if(row >= 0){
                int id = (Integer) jtbDonHangMua.getValueAt(row, 0);
                DonHangMuaBUS donHangBUS = new DonHangMuaBUS();
                DonHangMua dh = donHangBUS.getDonHangMua(id);
                donHangUpdate = this.donHangBUS.getDonHangMua(id);
                donHangDelete = this.donHangBUS.getDonHangMua(id);
                if(dh != null){
                    jtfidNhanVienLap.setText(String.valueOf(dh.getIdNhanVienLap()));
                    jtfidNguonHang.setText(String.valueOf(dh.getIdNguonHang()));
                    jtfidTrangThai.setText(String.valueOf(dh.getIdTrangThai()));
                    jdtNgayLap.setDate(dh.getNgayLap());
                    jtfTongTien.setText(String.valueOf(DecimalFormat.format(dh.getTongTien())));

                    ChiTietDonHangMuaBUS chiTietBUS = new ChiTietDonHangMuaBUS();
                    List<ChiTietDonHangMua> listct  = chiTietBUS.LoadChiTietDonHangMua(WIDTH,id);

                    SanPhamBUS sanPhamBUS = new SanPhamBUS();
                    List<SanPham> listsp  = sanPhamBUS.LoadSanPham(WIDTH);

                    jtbChiTietDonHangMuamodel.setRowCount(0);
                    for(ChiTietDonHangMua ctdh : listct){
                        List<String> productNames = new ArrayList<>();
                        for (SanPham sp : listsp) {
                            if (sp.getID() == ctdh.getIdSanPham()) {
                                productNames.add(sp.getTenSanPham());
                            }
                        }
                        if (!productNames.isEmpty()) {
                            String productName = String.join(" ", productNames);
                            jtbChiTietDonHangMuamodel.addRow(new Object[]{
                                ctdh.getId(),ctdh.getIdDonHangMua(),productName,ctdh.getSoLuong(),DecimalFormat.format(ctdh.getDonGiaApDung()),DecimalFormat.format(ctdh.getThanhTien())
                            });
                        }
                    }
                    jtbChiTietDonHangMuamodel.fireTableDataChanged();
                    chitietdonhangmuaid = listct.size() + 1;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtbDonHangMuaMouseClicked

    private void jtfidDonHangMuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfidDonHangMuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfidDonHangMuaActionPerformed

    private void jtfidSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfidSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfidSanPhamActionPerformed

    private void jtfidSanPhamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfidSanPhamKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            try {
                ChiTietDonHangMuaBUS ctdhbbus = new ChiTietDonHangMuaBUS();
                ChiTietDonHangMua ctdhb = ctdhbbus.getIDSanPham(Integer.parseInt(""+jtfidSanPham.getText()));
                if(ctdhb.getDonGiaApDung() == 0 ){
                    JOptionPane.showMessageDialog(this, "Sản phẩm không tồn tại");
                }
                jtfDonGia.setText(""+DecimalFormat.format(ctdhb.getDonGiaApDung()));
                jtfThanhTien.setText(""+DecimalFormat.format(ctdhb.getDonGiaApDung() * Integer.parseInt(jtfSoLuong.getText()) ) );
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lỗi");
            }
        }
    }//GEN-LAST:event_jtfidSanPhamKeyPressed

    private void jtfSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfSoLuongActionPerformed

    private void jtfSoLuongKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSoLuongKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            try {
                ChiTietDonHangMuaBUS ctdhbbus = new ChiTietDonHangMuaBUS();
                ChiTietDonHangMua ctdhb = ctdhbbus.getIDSanPham(Integer.parseInt(""+jtfidSanPham.getText()));
                if(ctdhb.getDonGiaApDung() == 0 ){
                    JOptionPane.showMessageDialog(this, "Sản phẩm không tồn tại");
                }
                jtfDonGia.setText(""+DecimalFormat.format(ctdhb.getDonGiaApDung()));
                jtfThanhTien.setText(""+DecimalFormat.format(ctdhb.getDonGiaApDung() * Integer.parseInt(jtfSoLuong.getText()) ) );
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lỗi");
            }
        }
    }//GEN-LAST:event_jtfSoLuongKeyPressed

    private void jtfDonGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDonGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDonGiaActionPerformed

    private void jtfThanhTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfThanhTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfThanhTienActionPerformed

    private void jtbChiTietDonHangMuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbChiTietDonHangMuaMouseClicked
        // TODO add your handling code here:
        try {
            int row = jtbChiTietDonHangMua.getSelectedRow();
            if(row >= 0){
                int id = (Integer) jtbChiTietDonHangMua.getValueAt(row, 0);
                ChiTietDonHangMuaBUS chiTietBUS = new ChiTietDonHangMuaBUS();
                ChiTietDonHangMua dh = chiTietBUS.getChiTietDonHangMua(id);
                chiTietUpdate = this.chiTietBUS.getChiTietDonHangMua(id);
                chiTietDelete = this.chiTietBUS.getChiTietDonHangMua(id);
                if(dh != null){
                    jtfidDonHangMua.setText(String.valueOf(dh.getIdDonHangMua()));
                    jtfidSanPham.setText(String.valueOf(dh.getIdSanPham()));
                    jtfSoLuong.setText(String.valueOf(dh.getSoLuong()));
                    jtfDonGia.setText(String.valueOf(DecimalFormat.format(dh.getDonGiaApDung())));
                    jtfThanhTien.setText(String.valueOf(DecimalFormat.format(dh.getThanhTien())));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtbChiTietDonHangMuaMouseClicked

    private void btnThemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemChiTietActionPerformed
        // TODO add your handling code here:
        ChiTietDonHangMua chiTiet = new ChiTietDonHangMua();
        if(jtfidDonHangMua.getText().isBlank()|| jtfidSanPham.getText().isBlank()|| jtfSoLuong.getText().isBlank()
            || jtfDonGia.getText().isBlank() || jtfThanhTien.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Không được điền thiếu thông tin chi tiết hóa đơn");
            return;
        }
        try {
            if(jtfidDonHangMua.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "nhập lại");
                return;
            }
            chiTiet.setId(chitietdonhangmuaid);
            chiTiet.setIdDonHangMua(Integer.parseInt(jtfidDonHangMua.getText()));
            chiTiet.setIdSanPham(Integer.parseInt(jtfidSanPham.getText()));
            chiTiet.setSoLuong(Integer.parseInt(jtfSoLuong.getText()));
            chiTiet.setDonGiaApDung(Float.parseFloat(jtfDonGia.getText()));
            chiTiet.setThanhTien(Float.parseFloat(jtfThanhTien.getText()));
            ChiTietDonHangMuaBUS chiTietBUS = new ChiTietDonHangMuaBUS();
            if(chiTietBUS.saveChiTietDonHangMua(chiTiet) > 0){
                JOptionPane.showMessageDialog(this, "Thêm chi tiết thành công");
                jtfidDonHangMua.setText("");
                jtfidSanPham.setText("");
                jtfSoLuong.setText("");
                jtfDonGia.setText("");
                jtfThanhTien.setText("");
                loadData();
            }
            else{
                JOptionPane.showMessageDialog(this, "Thêm chi tiết thất bại");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Thêm chi tiết thất bại");
        }
    }//GEN-LAST:event_btnThemChiTietActionPerformed

    private void btnXoaChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaChiTietActionPerformed
        // TODO add your handling code here:
        try {
            if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?", "Hỏi"
                , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION){
            return;
        }
        ChiTietDonHangMuaBUS chiTietBUS = new ChiTietDonHangMuaBUS();
        if(chiTietBUS.deleteChiTietDonHangMua(chiTietDelete)){
            JOptionPane.showMessageDialog(null, "Xóa thành công");
            loadData();
        }
        else{
            JOptionPane.showMessageDialog(null, "Xóa thất bại");
        }
        } catch (Exception e) {
            Logger.getLogger(DonHangMuanJFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnXoaChiTietActionPerformed

    private void btnCapNhatChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatChiTietActionPerformed
        // TODO add your handling code here:
        ChiTietDonHangMua chiTiet = new ChiTietDonHangMua();
        try {
            if(jtfidDonHangMua.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Nhập lại");
                return;
            }

            chiTiet = this.chiTietUpdate;
            chiTiet.setIdDonHangMua(Integer.parseInt(jtfidDonHangMua.getText()));
            chiTiet.setIdSanPham(Integer.parseInt(jtfidSanPham.getText()));
            chiTiet.setSoLuong(Integer.parseInt(jtfSoLuong.getText()));
            chiTiet.setDonGiaApDung(Double.parseDouble(jtfDonGia.getText()));
            chiTiet.setThanhTien(Double.parseDouble(jtfThanhTien.getText()));

            if(JOptionPane.showConfirmDialog(this, "Bạn có muốn Update không?", "Hỏi"
                , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION){
            return;
        }
        ChiTietDonHangMuaBUS chiTietBUS = new ChiTietDonHangMuaBUS();
        if(chiTietBUS.updateChiTietDonHangMua(chiTiet)>0){
            JOptionPane.showMessageDialog(null, "Update thành công");
            jtfidDonHangMua.setText("");
            jtfidSanPham.setText("");
            jtfSoLuong.setText("");
            jtfDonGia.setText("");
            jtfThanhTien.setText("");
            chiTietBUS.updateTongTien(Integer.parseInt(jtfidDonHangMua.getText()));
            loadData();
        }
        else{
            JOptionPane.showMessageDialog(null, "Update thất bại");
        }
        } catch (Exception e) {
            Logger.getLogger(DonHangMuanJFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnCapNhatChiTietActionPerformed

    private void btnResetChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetChiTietActionPerformed
        // TODO add your handling code here:
        jtfidDonHangMua.setText("");
        jtfidSanPham.setText("");
        jtfSoLuong.setText("");
        jtfDonGia.setText("");
        jtfThanhTien.setText("");
        loadData();
    }//GEN-LAST:event_btnResetChiTietActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnCapNhatChiTiet;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnResetChiTiet;
    private javax.swing.JButton btnThemChiTiet;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaChiTiet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.calendar.JDateChooser jdtNgayLap;
    private javax.swing.JTable jtbChiTietDonHangMua;
    private javax.swing.JTable jtbDonHangMua;
    private javax.swing.JTable jtbSanPham;
    private javax.swing.JTextField jtfDonGia;
    private javax.swing.JTextField jtfSoLuong;
    private javax.swing.JTextField jtfThanhTien;
    private javax.swing.JTextField jtfTimKiem;
    private javax.swing.JTextField jtfTongTien;
    private javax.swing.JTextField jtfidDonHangMua;
    private javax.swing.JTextField jtfidNguonHang;
    private javax.swing.JTextField jtfidNhanVienLap;
    private javax.swing.JTextField jtfidSanPham;
    private javax.swing.JTextField jtfidTrangThai;
    // End of variables declaration//GEN-END:variables
}
