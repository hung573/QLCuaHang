/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;
import javax.xml.crypto.Data;

/**
 *
 * @author tranconghung
 */
public class NhanVien {
    int ID;
    String TenNhanVien;
    String GioiTinh;
    Date NgaySinh;
    String SoDienThoai;
    String Email;
    String DiaChi;
    
    public NhanVien(){
        
    }

    public NhanVien(int ID, String TenNhanVien, String GioiTinh, Date NgaySinh, String SoDienThoai, String Email, String DiaChi) {
        this.ID = ID;
        this.TenNhanVien = TenNhanVien;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.SoDienThoai = SoDienThoai;
        this.Email = Email;
        this.DiaChi = DiaChi;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String TenNhanVien) {
        this.TenNhanVien = TenNhanVien;
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
    
}
