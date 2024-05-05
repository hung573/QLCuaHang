/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author tranconghung
 */
public class BienBanKiemKe extends NhanVien{
    int IdBienBan;
    String TenBienBan;
    Date NgayLap;
    int SoLuongTonKho;
    int SoLuongThuc;
    int ChenhLech;
    String LyDo;
    public BienBanKiemKe(){
        super();
    }

    public BienBanKiemKe(int IdBienBan, String TenBienBan, Date NgayLap, int SoLuongTonKho,int SoLuongThuc, int ChenhLech, String LyDo, int ID, String TenNhanVien, String GioiTinh, Date NgaySinh, String SoDienThoai, String Email, String DiaChi) {
        super(ID, TenNhanVien, GioiTinh, NgaySinh, SoDienThoai, Email, DiaChi);
        this.IdBienBan = IdBienBan;
        this.TenBienBan = TenBienBan;
        this.NgayLap = NgayLap;
        this.SoLuongTonKho = SoLuongTonKho;
        this.SoLuongThuc = SoLuongThuc;
        this.ChenhLech = ChenhLech;
        this.LyDo = LyDo;
    }
    
    public int getIdBienBan() {
        return IdBienBan;
    }

    public void setIdBienBan(int IdBienBan) {
        this.IdBienBan = IdBienBan;
    }

    public String getTenBienBan() {
        return TenBienBan;
    }

    public void setTenBienBan(String TenBienBan) {
        this.TenBienBan = TenBienBan;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(Date NgayLap) {
        this.NgayLap = NgayLap;
    }

    public int getSoLuongTonKho() {
        return SoLuongTonKho;
    }

    public void setSoLuongTonKho(int SoLuongTonKho) {
        this.SoLuongTonKho = SoLuongTonKho;
    }
    public int getSoLuongThuc() {
        return SoLuongThuc;
    }

    public void setSoLuongThuc(int SoLuongThuc) {
        this.SoLuongThuc = SoLuongThuc;
    }

    public int getChenhLech() {
        return ChenhLech;
    }

    public void setChenhLech(int ChenhLech) {
        this.ChenhLech = ChenhLech;
    }

    public String getLyDo() {
        return LyDo;
    }

    public void setLyDo(String LyDo) {
        this.LyDo = LyDo;
    }

    


    
}
