/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
import javax.xml.crypto.Data;
/**
 *
 * @author VO THANH HOA
 */
public class ChiTietDonHangBan {
    int id;
    int idDonHangBan;
    int idSanPham;
    int soLuong;
    double donGiaApDung;
    double thanhTien;

    public ChiTietDonHangBan() {
    }

    public ChiTietDonHangBan(int id, int idDonHangBan, int idSanPham, int soLuong, double donGiaApDung, double thanhTien) {
        this.id = id;
        this.idDonHangBan = idDonHangBan;
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

    public int getIdDonHangBan() {
        return idDonHangBan;
    }

    public void setIdDonHangBan(int idDonHangBan) {
        this.idDonHangBan = idDonHangBan;
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
