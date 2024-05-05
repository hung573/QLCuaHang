/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;
import DTO.DonHangBan;
import DTO.ChiTietDonHangBan;
import DAO.*;
import BUS.*;
import DTO.KhachHang;
import DTO.NhanVien;
import DTO.SanPham;
import DTO.TrangThaiBan;
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
public class DonHangBanJPanel extends javax.swing.JPanel {
    private DefaultTableModel jtbDonHangBanmodel;
    private  DonHangBanBUS donHangBUS = new DonHangBanBUS();
    private DonHangBan donHangUpdate = new DonHangBan();
    private DonHangBan donHangDelete = new DonHangBan();
    private int donhangbanid;
    private float tongtien = 0;
    private float thanhtientruoc=0;
    private float thanhtiensau=0;
    
    private DefaultTableModel jtbChiTietDonHangBanmodel;
    private  ChiTietDonHangBanBUS chiTietBUS = new ChiTietDonHangBanBUS();
    private ChiTietDonHangBan chiTietUpdate = new ChiTietDonHangBan();
    private ChiTietDonHangBan chiTietDelete = new ChiTietDonHangBan();
    private int chitietdonhangbanid;
    
    private DefaultTableModel jtbSanPhammodel;
    
    DecimalFormat DecimalFormat = new DecimalFormat("#");
    /**
     * Creates new form DonHangBanJPanel
     */
    public DonHangBanJPanel() {
        initComponents();
        initTable();
        loadData(); 
        jtfTongTien.setText("0");
        loadDataSanPham();
    }
    private void initTable(){
        jtbDonHangBanmodel = new DefaultTableModel();
        jtbDonHangBanmodel.setColumnIdentifiers(new String[] {"ID","idNhanVien","TenKhachHang","idTrangThai","TenTrangThai","NgayLap","TongTien"});
        jtbDonHangBan.setModel(jtbDonHangBanmodel);
        
        jtbChiTietDonHangBanmodel = new DefaultTableModel();
        jtbChiTietDonHangBanmodel.setColumnIdentifiers(new String[] {"ID","idDonHangBan","TenSanPham","SoLuong","DonGiaApDung","ThanhTien"});
        jtbChiTietDonHangBan.setModel(jtbChiTietDonHangBanmodel);
        
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
            DonHangBanBUS donHangBanBUS = new DonHangBanBUS();
            List<DonHangBan> list = donHangBanBUS.LoadDonHangBan(WIDTH);

            KhachHangBUS khachHangBUS = new KhachHangBUS();
            List<KhachHang> listkh = khachHangBUS.LoadKhachHang(WIDTH);

            TrangThaiBanBUS trangThaiBUS = new TrangThaiBanBUS();
            List<TrangThaiBan> listtt = trangThaiBUS.LoadTrangThaiBan(WIDTH);
            
            
            jtbDonHangBanmodel.setRowCount(0);
            for (DonHangBan dh : list) {
                List<String> customerNames = new ArrayList<>();
                List<String> trangThaiBan = new ArrayList<>();
                // Find all customers with the same ID as the current order's customer ID
                for (KhachHang kh : listkh) {
                    if (kh.getID() == dh.getIdKhachHang()) {
                        customerNames.add(kh.getTenKhachHang());
                    }
                }
                for (TrangThaiBan tt : listtt) {
                    if (tt.getID() == dh.getIdTrangThai()) {
                        trangThaiBan.add(tt.getTenTrangThai());
                    }
                }

                // Add the customer names and order details to the table
                if (!customerNames.isEmpty() || !trangThaiBan.isEmpty()) {
                    String customerName = String.join(" ", customerNames);
                    String statusName = String.join(" ", trangThaiBan);
                    jtbDonHangBanmodel.addRow(new Object[]{
                        dh.getID(), dh.getIdNhanVienLap(),customerName,dh.getIdTrangThai(), statusName, dh.getNgayLap(), DecimalFormat.format(dh.getTongTien())
                    });
                }
                
            }
            jtbDonHangBanmodel.fireTableDataChanged();
            donhangbanid = list.size() + 1;
            
//            ChiTietDonHangBanBUS chiTietBUS = new ChiTietDonHangBanBUS();
//            List<ChiTietDonHangBan> listct  = chiTietBUS.LoadChiTietDonHangBan(WIDTH);
//            
//            SanPhamBUS sanPhamBUS = new SanPhamBUS();
//            List<SanPham> listsp  = sanPhamBUS.LoadSanPham(WIDTH);
//            
//            jtbChiTietDonHangBanmodel.setRowCount(0);
//            for(ChiTietDonHangBan dh : listct){
//                 List<String> productNames = new ArrayList<>();
//                 for (SanPham sp : listsp) {
//                    if (sp.getID() == dh.getIdSanPham()) {
//                        productNames.add(sp.getTenSanPham());
//                    }
//                }
//                if (!productNames.isEmpty()) {
//                    String productName = String.join(" ", productNames);
//                    jtbChiTietDonHangBanmodel.addRow(new Object[]{
//                        dh.getId(),dh.getIdDonHangBan(),productName,dh.getSoLuong(),DecimalFormat.format(dh.getDonGiaApDung()),DecimalFormat.format(dh.getThanhTien())
//                    });
//                }
//            }
//            jtbChiTietDonHangBanmodel.fireTableDataChanged();
//            chitietdonhangbanid = list.size() + 1;
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
            for (int i = 0; i < jtbChiTietDonHangBan.getRowCount(); i++){
                row = excelSheet.createRow((short) 4 + i);
                row.setHeight((short) 400);
                for (int j = 0; j < jtbChiTietDonHangBan.getColumnCount(); j++){
                    row.createCell(j).setCellValue(jtbChiTietDonHangBan.getValueAt(i, j).toString());
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
        jtfidKhachHang = new javax.swing.JTextField();
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
        jtbDonHangBan = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtfidDonHangBan = new javax.swing.JTextField();
        jtfidSanPham = new javax.swing.JTextField();
        jtfSoLuong = new javax.swing.JTextField();
        jtfDonGia = new javax.swing.JTextField();
        jtfThanhTien = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbChiTietDonHangBan = new javax.swing.JTable();
        btnThemChiTiet = new javax.swing.JButton();
        btnXoaChiTiet = new javax.swing.JButton();
        btnCapNhatChiTiet = new javax.swing.JButton();
        btnResetChiTiet = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbSanPham = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 255, 204));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa Đơn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(204, 0, 204))); // NOI18N
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

        jtfidKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfidKhachHangActionPerformed(evt);
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

        jtbDonHangBan.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbDonHangBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbDonHangBanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbDonHangBan);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jtfidTrangThai))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jtfTongTien)
                                            .addComponent(jdtNgayLap, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                            .addComponent(jtfidKhachHang)
                                            .addComponent(jtfidNhanVienLap))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jtfTimKiem)
                                .addGap(18, 18, 18)
                                .addComponent(btnTimKiem))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnLuu)
                                .addGap(63, 63, 63)
                                .addComponent(btnCapNhat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnXoa)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                        .addComponent(btnExcel)
                        .addGap(69, 69, 69))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfidNhanVienLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtfidKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfidTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoa)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLuu)
                        .addComponent(btnCapNhat)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset)
                    .addComponent(btnExcel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

        jtfidDonHangBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfidDonHangBanActionPerformed(evt);
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

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtbChiTietDonHangBan.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbChiTietDonHangBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbChiTietDonHangBanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbChiTietDonHangBan);

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

        btnCapNhatChiTiet.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\icons8-update-left-rotation-27.png")
        );
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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(23, 23, 23)
                                .addComponent(jtfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtfidDonHangBan, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtfidSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnThemChiTiet)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoaChiTiet)
                                .addGap(18, 18, 18)
                                .addComponent(btnCapNhatChiTiet)
                                .addGap(18, 18, 18)
                                .addComponent(btnResetChiTiet)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtfidDonHangBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfidSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jtfThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jtfDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemChiTiet)
                    .addComponent(btnXoaChiTiet)
                    .addComponent(btnCapNhatChiTiet)
                    .addComponent(btnResetChiTiet))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtfidNhanVienLapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfidNhanVienLapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfidNhanVienLapActionPerformed

    private void jtfidKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfidKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfidKhachHangActionPerformed

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
            DonHangBanBUS donHangBUS = new DonHangBanBUS();
            List<DonHangBan> list = donHangBUS.findDonHangBan(jtfTimKiem.getText());
            
            KhachHangBUS khachHangBUS = new KhachHangBUS();
            List<KhachHang> listkh = khachHangBUS.LoadKhachHang(WIDTH);

            TrangThaiBanBUS trangThaiBUS = new TrangThaiBanBUS();
            List<TrangThaiBan> listtt = trangThaiBUS.LoadTrangThaiBan(WIDTH);
            initTable();
            for(DonHangBan donHang : list){
                List<String> customerNames = new ArrayList<>();
                List<String> trangThaiBan = new ArrayList<>();
                // Find all customers with the same ID as the current order's customer ID
                for (KhachHang kh : listkh) {
                    if (kh.getID() == donHang.getIdKhachHang()) {
                        customerNames.add(kh.getTenKhachHang());
                    }
                }
                for (TrangThaiBan tt : listtt) {
                    if (tt.getID() == donHang.getIdTrangThai()) {
                        trangThaiBan.add(tt.getTenTrangThai());
                    }
                }
                String customerName = String.join(" ", customerNames);
                String statusName = String.join(" ", trangThaiBan);
                jtbDonHangBanmodel.addRow(new Object[]{
                    donHang.getID(), donHang.getIdNhanVienLap(),customerName,donHang.getIdTrangThai(), statusName, donHang.getNgayLap(), DecimalFormat.format(donHang.getTongTien())
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
            DonHangBanBUS donHangBUS = new DonHangBanBUS();
            List<DonHangBan> list = donHangBUS.findDonHangBan(jtfTimKiem.getText());

            if(list.isEmpty()){
                JOptionPane.showMessageDialog(this,"Đơn hàng bán không tồn tại" , "Cảnh báo", JOptionPane.ERROR_MESSAGE);
            }
            else{
                for(DonHangBan dh : list){
                    jtfidNhanVienLap.setText(String.valueOf(dh.getIdNhanVienLap()));
                    jtfidKhachHang.setText(String.valueOf(dh.getIdKhachHang()));
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
        DonHangBan donHang = new DonHangBan();
        try {
            if(jtfidKhachHang.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Nhập lại");
                return;
            }

            donHang = this.donHangUpdate;
            donHang.setIdNhanVienLap(Integer.parseInt(jtfidNhanVienLap.getText()));
            donHang.setIdKhachHang(Integer.parseInt(jtfidKhachHang.getText()));
            donHang.setIdTrangThai(Integer.parseInt(jtfidTrangThai.getText()));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String finddate =  sdf.format(jdtNgayLap.getDate());
            donHang.setNgayLap( Date.valueOf(finddate));
            donHang.setTongTien(Float.parseFloat(jtfTongTien.getText()));

            if(JOptionPane.showConfirmDialog(this, "Bạn có muốn Update không?", "Hỏi"
                , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION){
            return;
        }
        DonHangBanBUS donHangBUS = new DonHangBanBUS();
        if(donHangBUS.updateDonHangBan(donHang)>0){
            JOptionPane.showMessageDialog(null, "Update thành công");
            jtfidNhanVienLap.setText("");
            jtfidKhachHang.setText("");
            jtfidTrangThai.setText("");
            jdtNgayLap.cleanup();
            jtfTongTien.setText("");
            loadData();
        }
        else{
            JOptionPane.showMessageDialog(null, "Update thất bại");
        }
        } catch (Exception e) {
            Logger.getLogger(DonHangBanJFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        try {
            if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?", "Hỏi"
                , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION){
            return;
        }
        DonHangBanBUS donHangBUS = new DonHangBanBUS();
        if(donHangBUS.deleteDonHangBan(donHangDelete)){
            JOptionPane.showMessageDialog(null, "Xóa thành công");
            loadData();
        }
        else{
            JOptionPane.showMessageDialog(null, "Xóa thất bại");
        }
        } catch (Exception e) {
            Logger.getLogger(DonHangBanJFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        DonHangBan donHang = new DonHangBan();
        if(jtfidNhanVienLap.getText().isBlank()|| jtfidKhachHang.getText().isBlank() || jdtNgayLap.getDate()== null
            || jtfidTrangThai.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Không được điền thiếu thông tin nhân viên");
            return;
        }
        try {
            if(jtfidTrangThai.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "nhập lại");
                return;
            }
            donHang.setID(donhangbanid);
            donHang.setIdNhanVienLap(Integer.parseInt(jtfidNhanVienLap.getText()));
            donHang.setIdKhachHang(Integer.parseInt(jtfidKhachHang.getText()));
            donHang.setIdTrangThai(Integer.parseInt(jtfidTrangThai.getText()));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String finddate =  sdf.format(jdtNgayLap.getDate()).toString();
            donHang.setNgayLap( Date.valueOf(finddate));
            donHang.setTongTien(Float.parseFloat(jtfTongTien.getText()));
            DonHangBanBUS donHangBUS = new DonHangBanBUS();
            if(donHangBUS.saveDonHangBan(donHang) > 0){
                JOptionPane.showMessageDialog(this, "Thêm đơn hàng bán thành công");
                jtfidNhanVienLap.setText("");
                jtfidKhachHang.setText("");
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
        jtfidKhachHang.setText("");
        jtfidTrangThai.setText("");
        jdtNgayLap.cleanup();
        jtfTongTien.setText("");
        loadData();
    }//GEN-LAST:event_btnResetActionPerformed

    private void jtbDonHangBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbDonHangBanMouseClicked
        // TODO add your handling code here:
        try {
            int row = jtbDonHangBan.getSelectedRow();
            if(row >= 0){
                int id = (Integer) jtbDonHangBan.getValueAt(row, 0);
                DonHangBanBUS donHangBUS = new DonHangBanBUS();
                DonHangBan dh = donHangBUS.getDonHangBan(id);
                donHangUpdate = this.donHangBUS.getDonHangBan(id);
                donHangDelete = this.donHangBUS.getDonHangBan(id);
                if(dh != null){
                    jtfidNhanVienLap.setText(String.valueOf(dh.getIdNhanVienLap()));
                    jtfidKhachHang.setText(String.valueOf(dh.getIdKhachHang()));
                    jtfidTrangThai.setText(String.valueOf(dh.getIdTrangThai()));
                    jdtNgayLap.setDate(dh.getNgayLap());
                    jtfTongTien.setText(String.valueOf(DecimalFormat.format(dh.getTongTien())));

                    ChiTietDonHangBanBUS chiTietBUS = new ChiTietDonHangBanBUS();
                    List<ChiTietDonHangBan> listct  = chiTietBUS.LoadChiTietDonHangBan(WIDTH,id);

                    SanPhamBUS sanPhamBUS = new SanPhamBUS();
                    List<SanPham> listsp  = sanPhamBUS.LoadSanPham(WIDTH);

                    jtbChiTietDonHangBanmodel.setRowCount(0);
                    for(ChiTietDonHangBan ctdh : listct){
                        List<String> productNames = new ArrayList<>();
                        for (SanPham sp : listsp) {
                            if (sp.getID() == ctdh.getIdSanPham()) {
                                productNames.add(sp.getTenSanPham());
                            }
                        }
                        if (!productNames.isEmpty()) {
                            String productName = String.join(" ", productNames);
                            jtbChiTietDonHangBanmodel.addRow(new Object[]{
                                ctdh.getId(),ctdh.getIdDonHangBan(),productName,ctdh.getSoLuong(),DecimalFormat.format(ctdh.getDonGiaApDung()),DecimalFormat.format(ctdh.getThanhTien())
                            });
                        }
                    }
                    jtbChiTietDonHangBanmodel.fireTableDataChanged();
                    chitietdonhangbanid = listct.size() + 1;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtbDonHangBanMouseClicked

    private void jtfidDonHangBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfidDonHangBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfidDonHangBanActionPerformed

    private void jtfidSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfidSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfidSanPhamActionPerformed

    private void jtfidSanPhamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfidSanPhamKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            try {
                ChiTietDonHangBanBUS ctdhbbus = new ChiTietDonHangBanBUS();
                ChiTietDonHangBan ctdhb = ctdhbbus.getIDSanPham(Integer.parseInt(""+jtfidSanPham.getText()));
                if(ctdhb.getDonGiaApDung() == 0 ){
                    JOptionPane.showMessageDialog(this, "Sản phẩm không tồn tại");
                }
                jtfDonGia.setText(""+DecimalFormat.format(ctdhb.getDonGiaApDung()));
                jtfThanhTien.setText(DecimalFormat.format(ctdhb.getDonGiaApDung() * Integer.parseInt(jtfSoLuong.getText()) ) );
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
                ChiTietDonHangBanBUS ctdhbbus = new ChiTietDonHangBanBUS();
                ChiTietDonHangBan ctdhb = ctdhbbus.getIDSanPham(Integer.parseInt(""+jtfidSanPham.getText()));
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

    private void jtbChiTietDonHangBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbChiTietDonHangBanMouseClicked
        // TODO add your handling code here:
        try {
            int row = jtbChiTietDonHangBan.getSelectedRow();
            if(row >= 0){
                int id = (Integer) jtbChiTietDonHangBan.getValueAt(row, 0);
                ChiTietDonHangBanBUS chiTietBUS = new ChiTietDonHangBanBUS();
                ChiTietDonHangBan dh = chiTietBUS.getChiTietDonHangBan(id);
                chiTietUpdate = this.chiTietBUS.getChiTietDonHangBan(id);
                chiTietDelete = this.chiTietBUS.getChiTietDonHangBan(id);
                if(dh != null){
                    jtfidDonHangBan.setText(String.valueOf(dh.getIdDonHangBan()));
                    jtfidSanPham.setText(String.valueOf(dh.getIdSanPham()));
                    jtfSoLuong.setText(String.valueOf(dh.getSoLuong()));
                    jtfDonGia.setText(String.valueOf(DecimalFormat.format(dh.getDonGiaApDung())));
                    jtfThanhTien.setText(String.valueOf(DecimalFormat.format(dh.getThanhTien())));
                    
                }
                //thanhtientruoc = (float) dh.getThanhTien() ;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtbChiTietDonHangBanMouseClicked

    private void btnThemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemChiTietActionPerformed
        // TODO add your handling code here:
        ChiTietDonHangBan chiTiet = new ChiTietDonHangBan();
        if(jtfidDonHangBan.getText().isBlank()|| jtfidSanPham.getText().isBlank()|| jtfSoLuong.getText().isBlank()
            || jtfDonGia.getText().isBlank() || jtfThanhTien.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Không được điền thiếu thông tin chi tiết hóa đơn");
            return;
        }
        try {
            tongtien = Float.parseFloat(jtfThanhTien.getText().toString()) + tongtien;  
            if(jtfidDonHangBan.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "nhập lại");
                return;
            }
            chiTiet.setId(chitietdonhangbanid);
            chiTiet.setIdDonHangBan(Integer.parseInt(jtfidDonHangBan.getText()));
            chiTiet.setIdSanPham(Integer.parseInt(jtfidSanPham.getText()));
            chiTiet.setSoLuong(Integer.parseInt(jtfSoLuong.getText()));
            chiTiet.setDonGiaApDung(Float.parseFloat(jtfDonGia.getText()));
            chiTiet.setThanhTien(Float.parseFloat(jtfThanhTien.getText()));
            ChiTietDonHangBanBUS chiTietBUS = new ChiTietDonHangBanBUS();
            if(chiTietBUS.saveChiTietDonHangBan(chiTiet) > 0){
                JOptionPane.showMessageDialog(this, "Thêm chi tiết thành công");
                jtfidDonHangBan.setText("");
                jtfidSanPham.setText("");
                jtfSoLuong.setText("");
                jtfDonGia.setText("");
                jtfThanhTien.setText("");
                jtbChiTietDonHangBanmodel = new DefaultTableModel();
                jtbChiTietDonHangBanmodel.setColumnIdentifiers(new String[] {"ID","idDonHangBan","TenSanPham","SoLuong","DonGiaApDung","ThanhTien"});
                jtbChiTietDonHangBan.setModel(jtbChiTietDonHangBanmodel);
                jtfTongTien.setText(""+DecimalFormat.format(tongtien));
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
            //tongtien = Float.parseFloat(jtfTongTien.getText());
        //tongtien = tongtien - Float.parseFloat(jtfThanhTien.getText());
        ChiTietDonHangBanBUS chiTietBUS = new ChiTietDonHangBanBUS();
        if(chiTietBUS.deleteChiTietDonHangBan(chiTietDelete)){
            JOptionPane.showMessageDialog(null, "Xóa thành công");
            //jtfTongTien.setText(""+DecimalFormat.format(tongtien));
            loadData();
        }
        else{
            JOptionPane.showMessageDialog(null, "Xóa thất bại");
        }
        } catch (Exception e) {
            Logger.getLogger(DonHangBanJFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnXoaChiTietActionPerformed

    private void btnCapNhatChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatChiTietActionPerformed
        // TODO add your handling code here:
        ChiTietDonHangBan chiTiet = new ChiTietDonHangBan();
        try {
            if(jtfidDonHangBan.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Nhập lại");
                return;
            }
            tongtien = Float.parseFloat(jtfTongTien.getText());
            
            thanhtiensau = Float.parseFloat(jtfThanhTien.getText());
            tongtien = (thanhtiensau-thanhtientruoc)+tongtien;
            chiTiet = this.chiTietUpdate;
            chiTiet.setIdDonHangBan(Integer.parseInt(jtfidDonHangBan.getText()));
            chiTiet.setIdSanPham(Integer.parseInt(jtfidSanPham.getText()));
            chiTiet.setSoLuong(Integer.parseInt(jtfSoLuong.getText()));
            chiTiet.setDonGiaApDung(Double.parseDouble(jtfDonGia.getText()));
            chiTiet.setThanhTien(Double.parseDouble(jtfThanhTien.getText()));

            if(JOptionPane.showConfirmDialog(this, "Bạn có muốn Update không?", "Hỏi"
                , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION){
            return;
        }
        ChiTietDonHangBanBUS chiTietBUS = new ChiTietDonHangBanBUS();
        if(chiTietBUS.updateChiTietDonHangBan(chiTiet)>0){
            JOptionPane.showMessageDialog(null, "Update thành công");
            jtfidDonHangBan.setText("");
            jtfidSanPham.setText("");
            jtfSoLuong.setText("");
            jtfDonGia.setText("");
            jtfThanhTien.setText("");
            chiTietBUS.updateTongTien(Integer.parseInt(jtfidDonHangBan.getText()));
            jtbChiTietDonHangBanmodel = new DefaultTableModel();
        jtbChiTietDonHangBanmodel.setColumnIdentifiers(new String[] {"ID","idDonHangBan","TenSanPham","SoLuong","DonGiaApDung","ThanhTien"});
        jtbChiTietDonHangBan.setModel(jtbChiTietDonHangBanmodel);
        jtfTongTien.setText(""+DecimalFormat.format(tongtien));
            loadData();
        }
        else{
            JOptionPane.showMessageDialog(null, "Update thất bại");
        }
        } catch (Exception e) {
            Logger.getLogger(DonHangBanJFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnCapNhatChiTietActionPerformed

    private void btnResetChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetChiTietActionPerformed
        // TODO add your handling code here:
        jtfidDonHangBan.setText("");
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
    private javax.swing.JTable jtbChiTietDonHangBan;
    private javax.swing.JTable jtbDonHangBan;
    private javax.swing.JTable jtbSanPham;
    private javax.swing.JTextField jtfDonGia;
    private javax.swing.JTextField jtfSoLuong;
    private javax.swing.JTextField jtfThanhTien;
    private javax.swing.JTextField jtfTimKiem;
    private javax.swing.JTextField jtfTongTien;
    private javax.swing.JTextField jtfidDonHangBan;
    private javax.swing.JTextField jtfidKhachHang;
    private javax.swing.JTextField jtfidNhanVienLap;
    private javax.swing.JTextField jtfidSanPham;
    private javax.swing.JTextField jtfidTrangThai;
    // End of variables declaration//GEN-END:variables
}
