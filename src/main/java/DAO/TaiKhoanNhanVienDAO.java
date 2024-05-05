/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author tranconghung
 */
public class TaiKhoanNhanVienDAO extends MyDatabaseManager{
    TaikhoanNhanvien taikhoanNhanvien = new TaikhoanNhanvien();
     private MyDatabaseManager xuLyDB = null;
    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet resultSet = null;
    public TaiKhoanNhanVienDAO(){
        TaiKhoanNhanVienDAO.connectDB();
    }
     public ResultSet LoginQuanTri(String TenDangNhap, String MatKhau){  
            PreparedStatement ps = null;
            ResultSet resultLogin = null;
            Connection connection = null;
            
            try {
                    xuLyDB = new MyDatabaseManager();
                    connection = xuLyDB.connectDB();
                    String query = "SELECT * FROM taikhoannhanvien\n" + "WHERE TenDangNhap = ? AND MatKhau = ? ";

                    ps = connection.prepareStatement(query);
                    ps.setString(1, TenDangNhap);
                    ps.setString(2, MatKhau);

                    resultLogin = ps.executeQuery();
                    
                    return resultLogin;
                    
                }catch(Exception e){
                        System.out.print(e);
                }
 
          return null;
        }
    public void listTaiKhoanNhanVien() throws SQLException{
        String sql = "select * from taikhoannhanvien";
        ResultSet rs = TaiKhoanNhanVienDAO.doReadQuery(sql);
        if(rs != null){
            int i = 1;
            System.out.println("TT \t TenDangNhap \t IDNhanVien \t\t MatKhau\t TrangThai \t AnhDaiDien");
            while (rs.next()) {
                 System.out.print(i + "\t" + rs.getString("TenDangNhap"));
                System.out.println("\t\t" + rs.getInt("IDNhanVien")
                        + "\t\t\t" + rs.getString("MatKhau")
                        + "\t\t\t" + rs.getString("TrangThai")
                        + "\t\t\t" + rs.getString("AnhDaiDien"));
                i++;
            }
        }
    }
    public ArrayList readTaiKhoanNhanVien() throws SQLException{
        String sql = "SELECT taikhoannhanvien.IDNhanVien,TenDangNhap,MatKhau,TrangThai,AnhDaiDien\n"+
               "FROM taikhoannhanvien,nhanvien\n"+
               "WHERE taikhoannhanvien.IDNhanVien = nhanvien.ID";
        ResultSet rs = TaiKhoanNhanVienDAO.doReadQuery(sql);
        ArrayList list = new ArrayList();
        if(rs != null){
            int i = 1;
            while (rs.next()) {
                TaikhoanNhanvien taikhoanNhanvien = new TaikhoanNhanvien();
                taikhoanNhanvien.setTenDangNhap(rs.getString("TenDangNhap"));
                taikhoanNhanvien.setID(rs.getInt("IDNhanVien"));
                taikhoanNhanvien.setMatKhau(rs.getString("MatKhau"));
                taikhoanNhanvien.setTrangThai(rs.getInt("TrangThai"));
                taikhoanNhanvien.setAnhDaiDien(rs.getBytes("AnhDaiDien"));
                list.add(taikhoanNhanvien);
            }
        }
        return list;
    }
    public TaikhoanNhanvien getTaikhoanNhanvien(String TenDangNhap) throws SQLException{
         String sql = "SELECT taikhoannhanvien.TenDangNhap,IDNhanVien,MatKhau,TrangThai,AnhDaiDien\n"+
               "FROM taikhoannhanvien,nhanvien\n"+
               "WHERE taikhoannhanvien.IDNhanVien = nhanvien.ID AND taikhoannhanvien.TenDangNhap = ?";
         PreparedStatement p = TaiKhoanNhanVienDAO.connectDB().prepareStatement(sql);
         p.setString(1, TenDangNhap);
         ResultSet rs = p.executeQuery();
         
         TaikhoanNhanvien taikhoanNhanvien = new TaikhoanNhanvien();
         if(rs != null){
             int i = 1;
             while (rs.next()) {
                taikhoanNhanvien.setTenDangNhap(rs.getString("TenDangNhap"));
                taikhoanNhanvien.setID(rs.getInt("IDNhanVien"));
                taikhoanNhanvien.setMatKhau(rs.getString("MatKhau"));
                taikhoanNhanvien.setTrangThai(rs.getInt("TrangThai"));
                taikhoanNhanvien.setAnhDaiDien(rs.getBytes("AnhDaiDien"));
             }
         }
         return  taikhoanNhanvien;
    }
    public TaikhoanNhanvien getIDTaikhoanNhanvien(int IDNhanVien) throws SQLException{
         String sql = "SELECT taikhoannhanvien.TenDangNhap,IDNhanVien,MatKhau,TrangThai,AnhDaiDien\n"+
               "FROM taikhoannhanvien,nhanvien\n"+
               "WHERE taikhoannhanvien.IDNhanVien = nhanvien.ID AND taikhoannhanvien.IDNhanVien = ?";
         PreparedStatement p = TaiKhoanNhanVienDAO.connectDB().prepareStatement(sql);
         p.setInt(1, IDNhanVien);
         ResultSet rs = p.executeQuery();
         
         TaikhoanNhanvien taikhoanNhanvien = new TaikhoanNhanvien();
         if(rs != null){
             int i = 1;
             while (rs.next()) {
                taikhoanNhanvien.setTenDangNhap(rs.getString("TenDangNhap"));
                taikhoanNhanvien.setID(rs.getInt("IDNhanVien"));
                taikhoanNhanvien.setMatKhau(rs.getString("MatKhau"));
                taikhoanNhanvien.setTrangThai(rs.getInt("TrangThai"));
                taikhoanNhanvien.setAnhDaiDien(rs.getBytes("AnhDaiDien"));
             }
         }
         return  taikhoanNhanvien;
    }
    public int insertTaiKhoanNV(TaikhoanNhanvien tknv) throws SQLException{
        String sql = "INSERT into taikhoannhanvien (TenDangNhap,IDNhanVien,MatKhau,TrangThai,AnhDaiDien) value (?,?,?,?,?)";
        PreparedStatement p = TaiKhoanNhanVienDAO.connectDB().prepareStatement(sql);
        p.setString(1, tknv.getTenDangNhap());
        p.setInt(2, tknv.getID());
        p.setString(3, tknv.getMatKhau());
        p.setInt(4, tknv.getTrangThai());
        p.setBytes(5, tknv.getAnhDaiDien());
        int result = p.executeUpdate();
        return result;
    }
    public int updateTaiKhoanNV(TaikhoanNhanvien tknv) throws SQLException{
        String sql = "UPDATE taikhoannhanvien set TenDangNhap=?,MatKhau=?,TrangThai=?,AnhDaiDien=?"
                +"WHERE IDNhanVien = ?";
                
        PreparedStatement p = TaiKhoanNhanVienDAO.connectDB().prepareStatement(sql);
        p.setString(1, tknv.getTenDangNhap());
        p.setString(2, tknv.getMatKhau());
        p.setInt(3, tknv.getTrangThai());
        p.setBytes(4, tknv.getAnhDaiDien());
        p.setInt(5, tknv.getID());
        int result = p.executeUpdate();
        return result;
    }
    public  boolean deleteTaiKhoanNV(TaikhoanNhanvien tknv) throws SQLException{
         String query = "DELETE FROM taikhoannhanvien WHERE TenDangNhap = ?";
        PreparedStatement p = NhanVienDAO.connectDB().prepareStatement(query);
        p.setString(1, tknv.getTenDangNhap());
        int result = p.executeUpdate();

        return true;
    }
    public List findTaiKhoanNhanVien(String TenDangNhap) throws SQLException{
        String sql = "SELECT * FROM taikhoannhanvien WHERE TenDangNhap LIKE ?";
        PreparedStatement p = BienBanKiemKeDAO.connectDB().prepareStatement(sql);
        p.setString(1, "%" + TenDangNhap + "%");
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();
        if(rs != null){
            int i = 1;
            while (rs.next()) {
                TaikhoanNhanvien taikhoanNhanvien = new TaikhoanNhanvien();
                taikhoanNhanvien.setTenDangNhap(rs.getString("TenDangNhap"));
                taikhoanNhanvien.setID(rs.getInt("IDNhanVien"));
                taikhoanNhanvien.setMatKhau(rs.getString("MatKhau"));
                taikhoanNhanvien.setTrangThai(rs.getInt("TrangThai"));
                taikhoanNhanvien.setAnhDaiDien(rs.getBytes("AnhDaiDien"));
                list.add(taikhoanNhanvien);
            }
        }
        return list;
    }
    
    public static void main(String[] args) {
        TaiKhoanNhanVienDAO tknvdao = new TaiKhoanNhanVienDAO();
        try {
            tknvdao.listTaiKhoanNhanVien();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanNhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
