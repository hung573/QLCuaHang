/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DonHangMua;
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

public class DonHangMuaDAO extends MyDatabaseManager{
    DonHangMua donHang = new DonHangMua();
    DecimalFormat DecimalFormat = new DecimalFormat("#");
    public DonHangMuaDAO(){
        DonHangMuaDAO.connectDB();
    }
    public void listDonHangMua() throws SQLException{
        String sql = "select * from donhangmua";
        ResultSet rs = DonHangMuaDAO.doReadQuery(sql);
        if(rs != null){
            int i = 1;
            System.out.println("TT \t ID \t idNhanVienLap \t\t idNguonHang\t idTrangThai \t NgayLap \t TongTien");
            while (rs.next()) {
                 System.out.print(i + "\t" + rs.getInt("ID"));
                System.out.println("\t\t" + rs.getInt("idNhanVienLap")
                        + "\t\t\t" + rs.getInt("idNguonHang")
                        + "\t\t\t" + rs.getInt("idTrangThai")
                        + "\t\t\t" + rs.getDate("NgayLap")
                        + "\t\t\t" + rs.getFloat("TongTien"));
                i++;
            }
        }
    }
//    public double ThanhTien(){
//        ChiTietDonHangMua ctdh = new ChiTietDonHangMua();
//        ctdh.
//        return ctdh.getThanhTien();
//    }
    public ArrayList readDonHangMua() throws SQLException{
        String sql = "select * from donhangmua where ID > 0";
        ResultSet rs = DonHangMuaDAO.doReadQuery(sql);
        ArrayList arrayList = new ArrayList();
        if(rs != null){
            int i = 1;
            while (rs.next()) {
                DonHangMua donHang = new DonHangMua();
                donHang.setID(rs.getInt("ID"));
                donHang.setIdNhanVienLap(rs.getInt("idNhanVienLap"));
                donHang.setIdNguonHang(rs.getInt("idNguonHang"));
                donHang.setIdTrangThai(rs.getInt("idTrangThai"));
                donHang.setNgayLap(rs.getDate("NgayLap"));
                donHang.setTongTien(rs.getFloat("TongTien"));
                arrayList.add(donHang);
            }
        }
        return  arrayList;
    }
    public DonHangMua getDonHangMua(int ID) throws SQLException{
        String sql = "select * from donhangmua where ID = ?";
        PreparedStatement p = DonHangMuaDAO.connectDB().prepareStatement(sql);
        p.setInt(1, ID);
        ResultSet rs  = p.executeQuery();
        
        DonHangMua donHang = new DonHangMua();
        if(rs != null){
            int i = 1;
            while(rs.next()){
                donHang.setID(rs.getInt("ID"));
                donHang.setIdNhanVienLap(rs.getInt("idNhanVienLap"));
                donHang.setIdNguonHang(rs.getInt("idNguonHang"));
                donHang.setIdTrangThai(rs.getInt("idTrangThai"));
//                nhanVien.setNgaySinh(rs.getString("NgaySinh"));
                donHang.setNgayLap(rs.getDate("NgayLap"));
                donHang.setTongTien(rs.getFloat("TongTien"));
            }
        }
        return donHang;
    }
    public int saveDonHangMua(DonHangMua donHang) throws SQLException{
        String sql = "Insert donhangmua (ID,idNhanVienLap,idNguonHang,idTrangThai,NgayLap,TongTien) value (?,?,?,?,?,?)";
        PreparedStatement p = DonHangMuaDAO.connectDB().prepareStatement(sql);
        p.setInt(1, donHang.getID());
        p.setInt(2, donHang.getIdNhanVienLap());
        p.setInt(3, donHang.getIdNguonHang());
        p.setInt(4, donHang.getIdTrangThai());
        p.setDate(5, donHang.getNgayLap());
        p.setFloat(6, donHang.getTongTien());
        int result = p.executeUpdate();
        return result;
    }
    public  int updateDonHangMua (DonHangMua donHang) throws SQLException{
        String sql = "Update donhangmua SET idNhanVienLap = ? , idNguonHang = ? , idTrangThai = ? , NgayLap = ? , TongTien = ?"
                + " WHERE ID = ?";
        PreparedStatement p = DonHangMuaDAO.connectDB().prepareStatement(sql);
        
        p.setInt(1, donHang.getIdNhanVienLap());
        p.setInt(2, donHang.getIdNguonHang());
        p.setInt(3, donHang.getIdTrangThai());
        p.setDate(4, donHang.getNgayLap());
        p.setFloat(5, donHang.getTongTien());
        p.setInt(6, donHang.getID());
        int result = p.executeUpdate();
        return result;
    }
    public boolean deleteDonHangMua(DonHangMua donHang) throws SQLException {
        String query = "DELETE FROM donhangmua WHERE ID = ?";
        PreparedStatement p = DonHangMuaDAO.connectDB().prepareStatement(query);
        p.setInt(1, donHang.getID());
        int result = p.executeUpdate();

        return true;
    }
    public List findDonHangMua(String idNguonHang) throws SQLException{
        String sql = "SELECT * FROM donhangmua WHERE  idNguonHang LIKE ?";
        PreparedStatement p = DonHangMuaDAO.connectDB().prepareStatement(sql);
        p.setString(1,idNguonHang);
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();
        
        if(rs != null){
            int i = 1;
            while (rs.next()) {
                DonHangMua donHang = new DonHangMua();
                donHang.setID(rs.getInt("ID"));
                donHang.setIdNhanVienLap(rs.getInt("idNhanVienLap"));
                donHang.setIdNguonHang(rs.getInt("idNguonHang"));
                donHang.setIdTrangThai(rs.getInt("idTrangThai"));
                donHang.setNgayLap(rs.getDate("NgayLap"));
                donHang.setTongTien(rs.getFloat("TongTien"));
                list.add(donHang);
            }
        }
        return list;
    }
    public ArrayList<DonHangMua> GetAll() throws Exception {
        String sql = "select * from donhangmua";
        ResultSet rs = DonHangMuaDAO.doReadQuery(sql);
        ArrayList<DonHangMua> DonMuaHang = new ArrayList<>();
        while ( rs.next() ) {
            DonHangMua donHang = new DonHangMua();
                donHang.setID(rs.getInt("ID"));
                donHang.setIdNhanVienLap(rs.getInt("idNhanVienLap"));
                donHang.setIdNguonHang(rs.getInt("idNguonHang"));
                donHang.setIdTrangThai(rs.getInt("idTrangThai"));
                donHang.setNgayLap(rs.getDate("NgayLap"));
                donHang.setTongTien( rs.getFloat("TongTien"));
            DonMuaHang.add(donHang);
        }
        return DonMuaHang;
    }
    public static void main(String[] args) {
        DonHangMuaDAO dhb = new DonHangMuaDAO();
        try {
            dhb.listDonHangMua();
        } catch (SQLException ex) {
            Logger.getLogger(DonHangMuaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
