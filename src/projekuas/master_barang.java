/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projekuas;

import com.mysql.cj.protocol.Resultset;
import javax.swing.JOptionPane;
import com.sun.source.doctree.AttributeTree;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.ByteArrayOutputStream;



/**
 *
 * @author LENOVO
 */
public class master_barang extends javax.swing.JFrame {
    private Image image;
    private PreparedStatement stat;
    private Resultset rs;
    private String filename;

    /**
     * Creates new form master_barang
     */
    public master_barang() {
        initComponents();
        tampilkandata();
        hapuskolom();
    }
    
    class panelgambar extends JPanel {
    private Image image;

    public void setImage(Image image) {
        this.image = image;
        repaint(); // Panggil method repaint untuk menggambar ulang panel dengan gambar baru
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
    
    public void tampilkandata()
    {
        try
        {
            String url = "SELECT * FROM master_barang";
            Connection con = config.inputbarang();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(url);
            
            DefaultTableModel model = (DefaultTableModel) tabel_masterbarang.getModel();
            model.setRowCount(0);
            
            int no = 1;
            while (rs.next())
            {

                String kode_barang = rs.getString("kode_barang");
                String nama_barang = rs.getString("nama_barang");
                String warna = rs.getString("warna");
                String tipe_gender = rs.getString("tipe_gender");
                
                Object[] data = {no++, kode_barang, nama_barang, warna, tipe_gender};
                model.addRow(data);
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan" + e.getMessage());
        }
    }
    
    public void hapuskolom()
    {
        kolomkodebarang.setText("");
        kolomnamabarang.setText("");
        kolomwarna.setSelectedItem(null);
        kolomtipegender.setSelectedItem(null);
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
        jLabel3 = new javax.swing.JLabel();
        kolomkodebarang = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        kolomwarna = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        kolomnamabarang = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        kolomcari = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        judul_input_barang2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel_masterbarang = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        judul_input_barang3 = new javax.swing.JLabel();
        judul_input_barang4 = new javax.swing.JLabel();
        judul_input_barang5 = new javax.swing.JLabel();
        judul_input_barang8 = new javax.swing.JLabel();
        judul_input_barang9 = new javax.swing.JLabel();
        judul_input_barang10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        judul_input_barang1 = new javax.swing.JLabel();
        kolomtipegender = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        tombolcarifoto = new javax.swing.JButton();
        labelfoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText(" Kode Barang");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 160, 40));

        kolomkodebarang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        kolomkodebarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kolomkodebarangActionPerformed(evt);
            }
        });
        jPanel1.add(kolomkodebarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 250, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Warna");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 110, 40));

        kolomwarna.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        kolomwarna.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Silver", "Black", "Blue", "White", "Gold" }));
        kolomwarna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kolomwarnaActionPerformed(evt);
            }
        });
        jPanel1.add(kolomwarna, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 180, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText(" Nama Barang");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 160, 40));

        kolomnamabarang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        kolomnamabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kolomnamabarangActionPerformed(evt);
            }
        });
        jPanel1.add(kolomnamabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 250, 40));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Simpan");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, 120, 40));

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 120, 40));

        jButton6.setBackground(new java.awt.Color(153, 0, 51));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Hapus");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 120, 40));

        kolomcari.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        kolomcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kolomcariActionPerformed(evt);
            }
        });
        kolomcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kolomcariKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kolomcariKeyTyped(evt);
            }
        });
        jPanel1.add(kolomcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 340, 190, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Cari Barang :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, -1, 40));

        judul_input_barang2.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        judul_input_barang2.setText("Tabel Data Jam Tangan");
        jPanel1.add(judul_input_barang2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 370, -1));

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
            tabel_masterbarang.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 780, 180));

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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 600));

        judul_input_barang1.setFont(new java.awt.Font("Garamond", 1, 36)); // NOI18N
        judul_input_barang1.setText("Input Jam Tangan");
        jPanel1.add(judul_input_barang1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 370, 50));

        kolomtipegender.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        kolomtipegender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-laki", "Perempuan" }));
        kolomtipegender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kolomtipegenderActionPerformed(evt);
            }
        });
        jPanel1.add(kolomtipegender, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, 180, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText(" Tipe Gender");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 110, 40));

        tombolcarifoto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tombolcarifoto.setText("Pilih Gambar");
        tombolcarifoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolcarifotoActionPerformed(evt);
            }
        });
        jPanel1.add(tombolcarifoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, 280, 40));

        labelfoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(labelfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 130, 280, 180));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void kolomkodebarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kolomkodebarangActionPerformed
        kolomnamabarang.grabFocus();
    }//GEN-LAST:event_kolomkodebarangActionPerformed

    private void kolomwarnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kolomwarnaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kolomwarnaActionPerformed

    private void kolomnamabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kolomnamabarangActionPerformed

    }//GEN-LAST:event_kolomnamabarangActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (kolomkodebarang.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Mohon isi kode barang", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (kolomnamabarang.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Mohon isi nama barang", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            try
            {
                if (kolomkodebarang.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Mohon isi kode barang","Error",JOptionPane.ERROR_MESSAGE);
                }
                else if (kolomnamabarang.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Mohon isi nama barang","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    
                    
                    String sql = "INSERT INTO  master_barang (kode_barang, nama_barang, warna, tipe_gender, gambar) VALUES (?, ?, ?, ?, ?)";
                    Connection con = config.inputbarang();
                    PreparedStatement pst = con.prepareStatement(sql);
                    
                    // Mengambil gambar dari label
                    ImageIcon icon = (ImageIcon) labelfoto.getIcon();
                    Image image = icon.getImage();

                    // Mengonversi gambar menjadi byte array
                    BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
                    Graphics2D g2 = bufferedImage.createGraphics();
                    g2.drawImage(image, 0, 0, null);
                    g2.dispose();

                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(bufferedImage, "png", baos);
                    byte[] imageData = baos.toByteArray();

                    pst.setString(1,kolomkodebarang.getText());
                    pst.setString(2,kolomnamabarang.getText());
                    pst.setString(3, kolomwarna.getSelectedItem().toString());
                    pst.setString(4, kolomtipegender.getSelectedItem().toString());
                    pst.setBytes(5, imageData);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dimasukan");
                }
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }

            tampilkandata();
            hapuskolom();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        hapuskolom();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try
        {
            String sql = "delete from master_barang WHERE kode_barang = '"+kolomkodebarang.getText()+"'AND warna = '"+kolomwarna.getSelectedItem()+"'";
            java.sql.Connection conn = (Connection)config.inputbarang();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus","Informasi",JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Data gagal dihapus" + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }

        tampilkandata();
        hapuskolom();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void kolomcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kolomcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kolomcariActionPerformed

    private void kolomcariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kolomcariKeyTyped
        
    }//GEN-LAST:event_kolomcariKeyTyped

    private void tabel_masterbarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_masterbarangMouseClicked
        int baris = tabel_masterbarang.rowAtPoint(evt.getPoint());

        String kode_barang = tabel_masterbarang.getValueAt(baris, 1).toString();
        kolomkodebarang.setText(kode_barang);

        String nama_barang = tabel_masterbarang.getValueAt(baris, 2).toString();
        kolomnamabarang.setText(nama_barang);

        String warna = tabel_masterbarang.getValueAt(baris, 3).toString();
        kolomwarna.setSelectedItem(warna);
    }//GEN-LAST:event_tabel_masterbarangMouseClicked

    private void kolomtipegenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kolomtipegenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kolomtipegenderActionPerformed

    private void tombolcarifotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolcarifotoActionPerformed
try {
    JFileChooser chooser = new JFileChooser();
    chooser.showOpenDialog(null);
    File f = chooser.getSelectedFile();
    
    BufferedImage img = ImageIO.read(f);
    
    int targetWidth = labelfoto.getWidth();
    int targetHeight = labelfoto.getHeight();
    
    BufferedImage scaledImg = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = scaledImg.createGraphics();
    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
    g2d.drawImage(img, 0, 0, targetWidth, targetHeight, null);
    g2d.dispose();
    
    ImageIcon ic = new ImageIcon(scaledImg);
    labelfoto.setIcon(ic);
    this.filename = f.getAbsolutePath();
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e.getMessage());
}
    }//GEN-LAST:event_tombolcarifotoActionPerformed

    private void kolomcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kolomcariKeyReleased
    try
        {
            String keyword = kolomcari.getText();

            String sql = "SELECT * FROM master_barang WHERE nama_barang LIKE '%"+kolomcari.getText()+"%' OR kode_barang LIKE '%"+kolomcari.getText()+"%' OR warna LIKE '%"+kolomcari.getText()+"%'";
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
        }        // TODO add your handling code here:
    }//GEN-LAST:event_kolomcariKeyReleased

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
            java.util.logging.Logger.getLogger(master_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(master_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(master_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(master_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new master_barang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel judul_input_barang1;
    private javax.swing.JLabel judul_input_barang10;
    private javax.swing.JLabel judul_input_barang2;
    private javax.swing.JLabel judul_input_barang3;
    private javax.swing.JLabel judul_input_barang4;
    private javax.swing.JLabel judul_input_barang5;
    private javax.swing.JLabel judul_input_barang8;
    private javax.swing.JLabel judul_input_barang9;
    private javax.swing.JTextField kolomcari;
    private javax.swing.JTextField kolomkodebarang;
    private javax.swing.JTextField kolomnamabarang;
    private javax.swing.JComboBox<String> kolomtipegender;
    private javax.swing.JComboBox<String> kolomwarna;
    private javax.swing.JLabel labelfoto;
    private javax.swing.JTable tabel_masterbarang;
    private javax.swing.JButton tombolcarifoto;
    // End of variables declaration//GEN-END:variables
}