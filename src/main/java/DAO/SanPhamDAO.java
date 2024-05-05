/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.SanPham;
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
public class SanPhamDAO extends MyDatabaseManager{
    SanPham sanpham = new SanPham();
    public SanPhamDAO(){
        SanPhamDAO.connectDB();
    }
    public void listSanPham() throws SQLException{
        String sql = "select * from sanpham";
        ResultSet rs = SanPhamDAO.doReadQuery(sql);
        if(rs != null){
            int i = 1;
            System.out.println("TT \t ID \t TenSanPham \t\t IdLoaiSanPham\t Gia \t MoTa \t SoLuong \t NgaySanXuat \t HinhAnh");
            while (rs.next()) {
                 System.out.print(i + "\t" + rs.getInt("ID"));
                System.out.println("\t\t" + rs.getString("TenSanPham")
                        + "\t\t\t" + rs.getInt("IdLoaiSanPham")
                        + "\t\t\t" + rs.getFloat("Gia")
                        + "\t\t\t" + rs.getString("MoTa")
                        + "\t\t\t" + rs.getString("SoLuong")
                        + "\t\t\t" + rs.getDate("NgaySanXuat")
                        + "\t\t\t" + rs.getString("HinhAnh"));
                i++;
            }
        }
    }
    public ArrayList readSanPham() throws SQLException{
        String sql = "select * from sanpham where ID > 0";
        ResultSet rs = SanPhamDAO.doReadQuery(sql);
        ArrayList arrayList = new ArrayList();
        if(rs != null){
            while (rs.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setID(rs.getInt("ID"));
                sanPham.setTenSanPham(rs.getString("TenSanPham"));
                sanPham.setIdLoaiSanPham(rs.getInt("IdLoaiSanPham"));
                sanPham.setGia( rs.getFloat("Gia"));
//                sanPham.setGia(rs.getString("Gia"));
                sanPham.setMoTa(rs.getString("MoTa"));
                sanPham.setSoLuong(rs.getInt("SoLuong"));
                sanPham.setNgaySanXuat(rs.getDate("NgaySanXuat"));
                sanPham.setHinhAnh(rs.getString("HinhAnh"));
                arrayList.add(sanPham);
            }
        }
        return  arrayList;
    }
    public SanPham getSanPham(int ID) throws SQLException{
        String sql = "select * from sanpham where ID = ?";
        PreparedStatement p = SanPhamDAO.connectDB().prepareStatement(sql);
        p.setInt(1, ID);
        ResultSet rs  = p.executeQuery();
        
        SanPham sanPham = new SanPham();
        if(rs != null){
            while(rs.next()){
                sanPham.setID(rs.getInt("ID"));
                sanPham.setTenSanPham(rs.getString("TenSanPham"));
                sanPham.setIdLoaiSanPham(rs.getInt("IdLoaiSanPham"));
                sanPham.setGia(rs.getFloat("Gia"));
//                sanPham.setGia(rs.getString("Gia"));
                sanPham.setMoTa(rs.getString("MoTa"));
                sanPham.setSoLuong(rs.getInt("SoLuong"));
                sanPham.setNgaySanXuat(rs.getDate("NgaySanXuat"));
                sanPham.setHinhAnh(rs.getString("HinhAnh"));
            }
        }
        return sanPham;
    }
    public int saveSanPham(SanPham sanPham) throws SQLException{
        String sql = "Insert sanpham (TenSanPham,IdLoaiSanPham,Gia,MoTa,SoLuong,NgaySanXuat,HinhAnh) value (?,?,?,?,?,?,?)";
        PreparedStatement p = SanPhamDAO.connectDB().prepareStatement(sql);
        //p.setInt(1, sanPham.getID());
        p.setString(1, sanPham.getTenSanPham());
        p.setInt(2, sanPham.getIdLoaiSanPham());
        p.setDouble(3, sanPham.getGia());
        p.setString(4, sanPham.getMoTa());
        p.setInt(5, sanPham.getSoLuong());
        p.setDate(6, sanPham.getNgaySanXuat());
        p.setString(7, sanPham.getHinhAnh());
        int result = p.executeUpdate();
        return result;
    }
    public  int updateSanPham (SanPham sanPham) throws SQLException{
        String sql = "Update sanpham SET TenSanPham = ? , IdLoaiSanPham = ? , Gia = ? , MoTa = ? , SoLuong = ?, NgaySanXuat = ? , HinhAnh = ?"
                + " WHERE ID =" + sanPham.getID();
        PreparedStatement p = SanPhamDAO.connectDB().prepareStatement(sql);
        
        //p.setInt(1, sanPham.getID());
        p.setString(1, sanPham.getTenSanPham());
        p.setInt(2, sanPham.getIdLoaiSanPham());
        p.setDouble(3, sanPham.getGia());
        p.setString(4, sanPham.getMoTa());
        p.setInt(5, sanPham.getSoLuong());
        p.setDate(6, sanPham.getNgaySanXuat());
        p.setString(7, sanPham.getHinhAnh());
        int result = p.executeUpdate();
        return result;
    }
    public boolean deleteSanPham(SanPham sanPham) throws SQLException {
        String query = "DELETE FROM sanpham WHERE ID = ?";
        PreparedStatement p = SanPhamDAO.connectDB().prepareStatement(query);
        p.setInt(1, sanPham.getID());
        int result = p.executeUpdate();

        return true;
    }
    public List findSanPham(String TenSanPham) throws SQLException{
        String sql = "SELECT * FROM sanpham WHERE  TenSanPham LIKE ?";
        PreparedStatement p = SanPhamDAO.connectDB().prepareStatement(sql);
        p.setString(1, "%" + TenSanPham + "%");
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();
        
        if(rs != null){
            int i = 1;
            while (rs.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setID(rs.getInt("ID"));
                sanPham.setTenSanPham(rs.getString("TenSanPham"));
                sanPham.setIdLoaiSanPham(rs.getInt("IdLoaiSanPham"));
                sanPham.setGia(rs.getFloat("Gia"));
//                sanPham.setGia(rs.getString("Gia"));
                sanPham.setMoTa(rs.getString("MoTa"));
                sanPham.setSoLuong(rs.getInt("SoLuong"));
                sanPham.setNgaySanXuat(rs.getDate("NgaySanXuat"));
                list.add(sanPham);
            }
        }
        return list;
    }
     public ArrayList<SanPham> GetAll() throws Exception {
        String sql = "select * from sanpham";
        ResultSet rs = SanPhamDAO.doReadQuery(sql);
        ArrayList<SanPham> sanPhams = new ArrayList<>();
        while ( rs.next() ) {
            SanPham sanPham = new SanPham();
                sanPham.setID(rs.getInt("ID"));
                sanPham.setTenSanPham(rs.getString("TenSanPham"));
                sanPham.setIdLoaiSanPham(rs.getInt("IdLoaiSanPham"));
                sanPham.setGia(rs.getFloat("Gia"));
//                sanPham.setGia(rs.getString("Gia"));
                sanPham.setMoTa(rs.getString("MoTa"));
                sanPham.setSoLuong(rs.getInt("SoLuong"));
                sanPham.setNgaySanXuat(rs.getDate("NgaySanXuat"));
                sanPhams.add(sanPham);
        }
        return sanPhams;
    }
    public static void main(String[] args) {
        SanPhamDAO nvdao = new SanPhamDAO();
        try {
            nvdao.listSanPham();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
