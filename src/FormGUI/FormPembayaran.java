/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormGUI;

import Database.Database;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import static java.util.Objects.hash;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Muhammad Dila
 */
public class FormPembayaran extends javax.swing.JFrame {

    Connection conn;
    Statement st;
    ResultSet rs;
    
    public Connection setKoneksi(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/db_tugasbesar_kelompok03","root","");
            st=conn.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Koneksi Gagal :" +e);
        }
       return conn; 
    }
    
    private void RapihkanTabel(){
        tabelKeranjang_Kelompok03.getColumnModel().getColumn(0).setPreferredWidth(80);
        tabelKeranjang_Kelompok03.getColumnModel().getColumn(1).setPreferredWidth(60);
        tabelKeranjang_Kelompok03.getColumnModel().getColumn(2).setPreferredWidth(110);
        tabelKeranjang_Kelompok03.getColumnModel().getColumn(3).setPreferredWidth(70);
        tabelKeranjang_Kelompok03.getColumnModel().getColumn(4).setPreferredWidth(140);
        tabelKeranjang_Kelompok03.getColumnModel().getColumn(5).setPreferredWidth(60);
        tabelKeranjang_Kelompok03.getColumnModel().getColumn(6).setPreferredWidth(40);
        tabelKeranjang_Kelompok03.getColumnModel().getColumn(7).setPreferredWidth(55);
    }
    
    private void kodeLaporanOtomatis(){
        try {
            setKoneksi();
            String sql="select right (kode_laporan_transaksi ,2)+1 from t_laporan_transaksi";
            ResultSet rs=st.executeQuery(sql);
            
            if(rs.next()){
                rs.last();
                String no=rs.getString(1);
                while (no.length()<3){
                    no="0"+no;
                    textKodeLaporan.setText("KLTR"+no);}
                }
            else 
            {
                textKodeLaporan.setText("KLTR001"); 
            }
            } catch (Exception e) 
            {
        }
    }
    
    private void TampilkanDataBarang(){
        DefaultTableModel model= new DefaultTableModel();
        model.addColumn("K. Transaksi");
        model.addColumn("K. Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Harga Barang");
        model.addColumn("Email Pembeli");
        model.addColumn("Tgl Pesan");
        model.addColumn("Jumlah");
        model.addColumn("Total Biaya");
        try{
            String sql="SELECT * FROM t_pembayaran WHERE email_pelanggan ='"+textEmail.getText()+"'";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                model.addRow(new Object[]{res.getString(12),res.getString(8),res.getString(2),res.getString(3)
                ,res.getString(4),res.getString(6),res.getString(5),res.getString(7)});
            }
            tabelKeranjang_Kelompok03.setModel(model);
            RapihkanTabel();
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public FormPembayaran() {
        initComponents();
        getContentPane().setBackground(new Color(255,255,255));
        tabelKeranjang_Kelompok03.fixTable(jScrollPane1_kelompok03);
        tabelKeranjang_Kelompok03.setColumnAlignment(0, JLabel.CENTER);
        tabelKeranjang_Kelompok03.setCellAlignment(0, JLabel.CENTER);
        tabelKeranjang_Kelompok03.setColumnAlignment(2, JLabel.CENTER);
        tabelKeranjang_Kelompok03.setCellAlignment(2, JLabel.CENTER);
        tabelKeranjang_Kelompok03.setColumnAlignment(4, JLabel.CENTER);
        tabelKeranjang_Kelompok03.setCellAlignment(4, JLabel.CENTER);
        tabelKeranjang_Kelompok03.setColumnWidth(0, 50);
        tabelKeranjang_Kelompok03.setColumnWidth(2, 100);
        textEmail.setText(FormLogin.textEmail_Kelompok03.getText());
        TampilkanDataBarang();
        RapihkanTabel();
        JOptionPane.showMessageDialog(this, "Lakukan Pembayaran Dalam 24 Jam\nAtau Pembayaran Akan Di Batalkan", "Pesan", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Kelompok03 = new javax.swing.JPanel();
        labelCartin_Kelompok03 = new javax.swing.JLabel();
        labelFood_Kelompok03 = new javax.swing.JLabel();
        labelHome_Kelompok03 = new javax.swing.JLabel();
        labelMenu_Kelompok03 = new javax.swing.JLabel();
        labelLayanan_Kelompok03 = new javax.swing.JLabel();
        labelKeranjang_Kelompok03 = new javax.swing.JLabel();
        labelAkun_Kelompok03 = new javax.swing.JLabel();
        labelKeluar_Kelompok03 = new javax.swing.JLabel();
        labelPembayaran_Kelompok03 = new javax.swing.JLabel();
        panelGaris_Kelompok03 = new ClassForGUI.PanelRound();
        panelRahasia_kelompok03 = new ClassForGUI.PanelRound();
        labelIconNamaDepan_Kelompok5 = new javax.swing.JLabel();
        labelJumlahPsn_Kelompok4 = new javax.swing.JLabel();
        textKodeBarang = new javax.swing.JTextField();
        textKodeKeranjang = new javax.swing.JTextField();
        textHargaBarang = new javax.swing.JTextField();
        textKodeTransaksi1 = new javax.swing.JTextField();
        textKodeTransaksi = new javax.swing.JTextField();
        textKodeLaporan = new javax.swing.JTextField();
        textEmail = new javax.swing.JTextField();
        panelGmbr_Kelompok03 = new ClassForGUI.PanelRound();
        labelGmbr_Kelompok03 = new javax.swing.JLabel();
        panelPembayaran_Kelompok03 = new ClassForGUI.PanelRound();
        labelLakukanPembayaran_Kelompok03 = new javax.swing.JLabel();
        panelTotalBiaya_Kelompok03 = new ClassForGUI.PanelRound();
        labelIconNamaDepan_Kelompok4 = new javax.swing.JLabel();
        labelTotalBiaya_Kelompok03 = new javax.swing.JLabel();
        textTotalBiaya_Kelompok03 = new javax.swing.JTextField();
        panelJumlahPsn_Kelompok03 = new ClassForGUI.PanelRound();
        labelIconNamaDepan_Kelompok03 = new javax.swing.JLabel();
        labelJumlahPsn_Kelompok03 = new javax.swing.JLabel();
        textJumlahPsn_Kelompok03 = new javax.swing.JTextField();
        jScrollPane1_kelompok03 = new javax.swing.JScrollPane();
        tabelKeranjang_Kelompok03 = new ClassForGUI.TableDark();
        labelGambar_Kelompok03 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_Kelompok03.setBackground(new java.awt.Color(57, 161, 255));
        panel_Kelompok03.setPreferredSize(new java.awt.Dimension(1280, 720));
        panel_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelCartin_Kelompok03.setFont(new java.awt.Font("Urbanist Black", 1, 24)); // NOI18N
        labelCartin_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelCartin_Kelompok03.setText("CARTIN");
        labelCartin_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_Kelompok03.add(labelCartin_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 25, 170, -1));

        labelFood_Kelompok03.setFont(new java.awt.Font("Urbanist Black", 1, 24)); // NOI18N
        labelFood_Kelompok03.setForeground(new java.awt.Color(255, 176, 0));
        labelFood_Kelompok03.setText("FOOD");
        panel_Kelompok03.add(labelFood_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 25, -1, -1));

        labelHome_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 20)); // NOI18N
        labelHome_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelHome_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Home Putih.png"))); // NOI18N
        labelHome_Kelompok03.setText("Home");
        labelHome_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelHome_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelHome_Kelompok03MouseMoved(evt);
            }
        });
        labelHome_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelHome_Kelompok03MouseClicked(evt);
            }
        });
        panel_Kelompok03.add(labelHome_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 28, -1, -1));

        labelMenu_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 20)); // NOI18N
        labelMenu_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelMenu_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMenu_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Menu Putih.png"))); // NOI18N
        labelMenu_Kelompok03.setText("Menu");
        labelMenu_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelMenu_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelMenu_Kelompok03MouseMoved(evt);
            }
        });
        labelMenu_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMenu_Kelompok03MouseClicked(evt);
            }
        });
        panel_Kelompok03.add(labelMenu_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 28, -1, -1));

        labelLayanan_Kelompok03.setBackground(new java.awt.Color(102, 102, 102));
        labelLayanan_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 20)); // NOI18N
        labelLayanan_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelLayanan_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Layanan Putih.png"))); // NOI18N
        labelLayanan_Kelompok03.setText("Layanan");
        labelLayanan_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelLayanan_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelLayanan_Kelompok03MouseMoved(evt);
            }
        });
        labelLayanan_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelLayanan_Kelompok03MouseClicked(evt);
            }
        });
        panel_Kelompok03.add(labelLayanan_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 28, -1, -1));

        labelKeranjang_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 20)); // NOI18N
        labelKeranjang_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelKeranjang_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keranjang Putih.png"))); // NOI18N
        labelKeranjang_Kelompok03.setText("Keranjang");
        labelKeranjang_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelKeranjang_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelKeranjang_Kelompok03MouseMoved(evt);
            }
        });
        labelKeranjang_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelKeranjang_Kelompok03MouseClicked(evt);
            }
        });
        panel_Kelompok03.add(labelKeranjang_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 28, -1, -1));

        labelAkun_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 20)); // NOI18N
        labelAkun_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelAkun_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Akun Putih.png"))); // NOI18N
        labelAkun_Kelompok03.setText("Profile");
        labelAkun_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelAkun_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelAkun_Kelompok03MouseMoved(evt);
            }
        });
        labelAkun_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAkun_Kelompok03MouseClicked(evt);
            }
        });
        panel_Kelompok03.add(labelAkun_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 28, -1, -1));

        labelKeluar_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 20)); // NOI18N
        labelKeluar_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelKeluar_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keluar Putih.png"))); // NOI18N
        labelKeluar_Kelompok03.setText("Keluar");
        labelKeluar_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelKeluar_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelKeluar_Kelompok03MouseMoved(evt);
            }
        });
        labelKeluar_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelKeluar_Kelompok03MouseClicked(evt);
            }
        });
        panel_Kelompok03.add(labelKeluar_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 28, -1, -1));

        labelPembayaran_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 20)); // NOI18N
        labelPembayaran_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelPembayaran_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Pembayaran .png"))); // NOI18N
        labelPembayaran_Kelompok03.setText("Pembayaran");
        labelPembayaran_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelPembayaran_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelPembayaran_Kelompok03MouseMoved(evt);
            }
        });
        labelPembayaran_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelPembayaran_Kelompok03MouseClicked(evt);
            }
        });
        panel_Kelompok03.add(labelPembayaran_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(825, 28, -1, -1));

        panelGaris_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panel_Kelompok03.add(panelGaris_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1280, 5));

        panelRahasia_kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelRahasia_kelompok03.setRoundBottomLeft(25);
        panelRahasia_kelompok03.setRoundBottomRight(25);
        panelRahasia_kelompok03.setRoundTopLeft(25);
        panelRahasia_kelompok03.setRoundTopRight(25);
        panelRahasia_kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelIconNamaDepan_Kelompok5.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconNamaDepan_Kelompok5.setForeground(new java.awt.Color(21, 0, 53));
        labelIconNamaDepan_Kelompok5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconNamaDepan_Kelompok5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Nama.png"))); // NOI18N
        panelRahasia_kelompok03.add(labelIconNamaDepan_Kelompok5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 40, 40));

        labelJumlahPsn_Kelompok4.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelJumlahPsn_Kelompok4.setForeground(new java.awt.Color(21, 0, 53));
        labelJumlahPsn_Kelompok4.setText("Jumlah Pesan");
        panelRahasia_kelompok03.add(labelJumlahPsn_Kelompok4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        textKodeBarang.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textKodeBarang.setForeground(new java.awt.Color(21, 0, 53));
        textKodeBarang.setBorder(null);
        textKodeBarang.setOpaque(false);
        panelRahasia_kelompok03.add(textKodeBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 140, 20));

        textKodeKeranjang.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textKodeKeranjang.setForeground(new java.awt.Color(21, 0, 53));
        textKodeKeranjang.setBorder(null);
        textKodeKeranjang.setOpaque(false);
        panelRahasia_kelompok03.add(textKodeKeranjang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 140, 20));

        textHargaBarang.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textHargaBarang.setForeground(new java.awt.Color(21, 0, 53));
        textHargaBarang.setBorder(null);
        textHargaBarang.setOpaque(false);
        panelRahasia_kelompok03.add(textHargaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 140, 20));

        textKodeTransaksi1.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textKodeTransaksi1.setForeground(new java.awt.Color(21, 0, 53));
        textKodeTransaksi1.setBorder(null);
        textKodeTransaksi1.setOpaque(false);
        panelRahasia_kelompok03.add(textKodeTransaksi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 140, 20));

        textKodeTransaksi.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textKodeTransaksi.setForeground(new java.awt.Color(21, 0, 53));
        textKodeTransaksi.setBorder(null);
        textKodeTransaksi.setOpaque(false);
        textKodeTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textKodeTransaksiActionPerformed(evt);
            }
        });
        panelRahasia_kelompok03.add(textKodeTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 140, 20));

        textKodeLaporan.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textKodeLaporan.setForeground(new java.awt.Color(21, 0, 53));
        textKodeLaporan.setBorder(null);
        textKodeLaporan.setOpaque(false);
        panelRahasia_kelompok03.add(textKodeLaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 140, 20));

        textEmail.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textEmail.setForeground(new java.awt.Color(21, 0, 53));
        textEmail.setBorder(null);
        textEmail.setOpaque(false);
        panelRahasia_kelompok03.add(textEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 140, 20));

        panel_Kelompok03.add(panelRahasia_kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 360, 0));

        panelGmbr_Kelompok03.setBackground(new java.awt.Color(21, 0, 53));
        panelGmbr_Kelompok03.setRoundBottomLeft(25);
        panelGmbr_Kelompok03.setRoundBottomRight(25);
        panelGmbr_Kelompok03.setRoundTopLeft(25);
        panelGmbr_Kelompok03.setRoundTopRight(25);
        panelGmbr_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelGmbr_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 20)); // NOI18N
        labelGmbr_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelGmbr_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Logo Polos Kecil.png"))); // NOI18N
        panelGmbr_Kelompok03.add(labelGmbr_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 310));

        panel_Kelompok03.add(panelGmbr_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 120, 330, 310));

        panelPembayaran_Kelompok03.setBackground(new java.awt.Color(21, 0, 53));
        panelPembayaran_Kelompok03.setRoundBottomLeft(35);
        panelPembayaran_Kelompok03.setRoundBottomRight(35);
        panelPembayaran_Kelompok03.setRoundTopLeft(35);
        panelPembayaran_Kelompok03.setRoundTopRight(35);
        panelPembayaran_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelPembayaran_Kelompok03MouseMoved(evt);
            }
        });
        panelPembayaran_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelLakukanPembayaran_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelLakukanPembayaran_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelLakukanPembayaran_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLakukanPembayaran_Kelompok03.setText("Bayar & Cetak Struk");
        labelLakukanPembayaran_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelLakukanPembayaran_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelLakukanPembayaran_Kelompok03MouseMoved(evt);
            }
        });
        labelLakukanPembayaran_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelLakukanPembayaran_Kelompok03MouseClicked(evt);
            }
        });
        panelPembayaran_Kelompok03.add(labelLakukanPembayaran_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 310, 30));

        panel_Kelompok03.add(panelPembayaran_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 610, 330, 60));

        panelTotalBiaya_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelTotalBiaya_Kelompok03.setRoundBottomLeft(25);
        panelTotalBiaya_Kelompok03.setRoundBottomRight(25);
        panelTotalBiaya_Kelompok03.setRoundTopLeft(25);
        panelTotalBiaya_Kelompok03.setRoundTopRight(25);
        panelTotalBiaya_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelIconNamaDepan_Kelompok4.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconNamaDepan_Kelompok4.setForeground(new java.awt.Color(21, 0, 53));
        labelIconNamaDepan_Kelompok4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconNamaDepan_Kelompok4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Pembayaran .png"))); // NOI18N
        panelTotalBiaya_Kelompok03.add(labelIconNamaDepan_Kelompok4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 40, 40));

        labelTotalBiaya_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelTotalBiaya_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelTotalBiaya_Kelompok03.setText("Masukan Uang Disini");
        panelTotalBiaya_Kelompok03.add(labelTotalBiaya_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        textTotalBiaya_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textTotalBiaya_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textTotalBiaya_Kelompok03.setBorder(null);
        textTotalBiaya_Kelompok03.setOpaque(false);
        textTotalBiaya_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textTotalBiaya_Kelompok03MouseClicked(evt);
            }
        });
        panelTotalBiaya_Kelompok03.add(textTotalBiaya_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 270, 20));

        panel_Kelompok03.add(panelTotalBiaya_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 530, 330, 60));

        panelJumlahPsn_Kelompok03.setBackground(new java.awt.Color(222, 225, 229));
        panelJumlahPsn_Kelompok03.setRoundBottomLeft(25);
        panelJumlahPsn_Kelompok03.setRoundBottomRight(25);
        panelJumlahPsn_Kelompok03.setRoundTopLeft(25);
        panelJumlahPsn_Kelompok03.setRoundTopRight(25);
        panelJumlahPsn_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelIconNamaDepan_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconNamaDepan_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelIconNamaDepan_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconNamaDepan_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Harga Barang.png"))); // NOI18N
        panelJumlahPsn_Kelompok03.add(labelIconNamaDepan_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 40, 40));

        labelJumlahPsn_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelJumlahPsn_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelJumlahPsn_Kelompok03.setText("Total Semua Biaya");
        panelJumlahPsn_Kelompok03.add(labelJumlahPsn_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        textJumlahPsn_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textJumlahPsn_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textJumlahPsn_Kelompok03.setBorder(null);
        textJumlahPsn_Kelompok03.setEnabled(false);
        textJumlahPsn_Kelompok03.setOpaque(false);
        panelJumlahPsn_Kelompok03.add(textJumlahPsn_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 270, 20));

        panel_Kelompok03.add(panelJumlahPsn_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 450, 330, 60));

        jScrollPane1_kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jScrollPane1_kelompok03MouseMoved(evt);
            }
        });

        tabelKeranjang_Kelompok03.setAutoCreateRowSorter(true);
        tabelKeranjang_Kelompok03.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelKeranjang_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tabelKeranjang_Kelompok03MouseMoved(evt);
            }
        });
        tabelKeranjang_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelKeranjang_Kelompok03MouseClicked(evt);
            }
        });
        jScrollPane1_kelompok03.setViewportView(tabelKeranjang_Kelompok03);

        panel_Kelompok03.add(jScrollPane1_kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 840, 560));

        labelGambar_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelGambar_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelGambar_Kelompok03MouseMoved(evt);
            }
        });
        panel_Kelompok03.add(labelGambar_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -20, 1300, 740));

        getContentPane().add(panel_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(1296, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void labelMenu_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMenu_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelMenu_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Menu.png")));
        labelMenu_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
    }//GEN-LAST:event_labelMenu_Kelompok03MouseMoved

    private void labelGambar_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelGambar_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelMenu_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Menu Putih.png")));
        labelMenu_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelHome_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Home Putih.png")));
        labelHome_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelLayanan_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Layanan Putih.png")));
        labelLayanan_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelKeranjang_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keranjang Putih.png")));
        labelKeranjang_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelPembayaran_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Pembayaran .png")));
        labelPembayaran_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelAkun_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Akun Putih.png")));
        labelAkun_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelKeluar_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keluar Putih.png")));
        labelKeluar_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        panelPembayaran_Kelompok03.setBackground(new java.awt.Color(21, 0, 53));
        labelLakukanPembayaran_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        if(textJumlahPsn_Kelompok03.getText().equals("")) {
            textJumlahPsn_Kelompok03.setText("0");
        }
        if (textTotalBiaya_Kelompok03.getText().equals("")){
            textTotalBiaya_Kelompok03.setText("0");
        }
            int sum = 0;
        for(int i = 0; i < tabelKeranjang_Kelompok03.getRowCount(); i++)
        {
            sum = sum + Integer.parseInt(tabelKeranjang_Kelompok03.getValueAt(i, 7).toString());
        }
        textJumlahPsn_Kelompok03.setText(Integer.toString(sum));
        
//        int baris=tabelKeranjang_Kelompok03.rowAtPoint(evt.getPoint());
//        String kodeTransaksi2 = tabelKeranjang_Kelompok03.getValueAt(baris,0).toString();
//        java.util.Date tgl = new java.util.Date();  
//        java.text.SimpleDateFormat kal = new java.text.SimpleDateFormat("MMdd");  
//        java.text.SimpleDateFormat tanggal = new java.text.SimpleDateFormat("yyyyMMdd");
//        textKodeTransaksi.setText("000"+kal.format(tgl));
//        String kodeTransaksi = "000"+kal.format(tgl);
//        textKodeTransaksi1.setText(kodeTransaksi2);
//        int kodeTransaksiInt1 = Integer.parseInt(textKodeTransaksi.getText());
//        int kodeTransaksiInt2 = Integer.parseInt(textKodeTransaksi1.getText());
//        if (kodeTransaksiInt1 != kodeTransaksiInt2){
//            try{
//                String sql2= "DELETE FROM t_pembayaran WHERE kode_transaksi ='"+kodeTransaksi2+"'";
//
//                java.sql.Connection conn=(Connection)Database.configDB();
//                java.sql.PreparedStatement pstm2 = conn.prepareStatement(sql2);
//                pstm2.execute();
//                JOptionPane.showMessageDialog(this, "Data Ada Yang Sudah Kadaluarsa\nData Akan Dihapus Secara Otomatis", "Pesan",
//                JOptionPane.WARNING_MESSAGE);
//                TampilkanDataBarang();
//            RapihkanTabel();
//            }catch(HeadlessException | SQLException e){
//                JOptionPane.showMessageDialog(this, "Simpan Data Gagal", "Pesan",
//                JOptionPane.WARNING_MESSAGE);
//            }
//            }
    }//GEN-LAST:event_labelGambar_Kelompok03MouseMoved

    private void labelHome_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelHome_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelHome_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Home.png")));
        labelHome_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
    }//GEN-LAST:event_labelHome_Kelompok03MouseMoved

    private void labelLayanan_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLayanan_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelLayanan_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Layanan.png")));
        labelLayanan_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
    }//GEN-LAST:event_labelLayanan_Kelompok03MouseMoved

    private void labelKeranjang_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelKeranjang_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelKeranjang_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keranjang.png")));
        labelKeranjang_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
    }//GEN-LAST:event_labelKeranjang_Kelompok03MouseMoved

    private void labelPembayaran_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPembayaran_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelPembayaran_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Pembayaran Putih.png")));
        labelPembayaran_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_labelPembayaran_Kelompok03MouseMoved

    private void labelAkun_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAkun_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelAkun_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Akun.png")));
        labelAkun_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
    }//GEN-LAST:event_labelAkun_Kelompok03MouseMoved

    private void labelKeluar_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelKeluar_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelKeluar_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keluar.png")));
        labelKeluar_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
    }//GEN-LAST:event_labelKeluar_Kelompok03MouseMoved

    private void labelKeluar_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelKeluar_Kelompok03MouseClicked
        // TODO add your handling code here:
        FormLogin s = new FormLogin();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_labelKeluar_Kelompok03MouseClicked

    private void labelAkun_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAkun_Kelompok03MouseClicked
        // TODO add your handling code here:
        FormAkun s = new FormAkun();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_labelAkun_Kelompok03MouseClicked

    private void labelMenu_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMenu_Kelompok03MouseClicked
        // TODO add your handling code here:
        FormMenu s = new FormMenu();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_labelMenu_Kelompok03MouseClicked

    private void labelLayanan_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLayanan_Kelompok03MouseClicked
        // TODO add your handling code here:
        FormLayanan s = new FormLayanan();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_labelLayanan_Kelompok03MouseClicked

    private void labelKeranjang_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelKeranjang_Kelompok03MouseClicked
        // TODO add your handling code here:
        FormKeranjang s = new FormKeranjang();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_labelKeranjang_Kelompok03MouseClicked

    private void labelPembayaran_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPembayaran_Kelompok03MouseClicked
        // TODO add your handling code here:
        FormPembayaran s = new FormPembayaran();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_labelPembayaran_Kelompok03MouseClicked

    private void labelHome_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelHome_Kelompok03MouseClicked
        // TODO add your handling code here:
        FormHome s = new FormHome();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_labelHome_Kelompok03MouseClicked

    private void labelLakukanPembayaran_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLakukanPembayaran_Kelompok03MouseMoved
        // TODO add your handling code here:
        panelPembayaran_Kelompok03.setBackground(new java.awt.Color(255, 176, 0));
        labelLakukanPembayaran_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
    }//GEN-LAST:event_labelLakukanPembayaran_Kelompok03MouseMoved

    private void labelLakukanPembayaran_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLakukanPembayaran_Kelompok03MouseClicked
        // TODO add your handling code here:
        int baris=tabelKeranjang_Kelompok03.rowAtPoint(evt.getPoint());
        String kodeTransaksi2 = tabelKeranjang_Kelompok03.getValueAt(baris,0).toString();
        
        java.util.Date tgl = new java.util.Date();  
        java.text.SimpleDateFormat kal = new java.text.SimpleDateFormat("MMdd");  
        java.text.SimpleDateFormat tanggal = new java.text.SimpleDateFormat("yyyyMMdd");
        textKodeTransaksi.setText("000"+kal.format(tgl));
        String kodeTransaksi = "000"+kal.format(tgl);
        textKodeTransaksi1.setText(kodeTransaksi2);
        int kodeTransaksiInt1 = Integer.parseInt(textKodeTransaksi.getText());
        int kodeTransaksiInt2 = Integer.parseInt(textKodeTransaksi1.getText());
        
        int total = Integer.parseInt(textJumlahPsn_Kelompok03.getText());
                int uang = Integer.parseInt(textTotalBiaya_Kelompok03.getText());
                int totalAkhir = total - uang;
                if (totalAkhir <= 0){
                if (kodeTransaksiInt1 == kodeTransaksiInt2){
                    try{
                        String sql = "UPDATE t_pembayaran SET grand_total ='"+textJumlahPsn_Kelompok03.getText()
                                +"',uang_bayar='"+textTotalBiaya_Kelompok03.getText()
                                +"',kembalian='"+totalAkhir
                                +"' WHERE email_pelanggan ='"+ textEmail.getText()+"'";
                        String sql2 = "UPDATE t_laporan_transaksi SET grand_total ='"+textJumlahPsn_Kelompok03.getText()
                                +"',uang_bayar='"+textTotalBiaya_Kelompok03.getText()
                                +"',kembalian='"+totalAkhir
                                +"' WHERE email_pelanggan ='"+ textEmail.getText()+"'";
                        
                        java.sql.Connection conn=(Connection)Database.configDB();
                        java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                        java.sql.PreparedStatement pstm2= conn.prepareStatement(sql2);
                        pstm.execute();
                        pstm2.execute();
                        JOptionPane.showMessageDialog(null, "Proses Pembayaran Berhasil.");
                        RapihkanTabel();
                      }catch(HeadlessException | SQLException e){
                          JOptionPane.showMessageDialog(this, "Simpan Data Gagal", "Pesan",
                          JOptionPane.WARNING_MESSAGE);
                      }
                    try{
                        Database objkoneksi = new Database();
                        Connection con =objkoneksi.configDB();
                        String fileName="src\\CetakLaporan\\StrukPembayaran.jrxml";
                        String filetoFill="src\\CetakLaporan\\StrukPembayaran.jasper";
                        JasperCompileManager.compileReport(fileName);
                        HashMap param= new HashMap();
                        param.put("EMAIL", textEmail.getText());
                        JasperFillManager.fillReport(filetoFill, param, con);
                        JasperPrint jp=JasperFillManager.fillReport(filetoFill, param,con);
                        JasperViewer.viewReport(jp,false);

//                    String report = ("C:\\Users\\Muhammad Dila\\Documents\\NetBeansProjects\\TugasBesarKelompok03\\src\\CetakLaporan\\StrukPembayaran.jrxml");
//                
//                    HashMap hash = new HashMap();
//                    hash.put("EMAIL", textEmail.getText());
//                    JasperReport JRpt = JasperCompileManager.compileReport(report);
//                    JasperPrint JPrint = JasperFillManager.fillReport(JRpt, hash, con);
//                    JasperViewer.viewReport(JPrint, false);

                    }catch(Exception ex){
                           System.out.println(ex.toString());
                    }
                    try{
                        String sql2= "DELETE FROM t_pembayaran WHERE email_pelanggan ='"+textEmail.getText()+"'";
                        
                        java.sql.Connection conn=(Connection)Database.configDB();
                        java.sql.PreparedStatement pstm2 = conn.prepareStatement(sql2);
                        pstm2.execute();
                        RapihkanTabel();
                      }catch(HeadlessException | SQLException e){
                          JOptionPane.showMessageDialog(this, "Simpan Data Gagal", "Pesan",
                          JOptionPane.WARNING_MESSAGE);
                      }
                }      
                else if (kodeTransaksiInt1 != kodeTransaksiInt2) {
                     try{
                                String sql2= "DELETE FROM t_pembayaran WHERE kode_transaksi ='"+kodeTransaksi2+"'";

                                java.sql.Connection conn=(Connection)Database.configDB();
                                java.sql.PreparedStatement pstm2 = conn.prepareStatement(sql2);
                                pstm2.execute();
                                JOptionPane.showMessageDialog(this, "Data Ada Yang Sudah Kadaluarsa\nData Akan Dihapus Secara Otomatis", "Pesan",
                                JOptionPane.WARNING_MESSAGE);
                                JOptionPane.showMessageDialog(this, "Data Yang Kadaluarsa\nKode Transaksi = "+kodeTransaksi2, "Pesan",
                                JOptionPane.ERROR_MESSAGE);
                                JOptionPane.showMessageDialog(this, "Silhkan Ulangi Pembayaran", "Pesan",
                                JOptionPane.WARNING_MESSAGE);
                                TampilkanDataBarang();
                                RapihkanTabel();
                              }catch(HeadlessException | SQLException e){
                                  JOptionPane.showMessageDialog(this, "Simpan Data Gagal", "Pesan",
                                  JOptionPane.WARNING_MESSAGE);
                              }
                }
                else {
                    JOptionPane.showMessageDialog(this, "Uang Anda Kurang", "Pesan",
                    JOptionPane.WARNING_MESSAGE);
                }
                }
                else {
                    JOptionPane.showMessageDialog(this, "Uang Anda Kurang", "Pesan",
                    JOptionPane.WARNING_MESSAGE);
                }
                RapihkanTabel();
                TampilkanDataBarang();
    }//GEN-LAST:event_labelLakukanPembayaran_Kelompok03MouseClicked

    private void panelPembayaran_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelPembayaran_Kelompok03MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_panelPembayaran_Kelompok03MouseMoved

    private void tabelKeranjang_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKeranjang_Kelompok03MouseClicked
        // TODO add your handling code here:
      int baris=tabelKeranjang_Kelompok03.rowAtPoint(evt.getPoint());
      String kodeBarang = tabelKeranjang_Kelompok03.getValueAt(baris,1).toString();
      textKodeBarang.setText(kodeBarang);
      if (textKodeBarang.getText().equals("KBRCF03")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Baso Tahu Menu.png")));
      }
      else if (textKodeBarang.getText().equals("KBRCF01")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Food Original.png")));
      }
      else if (textKodeBarang.getText().equals("KBRCF02")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Food Medium.png")));
      }
      else if (textKodeBarang.getText().equals("KBRCF04")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Food Special.png")));
      }
      else if (textKodeBarang.getText().equals("KBRCF06")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Air Meneral.png")));
      }
      else if (textKodeBarang.getText().equals("KBRCF05")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Air Mineral 330 ml Keranjang.png")));
      }
      else if (textKodeBarang.getText().equals("KBRCF07")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Air Mineral 660 ml Keranjang.png")));
      }
      else if (textKodeBarang.getText().equals("KBRCF08")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Jus Botol Lemon.png")));
      }
      else if (textKodeBarang.getText().equals("KBRCF09")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keranjang Jus Alpukat.png")));
      }
      else if (textKodeBarang.getText().equals("KBRCF10")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keranjang Jus Strauberi.png")));
      }
      else if (textKodeBarang.getText().equals("KBRCF11")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keranjang Coca Cola.png")));
      }
      else if (textKodeBarang.getText().equals("KBRCF12")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keranjang Sprite.png")));
      }
      else if (textKodeBarang.getText().equals("KBRCF13")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keranjang Fanta.png")));
      }
      else if (textKodeBarang.getText().equals("KBRCF14")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keranjang Kopi Ori.png")));
      }
      else if (textKodeBarang.getText().equals("KBRCF15")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keranjang Capucino.png")));
      }
      else if (textKodeBarang.getText().equals("KBRCF16")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keranjang Misto.png")));
      }
      else if (textKodeBarang.getText().equals("KBRCF17")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Catering.png")));
      }
      else if (textKodeBarang.getText().equals("KBRCF18")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Catering Medium.png")));
      }
      else if (textKodeBarang.getText().equals("KBRCF19")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Catering Besar.png")));
      }
      else if (textKodeBarang.getText().equals("KBRCF20")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Frozen.png")));
      }
      else if (textKodeBarang.getText().equals("KBRCF21")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Frozen Siomay.png")));
      }
      else if (textKodeBarang.getText().equals("KBRCF22")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Frozen Dimsum.png")));
      }
      else if (textKodeBarang.getText().equals("KBRCF93")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Eceran Tahu.png")));
      }
      else if (textKodeBarang.getText().equals("KBRCF94")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Eceran.png")));
      }
    }//GEN-LAST:event_tabelKeranjang_Kelompok03MouseClicked

    private void tabelKeranjang_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKeranjang_Kelompok03MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelKeranjang_Kelompok03MouseMoved

    private void jScrollPane1_kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1_kelompok03MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1_kelompok03MouseMoved

    private void textTotalBiaya_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textTotalBiaya_Kelompok03MouseClicked
       // TODO add your handling code here:
    }//GEN-LAST:event_textTotalBiaya_Kelompok03MouseClicked

    private void textKodeTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textKodeTransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textKodeTransaksiActionPerformed

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
            java.util.logging.Logger.getLogger(FormPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPembayaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1_kelompok03;
    private javax.swing.JLabel labelAkun_Kelompok03;
    private javax.swing.JLabel labelCartin_Kelompok03;
    private javax.swing.JLabel labelFood_Kelompok03;
    private javax.swing.JLabel labelGambar_Kelompok03;
    private javax.swing.JLabel labelGmbr_Kelompok03;
    private javax.swing.JLabel labelHome_Kelompok03;
    private javax.swing.JLabel labelIconNamaDepan_Kelompok03;
    private javax.swing.JLabel labelIconNamaDepan_Kelompok4;
    private javax.swing.JLabel labelIconNamaDepan_Kelompok5;
    private javax.swing.JLabel labelJumlahPsn_Kelompok03;
    private javax.swing.JLabel labelJumlahPsn_Kelompok4;
    private javax.swing.JLabel labelKeluar_Kelompok03;
    private javax.swing.JLabel labelKeranjang_Kelompok03;
    private javax.swing.JLabel labelLakukanPembayaran_Kelompok03;
    private javax.swing.JLabel labelLayanan_Kelompok03;
    private javax.swing.JLabel labelMenu_Kelompok03;
    private javax.swing.JLabel labelPembayaran_Kelompok03;
    private javax.swing.JLabel labelTotalBiaya_Kelompok03;
    private ClassForGUI.PanelRound panelGaris_Kelompok03;
    private ClassForGUI.PanelRound panelGmbr_Kelompok03;
    private ClassForGUI.PanelRound panelJumlahPsn_Kelompok03;
    private ClassForGUI.PanelRound panelPembayaran_Kelompok03;
    private ClassForGUI.PanelRound panelRahasia_kelompok03;
    private ClassForGUI.PanelRound panelTotalBiaya_Kelompok03;
    private javax.swing.JPanel panel_Kelompok03;
    private ClassForGUI.TableDark tabelKeranjang_Kelompok03;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textHargaBarang;
    private javax.swing.JTextField textJumlahPsn_Kelompok03;
    private javax.swing.JTextField textKodeBarang;
    private javax.swing.JTextField textKodeKeranjang;
    private javax.swing.JTextField textKodeLaporan;
    private javax.swing.JTextField textKodeTransaksi;
    private javax.swing.JTextField textKodeTransaksi1;
    private javax.swing.JTextField textTotalBiaya_Kelompok03;
    // End of variables declaration//GEN-END:variables
}
