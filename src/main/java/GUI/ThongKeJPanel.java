/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.*;
import DTO.*;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author tranconghung
 */
public class ThongKeJPanel extends javax.swing.JPanel {
    DefaultTableModel jtbThongKeModel;
    DefaultTableModel jtbTKDHMuaModel;
    DonHangBanBUS donHangBanBUS = new DonHangBanBUS();
    DonHangMuaBUS donHangMuaBUS = new DonHangMuaBUS();
    SanPhamBUS sanPhamBUS = new SanPhamBUS();
    
    DecimalFormat DecimalFormat = new DecimalFormat("#");
    /**
     * Creates new form ThongKeJPanel
     */
    public ThongKeJPanel() throws Exception {
        initComponents();
        LoadDataTableDonHangBan();
        LoadDataTableDonHangMua();
        TongDoanhThuBan();
        TongDoanhThuMua();
        TongDonHangBan();
        TongDonHangMua();
//        this.setLocationRelativeTo(null);
        setDataToChartDHB(jpnDonHangBan3);
        setDataToChartDHM(jpnDonHangMua);
        setDataSanPham(jpnSanPham);
    }
    private void LoadDataTableDonHangBan(){
        jtbThongKeModel = new DefaultTableModel();
        jtbThongKeModel.setColumnIdentifiers(new String[]{"Mã hóa đơn","Ngày Bán","Tổng tiền"});
        try {
            ArrayList<DonHangBan> donHangBans = donHangBanBUS.getHoaDonAll();

            initTableDonHangBan(donHangBans);
        } catch (Exception e) {
            e.printStackTrace();
        }
        jtbThongKeDHB3.setModel(jtbThongKeModel);
    }
    private void LoadDataTableDonHangMua(){
        jtbTKDHMuaModel = new DefaultTableModel();
        jtbTKDHMuaModel.setColumnIdentifiers(new String[]{"Mã hóa đơn","Ngày Bán","Tổng tiền"});
        try {
            ArrayList<DonHangMua> donHangMuas = donHangMuaBUS.getHoaDonAll();

            initTableDonHangMua(donHangMuas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        jtbTKDonHangMua.setModel(jtbTKDHMuaModel);
    }
    private void initTableDonHangBan(ArrayList<DonHangBan> donHangBans){
        for(DonHangBan hd : donHangBans){
            jtbThongKeModel.addRow(new Object[]{hd.getID(),hd.getNgayLap(),DecimalFormat.format(hd.getTongTien())});
        }
    }
    private void initTableDonHangMua(ArrayList<DonHangMua> donHangMuas){
        for(DonHangMua hd : donHangMuas){
            jtbTKDHMuaModel.addRow(new Object[]{hd.getID(),hd.getNgayLap(),DecimalFormat.format(hd.getTongTien())});
        }
    }
    private float TongDoanhThuBan(){
        float Tong = 0;
        try {
            ArrayList<DonHangBan> donHangBans = donHangBanBUS.getHoaDonAll();
            for(DonHangBan dhb : donHangBans){
                Tong += dhb.getTongTien();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jlbDoanhThu.setText(DecimalFormat.format(Tong)+" VND");

        return Tong;
    }
    private float TongDoanhThuMua(){
        float Tong = 0;
        try {
            
            ArrayList<DonHangMua> donHangMuas = donHangMuaBUS.getHoaDonAll();
           
            for(DonHangMua dhm : donHangMuas){
                Tong += dhm.getTongTien();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        jlbDoanhThuaMua.setText(DecimalFormat.format(Tong)+" VND");

        return Tong;
    }
    private float TongDonHangBan(){
        int Tong = 0;
        try {
            ArrayList<DonHangBan> donHangBans = donHangBanBUS.getHoaDonAll();
            for(DonHangBan dhb : donHangBans){
                Tong = dhb.getID();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jlbTongDonHang.setText(""+Tong);

        return Tong;
    }
    private float TongDonHangMua(){
        int Tong = 0;
        try {
            ArrayList<DonHangMua> donHangMuas = donHangMuaBUS.getHoaDonAll();
            for(DonHangMua dhm : donHangMuas){
                Tong = dhm.getID();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jlbTongDonHangMua.setText(""+Tong);

        return Tong;
    }
    private void setDataToChartDHB(JPanel jpnDonHangBan3) throws Exception{
        List<DonHangBan> donHangBans = (ArrayList<DonHangBan>) donHangBanBUS.getHoaDonAll();
        if(donHangBans != null){
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for(DonHangBan dhb : donHangBans){
                dataset.addValue(dhb.getTongTien(), "Doanh thu trong ngày bán được", dhb.getNgayLap());
            }
            
            JFreeChart chart = ChartFactory.createBarChart("Thống Kê Doanh Thu", "Thời Gian", "Doanh Thu (VND)", dataset);
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(jpnDonHangBan3.getWidth(),450));
            jpnDonHangBan3.removeAll();
            jpnDonHangBan3.setLayout(new CardLayout());
            jpnDonHangBan3.add(chartPanel);
            jpnDonHangBan3.validate();
            jpnDonHangBan3.repaint();
        }
    }
    private void setDataToChartDHM(JPanel jpnDonHangMua) throws Exception{
        List<DonHangMua> donHangMuas = (ArrayList<DonHangMua>) donHangMuaBUS.getHoaDonAll();
        if(donHangMuas != null){
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for(DonHangMua dhm : donHangMuas){
                dataset.addValue(dhm.getTongTien(), "Doanh thu trong ngày bán được", dhm.getNgayLap());
            }
            
            JFreeChart chart = ChartFactory.createBarChart("Thống Kê Doanh Thu", "Thời Gian", "Doanh Thu (VND)", dataset);
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(jpnDonHangMua.getWidth(),450));
            jpnDonHangMua.removeAll();
            jpnDonHangMua.setLayout(new CardLayout());
            jpnDonHangMua.add(chartPanel);
            jpnDonHangMua.validate();
            jpnDonHangMua.repaint();
        }
    }
    private void setDataSanPham(JPanel jpnSanPham) throws Exception{
        List<SanPham> sanPhams = (ArrayList<SanPham>) sanPhamBUS.getHoaDonAll();
        if(sanPhams != null){
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for(SanPham sp : sanPhams){
                dataset.addValue(sp.getSoLuong(), "Số Lượng của từng sản phẩm", sp.getTenSanPham());
            }
            
            JFreeChart chart = ChartFactory.createBarChart("Thống kê sản phẩm", "Tên sản phẩm", "Số lượng (Cái)", dataset);
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(jpnSanPham.getWidth(),450));
            jpnSanPham.removeAll();
            jpnSanPham.setLayout(new CardLayout());
            jpnSanPham.add(chartPanel);
            jpnSanPham.validate();
            jpnSanPham.repaint();
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtbThongKeDHB3 = new javax.swing.JTable();
        jpnDonHangBan3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlbDoanhThu = new javax.swing.JLabel();
        jlbTongDonHang = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbTKDonHangMua = new javax.swing.JTable();
        jpnDonHangMua = new javax.swing.JPanel();
        jlbDoanhThuaMua = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlbTongDonHangMua = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jpnSanPham = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(983, 650));

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(984, 331));

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ĐƠN HÀNG BÁN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(204, 0, 204))); // NOI18N
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel4.setPreferredSize(new java.awt.Dimension(984, 300));
        jPanel4.setRequestFocusEnabled(false);

        jtbThongKeDHB3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jtbThongKeDHB3);

        javax.swing.GroupLayout jpnDonHangBan3Layout = new javax.swing.GroupLayout(jpnDonHangBan3);
        jpnDonHangBan3.setLayout(jpnDonHangBan3Layout);
        jpnDonHangBan3Layout.setHorizontalGroup(
            jpnDonHangBan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );
        jpnDonHangBan3Layout.setVerticalGroup(
            jpnDonHangBan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Tổng doanh thu:");

        jlbDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlbDoanhThu.setForeground(new java.awt.Color(0, 0, 255));
        jlbDoanhThu.setText("VND");

        jlbTongDonHang.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlbTongDonHang.setForeground(new java.awt.Color(0, 0, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Tổng đơn hàng:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1))
                        .addComponent(jlbDoanhThu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbTongDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnDonHangBan3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbDoanhThu)
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbTongDonHang)
                .addGap(0, 234, Short.MAX_VALUE))
            .addComponent(jpnDonHangBan3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Thống Kê Đơn Hàng Bán", jPanel4);
        jPanel4.getAccessibleContext().setAccessibleParent(jTabbedPane1);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ĐƠN HÀNG MUA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(204, 0, 204))); // NOI18N

        jtbTKDonHangMua.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtbTKDonHangMua);

        javax.swing.GroupLayout jpnDonHangMuaLayout = new javax.swing.GroupLayout(jpnDonHangMua);
        jpnDonHangMua.setLayout(jpnDonHangMuaLayout);
        jpnDonHangMuaLayout.setHorizontalGroup(
            jpnDonHangMuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
        );
        jpnDonHangMuaLayout.setVerticalGroup(
            jpnDonHangMuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jlbDoanhThuaMua.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlbDoanhThuaMua.setForeground(new java.awt.Color(0, 0, 255));
        jlbDoanhThuaMua.setText("VND");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("Tổng doanh thu:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("Tổng đơn hàng mua:");

        jlbTongDonHangMua.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlbTongDonHangMua.setForeground(new java.awt.Color(0, 0, 255));
        jlbTongDonHangMua.setText("VND");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addComponent(jlbDoanhThuaMua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlbTongDonHangMua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnDonHangMua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbDoanhThuaMua)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jlbTongDonHangMua)
                .addGap(0, 208, Short.MAX_VALUE))
            .addComponent(jpnDonHangMua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Thống Kê Đơn Hàng Mua", jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SẢN PHẨM", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(204, 0, 204))); // NOI18N

        javax.swing.GroupLayout jpnSanPhamLayout = new javax.swing.GroupLayout(jpnSanPham);
        jpnSanPham.setLayout(jpnSanPhamLayout);
        jpnSanPhamLayout.setHorizontalGroup(
            jpnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 961, Short.MAX_VALUE)
        );
        jpnSanPhamLayout.setVerticalGroup(
            jpnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thống Kê Sản Phẩm", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jlbDoanhThu;
    private javax.swing.JLabel jlbDoanhThuaMua;
    private javax.swing.JLabel jlbTongDonHang;
    private javax.swing.JLabel jlbTongDonHangMua;
    private javax.swing.JPanel jpnDonHangBan3;
    private javax.swing.JPanel jpnDonHangMua;
    private javax.swing.JPanel jpnSanPham;
    private javax.swing.JTable jtbTKDonHangMua;
    private javax.swing.JTable jtbThongKeDHB3;
    // End of variables declaration//GEN-END:variables

}
