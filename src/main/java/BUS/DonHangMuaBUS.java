/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.DonHangMua;
import DAO.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DonHangMuaBUS {
    DonHangMuaDAO donHangDAO;
    public  DonHangMuaBUS(){
        donHangDAO = new DonHangMuaDAO();
    }
    public List LoadDonHangMua(int page) throws SQLException{
        int numfrecords = 100;
        ArrayList list = donHangDAO.readDonHangMua();
        int size = list.size();
        int from, to;
        from = (page - 1) * numfrecords;
        to = page * numfrecords;
        
        return list.subList(from, Math.min(to,size));
    }
    public DonHangMua getDonHangMua(int ID) throws SQLException{
        DonHangMua donHang = donHangDAO.getDonHangMua(ID);
        return donHang;
    }
    public int saveDonHangMua(DonHangMua donHang) throws SQLException{
        int result = donHangDAO.saveDonHangMua(donHang);
        return result;
    }
    public int updateDonHangMua(DonHangMua donHang) throws SQLException{
        int result = donHangDAO.updateDonHangMua(donHang);
        return result;
    }
    public boolean deleteDonHangMua(DonHangMua donHang) throws SQLException {
        boolean result = donHangDAO.deleteDonHangMua(donHang);
        return result;
    }
    public List findDonHangMua(String idNguonHang) throws SQLException{
        List list = new ArrayList();
        list = donHangDAO.findDonHangMua(idNguonHang);
        return list;
    }
    public ArrayList<DonHangMua> getHoaDonAll() throws Exception{
        ArrayList<DonHangMua> Danhsachhoadon = donHangDAO.GetAll();
        return Danhsachhoadon;
    }
}
    
