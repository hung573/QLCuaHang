package DTO;

import java.sql.Date;


public class KhachHang {
    private int ID;
    private String TenKhachHang, SoDienThoai, Email, DiaChi;
    private String GioiTinh;
    private Date NgaySinh;

    public KhachHang() {
    }

    public KhachHang(int ID, String TenKhachHang, String SoDienThoai, String Email, String DiaChi, String GioiTinh, Date NgaySinh) {
        this.ID = ID;
        this.TenKhachHang = TenKhachHang;
        this.SoDienThoai = SoDienThoai;
        this.Email = Email;
        this.DiaChi = DiaChi;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }
    
    
}
