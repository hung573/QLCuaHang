/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author tranconghung
 */
import java.sql.Date;

/**
 *
 * @author tranconghung
 */
public class TaikhoanNhanvien extends NhanVien{
    String TenDangNhap;
    String MatKhau;
    int TrangThai;
    byte[] AnhDaiDien;
    
    public TaikhoanNhanvien(){
        super();
    }
    
    public TaikhoanNhanvien(String TenDangNhap, String MatKhau, int TrangThai, byte[] AnhDaiDien, int ID, String TenNhanVien, String GioiTinh, Date NgaySinh, String SoDienThoai, String Email, String DiaChi) {
        super(ID, TenNhanVien, GioiTinh, NgaySinh, SoDienThoai, Email, DiaChi);
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
        this.TrangThai = TrangThai;
        this.AnhDaiDien = AnhDaiDien;
    }

 
    
    

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public byte[] getAnhDaiDien() {
        return AnhDaiDien;
    }

    public void setAnhDaiDien(byte[] AnhDaiDien) {
        this.AnhDaiDien = AnhDaiDien;
    }

    

    
    
}
