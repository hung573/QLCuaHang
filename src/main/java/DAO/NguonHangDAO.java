package DAO;

import DTO.*;
import GUI.QuanLyNguonHang_GUI;
import GUI.SanPhamJFrame;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NguonHangDAO extends MyDatabaseManager{
    NguonHang nguonhang = new NguonHang();

    public NguonHangDAO() {
        NguonHangDAO.connectDB();
    }
    
    public void listNguonHang() throws SQLException{
        String sql = "select * from nguonhang";
        ResultSet rs = NguonHangDAO.doReadQuery(sql);
        if(rs != null){
            int i = 1;
            System.out.println("TT \t ID \t TenNguonHang \t\t SoDienThoai \t Email \t DiaChi \t NgayTao \t NguoiDaiDien");
            while (rs.next()) {
                 System.out.print(i + "\t" + rs.getInt("ID"));
                System.out.println("\t\t" + rs.getString("TenNguonHang")
                        + "\t\t\t" + rs.getString("SoDienThoai")
                        + "\t\t\t" + rs.getString("Email")
                        + "\t\t\t" + rs.getString("DiaChi")
                        + "\t\t\t" + rs.getDate("NgayTao")
                        + "\t\t\t" + rs.getString("NguoiDaiDien"));
                i++;
            }
        }
    }
    
    public ArrayList readNguonHang() throws SQLException{
        String sql = "select * from nguonhang where ID > 0";
        ResultSet rs = NguonHangDAO.doReadQuery(sql);
        ArrayList arrayList = new ArrayList();
        if(rs != null){
            int i = 1;
            while (rs.next()) {
                NguonHang nh = new NguonHang();
                nh.setID(rs.getInt("ID"));
                nh.setTenNguonHang(rs.getString("TenNguonHang"));
                nh.setSoDienThoai(rs.getString("SoDienThoai"));
                nh.setEmail(rs.getString("Email"));
                nh.setDiaChi(rs.getString("DiaChi"));
                nh.setNgayTao(rs.getDate("NgayTao"));
                nh.setNguoiDaiDien(rs.getString("NguoiDaiDien"));
                arrayList.add(nh);
            }
        }
        return  arrayList;
    }
    
    public NguonHang getNguonHang(int ID) throws SQLException{
        String sql = "select * from nguonhang where ID = ?";
        PreparedStatement p = NguonHangDAO.connectDB().prepareStatement(sql);
        p.setInt(1, ID);
        ResultSet rs  = p.executeQuery();
        
        NguonHang nh = new NguonHang();
        if(rs != null){
            int i = 1;
            while(rs.next()){
                nh.setID(rs.getInt("ID"));
                nh.setTenNguonHang(rs.getString("TenNguonHang"));
                nh.setSoDienThoai(rs.getString("SoDienThoai"));
                nh.setEmail(rs.getString("Email"));
                nh.setDiaChi(rs.getString("DiaChi"));
                nh.setNgayTao(rs.getDate("NgayTao"));
                nh.setNguoiDaiDien(rs.getString("NguoiDaiDien"));
                
            }
        }
        return nh;
    }
    
    public int saveNguonHang(NguonHang nh) throws SQLException{
        String sql = "Insert nguonhang (ID,TenNguonHang,SoDienThoai,Email,DiaChi,NgayTao,NguoiDaiDien) value (?,?,?,?,?,?,?)";
        PreparedStatement p = KhachHangDAO.connectDB().prepareStatement(sql);
        p.setInt(1, nh.getID());
        p.setString(2, nh.getTenNguonHang());
        p.setString(3, nh.getSoDienThoai());
        p.setString(4, nh.getEmail());
        p.setString(5, nh.getDiaChi());
        p.setDate(6, nh.getNgayTao());
        p.setString(7, nh.getNguoiDaiDien());
        int result = p.executeUpdate();
        return result;
    }
    
    public  int updateNguonHang (NguonHang nh) throws SQLException{
        String sql = "Update nguonhang SET TenNguonHang = ? , SoDienThoai = ? , Email = ? , DiaChi = ? , NgayTao = ? , NguoiDaiDien = ?"
                + " WHERE ID = ?";
        PreparedStatement p = NguonHangDAO.connectDB().prepareStatement(sql);
        
        p.setString(1, nh.getTenNguonHang());
        p.setString(2, nh.getSoDienThoai());
        p.setString(3, nh.getEmail());
        p.setString(4, nh.getDiaChi());
        p.setDate(5, nh.getNgayTao());
        p.setString(6, nh.getNguoiDaiDien());
        p.setInt(7, nh.getID());
        int result = p.executeUpdate();
        return result;
    }
    
    public boolean deleteNguonHang(NguonHang nh) throws SQLException {
        String query = "DELETE FROM nguonhang WHERE ID = ?";
        PreparedStatement p = NguonHangDAO.connectDB().prepareStatement(query);
        p.setInt(1, nh.getID());
        int result = p.executeUpdate();

        return true;
    }
    
    public List findNguonHang(String TenNguonHang) throws SQLException{
        String sql = "SELECT * FROM nguonhang WHERE  TenNguonHang LIKE ?";
        PreparedStatement p = NguonHangDAO.connectDB().prepareStatement(sql);
        p.setString(1, "%" + TenNguonHang + "%");
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();
        
        if(rs != null){
            int i = 1;
            while (rs.next()) {
                NguonHang nh = new NguonHang();
                nh.setID(rs.getInt("ID"));
                nh.setTenNguonHang(rs.getString("TenNguonHang"));
                nh.setSoDienThoai(rs.getString("SoDienThoai"));
                nh.setEmail(rs.getString("Email"));
                nh.setDiaChi(rs.getString("DiaChi"));
                nh.setNgayTao(rs.getDate("NgayTao"));
                nh.setNguoiDaiDien(rs.getString("NguoiDaiDien"));
                list.add(nh);
            }
        }
        return list;
    }

}
