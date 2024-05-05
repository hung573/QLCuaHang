/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhanVien;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.mysql.cj.xdevapi.Result;
import java.sql.Date;
import DTO.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.crypto.Data;

/**
 *
 * @author tranconghung
 */
public class NhanVienDAO extends MyDatabaseManager{
    NhanVien nhanVien = new NhanVien();
    public NhanVienDAO(){
        NhanVienDAO.connectDB();
    }
    public void listNhanVien() throws SQLException{
        String sql = "select * from nhanvien";
        ResultSet rs = NhanVienDAO.doReadQuery(sql);
        if(rs != null){
            int i = 1;
            System.out.println("TT \t ID \t TenNhanVien \t\t GioiTinh\t NgaySinh \t SoDienThoai \t Email \t DiaChi");
            while (rs.next()) {
                 System.out.print(i + "\t" + rs.getInt("ID"));
                System.out.println("\t\t" + rs.getString("TenNhanVien")
                        + "\t\t\t" + rs.getString("GioiTinh")
                        + "\t\t\t" + rs.getDate("NgaySinh")
                        + "\t\t\t" + rs.getString("SoDienThoai")
                        + "\t\t\t" + rs.getString("Email")
                        + "\t\t\t" + rs.getString("DiaChi"));
                i++;
            }
        }
    }
    public ArrayList readNhanVien() throws SQLException{
        String sql = "select * from nhanvien where ID > 0";
        ResultSet rs = NhanVienDAO.doReadQuery(sql);
        ArrayList arrayList = new ArrayList();
        if(rs != null){
            int i = 1;
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setID(rs.getInt("ID"));
                nhanVien.setTenNhanVien(rs.getString("TenNhanVien"));
                nhanVien.setGioiTinh(rs.getString("GioiTinh"));
                nhanVien.setNgaySinh( rs.getDate("NgaySinh"));
//                nhanVien.setNgaySinh(rs.getString("NgaySinh"));
                nhanVien.setSoDienThoai(rs.getString("SoDienThoai"));
                nhanVien.setEmail(rs.getString("Email"));
                nhanVien.setDiaChi(rs.getString("DiaChi"));
                arrayList.add(nhanVien);
            }
        }
        return  arrayList;
    }
    public NhanVien getNhanVien(int ID) throws SQLException{
        String sql = "select * from nhanvien where ID = ?";
        PreparedStatement p = NhanVienDAO.connectDB().prepareStatement(sql);
        p.setInt(1, ID);
        ResultSet rs  = p.executeQuery();
        
        NhanVien nhanVien = new NhanVien();
        if(rs != null){
            int i = 1;
            while(rs.next()){
                nhanVien.setID(rs.getInt("ID"));
                nhanVien.setTenNhanVien(rs.getString("TenNhanVien"));
                nhanVien.setGioiTinh(rs.getString("GioiTinh"));
                nhanVien.setNgaySinh(rs.getDate("NgaySinh"));
//                nhanVien.setNgaySinh(rs.getString("NgaySinh"));
                nhanVien.setSoDienThoai(rs.getString("SoDienThoai"));
                nhanVien.setEmail(rs.getString("Email"));
                nhanVien.setDiaChi(rs.getString("DiaChi"));
            }
        }
        return nhanVien;
    }
    public int saveNhanvien(NhanVien nhanVien) throws SQLException{
        String sql = "Insert nhanvien (ID,TenNhanVien,GioiTinh,NgaySinh,SoDienThoai,Email,DiaChi) value (?,?,?,?,?,?,?)";
        PreparedStatement p = NhanVienDAO.connectDB().prepareStatement(sql);
        p.setInt(1, nhanVien.getID());
        p.setString(2, nhanVien.getTenNhanVien());
        p.setString(3, nhanVien.getGioiTinh());
        p.setDate(4, nhanVien.getNgaySinh());
//        p.setString(4, nhanVien.getNgaySinh());
        p.setString(5, nhanVien.getSoDienThoai());
        p.setString(6, nhanVien.getEmail());
        p.setString(7, nhanVien.getDiaChi());
        int result = p.executeUpdate();
        return result;
    }
    public  int updateNhanVien (NhanVien nhanVien) throws SQLException{
        String sql = "Update nhanvien SET TenNhanVien = ? , GioiTinh = ? , NgaySinh = ? , SoDienThoai = ? , Email = ?, DiaChi = ? "
                + " WHERE ID = ?";
        PreparedStatement p = NhanVienDAO.connectDB().prepareStatement(sql);
        
        p.setString(1, nhanVien.getTenNhanVien());
        p.setString(2, nhanVien.getGioiTinh());
        p.setDate(3, nhanVien.getNgaySinh());
//        p.setString(3, nhanVien.getNgaySinh());
        p.setString(4, nhanVien.getSoDienThoai());
        p.setString(5, nhanVien.getEmail());
        p.setString(6, nhanVien.getDiaChi());
        p.setInt(7, nhanVien.getID());
        int result = p.executeUpdate();
        return result;
    }
    public boolean deleteNhanVien(NhanVien nhanVien) throws SQLException {
        String query = "DELETE FROM nhanvien WHERE ID = ?";
        PreparedStatement p = NhanVienDAO.connectDB().prepareStatement(query);
        p.setInt(1, nhanVien.getID());
        int result = p.executeUpdate();

        return true;
    }
    public List findNhanVien(String TenNhanVien) throws SQLException{
        String sql = "SELECT * FROM nhanvien WHERE  TenNhanVien LIKE ?";
        PreparedStatement p = NhanVienDAO.connectDB().prepareStatement(sql);
        p.setString(1, "%" + TenNhanVien + "%");
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();
        
        if(rs != null){
            int i = 1;
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setID(rs.getInt("ID"));
                nhanVien.setTenNhanVien(rs.getString("TenNhanVien"));
                nhanVien.setGioiTinh(rs.getString("GioiTinh"));
                nhanVien.setNgaySinh(rs.getDate("NgaySinh"));
//                nhanVien.setNgaySinh(rs.getString("NgaySinh"));
                nhanVien.setSoDienThoai(rs.getString("SoDienThoai"));
                nhanVien.setEmail(rs.getString("Email"));
                nhanVien.setDiaChi(rs.getString("DiaChi"));
                list.add(nhanVien);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        NhanVienDAO nvdao = new NhanVienDAO();
        try {
            nvdao.listNhanVien();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
