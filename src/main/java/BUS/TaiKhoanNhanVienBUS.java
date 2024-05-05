/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.*;
import DTO.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author tranconghung
 */
public class TaiKhoanNhanVienBUS {
    TaiKhoanNhanVienDAO taiKhoanNhanVienDAO;
    TaiKhoanNhanVienDAO TaiKhoanNhanVienDAO = new TaiKhoanNhanVienDAO();
    
    public ResultSet LoginQuanTri(String TenDangNhap, String MatKhau){
        ResultSet resultLogin = TaiKhoanNhanVienDAO.LoginQuanTri(TenDangNhap, MatKhau);
        return resultLogin;
    }
    public TaiKhoanNhanVienBUS(){
        taiKhoanNhanVienDAO = new TaiKhoanNhanVienDAO();
    }
    public List LoadTaiKhoanNhanVien(int page) throws SQLException{
        int numofrecords = 30;
        ArrayList list = taiKhoanNhanVienDAO.readTaiKhoanNhanVien();
        int size = list.size();
        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;

        return list.subList(from, Math.min(to, size));
    }
    public TaikhoanNhanvien getTaikhoanNhanvien(String TenDangNhap) throws SQLException{
        TaikhoanNhanvien taikhoanNhanvien = taiKhoanNhanVienDAO.getTaikhoanNhanvien(TenDangNhap);
        return  taikhoanNhanvien;
    }
    public TaikhoanNhanvien getIDTaikhoanNhanvien(int IDNhanVien) throws SQLException{
        TaikhoanNhanvien taikhoanNhanvien = taiKhoanNhanVienDAO.getIDTaikhoanNhanvien(IDNhanVien);
        return  taikhoanNhanvien;
    }
    public int insertTaiKhoanNV(TaikhoanNhanvien tknv) throws SQLException{
        int result = taiKhoanNhanVienDAO.insertTaiKhoanNV(tknv);
        return result;
    }
    public int updateTaiKhoanNV(TaikhoanNhanvien tknv) throws SQLException{
        int result = taiKhoanNhanVienDAO.updateTaiKhoanNV(tknv);
        return result;
    }
    public  boolean deleteTaiKhoanNV(TaikhoanNhanvien tknv) throws SQLException{
        boolean result = taiKhoanNhanVienDAO.deleteTaiKhoanNV(tknv);
        return result;
    }
    public List findTaiKhoanNhanVien(String TenDangNhap) throws SQLException{
        List list = new ArrayList();
        list = taiKhoanNhanVienDAO.findTaiKhoanNhanVien(TenDangNhap);
        return list;
    }
}
