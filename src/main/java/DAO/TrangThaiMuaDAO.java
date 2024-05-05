/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TrangThaiMua;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.mysql.cj.xdevapi.Result;
import java.sql.Date;
import DTO.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.crypto.Data;

public class TrangThaiMuaDAO extends MyDatabaseManager{
    TrangThaiMua trangThai = new TrangThaiMua();
    public TrangThaiMuaDAO(){
        TrangThaiMuaDAO.connectDB();
    }
    public void listTrangThaiMua() throws SQLException{
        String sql = "select * from trangthaimua";
        ResultSet rs = TrangThaiMuaDAO.doReadQuery(sql);
        if(rs != null){
            int i = 1;
            System.out.println("TT \t ID \t TenTrangThai");
            while (rs.next()) {
                 System.out.print(i + "\t" + rs.getInt("ID"));
                 System.out.println("\t\t" + rs.getString("TenTrangThai"));
                 i++;
            }
        }
    }
    public ArrayList readTrangThaiMua() throws SQLException{
        String sql = "select * from trangthaimua where ID > 0";
        ResultSet rs = TrangThaiMuaDAO.doReadQuery(sql);
        ArrayList arrayList = new ArrayList();
        if(rs != null){
            int i = 1;
            while (rs.next()) {
                TrangThaiMua trangThai = new TrangThaiMua();
                trangThai.setID(rs.getInt("ID"));
                trangThai.setTenTrangThai(rs.getString("TenTrangThai"));
                arrayList.add(trangThai);
            }
        }
        return  arrayList;
    }
    public TrangThaiMua getTrangThaiMua(int ID) throws SQLException{
        String sql = "select * from trangthaimua where ID = ?";
        PreparedStatement p = TrangThaiMuaDAO.connectDB().prepareStatement(sql);
        p.setInt(1, ID);
        ResultSet rs  = p.executeQuery();
        
        TrangThaiMua trangThai = new TrangThaiMua();
        if(rs != null){
            int i = 1;
            while(rs.next()){
                trangThai.setID(rs.getInt("ID"));
                trangThai.setTenTrangThai(rs.getString("TenTrangThai"));
            }
        }
        return trangThai;
    }
    
    public int saveTrangThaiMua(TrangThaiMua trangThai) throws SQLException{
        String sql = "Insert trangthaimua (ID,TenTrangThai) value (?,?)";
        PreparedStatement p = TrangThaiMuaDAO.connectDB().prepareStatement(sql);
        p.setInt(1, trangThai.getID());
        p.setString(2, trangThai.getTenTrangThai());
        int result = p.executeUpdate();
        return result;
    }
    
    public boolean deleteTrangThaiMua(TrangThaiMua trangThai) throws SQLException {
        String query = "DELETE FROM trangthaimua WHERE ID = ?";
        PreparedStatement p = TrangThaiMuaDAO.connectDB().prepareStatement(query);
        p.setInt(1, trangThai.getID());
        int result = p.executeUpdate();

        return true;
    }
    
    public static void main(String[] args) {
        TrangThaiMuaDAO nvdao = new TrangThaiMuaDAO();
        try {
            nvdao.listTrangThaiMua();
        } catch (SQLException ex) {
            Logger.getLogger(TrangThaiMuaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
