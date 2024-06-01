/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projekuas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author LENOVO
 */
public class config {
    private static Connection mysqlconfig;
    public static Connection inputbarang()throws SQLException
    {
        try
        {
            String url = "jdbc:mysql://localhost/uas_jam_tangan";
            String user = "root";
            String pass = "";
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            mysqlconfig = DriverManager.getConnection(url, user, pass);
        }
        catch (Exception e)
        {
            System.err.println("koneksi gagal "+e.getMessage());
        }
        return mysqlconfig;
    }
}
