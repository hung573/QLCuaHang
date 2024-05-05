package DAO;

import DTO.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhachHangDAO extends MyDatabaseManager{
    KhachHang khachhang = new KhachHang();

    public KhachHangDAO() {
        KhachHangDAO.connectDB();
    }
    
    public void listKhachHang() throws SQLException{
        String sql = "select * from khachhang";
        ResultSet rs = KhachHangDAO.doReadQuery(sql);
        if(rs != null){
            int i = 1;
            System.out.println("TT \t ID \t TenKhachHang \t\t GioiTinh\t NgaySinh \t SoDienThoai \t Email \t DiaChi");
            while (rs.next()) {
                 System.out.print(i + "\t" + rs.getInt("ID"));
                System.out.println("\t\t" + rs.getString("TenKhachHang")
                        + "\t\t\t" + rs.getString("GioiTinh")
                        + "\t\t\t" + rs.getDate("NgaySinh")
                        + "\t\t\t" + rs.getString("SoDienThoai")
                        + "\t\t\t" + rs.getString("Email")
                        + "\t\t\t" + rs.getString("DiaChi"));
                i++;
            }
        }
    }
    
    public ArrayList readKhachHang() throws SQLException{
        String sql = "select * from khachhang where ID > 0";
        ResultSet rs = KhachHangDAO.doReadQuery(sql);
        ArrayList arrayList = new ArrayList();
        if(rs != null){
            int i = 1;
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setID(rs.getInt("ID"));
                kh.setTenKhachHang(rs.getString("TenKhachHang"));
                kh.setGioiTinh(rs.getString("GioiTinh"));
                kh.setNgaySinh( rs.getDate("NgaySinh"));
//                nhanVien.setNgaySinh(rs.getString("NgaySinh"));
                kh.setSoDienThoai(rs.getString("SoDienThoai"));
                kh.setEmail(rs.getString("Email"));
                kh.setDiaChi(rs.getString("DiaChi"));
                arrayList.add(kh);
            }
        }
        return  arrayList;
    }
    
    public KhachHang getKhachHang(int ID) throws SQLException{
        String sql = "select * from khachhang where ID = ?";
        PreparedStatement p = KhachHangDAO.connectDB().prepareStatement(sql);
        p.setInt(1, ID);
        ResultSet rs  = p.executeQuery();
        
        KhachHang kh = new KhachHang();
        if(rs != null){
            int i = 1;
            while(rs.next()){
                kh.setID(rs.getInt("ID"));
                kh.setTenKhachHang(rs.getString("TenKhachHang"));
                kh.setGioiTinh(rs.getString("GioiTinh"));
                kh.setNgaySinh(rs.getDate("NgaySinh"));
//                nhanVien.setNgaySinh(rs.getString("NgaySinh"));
                kh.setSoDienThoai(rs.getString("SoDienThoai"));
                kh.setEmail(rs.getString("Email"));
                kh.setDiaChi(rs.getString("DiaChi"));
            }
        }
        return kh;
    }
    
    public int saveKhachHang(KhachHang kh) throws SQLException{
        String sql = "Insert khachhang (ID,TenKhachHang,GioiTinh,NgaySinh,SoDienThoai,Email,DiaChi) value (?,?,?,?,?,?,?)";
        PreparedStatement p = KhachHangDAO.connectDB().prepareStatement(sql);
        p.setInt(1, kh.getID());
        p.setString(2, kh.getTenKhachHang());
        p.setString(3, kh.getGioiTinh());
        p.setDate(4, kh.getNgaySinh());
//        p.setString(4, nhanVien.getNgaySinh());
        p.setString(5, kh.getSoDienThoai());
        p.setString(6, kh.getEmail());
        p.setString(7, kh.getDiaChi());
        int result = p.executeUpdate();
        return result;
    }
    
    public  int updateKhachHang (KhachHang kh) throws SQLException{
        String sql = "Update khachhang SET TenKhachHang = ? , GioiTinh = ? , NgaySinh = ? , SoDienThoai = ? , Email = ?, DiaChi = ? "
                + " WHERE ID = ?";
        PreparedStatement p = KhachHangDAO.connectDB().prepareStatement(sql);
        
        p.setString(1, kh.getTenKhachHang());
        p.setString(2, kh.getGioiTinh());
        p.setDate(3, kh.getNgaySinh());
//        p.setString(3, nhanVien.getNgaySinh());
        p.setString(4, kh.getSoDienThoai());
        p.setString(5, kh.getEmail());
        p.setString(6, kh.getDiaChi());
        p.setInt(7, kh.getID());
        int result = p.executeUpdate();
        return result;
    }
    
    public boolean deleteKhachHang(KhachHang kh) throws SQLException {
        String query = "DELETE FROM khachhang WHERE ID = ?";
        PreparedStatement p = KhachHangDAO.connectDB().prepareStatement(query);
        p.setInt(1, kh.getID());
        int result = p.executeUpdate();

        return true;
    }
    
    public List findKhachHang(String TenKhachHang) throws SQLException{
        String sql = "SELECT * FROM khachhang WHERE  TenKhachHang LIKE ?";
        PreparedStatement p = KhachHangDAO.connectDB().prepareStatement(sql);
        p.setString(1, "%" + TenKhachHang + "%");
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();
        
        if(rs != null){
            int i = 1;
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setID(rs.getInt("ID"));
                kh.setTenKhachHang(rs.getString("TenKhachHang"));
                kh.setGioiTinh(rs.getString("GioiTinh"));
                kh.setNgaySinh(rs.getDate("NgaySinh"));
//                nhanVien.setNgaySinh(rs.getString("NgaySinh"));
                kh.setSoDienThoai(rs.getString("SoDienThoai"));
                kh.setEmail(rs.getString("Email"));
                kh.setDiaChi(rs.getString("DiaChi"));
                list.add(kh);
            }
        }
        return list;
    }
}
