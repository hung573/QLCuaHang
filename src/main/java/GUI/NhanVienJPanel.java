/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;
import DTO.NhanVien;
import DAO.*;
import BUS.*;
import DTO.TaikhoanNhanvien;
import java.awt.Color;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Image;
import static java.awt.image.ImageObserver.WIDTH;
import java.beans.Customizer;
import java.io.File;
import java.nio.file.Files;
import java.sql.Date;
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author tranconghung
 */
public class NhanVienJPanel extends javax.swing.JPanel {

    /**
     * Creates new form NhanVienJPanel
     */
    public NhanVienJPanel() {
        initComponents();
        initTable();
        loadData();
        initTableTaiKhoanNhanVien();
        LoadTableTaiKhoanNhanVien();
    }
    private DefaultTableModel jtbNhanVienmodel;
    private  NhanVienBUS nhanVienBUS = new NhanVienBUS();
    private NhanVien nhanVienUpdate = new NhanVien();
    private NhanVien nhanVienDelete = new NhanVien();
    private int nhanvienid;
    private DefaultTableModel jtbtaikhoannhanvienModel;
    private  int idTaikhoanNV;
    private TaikhoanNhanvien taikhoanNhanvienUpdate = new TaikhoanNhanvien();
    private TaikhoanNhanvien taikhoanNhanvienDelete = new TaikhoanNhanvien();
    private File file;
    /**
     * Creates new form NhanVienJFrame
     */
    

    private void initTable(){
        jtbNhanVienmodel = new DefaultTableModel();
        jtbNhanVienmodel.setColumnIdentifiers(new String[] {"ID","TenNhanVien","GioiTinh","NgaySinh","SoDienThoai","Email","DiaChi"});
        jtbNhanVien.setModel(jtbNhanVienmodel);
    }
    private void loadData(){
        try {
            NhanVienBUS nhanVienBUS = new NhanVienBUS();
            List<NhanVien> list  = nhanVienBUS.LoadNhanVien(WIDTH);
            jtbNhanVienmodel.setRowCount(0);
            for(NhanVien nv : list){
                jtbNhanVienmodel.addRow(new Object[]{
                    nv.getID(),nv.getTenNhanVien(),nv.getGioiTinh(),nv.getNgaySinh(),nv.getSoDienThoai(),nv.getEmail(),nv.getDiaChi()
                });
            }
            jtbNhanVienmodel.fireTableDataChanged();
            nhanvienid = list.size() + 1;
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    private boolean Email(){
          String Email;
          Email = jtfEmailNhanvien.getText();
          String check = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
          if(!Email.matches(check)){
             return false;
          }else{
            return true;
          }
          
      }
     public void initTableTaiKhoanNhanVien(){
        jtbtaikhoannhanvienModel = new DefaultTableModel();
        jtbtaikhoannhanvienModel.setColumnIdentifiers(new String[]{"Ảnh đại diện","Tên đăng nhập","Mã nhân viên","Mật khẩu","Trạng thái"});
        jtbTaikhoanNhanvien.setModel(jtbtaikhoannhanvienModel);
        jtbTaikhoanNhanvien.getTableHeader().setReorderingAllowed(false);
        jtbTaikhoanNhanvien.getColumnModel().getColumn(0).setCellRenderer(new ImageRender());
        jtbTaikhoanNhanvien.setRowHeight(150);
    }
      private class ImageRender extends DefaultTableCellRenderer{
         @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
            byte[] bytes = (byte[]) value;
            ImageIcon imageicon =  new ImageIcon(new ImageIcon(bytes).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
            setIcon(imageicon);
            return this;
        }
    }
    public void LoadTableTaiKhoanNhanVien(){
        try {
            TaiKhoanNhanVienBUS taiKhoanNhanVienBUS = new TaiKhoanNhanVienBUS();
            List<TaikhoanNhanvien> list = taiKhoanNhanVienBUS.LoadTaiKhoanNhanVien(WIDTH);
            jtbtaikhoannhanvienModel.setRowCount(0);
            for(TaikhoanNhanvien tk : list){
                jtbtaikhoannhanvienModel.addRow(new Object[]{
                    tk.getAnhDaiDien(),tk.getTenDangNhap(),tk.getID(),tk.getMatKhau(),tk.getTrangThai()
                });
            }
            jtbtaikhoannhanvienModel.fireTableDataChanged();
//            idTaikhoanNV = list.size() + 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private boolean checkIdNhanvien() throws HeadlessException{
        StringBuilder bd = new StringBuilder();
        if(jtfManv.getText().equals("")){
            bd.append("Mã nhân viên không được để tróng");
        }
        if(bd.length() > 0){
            JOptionPane.showMessageDialog(this, bd, "Cảnh báo", JOptionPane.ERROR_MESSAGE);
            jtfManv.setBackground(Color.red);
            return true;
        }
        return false;
    }
    private String getSex(){
        String sexs = "";
        if(cbNam.isSelected()){
            sexs += cbNam.getText();
        }
        if(cbNu.isSelected()){
            sexs += cbNu.getText();
        }
        return sexs;
    }
    private void CbSelected(String sex){
        if(sex.equals("Nam")){
            cbNam.setSelected(true);
        }
        if(sex.equals("Nữ")){
            cbNu.setSelected(true);
        }
    }
    private void CbSelectreset(){
        cbNam.setSelected(false);
        cbNu.setSelected(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfHovaTenNhanvien = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfSdtNhanvien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfEmailNhanvien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfDiachiNhanvien = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jdtNgaySinh = new com.toedter.calendar.JDateChooser();
        jtfTimkiem = new javax.swing.JTextField();
        btnTimkiem = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbNhanVien = new javax.swing.JTable();
        btnCleanNV = new javax.swing.JButton();
        cbNam = new javax.swing.JCheckBox();
        cbNu = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jtfUsername = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtfManv = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtfTrangthai = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnShowNhanVien = new javax.swing.JButton();
        btnbrowse = new javax.swing.JButton();
        jtfTimkiemTk = new javax.swing.JTextField();
        btnTimkiemTKNV = new javax.swing.JButton();
        btnSaveTKNV = new javax.swing.JButton();
        btnUpdateTKNV = new javax.swing.JButton();
        btnDeleteTKNV = new javax.swing.JButton();
        btnCleanTKNV = new javax.swing.JButton();
        jtfPassword = new javax.swing.JPasswordField();
        lbimage = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbTaikhoanNhanvien = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 255, 204));
        setPreferredSize(new java.awt.Dimension(983, 650));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý nhân viên", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(204, 0, 204))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(984, 300));
        jPanel1.setRequestFocusEnabled(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Họ và tên");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Giới tính");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Ngày sinh");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Số điện thoại");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Email");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Địa chỉ");

        jtfTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTimkiemActionPerformed(evt);
            }
        });
        jtfTimkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfTimkiemKeyReleased(evt);
            }
        });

        btnTimkiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTimkiem.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\icons8-search-27.png"
        ));
        btnTimkiem.setText("Tìm kiếm");
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\icons8-add-27.png"));
        btnSave.setText("Thêm");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\icons8-update-left-rotation-27.png"));
        btnUpdate.setText("Sữa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\icons8-delete-27.png"));
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jtbNhanVien.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbNhanVien);

        btnCleanNV.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\clean-icon3.png"));
        btnCleanNV.setText("Làm mới");
        btnCleanNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanNVActionPerformed(evt);
            }
        });

        cbNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbNam.setText("Nam");
        cbNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNamActionPerformed(evt);
            }
        });

        cbNu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbNu.setText("Nữ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfHovaTenNhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfEmailNhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtfTimkiem)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnTimkiem))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnSave)
                                        .addGap(27, 27, 27)
                                        .addComponent(btnUpdate)
                                        .addGap(26, 26, 26)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCleanNV)))
                                .addContainerGap(114, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtfDiachiNhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(cbNu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfSdtNhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jtfHovaTenNhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jdtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtfTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnTimkiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtfEmailNhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete)
                            .addComponent(btnCleanNV, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfDiachiNhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfSdtNhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbNu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nhân Viên", jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý tài khoản nhân viên", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(204, 0, 204))); // NOI18N
        jPanel2.setMinimumSize(new java.awt.Dimension(984, 348));
        jPanel2.setPreferredSize(new java.awt.Dimension(984, 300));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Tên tài khoản");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Mật khẩu");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("ID nhân viên");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Trạng thái");

        jtfTrangthai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTrangthaiActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Ảnh đại diện < (64kb)");

        btnShowNhanVien.setText("...");
        btnShowNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowNhanVienActionPerformed(evt);
            }
        });

        btnbrowse.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnbrowse.setText("Browse");
        btnbrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbrowseActionPerformed(evt);
            }
        });

        jtfTimkiemTk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfTimkiemTkKeyReleased(evt);
            }
        });

        btnTimkiemTKNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTimkiemTKNV.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\icons8-search-27.png"));
        btnTimkiemTKNV.setText("Tìm Kiếm");
        btnTimkiemTKNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemTKNVActionPerformed(evt);
            }
        });

        btnSaveTKNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSaveTKNV.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\icons8-add-27.png"
        ));
        btnSaveTKNV.setText("Lưu");
        btnSaveTKNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveTKNVActionPerformed(evt);
            }
        });

        btnUpdateTKNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdateTKNV.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\icons8-update-left-rotation-27.png"));
        btnUpdateTKNV.setText("Sửa");
        btnUpdateTKNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTKNVActionPerformed(evt);
            }
        });

        btnDeleteTKNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDeleteTKNV.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\icons8-delete-27.png"));
        btnDeleteTKNV.setText("Xóa");
        btnDeleteTKNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTKNVActionPerformed(evt);
            }
        });

        btnCleanTKNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCleanTKNV.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Image\\clean-icon3.png"));
        btnCleanTKNV.setText("Làm sạch");
        btnCleanTKNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanTKNVActionPerformed(evt);
            }
        });

        jtfPassword.setText("jPasswordField1");

        lbimage.setBackground(new java.awt.Color(255, 255, 255));
        lbimage.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbimage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbimage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jtbTaikhoanNhanvien.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbTaikhoanNhanvien.setGridColor(new java.awt.Color(255, 255, 255));
        jtbTaikhoanNhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbTaikhoanNhanvienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbTaikhoanNhanvien);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGap(72, 72, 72)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jtfPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addComponent(jtfUsername, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfManv, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfTrangthai))
                .addGap(36, 36, 36)
                .addComponent(btnShowNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(lbimage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnbrowse)
                .addGap(55, 55, 55))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(btnSaveTKNV)
                .addGap(18, 18, 18)
                .addComponent(btnUpdateTKNV)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteTKNV)
                .addGap(21, 21, 21)
                .addComponent(btnCleanTKNV)
                .addGap(88, 88, 88)
                .addComponent(jtfTimkiemTk, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimkiemTKNV)
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jtfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jtfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jtfManv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnShowNhanVien))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jtfTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel11)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbimage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnbrowse)))
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfTimkiemTk, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimkiemTKNV))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSaveTKNV)
                        .addComponent(btnUpdateTKNV)
                        .addComponent(btnDeleteTKNV)
                        .addComponent(btnCleanTKNV, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tài Khoản Nhân Viên", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtbNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbNhanVienMouseClicked
        try {
            int row = jtbNhanVien.getSelectedRow();
            if(row >= 0){
                int id = (Integer) jtbNhanVien.getValueAt(row, 0);
                NhanVienBUS nhanVienBUS = new NhanVienBUS();
                NhanVien nv = nhanVienBUS.getNhanVien(id);
                nhanVienUpdate = this.nhanVienBUS.getNhanVien(id);
                nhanVienDelete = this.nhanVienBUS.getNhanVien(id);
                if(nv != null){
                    jtfHovaTenNhanvien.setText(nv.getTenNhanVien());
//                    jtfGioitinhNhanvien.setText(nv.getGioiTinh());
                    String gioitinh = nv.getGioiTinh();
                    CbSelected(String.valueOf(gioitinh));
                    jdtNgaySinh.setDate(nv.getNgaySinh());
                    jtfSdtNhanvien.setText(nv.getSoDienThoai());
                    jtfEmailNhanvien.setText(nv.getEmail());
                    jtfDiachiNhanvien.setText(nv.getDiaChi());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtbNhanVienMouseClicked

    private void jtfTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTimkiemActionPerformed

    private void jtfTimkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTimkiemKeyReleased
        try {
            NhanVienBUS nhanVienBUS = new NhanVienBUS();
            List<NhanVien> list = nhanVienBUS.findNhanVien(jtfTimkiem.getText());
            initTable();
            for(NhanVien nhanVien : list){
                jtbNhanVienmodel.addRow(new Object[]{
                    nhanVien.getID(),nhanVien.getTenNhanVien(),nhanVien.getGioiTinh(),nhanVien.getNgaySinh(),nhanVien.getSoDienThoai(),
                    nhanVien.getEmail(),nhanVien.getDiaChi()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Nhân viên không tồn tại" , "Cảnh báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtfTimkiemKeyReleased

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        try {
            NhanVienBUS nhanVienBUS = new NhanVienBUS();
            List<NhanVien> list = nhanVienBUS.findNhanVien(jtfTimkiem.getText());

            if(list.isEmpty()){
                JOptionPane.showMessageDialog(this,"Nhân viên không tồn tại" , "Cảnh báo", JOptionPane.ERROR_MESSAGE);
            }
            else{
                for(NhanVien nv : list){
                    jtfHovaTenNhanvien.setText(nv.getTenNhanVien());
//                    jtfGioitinhNhanvien.setText(nv.getGioiTinh());
                    String gioitinh = nv.getGioiTinh();
                    CbSelected(String.valueOf(gioitinh));
                    //                    jtfNgaysinhNhanvien.setText(nv.getNgaySinh());
                    jdtNgaySinh.setDate(nv.getNgaySinh());
                    jtfSdtNhanvien.setText(nv.getSoDienThoai());
                    jtfEmailNhanvien.setText(nv.getEmail());
                    jtfDiachiNhanvien.setText(nv.getDiaChi());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Nhân viên không tồn tại" , "Cảnh báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnTimkiemActionPerformed
//jtfGioitinhNhanvien.getText().isBlank() ||
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(jtfHovaTenNhanvien.getText().isBlank() ||  jdtNgaySinh.getDate()== null
            || jtfSdtNhanvien.getText().isBlank() || jtfEmailNhanvien.getText().isBlank() || jtfDiachiNhanvien.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Không được điền thiếu thông tin nhân viên");
            return;
        }
        try {
            if(!Email()){
                JOptionPane.showMessageDialog(this, "Sai ding dang Email");
                return;
            }
            NhanVien nhanVien = new NhanVien();
            nhanVien.setID(nhanvienid);
            nhanVien.setTenNhanVien(jtfHovaTenNhanvien.getText());
//            nhanVien.setGioiTinh(jtfGioitinhNhanvien.getText());
            String gioitinh = getSex();
            nhanVien.setGioiTinh(gioitinh);
            //                nhanVien.setNgaySinh(Date.valueOf(jtfNgaysinhNhanvien.getDate().toString()));
            //                nhanVien.setNgaySinh(String.valueOf(jtfNgaysinhNhanvien.getText()));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String finddate =  sdf.format(jdtNgaySinh.getDate()).toString();
            nhanVien.setNgaySinh( Date.valueOf(finddate));
            nhanVien.setSoDienThoai(jtfSdtNhanvien.getText());

            nhanVien.setEmail(jtfEmailNhanvien.getText());
            nhanVien.setDiaChi(jtfDiachiNhanvien.getText());
            NhanVienBUS nhanVienBUS = new NhanVienBUS();
            if(nhanVienBUS.saveNhanvien(nhanVien) > 0){
                JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công");
                jtfHovaTenNhanvien.setText("");
//                jtfGioitinhNhanvien.setText("");
                //jdtNgaySinh.setDate("");
                jdtNgaySinh.cleanup();
                jtfSdtNhanvien.setText("");
                jtfEmailNhanvien.setText("");
                jtfDiachiNhanvien.setText("");
                CbSelectreset();
                loadData();
            }
            else{
                JOptionPane.showMessageDialog(this, "Thêm nhân viên thất bại");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Thêm nhân viên thất bại");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            if(!Email()){
                JOptionPane.showMessageDialog(this, "Sai ding dang Email");
                return;
            }
            NhanVien nhanVien = new NhanVien();
            nhanVien = this.nhanVienUpdate;
            nhanVien.setTenNhanVien(jtfHovaTenNhanvien.getText());
//            nhanVien.setGioiTinh(jtfGioitinhNhanvien.getText());
            String gioitinh = getSex();
            nhanVien.setGioiTinh(gioitinh);
            //            nhanVien.setNgaySinh(jtfNgaysinhNhanvien.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String finddate =  sdf.format(jdtNgaySinh.getDate()).toString();
            nhanVien.setNgaySinh( Date.valueOf(finddate));
            nhanVien.setSoDienThoai(jtfSdtNhanvien.getText());
            nhanVien.setEmail(jtfEmailNhanvien.getText());
            nhanVien.setDiaChi(jtfDiachiNhanvien.getText());

            if(JOptionPane.showConfirmDialog(this, "Bạn có muốn Update không?", "Hỏi"
                , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION){
            return;
        }
        NhanVienBUS nhanVienBUS = new NhanVienBUS();
        if(nhanVienBUS.updateNhanvien(nhanVien)>0){
            JOptionPane.showMessageDialog(null, "Update thành công");
            jtfHovaTenNhanvien.setText("");
//            jtfGioitinhNhanvien.setText("");
            jdtNgaySinh.cleanup();
            jtfSdtNhanvien.setText("");
            jtfEmailNhanvien.setText("");
            jtfDiachiNhanvien.setText("");
            CbSelectreset();
            loadData();
        }
        else{
            JOptionPane.showMessageDialog(null, "Update thất bại");
        }
        } catch (Exception e) {
            Logger.getLogger(NhanVienJFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?", "Hỏi"
                , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION){
            return;
        }
        NhanVienBUS nhanVienBUS = new NhanVienBUS();
        if(nhanVienBUS.deleteNhanvien(nhanVienDelete)){
            JOptionPane.showMessageDialog(null, "Xóa thành công");
            CbSelectreset();
            loadData();
        }
        else{
            JOptionPane.showMessageDialog(null, "Xóa thất bại");
        }
        } catch (Exception e) {
            Logger.getLogger(NhanVienJFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jtfTrangthaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTrangthaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTrangthaiActionPerformed

    private void btnShowNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowNhanVienActionPerformed
        TableNhanVien tbNhanVien = new TableNhanVien();
        try {
            tbNhanVien.list();
        } catch (Exception e) {
            Logger.getLogger(TableNhanVien.class.getName()).log(Level.SEVERE, null, e);
        }
        tbNhanVien.setVisible(true);
    }//GEN-LAST:event_btnShowNhanVienActionPerformed

    private void btnbrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbrowseActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(false);
        if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            this.file = chooser.getSelectedFile();
            String path = file.getAbsolutePath();
            //txtAmount.setText(path);
            ImageIcon imageicon = new ImageIcon(path);
            Image image = imageicon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
            lbimage.setIcon(new ImageIcon(image));
        }
    }//GEN-LAST:event_btnbrowseActionPerformed

    private void jtfTimkiemTkKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTimkiemTkKeyReleased
        try {
            TaiKhoanNhanVienBUS taiKhoanNhanVienBUS = new TaiKhoanNhanVienBUS();
            List<TaikhoanNhanvien> list = taiKhoanNhanVienBUS.findTaiKhoanNhanVien(jtfTimkiemTk.getText());
            initTableTaiKhoanNhanVien();
            for(TaikhoanNhanvien tk : list){
                jtbtaikhoannhanvienModel.addRow(new Object[]{
                    tk.getAnhDaiDien(),tk.getTenDangNhap(),tk.getID(),tk.getMatKhau(),tk.getTrangThai()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Tài khoản nhân viên không tồn tại" , "Cảnh báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtfTimkiemTkKeyReleased

    private void btnTimkiemTKNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemTKNVActionPerformed
        try {
            TaiKhoanNhanVienBUS taiKhoanNhanVienBUS = new TaiKhoanNhanVienBUS();
            List<TaikhoanNhanvien> list = taiKhoanNhanVienBUS.findTaiKhoanNhanVien(jtfTimkiem.getText());
            if(list.isEmpty()){
                JOptionPane.showMessageDialog(this,"Tài khoản không tồn tại" , "Cảnh báo", JOptionPane.ERROR_MESSAGE);
            }
            else{
                for(TaikhoanNhanvien taikhoanNhanvien : list){
                    jtfUsername.setText(taikhoanNhanvien.getTenDangNhap());
                    jtfManv.setText(String.valueOf(taikhoanNhanvien.getID()));
                    jtfPassword.setText(taikhoanNhanvien.getMatKhau());
                    jtfTrangthai.setText(String.valueOf(taikhoanNhanvien.getTrangThai()));
                    lbimage.setIcon(new ImageIcon(new ImageIcon(taikhoanNhanvien.getAnhDaiDien()).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Tài khoản không tồn tại" , "Cảnh báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnTimkiemTKNVActionPerformed

    private void btnSaveTKNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveTKNVActionPerformed
        if(!checkIdNhanvien()){
            try {
                TaikhoanNhanvien taikhoanNhanvien = new TaikhoanNhanvien();
                taikhoanNhanvien.setTenDangNhap(jtfUsername.getText());
                taikhoanNhanvien.setID(Integer.parseInt(jtfManv.getText()));
                taikhoanNhanvien.setMatKhau(String.valueOf(jtfPassword.getPassword()).toString());
                taikhoanNhanvien.setTrangThai(Integer.parseInt(jtfTrangthai.getText()));
                taikhoanNhanvien.setAnhDaiDien(Files.readAllBytes(this.file.toPath()));
                TaiKhoanNhanVienBUS taiKhoanNhanVienBUS = new TaiKhoanNhanVienBUS();
                if(taiKhoanNhanVienBUS.insertTaiKhoanNV(taikhoanNhanvien) > 0 ){
                    JOptionPane.showMessageDialog(this, "Thêm tài khoản thành công");
                    jtfUsername.setText("");
                    jtfManv.setText("");
                    jtfPassword.setText("");
                    jtfTrangthai.setText("");
                    lbimage.setVisible(true);
                    LoadTableTaiKhoanNhanVien();
                }
                else{
                    JOptionPane.showMessageDialog(this,"Thêm tài khoản thất bại" , "Cảnh báo", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this,"Tên đặng nhập đã tồn tại" , "Cảnh báo", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Mã nhân viên không tồn tại" , "Cảnh báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveTKNVActionPerformed

    private void btnUpdateTKNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTKNVActionPerformed
        try {
            TaikhoanNhanvien tknv = new TaikhoanNhanvien();
            tknv = this.taikhoanNhanvienUpdate;
            tknv.setTenDangNhap(jtfUsername.getText());
            tknv.setMatKhau(String.valueOf(jtfPassword.getPassword()).toString());
            tknv.setTrangThai(Integer.parseInt(jtfTrangthai.getText()));
            tknv.setAnhDaiDien(Files.readAllBytes(this.file.toPath()));
            tknv.setID(Integer.parseInt(jtfManv.getText()));

            if(JOptionPane.showConfirmDialog(this, "Bạn có muốn Update không?", "Hỏi"
                , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION){
            return;
        }
        TaiKhoanNhanVienBUS tknvbus = new TaiKhoanNhanVienBUS();
        if(tknvbus.updateTaiKhoanNV(tknv) > 0 ){
            JOptionPane.showMessageDialog(null, "Update thành công");
            jtfUsername.setText("");
            jtfPassword.setText("");
            jtfTrangthai.setText("");
            lbimage.setVisible(true);
            //                jtfManv.setText("");
            LoadTableTaiKhoanNhanVien();
        }
        else{
            JOptionPane.showMessageDialog(null, "Update thất bại");
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Chưa cập nhật lại Ảnh. Update thất bại");
            Logger.getLogger(NhanVienJFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnUpdateTKNVActionPerformed

    private void btnDeleteTKNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTKNVActionPerformed
        try {
            if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?", "Hỏi"
                , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION){
            return;
        }
        TaiKhoanNhanVienBUS tknvbus = new TaiKhoanNhanVienBUS();
        if(tknvbus.deleteTaiKhoanNV(taikhoanNhanvienDelete)){
            JOptionPane.showMessageDialog(null, "Xóa thành công");
            LoadTableTaiKhoanNhanVien();
        }
        else{
            JOptionPane.showMessageDialog(null, "Xóa thất bại");
        }
        } catch (Exception e) {
            Logger.getLogger(NhanVienJFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnDeleteTKNVActionPerformed

    private void jtbTaikhoanNhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbTaikhoanNhanvienMouseClicked
        try {
            int row = jtbTaikhoanNhanvien.getSelectedRow();
            if(row >= 0){
                String Username =  jtbTaikhoanNhanvien.getValueAt(row, 1).toString();
                int ID = (Integer)jtbTaikhoanNhanvien.getValueAt(row, 2);
                TaiKhoanNhanVienBUS taiKhoanNhanVienBUS = new TaiKhoanNhanVienBUS();
                TaikhoanNhanvien taikhoanNhanvien  = taiKhoanNhanVienBUS.getTaikhoanNhanvien(Username);

                taikhoanNhanvienUpdate = taiKhoanNhanVienBUS.getIDTaikhoanNhanvien(ID);
                taikhoanNhanvienDelete = taiKhoanNhanVienBUS.getTaikhoanNhanvien(Username);
                if(taikhoanNhanvien != null){
                    jtfUsername.setText(taikhoanNhanvien.getTenDangNhap());
                    jtfManv.setText(String.valueOf(taikhoanNhanvien.getID()));
                    jtfPassword.setText(taikhoanNhanvien.getMatKhau());
                    jtfTrangthai.setText(String.valueOf(taikhoanNhanvien.getTrangThai()));
                    lbimage.setIcon(new ImageIcon(new ImageIcon(taikhoanNhanvien.getAnhDaiDien()).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtbTaikhoanNhanvienMouseClicked

    private void btnCleanNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanNVActionPerformed
        jtfHovaTenNhanvien.setText("");
//        jtfGioitinhNhanvien.setText("");
        jdtNgaySinh.cleanup();
        jtfSdtNhanvien.setText("");
        jtfEmailNhanvien.setText("");
        jtfDiachiNhanvien.setText("");
        CbSelectreset();
        loadData();
    }//GEN-LAST:event_btnCleanNVActionPerformed

    private void btnCleanTKNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanTKNVActionPerformed
        jtfUsername.setText("");
        jtfPassword.setText("");
        jtfTrangthai.setText("");
        jtfManv.setText("");
        lbimage.setVisible(true);
        //                jtfManv.setText("");
        LoadTableTaiKhoanNhanVien();
    }//GEN-LAST:event_btnCleanTKNVActionPerformed

    private void cbNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbNamActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCleanNV;
    private javax.swing.JButton btnCleanTKNV;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteTKNV;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveTKNV;
    private javax.swing.JButton btnShowNhanVien;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnTimkiemTKNV;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateTKNV;
    private javax.swing.JButton btnbrowse;
    private javax.swing.JCheckBox cbNam;
    private javax.swing.JCheckBox cbNu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JDateChooser jdtNgaySinh;
    private javax.swing.JTable jtbNhanVien;
    private javax.swing.JTable jtbTaikhoanNhanvien;
    private javax.swing.JTextField jtfDiachiNhanvien;
    private javax.swing.JTextField jtfEmailNhanvien;
    private javax.swing.JTextField jtfHovaTenNhanvien;
    private javax.swing.JTextField jtfManv;
    private javax.swing.JPasswordField jtfPassword;
    private javax.swing.JTextField jtfSdtNhanvien;
    private javax.swing.JTextField jtfTimkiem;
    private javax.swing.JTextField jtfTimkiemTk;
    private javax.swing.JTextField jtfTrangthai;
    private javax.swing.JTextField jtfUsername;
    private javax.swing.JLabel lbimage;
    // End of variables declaration//GEN-END:variables
}
