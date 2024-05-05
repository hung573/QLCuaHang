/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DTO.ChiTietDonHangMua;
import DAO.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ChiTietDonHangMuaBUS {
    ChiTietDonHangMuaDAO chiTietDAO;
    public  ChiTietDonHangMuaBUS(){
        chiTietDAO = new ChiTietDonHangMuaDAO();
    }
    public List LoadChiTietDonHangMua(int page,int id) throws SQLException{
        int numfrecords = 100;
        ArrayList list = chiTietDAO.readChiTietDonHangMua(id);
        int size = list.size();
        int from, to;
        from = (page - 1) * numfrecords;
        to = page * numfrecords;
        
        return list.subList(from, Math.min(to,size));
    }
    public ChiTietDonHangMua getChiTietDonHangMua(int ID) throws SQLException{
        ChiTietDonHangMua chiTiet = chiTietDAO.getChiTietDonHangMua(ID);
        return chiTiet;
    }
    
    public int saveChiTietDonHangMua(ChiTietDonHangMua chiTiet) throws SQLException{
        int result = chiTietDAO.saveChiTietDonHangMua(chiTiet);
        return result;
    }
    
    public int updateChiTietDonHangMua(ChiTietDonHangMua chiTiet) throws SQLException{
        int result = chiTietDAO.updateChiTietDonHangMua(chiTiet);
        return result;
    }
    public boolean deleteChiTietDonHangMua(ChiTietDonHangMua nhanVien) throws SQLException {
        boolean result = chiTietDAO.deleteChiTietDonHangMua(nhanVien);
        return result;
    }
    public ChiTietDonHangMua getIDSanPham(int IdSanPham) throws SQLException{
        ChiTietDonHangMua ctdhb = chiTietDAO.getIDSanPham(IdSanPham);
        return ctdhb;
    }
    public int updateTongTien(int id) throws SQLException{
        int ctdhb = chiTietDAO.updateTongTien(id);
        return ctdhb;
    }
    
}
