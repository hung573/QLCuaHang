/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.LoaiSanPhamDAO;
import DTO.LoaiSanPham;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LoaiSanPhamBUS {
    LoaiSanPhamDAO loaisanphamDAO;
    public LoaiSanPhamBUS(){
        loaisanphamDAO = new LoaiSanPhamDAO();
    }
    public List LoadLoaiSanPham(int page) throws SQLException{
        int numfrecords = 100;
        ArrayList list = loaisanphamDAO.readLoaiSanPham();
        int size = list.size();
        int from, to;
        from = (page - 1) * numfrecords;
        to = page * numfrecords;
        return list.subList(from, Math.min(to,size));
    }
    
    public LoaiSanPham getLoaiSanPham(int ID) throws SQLException{
        LoaiSanPham sanPham =  loaisanphamDAO.getLoaiSanPham(ID);
        return sanPham;
    }
    
    public int saveLoaiSanPham(LoaiSanPham sanPham) throws SQLException{
        int result = loaisanphamDAO.saveLoaiSanPham(sanPham);
        return result;
    }
    public int updateLoaiSanPham(LoaiSanPham sanPham) throws SQLException{
        int result = loaisanphamDAO.updateLoaiSanPham(sanPham);
        return result;
    }
    public boolean deleteLoaiSanPham(LoaiSanPham sanPham) throws SQLException {
        boolean result = loaisanphamDAO.deleteLoaiSanPham(sanPham);
        return result;
    }
}
