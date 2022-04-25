/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
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
        } catch (SQLException ex) {
            System.out.println("Error: "+ ex);
        }
        return rowCount;
    }
    
    public int getCountUser(){
        int rowCount = 0;
        try{
            String q = "select count(*) as jum from user";
            rs = st.executeQuery(q);
            rs.next();
            rowCount = rs.getInt("jum");
        } catch (SQLException ex) {
            System.out.println("Error: "+ ex);
        }
        return rowCount;
    }
    
    public int getCountMobil(){
        int rowCount = 0;
        try{
            String q = "select count(*) as jum from mobil";
            rs = st.executeQuery(q);
            rs.next();
            rowCount = rs.getInt("jum");
        } catch (SQLException ex) {
            System.out.println("Error: "+ ex);
        }
        return rowCount;
    }
    
    public int getLastIdPeminjaman(){
        int LastId = 0;
        int jmlh = this.getCountPeminjaman();
        int last = jmlh - 1;
        try{
            Object[][] data = this.getDataPeminjaman();
            LastId = Integer.parseInt(data[last][0].toString());
        } catch (NumberFormatException ex){
            System.out.println("Error: " + ex);
        }
        return LastId;
    }
    
    public Object[][] getDataPeminjaman(){
        Object[][] row = new Object[1000][5];
        try {
            String query = "SELECT * FROM peminjaman "
                    + "INNER JOIN mobil ON peminjaman.id_mobil = mobil.id_mobil "
                    + "INNER JOIN user ON peminjaman.id_user = user.id_user ORDER BY id_peminjaman ASC;";
            rs = st.executeQuery(query);
            int i = 0;
            while (rs.next()){
                row[i][0] = rs.getString("id_peminjaman");
                row[i][1] = rs.getString("nama");
                row[i][2] = rs.getString("merk");
                row[i][3] = rs.getString("tgl_peminjaman");
                row[i][4] = rs.getString("tgl_kembali");
                i++;
            }
        } catch (SQLException ex){
            System.out.println("Error : "+ex);
        }
        return row;
    }
    
    public Object[][] getDataUser(){
        Object[][] row = new Object[1000][5];
        try {
            String query = "SELECT * FROM user";
            rs = st.executeQuery(query);
            int i = 0;
            while (rs.next()){
                row[i][0] = rs.getString("id_user");
                row[i][1] = rs.getString("username");
                row[i][2] = rs.getString("password");
                row[i][3] = rs.getString("nama");
                row[i][4] = rs.getString("akses");
                i++;
            }
        } catch (SQLException ex){
            System.out.println("Error : "+ex);
        }
        return row;
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
        } catch (SQLException ex){
            System.out.println("Error : "+ex);
        }
        return row;
    }
    
    public int getIdUser(String nama){
        int id_user=0;
        try{
            String q = "select id_user FROM user WHERE nama = '"+nama+"'";
            rs = st.executeQuery(q);
            rs.next();
            id_user = rs.getInt("id_user");
        } catch (SQLException ex) {
            System.out.println("Error: "+ ex);
        }
        return id_user;
    }
    
    public int getIdMobil(String merk){
        int id_mobil=0;
        try{
            String q = "select id_mobil FROM mobil WHERE merk = '"+merk+"'";
            rs = st.executeQuery(q);
            rs.next();
            id_mobil = rs.getInt("id_mobil");
        } catch (SQLException ex) {
            System.out.println("Error: "+ ex);
        }
        return id_mobil;
    }
    
    public void tambahDataPeminjaman(int id_peminjaman, int id_user, int id_mobil, String tglPinjam, String tglkembali) throws SQLException{
        try{
            String query = "INSERT into peminjaman (id_peminjaman,id_user,id_mobil,tgl_peminjaman,tgl_kembali) values (?,?,?,?,?)";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            stmt.setInt(1, id_peminjaman);
            stmt.setInt(2, id_user);
            stmt.setInt(3, id_mobil);
            stmt.setString(4, tglPinjam);
            stmt.setString(5, tglkembali);
            stmt.execute();  
        } catch(SQLException ex){
            System.out.println("Error: " + ex);
        }
    }
    
    public void ubahDataPeminjaman(int id_peminjaman, int id_user, int id_mobil, String tglPinjam, String tglKembali){
        try{
            String query = "UPDATE peminjaman SET id_user = ?, id_mobil = ?, tgl_peminjaman = ?, tgl_kembali = ? WHERE id_peminjaman = ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            stmt.setInt(1, id_user);
            stmt.setInt(2, id_mobil);
            stmt.setString(3, tglPinjam);
            stmt.setString(4, tglKembali);
            stmt.setInt(5, id_peminjaman);
            stmt.execute();  
        } catch(SQLException ex){
            System.out.println("Error: " + ex);
        }
    }
    
    public void hapusDataPeminjaman(int id_peminjaman){
        try{
            String query = "DELETE FROM peminjaman WHERE id_peminjaman = ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            stmt.setInt(1, id_peminjaman);
            stmt.execute();  
        }catch(SQLException ex){
            System.out.println("Error: " + ex);
        }
    }
    
    public void tambahUser(String nama, String username, String password, String akses){
        try{
            String query = "INSERT into user (nama,username,password,akses) values (?,?,?,?)";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            stmt.setString(1, nama);
            stmt.setString(2, username);
            stmt.setString(3, password);
            stmt.setString(4, akses);
            stmt.execute();  
        }catch(SQLException ex){
            System.out.println("Error: " + ex);
        }
    }
    
    public void tambahMobil(String merk, String jenis){
        try{
            String query = "INSERT into mobil (merk,jenis) values (?,?)";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            stmt.setString(1, merk);
            stmt.setString(2, jenis);
            stmt.execute();  
        }catch(SQLException ex){
            System.out.println("Error: " + ex);
        }
    }
}
