package GUI;
import java.awt.Color;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JFrame;
public class Admin_GUI extends javax.swing.JFrame {
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMenu = new javax.swing.JPanel();
        btnQuanLyNV = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        btnQuanLyKH = new javax.swing.JButton();
        btnQuanLySP = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnTrangChu = new javax.swing.JButton();
        btnBanHang = new javax.swing.JButton();
        btnQuanLyHD = new javax.swing.JButton();
        pnMain = new javax.swing.JPanel();
        pnTitileBar = new javax.swing.JPanel();
        lbExit = new javax.swing.JLabel();
        lbMinimize = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbHoTenOnline = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMIN");
        setBackground(new java.awt.Color(0, 126, 167));
        setUndecorated(true);
        setResizable(false);

        pnMenu.setBackground(new java.awt.Color(102, 102, 102));
        pnMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnQuanLyNV.setBackground(new java.awt.Color(255, 255, 255));
        btnQuanLyNV.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnQuanLyNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-staff-26.png"))); // NOI18N
        btnQuanLyNV.setText("Quản lý nhân viên");
        btnQuanLyNV.setBorder(null);
        btnQuanLyNV.setBorderPainted(false);
        btnQuanLyNV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQuanLyNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuanLyNVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnQuanLyNVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnQuanLyNVMouseExited(evt);
            }
        });
        btnQuanLyNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyNVActionPerformed(evt);
            }
        });
        pnMenu.add(btnQuanLyNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 255, 39));

        btnDangXuat.setBackground(new java.awt.Color(255, 204, 0));
        btnDangXuat.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-logout-rounded-left-26.png"))); // NOI18N
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.setBorder(null);
        btnDangXuat.setBorderPainted(false);
        btnDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDangXuatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDangXuatMouseExited(evt);
            }
        });
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });
        pnMenu.add(btnDangXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 122, 35));

        btnQuanLyKH.setBackground(new java.awt.Color(255, 255, 255));
        btnQuanLyKH.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnQuanLyKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-user-groups-26.png"))); // NOI18N
        btnQuanLyKH.setText("Quản lý khách hàng");
        btnQuanLyKH.setBorder(null);
        btnQuanLyKH.setBorderPainted(false);
        btnQuanLyKH.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQuanLyKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuanLyKHMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnQuanLyKHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnQuanLyKHMouseExited(evt);
            }
        });
        btnQuanLyKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyKHActionPerformed(evt);
            }
        });
        pnMenu.add(btnQuanLyKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 255, 39));

        btnQuanLySP.setBackground(new java.awt.Color(255, 255, 255));
        btnQuanLySP.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnQuanLySP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-product-26.png"))); // NOI18N
        btnQuanLySP.setText("Quản lý sản phẩm");
        btnQuanLySP.setBorder(null);
        btnQuanLySP.setBorderPainted(false);
        btnQuanLySP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQuanLySP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuanLySPMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnQuanLySPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnQuanLySPMouseExited(evt);
            }
        });
        btnQuanLySP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLySPActionPerformed(evt);
            }
        });
        pnMenu.add(btnQuanLySP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 255, 39));

        btnThongKe.setBackground(new java.awt.Color(128, 216, 255));
        btnThongKe.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-account-26.png"))); // NOI18N
        btnThongKe.setText("Thống kê");
        btnThongKe.setBorder(null);
        btnThongKe.setBorderPainted(false);
        btnThongKe.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThongKeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnThongKeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnThongKeMouseExited(evt);
            }
        });
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });
        pnMenu.add(btnThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 255, 39));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cc.png"))); // NOI18N
        pnMenu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 120, 200));
        pnMenu.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 275, 10));

        btnTrangChu.setBackground(new java.awt.Color(255, 255, 255));
        btnTrangChu.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-home-26.png"))); // NOI18N
        btnTrangChu.setText("Trang chủ");
        btnTrangChu.setBorder(null);
        btnTrangChu.setBorderPainted(false);
        btnTrangChu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTrangChu.setInheritsPopupMenu(true);
        btnTrangChu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTrangChuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTrangChuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTrangChuMouseExited(evt);
            }
        });
        btnTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrangChuActionPerformed(evt);
            }
        });
        pnMenu.add(btnTrangChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 255, 39));

        btnBanHang.setBackground(new java.awt.Color(255, 255, 255));
        btnBanHang.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-sell-27.png"))); // NOI18N
        btnBanHang.setText("Bán hàng");
        btnBanHang.setBorder(null);
        btnBanHang.setBorderPainted(false);
        btnBanHang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBanHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBanHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBanHangMouseExited(evt);
            }
        });
        btnBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHangActionPerformed(evt);
            }
        });
        pnMenu.add(btnBanHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 255, 39));

        btnQuanLyHD.setBackground(new java.awt.Color(255, 255, 255));
        btnQuanLyHD.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnQuanLyHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-receipt-26.png"))); // NOI18N
        btnQuanLyHD.setText("Quản lý hóa đơn");
        btnQuanLyHD.setBorder(null);
        btnQuanLyHD.setBorderPainted(false);
        btnQuanLyHD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQuanLyHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuanLyHDMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnQuanLyHDMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnQuanLyHDMouseExited(evt);
            }
        });
        btnQuanLyHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyHDActionPerformed(evt);
            }
        });
        pnMenu.add(btnQuanLyHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 255, 39));

        pnTitileBar.setBackground(new java.awt.Color(102, 102, 102));
        pnTitileBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pnTitileBar.setAlignmentX(0.0F);
        pnTitileBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnTitileBarMouseDragged(evt);
            }
        });
        pnTitileBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnTitileBarMousePressed(evt);
            }
        });

        lbExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-xbox-x-20.png"))); // NOI18N
        lbExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbExitMouseClicked(evt);
            }
        });

        lbMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-minimize-window-20.png"))); // NOI18N
        lbMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMinimizeMouseClicked(evt);
            }
        });

        lbTitle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(255, 255, 255));
        lbTitle.setText("QUAN LI MAY TINH");
        lbTitle.setMaximumSize(new java.awt.Dimension(20, 20));
        lbTitle.setMinimumSize(new java.awt.Dimension(20, 20));
        lbTitle.setPreferredSize(new java.awt.Dimension(20, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Admin -");

        lbHoTenOnline.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbHoTenOnline.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnTitileBarLayout = new javax.swing.GroupLayout(pnTitileBar);
        pnTitileBar.setLayout(pnTitileBarLayout);
        pnTitileBarLayout.setHorizontalGroup(
            pnTitileBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTitileBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbHoTenOnline, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(486, 486, 486)
                .addComponent(lbMinimize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbExit)
                .addGap(18, 18, 18))
        );
        pnTitileBarLayout.setVerticalGroup(
            pnTitileBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTitileBarLayout.createSequentialGroup()
                .addGroup(pnTitileBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbExit, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(lbMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnTitileBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(lbHoTenOnline, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE))
            .addComponent(pnTitileBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnTitileBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuanLyNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyNVActionPerformed
     
    }//GEN-LAST:event_btnQuanLyNVActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
      
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnQuanLyKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyKHActionPerformed

    }//GEN-LAST:event_btnQuanLyKHActionPerformed

    private void btnQuanLySPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLySPActionPerformed
  
    }//GEN-LAST:event_btnQuanLySPActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed

    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangChuActionPerformed

    }//GEN-LAST:event_btnTrangChuActionPerformed

 
    private void btnTrangChuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseEntered
    
    }//GEN-LAST:event_btnTrangChuMouseEntered

    private void btnTrangChuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseExited
    
    }//GEN-LAST:event_btnTrangChuMouseExited

    private void btnQuanLyNVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyNVMouseEntered

    }//GEN-LAST:event_btnQuanLyNVMouseEntered

    private void btnQuanLyNVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyNVMouseExited
    
    }//GEN-LAST:event_btnQuanLyNVMouseExited

    private void btnQuanLyKHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyKHMouseEntered
     
    }//GEN-LAST:event_btnQuanLyKHMouseEntered

    private void btnQuanLyKHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyKHMouseExited
  
    }//GEN-LAST:event_btnQuanLyKHMouseExited

    private void btnQuanLySPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLySPMouseEntered

    }//GEN-LAST:event_btnQuanLySPMouseEntered

    private void btnQuanLySPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLySPMouseExited
 
    }//GEN-LAST:event_btnQuanLySPMouseExited

    private void btnThongKeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongKeMouseEntered

    }//GEN-LAST:event_btnThongKeMouseEntered

    private void btnThongKeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongKeMouseExited
  
    }//GEN-LAST:event_btnThongKeMouseExited

    private void btnDangXuatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDangXuatMouseEntered
  
    }//GEN-LAST:event_btnDangXuatMouseEntered

    private void btnDangXuatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDangXuatMouseExited
 
    }//GEN-LAST:event_btnDangXuatMouseExited

    private void btnThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongKeMouseClicked
   
    }//GEN-LAST:event_btnThongKeMouseClicked

    private void btnTrangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseClicked

    }//GEN-LAST:event_btnTrangChuMouseClicked

    private void btnQuanLyNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyNVMouseClicked

    }//GEN-LAST:event_btnQuanLyNVMouseClicked

    private void btnQuanLyKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyKHMouseClicked
 
    }//GEN-LAST:event_btnQuanLyKHMouseClicked

    private void btnQuanLySPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLySPMouseClicked
     
    }//GEN-LAST:event_btnQuanLySPMouseClicked

    private void btnBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBanHangMouseClicked


    }//GEN-LAST:event_btnBanHangMouseClicked

    private void btnBanHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBanHangMouseExited
 
   
    }//GEN-LAST:event_btnBanHangMouseExited

    private void btnBanHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBanHangMouseEntered
  
    }//GEN-LAST:event_btnBanHangMouseEntered

    private void btnBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHangActionPerformed

    }//GEN-LAST:event_btnBanHangActionPerformed

    private void lbExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExitMouseClicked
    
    }//GEN-LAST:event_lbExitMouseClicked

    private void lbMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMinimizeMouseClicked
    
    }//GEN-LAST:event_lbMinimizeMouseClicked

    private void pnTitileBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnTitileBarMouseDragged
     
    }//GEN-LAST:event_pnTitileBarMouseDragged

    private void pnTitileBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnTitileBarMousePressed
   
    }//GEN-LAST:event_pnTitileBarMousePressed

    private void btnQuanLyHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyHDMouseClicked
 
    }//GEN-LAST:event_btnQuanLyHDMouseClicked

    private void btnQuanLyHDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyHDMouseEntered
       
    }//GEN-LAST:event_btnQuanLyHDMouseEntered

    private void btnQuanLyHDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyHDMouseExited
     
    }//GEN-LAST:event_btnQuanLyHDMouseExited

    private void btnQuanLyHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyHDActionPerformed
    
    }//GEN-LAST:event_btnQuanLyHDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBanHang;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnQuanLyHD;
    private javax.swing.JButton btnQuanLyKH;
    private javax.swing.JButton btnQuanLyNV;
    private javax.swing.JButton btnQuanLySP;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTrangChu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbExit;
    private javax.swing.JLabel lbHoTenOnline;
    private javax.swing.JLabel lbMinimize;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JPanel pnTitileBar;
    // End of variables declaration//GEN-END:variables
}
