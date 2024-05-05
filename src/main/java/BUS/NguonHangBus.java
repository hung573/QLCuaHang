package BUS;

import DAO.*;
import DTO.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NguonHangBus {
    NguonHangDAO nguonhangDAO;

    public NguonHangBus() {
        nguonhangDAO = new NguonHangDAO();
    }
    
    public List LoadNguonHang(int page) throws SQLException{
        int numfrecords = 100;
        ArrayList list = nguonhangDAO.readNguonHang();
        int size = list.size();
        int from, to;
        from = (page - 1) * numfrecords;
        to = page * numfrecords;
        
        return list.subList(from, Math.min(to,size));
    }
    public NguonHang getNguonHang(int ID) throws SQLException{
        NguonHang nh = nguonhangDAO.getNguonHang(ID);
        return nh;
    }
    public int saveNguonHang(NguonHang nh) throws SQLException{
        int result = nguonhangDAO.saveNguonHang(nh);
        return result;
    }
    public int updateNguonHang(NguonHang nh) throws SQLException{
        int result = nguonhangDAO.updateNguonHang(nh);
        return result;
    }
    public boolean deleteNguonHang(NguonHang nh) throws SQLException {
        boolean result = nguonhangDAO.deleteNguonHang(nh);
        return result;
    }
    public List findNguonHang(String TenNguonHang) throws SQLException{
        List list = new ArrayList();
        list = nguonhangDAO.findNguonHang(TenNguonHang);
        return list;
    }
}
