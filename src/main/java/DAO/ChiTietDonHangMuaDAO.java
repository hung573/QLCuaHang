/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChiTietDonHangMua;
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

public class ChiTietDonHangMuaDAO extends MyDatabaseManager{
    ChiTietDonHangMua chiTiet = new ChiTietDonHangMua();
    DonHangMua donHangMua = new DonHangMua();
    public ChiTietDonHangMuaDAO(){
        ChiTietDonHangMuaDAO.connectDB();
    }
    public void listChiTietDonHangMua() throws SQLException{
        String sql = "select * from chitietdonhangmua";
        ResultSet rs = ChiTietDonHangMuaDAO.doReadQuery(sql);
        if(rs != null){
            int i = 1;
            System.out.println("TT \t ID \t idDonHangMua \t\t idSanPham\t SoLuong \t DonGiaApDung \t ThanhTien");
            while (rs.next()) {
                 System.out.print(i + "\t" + rs.getInt("ID"));
                System.out.println("\t\t" + rs.getInt("idDonHangMua")
                        + "\t\t\t" + rs.getInt("idSanPham")
                        + "\t\t\t" + rs.getInt("SoLuong")
                        + "\t\t\t" + rs.getDouble("DonGiaApDung")
                        + "\t\t\t" + rs.getDouble("ThanhTien"));
                i++;
            }
        }
    }
    public ArrayList readChiTietDonHangMua(int iddonhang) throws SQLException{
        String sql = "select * from chitietdonhangmua where idDonHangMua = " + iddonhang;
        ResultSet rs = ChiTietDonHangMuaDAO.doReadQuery(sql);
        ArrayList arrayList = new ArrayList();
        if(rs != null){
            int i = 1;
            while (rs.next()) {
                ChiTietDonHangMua chiTiet = new ChiTietDonHangMua();
                chiTiet.setId(rs.getInt("ID"));
                chiTiet.setIdDonHangMua(rs.getInt("idDonHangMua"));
                chiTiet.setIdSanPham(rs.getInt("idSanPham"));
                chiTiet.setSoLuong(rs.getInt("SoLuong"));
                chiTiet.setDonGiaApDung(rs.getDouble("DonGiaApDung"));
                chiTiet.setThanhTien(rs.getDouble("ThanhTien"));
                arrayList.add(chiTiet);
            }
        }
        return  arrayList;
    }
    public ChiTietDonHangMua getChiTietDonHangMua(int ID) throws SQLException{
        String sql = "select * from chitietdonhangmua where ID = ?";
        PreparedStatement p = ChiTietDonHangMuaDAO.connectDB().prepareStatement(sql);
        p.setInt(1, ID);
        ResultSet rs  = p.executeQuery();
        
        ChiTietDonHangMua chiTiet = new ChiTietDonHangMua();
        if(rs != null){
            int i = 1;
            while(rs.next()){
                chiTiet.setId(rs.getInt("ID"));
                chiTiet.setIdDonHangMua(rs.getInt("idDonHangMua"));
                chiTiet.setIdSanPham(rs.getInt("idSanPham"));
                chiTiet.setSoLuong(rs.getInt("SoLuong"));
                chiTiet.setDonGiaApDung(rs.getDouble("DonGiaApDung"));
                chiTiet.setThanhTien(rs.getDouble("ThanhTien"));
            }
        }
        return chiTiet;
    }
    public int saveChiTietDonHangMua(ChiTietDonHangMua chiTiet) throws SQLException{
        String sql = "Insert chitietdonhangmua (ID,idDonHangMua,idSanPham,SoLuong,DonGiaApDung,ThanhTien) value (?,?,?,?,?,?)";
        PreparedStatement p = ChiTietDonHangMuaDAO.connectDB().prepareStatement(sql);
        p.setInt(1, chiTiet.getId());
        p.setInt(2, chiTiet.getIdDonHangMua());
        p.setInt(3, chiTiet.getIdSanPham());
        p.setInt(4, chiTiet.getSoLuong());
        p.setDouble(5, chiTiet.getDonGiaApDung());
        p.setDouble(6, chiTiet.getThanhTien());
        int result = p.executeUpdate();
        return result;
    }
    public int updateTongTien (int id) throws SQLException{
        String sql = "UPDATE donhangmua SET TongTien = (SELECT SUM(soluong * dongiaapdung) FROM ChiTietDonHangMua WHERE idDonHangMua = iddonhangmua) WHERE ID = iddonhangmua =" + id;
        PreparedStatement p = ChiTietDonHangMuaDAO.connectDB().prepareStatement(sql);
        p.setInt(1, donHangMua.getID());
        int result = p.executeUpdate();
        return result;
    }
    public  int updateChiTietDonHangMua (ChiTietDonHangMua chiTiet) throws SQLException{
        String sql = "Update chitietdonhangmua SET idDonHangMua = ? , idSanPham = ? , SoLuong = ? , DonGiaApDung = ? , ThanhTien = ?"
                + " WHERE ID = ?";
        PreparedStatement p = ChiTietDonHangMuaDAO.connectDB().prepareStatement(sql);
        
        p.setInt(1, chiTiet.getIdDonHangMua());
        p.setInt(2, chiTiet.getIdSanPham());
        p.setInt(3, chiTiet.getSoLuong());
        p.setDouble(4, chiTiet.getDonGiaApDung());
        p.setDouble(5, chiTiet.getThanhTien());
        p.setInt(6, chiTiet.getId());
        int result = p.executeUpdate();
        return result;
    }
    public boolean deleteChiTietDonHangMua(ChiTietDonHangMua chiTiet) throws SQLException {
        String query = "DELETE FROM chitietdonhangmua WHERE ID = ?";
        PreparedStatement p = ChiTietDonHangMuaDAO.connectDB().prepareStatement(query);
        p.setInt(1, chiTiet.getId());
        int result = p.executeUpdate();

        return true;
    }
    public ChiTietDonHangMua getIDSanPham(int IdSanPham) throws SQLException{
        String sql = "select * from chitietdonhangmua , sanpham WHERE chitietdonhangmua.idSanPham = sanpham.ID AND idSanPham = ?";
        PreparedStatement p = ChiTietDonHangMuaDAO.connectDB().prepareStatement(sql);
        p.setDouble(1, IdSanPham);
        ResultSet rs = p.executeQuery();
        
        ChiTietDonHangMua chiTiet = new ChiTietDonHangMua();
        if(rs != null){
            int i = 1;
            while (rs.next()) {
                chiTiet.setId(rs.getInt("ID"));
                chiTiet.setIdDonHangMua(rs.getInt("idDonHangMua"));
                chiTiet.setIdSanPham(rs.getInt("idSanPham"));
                chiTiet.setSoLuong(rs.getInt("SoLuong"));
                chiTiet.setDonGiaApDung(rs.getDouble("DonGiaApDung"));
                chiTiet.setThanhTien(rs.getDouble("ThanhTien"));
            }
        }
        return  chiTiet;
    }
   
    public static void main(String[] args) {
        ChiTietDonHangMuaDAO nvdao = new ChiTietDonHangMuaDAO();
        try {
            nvdao.listChiTietDonHangMua();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietDonHangMuaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
