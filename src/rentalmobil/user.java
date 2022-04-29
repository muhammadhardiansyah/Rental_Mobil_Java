/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalmobil;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import mysql.Koneksi;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WINDOWS 10
 */
public class user extends javax.swing.JFrame {

    /**
     * Creates new form user
     */
    public user() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        lblNamaUser.setText(login.name);
        lblNamaPengguna.setText(login.name);
        
        //set minimal kalender
        Date date = new Date();
        tglPinjam.getJCalendar().setMinSelectableDate(date);
        tglKembali.getJCalendar().setMinSelectableDate(date);

        //Koneksi database
        Koneksi koneksi = new Koneksi();      
        
        //Menampilkan tabel data peminjaman
        Object [][] data = koneksi.getDataPeminjamanById(login.id);
        DefaultTableModel model;
        model = (DefaultTableModel) tblDaftarPeminjaman.getModel();
        Object[] row;
        for (int i = 0; i < koneksi.getCountPeminjamanById(login.id); i++){
            row = new Object[]{data[i][0],data[i][1],data[i][2],data[i][3],data[i][4],"Rp. " + data[i][5]};
            model.addRow(row);
        }
        
        //Menampilkan dropdown merk
        Object[][] merk_data = koneksi.getDataMobil();
        cbMerk.addItem("Choose..");
        for (int k=0; k < koneksi.getCountMobil();k++){
            cbMerk.addItem((merk_data[k][1]).toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        lblNamaUser = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnLogut1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDaftarPeminjaman = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        tglPinjam = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        tglKembali = new com.toedter.calendar.JDateChooser();
        cbMerk = new javax.swing.JComboBox<>();
        lblNamaPengguna = new javax.swing.JLabel();
        lblKet = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-close-64.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton2.setText("-");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-user-60.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setRequestFocusEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        lblNamaUser.setFont(new java.awt.Font("Square721 BT", 0, 18)); // NOI18N
        lblNamaUser.setText("Nama");

        jButton4.setBackground(new java.awt.Color(51, 255, 51));
        jButton4.setFont(new java.awt.Font("Square721 BT", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Rental Mobil");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(51, 255, 255));
        jButton5.setFont(new java.awt.Font("Square721 BT", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Pinjaman Anda");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnLogut1.setBackground(new java.awt.Color(0, 0, 0));
        btnLogut1.setFont(new java.awt.Font("Square721 BT", 1, 18)); // NOI18N
        btnLogut1.setForeground(new java.awt.Color(255, 255, 255));
        btnLogut1.setText("Log Out");
        btnLogut1.setActionCommand("Bua");
        btnLogut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogut1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNamaUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(btnLogut1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNamaUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(106, 106, 106)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                .addComponent(btnLogut1)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Square721 BT", 1, 24)); // NOI18N
        jLabel2.setText("Pinjaman Anda");

        tblDaftarPeminjaman.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblDaftarPeminjaman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nama", "Merk", "Tgl Pinjam", "Tgl Kembali", "Total Biaya"
            }
        ));
        tblDaftarPeminjaman.setGridColor(new java.awt.Color(255, 255, 255));
        tblDaftarPeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDaftarPeminjamanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDaftarPeminjaman);

        jLabel3.setFont(new java.awt.Font("Square721 BT", 0, 18)); // NOI18N
        jLabel3.setText("Nama");

        jLabel4.setFont(new java.awt.Font("Square721 BT", 0, 18)); // NOI18N
        jLabel4.setText("Merk");

        jLabel5.setFont(new java.awt.Font("Square721 BT", 0, 18)); // NOI18N
        jLabel5.setText("Tgl Pinjam");

        jLabel6.setFont(new java.awt.Font("Square721 BT", 1, 24)); // NOI18N
        jLabel6.setText("Peminjam");

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Square721 BT", 0, 18)); // NOI18N
        jLabel7.setText("Tgl Kembali");

        tglKembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tglKembaliMouseClicked(evt);
            }
        });

        cbMerk.setFont(new java.awt.Font("Square721 BT", 0, 14)); // NOI18N
        cbMerk.setMaximumRowCount(100);

        lblNamaPengguna.setFont(new java.awt.Font("Square721 BT", 0, 18)); // NOI18N
        lblNamaPengguna.setText("Nama");

        lblKet.setFont(new java.awt.Font("Square721 BT", 0, 18)); // NOI18N
        lblKet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(202, 202, 202))
            .addComponent(lblKet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tglKembali, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                            .addComponent(tglPinjam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbMerk, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNamaPengguna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblNamaPengguna))
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbMerk))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5))
                    .addComponent(tglPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7))
                    .addComponent(tglKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblKet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHapus)
                    .addComponent(btnUbah))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(174, 174, 174))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setState(1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        rental rtl = new rental();
        rtl.setVisible(true);
        rtl.pack();
        rtl.setLocationRelativeTo(null);
        rtl.setDefaultCloseOperation(rental.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tblDaftarPeminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDaftarPeminjamanMouseClicked
        // TODO add your handling code here:
        cbMerk.setSelectedItem(tblDaftarPeminjaman.getValueAt(tblDaftarPeminjaman.getSelectedRow(), 2).toString());
        try {
            DefaultTableModel table = (DefaultTableModel) tblDaftarPeminjaman.getModel();
            int selectedRow = tblDaftarPeminjaman.getSelectedRow();
            Date pinjam = new SimpleDateFormat("dd-MM-yyyy").parse((String)table.getValueAt(selectedRow, 3).toString());
            Date kembali = new SimpleDateFormat("dd-MM-yyyy").parse((String)table.getValueAt(selectedRow, 4).toString());
            tglPinjam.setDate(pinjam);
            tglKembali.setDate(kembali);
        } catch (ParseException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblDaftarPeminjamanMouseClicked

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        Koneksi koneksi = new Koneksi();

        int id_peminjaman = Integer.parseInt(tblDaftarPeminjaman.getValueAt(tblDaftarPeminjaman.getSelectedRow(), 0).toString());

        int id_user = Integer.parseInt(login.id);

        String merk = cbMerk.getSelectedItem().toString();
        int id_mobil = koneksi.getIdMobil(merk);

        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");

        Date tgl_Pinjam = tglPinjam.getDate();
        String strPinjam = formater.format(tgl_Pinjam);

        Date tgl_Kembali= tglKembali.getDate();
        String strKembali = formater.format(tgl_Kembali);

        long selisihTanggal = Math.abs(tgl_Kembali.getTime() - tgl_Pinjam.getTime());
        int selisih = (int) (TimeUnit.MILLISECONDS.toDays(selisihTanggal)) + 1;
        int totalBiaya = selisih * login.hrgRental;
        
        if (merk.equals("Choose..")){
            lblKet.setText("Pastikan data sudah terisi lengkap!");
        }else {
            koneksi.ubahDataPeminjaman(id_peminjaman, id_user, id_mobil, strPinjam, strKembali, totalBiaya);

            DefaultTableModel tbl = (DefaultTableModel) tblDaftarPeminjaman.getModel();
            tbl.setValueAt(merk, tblDaftarPeminjaman.getSelectedRow(), 2);
            tbl.setValueAt(strPinjam, tblDaftarPeminjaman.getSelectedRow(), 3);
            tbl.setValueAt(strKembali, tblDaftarPeminjaman.getSelectedRow(), 4);
            tbl.setValueAt("Rp. " + totalBiaya, tblDaftarPeminjaman.getSelectedRow(), 5);
            lblKet.setText("Data berhasil diperbarui!");
        }

    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        Koneksi koneksi = new Koneksi();

        int id_peminjaman = Integer.parseInt(tblDaftarPeminjaman.getValueAt(tblDaftarPeminjaman.getSelectedRow(), 0).toString());

        koneksi.hapusDataPeminjaman(id_peminjaman);

        DefaultTableModel tbl = (DefaultTableModel) tblDaftarPeminjaman.getModel();
        tbl.removeRow(tblDaftarPeminjaman.getSelectedRow());

        cbMerk.setSelectedItem("Choose..");
        tglPinjam.setDate(null);
        tglKembali.setDate(null);
        lblKet.setText("Data berhasil dihapus!");

    }//GEN-LAST:event_btnHapusActionPerformed

    private void tglKembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tglKembaliMouseClicked

    }//GEN-LAST:event_tglKembaliMouseClicked

    private void btnLogut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogut1ActionPerformed
        // TODO add your handling code here:
        login idx = new login();
        idx.setVisible(true);
        idx.pack();
        idx.setLocationRelativeTo(null);
        idx.setDefaultCloseOperation(user.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnLogut1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnLogut1;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cbMerk;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblKet;
    private javax.swing.JLabel lblNamaPengguna;
    private javax.swing.JLabel lblNamaUser;
    private javax.swing.JTable tblDaftarPeminjaman;
    private com.toedter.calendar.JDateChooser tglKembali;
    private com.toedter.calendar.JDateChooser tglPinjam;
    // End of variables declaration//GEN-END:variables
}
