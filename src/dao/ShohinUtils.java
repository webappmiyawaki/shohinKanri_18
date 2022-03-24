package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ShohinUtils{
    private static Properties properties = null;
    static{
        try {
            InputStream inputStream = ShohinUtils.class
                    .getClassLoader()
                    .getResourceAsStream("dbconfig.properties");
            properties = new Properties();
            properties.load(inputStream);
            Class.forName(properties.getProperty("driverClassName"));
        }catch(ClassNotFoundException errorClassNot){
            errorClassNot.printStackTrace();
        }catch(IOException errorIO){
            errorIO.printStackTrace();
        }finally{
        }
    }

    public  static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("username"),
                properties.getProperty("password")
        );
    }

    /**
     *     Statement用
     *     try-with-resource文使うからあまり使わない？
     */
    public static void close(Statement stat, Connection conn, ResultSet rs) {
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     *     PreparedStatement用
     */
    public static void close(PreparedStatement pstm, Connection conn, ResultSet rs) {
        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}