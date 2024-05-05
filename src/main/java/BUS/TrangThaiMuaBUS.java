/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.TrangThaiMua;
import DAO.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrangThaiMuaBUS {
    TrangThaiMuaDAO trangThaiDAO;
    public  TrangThaiMuaBUS(){
        trangThaiDAO = new TrangThaiMuaDAO();
    }
    public List LoadTrangThaiMua(int page) throws SQLException{
        int numfrecords = 100;
        ArrayList list = trangThaiDAO.readTrangThaiMua();
        int size = list.size();
        int from, to;
        from = (page - 1) * numfrecords;
        to = page * numfrecords;
        
        return list.subList(from, Math.min(to,size));
    }
    public TrangThaiMua getTrangThaiMua(int ID) throws SQLException{
        TrangThaiMua trangThai = trangThaiDAO.getTrangThaiMua(ID);
        return trangThai;
    }
    public int saveTrangThaiMua(TrangThaiMua trangThai) throws SQLException{
        int result = trangThaiDAO.saveTrangThaiMua(trangThai);
        return result;
    }
    public boolean deleteTrangThaiMua(TrangThaiMua trangThai) throws SQLException {
        boolean result = trangThaiDAO.deleteTrangThaiMua(trangThai);
        return result;
    }
}
