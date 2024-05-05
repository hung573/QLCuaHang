package GUI;
import GUI.Admin_GUI;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DangNhap_GUI extends javax.swing.JFrame {
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnDangNhap = new javax.swing.JPanel();
        lblDangNhap = new javax.swing.JLabel();
        lblTenTaiKhoan = new javax.swing.JLabel();
        txfTenTaiKhoan = new javax.swing.JTextField();
        lblMatKhau = new javax.swing.JLabel();
        buttonDangNhap = new javax.swing.JButton();
        txfMatKhau = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lblImage = new javax.swing.JLabel();
        pnTitle = new javax.swing.JPanel();
        lbExit = new javax.swing.JLabel();
        lbMinimize = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ĐĂNG NHẬP QUẢN TRỊ");
        setBackground(new java.awt.Color(102, 163, 222));
        setName("Đăng nhập Admin"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        pnDangNhap.setBackground(new java.awt.Color(255, 153, 153));
        pnDangNhap.setForeground(new java.awt.Color(255, 102, 255));
        pnDangNhap.setToolTipText("");
        pnDangNhap.setName(""); // NOI18N

        lblDangNhap.setFont(new java.awt.Font("Tahoma", 1, 23)); // NOI18N
        lblDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        lblDangNhap.setText("ĐĂNG NHẬP ĐỂ QUẢN LÍ");

        lblTenTaiKhoan.setBackground(new java.awt.Color(255, 255, 255));
        lblTenTaiKhoan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTenTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        lblTenTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-username-50.png"))); // NOI18N
        lblTenTaiKhoan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txfTenTaiKhoan.setForeground(new java.awt.Color(153, 153, 153));
        txfTenTaiKhoan.setText("Nhập tên tài khoản...");
        txfTenTaiKhoan.setToolTipText("Nhập tên tài khoản...");
        txfTenTaiKhoan.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txfTenTaiKhoan.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txfTenTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txfTenTaiKhoanMousePressed(evt);
            }
        });
        txfTenTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfTenTaiKhoanActionPerformed(evt);
            }
        });
        txfTenTaiKhoan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfTenTaiKhoanKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfTenTaiKhoanKeyReleased(evt);
            }
        });

        lblMatKhau.setBackground(new java.awt.Color(255, 255, 255));
        lblMatKhau.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        lblMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-password-52.png"))); // NOI18N
        lblMatKhau.setToolTipText("");

        buttonDangNhap.setBackground(new java.awt.Color(204, 0, 0));
        buttonDangNhap.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        buttonDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        buttonDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-login-30.png"))); // NOI18N
        buttonDangNhap.setText("Đăng nhập");
        buttonDangNhap.setBorder(null);
        buttonDangNhap.setBorderPainted(false);
        buttonDangNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonDangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonDangNhapMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonDangNhapMouseExited(evt);
            }
        });
        buttonDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDangNhapActionPerformed(evt);
            }
        });

        txfMatKhau.setForeground(new java.awt.Color(153, 153, 153));
        txfMatKhau.setText("Nhập mật khẩu...");
        txfMatKhau.setToolTipText("Nhập mật khẩu...");
        txfMatKhau.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txfMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txfMatKhauMousePressed(evt);
            }
        });
        txfMatKhau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfMatKhauKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfMatKhauKeyReleased(evt);
            }
        });

        lblImage.setForeground(new java.awt.Color(255, 102, 51));
        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nen.png"))); // NOI18N

        javax.swing.GroupLayout pnDangNhapLayout = new javax.swing.GroupLayout(pnDangNhap);
        pnDangNhap.setLayout(pnDangNhapLayout);
        pnDangNhapLayout.setHorizontalGroup(
            pnDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDangNhapLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDangNhapLayout.createSequentialGroup()
                        .addComponent(lblDangNhap)
                        .addGap(71, 71, 71))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDangNhapLayout.createSequentialGroup()
                        .addComponent(buttonDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))))
            .addGroup(pnDangNhapLayout.createSequentialGroup()
                .addGroup(pnDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDangNhapLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(pnDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnDangNhapLayout.createSequentialGroup()
                                .addComponent(lblTenTaiKhoan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txfTenTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnDangNhapLayout.createSequentialGroup()
                                .addComponent(lblMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfMatKhau))))
                    .addGroup(pnDangNhapLayout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(lblImage)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        pnDangNhapLayout.setVerticalGroup(
            pnDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDangNhapLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnDangNhapLayout.createSequentialGroup()
                        .addGroup(pnDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txfTenTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTenTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(txfMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(buttonDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pnTitle.setBackground(new java.awt.Color(255, 255, 255));
        pnTitle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnTitleMouseDragged(evt);
            }
        });
        pnTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnTitleMousePressed(evt);
            }
        });

        lbExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-xbox-x-20.png"))); // NOI18N
        lbExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbExitMouseClicked(evt);
            }
        });

        lbMinimize.setBackground(new java.awt.Color(255, 51, 51));
        lbMinimize.setForeground(new java.awt.Color(255, 0, 51));
        lbMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-minimize-window-20.png"))); // NOI18N
        lbMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMinimizeMouseClicked(evt);
            }
        });

        lbTitle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(255, 102, 102));
        lbTitle.setText("QUAN LY MAY TINH");
        lbTitle.setMaximumSize(new java.awt.Dimension(20, 20));
        lbTitle.setMinimumSize(new java.awt.Dimension(20, 20));
        lbTitle.setPreferredSize(new java.awt.Dimension(20, 20));

        javax.swing.GroupLayout pnTitleLayout = new javax.swing.GroupLayout(pnTitle);
        pnTitle.setLayout(pnTitleLayout);
        pnTitleLayout.setHorizontalGroup(
            pnTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTitleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(lbMinimize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbExit)
                .addContainerGap())
        );
        pnTitleLayout.setVerticalGroup(
            pnTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbExit, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
            .addComponent(lbMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTitleLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void txfTenTaiKhoanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTenTaiKhoanKeyPressed

    
    }//GEN-LAST:event_txfTenTaiKhoanKeyPressed

    private void buttonDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDangNhapActionPerformed

    }//GEN-LAST:event_buttonDangNhapActionPerformed

    private void txfMatKhauKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfMatKhauKeyPressed

    }//GEN-LAST:event_txfMatKhauKeyPressed

    private void buttonDangNhapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDangNhapMouseEntered
       
    }//GEN-LAST:event_buttonDangNhapMouseEntered

    private void buttonDangNhapMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDangNhapMouseExited

    }//GEN-LAST:event_buttonDangNhapMouseExited

    private void txfTenTaiKhoanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTenTaiKhoanKeyReleased
    

    }//GEN-LAST:event_txfTenTaiKhoanKeyReleased

    private void txfTenTaiKhoanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txfTenTaiKhoanMousePressed
      
    }//GEN-LAST:event_txfTenTaiKhoanMousePressed

    private void txfMatKhauKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfMatKhauKeyReleased

    }//GEN-LAST:event_txfMatKhauKeyReleased

    private void txfMatKhauMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txfMatKhauMousePressed

    }//GEN-LAST:event_txfMatKhauMousePressed

    private void lbMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMinimizeMouseClicked
     
    }//GEN-LAST:event_lbMinimizeMouseClicked

    private void lbExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExitMouseClicked
    
    }//GEN-LAST:event_lbExitMouseClicked

    private void pnTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnTitleMousePressed
       
    }//GEN-LAST:event_pnTitleMousePressed

    private void pnTitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnTitleMouseDragged
      
    }//GEN-LAST:event_pnTitleMouseDragged

    private void txfTenTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfTenTaiKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfTenTaiKhoanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDangNhap;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbExit;
    private javax.swing.JLabel lbMinimize;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lblDangNhap;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblTenTaiKhoan;
    private javax.swing.JPanel pnDangNhap;
    private javax.swing.JPanel pnTitle;
    private javax.swing.JPasswordField txfMatKhau;
    private javax.swing.JTextField txfTenTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
