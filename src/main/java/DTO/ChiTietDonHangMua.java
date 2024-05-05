/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
import javax.xml.crypto.Data;
public class ChiTietDonHangMua {
    int id;
    int idDonHangMua;
    int idSanPham;
    int soLuong;
    double donGiaApDung;
    double thanhTien;

    public ChiTietDonHangMua() {
    }

    public ChiTietDonHangMua(int id, int idDonHangMua, int idSanPham, int soLuong, double donGiaApDung, double thanhTien) {
        this.id = id;
        this.idDonHangMua = idDonHangMua;
        this.idSanPham = idSanPham;
        this.soLuong = soLuong;
        this.donGiaApDung = donGiaApDung;
        this.thanhTien = thanhTien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDonHangMua() {
        return idDonHangMua;
    }

    public void setIdDonHangMua(int idDonHangMua) {
        this.idDonHangMua = idDonHangMua;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGiaApDung() {
        return donGiaApDung;
    }

    public void setDonGiaApDung(double donGiaApDung) {
        this.donGiaApDung = donGiaApDung;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
    
    
}
