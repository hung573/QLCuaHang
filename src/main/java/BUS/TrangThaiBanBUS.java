/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.TrangThaiBan;
import DAO.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author VO THANH HOA
 */
public class TrangThaiBanBUS {
    TrangThaiBanDAO trangThaiDAO;
    public  TrangThaiBanBUS(){
        trangThaiDAO = new TrangThaiBanDAO();
    }
    public List LoadTrangThaiBan(int page) throws SQLException{
        int numfrecords = 100;
        ArrayList list = trangThaiDAO.readTrangThaiBan();
        int size = list.size();
        int from, to;
        from = (page - 1) * numfrecords;
        to = page * numfrecords;
        
        return list.subList(from, Math.min(to,size));
    }
    public TrangThaiBan getTrangThaiBan(int ID) throws SQLException{
        TrangThaiBan trangThai = trangThaiDAO.getTrangThaiBan(ID);
        return trangThai;
    }
    public int saveTrangThaiBan(TrangThaiBan trangThai) throws SQLException{
        int result = trangThaiDAO.saveTrangThaiBan(trangThai);
        return result;
    }
    public boolean deleteTrangThaiBan(TrangThaiBan trangThai) throws SQLException {
        boolean result = trangThaiDAO.deleteTrangThaiBan(trangThai);
        return result;
    }
}
