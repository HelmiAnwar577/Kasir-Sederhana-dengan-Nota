/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projekuas;

import com.toedter.calendar.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import javax.imageio.ImageIO;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.ByteArrayOutputStream;
import java.text.NumberFormat;
import javax.swing.JTextField;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ACER
 */
public class pembelian extends javax.swing.JFrame {
    
    /**
     * Creates new form pembelian
     */
     private DecimalFormat decimalFormat;
      private Connection connection;
    private String currentID;
    private int currentSequence;

    public pembelian() {
    
    

    initComponents();
    
    setFormatRupiah(hargabeli);
        setFormatRupiah(hargajual);
        setFormatRupiah(total);
        setFormatRupiah(bayar);
        setFormatRupiah(kembalian);
        formatLabelToRupiah();
    showDate();
    
     // Mendapatkan ID terakhir dari tabel laporan_pembelian_umum
try {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    java.sql.Connection conn = (Connection) config.inputbarang();
    String tanggalSekarang = dateFormat.format(new Date());

    String getIdSql = "SELECT id FROM laporan_pembelian_umum WHERE tanggal = ? ORDER BY id DESC LIMIT 1";
    PreparedStatement getIdStatement = conn.prepareStatement(getIdSql);
    getIdStatement.setString(1, tanggalSekarang);
    ResultSet idResult = getIdStatement.executeQuery();
    String lastId = null;
    if (idResult.next()) {
        lastId = idResult.getString(1);
    }
    idResult.close();
    getIdStatement.close();

    // Membuat ID baru dengan format "YYYYMMDD-XXXXX"
    String newId = null;
    if (lastId != null) {
        String lastNumberString = lastId.substring(9);
        int lastNumber = Integer.parseInt(lastNumberString);
        if (lastNumber >= 99999) {
            // ID mencapai batas maksimum, lakukan penanganan khusus di sini
            // Misalnya, Anda dapat menghasilkan pesan kesalahan atau mengambil tindakan lain
        } else {
            String newNumberString = String.format("%05d", lastNumber + 1);
            newId = tanggalSekarang + "-" + newNumberString;
        }
    } else {
        newId = tanggalSekarang + "-00001";
    }

    id1.setText(newId);
} catch (Exception e) {
    // Exception handling
    e.printStackTrace();
}


jLabel1.requestFocus();

try {
    String sql = "SELECT * FROM master_supplier WHERE nama_supplier LIKE '%" + kolomcari.getText() + "%' OR kode_supplier LIKE '%" + kolomcari.getText() + "%' OR alamat LIKE '%" + kolomcari.getText() + "%' OR nomor_telepon LIKE '%" + kolomcari.getText() + "%'";
    java.sql.Connection conn = (Connection) config.inputbarang();
    java.sql.PreparedStatement pst = conn.prepareStatement(sql);

    java.sql.ResultSet rs = pst.executeQuery();

    DefaultTableModel model = (DefaultTableModel) tabel_mastersupplier.getModel();
    model.setRowCount(0);

    while (rs.next()) {
        String kode_barang = rs.getString("kode_supplier");
        String nama_barang = rs.getString("nama_supplier");
        String warna = rs.getString("alamat");
        String gender = rs.getString("nomor_telepon");

        Object[] data = { kode_barang, nama_barang, warna, gender };
        model.addRow(data);
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Gagal" + e.getMessage());
}

try {
    String sql = "SELECT * FROM master_barang WHERE nama_barang LIKE '%" + kolomcari1.getText() + "%' OR tipe_gender LIKE '%" + kolomcari1.getText() + "%' OR kode_barang LIKE '%" + kolomcari1.getText() + "%' OR warna LIKE '%" + kolomcari1.getText() + "%'";
    java.sql.Connection conn = (Connection) config.inputbarang();
    java.sql.PreparedStatement pst = conn.prepareStatement(sql);

    java.sql.ResultSet rs = pst.executeQuery();

    DefaultTableModel model = (DefaultTableModel) tabel_masterbarang.getModel();
    model.setRowCount(0);

    int no = 1;
    while (rs.next()) {
        String kode_barang = rs.getString("kode_barang");
        String nama_barang = rs.getString("nama_barang");
        String warna = rs.getString("warna");
        String gender = rs.getString("tipe_gender");

        Object[] data = { no++, kode_barang, nama_barang, warna, gender };
        model.addRow(data);
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Gagal" + e.getMessage());
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

        jDialog1 = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel_masterbarang = new javax.swing.JTable();
        jDialog2 = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_mastersupplier = new javax.swing.JTable();
        jDialog3 = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        total = new javax.swing.JTextField();
        bayar = new javax.swing.JTextField();
        kembalian = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        judul_input_barang3 = new javax.swing.JLabel();
        judul_input_barang4 = new javax.swing.JLabel();
        judul_input_barang5 = new javax.swing.JLabel();
        judul_input_barang8 = new javax.swing.JLabel();
        judul_input_barang9 = new javax.swing.JLabel();
        judul_input_barang10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        namasupplier = new javax.swing.JLabel();
        alamat = new javax.swing.JLabel();
        nomortelepon = new javax.swing.JLabel();
        kolomcari = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        kodesupplier = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        kolomcari1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        kodebarang = new javax.swing.JLabel();
        namabarang = new javax.swing.JLabel();
        gender = new javax.swing.JLabel();
        warna = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        labelfoto = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        nofaktur = new javax.swing.JTextField();
        subtotal = new javax.swing.JLabel();
        hargabeli = new javax.swing.JTextField();
        hargajual = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jumlah = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        id1 = new javax.swing.JTextField();
        tanggal = new com.toedter.calendar.JDateChooser();

        jDialog1.setTitle("Table Master Barang");
        jDialog1.setModal(true);
        jDialog1.setModalExclusionType(null);
        jDialog1.setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
        jDialog1.addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                jDialog1WindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        jDialog1.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                jDialog1WindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                jDialog1WindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                jDialog1WindowOpened(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(9000, 9000));
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 205));

        tabel_masterbarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Kode Barang", "Nama Barang", "Warna", "Tipe Gender"
            }
        ));
        tabel_masterbarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_masterbarangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabel_masterbarang);
        if (tabel_masterbarang.getColumnModel().getColumnCount() > 0) {
            tabel_masterbarang.getColumnModel().getColumn(0).setMinWidth(50);
            tabel_masterbarang.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabel_masterbarang.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 10, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 10, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 205, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 12, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 13, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 205, Short.MAX_VALUE)
            .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jDialog2.setTitle("Table Master Supplier");
        jDialog2.setModalExclusionType(null);
        jDialog2.setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
        jDialog2.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                jDialog2WindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                jDialog2WindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                jDialog2WindowOpened(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tabel_mastersupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Supplier", "Nama Supplier", "Nomor Telepon", "Alamat"
            }
        ));
        tabel_mastersupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_mastersupplierMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_mastersupplier);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jDialog3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        total.setFocusable(false);

        bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bayarKeyReleased(evt);
            }
        });

        kembalian.setFocusable(false);

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel4.setText("TOTAL");

        jLabel23.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel23.setText("BAYAR");

        jLabel24.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel24.setText("KEMBALIAN");

        jButton7.setBackground(new java.awt.Color(102, 255, 102));
        jButton7.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jButton7.setText("BAYAR");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        judul_input_barang3.setBackground(new java.awt.Color(255, 255, 255));
        judul_input_barang3.setFont(new java.awt.Font("Gill Sans MT", 1, 48)); // NOI18N
        judul_input_barang3.setForeground(new java.awt.Color(255, 255, 255));
        judul_input_barang3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judul_input_barang3.setText("H");
        jPanel2.add(judul_input_barang3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 180, 70));

        judul_input_barang4.setBackground(new java.awt.Color(255, 255, 255));
        judul_input_barang4.setFont(new java.awt.Font("Gill Sans MT", 1, 48)); // NOI18N
        judul_input_barang4.setForeground(new java.awt.Color(255, 255, 255));
        judul_input_barang4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judul_input_barang4.setText("E");
        jPanel2.add(judul_input_barang4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 180, 60));

        judul_input_barang5.setBackground(new java.awt.Color(255, 255, 255));
        judul_input_barang5.setFont(new java.awt.Font("Gill Sans MT", 1, 48)); // NOI18N
        judul_input_barang5.setForeground(new java.awt.Color(255, 255, 255));
        judul_input_barang5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judul_input_barang5.setText("L");
        jPanel2.add(judul_input_barang5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 180, 60));

        judul_input_barang8.setBackground(new java.awt.Color(255, 255, 255));
        judul_input_barang8.setFont(new java.awt.Font("Gill Sans MT", 1, 48)); // NOI18N
        judul_input_barang8.setForeground(new java.awt.Color(255, 255, 255));
        judul_input_barang8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judul_input_barang8.setText("D");
        jPanel2.add(judul_input_barang8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 180, 60));

        judul_input_barang9.setBackground(new java.awt.Color(255, 255, 255));
        judul_input_barang9.setFont(new java.awt.Font("Gill Sans MT", 1, 48)); // NOI18N
        judul_input_barang9.setForeground(new java.awt.Color(255, 255, 255));
        judul_input_barang9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judul_input_barang9.setText("H");
        jPanel2.add(judul_input_barang9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 180, 60));

        judul_input_barang10.setBackground(new java.awt.Color(255, 255, 255));
        judul_input_barang10.setFont(new java.awt.Font("Gill Sans MT", 1, 48)); // NOI18N
        judul_input_barang10.setForeground(new java.awt.Color(255, 255, 255));
        judul_input_barang10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judul_input_barang10.setText("I");
        jPanel2.add(judul_input_barang10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 180, 60));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 130, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Supplier", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("- Nama Supplier  ");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("- Alamat                ");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("- Nomor Telepon ");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText(": ");

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText(": ");

        namasupplier.setBackground(new java.awt.Color(0, 0, 0));
        namasupplier.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        namasupplier.setForeground(new java.awt.Color(0, 0, 0));
        namasupplier.setText("-");

        alamat.setBackground(new java.awt.Color(0, 0, 0));
        alamat.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        alamat.setForeground(new java.awt.Color(0, 0, 0));
        alamat.setText("-");

        nomortelepon.setBackground(new java.awt.Color(0, 0, 0));
        nomortelepon.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        nomortelepon.setForeground(new java.awt.Color(0, 0, 0));
        nomortelepon.setText("-");

        kolomcari.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                kolomcariFocusGained(evt);
            }
        });
        kolomcari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kolomcariMouseClicked(evt);
            }
        });
        kolomcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kolomcariActionPerformed(evt);
            }
        });
        kolomcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kolomcariKeyReleased(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("- Kode Supplier  ");

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText(": ");

        kodesupplier.setBackground(new java.awt.Color(0, 0, 0));
        kodesupplier.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        kodesupplier.setForeground(new java.awt.Color(0, 0, 0));
        kodesupplier.setText("-");

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText(": ");

        jButton3.setBackground(new java.awt.Color(153, 0, 0));
        jButton3.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jButton3.setText("CLEAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(kolomcari)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel5))))
                                .addGap(4, 4, 4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomortelepon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(kodesupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(namasupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(kodesupplier))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9)
                            .addComponent(namasupplier))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alamat)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(nomortelepon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kolomcari, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Barang", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N

        kolomcari1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kolomcari1MouseClicked(evt);
            }
        });
        kolomcari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kolomcari1ActionPerformed(evt);
            }
        });
        kolomcari1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kolomcari1KeyReleased(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("- Kode Barang ");

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("- Gender");

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("- Nama Barang  ");

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("- Warna");

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText(": ");

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText(": ");

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText(": ");

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText(": ");

        kodebarang.setBackground(new java.awt.Color(0, 0, 0));
        kodebarang.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        kodebarang.setForeground(new java.awt.Color(0, 0, 0));
        kodebarang.setText("-");

        namabarang.setBackground(new java.awt.Color(0, 0, 0));
        namabarang.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        namabarang.setForeground(new java.awt.Color(0, 0, 0));
        namabarang.setText("-");

        gender.setBackground(new java.awt.Color(0, 0, 0));
        gender.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        gender.setForeground(new java.awt.Color(0, 0, 0));
        gender.setText("-");

        warna.setBackground(new java.awt.Color(0, 0, 0));
        warna.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        warna.setForeground(new java.awt.Color(0, 0, 0));
        warna.setText("-");

        jButton1.setBackground(new java.awt.Color(153, 0, 0));
        jButton1.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jButton1.setText("CLEAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(kolomcari1)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namabarang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(warna, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(kodebarang, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(jButton1))))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(kodebarang)))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(namabarang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(warna))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(gender))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kolomcari1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        labelfoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("- Tanggal");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Tanggal", "No.Faktur", "Kode Supplier", "Nama Supplier", "Kode Barang", "Nama Barang", "Jumlah", "Harga Beli", "Harga Jual", "Sub Total", "Gambar", "warna", "gender", "alamat", "nomortelepon"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(30);
            table.getColumnModel().getColumn(0).setPreferredWidth(30);
            table.getColumnModel().getColumn(0).setMaxWidth(30);
            table.getColumnModel().getColumn(1).setMinWidth(60);
            table.getColumnModel().getColumn(1).setPreferredWidth(60);
            table.getColumnModel().getColumn(1).setMaxWidth(60);
            table.getColumnModel().getColumn(7).setMinWidth(50);
            table.getColumnModel().getColumn(7).setPreferredWidth(50);
            table.getColumnModel().getColumn(7).setMaxWidth(50);
            table.getColumnModel().getColumn(11).setMinWidth(0);
            table.getColumnModel().getColumn(11).setPreferredWidth(0);
            table.getColumnModel().getColumn(11).setMaxWidth(0);
            table.getColumnModel().getColumn(12).setMinWidth(0);
            table.getColumnModel().getColumn(12).setPreferredWidth(0);
            table.getColumnModel().getColumn(12).setMaxWidth(0);
            table.getColumnModel().getColumn(13).setMinWidth(0);
            table.getColumnModel().getColumn(13).setPreferredWidth(0);
            table.getColumnModel().getColumn(13).setMaxWidth(0);
            table.getColumnModel().getColumn(14).setMinWidth(0);
            table.getColumnModel().getColumn(14).setPreferredWidth(0);
            table.getColumnModel().getColumn(14).setMaxWidth(0);
            table.getColumnModel().getColumn(15).setMinWidth(0);
            table.getColumnModel().getColumn(15).setPreferredWidth(0);
            table.getColumnModel().getColumn(15).setMaxWidth(0);
        }

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("- Harga Jual");

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("- Jumlah");

        nofaktur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nofakturActionPerformed(evt);
            }
        });

        subtotal.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        subtotal.setText("0");

        hargabeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargabeliActionPerformed(evt);
            }
        });
        hargabeli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                hargabeliKeyReleased(evt);
            }
        });

        hargajual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargajualActionPerformed(evt);
            }
        });

        jLabel22.setBackground(new java.awt.Color(0, 0, 0));
        jLabel22.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("- Sub Total ");

        jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahActionPerformed(evt);
            }
        });
        jumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jumlahKeyReleased(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 255, 102));
        jButton2.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jButton2.setText("TAMBAH");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 0, 51));
        jButton5.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jButton5.setText("BATAL");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 51, 255));
        jButton4.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jButton4.setText("BAYAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("- Harga Beli ");

        jButton6.setBackground(new java.awt.Color(255, 0, 51));
        jButton6.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jButton6.setText("HAPUS");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(51, 51, 255));
        jButton8.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jButton8.setText("EDIT");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(id1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nofaktur, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jumlah)
                                    .addComponent(hargajual)
                                    .addComponent(hargabeli)
                                    .addComponent(tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(labelfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addGap(25, 25, 25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nofaktur, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(hargabeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hargajual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                                    .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addComponent(labelfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(id1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 820, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private String getValueAsString(Object valueAt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int getValueAsInt(Object valueAt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
                                    
     class ImageRenderer extends DefaultTableCellRenderer {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value instanceof JLabel) {
                    JLabel label = (JLabel) value;
                    setIcon(label.getIcon());
                    setText(label.getText());
                } else {
                    setIcon(null);
                    setText((value == null) ? "" : value.toString());
                }
                return this;
            }
        }

        // Terapkan render khusus pada kolom gambar
        
    
    private boolean isMethodEnabled = true;
    
    private void tabel_masterbarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_masterbarangMouseClicked
        int baris = tabel_masterbarang.rowAtPoint(evt.getPoint());

        String kode_supplier = tabel_masterbarang.getValueAt(baris, 1).toString();
        kodebarang.setText(kode_supplier);

        String nama_supplier = tabel_masterbarang.getValueAt(baris, 2).toString();
        namabarang.setText(nama_supplier);

        String alamat1 = tabel_masterbarang.getValueAt(baris, 3).toString();
        warna.setText(alamat1);

        String nomor_telepon = tabel_masterbarang.getValueAt(baris, 4).toString();
        gender.setText(nomor_telepon);
        
        jDialog1.setVisible(false);
        kolomcari1.setText("");
        
        tabel_masterbarang.clearSelection();
        kolomcari1.requestFocus();
        
        try {
    // Memeriksa isi Label1 sebelum mengambil dan menampilkan foto
    if (!kodebarang.getText().equals("-")) {
        // Menghubungkan ke database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uas_jam_tangan", "root", "");

       String sql = "SELECT gambar FROM master_barang WHERE kode_barang = ?";
       PreparedStatement statement = connection.prepareStatement(sql);
       statement.setString(1, kodebarang.getText()); // Menggunakan getText() untuk mendapatkan teks dari kodebarang
       ResultSet result = statement.executeQuery();

        if (result.next()) {
                // Mengambil data gambar dari hasil query
                Blob fotoBlob = result.getBlob("gambar");
                byte[] fotoBytes = fotoBlob.getBytes(1, (int) fotoBlob.length());

                // Menampilkan gambar di label
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(fotoBytes));
                ImageIcon icon = new ImageIcon(image);
                labelfoto.setIcon(icon);

            // Menutup stream dan koneksi
            statement.close();
            connection.close();
        }
    }
} catch (SQLException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}
    }//GEN-LAST:event_tabel_masterbarangMouseClicked

    private void tabel_mastersupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_mastersupplierMouseClicked
        int baris = tabel_mastersupplier.rowAtPoint(evt.getPoint());

        String kode_supplier = tabel_mastersupplier.getValueAt(baris, 0).toString();
        kodesupplier.setText(kode_supplier);

        String nama_supplier = tabel_mastersupplier.getValueAt(baris, 1).toString();
        namasupplier.setText(nama_supplier);

        String alamat1 = tabel_mastersupplier.getValueAt(baris, 2).toString();
        alamat.setText(alamat1);

        String nomor_telepon = tabel_mastersupplier.getValueAt(baris, 3).toString();
        nomortelepon.setText(nomor_telepon);
        
        jDialog2.setVisible(false);
        kolomcari.setText("");
        
        tabel_mastersupplier.clearSelection();
        
    }//GEN-LAST:event_tabel_mastersupplierMouseClicked

    private void kolomcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kolomcariActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_kolomcariActionPerformed

    private void kolomcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kolomcariKeyReleased
   
        try
        {
            String sql = "SELECT * FROM master_supplier WHERE nama_supplier LIKE '%"+kolomcari.getText()+"%' OR kode_supplier LIKE '%"+kolomcari.getText()+"%' OR alamat LIKE '%"+kolomcari.getText()+"%' OR nomor_telepon LIKE '%"+kolomcari.getText()+"%'";
            java.sql.Connection conn = (Connection)config.inputbarang();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);

            java.sql.ResultSet rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) tabel_mastersupplier.getModel();
            model.setRowCount(0);

            
            while (rs.next())
            {
                String kode_barang = rs.getString("kode_supplier");
                String nama_barang = rs.getString("nama_supplier");
                String warna = rs.getString("alamat");
                String gender = rs.getString("nomor_telepon");

                Object[] data = {kode_barang, nama_barang, warna, gender};
                model.addRow(data);
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Gagal"+e.getMessage());
        }         // TODO add your handling code here:
    }//GEN-LAST:event_kolomcariKeyReleased

    private void kolomcariFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_kolomcariFocusGained
     // TODO add your handling code here:
    }//GEN-LAST:event_kolomcariFocusGained

    private void jDialog2WindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog2WindowActivated
     kolomcari.requestFocus();       // TODO add your handling code here:
    }//GEN-LAST:event_jDialog2WindowActivated

    private void jDialog2WindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog2WindowClosed
     kolomcari1.requestFocus();   // TODO add your handling code here:
    }//GEN-LAST:event_jDialog2WindowClosed

    private void jDialog2WindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog2WindowOpened

    kolomcari.requestFocus();// TODO add your handling code here:
    }//GEN-LAST:event_jDialog2WindowOpened

    private void kolomcariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kolomcariMouseClicked
    
             jDialog2.setSize(800, 205);
            jDialog2.setLocationRelativeTo(null);
            int dx = 90;
            int dy = 30; // Jarak vertikal ke bawah dalam piksel (misalnya, 50 piksel)
            jDialog2.setLocation(jDialog2.getX() + dx, jDialog2.getY() + dy);
            
            jDialog2.setAlwaysOnTop(true);
        jDialog2.setVisible(true);
        kolomcari.requestFocus();
     
        // TODO add your handling code here:
    }//GEN-LAST:event_kolomcariMouseClicked

    private void kolomcari1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kolomcari1MouseClicked
            jDialog1.setSize(810, 210);
            jDialog1.setLocationRelativeTo(null);
            int dx = 90;
            int dy = 30; // Jarak vertikal ke bawah dalam piksel (misalnya, 50 piksel)
            jDialog1.setLocation(jDialog1.getX() + dx, jDialog1.getY() + dy);
            
            jDialog1.setAlwaysOnTop(true);
        jDialog1.setVisible(true);
        kolomcari1.requestFocus();    // TODO add your handling code here:
    }//GEN-LAST:event_kolomcari1MouseClicked

    private void kolomcari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kolomcari1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kolomcari1ActionPerformed

    private void kolomcari1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kolomcari1KeyReleased
     try
        {
           
            String sql = "SELECT * FROM master_barang WHERE nama_barang LIKE '%"+kolomcari1.getText()+"%' OR tipe_gender LIKE '%"+kolomcari1.getText()+"%' OR kode_barang LIKE '%"+kolomcari1.getText()+"%' OR warna LIKE '%"+kolomcari1.getText()+"%'";
            java.sql.Connection conn = (Connection)config.inputbarang();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);

            java.sql.ResultSet rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) tabel_masterbarang.getModel();
            model.setRowCount(0);

            int no = 1;
            while (rs.next())
            {
                String kode_barang = rs.getString("kode_barang");
                String nama_barang = rs.getString("nama_barang");
                String warna = rs.getString("warna");
                String gender = rs.getString("tipe_gender");

                Object[] data = {no++,kode_barang, nama_barang, warna, gender};
                model.addRow(data);
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Gagal"+e.getMessage());
        }         // TODO add your handling code here:
    }//GEN-LAST:event_kolomcari1KeyReleased

    private void jDialog1WindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog1WindowOpened
    tabel_masterbarang.clearSelection();
        kolomcari1.requestFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_jDialog1WindowOpened

    private void jDialog1WindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog1WindowGainedFocus
        
        kolomcari1.requestFocus();           // TODO add your handling code here:
    }//GEN-LAST:event_jDialog1WindowGainedFocus

    private void jDialog1WindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog1WindowActivated
       kolomcari1.requestFocus();       // TODO add your handling code here:
    }//GEN-LAST:event_jDialog1WindowActivated

    private void jDialog1WindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog1WindowClosed
        kolomcari1.requestFocus();      // TODO add your handling code here:
    }//GEN-LAST:event_jDialog1WindowClosed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int selectedRow = table.getSelectedRow();
DefaultTableModel tbl = (DefaultTableModel) table.getModel();
String Nofaktur = table.getValueAt(selectedRow, 2) != null ? table.getValueAt(selectedRow, 2).toString() : "";
String KodeSupplier = table.getValueAt(selectedRow, 3) != null ? table.getValueAt(selectedRow, 3).toString() : "";
String NamaSupplier = table.getValueAt(selectedRow, 4) != null ? table.getValueAt(selectedRow, 4).toString() : "";
String kodeBarang = table.getValueAt(selectedRow, 5) != null ? table.getValueAt(selectedRow, 5).toString() : "";
String NamaBarang = table.getValueAt(selectedRow, 6) != null ? table.getValueAt(selectedRow, 6).toString() : "";
int JumlahBarang = table.getValueAt(selectedRow, 7) != null ? Integer.parseInt(table.getValueAt(selectedRow, 7).toString()) : 0;
String hargabarang1 = table.getValueAt(selectedRow, 8) != null ? table.getValueAt(selectedRow, 8).toString().replace("Rp", "").replace(".", "") : "";
String hargajual1 = table.getValueAt(selectedRow, 9) != null ? table.getValueAt(selectedRow, 9).toString().replace("Rp", "").replace(".", "") : "";
String tanggal1 = table.getValueAt(selectedRow, 1) != null ? table.getValueAt(selectedRow, 1).toString() : "";
String imagePath = table.getValueAt(selectedRow, 11) != null ? table.getValueAt(selectedRow, 11).toString() : "";
String warna1 = table.getValueAt(selectedRow, 12) != null ? table.getValueAt(selectedRow, 12).toString() : "";
String gender1 = table.getValueAt(selectedRow, 13) != null ? table.getValueAt(selectedRow, 13).toString() : "";
String alamat1 = table.getValueAt(selectedRow, 14) != null ? table.getValueAt(selectedRow, 14).toString() : "";
String nomortelepon1 = table.getValueAt(selectedRow, 15) != null ? table.getValueAt(selectedRow, 15).toString() : "";

DecimalFormat decimalFormat = new DecimalFormat("#,###");
nofaktur.setText(Nofaktur);
kodesupplier.setText(KodeSupplier);
namasupplier.setText(NamaSupplier);
kodebarang.setText(kodeBarang);
namabarang.setText(NamaBarang);
String rupiah = decimalFormat.format(Integer.parseInt(hargabarang1));
hargabeli.setText(rupiah);
String rupiah1 = decimalFormat.format(Integer.parseInt(hargajual1));
hargajual.setText(rupiah1);
String pattern = "dd/MM/yy";
SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
try {
    Date date = dateFormat.parse(tanggal1);
    tanggal.setDate(date);
} catch (ParseException e) {
    e.printStackTrace();
}

// Dapatkan textIcon dari tabel
String textIcon = table.getValueAt(selectedRow, 11) != null ? table.getValueAt(selectedRow, 11).toString() : "";

// Lakukan dekode Base64 pada textIcon
byte[] imageBytes = Base64.getDecoder().decode(textIcon);

// Ubah array byte menjadi ImageIcon
ImageIcon imageIcon = new ImageIcon(imageBytes);

// Set ImageIcon sebagai ikon pada labelfoto
labelfoto.setIcon(imageIcon);

warna.setText(warna1);
gender.setText(gender1);
alamat.setText(alamat1);
nomortelepon.setText(nomortelepon1);
jumlah.setText(String.valueOf(JumlahBarang));
String SUBTOTAL = table.getValueAt(selectedRow, 10) != null ? table.getValueAt(selectedRow, 10).toString() : "";
String rupiah2 = decimalFormat.format(Integer.parseInt(SUBTOTAL));
subtotal.setText(rupiah2);


        
        
        
        
        

      

        // TODO add your handling code here:
    }//GEN-LAST:event_tableMouseClicked

    private void nofakturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nofakturActionPerformed
    hargabeli.requestFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_nofakturActionPerformed

    private void hargabeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargabeliActionPerformed
    hargajual.requestFocus();         // TODO add your handling code here:
    }//GEN-LAST:event_hargabeliActionPerformed

    private void jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahActionPerformed
 
    }//GEN-LAST:event_jumlahActionPerformed

    private void hargabeliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hargabeliKeyReleased
        if (jumlah.getText().equals("")){
        subtotal.setText("0");}
        else if (hargabeli.getText().equals("")){
        subtotal.setText("0");
        }
        else{
        String text1 = hargabeli.getText();
        double amount1 = Double.parseDouble(text1.replaceAll("[^\\d.]", ""));

        String text2 = jumlah.getText();
        double amount2 = Double.parseDouble(text2.replaceAll("[^\\d.]", ""));

        double result = amount1 * amount2;

        String formattedResult = decimalFormat.format(result);
        subtotal.setText(formattedResult);}
                // TODO add your handling code here:
    }//GEN-LAST:event_hargabeliKeyReleased

    private void jumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jumlahKeyReleased
        if (jumlah.getText().equals("")){
        subtotal.setText("0");}
        else{
        String text1 = hargabeli.getText();
        double amount1 = Double.parseDouble(text1.replaceAll("[^\\d.]", ""));

        String text2 = jumlah.getText();
        double amount2 = Double.parseDouble(text2.replaceAll("[^\\d.]", ""));

        double result = amount1 * amount2;

        String formattedResult = decimalFormat.format(result);
        subtotal.setText(formattedResult);} // TODO add your handling code here:
    }//GEN-LAST:event_jumlahKeyReleased

    private void hargajualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargajualActionPerformed
    jumlah.requestFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_hargajualActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
   kodesupplier.setText("-"); 
   namasupplier.setText("-"); 
alamat.setText("-"); 
nomortelepon.setText("-"); // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     kodebarang.setText("-"); 
   namabarang.setText("-"); 
warna.setText("-"); 
gender.setText("-"); 
labelfoto.setIcon(null);// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (nofaktur.getText().equals("") && kodesupplier.getText().equals("-") && kodebarang.getText().equals("-") && nofaktur.getText().equals("") ) {
         JOptionPane.showMessageDialog(null, "PAKE NANYA!"); }
       else if (kodesupplier.getText().equals("-")){
           JOptionPane.showMessageDialog(null,"PILIH DATA SUPPLIER TERLEBIH DAHULU");}
        else if (kodebarang.getText().equals("-")){
           JOptionPane.showMessageDialog(null,"PILIH DATA BARANG TERLEBIH DAHULU");}
        else if (nofaktur.getText().equals("")) {
         JOptionPane.showMessageDialog(null, "NOMOR FAKTUR HARUS ADA!"); }
        else if (subtotal.getText().equals("0")) {
         JOptionPane.showMessageDialog(null, "MASUKAN HARGA DENGAN BENAR"); }
        else{
        DefaultTableModel tbl = (DefaultTableModel) table.getModel();
        String Nofaktur = nofaktur.getText();
        String KodeSupplier = (String) kodesupplier.getText();
        String NamaSupplier = namasupplier.getText();
        String KodeBarang = (String) kodebarang.getText();
        String NamaBarang = namabarang.getText();
        int JumlahBarang = Integer.parseInt(jumlah.getText());
        String hargabarang1 = hargabeli.getText().toString().replace("Rp", "").replace(".", "").replace(",", "");
        int HargaBarang = JumlahBarang * Integer.parseInt(hargabarang1);
        int HargaBeli = Integer.parseInt(hargabarang1);
        String hargajual1 = hargajual.getText().toString().replace("Rp", "").replace(".", "").replace(",", "");
        int HargaJual = Integer.parseInt(hargajual1);
        String t = tanggal.getDateFormatString();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();
int noUrut = rowCount + 1;
String nomorFaktur = Nofaktur;
String kodeSupplier = KodeSupplier;
String namaSupplier = NamaSupplier;
String kodeBarang = KodeBarang;
String namaBarang = NamaBarang;
int jumlahBarang = JumlahBarang;
int hargaBeli = HargaBeli;
String WARNA = warna.getText();
String GENDER = gender.getText();
String ALAMAT = alamat.getText();
String NO = nomortelepon.getText();
labelfoto.getIcon();
Date tanggalInput = tanggal.getDate();
 String formatInput = "dd MMMM yyyy";
        String formatOutput = "dd/MM/yy";
        SimpleDateFormat inputDateFormat = new SimpleDateFormat(formatInput);
        SimpleDateFormat outputDateFormat = new SimpleDateFormat(formatOutput);
        String tanggalOutput = outputDateFormat.format(tanggalInput);
int subtotal1 = jumlahBarang * hargaBeli;
Icon icon = labelfoto.getIcon();
ByteArrayOutputStream baos = new ByteArrayOutputStream();
BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
Graphics2D g2d = bufferedImage.createGraphics();
g2d.drawImage(((ImageIcon) icon).getImage(), 0, 0, null);
g2d.dispose();
try {
    ImageIO.write(bufferedImage, "png", baos);
} catch (IOException e) {
    e.printStackTrace();
}
byte[] imageBytes = baos.toByteArray();
try {
    baos.close();
} catch (IOException e) {
    e.printStackTrace();
}
String textIcon = Base64.getEncoder().encodeToString(imageBytes);
Object[] row = {noUrut, tanggalOutput,  nomorFaktur, kodeSupplier, namaSupplier, kodeBarang, namaBarang, jumlahBarang, hargaBeli,HargaJual, subtotal1,textIcon, WARNA, GENDER, ALAMAT, NO};
model.addRow(row);
        
        kodesupplier.setText("-");   
    namasupplier.setText("-");
    alamat.setText("-"); 
    nomortelepon.setText("-"); 
    kodebarang.setText("-"); 
    namabarang.setText("-"); 
    warna.setText("-"); 
    gender.setText("-"); 
    nofaktur.setText(""); 
    hargabeli.setText(""); 
    hargajual.setText(""); 
    jumlah.setText("");
    subtotal.setText(String.valueOf(0));
labelfoto.setIcon(null);
Calendar calendar = Calendar.getInstance();
Date tanggalSekarang = calendar.getTime();
tanggal.setDate(tanggalSekarang);}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    DefaultTableModel model = (DefaultTableModel) table.getModel();
int row = table.getSelectedRow();
if (row >= 0) {
    model.removeRow(row);
    // Update nomor indeks di kolom pertama
    for (int i = row; i < model.getRowCount(); i++) {
        int currIndex = Integer.parseInt(model.getValueAt(i, 0).toString());
        model.setValueAt(currIndex - 1, i, 0);
    }
     
   
}   
// TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       DefaultTableModel model = (DefaultTableModel) table.getModel();
model.setRowCount(0);
kodesupplier.setText("-");   
    namasupplier.setText("-");
    alamat.setText("-"); 
    nomortelepon.setText("-"); 
    kodebarang.setText("-"); 
    namabarang.setText("-"); 
    warna.setText("-"); 
    gender.setText("-"); 
    nofaktur.setText(""); 
    hargabeli.setText(""); 
    hargajual.setText(""); 
    jumlah.setText("");
    subtotal.setText(String.valueOf(0));
labelfoto.setIcon(null);
Calendar calendar = Calendar.getInstance();
Date tanggalSekarang = calendar.getTime();

// Atur tanggal saat ini pada JDateChooser
tanggal.setDate(tanggalSekarang);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    if (table.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "ISI TERLEBIH DAHULU BARANG YANG AKAN DIBELI");
        } else {
            jDialog3.setSize(322, 230);
            jDialog3.setLocationByPlatform(true);

            
            jDialog3.setLocationRelativeTo(null);
             int dx = 90;
            int dy = 30; // Jarak vertikal ke bawah dalam piksel (misalnya, 50 piksel)
            jDialog3.setLocation(jDialog3.getX() + dx, jDialog3.getY() + dy);
            
            jDialog3.setAlwaysOnTop(true);
        jDialog3.setVisible(true);
        bayar.requestFocus(); 
        int jumlah = 0;
        for (int i = 0; i < table.getRowCount(); i++) {
            Object value = table.getValueAt(i, 10);
            if (value instanceof Integer) {
                jumlah += (Integer) value;
            }
        } total.setText(String.valueOf(jumlah));
       DecimalFormat decimalFormat = new DecimalFormat("#,###");
        int p= Integer.parseInt(total.getText());
        // Format angka menjadi format rupiah
        String rupiah = decimalFormat.format(p);
        total.setText(rupiah);
        }
        

// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
 String k = kembalian.getText().toString().replace(",", "");
if (!k.isEmpty()) {
    int K = Integer.parseInt(k);
    if (K < 0) {
        JOptionPane.showMessageDialog(null, "MASUKKAN BAYAR DENGAN BENAR");
    } else {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String url = "jdbc:mysql://localhost:3306/uas_jam_tangan";
        String username = "root";
        String password = "";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            for (int row = 0; row < model.getRowCount(); row++) {
                String kodebarang = model.getValueAt(row, 5).toString();
                String namabarang = model.getValueAt(row, 6).toString();
                String warna = model.getValueAt(row, 12).toString();
                String gender = model.getValueAt(row, 13).toString();
                String harga = model.getValueAt(row, 9).toString();
                String jumlah = model.getValueAt(row, 7).toString();
                String gambar = model.getValueAt(row, 11).toString();

                // Periksa apakah kodebarang sudah ada di tabel
                String checkSql = "SELECT COUNT(*) FROM stok WHERE kodebarang = ?";
                PreparedStatement checkStatement = conn.prepareStatement(checkSql);
                checkStatement.setString(1, kodebarang);
                ResultSet resultSet = checkStatement.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);
                checkStatement.close();

                if (count > 0) {
                    // Jika kodebarang sudah ada, periksa apakah ada perubahan harga
                    String selectSql = "SELECT harga FROM stok WHERE kodebarang = ?";
                    PreparedStatement selectStatement = conn.prepareStatement(selectSql);
                    selectStatement.setString(1, kodebarang);
                    ResultSet selectResult = selectStatement.executeQuery();
                    selectResult.next();
                    int oldHarga = selectResult.getInt(1);
                    selectStatement.close();

                    int newHarga = Integer.parseInt(harga);

                    if (newHarga != oldHarga) {
                        // Jika ada perubahan harga, lakukan UPDATE pada harga
                        String updateSql = "UPDATE stok SET harga = ? WHERE kodebarang = ?";
                        PreparedStatement updateStatement = conn.prepareStatement(updateSql);
                        updateStatement.setString(1, harga);
                        updateStatement.setString(2, kodebarang);
                        updateStatement.executeUpdate();
                        updateStatement.close();
                    }
                }

                if (count > 0) {
                    // Jika kodebarang sudah ada, lakukan UPDATE pada jumlah
                    String updateSql = "UPDATE stok SET jumlah = jumlah + ? WHERE kodebarang = ?";
                    PreparedStatement updateStatement = conn.prepareStatement(updateSql);
                    updateStatement.setString(1, jumlah);
                    updateStatement.setString(2, kodebarang);
                    updateStatement.executeUpdate();
                    updateStatement.close();
                } else {
                    // Jika kodebarang belum ada, lakukan INSERT data baru
                    String insertSql = "INSERT INTO stok (kodebarang, namabarang, warna, gender, harga, jumlah, gambar) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement insertStatement = conn.prepareStatement(insertSql);
                    insertStatement.setString(1, kodebarang);
                    insertStatement.setString(2, namabarang);
                    insertStatement.setString(3, warna);
                    insertStatement.setString(4, gender);
                    insertStatement.setString(5, harga);
                    insertStatement.setString(6, jumlah);
                    insertStatement.setString(7, gambar);
                    insertStatement.executeUpdate();
                    insertStatement.close();
                }
            }

            // Mendapatkan tanggal saat ini
           Calendar calendar = Calendar.getInstance();
Date tanggalSekarang = calendar.getTime();
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

// Mengambil nomor berikutnya untuk ID
String getIdSql = "SELECT MAX(CAST(SUBSTRING(id, 10) AS UNSIGNED)) FROM laporan_pembelian_umum WHERE SUBSTRING(id, 1, 8) = ?";
PreparedStatement getIdStatement = conn.prepareStatement(getIdSql);
getIdStatement.setString(1, dateFormat.format(tanggalSekarang));
ResultSet idResult = getIdStatement.executeQuery();
int lastNumber = 0;
if (idResult.next()) {
    lastNumber = idResult.getInt(1);
}
idResult.close();
getIdStatement.close(); 

// Membuat ID baru dengan format "YYYYMMDD-XXXXX"
String id = dateFormat.format(tanggalSekarang) + "-" + String.format("%05d", lastNumber + 1);



int totalValue = Integer.parseInt(total.getText().replace(",", ""));
int bayarValue = Integer.parseInt(bayar.getText().replace(",", ""));
int kembalianValue = Integer.parseInt(kembalian.getText().replace(",", ""));

// Query SQL untuk menyimpan data ke tabel laporan_pembelian_umum
String insertLaporanSql = "INSERT INTO laporan_pembelian_umum (id, total, bayar, kembalian, tanggal) VALUES (?, ?, ?, ?, ?)";
PreparedStatement insertLaporanStatement = conn.prepareStatement(insertLaporanSql);
insertLaporanStatement.setString(1, id);
insertLaporanStatement.setInt(2, totalValue);
insertLaporanStatement.setInt(3, bayarValue);
insertLaporanStatement.setInt(4, kembalianValue);
insertLaporanStatement.setDate(5, new java.sql.Date(tanggalSekarang.getTime()));
insertLaporanStatement.executeUpdate();
insertLaporanStatement.close();


            for (int row = 0; row < model.getRowCount(); row++) {
                String kodebarang = model.getValueAt(row, 5).toString();
                String NOFAKTUR = model.getValueAt(row, 2).toString();
                String KODESUPPLIER = model.getValueAt(row, 3).toString();
                String NAMASUPPLIER = model.getValueAt(row, 4).toString();
                String TANGGAL = model.getValueAt(row, 1).toString();
                String namabarang = model.getValueAt(row, 6).toString();
                String warna = model.getValueAt(row, 12).toString();
                String gender = model.getValueAt(row, 13).toString();
                String ALAMAT = model.getValueAt(row, 14).toString();
                String NOMORTELEPON = model.getValueAt(row, 15).toString();
                String SUBTOTAL = model.getValueAt(row, 10).toString();
                String jumlah = model.getValueAt(row, 7).toString();
                String gambar = model.getValueAt(row, 11).toString();
                String HARGABELI = model.getValueAt(row, 8).toString();
                String HARGAJUAL = model.getValueAt(row, 9).toString();
               String pattern = "dd/MM/yy";
java.sql.Date tanggalSql = new java.sql.Date(tanggalSekarang.getTime());



                
                // Query SQL untuk menyimpan data ke tabel laporan_pembelian_detail
                String insertDetailSql = "INSERT INTO laporan_pembelian_detail (ID, nofaktur, kodesupplier, namasupplier, kodebarang, namabarang, jumlah, hargabeli, hargajual, tanggal, warna, gender, alamat, nomortelepon, subtotal, gambar) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement insertDetailStatement = conn.prepareStatement(insertDetailSql);
                insertDetailStatement.setString(1, id);
                insertDetailStatement.setString(2, NOFAKTUR);
                insertDetailStatement.setString(3, KODESUPPLIER);
                insertDetailStatement.setString(4, NAMASUPPLIER);
                insertDetailStatement.setString(5, kodebarang);
                insertDetailStatement.setString(6, namabarang);
                insertDetailStatement.setString(7, jumlah);
                insertDetailStatement.setString(8, HARGABELI);
                insertDetailStatement.setString(9, HARGAJUAL);
                insertDetailStatement.setDate(10, tanggalSql);
                insertDetailStatement.setString(11, warna);
                insertDetailStatement.setString(12, gender);
                insertDetailStatement.setString(13, ALAMAT);
                insertDetailStatement.setString(14, NOMORTELEPON);
                insertDetailStatement.setString(15, SUBTOTAL);
                insertDetailStatement.setString(16, gambar);

                insertDetailStatement.executeUpdate();
                insertDetailStatement.close();
            }

         
    // ...
     

    // ...

            
            conn.close();
            jDialog3.dispose();
            total.setText("");
            bayar.setText("");
            kembalian.setText("");

            model.setRowCount(0);
            kodesupplier.setText("-");
            namasupplier.setText("-");
            alamat.setText("-");
            nomortelepon.setText("-");
            kodebarang.setText("-");
            namabarang.setText("-");
            warna.setText("-");
            gender.setText("-");
            nofaktur.setText("");
            hargabeli.setText("");
            hargajual.setText("");
            jumlah.setText("");
            subtotal.setText(String.valueOf(0));
            labelfoto.setIcon(null);

            // Atur tanggal saat ini pada JDateChooser
            tanggal.setDate(tanggalSekarang);

            JOptionPane.showMessageDialog(null, "Data berhasil disimpan ke database.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

   // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void bayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bayarKeyReleased
    String t = total.getText().toString().replace("Rp", "").replace(".", "").replace(",", "");
String b = bayar.getText().toString().replace("Rp", "").replace(".", "").replace(",", "");
int T = Integer.parseInt(t);
int B = Integer.parseInt(b);
int K = B - T;

// Konversi hasil pengurangan ke dalam tipe Integer menjadi String
String k = String.valueOf(K);

DecimalFormat decimalFormat = new DecimalFormat("#,###");
String rupiah = decimalFormat.format(Integer.parseInt(k));
kembalian.setText(rupiah);       // TODO add your handling code here:
    }//GEN-LAST:event_bayarKeyReleased

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    int selectedRow = table.getSelectedRow();
    if (selectedRow >= 0) {
        String Nofaktur = nofaktur.getText();
        String KodeSupplier = kodesupplier.getText();
        String NamaSupplier = namasupplier.getText();
        String KodeBarang = kodebarang.getText();
        String NamaBarang = namabarang.getText();
        int JumlahBarang = Integer.parseInt(jumlah.getText());
        String hargabarang1 = hargabeli.getText().replace("Rp", "").replace(".", "").replace(",", "");
        int HargaBeli = Integer.parseInt(hargabarang1);
        String hargajual1 = hargajual.getText().replace("Rp", "").replace(".", "").replace(",", "");
        int HargaJual = Integer.parseInt(hargajual1);
        String WARNA = warna.getText();
        String GENDER = gender.getText();
        String ALAMAT = alamat.getText();
        String NO = nomortelepon.getText();
        Icon icon = labelfoto.getIcon();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(((ImageIcon) icon).getImage(), 0, 0, null);
        g2d.dispose();
        try {
            ImageIO.write(bufferedImage, "png", baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] imageBytes = baos.toByteArray();
        try {
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String textIcon = Base64.getEncoder().encodeToString(imageBytes);

        model.setValueAt(Nofaktur, selectedRow, 2);
        model.setValueAt(KodeSupplier, selectedRow, 3);
        model.setValueAt(NamaSupplier, selectedRow, 4);
        model.setValueAt(KodeBarang, selectedRow, 5);
        model.setValueAt(NamaBarang, selectedRow, 6);
        model.setValueAt(JumlahBarang, selectedRow, 7);
        model.setValueAt(HargaBeli, selectedRow, 8);
        model.setValueAt(HargaJual, selectedRow, 9);
        model.setValueAt(WARNA, selectedRow, 12);
        model.setValueAt(GENDER, selectedRow, 13);
        model.setValueAt(ALAMAT, selectedRow, 14);
        model.setValueAt(NO, selectedRow, 15);
        model.setValueAt(textIcon, selectedRow, 11);

        // Reset input fields
        kodesupplier.setText("-");
        namasupplier.setText("-");
        alamat.setText("-");
        nomortelepon.setText("-");
        kodebarang.setText("-");
        namabarang.setText("-");
        warna.setText("-");
        gender.setText("-");
        nofaktur.setText("");
        hargabeli.setText("");
        hargajual.setText("");
        jumlah.setText("");
        subtotal.setText(String.valueOf(0));
        labelfoto.setIcon(null);
        Calendar calendar = Calendar.getInstance();
        Date tanggalSekarang = calendar.getTime();
        tanggal.setDate(tanggalSekarang); 
        
        
       
    }// 
     try {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    java.sql.Connection conn = (Connection) config.inputbarang();
    String tanggalSekarang = dateFormat.format(new Date());

    String getIdSql = "SELECT id FROM laporan_pembelian_umum WHERE tanggal = ? ORDER BY id DESC LIMIT 1";
    PreparedStatement getIdStatement = conn.prepareStatement(getIdSql);
    getIdStatement.setString(1, tanggalSekarang);
    ResultSet idResult = getIdStatement.executeQuery();
    String lastId = null;
    if (idResult.next()) {
        lastId = idResult.getString(1);
    }
    idResult.close();
    getIdStatement.close();

    // Membuat ID baru dengan format "YYYYMMDD-XXXXX"
    String newId = null;
    if (lastId != null) {
        String lastNumberString = lastId.substring(9);
        int lastNumber = Integer.parseInt(lastNumberString);
        if (lastNumber >= 99999) {
            // ID mencapai batas maksimum, lakukan penanganan khusus di sini
            // Misalnya, Anda dapat menghasilkan pesan kesalahan atau mengambil tindakan lain
        } else {
            String newNumberString = String.format("%05d", lastNumber + 1);
            newId = tanggalSekarang + "-" + newNumberString;
        }
    } else {
        newId = tanggalSekarang + "-00001";
    }

    id1.setText(newId);
} catch (Exception e) {
    // Exception handling
    e.printStackTrace();
}

  id1.setText("");
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
        try {
            new pembelian().setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(pembelian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alamat;
    private javax.swing.JTextField bayar;
    private javax.swing.JLabel gender;
    private javax.swing.JTextField hargabeli;
    private javax.swing.JTextField hargajual;
    private javax.swing.JTextField id1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel judul_input_barang10;
    private javax.swing.JLabel judul_input_barang3;
    private javax.swing.JLabel judul_input_barang4;
    private javax.swing.JLabel judul_input_barang5;
    private javax.swing.JLabel judul_input_barang8;
    private javax.swing.JLabel judul_input_barang9;
    private javax.swing.JTextField jumlah;
    private javax.swing.JTextField kembalian;
    private javax.swing.JLabel kodebarang;
    private javax.swing.JLabel kodesupplier;
    private javax.swing.JTextField kolomcari;
    private javax.swing.JTextField kolomcari1;
    private javax.swing.JLabel labelfoto;
    private javax.swing.JLabel namabarang;
    private javax.swing.JLabel namasupplier;
    private javax.swing.JTextField nofaktur;
    private javax.swing.JLabel nomortelepon;
    private javax.swing.JLabel subtotal;
    private javax.swing.JTable tabel_masterbarang;
    private javax.swing.JTable tabel_mastersupplier;
    private javax.swing.JTable table;
    private com.toedter.calendar.JDateChooser tanggal;
    private javax.swing.JTextField total;
    private javax.swing.JLabel warna;
    // End of variables declaration//GEN-END:variables
    private void setFormatRupiah(JTextField textField) {
        decimalFormat = new DecimalFormat("#,###");

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0' && c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                formatTextField(textField);
            }
        });
    }

    private void formatTextField(JTextField textField) {
        try {
            String text = textField.getText();
            if (!text.isEmpty()) {
                double amount = Double.parseDouble(text.replaceAll("[^\\d.]", ""));
                textField.setText(decimalFormat.format(amount));
            }
        } catch (NumberFormatException e) {
            // Handle error if input cannot be parsed to a number
            e.printStackTrace();
        }
    }

  

    // Variables declaration - do not modify                     
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration                   

    private void formatLabelToRupiah() {
    String text = subtotal.getText();
        double amount = Double.parseDouble(text);
        String formattedAmount = decimalFormat.format(amount);
        subtotal.setText(formattedAmount);    
    }

    private void showDate() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy"); // format tanggal yang diinginkan
        tanggal.setDate(now);
        Date tanggalDariChooser = tanggal.getDate(); }

    private void setText(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setText(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
