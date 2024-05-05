/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.DonHangBan;
import DAO.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author VO THANH HOA
 */
public class DonHangBanBUS {
    DonHangBanDAO donHangDAO;
    public  DonHangBanBUS(){
        donHangDAO = new DonHangBanDAO();
    }
    public List LoadDonHangBan(int page) throws SQLException{
        int numfrecords = 100;
        ArrayList list = donHangDAO.readDonHangBan();
        int size = list.size();
        int from, to;
        from = (page - 1) * numfrecords;
        to = page * numfrecords;
        
        return list.subList(from, Math.min(to,size));
    }
    public DonHangBan getDonHangBan(int ID) throws SQLException{
        DonHangBan donHang = donHangDAO.getDonHangBan(ID);
        return donHang;
    }
    public int saveDonHangBan(DonHangBan donHang) throws SQLException{
        int result = donHangDAO.saveDonHangBan(donHang);
        return result;
    }
    public int updateDonHangBan(DonHangBan donHang) throws SQLException{
        int result = donHangDAO.updateDonHangBan(donHang);
        return result;
    }
    public boolean deleteDonHangBan(DonHangBan donHang) throws SQLException {
        boolean result = donHangDAO.deleteDonHangBan(donHang);
        return result;
    }
    public List findDonHangBan(String idKhachHang) throws SQLException{
        List list = new ArrayList();
        list = donHangDAO.findDonHangBan(idKhachHang);
        return list;
    }
    public ArrayList<DonHangBan> getHoaDonAll() throws Exception{
        ArrayList<DonHangBan> Danhsachhoadon = donHangDAO.GetAll();
        return Danhsachhoadon;
    }
}
    
