/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.*;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author tranconghung
 */
public class BienBanKiemKeDAO extends MyDatabaseManager{
    BienBanKiemKe bienBanKiemKe = new BienBanKiemKe();
    public BienBanKiemKeDAO(){
        BienBanKiemKeDAO.connectDB();
    }
    public void listBienBanKiemKe() throws SQLException{
        String sql = "select * from bienbankiemke";
        ResultSet rs = BienBanKiemKeDAO.doReadQuery(sql);
        if(rs != null){
            int i = 1;
            
            while (rs.next()) {
                 System.out.print(i + "\t" + rs.getString("ID"));
                System.out.println("\t\t" + rs.getInt("IDNguoiLap")
                        + "\t\t\t" + rs.getString("TenBienBan")
                        + "\t\t\t" + rs.getDate("NgayLap")
                        + "\t\t\t" + rs.getString("SoLuongTonKho")
                        + "\t\t\t" + rs.getString("ChenhLech")
                        + "\t\t\t" + rs.getString("LyDo")
                );
                i++;
            }
        }
    }
    public ArrayList readBienBamKiemKe() throws SQLException{
        String sql = "SELECT bienbankiemke.ID,IDNguoiLap,TenBienBan,NgayLap,SoLuongTonKho,SoLuongThucThe,ChenhLech,LyDo\n"+
                "FROM bienbankiemke,nhanvien\n"+
                "WHERE bienbankiemke.IDNguoiLap = nhanvien.ID";
        ResultSet rs = BienBanKiemKeDAO.doReadQuery(sql);
        ArrayList list = new ArrayList();
        if(rs != null){
            int i = 1;
            while (rs.next()) {
                BienBanKiemKe bbkk = new BienBanKiemKe();
                bbkk.setIdBienBan(rs.getInt("ID"));
                bbkk.setID(rs.getInt("IDNguoiLap"));
                bbkk.setTenBienBan(rs.getString("TenBienBan"));
                bbkk.setNgayLap(rs.getDate("NgayLap"));
                bbkk.setSoLuongTonKho(rs.getInt("SoLuongTonKho"));
                bbkk.setSoLuongThuc(rs.getInt("SoLuongThucThe"));
                bbkk.setChenhLech(rs.getInt("ChenhLech"));
                bbkk.setLyDo(rs.getString("LyDo"));
                list.add(bbkk);
            }
        }
        return list;
    }
    public BienBanKiemKe getBienBanKiemKe(int ID) throws SQLException{
        String sql = "SELECT bienbankiemke.ID,IDNguoiLap,TenBienBan,NgayLap,SoLuongTonKho,SoLuongThucThe,ChenhLech,LyDo\n"+
                "FROM bienbankiemke,nhanvien\n"+
                "WHERE bienbankiemke.IDNguoiLap = nhanvien.ID AND bienbankiemke.ID = ?";
        PreparedStatement p = BienBanKiemKeDAO.connectDB().prepareStatement(sql);
        p.setInt(1, ID);
        ResultSet rs = p.executeQuery();
        
        BienBanKiemKe bbkk = new BienBanKiemKe();
        if(rs != null){
            int i = 1;
            while (rs.next()) {
                bbkk.setIdBienBan(rs.getInt("ID"));
                bbkk.setID(rs.getInt("IDNguoiLap"));
                bbkk.setTenBienBan(rs.getString("TenBienBan"));
                bbkk.setNgayLap(rs.getDate("NgayLap"));
                bbkk.setSoLuongTonKho(rs.getInt("SoLuongTonKho"));
                bbkk.setSoLuongThuc(rs.getInt("SoLuongThucThe"));
                bbkk.setChenhLech(rs.getInt("ChenhLech"));
                bbkk.setLyDo(rs.getString("LyDo"));
            }
        }
        return  bbkk;
        
    }
    public int addBienBanKiemKe(BienBanKiemKe bbkk) throws SQLException{
        String sql = "insert into bienbankiemke(ID,IDNguoiLap,TenBienBan,NgayLap,SoLuongTonKho,SoLuongThucThe,ChenhLech,LyDo) value (?,?,?,?,?,?,?,?)";
        PreparedStatement p = BienBanKiemKeDAO.connectDB().prepareCall(sql);
        p.setInt(1, bbkk.getIdBienBan());
        p.setInt(2, bbkk.getID());
        p.setString(3, bbkk.getTenBienBan());
        p.setDate(4,bbkk.getNgayLap());
        p.setInt(5, bbkk.getSoLuongTonKho());
        p.setInt(6, bbkk.getSoLuongThuc());
        p.setInt(7, bbkk.getChenhLech());
        p.setString(8, bbkk.getLyDo());
        int result = p.executeUpdate();
        return result;
    }
    public int updateBienBanKiemKe(BienBanKiemKe bbkk) throws SQLException{
        String sql = "Update bienbankiemke set IDNguoiLap=?,TenBienBan=?,NgayLap=?,SoLuongTonKho=?,SoLuongThucThe=?,ChenhLech=?,LyDo=?"
                +"WHERE  ID=?";
        PreparedStatement p = BienBanKiemKeDAO.connectDB().prepareCall(sql);
        p.setInt(1, bbkk.getID());
        p.setString(2, bbkk.getTenBienBan());
        p.setDate(3,bbkk.getNgayLap());
        p.setInt(4, bbkk.getSoLuongTonKho());
        p.setInt(5, bbkk.getSoLuongThuc());
        p.setInt(6, bbkk.getChenhLech());
        p.setString(7, bbkk.getLyDo());
        p.setInt(8, bbkk.getIdBienBan());
        int result = p.executeUpdate();
        return result;
    }
    public boolean deleteBienBanKiemKe(BienBanKiemKe bbkk)throws SQLException{
        String query = "DELETE FROM bienbankiemke WHERE ID = ?";
        PreparedStatement p = NhanVienDAO.connectDB().prepareStatement(query);
        p.setInt(1, bbkk.getIdBienBan());
        int result = p.executeUpdate();

        return true;
    }
    public List findBienBanKiemKe(String TenBienBan) throws SQLException{
        String sql = "SELECT * FROM bienbankiemke WHERE  TenBienBan LIKE ?";
        PreparedStatement p = BienBanKiemKeDAO.connectDB().prepareStatement(sql);
        p.setString(1, "%" + TenBienBan + "%");
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();
        if(rs != null){
            int i = 1;
            while (rs.next()) {
                BienBanKiemKe bbkk = new BienBanKiemKe();
                bbkk.setIdBienBan(rs.getInt("ID"));
                bbkk.setID(rs.getInt("IDNguoiLap"));
                bbkk.setTenBienBan(rs.getString("TenBienBan"));
                bbkk.setNgayLap(rs.getDate("NgayLap"));
                bbkk.setSoLuongTonKho(rs.getInt("SoLuongTonKho"));
                bbkk.setSoLuongThuc(rs.getInt("SoLuongThucThe"));
                bbkk.setChenhLech(rs.getInt("ChenhLech"));
                bbkk.setLyDo(rs.getString("LyDo"));
                list.add(bbkk);
            }
        }
        return list;
    }
     public static void main(String[] args) {
        BienBanKiemKeDAO bienBanKiemKeDAO = new BienBanKiemKeDAO();
        try {
            bienBanKiemKeDAO.listBienBanKiemKe();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanNhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
