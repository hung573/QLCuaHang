/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class LoaiSanPham {
    int ID;
    String TenLoaiSanPham;
    
    public LoaiSanPham(){
        
    }
    public LoaiSanPham(int ID, String TenLoaiSanPham){
        this.ID = ID;
        this.TenLoaiSanPham = TenLoaiSanPham;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenLoaiSanPham() {
        return TenLoaiSanPham;
    }

    public void setTenLoaiSanPham(String TenLoaiSanPham) {
        this.TenLoaiSanPham = TenLoaiSanPham;
    }
}
