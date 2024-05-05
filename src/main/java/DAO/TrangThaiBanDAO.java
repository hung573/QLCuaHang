/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TrangThaiBan;
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
/**
 *
 * @author VO THANH HOA
 */
public class TrangThaiBanDAO extends MyDatabaseManager{
    TrangThaiBan trangThai = new TrangThaiBan();
    public TrangThaiBanDAO(){
        TrangThaiBanDAO.connectDB();
    }
    public void listTrangThaiBan() throws SQLException{
        String sql = "select * from trangthaiban";
        ResultSet rs = TrangThaiBanDAO.doReadQuery(sql);
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
    public ArrayList readTrangThaiBan() throws SQLException{
        String sql = "select * from trangthaiban where ID > 0";
        ResultSet rs = TrangThaiBanDAO.doReadQuery(sql);
        ArrayList arrayList = new ArrayList();
        if(rs != null){
            int i = 1;
            while (rs.next()) {
                TrangThaiBan trangThai = new TrangThaiBan();
                trangThai.setID(rs.getInt("ID"));
                trangThai.setTenTrangThai(rs.getString("TenTrangThai"));
                arrayList.add(trangThai);
            }
        }
        return  arrayList;
    }
    public TrangThaiBan getTrangThaiBan(int ID) throws SQLException{
        String sql = "select * from trangthaiban where ID = ?";
        PreparedStatement p = TrangThaiBanDAO.connectDB().prepareStatement(sql);
        p.setInt(1, ID);
        ResultSet rs  = p.executeQuery();
        
        TrangThaiBan trangThai = new TrangThaiBan();
        if(rs != null){
            int i = 1;
            while(rs.next()){
                trangThai.setID(rs.getInt("ID"));
                trangThai.setTenTrangThai(rs.getString("TenTrangThai"));
            }
        }
        return trangThai;
    }
    
    public int saveTrangThaiBan(TrangThaiBan trangThai) throws SQLException{
        String sql = "Insert trangthaiban (ID,TenTrangThai) value (?,?)";
        PreparedStatement p = TrangThaiBanDAO.connectDB().prepareStatement(sql);
        p.setInt(1, trangThai.getID());
        p.setString(2, trangThai.getTenTrangThai());
        int result = p.executeUpdate();
        return result;
    }
    
    public boolean deleteTrangThaiBan(TrangThaiBan trangThai) throws SQLException {
        String query = "DELETE FROM trangthaiban WHERE ID = ?";
        PreparedStatement p = TrangThaiBanDAO.connectDB().prepareStatement(query);
        p.setInt(1, trangThai.getID());
        int result = p.executeUpdate();

        return true;
    }
    
    public static void main(String[] args) {
        TrangThaiBanDAO nvdao = new TrangThaiBanDAO();
        try {
            nvdao.listTrangThaiBan();
        } catch (SQLException ex) {
            Logger.getLogger(TrangThaiBanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
