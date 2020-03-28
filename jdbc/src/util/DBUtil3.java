package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil3 {
    static ResourceBundle bundle; //ResourceBundle 객체 변수 선언

    static{
        bundle = ResourceBundle.getBundle("db");
        try {
            Class.forName(bundle.getString("driver"));
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패!!!");
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(bundle.getString("url"),bundle.getString("user"),bundle.getString("pass"));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("DB 연결 실패");
            e.printStackTrace();
            return null;
        }
    }
}
