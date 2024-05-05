/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.XuLyDatabase_DAO.checkTrangThaiLogin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tranconghung
 */
public class MyDatabaseManager {
    private static Connection c;
    private static Statement s;
    private static PreparedStatement p;
    private static String host, port, dbName, dbUser, dbPassword;
    
    
    public static Connection connectDB()
    {
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost:3306/quanlymaytinh";
            String username = "root";
            String password = "";
            java.sql.Connection conn = DriverManager.getConnection(connectionUrl,username,password);
            return conn;
        }catch(Exception e){
            System.out.println("KẾT NỐI CSDL THẤT BẠI " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
 
    //run sql
    public static ResultSet doReadQuery(String sql) {
        ResultSet rs = null;
        try {
            var con = MyDatabaseManager.connectDB();
            PreparedStatement pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MyDatabaseManager.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    
public void closeConnection(Connection conn){
            try {
                if(conn!=null)
                    conn.close();
                    System.out.println("Đóng kết nối DB thành công!");
            } catch (SQLException ex) {
                System.out.println("Đóng kết nối DB thất bại!");
                ex.printStackTrace();
            }
        }
//public void LoginQuanTri(String TenDangNhap, String MatKhau){  
//            PreparedStatement ps = null;
//            ResultSet result = null;
//            Connection connection = null;
//            
//            try {
//                    connection = this.connectDB();
//                    String query = "SELECT * FROM tbl_nhanvien\n" + "WHERE TenDangNhap = ? AND MatKhau = ?";
//
//                    ps = connection.prepareStatement(query);
//                    ps.setString(1, TenDangNhap);
//                    ps.setString(2, MatKhau);
//
//                    result = ps.executeQuery();
//                    
//                    if (result.next()){
//                        checkTrangThaiLogin = 1;
//                        JOptionPane.showMessageDialog(null,"Đăng nhập thành công!");
//         
//                    }else{
//                        JOptionPane.showMessageDialog(null,"Sai thông tin đăng nhập! Mời nhập lại!");
////                        txfTenTaiKhoan.requestFocus();
//                    }
//                    
//                }catch(Exception e){
//                        System.out.print(e);
//                }
//            
//            finally{
//            try{
//                this.closeConnection(connection);
////                ps.close();
////                result.close();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
// 
//        }
    //test connection
    public static void main(String[] args) {
        MyDatabaseManager.connectDB();
       
        
    }
}
