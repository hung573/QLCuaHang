package BUS;

import DAO.*;
import DTO.KhachHang;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhachHangBUS {
    KhachHangDAO khachhangDAO;

    public KhachHangBUS() {
        khachhangDAO = new KhachHangDAO();
    }
    
    public List LoadKhachHang(int page) throws SQLException{
        int numfrecords = 100;
        ArrayList list = khachhangDAO.readKhachHang();
        int size = list.size();
        int from, to;
        from = (page - 1) * numfrecords;
        to = page * numfrecords;
        
        return list.subList(from, Math.min(to,size));
    }
    public KhachHang getKhachHang(int ID) throws SQLException{
        KhachHang khachhang = khachhangDAO.getKhachHang(ID);
        return khachhang;
    }
    public int saveKhachHang(KhachHang khachhang) throws SQLException{
        int result = khachhangDAO.saveKhachHang(khachhang);
        return result;
    }
    public int updateKhachHang(KhachHang khachhang) throws SQLException{
        int result = khachhangDAO.updateKhachHang(khachhang);
        return result;
    }
    public boolean deleteKhachHang(KhachHang khachhang) throws SQLException {
        boolean result = khachhangDAO.deleteKhachHang(khachhang);
        return result;
    }
    public List findKhachHang(String TenKhachHang) throws SQLException{
        List list = new ArrayList();
        list = khachhangDAO.findKhachHang(TenKhachHang);
        return list;
    }
}
