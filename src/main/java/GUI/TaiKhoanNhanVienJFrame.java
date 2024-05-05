/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import BUS.*;
import DAO.*;
import DTO.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author tranconghung
 */
public class TaiKhoanNhanVienJFrame extends javax.swing.JFrame {
    private DefaultTableModel jtbtaikhoannhanvienModel;
    private  int idTaikhoanNV;
    private TaikhoanNhanvien taikhoanNhanvienUpdate = new TaikhoanNhanvien();
    private TaikhoanNhanvien taikhoanNhanvienDelete = new TaikhoanNhanvien();
    private File file;
    /**
     * Creates new form TaiKhoanNhanVienJFrame
     */
    public TaiKhoanNhanVienJFrame() {
        initComponents();
        initTable();
        LoadTable();
    }
     public void initTable(){
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
    public void LoadTable(){
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtbTaikhoanNhanvien = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jtfUsername = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfManv = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtfTrangthai = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnShowNhanVien = new javax.swing.JButton();
        btnbrowse = new javax.swing.JButton();
        jtfTimkiem = new javax.swing.JTextField();
        btnTimkiem = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jButton = new javax.swing.JButton();
        jtfPassword = new javax.swing.JPasswordField();
        lbimage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        jtbTaikhoanNhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbTaikhoanNhanvienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbTaikhoanNhanvien);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý tài khoản nhân viên", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(204, 0, 204))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Tên tài khoản");

        jtfUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfUsernameActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Mật khẩu");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("ID nhân viên");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Trạng thái");

        jtfTrangthai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTrangthaiActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Ảnh đại diện < (64kb)");

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

        btnTimkiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTimkiem.setText("Tìm Kiếm");

        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton.setText("jButton7");

        jtfPassword.setText("jPasswordField1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jtfPassword, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfUsername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addComponent(jtfManv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addComponent(jtfTrangthai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addComponent(lbimage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnShowNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbrowse))
                .addGap(109, 109, 109)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete))
                    .addComponent(jtfTimkiem))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimkiem)
                    .addComponent(jButton))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimkiem))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtfManv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShowNhanVien)
                    .addComponent(btnSave)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(jButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtfTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(lbimage, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnbrowse))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
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
                LoadTable();
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
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
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
                LoadTable();
            }
            else{
                JOptionPane.showMessageDialog(null, "Update thất bại");
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Chưa cập nhật lại Ảnh. Update thất bại");
             Logger.getLogger(NhanVienJFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
         try {
            if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?", "Hỏi"
            , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION){
            return;
            }
            TaiKhoanNhanVienBUS tknvbus = new TaiKhoanNhanVienBUS();
            if(tknvbus.deleteTaiKhoanNV(taikhoanNhanvienDelete)){
                JOptionPane.showMessageDialog(null, "Xóa thành công");
                LoadTable();
            }
            else{
                JOptionPane.showMessageDialog(null, "Xóa thất bại");
            }
        } catch (Exception e) {
            Logger.getLogger(NhanVienJFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jtfUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfUsernameActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TaiKhoanNhanVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaiKhoanNhanVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaiKhoanNhanVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaiKhoanNhanVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaiKhoanNhanVienJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnShowNhanVien;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnbrowse;
    private javax.swing.JButton jButton;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbTaikhoanNhanvien;
    private javax.swing.JTextField jtfManv;
    private javax.swing.JPasswordField jtfPassword;
    private javax.swing.JTextField jtfTimkiem;
    private javax.swing.JTextField jtfTrangthai;
    private javax.swing.JTextField jtfUsername;
    private javax.swing.JLabel lbimage;
    // End of variables declaration//GEN-END:variables
}