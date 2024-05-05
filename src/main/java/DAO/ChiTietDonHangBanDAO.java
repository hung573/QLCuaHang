/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChiTietDonHangBan;
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
 * @author VO THANH HOA
 */
public class ChiTietDonHangBanDAO extends MyDatabaseManager{
    ChiTietDonHangBan chiTiet = new ChiTietDonHangBan();
    DonHangBan donHangBan = new DonHangBan();
    public ChiTietDonHangBanDAO(){
        ChiTietDonHangBanDAO.connectDB();
    }
    public void listChiTietDonHangBan() throws SQLException{
        String sql = "select * from chitietdonhangban";
        ResultSet rs = ChiTietDonHangBanDAO.doReadQuery(sql);
        if(rs != null){
            int i = 1;
            System.out.println("TT \t ID \t idDonHangBan \t\t idSanPham\t SoLuong \t DonGiaApDung \t ThanhTien");
            while (rs.next()) {
                 System.out.print(i + "\t" + rs.getInt("ID"));
                System.out.println("\t\t" + rs.getInt("idDonHangBan")
                        + "\t\t\t" + rs.getInt("idSanPham")
                        + "\t\t\t" + rs.getInt("SoLuong")
                        + "\t\t\t" + rs.getDouble("DonGiaApDung")
                        + "\t\t\t" + rs.getDouble("ThanhTien"));
                i++;
            }
        }
    }
    public ArrayList readChiTietDonHangBan(int iddonhang) throws SQLException{
        String sql = "select * from chitietdonhangban where idDonHangBan = " + iddonhang;
        ResultSet rs = ChiTietDonHangBanDAO.doReadQuery(sql);
        ArrayList arrayList = new ArrayList();
        if(rs != null){
            int i = 1;
            while (rs.next()) {
                ChiTietDonHangBan chiTiet = new ChiTietDonHangBan();
                chiTiet.setId(rs.getInt("ID"));
                chiTiet.setIdDonHangBan(rs.getInt("idDonHangBan"));
                chiTiet.setIdSanPham(rs.getInt("idSanPham"));
                chiTiet.setSoLuong(rs.getInt("SoLuong"));
                chiTiet.setDonGiaApDung(rs.getDouble("DonGiaApDung"));
                chiTiet.setThanhTien(rs.getDouble("ThanhTien"));
                arrayList.add(chiTiet);
            }
        }
        return  arrayList;
    }
    public ChiTietDonHangBan getChiTietDonHangBan(int ID) throws SQLException{
        String sql = "select * from chitietdonhangban where ID = ?";
        PreparedStatement p = ChiTietDonHangBanDAO.connectDB().prepareStatement(sql);
        p.setInt(1, ID);
        ResultSet rs  = p.executeQuery();
        
        ChiTietDonHangBan chiTiet = new ChiTietDonHangBan();
        if(rs != null){
            int i = 1;
            while(rs.next()){
                chiTiet.setId(rs.getInt("ID"));
                chiTiet.setIdDonHangBan(rs.getInt("idDonHangBan"));
                chiTiet.setIdSanPham(rs.getInt("idSanPham"));
                chiTiet.setSoLuong(rs.getInt("SoLuong"));
                chiTiet.setDonGiaApDung(rs.getDouble("DonGiaApDung"));
                chiTiet.setThanhTien(rs.getDouble("ThanhTien"));
            }
        }
        return chiTiet;
    }

    public int saveChiTietDonHangBan(ChiTietDonHangBan chiTiet) throws SQLException{
        String sql = "Insert chitietdonhangban (ID,idDonHangBan,idSanPham,SoLuong,DonGiaApDung,ThanhTien) value (?,?,?,?,?,?)";
        PreparedStatement p = ChiTietDonHangBanDAO.connectDB().prepareStatement(sql);
        p.setInt(1, chiTiet.getId());
        p.setInt(2, chiTiet.getIdDonHangBan());
        p.setInt(3, chiTiet.getIdSanPham());
        p.setInt(4, chiTiet.getSoLuong());
        p.setDouble(5, chiTiet.getDonGiaApDung());
        p.setDouble(6, chiTiet.getThanhTien());
        int result = p.executeUpdate();
        return result;
    }
    public int updateTongTien (int id) throws SQLException{
        String sql = "UPDATE donhangban SET TongTien = (SELECT SUM(soluong * dongiaapdung) FROM ChiTietDonHangBan WHERE idDonHangBan = iddonhangban) WHERE ID = iddonhangban =" + id;
        PreparedStatement p = ChiTietDonHangBanDAO.connectDB().prepareStatement(sql);
        p.setInt(1, donHangBan.getID());
        int result = p.executeUpdate();
        return result;
    }
    public  int updateChiTietDonHangBan (ChiTietDonHangBan chiTiet) throws SQLException{
        String sql = "Update chitietdonhangban SET idDonHangBan = ? , idSanPham = ? , SoLuong = ? , DonGiaApDung = ? , ThanhTien = ?"
                + " WHERE ID = ?";
        PreparedStatement p = ChiTietDonHangBanDAO.connectDB().prepareStatement(sql);
        
        p.setInt(1, chiTiet.getIdDonHangBan());
        p.setInt(2, chiTiet.getIdSanPham());
        p.setInt(3, chiTiet.getSoLuong());
        p.setDouble(4, chiTiet.getDonGiaApDung());
        p.setDouble(5, chiTiet.getThanhTien());
        p.setInt(6, chiTiet.getId());
        int result = p.executeUpdate();
        return result;
    }
    public boolean deleteChiTietDonHangBan(ChiTietDonHangBan chiTiet) throws SQLException {
        String query = "DELETE FROM chitietdonhangban WHERE ID = ?";
        PreparedStatement p = ChiTietDonHangBanDAO.connectDB().prepareStatement(query);
        p.setInt(1, chiTiet.getId());
        int result = p.executeUpdate();

        return true;
    }
    public ChiTietDonHangBan getIDSanPham(int IdSanPham) throws SQLException{
        String sql = "select * from chitietdonhangban , sanpham WHERE chitietdonhangban.idSanPham = sanpham.ID AND idSanPham = ?";
        PreparedStatement p = ChiTietDonHangBanDAO.connectDB().prepareStatement(sql);
        p.setDouble(1, IdSanPham);
        ResultSet rs = p.executeQuery();
        
        ChiTietDonHangBan chiTiet = new ChiTietDonHangBan();
        if(rs != null){
            int i = 1;
            while (rs.next()) {
                chiTiet.setId(rs.getInt("ID"));
                chiTiet.setIdDonHangBan(rs.getInt("idDonHangBan"));
                chiTiet.setIdSanPham(rs.getInt("idSanPham"));
                chiTiet.setSoLuong(rs.getInt("SoLuong"));
                chiTiet.setDonGiaApDung(rs.getDouble("DonGiaApDung"));
                chiTiet.setThanhTien(rs.getDouble("ThanhTien"));
            }
        }
        return  chiTiet;
    }
   
    public static void main(String[] args) {
        ChiTietDonHangBanDAO nvdao = new ChiTietDonHangBanDAO();
        try {
            nvdao.listChiTietDonHangBan();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietDonHangBanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
