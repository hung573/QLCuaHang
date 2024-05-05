
package DAO;

import GUI.DangNhap_GUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class XuLyDatabase_DAO {
    private static String dbURL = "jdbc:mysql://localhost:3306/quanlymaytinh";
    private static String userName = "root";
    private static String password = "";
    
    public static int checkTrangThaiLogin = 0;
//    public static Connection conn = null;
        
        //Start Hàm kết nối cơ sở dữ liệu
        public Connection connectDB() throws ClassNotFoundException{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(dbURL, userName, password);
                if(conn != null){
                    System.out.println("Kết nối DB thành công!");
                    return conn;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Kết nối DB thất bại!");
                System.out.println("Kết nối DB thất bại!");
                ex.printStackTrace();
            }      
        return null;
        }
        //End Hàm kết nối cơ sở dữ liệu
        
        //Start Hàm ĐÓNG kết nối cơ sở dữ liệu
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
        //End Hàm ĐÓNG kết nối cơ sở dữ liệu
        
        //Start Hàm đăng nhập quản trị
        public void LoginQuanTri(String TenDangNhap, String MatKhau){  
            PreparedStatement ps = null;
            ResultSet result = null;
            Connection connection = null;
            
            try {
                    connection = this.connectDB();
                    String query = "SELECT * FROM taikhoannhanvien\n" + "WHERE TenDangNhap = ? AND MatKhau = ? ";

                    ps = connection.prepareStatement(query);
                    ps.setString(1, TenDangNhap);
                    ps.setString(2, MatKhau);

                    result = ps.executeQuery();
                    
                    if (result.next()){
                        checkTrangThaiLogin = 1;
                        JOptionPane.showMessageDialog(null,"Đăng nhập thành công!");
         
                    }else{
                        JOptionPane.showMessageDialog(null,"Sai thông tin đăng nhập! Mời nhập lại!");
//                        txfTenTaiKhoan.requestFocus();
                    }
                    
                }catch(Exception e){
                        System.out.print(e);
                }
            
            finally{
            try{
                this.closeConnection(connection);
//                ps.close();
//                result.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
 
        }
        //End Hàm đăng nhập quản trị
        
        
        
    }

