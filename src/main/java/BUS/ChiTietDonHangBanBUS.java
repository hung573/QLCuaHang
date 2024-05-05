/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DTO.ChiTietDonHangBan;
import DAO.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author VO THANH HOA
 */
public class ChiTietDonHangBanBUS {
    ChiTietDonHangBanDAO chiTietDAO;
    public  ChiTietDonHangBanBUS(){
        chiTietDAO = new ChiTietDonHangBanDAO();
    }
    public List LoadChiTietDonHangBan(int page,int id) throws SQLException{
        int numfrecords = 100;
        ArrayList list = chiTietDAO.readChiTietDonHangBan(id);
        int size = list.size();
        int from, to;
        from = (page - 1) * numfrecords;
        to = page * numfrecords;
        
        return list.subList(from, Math.min(to,size));
    }
//    public List LoadChiTietDonHangBan(int page) throws SQLException{
//        int numfrecords = 100;
//        ArrayList list = chiTietDAO.readChiTietDonHangBan();
//        int size = list.size();
//        int from, to;
//        from = (page - 1) * numfrecords;
//        to = page * numfrecords;
//        
//        return list.subList(from, Math.min(to,size));
//    }
    public ChiTietDonHangBan getChiTietDonHangBan(int ID) throws SQLException{
        ChiTietDonHangBan chiTiet = chiTietDAO.getChiTietDonHangBan(ID);
        return chiTiet;
    }
    
    public int saveChiTietDonHangBan(ChiTietDonHangBan chiTiet) throws SQLException{
        int result = chiTietDAO.saveChiTietDonHangBan(chiTiet);
        return result;
    }
    
    public int updateChiTietDonHangBan(ChiTietDonHangBan chiTiet) throws SQLException{
        int result = chiTietDAO.updateChiTietDonHangBan(chiTiet);
        return result;
    }
    public boolean deleteChiTietDonHangBan(ChiTietDonHangBan nhanVien) throws SQLException {
        boolean result = chiTietDAO.deleteChiTietDonHangBan(nhanVien);
        return result;
    }
    public ChiTietDonHangBan getIDSanPham(int IdSanPham) throws SQLException{
        ChiTietDonHangBan ctdhb = chiTietDAO.getIDSanPham(IdSanPham);
        return ctdhb;
    }
    public int updateTongTien(int id) throws SQLException{
        int ctdhb = chiTietDAO.updateTongTien(id);
        return ctdhb;
    }
    
}
