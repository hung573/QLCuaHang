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
public class TrangThaiBan {
    int ID;
    String TenTrangThai;

    public TrangThaiBan() {
    }

    public TrangThaiBan(int ID, String TenTrangThai) {
        this.ID = ID;
        this.TenTrangThai = TenTrangThai;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenTrangThai() {
        return TenTrangThai;
    }

    public void setTenTrangThai(String TenTrangThai) {
        this.TenTrangThai = TenTrangThai;
    }
    
    
}
