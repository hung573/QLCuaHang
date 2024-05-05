/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DonHangBan;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.mysql.cj.xdevapi.Result;
import java.sql.Date;
import DTO.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.crypto.Data;
/**
 *
 * @author VO THANH HOA
 */
public class DonHangBanDAO extends MyDatabaseManager{
    DonHangBan donHang = new DonHangBan();
    DecimalFormat DecimalFormat = new DecimalFormat("#");
    public DonHangBanDAO(){
        DonHangBanDAO.connectDB();
    }
    public void listDonHangBan() throws SQLException{
        String sql = "select * from donhangban";
        ResultSet rs = DonHangBanDAO.doReadQuery(sql);
        if(rs != null){
            int i = 1;
            System.out.println("TT \t ID \t idNhanVienLap \t\t idKhachHang\t idTrangThai \t NgayLap \t TongTien");
            while (rs.next()) {
                 System.out.print(i + "\t" + rs.getInt("ID"));
                System.out.println("\t\t" + rs.getInt("idNhanVienLap")
                        + "\t\t\t" + rs.getInt("idKhachHang")
                        + "\t\t\t" + rs.getInt("idTrangThai")
                        + "\t\t\t" + rs.getDate("NgayLap")
                        + "\t\t\t" + rs.getFloat("TongTien"));
                i++;
            }
        }
    }
//    public double ThanhTien(){
//        ChiTietDonHangBan ctdh = new ChiTietDonHangBan();
//        ctdh.
//        return ctdh.getThanhTien();
//    }
    public ArrayList readDonHangBan() throws SQLException{
        String sql = "select * from donhangban where ID > 0";
        ResultSet rs = DonHangBanDAO.doReadQuery(sql);
        ArrayList arrayList = new ArrayList();
        if(rs != null){
            int i = 1;
            while (rs.next()) {
                DonHangBan donHang = new DonHangBan();
                donHang.setID(rs.getInt("ID"));
                donHang.setIdNhanVienLap(rs.getInt("idNhanVienLap"));
                donHang.setIdKhachHang(rs.getInt("idKhachHang"));
                donHang.setIdTrangThai(rs.getInt("idTrangThai"));
                donHang.setNgayLap(rs.getDate("NgayLap"));
                donHang.setTongTien(rs.getFloat("TongTien"));
                arrayList.add(donHang);
            }
        }
        return  arrayList;
    }
    public DonHangBan getDonHangBan(int ID) throws SQLException{
        String sql = "select * from donhangban where ID = ?";
        PreparedStatement p = DonHangBanDAO.connectDB().prepareStatement(sql);
        p.setInt(1, ID);
        ResultSet rs  = p.executeQuery();
        
        DonHangBan donHang = new DonHangBan();
        if(rs != null){
            int i = 1;
            while(rs.next()){
                donHang.setID(rs.getInt("ID"));
                donHang.setIdNhanVienLap(rs.getInt("idNhanVienLap"));
                donHang.setIdKhachHang(rs.getInt("idKhachHang"));
                donHang.setIdTrangThai(rs.getInt("idTrangThai"));
//                nhanVien.setNgaySinh(rs.getString("NgaySinh"));
                donHang.setNgayLap(rs.getDate("NgayLap"));
                donHang.setTongTien(rs.getFloat("TongTien"));
            }
        }
        return donHang;
    }
    public int saveDonHangBan(DonHangBan donHang) throws SQLException{
        String sql = "Insert donhangban (ID,idNhanVienLap,idKhachHang,idTrangThai,NgayLap,TongTien) value (?,?,?,?,?,?)";
        PreparedStatement p = DonHangBanDAO.connectDB().prepareStatement(sql);
        p.setInt(1, donHang.getID());
        p.setInt(2, donHang.getIdNhanVienLap());
        p.setInt(3, donHang.getIdKhachHang());
        p.setInt(4, donHang.getIdTrangThai());
        p.setDate(5, donHang.getNgayLap());
        p.setFloat(6, donHang.getTongTien());
        int result = p.executeUpdate();
        return result;
    }
    public  int updateDonHangBan (DonHangBan donHang) throws SQLException{
        String sql = "Update donhangban SET idNhanVienLap = ? , idKhachHang = ? , idTrangThai = ? , NgayLap = ? , TongTien = ?"
                + " WHERE ID = ?";
        PreparedStatement p = DonHangBanDAO.connectDB().prepareStatement(sql);
        
        p.setInt(1, donHang.getIdNhanVienLap());
        p.setInt(2, donHang.getIdKhachHang());
        p.setInt(3, donHang.getIdTrangThai());
        p.setDate(4, donHang.getNgayLap());
        p.setFloat(5, donHang.getTongTien());
        p.setInt(6, donHang.getID());
        int result = p.executeUpdate();
        return result;
    }
    public boolean deleteDonHangBan(DonHangBan donHang) throws SQLException {
        String query = "DELETE FROM donhangban WHERE ID = ?";
        PreparedStatement p = DonHangBanDAO.connectDB().prepareStatement(query);
        p.setInt(1, donHang.getID());
        int result = p.executeUpdate();

        return true;
    }
    public List findDonHangBan(String idKhachHang) throws SQLException{
        String sql = "SELECT * FROM donhangban WHERE  idKhachHang LIKE ?";
        PreparedStatement p = DonHangBanDAO.connectDB().prepareStatement(sql);
        p.setString(1,idKhachHang);
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();
        
        if(rs != null){
            int i = 1;
            while (rs.next()) {
                DonHangBan donHang = new DonHangBan();
                donHang.setID(rs.getInt("ID"));
                donHang.setIdNhanVienLap(rs.getInt("idNhanVienLap"));
                donHang.setIdKhachHang(rs.getInt("idKhachHang"));
                donHang.setIdTrangThai(rs.getInt("idTrangThai"));
                donHang.setNgayLap(rs.getDate("NgayLap"));
                donHang.setTongTien(rs.getFloat("TongTien"));
                list.add(donHang);
            }
        }
        return list;
    }
    public ArrayList<DonHangBan> GetAll() throws Exception {
        String sql = "select * from donhangban";
        ResultSet rs = DonHangBanDAO.doReadQuery(sql);
        ArrayList<DonHangBan> DonBanHang = new ArrayList<>();
        while ( rs.next() ) {
            DonHangBan donHang = new DonHangBan();
                donHang.setID(rs.getInt("ID"));
                donHang.setIdNhanVienLap(rs.getInt("idNhanVienLap"));
                donHang.setIdKhachHang(rs.getInt("idKhachHang"));
                donHang.setIdTrangThai(rs.getInt("idTrangThai"));
                donHang.setNgayLap(rs.getDate("NgayLap"));
                donHang.setTongTien( rs.getFloat("TongTien"));
            DonBanHang.add(donHang);
        }
        return DonBanHang;
    }
    public static void main(String[] args) {
        DonHangBanDAO dhb = new DonHangBanDAO();
        try {
            dhb.listDonHangBan();
        } catch (SQLException ex) {
            Logger.getLogger(DonHangBanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
