package DTO;

import java.sql.Date;

public class NguonHang {
    private int ID;
    private String TenNguonHang, SoDienThoai, Email, DiaChi, NguoiDaiDien;
    private Date NgayTao;

    public NguonHang() {
    }

    public NguonHang(int ID, String TenNguonHang, String SoDienThoai, String Email, String DiaChi, String NguoiDaiDien, Date NgayTao) {
        this.ID = ID;
        this.TenNguonHang = TenNguonHang;
        this.SoDienThoai = SoDienThoai;
        this.Email = Email;
        this.DiaChi = DiaChi;
        this.NguoiDaiDien = NguoiDaiDien;
        this.NgayTao = NgayTao;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenNguonHang() {
        return TenNguonHang;
    }

    public void setTenNguonHang(String TenNguonHang) {
        this.TenNguonHang = TenNguonHang;
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

    public String getNguoiDaiDien() {
        return NguoiDaiDien;
    }

    public void setNguoiDaiDien(String NguoiDaiDien) {
        this.NguoiDaiDien = NguoiDaiDien;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }
    
    
}
