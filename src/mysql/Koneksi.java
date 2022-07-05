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

    public Koneksi() {
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "rental_mobil";
        String driver = "com.mysql.jdbc.Driver";
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

    public int getCountPeminjaman() {
        int rowCount = 0;
        try {
            String q = "select count(*) as jum from peminjaman";
            rs = st.executeQuery(q);
            rs.next();
            rowCount = rs.getInt("jum");
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        return rowCount;
    }

    public int getCountPeminjamanById(String id) {
        int rowCount = 0;
        try {
            String q = "select count(*) as jum from peminjaman where id_user = " + id;
            rs = st.executeQuery(q);
            rs.next();
            rowCount = rs.getInt("jum");
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        return rowCount;
    }

    public int getCountUser() {
        int rowCount = 0;
        try {
            String q = "select count(*) as jum from user";
            rs = st.executeQuery(q);
            rs.next();
            rowCount = rs.getInt("jum");
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        return rowCount;
    }

    public int getCountMobil() {
        int rowCount = 0;
        try {
            String q = "select count(*) as jum from mobil";
            rs = st.executeQuery(q);
            rs.next();
            rowCount = rs.getInt("jum");
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        return rowCount;
    }

    public int getLastIdPeminjaman() {
        int LastId = 0;
        int jmlh = this.getCountPeminjaman();
        int last = jmlh - 1;
        try {
            Object[][] data = this.getDataPeminjaman();
            LastId = Integer.parseInt(data[last][0].toString());
        } catch (NumberFormatException ex) {
            System.out.println("Error: " + ex);
        }
        return LastId;
    }

    public Object[][] getDataPeminjaman() {
        Object[][] row = new Object[1000][8];
        try {
            String query = "SELECT * FROM peminjaman "
                    + "INNER JOIN mobil ON peminjaman.id_mobil = mobil.id_mobil "
                    + "INNER JOIN user ON peminjaman.id_user = user.id_user ORDER BY id_peminjaman ASC;";
            rs = st.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                row[i][0] = rs.getString("id_peminjaman");
                row[i][1] = rs.getString("nama");
                row[i][2] = rs.getString("merk");
                row[i][3] = rs.getString("tgl_peminjaman");
                row[i][4] = rs.getString("tgl_kembali");
                row[i][5] = rs.getString("total_biaya");
                row[i][6] = rs.getString("jenis");
                row[i][7] = rs.getString("no_polisi");
                i++;
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
        }
        return row;
    }

    public Object[][] getDataPeminjamanById(String id) {
        Object[][] row = new Object[1000][8];
        try {
            String query = "SELECT * FROM peminjaman "
                    + "INNER JOIN mobil ON peminjaman.id_mobil = mobil.id_mobil "
                    + "INNER JOIN user ON peminjaman.id_user = user.id_user "
                    + "WHERE peminjaman.id_user = " + id
                    + " ORDER BY id_peminjaman ASC;";
            rs = st.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                row[i][0] = rs.getString("id_peminjaman");
                row[i][1] = rs.getString("nama");
                row[i][2] = rs.getString("merk");
                row[i][3] = rs.getString("tgl_peminjaman");
                row[i][4] = rs.getString("tgl_kembali");
                row[i][5] = rs.getString("total_biaya");
                row[i][6] = rs.getString("jenis");
                row[i][7] = rs.getString("no_polisi");
                i++;
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
        }
        return row;
    }

    public Object[][] getDataUser() {
        Object[][] row = new Object[1000][5];
        try {
            String query = "SELECT * FROM user";
            rs = st.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                row[i][0] = rs.getString("id_user");
                row[i][1] = rs.getString("username");
                row[i][2] = rs.getString("password");
                row[i][3] = rs.getString("nama");
                row[i][4] = rs.getString("akses");
                i++;
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
        }
        return row;
    }

    public Object[][] getDataMobil() {
        Object[][] row = new Object[1000][4];
        try {
            String query = "select * from mobil";
            rs = st.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                row[i][0] = rs.getString("id_mobil");
                row[i][1] = rs.getString("merk");
                row[i][2] = rs.getString("jenis");
                row[i][3] = rs.getString("no_polisi");
                i++;
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
        }
        return row;
    }

    public int getIdUser(String nama) {
        int id_user = 0;
        try {
            String q = "select id_user FROM user WHERE nama = '" + nama + "'";
            rs = st.executeQuery(q);
            rs.next();
            id_user = rs.getInt("id_user");
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        return id_user;
    }

    public int getIdMobil(String no_polisi) {
        int id_mobil = 0;
        try {
            String q = "select id_mobil FROM mobil WHERE no_polisi = '" + no_polisi + "'";
            rs = st.executeQuery(q);
            rs.next();
            id_mobil = rs.getInt("id_mobil");
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        return id_mobil;
    }

    public void tambahDataPeminjaman(int id_peminjaman, int id_user, int id_mobil, String tglPinjam, String tglkembali, int total_biaya) throws SQLException {
        try {
            String query = "INSERT into peminjaman (id_peminjaman,id_user,id_mobil,tgl_peminjaman,tgl_kembali,total_biaya) values (?,?,?,?,?,?)";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            stmt.setInt(1, id_peminjaman);
            stmt.setInt(2, id_user);
            stmt.setInt(3, id_mobil);
            stmt.setString(4, tglPinjam);
            stmt.setString(5, tglkembali);
            stmt.setInt(6, total_biaya);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void ubahDataPeminjaman(int id_peminjaman, int id_user, int id_mobil, String tglPinjam, String tglKembali, int total_biaya) {
        try {
            String query = "UPDATE peminjaman SET id_user = ?, id_mobil = ?, tgl_peminjaman = ?, tgl_kembali = ?, total_biaya = ? WHERE id_peminjaman = ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            stmt.setInt(1, id_user);
            stmt.setInt(2, id_mobil);
            stmt.setString(3, tglPinjam);
            stmt.setString(4, tglKembali);
            stmt.setInt(5, total_biaya);
            stmt.setInt(6, id_peminjaman);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void hapusDataPeminjaman(int id_peminjaman) {
        try {
            String query = "DELETE FROM peminjaman WHERE id_peminjaman = ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            stmt.setInt(1, id_peminjaman);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void hapusDataPeminjamanByIdMobil(int id_mobil) {
        try {
            String query = "DELETE FROM peminjaman WHERE id_mobil = ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            stmt.setInt(1, id_mobil);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void hapusDataPeminjamanByIdUser(int id_user) {
        try {
            String query = "DELETE FROM peminjaman WHERE id_user = ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            stmt.setInt(1, id_user);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void tambahUser(String nama, String username, String password, String akses) {
        try {
            String query = "INSERT into user (nama,username,password,akses) values (?,?,?,?)";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            stmt.setString(1, nama);
            stmt.setString(2, username);
            stmt.setString(3, password);
            stmt.setString(4, akses);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }
    
    public void ubahDataUser(int id_user, String username, String password, String nama, String akses) {
        try {
            String query = "UPDATE user SET username = ?, password = ?, nama = ?, akses = ? WHERE id_user = ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, nama);
            stmt.setString(4, akses);
             stmt.setInt(5, id_user);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void hapusDataUser(int id_user) {
        try {
            String query = "DELETE FROM user WHERE id_user = ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            stmt.setInt(1, id_user);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void tambahMobil(String merk, String jenis, String no_polisi) {
        try {
            String query = "INSERT into mobil (merk,jenis,no_polisi) values (?,?,?)";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            stmt.setString(1, merk);
            stmt.setString(2, jenis);
            stmt.setString(3, no_polisi);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void ubahDataMobil(int id_mobil, String merk, String jenis, String polisi) {
        try {
            String query = "UPDATE mobil SET merk = ?, jenis = ?, no_polisi = ? WHERE id_mobil = ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            stmt.setString(1, merk);
            stmt.setString(2, jenis);
            stmt.setString(3, polisi);
            stmt.setInt(4, id_mobil);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void hapusDataMobil(int id_mobil) {
        try {
            String query = "DELETE FROM mobil WHERE id_mobil = ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            stmt.setInt(1, id_mobil);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }
}
