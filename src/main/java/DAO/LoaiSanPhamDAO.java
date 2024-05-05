/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.LoaiSanPham;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class LoaiSanPhamDAO extends MyDatabaseManager{
    LoaiSanPham loaisanpham = new LoaiSanPham();
    
    public LoaiSanPhamDAO(){
        LoaiSanPhamDAO.connectDB();
    }
    
    public void listLoaiSanPham() throws SQLException{
        String sql = "select * from loaisanpham";
        ResultSet rs = SanPhamDAO.doReadQuery(sql);
        if(rs != null){
            int i = 1;
            System.out.println("TT \t ID \t TenLoaiSanPham ");
            while (rs.next()) {
                 System.out.print(i + "\t" + rs.getInt("ID"));
                System.out.println("\t\t" + rs.getString("TenLoaiSanPham"));
                i++;
            }
        }
    }
    
    public ArrayList readLoaiSanPham() throws SQLException{
        String sql = "select * from loaisanpham where ID > 0";
        ResultSet rs = SanPhamDAO.doReadQuery(sql);
        ArrayList arrayList = new ArrayList();
        if(rs != null){
            while (rs.next()) {
                LoaiSanPham sanPham = new LoaiSanPham();
                sanPham.setID(rs.getInt("ID"));
                sanPham.setTenLoaiSanPham(rs.getString("TenLoaiSanPham"));
                arrayList.add(sanPham);
            }
        }
        return  arrayList;
    }
    
    public LoaiSanPham getLoaiSanPham(int ID) throws SQLException{
        String sql = "select * from loaisanpham where ID = ?";
        PreparedStatement p = LoaiSanPhamDAO.connectDB().prepareStatement(sql);
        p.setInt(1, ID);
        ResultSet rs  = p.executeQuery();
        
        LoaiSanPham loaisanPham = new LoaiSanPham();
        if(rs != null){
            while(rs.next()){
                loaisanPham.setID(rs.getInt("ID"));
                loaisanPham.setTenLoaiSanPham(rs.getString("TenLoaiSanPham"));
            }
        }
        return loaisanPham;
    }
    public int saveLoaiSanPham(LoaiSanPham loaiSanPham) throws SQLException{
        String sql = "Insert loaisanpham (TenLoaiSanPham) value (?)";
        PreparedStatement p = LoaiSanPhamDAO.connectDB().prepareStatement(sql);

        p.setString(1, loaiSanPham.getTenLoaiSanPham());
        int result = p.executeUpdate();
        return result;
    }
    public  int updateLoaiSanPham (LoaiSanPham loaiSanPham) throws SQLException{
        String sql = "Update loaisanpham SET TenLoaiSanPham = ? "
                + " WHERE ID =" + loaiSanPham.getID();
        PreparedStatement p = LoaiSanPhamDAO.connectDB().prepareStatement(sql);
        p.setString(1, loaiSanPham.getTenLoaiSanPham());
        int result = p.executeUpdate();
        return result;
    }
    public boolean deleteLoaiSanPham(LoaiSanPham loaiSanPham) throws SQLException {
        String query = "DELETE FROM loaisanpham WHERE ID = ?";
        PreparedStatement p = LoaiSanPhamDAO.connectDB().prepareStatement(query);
        p.setInt(1, loaiSanPham.getID());
        int result = p.executeUpdate();
        return true;
    }
    public static void main(String[] args) {
        LoaiSanPhamDAO nvdao = new LoaiSanPhamDAO();
        try {
            nvdao.listLoaiSanPham();
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
