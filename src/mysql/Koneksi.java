/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author WINDOWS 10
 */
public class Koneksi {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public Koneksi(){
        String url      = "jdbc:mysql://localhost:3306/";
        String dbName   = "rental_mobil";
        String driver   = "com.mysql.jdbc.Driver";
        String username = "root";
        String password = "";
        
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url + dbName, username, password);
            st = (Statement) con.createStatement();
            System.out.println("Connection success");
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
    }
    
    public int getCountPeminjaman(){
        int rowCount = 0;
        try{
            String q = "select count(*) as jum from peminjaman";
            rs = st.executeQuery(q);
            rs.next();
            rowCount = rs.getInt("jum");
        } catch (Exception ex) {
            System.out.println("Error: "+ ex);
        }
        return rowCount;
    }
    
    public Object[][] getDataMobil(){
        Object[][] row = new Object[1000][3];
        try {
            String query = "select * from mobil";
            rs = st.executeQuery(query);
            int i = 0;
            while (rs.next()){
                row[i][0] = rs.getString("id_mobil");
                row[i][1] = rs.getString("merk");
                row[i][2] = rs.getString("jenis");
                i++;
            }
        } catch (Exception ex){
            System.out.println("Error : "+ex);
        }
        return row;
    }
}
