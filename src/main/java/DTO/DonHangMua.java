/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;
import javax.xml.crypto.Data;
public class DonHangMua {
    int ID;
    int idNhanVienLap;
    int idNguonHang;
    int idTrangThai;
    Date NgayLap;
    float TongTien;

    public DonHangMua() {
    }

    public DonHangMua(int ID, int idNhanVienLap, int idNguonHang, int idTrangThai, Date NgayLap, float TongTien) {
        this.ID = ID;
        this.idNhanVienLap = idNhanVienLap;
        this.idNguonHang = idNguonHang;
        this.idTrangThai = idTrangThai;
        this.NgayLap = NgayLap;
        this.TongTien = TongTien;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIdNhanVienLap() {
        return idNhanVienLap;
    }

    public void setIdNhanVienLap(int idNhanVienLap) {
        this.idNhanVienLap = idNhanVienLap;
    }

    public int getIdNguonHang() {
        return idNguonHang;
    }

    public void setIdNguonHang(int idNguonHang) {
        this.idNguonHang = idNguonHang;
    }

    public int getIdTrangThai() {
        return idTrangThai;
    }

    public void setIdTrangThai(int idTrangThai) {
        this.idTrangThai = idTrangThai;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(Date NgayLap) {
        this.NgayLap = NgayLap;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

}
