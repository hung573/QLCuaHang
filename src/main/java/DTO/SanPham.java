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
public class SanPham {
    int ID;
    String TenSanPham;
    int idLoaiSanPham;
    double Gia;
    String MoTa;
    int SoLuong;
    Date NgaySanXuat;
    String HinhAnh;
    
    LoaiSanPham tenloaisanpham;

    public LoaiSanPham getTenloaisanpham() {
        return tenloaisanpham;
    }

    public void setTenloaisanpham(LoaiSanPham tenloaisanpham) {
        this.tenloaisanpham = tenloaisanpham;
    }
    
    public SanPham(){
        
    }

    public SanPham(int ID, String TenSanPham,int idLoaiSanPham ,float Gia, String MoTa, int SoLuong, Date NgaySanXuat,String HinhAnh) {
        this.ID = ID;
        this.TenSanPham = TenSanPham;
        this.idLoaiSanPham = idLoaiSanPham;
        this.Gia = Gia;
        this.MoTa = MoTa;
        this.SoLuong = SoLuong;
        this.NgaySanXuat = NgaySanXuat;
        this.HinhAnh = HinhAnh;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public int getIdLoaiSanPham() {
        return idLoaiSanPham;
    }

    public void setIdLoaiSanPham(int idLoaiSanPham) {
        this.idLoaiSanPham = idLoaiSanPham;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(float Gia) {
        this.Gia = Gia;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public Date getNgaySanXuat() {
        return NgaySanXuat;
    }

    public void setNgaySanXuat(Date NgaySanXuat) {
        this.NgaySanXuat = NgaySanXuat;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    
    
}
