/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormGUI;

import Database.Database;
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static javax.xml.ws.Service.Mode.MESSAGE;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRLine;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Muhammad Dila
 */
public class FormTransaksiAdmin extends javax.swing.JFrame {

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
        tabelBahanBaku_kelompok03.getColumnModel().getColumn(0).setPreferredWidth(80);
        tabelBahanBaku_kelompok03.getColumnModel().getColumn(1).setPreferredWidth(150);
        tabelBahanBaku_kelompok03.getColumnModel().getColumn(2).setPreferredWidth(90);
        tabelBahanBaku_kelompok03.getColumnModel().getColumn(3).setPreferredWidth(70);
        tabelBahanBaku_kelompok03.getColumnModel().getColumn(4).setPreferredWidth(70);
        tabelBahanBaku_kelompok03.getColumnModel().getColumn(5).setPreferredWidth(160);
        tabelBahanBaku_kelompok03.getColumnModel().getColumn(6).setPreferredWidth(90);
    }
    
    public void TampilkanDataBahan(){
        DefaultTableModel model= new DefaultTableModel();
        model.addColumn("K Transaksi");
        model.addColumn("Nama Barang");
        model.addColumn("Harga Barang");
        model.addColumn("Jmlh Pesan");
        model.addColumn("Total Biaya");
        model.addColumn("Email Pembeli");
        model.addColumn("Tgl Pembelian");
        try{
            String sql="SELECT * FROM t_laporan_transaksi";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(5)
                ,res.getString(7),res.getString(4),res.getString(6)});
            }
            
            tabelBahanBaku_kelompok03.setModel(model);
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public void TampilkanDataBahanPerTanggal(){
        DefaultTableModel model= new DefaultTableModel();
        model.addColumn("K Transaksi");
        model.addColumn("Nama Barang");
        model.addColumn("Harga Barang");
        model.addColumn("Jmlh Pesan");
        model.addColumn("Total Biaya");
        model.addColumn("Email Pembeli");
        model.addColumn("Tgl Pembelian");
        try{
            String sql="SELECT * FROM t_laporan_transaksi WHERE tanggal_pemesanan ='"+textInput_Kelompok03.getText()+"'";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(5)
                ,res.getString(7),res.getString(4),res.getString(6)});
            }
            
                st = conn.createStatement();
                String sql2 = ("SELECT * FROM t_laporan_transaksi WHERE tanggal_pemesanan ='" + textInput_Kelompok03.getText()+"'");
                ResultSet rs = st.executeQuery(sql2); 
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "Data Berhasil Diambil");
                    panelSetPeriodeDataDetail_Kelompok03.setSize(330, 0);
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Data Gagal Diambil\nAtau Data Tidak Ada", "Pesan",
                    JOptionPane.ERROR_MESSAGE);
                }
            
            tabelBahanBaku_kelompok03.setModel(model);
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
        RapihkanTabel();
    }
    
    public void TampilkanDataBahanPerBulan(){
        DefaultTableModel model= new DefaultTableModel();
        model.addColumn("K Transaksi");
        model.addColumn("Nama Barang");
        model.addColumn("Harga Barang");
        model.addColumn("Jmlh Pesan");
        model.addColumn("Total Biaya");
        model.addColumn("Email Pembeli");
        model.addColumn("Tgl Pembelian");
        try{
            String sql="SELECT * FROM t_laporan_transaksi WHERE Bulan ='"+textInput_Kelompok03.getText()+"'";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(5)
                ,res.getString(7),res.getString(4),res.getString(6)});
            }
            st = conn.createStatement();
                String sql2 = ("SELECT * FROM t_laporan_transaksi WHERE Bulan ='" + textInput_Kelompok03.getText()+"'");
                ResultSet rs = st.executeQuery(sql2); 
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "Data Berhasil Diambil");
                    panelSetPeriodeDataDetail_Kelompok03.setSize(330, 0);
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Data Gagal Diambil\nAtau Data Tidak Ada", "Pesan",
                    JOptionPane.ERROR_MESSAGE);
                }
            tabelBahanBaku_kelompok03.setModel(model);
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
        RapihkanTabel();
    }
    
    public void TampilkanDataBahanPerTahun(){
        DefaultTableModel model= new DefaultTableModel();
        model.addColumn("K Transaksi");
        model.addColumn("Nama Barang");
        model.addColumn("Harga Barang");
        model.addColumn("Jmlh Pesan");
        model.addColumn("Total Biaya");
        model.addColumn("Email Pembeli");
        model.addColumn("Tgl Pembelian");
        try{
            String sql="SELECT * FROM t_laporan_transaksi WHERE Tahun ='"+textInput_Kelompok03.getText()+"'";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(5)
                ,res.getString(7),res.getString(4),res.getString(6)});
            }
            st = conn.createStatement();
                String sql2 = ("SELECT * FROM t_laporan_transaksi WHERE Tahun ='" + textInput_Kelompok03.getText()+"'");
                ResultSet rs = st.executeQuery(sql2); 
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "Data Berhasil Diambil");
                    panelSetPeriodeDataDetail_Kelompok03.setSize(330, 0);
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Data Gagal Diambil\nAtau Data Tidak Ada", "Pesan",
                    JOptionPane.ERROR_MESSAGE);
                }
            tabelBahanBaku_kelompok03.setModel(model);
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
        RapihkanTabel();
    }
    
    public void HapusTabel(){
        DefaultTableModel model= new DefaultTableModel();
        model.addColumn("K Transaksi");
        model.addColumn("Nama Barang");
        model.addColumn("Harga Barang");
        model.addColumn("Jmlh Pesan");
        model.addColumn("Total Biaya");
        model.addColumn("Email Pembeli");
        model.addColumn("Tgl Pembelian");
        try{
            String sql="SELECT * FROM t_laporan_transaksi WHERE Tahun ='"+textNamaBahani_Kelompok03.getText()+"'";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(5)
                ,res.getString(7),res.getString(4),res.getString(6)});
            }
            
            tabelBahanBaku_kelompok03.setModel(model);
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
        RapihkanTabel();
    }
    
    public FormTransaksiAdmin() {
        initComponents();
        getContentPane().setBackground(new Color(255,255,255));
        tabelBahanBaku_kelompok03.fixTable(jScrollPane1_kelompok03);
        tabelBahanBaku_kelompok03.setColumnAlignment(0, JLabel.CENTER);
        tabelBahanBaku_kelompok03.setCellAlignment(0, JLabel.CENTER);
        tabelBahanBaku_kelompok03.setColumnAlignment(2, JLabel.CENTER);
        tabelBahanBaku_kelompok03.setCellAlignment(2, JLabel.CENTER);
        tabelBahanBaku_kelompok03.setColumnAlignment(4, JLabel.CENTER);
        tabelBahanBaku_kelompok03.setCellAlignment(4, JLabel.CENTER);
        tabelBahanBaku_kelompok03.setColumnWidth(0, 50);
        tabelBahanBaku_kelompok03.setColumnWidth(2, 100);
        TampilkanDataBahan();
        RapihkanTabel();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Kelompok03 = new javax.swing.JPanel();
        labelCartin_Kelompok03 = new javax.swing.JLabel();
        labelFood_Kelompok03 = new javax.swing.JLabel();
        labelHome_Kelompok03 = new javax.swing.JLabel();
        labelBahanBaku_Kelompok03 = new javax.swing.JLabel();
        labelBarang_Kelompok03 = new javax.swing.JLabel();
        labelPelanggan_Kelompok03 = new javax.swing.JLabel();
        labelKeluar_Kelompok03 = new javax.swing.JLabel();
        labelTransaksi_Kelompok03 = new javax.swing.JLabel();
        panelGaris_Kelompok03 = new ClassForGUI.PanelRound();
        panelBantuan1_Kelompok03 = new ClassForGUI.PanelRound();
        labelBantuan1_Kelompok03 = new javax.swing.JLabel();
        panelOke1_Kelompok03 = new ClassForGUI.PanelRound();
        labelOke1_Kelompok03 = new javax.swing.JLabel();
        panelBantuan2_Kelompok03 = new ClassForGUI.PanelRound();
        labelBantuan1_Kelompok4 = new javax.swing.JLabel();
        panelOke2_Kelompok03 = new ClassForGUI.PanelRound();
        labelOke2_Kelompok03 = new javax.swing.JLabel();
        panelBantuan5_Kelompok03 = new ClassForGUI.PanelRound();
        labelBantuan1_Kelompok7 = new javax.swing.JLabel();
        panelOke2_Kelompok6 = new ClassForGUI.PanelRound();
        labelOke2_Kelompok6 = new javax.swing.JLabel();
        panelBantuan3_Kelompok03 = new ClassForGUI.PanelRound();
        labelBantuan1_Kelompok5 = new javax.swing.JLabel();
        panelOke2_Kelompok4 = new ClassForGUI.PanelRound();
        labelOke2_Kelompok4 = new javax.swing.JLabel();
        panelBantuan4_Kelompok03 = new ClassForGUI.PanelRound();
        labelBantuan1_Kelompok6 = new javax.swing.JLabel();
        panelOke2_Kelompok5 = new ClassForGUI.PanelRound();
        labelOke2_Kelompok5 = new javax.swing.JLabel();
        panelRahasia_Kelompok03 = new ClassForGUI.PanelRound();
        Rahasia = new javax.swing.JLabel();
        labelIconmRahasia_Kelompok03 = new javax.swing.JLabel();
        textRahasia_Kelompok03 = new javax.swing.JTextField();
        textTotalPendapatan_Kelompok03 = new javax.swing.JTextField();
        textPeriodeSet_Kelompok03 = new javax.swing.JTextField();
        textRahasia2_Kelompok03 = new javax.swing.JTextField();
        panelSetPeriodeDataDetail_Kelompok03 = new ClassForGUI.PanelRound();
        panelSet_Kelompok03 = new ClassForGUI.PanelRound();
        labelSet_Kelompok03 = new javax.swing.JLabel();
        paneInput_Kelompok03 = new ClassForGUI.PanelRound();
        labelInput_Kelompok03 = new javax.swing.JLabel();
        textInput_Kelompok03 = new javax.swing.JTextField();
        panelPeriode_Kelompok03 = new ClassForGUI.PanelRound();
        labelPeriode_Kelompok03 = new javax.swing.JLabel();
        textPeriode_Kelompok03 = new ClassForGUI.ComboBoxSuggestion();
        panelGmbr_Kelompok03 = new ClassForGUI.PanelRound();
        labelGmbr_Kelompok03 = new javax.swing.JLabel();
        panelDetailBahanBaku_Kelompok03 = new ClassForGUI.PanelRound();
        paneltanggalMasukl_Kelompok03 = new ClassForGUI.PanelRound();
        labeltanggalMasukl_Kelompok03 = new javax.swing.JLabel();
        dateTglMasuk_Kelompok03 = new com.toedter.calendar.JDateChooser();
        panelNamaBahani_Kelompok03 = new ClassForGUI.PanelRound();
        labelNamaBahani_Kelompok03 = new javax.swing.JLabel();
        labelIconNamaBrgOri_Kelompok03 = new javax.swing.JLabel();
        textNamaBahani_Kelompok03 = new javax.swing.JTextField();
        panelJumlahStocki_Kelompok03 = new ClassForGUI.PanelRound();
        labelJumlahStocki_Kelompok03 = new javax.swing.JLabel();
        labelIconTotalOri_Kelompok03 = new javax.swing.JLabel();
        textJumlahStocki_Kelompok03 = new javax.swing.JTextField();
        panelHargaBahan_Kelompok03 = new ClassForGUI.PanelRound();
        labelHargaBahan_Kelompok03 = new javax.swing.JLabel();
        labelIconJumlahOri_Kelompok03 = new javax.swing.JLabel();
        textHargaBahan_Kelompok03 = new javax.swing.JTextField();
        panelSatuanJumlahi_Kelompok03 = new ClassForGUI.PanelRound();
        labelSatuanJumlahi_Kelompok03 = new javax.swing.JLabel();
        labelIconEmailOri_Kelompok03 = new javax.swing.JLabel();
        textSatuanJumlahi_Kelompok03 = new javax.swing.JTextField();
        panelKdBahani_Kelompok03 = new ClassForGUI.PanelRound();
        labelKdBahani_Kelompok03 = new javax.swing.JLabel();
        labelIconKdBrgOri_Kelompok03 = new javax.swing.JLabel();
        textKdBahani_Kelompok03 = new javax.swing.JTextField();
        panelSimpanPerubahanl_Kelompok03 = new ClassForGUI.PanelRound();
        labelSimpanPerubahanl_Kelompok03 = new javax.swing.JLabel();
        panelKembali_Kelompok03 = new ClassForGUI.PanelRound();
        labelKembali_Kelompok03 = new javax.swing.JLabel();
        panelGmbrDetail_Kelompok03 = new ClassForGUI.PanelRound();
        GmbrDetail_Kelompok03 = new javax.swing.JLabel();
        labelKetDetail_Kelompok03 = new javax.swing.JLabel();
        labelKet2_Kelompok4 = new javax.swing.JLabel();
        panelSetPeriodeData_Kelompok03 = new ClassForGUI.PanelRound();
        labelSetPeriodeData_Kelompok03 = new javax.swing.JLabel();
        jScrollPane1_kelompok03 = new javax.swing.JScrollPane();
        tabelBahanBaku_kelompok03 = new ClassForGUI.TableDark();
        panelCetakLaporan_Kelompok03 = new ClassForGUI.PanelRound();
        labelCetakLaporan_Kelompok03 = new javax.swing.JLabel();
        labelHelp_Kelompok03 = new javax.swing.JLabel();
        labelGambar_Kelompok03 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_Kelompok03.setBackground(new java.awt.Color(255, 176, 0));
        panel_Kelompok03.setPreferredSize(new java.awt.Dimension(1280, 720));
        panel_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelCartin_Kelompok03.setFont(new java.awt.Font("Urbanist Black", 1, 24)); // NOI18N
        labelCartin_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelCartin_Kelompok03.setText("CARTIN");
        labelCartin_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_Kelompok03.add(labelCartin_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 25, 170, -1));

        labelFood_Kelompok03.setFont(new java.awt.Font("Urbanist Black", 1, 24)); // NOI18N
        labelFood_Kelompok03.setForeground(new java.awt.Color(57, 161, 255));
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

        labelBahanBaku_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 20)); // NOI18N
        labelBahanBaku_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelBahanBaku_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBahanBaku_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Bahan Baku Putih.png"))); // NOI18N
        labelBahanBaku_Kelompok03.setText("Bahan Baku");
        labelBahanBaku_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelBahanBaku_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelBahanBaku_Kelompok03MouseMoved(evt);
            }
        });
        labelBahanBaku_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelBahanBaku_Kelompok03MouseClicked(evt);
            }
        });
        panel_Kelompok03.add(labelBahanBaku_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 28, -1, -1));

        labelBarang_Kelompok03.setBackground(new java.awt.Color(102, 102, 102));
        labelBarang_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 20)); // NOI18N
        labelBarang_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelBarang_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Barang Putih.png"))); // NOI18N
        labelBarang_Kelompok03.setText("Barang");
        labelBarang_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelBarang_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelBarang_Kelompok03MouseMoved(evt);
            }
        });
        labelBarang_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelBarang_Kelompok03MouseClicked(evt);
            }
        });
        panel_Kelompok03.add(labelBarang_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 28, -1, -1));

        labelPelanggan_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 20)); // NOI18N
        labelPelanggan_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelPelanggan_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Pelanggan Home Putih.png"))); // NOI18N
        labelPelanggan_Kelompok03.setText("Pelanggan");
        labelPelanggan_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelPelanggan_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelPelanggan_Kelompok03MouseMoved(evt);
            }
        });
        labelPelanggan_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelPelanggan_Kelompok03MouseClicked(evt);
            }
        });
        panel_Kelompok03.add(labelPelanggan_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 28, -1, -1));

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

        labelTransaksi_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 20)); // NOI18N
        labelTransaksi_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelTransaksi_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Transaksi.png"))); // NOI18N
        labelTransaksi_Kelompok03.setText("Transaksi");
        labelTransaksi_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelTransaksi_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelTransaksi_Kelompok03MouseMoved(evt);
            }
        });
        labelTransaksi_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelTransaksi_Kelompok03MouseClicked(evt);
            }
        });
        panel_Kelompok03.add(labelTransaksi_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 28, -1, -1));

        panelGaris_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panel_Kelompok03.add(panelGaris_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1280, 5));

        panelBantuan1_Kelompok03.setBackground(new java.awt.Color(57, 161, 255));
        panelBantuan1_Kelompok03.setRoundBottomLeft(35);
        panelBantuan1_Kelompok03.setRoundBottomRight(35);
        panelBantuan1_Kelompok03.setRoundTopLeft(35);
        panelBantuan1_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelBantuan1_Kelompok03MouseMoved(evt);
            }
        });
        panelBantuan1_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelBantuan1_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelBantuan1_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelBantuan1_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBantuan1_Kelompok03.setText("1. Pilih Tombol Set Periode");
        labelBantuan1_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelBantuan1_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelBantuan1_Kelompok03MouseMoved(evt);
            }
        });
        labelBantuan1_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelBantuan1_Kelompok03MouseClicked(evt);
            }
        });
        panelBantuan1_Kelompok03.add(labelBantuan1_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 250, 30));

        panelOke1_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelOke1_Kelompok03.setRoundBottomLeft(35);
        panelOke1_Kelompok03.setRoundBottomRight(35);
        panelOke1_Kelompok03.setRoundTopLeft(35);
        panelOke1_Kelompok03.setRoundTopRight(35);
        panelOke1_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelOke1_Kelompok03MouseMoved(evt);
            }
        });
        panelOke1_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelOke1_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelOke1_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelOke1_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelOke1_Kelompok03.setText("Oke");
        labelOke1_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelOke1_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelOke1_Kelompok03MouseMoved(evt);
            }
        });
        labelOke1_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelOke1_Kelompok03MouseClicked(evt);
            }
        });
        panelOke1_Kelompok03.add(labelOke1_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 30));

        panelBantuan1_Kelompok03.add(panelOke1_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 80, 30));

        panel_Kelompok03.add(panelBantuan1_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 480, 270, 0));

        panelBantuan2_Kelompok03.setBackground(new java.awt.Color(57, 161, 255));
        panelBantuan2_Kelompok03.setRoundBottomLeft(35);
        panelBantuan2_Kelompok03.setRoundBottomRight(35);
        panelBantuan2_Kelompok03.setRoundTopLeft(35);
        panelBantuan2_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelBantuan2_Kelompok03MouseMoved(evt);
            }
        });
        panelBantuan2_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelBantuan1_Kelompok4.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelBantuan1_Kelompok4.setForeground(new java.awt.Color(21, 0, 53));
        labelBantuan1_Kelompok4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBantuan1_Kelompok4.setText("2. Pilih Periode Data Yang Akan Digunakan");
        labelBantuan1_Kelompok4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelBantuan1_Kelompok4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelBantuan1_Kelompok4MouseMoved(evt);
            }
        });
        labelBantuan1_Kelompok4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelBantuan1_Kelompok4MouseClicked(evt);
            }
        });
        panelBantuan2_Kelompok03.add(labelBantuan1_Kelompok4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 400, 30));

        panelOke2_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelOke2_Kelompok03.setRoundBottomLeft(35);
        panelOke2_Kelompok03.setRoundBottomRight(35);
        panelOke2_Kelompok03.setRoundTopLeft(35);
        panelOke2_Kelompok03.setRoundTopRight(35);
        panelOke2_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelOke2_Kelompok03MouseMoved(evt);
            }
        });
        panelOke2_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelOke2_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelOke2_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelOke2_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelOke2_Kelompok03.setText("Oke");
        labelOke2_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelOke2_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelOke2_Kelompok03MouseMoved(evt);
            }
        });
        labelOke2_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelOke2_Kelompok03MouseClicked(evt);
            }
        });
        panelOke2_Kelompok03.add(labelOke2_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 30));

        panelBantuan2_Kelompok03.add(panelOke2_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 80, 30));

        panel_Kelompok03.add(panelBantuan2_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 480, 420, 0));

        panelBantuan5_Kelompok03.setBackground(new java.awt.Color(57, 161, 255));
        panelBantuan5_Kelompok03.setRoundBottomLeft(35);
        panelBantuan5_Kelompok03.setRoundBottomRight(35);
        panelBantuan5_Kelompok03.setRoundTopLeft(35);
        panelBantuan5_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelBantuan5_Kelompok03MouseMoved(evt);
            }
        });
        panelBantuan5_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelBantuan1_Kelompok7.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelBantuan1_Kelompok7.setForeground(new java.awt.Color(21, 0, 53));
        labelBantuan1_Kelompok7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBantuan1_Kelompok7.setText("5. Pilih Tombol Cetak Untuk Mencetak Laporan");
        labelBantuan1_Kelompok7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelBantuan1_Kelompok7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelBantuan1_Kelompok7MouseMoved(evt);
            }
        });
        labelBantuan1_Kelompok7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelBantuan1_Kelompok7MouseClicked(evt);
            }
        });
        panelBantuan5_Kelompok03.add(labelBantuan1_Kelompok7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 400, 30));

        panelOke2_Kelompok6.setBackground(new java.awt.Color(255, 255, 255));
        panelOke2_Kelompok6.setRoundBottomLeft(35);
        panelOke2_Kelompok6.setRoundBottomRight(35);
        panelOke2_Kelompok6.setRoundTopLeft(35);
        panelOke2_Kelompok6.setRoundTopRight(35);
        panelOke2_Kelompok6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelOke2_Kelompok6MouseMoved(evt);
            }
        });
        panelOke2_Kelompok6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelOke2_Kelompok6.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelOke2_Kelompok6.setForeground(new java.awt.Color(21, 0, 53));
        labelOke2_Kelompok6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelOke2_Kelompok6.setText("Oke");
        labelOke2_Kelompok6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelOke2_Kelompok6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelOke2_Kelompok6MouseMoved(evt);
            }
        });
        labelOke2_Kelompok6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelOke2_Kelompok6MouseClicked(evt);
            }
        });
        panelOke2_Kelompok6.add(labelOke2_Kelompok6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 30));

        panelBantuan5_Kelompok03.add(panelOke2_Kelompok6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 80, 30));

        panel_Kelompok03.add(panelBantuan5_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 560, 420, 0));

        panelBantuan3_Kelompok03.setBackground(new java.awt.Color(57, 161, 255));
        panelBantuan3_Kelompok03.setRoundBottomLeft(35);
        panelBantuan3_Kelompok03.setRoundBottomRight(35);
        panelBantuan3_Kelompok03.setRoundTopLeft(35);
        panelBantuan3_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelBantuan3_Kelompok03MouseMoved(evt);
            }
        });
        panelBantuan3_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelBantuan1_Kelompok5.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelBantuan1_Kelompok5.setForeground(new java.awt.Color(21, 0, 53));
        labelBantuan1_Kelompok5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBantuan1_Kelompok5.setText("3. Inputkan Data Sesuia Dengan Periode");
        labelBantuan1_Kelompok5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelBantuan1_Kelompok5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelBantuan1_Kelompok5MouseMoved(evt);
            }
        });
        labelBantuan1_Kelompok5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelBantuan1_Kelompok5MouseClicked(evt);
            }
        });
        panelBantuan3_Kelompok03.add(labelBantuan1_Kelompok5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 400, 30));

        panelOke2_Kelompok4.setBackground(new java.awt.Color(255, 255, 255));
        panelOke2_Kelompok4.setRoundBottomLeft(35);
        panelOke2_Kelompok4.setRoundBottomRight(35);
        panelOke2_Kelompok4.setRoundTopLeft(35);
        panelOke2_Kelompok4.setRoundTopRight(35);
        panelOke2_Kelompok4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelOke2_Kelompok4MouseMoved(evt);
            }
        });
        panelOke2_Kelompok4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelOke2_Kelompok4.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelOke2_Kelompok4.setForeground(new java.awt.Color(21, 0, 53));
        labelOke2_Kelompok4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelOke2_Kelompok4.setText("Oke");
        labelOke2_Kelompok4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelOke2_Kelompok4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelOke2_Kelompok4MouseMoved(evt);
            }
        });
        labelOke2_Kelompok4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelOke2_Kelompok4MouseClicked(evt);
            }
        });
        panelOke2_Kelompok4.add(labelOke2_Kelompok4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 30));

        panelBantuan3_Kelompok03.add(panelOke2_Kelompok4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 80, 30));

        panel_Kelompok03.add(panelBantuan3_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 570, 420, 0));

        panelBantuan4_Kelompok03.setBackground(new java.awt.Color(57, 161, 255));
        panelBantuan4_Kelompok03.setRoundBottomLeft(35);
        panelBantuan4_Kelompok03.setRoundTopLeft(35);
        panelBantuan4_Kelompok03.setRoundTopRight(35);
        panelBantuan4_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelBantuan4_Kelompok03MouseMoved(evt);
            }
        });
        panelBantuan4_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelBantuan1_Kelompok6.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelBantuan1_Kelompok6.setForeground(new java.awt.Color(21, 0, 53));
        labelBantuan1_Kelompok6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBantuan1_Kelompok6.setText("4. Pilih Tombol Set Periode Data");
        labelBantuan1_Kelompok6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelBantuan1_Kelompok6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelBantuan1_Kelompok6MouseMoved(evt);
            }
        });
        labelBantuan1_Kelompok6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelBantuan1_Kelompok6MouseClicked(evt);
            }
        });
        panelBantuan4_Kelompok03.add(labelBantuan1_Kelompok6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 400, 30));

        panelOke2_Kelompok5.setBackground(new java.awt.Color(255, 255, 255));
        panelOke2_Kelompok5.setRoundBottomLeft(35);
        panelOke2_Kelompok5.setRoundBottomRight(35);
        panelOke2_Kelompok5.setRoundTopLeft(35);
        panelOke2_Kelompok5.setRoundTopRight(35);
        panelOke2_Kelompok5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelOke2_Kelompok5MouseMoved(evt);
            }
        });
        panelOke2_Kelompok5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelOke2_Kelompok5.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelOke2_Kelompok5.setForeground(new java.awt.Color(21, 0, 53));
        labelOke2_Kelompok5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelOke2_Kelompok5.setText("Oke");
        labelOke2_Kelompok5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelOke2_Kelompok5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelOke2_Kelompok5MouseMoved(evt);
            }
        });
        labelOke2_Kelompok5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelOke2_Kelompok5MouseClicked(evt);
            }
        });
        panelOke2_Kelompok5.add(labelOke2_Kelompok5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 30));

        panelBantuan4_Kelompok03.add(panelOke2_Kelompok5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 80, 30));

        panel_Kelompok03.add(panelBantuan4_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 540, 420, 0));

        panelRahasia_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelRahasia_Kelompok03.setRoundBottomLeft(25);
        panelRahasia_Kelompok03.setRoundBottomRight(25);
        panelRahasia_Kelompok03.setRoundTopLeft(25);
        panelRahasia_Kelompok03.setRoundTopRight(25);
        panelRahasia_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Rahasia.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        Rahasia.setForeground(new java.awt.Color(21, 0, 53));
        Rahasia.setText("Rahasia");
        panelRahasia_Kelompok03.add(Rahasia, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        labelIconmRahasia_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconmRahasia_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelIconmRahasia_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconmRahasia_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Nama Barang.png"))); // NOI18N
        panelRahasia_Kelompok03.add(labelIconmRahasia_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 40, 40));

        textRahasia_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textRahasia_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textRahasia_Kelompok03.setText("asd");
        textRahasia_Kelompok03.setBorder(null);
        textRahasia_Kelompok03.setOpaque(false);
        panelRahasia_Kelompok03.add(textRahasia_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 250, -1));

        textTotalPendapatan_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textTotalPendapatan_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textTotalPendapatan_Kelompok03.setText("asd");
        textTotalPendapatan_Kelompok03.setBorder(null);
        textTotalPendapatan_Kelompok03.setOpaque(false);
        panelRahasia_Kelompok03.add(textTotalPendapatan_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 250, -1));

        textPeriodeSet_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textPeriodeSet_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textPeriodeSet_Kelompok03.setText("asd");
        textPeriodeSet_Kelompok03.setBorder(null);
        textPeriodeSet_Kelompok03.setOpaque(false);
        panelRahasia_Kelompok03.add(textPeriodeSet_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 250, -1));

        textRahasia2_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textRahasia2_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textRahasia2_Kelompok03.setBorder(null);
        textRahasia2_Kelompok03.setOpaque(false);
        panelRahasia_Kelompok03.add(textRahasia2_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 250, -1));

        panel_Kelompok03.add(panelRahasia_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, 280, 0));

        panelSetPeriodeDataDetail_Kelompok03.setBackground(new java.awt.Color(21, 0, 53));
        panelSetPeriodeDataDetail_Kelompok03.setRoundBottomLeft(35);
        panelSetPeriodeDataDetail_Kelompok03.setRoundBottomRight(35);
        panelSetPeriodeDataDetail_Kelompok03.setRoundTopLeft(35);
        panelSetPeriodeDataDetail_Kelompok03.setRoundTopRight(35);
        panelSetPeriodeDataDetail_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelSetPeriodeDataDetail_Kelompok03MouseMoved(evt);
            }
        });
        panelSetPeriodeDataDetail_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelSet_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelSet_Kelompok03.setRoundBottomLeft(25);
        panelSet_Kelompok03.setRoundBottomRight(25);
        panelSet_Kelompok03.setRoundTopLeft(25);
        panelSet_Kelompok03.setRoundTopRight(25);
        panelSet_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelSet_Kelompok03MouseMoved(evt);
            }
        });
        panelSet_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelSet_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelSet_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelSet_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSet_Kelompok03.setText("Set Periode Data");
        labelSet_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelSet_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelSet_Kelompok03MouseMoved(evt);
            }
        });
        labelSet_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSet_Kelompok03MouseClicked(evt);
            }
        });
        panelSet_Kelompok03.add(labelSet_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 270, 40));

        panelSetPeriodeDataDetail_Kelompok03.add(panelSet_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 290, 40));

        paneInput_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        paneInput_Kelompok03.setRoundBottomLeft(25);
        paneInput_Kelompok03.setRoundBottomRight(25);
        paneInput_Kelompok03.setRoundTopLeft(25);
        paneInput_Kelompok03.setRoundTopRight(25);
        paneInput_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelInput_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelInput_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelInput_Kelompok03.setText("Inputkan Tanggal / Bulan / Tahun");
        paneInput_Kelompok03.add(labelInput_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 250, -1));

        textInput_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textInput_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textInput_Kelompok03.setBorder(null);
        textInput_Kelompok03.setOpaque(false);
        textInput_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textInput_Kelompok03MouseClicked(evt);
            }
        });
        paneInput_Kelompok03.add(textInput_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 250, -1));

        panelSetPeriodeDataDetail_Kelompok03.add(paneInput_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 290, 60));

        panelPeriode_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelPeriode_Kelompok03.setRoundBottomLeft(25);
        panelPeriode_Kelompok03.setRoundBottomRight(25);
        panelPeriode_Kelompok03.setRoundTopLeft(25);
        panelPeriode_Kelompok03.setRoundTopRight(25);
        panelPeriode_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelPeriode_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelPeriode_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelPeriode_Kelompok03.setText("Pilih Periode Data");
        panelPeriode_Kelompok03.add(labelPeriode_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        textPeriode_Kelompok03.setBorder(null);
        textPeriode_Kelompok03.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Per Tanggal", "Per Bulan", "Per Tahun" }));
        textPeriode_Kelompok03.setSelectedIndex(-1);
        textPeriode_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textPeriode_Kelompok03.setOpaque(false);
        textPeriode_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textPeriode_Kelompok03MouseClicked(evt);
            }
        });
        textPeriode_Kelompok03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPeriode_Kelompok03ActionPerformed(evt);
            }
        });
        textPeriode_Kelompok03.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                textPeriode_Kelompok03PropertyChange(evt);
            }
        });
        panelPeriode_Kelompok03.add(textPeriode_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, 270, 30));

        panelSetPeriodeDataDetail_Kelompok03.add(panelPeriode_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 290, 60));

        panel_Kelompok03.add(panelSetPeriodeDataDetail_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 450, 330, 0));

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

        panelDetailBahanBaku_Kelompok03.setBackground(new java.awt.Color(57, 161, 255));
        panelDetailBahanBaku_Kelompok03.setRoundBottomLeft(25);
        panelDetailBahanBaku_Kelompok03.setRoundBottomRight(25);
        panelDetailBahanBaku_Kelompok03.setRoundTopLeft(25);
        panelDetailBahanBaku_Kelompok03.setRoundTopRight(25);
        panelDetailBahanBaku_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelDetailBahanBaku_Kelompok03MouseMoved(evt);
            }
        });
        panelDetailBahanBaku_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paneltanggalMasukl_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        paneltanggalMasukl_Kelompok03.setRoundBottomLeft(25);
        paneltanggalMasukl_Kelompok03.setRoundBottomRight(25);
        paneltanggalMasukl_Kelompok03.setRoundTopLeft(25);
        paneltanggalMasukl_Kelompok03.setRoundTopRight(25);
        paneltanggalMasukl_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labeltanggalMasukl_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labeltanggalMasukl_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labeltanggalMasukl_Kelompok03.setText("Tanggal Masuk");
        paneltanggalMasukl_Kelompok03.add(labeltanggalMasukl_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        dateTglMasuk_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        dateTglMasuk_Kelompok03.setDateFormatString("dd/MM/yyyy");
        dateTglMasuk_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        dateTglMasuk_Kelompok03.setOpaque(false);
        dateTglMasuk_Kelompok03.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateTglMasuk_Kelompok03PropertyChange(evt);
            }
        });
        dateTglMasuk_Kelompok03.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                dateTglMasuk_Kelompok03VetoableChange(evt);
            }
        });
        paneltanggalMasukl_Kelompok03.add(dateTglMasuk_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, 260, 30));

        panelDetailBahanBaku_Kelompok03.add(paneltanggalMasukl_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, 280, 60));

        panelNamaBahani_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelNamaBahani_Kelompok03.setRoundBottomLeft(25);
        panelNamaBahani_Kelompok03.setRoundBottomRight(25);
        panelNamaBahani_Kelompok03.setRoundTopLeft(25);
        panelNamaBahani_Kelompok03.setRoundTopRight(25);
        panelNamaBahani_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNamaBahani_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelNamaBahani_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelNamaBahani_Kelompok03.setText("Nama Bahan");
        panelNamaBahani_Kelompok03.add(labelNamaBahani_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        labelIconNamaBrgOri_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconNamaBrgOri_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelIconNamaBrgOri_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconNamaBrgOri_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Nama Barang.png"))); // NOI18N
        panelNamaBahani_Kelompok03.add(labelIconNamaBrgOri_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 40, 40));

        textNamaBahani_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textNamaBahani_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textNamaBahani_Kelompok03.setBorder(null);
        textNamaBahani_Kelompok03.setOpaque(false);
        panelNamaBahani_Kelompok03.add(textNamaBahani_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 250, -1));

        panelDetailBahanBaku_Kelompok03.add(panelNamaBahani_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 90, 280, 60));

        panelJumlahStocki_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelJumlahStocki_Kelompok03.setRoundBottomLeft(25);
        panelJumlahStocki_Kelompok03.setRoundBottomRight(25);
        panelJumlahStocki_Kelompok03.setRoundTopLeft(25);
        panelJumlahStocki_Kelompok03.setRoundTopRight(25);
        panelJumlahStocki_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelJumlahStocki_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelJumlahStocki_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelJumlahStocki_Kelompok03.setText("Jumlah Stok");
        panelJumlahStocki_Kelompok03.add(labelJumlahStocki_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        labelIconTotalOri_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconTotalOri_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelIconTotalOri_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconTotalOri_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Total Biaya.png"))); // NOI18N
        panelJumlahStocki_Kelompok03.add(labelIconTotalOri_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 40, 40));

        textJumlahStocki_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textJumlahStocki_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textJumlahStocki_Kelompok03.setBorder(null);
        textJumlahStocki_Kelompok03.setOpaque(false);
        panelJumlahStocki_Kelompok03.add(textJumlahStocki_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 250, -1));

        panelDetailBahanBaku_Kelompok03.add(panelJumlahStocki_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 280, 60));

        panelHargaBahan_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelHargaBahan_Kelompok03.setRoundBottomLeft(25);
        panelHargaBahan_Kelompok03.setRoundBottomRight(25);
        panelHargaBahan_Kelompok03.setRoundTopLeft(25);
        panelHargaBahan_Kelompok03.setRoundTopRight(25);
        panelHargaBahan_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelHargaBahan_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelHargaBahan_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelHargaBahan_Kelompok03.setText("Harga Bahan");
        panelHargaBahan_Kelompok03.add(labelHargaBahan_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        labelIconJumlahOri_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconJumlahOri_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelIconJumlahOri_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconJumlahOri_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Jumlah Pesanan.png"))); // NOI18N
        panelHargaBahan_Kelompok03.add(labelIconJumlahOri_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 40, 40));

        textHargaBahan_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textHargaBahan_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textHargaBahan_Kelompok03.setBorder(null);
        textHargaBahan_Kelompok03.setOpaque(false);
        panelHargaBahan_Kelompok03.add(textHargaBahan_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 250, -1));

        panelDetailBahanBaku_Kelompok03.add(panelHargaBahan_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 270, 280, 60));

        panelSatuanJumlahi_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelSatuanJumlahi_Kelompok03.setRoundBottomLeft(25);
        panelSatuanJumlahi_Kelompok03.setRoundBottomRight(25);
        panelSatuanJumlahi_Kelompok03.setRoundTopLeft(25);
        panelSatuanJumlahi_Kelompok03.setRoundTopRight(25);
        panelSatuanJumlahi_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelSatuanJumlahi_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelSatuanJumlahi_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelSatuanJumlahi_Kelompok03.setText("Satuan Jumlah");
        panelSatuanJumlahi_Kelompok03.add(labelSatuanJumlahi_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        labelIconEmailOri_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconEmailOri_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelIconEmailOri_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconEmailOri_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Email.png"))); // NOI18N
        panelSatuanJumlahi_Kelompok03.add(labelIconEmailOri_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 40, 40));

        textSatuanJumlahi_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textSatuanJumlahi_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textSatuanJumlahi_Kelompok03.setBorder(null);
        textSatuanJumlahi_Kelompok03.setOpaque(false);
        panelSatuanJumlahi_Kelompok03.add(textSatuanJumlahi_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 250, -1));

        panelDetailBahanBaku_Kelompok03.add(panelSatuanJumlahi_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 180, 280, 60));

        panelKdBahani_Kelompok03.setBackground(new java.awt.Color(222, 225, 229));
        panelKdBahani_Kelompok03.setRoundBottomLeft(25);
        panelKdBahani_Kelompok03.setRoundBottomRight(25);
        panelKdBahani_Kelompok03.setRoundTopLeft(25);
        panelKdBahani_Kelompok03.setRoundTopRight(25);
        panelKdBahani_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelKdBahani_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelKdBahani_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelKdBahani_Kelompok03.setText("Kode Bahan");
        panelKdBahani_Kelompok03.add(labelKdBahani_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        labelIconKdBrgOri_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconKdBrgOri_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelIconKdBrgOri_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconKdBrgOri_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Kode Barang.png"))); // NOI18N
        panelKdBahani_Kelompok03.add(labelIconKdBrgOri_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 40, 40));

        textKdBahani_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textKdBahani_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textKdBahani_Kelompok03.setBorder(null);
        textKdBahani_Kelompok03.setEnabled(false);
        textKdBahani_Kelompok03.setOpaque(false);
        panelKdBahani_Kelompok03.add(textKdBahani_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 250, -1));

        panelDetailBahanBaku_Kelompok03.add(panelKdBahani_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 280, 60));

        panelSimpanPerubahanl_Kelompok03.setBackground(new java.awt.Color(21, 0, 53));
        panelSimpanPerubahanl_Kelompok03.setRoundBottomLeft(35);
        panelSimpanPerubahanl_Kelompok03.setRoundBottomRight(35);
        panelSimpanPerubahanl_Kelompok03.setRoundTopLeft(35);
        panelSimpanPerubahanl_Kelompok03.setRoundTopRight(35);
        panelSimpanPerubahanl_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelSimpanPerubahanl_Kelompok03MouseMoved(evt);
            }
        });
        panelSimpanPerubahanl_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelSimpanPerubahanl_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelSimpanPerubahanl_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelSimpanPerubahanl_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSimpanPerubahanl_Kelompok03.setText("Simpan Perubahan");
        labelSimpanPerubahanl_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelSimpanPerubahanl_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelSimpanPerubahanl_Kelompok03MouseMoved(evt);
            }
        });
        labelSimpanPerubahanl_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSimpanPerubahanl_Kelompok03MouseClicked(evt);
            }
        });
        panelSimpanPerubahanl_Kelompok03.add(labelSimpanPerubahanl_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 560, 30));

        panelDetailBahanBaku_Kelompok03.add(panelSimpanPerubahanl_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 360, 580, 60));

        panelKembali_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelKembali_Kelompok03.setRoundBottomLeft(35);
        panelKembali_Kelompok03.setRoundBottomRight(35);
        panelKembali_Kelompok03.setRoundTopLeft(35);
        panelKembali_Kelompok03.setRoundTopRight(35);
        panelKembali_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelKembali_Kelompok03MouseMoved(evt);
            }
        });
        panelKembali_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelKembali_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelKembali_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelKembali_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelKembali_Kelompok03.setText("Kembali");
        labelKembali_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelKembali_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelKembali_Kelompok03MouseMoved(evt);
            }
        });
        labelKembali_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelKembali_Kelompok03MouseClicked(evt);
            }
        });
        panelKembali_Kelompok03.add(labelKembali_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 110, 30));

        panelDetailBahanBaku_Kelompok03.add(panelKembali_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, 130, 40));

        panelGmbrDetail_Kelompok03.setBackground(new java.awt.Color(21, 0, 53));
        panelGmbrDetail_Kelompok03.setRoundBottomLeft(25);
        panelGmbrDetail_Kelompok03.setRoundBottomRight(25);
        panelGmbrDetail_Kelompok03.setRoundTopLeft(25);
        panelGmbrDetail_Kelompok03.setRoundTopRight(25);
        panelGmbrDetail_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelGmbrDetail_Kelompok03MouseMoved(evt);
            }
        });
        panelGmbrDetail_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GmbrDetail_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 20)); // NOI18N
        GmbrDetail_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        GmbrDetail_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GmbrDetail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Original Detail.png"))); // NOI18N
        GmbrDetail_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                GmbrDetail_Kelompok03MouseMoved(evt);
            }
        });
        panelGmbrDetail_Kelompok03.add(GmbrDetail_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 550, 470));

        panelDetailBahanBaku_Kelompok03.add(panelGmbrDetail_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 530, 450));

        labelKetDetail_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelKetDetail_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelKetDetail_Kelompok03.setText("Detail Bahan");
        panelDetailBahanBaku_Kelompok03.add(labelKetDetail_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, 460, -1));

        labelKet2_Kelompok4.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelKet2_Kelompok4.setForeground(new java.awt.Color(21, 0, 53));
        labelKet2_Kelompok4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelKet2_Kelompok4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Artboard Admin.png"))); // NOI18N
        labelKet2_Kelompok4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelKet2_Kelompok4MouseMoved(evt);
            }
        });
        panelDetailBahanBaku_Kelompok03.add(labelKet2_Kelompok4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 640));

        panel_Kelompok03.add(panelDetailBahanBaku_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1280, 0));

        panelSetPeriodeData_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelSetPeriodeData_Kelompok03.setRoundBottomLeft(35);
        panelSetPeriodeData_Kelompok03.setRoundBottomRight(35);
        panelSetPeriodeData_Kelompok03.setRoundTopLeft(35);
        panelSetPeriodeData_Kelompok03.setRoundTopRight(35);
        panelSetPeriodeData_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelSetPeriodeData_Kelompok03MouseMoved(evt);
            }
        });
        panelSetPeriodeData_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelSetPeriodeData_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelSetPeriodeData_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelSetPeriodeData_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSetPeriodeData_Kelompok03.setText("Set Periode Data Transaksi");
        labelSetPeriodeData_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelSetPeriodeData_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelSetPeriodeData_Kelompok03MouseMoved(evt);
            }
        });
        labelSetPeriodeData_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSetPeriodeData_Kelompok03MouseClicked(evt);
            }
        });
        panelSetPeriodeData_Kelompok03.add(labelSetPeriodeData_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 310, 30));

        panel_Kelompok03.add(panelSetPeriodeData_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 450, 330, 60));

        tabelBahanBaku_kelompok03.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelBahanBaku_kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBahanBaku_kelompok03MouseClicked(evt);
            }
        });
        jScrollPane1_kelompok03.setViewportView(tabelBahanBaku_kelompok03);

        panel_Kelompok03.add(jScrollPane1_kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 117, 830, 570));

        panelCetakLaporan_Kelompok03.setBackground(new java.awt.Color(21, 0, 53));
        panelCetakLaporan_Kelompok03.setRoundBottomLeft(35);
        panelCetakLaporan_Kelompok03.setRoundBottomRight(35);
        panelCetakLaporan_Kelompok03.setRoundTopLeft(35);
        panelCetakLaporan_Kelompok03.setRoundTopRight(35);
        panelCetakLaporan_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelCetakLaporan_Kelompok03MouseMoved(evt);
            }
        });
        panelCetakLaporan_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelCetakLaporan_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelCetakLaporan_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelCetakLaporan_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCetakLaporan_Kelompok03.setText("Cetak Laporan Data Transaksi");
        labelCetakLaporan_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelCetakLaporan_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelCetakLaporan_Kelompok03MouseMoved(evt);
            }
        });
        labelCetakLaporan_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCetakLaporan_Kelompok03MouseClicked(evt);
            }
        });
        panelCetakLaporan_Kelompok03.add(labelCetakLaporan_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 310, 30));

        panel_Kelompok03.add(panelCetakLaporan_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 530, 330, 60));

        labelHelp_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHelp_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Help Hitam.png"))); // NOI18N
        labelHelp_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelHelp_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelHelp_Kelompok03MouseMoved(evt);
            }
        });
        labelHelp_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelHelp_Kelompok03MouseClicked(evt);
            }
        });
        panel_Kelompok03.add(labelHelp_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 25, -1, -1));

        labelGambar_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelGambar_Kelompok03.setForeground(new java.awt.Color(255, 0, 0));
        labelGambar_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Artboard Admin.png"))); // NOI18N
        labelGambar_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelGambar_Kelompok03MouseMoved(evt);
            }
        });
        panel_Kelompok03.add(labelGambar_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 710));

        getContentPane().add(panel_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(1296, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void labelBahanBaku_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBahanBaku_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelBahanBaku_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Bahan Baku.png")));
        labelBahanBaku_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
    }//GEN-LAST:event_labelBahanBaku_Kelompok03MouseMoved

    private void labelHome_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelHome_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelHome_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Home.png")));
        labelHome_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
    }//GEN-LAST:event_labelHome_Kelompok03MouseMoved

    private void labelBarang_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBarang_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelBarang_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Barang.png")));
        labelBarang_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
    }//GEN-LAST:event_labelBarang_Kelompok03MouseMoved

    private void labelPelanggan_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPelanggan_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelPelanggan_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Pelanggan Home.png")));
        labelPelanggan_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
    }//GEN-LAST:event_labelPelanggan_Kelompok03MouseMoved

    private void labelTransaksi_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTransaksi_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelTransaksi_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Transaksi Putih.png")));
        labelTransaksi_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_labelTransaksi_Kelompok03MouseMoved

    private void labelKeluar_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelKeluar_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelKeluar_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keluar.png")));
        labelKeluar_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
    }//GEN-LAST:event_labelKeluar_Kelompok03MouseMoved

    private void labelKeluar_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelKeluar_Kelompok03MouseClicked
        // TODO add your handling code here:
        FormLoginAdmin s = new FormLoginAdmin();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_labelKeluar_Kelompok03MouseClicked

    private void labelBahanBaku_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBahanBaku_Kelompok03MouseClicked
        // TODO add your handling code here:
        FormBahanBakuAdmin s = new FormBahanBakuAdmin();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_labelBahanBaku_Kelompok03MouseClicked

    private void labelBarang_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBarang_Kelompok03MouseClicked
        // TODO add your handling code here:
        FormBarangAdmin s = new FormBarangAdmin();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_labelBarang_Kelompok03MouseClicked

    private void labelPelanggan_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPelanggan_Kelompok03MouseClicked
        // TODO add your handling code here:
        FormPelangganAdmin s = new FormPelangganAdmin();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_labelPelanggan_Kelompok03MouseClicked

    private void labelTransaksi_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTransaksi_Kelompok03MouseClicked
        // TODO add your handling code here:
        FormTransaksiAdmin s = new FormTransaksiAdmin();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_labelTransaksi_Kelompok03MouseClicked

    private void labelHome_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelHome_Kelompok03MouseClicked
        // TODO add your handling code here:
        FormHomeAdmin s = new FormHomeAdmin();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_labelHome_Kelompok03MouseClicked

    private void labelGambar_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelGambar_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelBahanBaku_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Bahan Baku Putih.png")));
        labelBahanBaku_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelHome_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Home Putih.png")));
        labelHome_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelBarang_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Barang Putih.png")));
        labelBarang_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelPelanggan_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Pelanggan Home Putih.png")));
        labelPelanggan_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelTransaksi_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Transaksi.png")));
        labelTransaksi_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelKeluar_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keluar Putih.png")));
        labelKeluar_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        panelCetakLaporan_Kelompok03.setBackground(new java.awt.Color(21, 0, 53));
        labelCetakLaporan_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        panelSetPeriodeData_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelSet_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        labelHelp_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Help Hitam.png")));
    }//GEN-LAST:event_labelGambar_Kelompok03MouseMoved

    private void labelCetakLaporan_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCetakLaporan_Kelompok03MouseMoved
        // TODO add your handling code here:
        panelCetakLaporan_Kelompok03.setBackground(new java.awt.Color(57,161,255));
        labelCetakLaporan_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
    }//GEN-LAST:event_labelCetakLaporan_Kelompok03MouseMoved

    private void labelCetakLaporan_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCetakLaporan_Kelompok03MouseClicked
        // TODO add your handling code here:
        if (textInput_Kelompok03.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Silahkan Set Periode Terlebih Dahulu", "Pesan",
                          JOptionPane.WARNING_MESSAGE);
        }
        int sum = 0;
        for(int i = 0; i < tabelBahanBaku_kelompok03.getRowCount(); i++)
        {
            sum = sum + Integer.parseInt(tabelBahanBaku_kelompok03.getValueAt(i, 4).toString());
        }
        textTotalPendapatan_Kelompok03.setText(Integer.toString(sum));
        try{
                        String sql = "UPDATE t_laporan_transaksi SET total_pendapatan ='" + textTotalPendapatan_Kelompok03.getText()+"'";
                        
                        java.sql.Connection conn=(Connection)Database.configDB();
                        java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                        pstm.execute();
                        RapihkanTabel();
                      }catch(HeadlessException | SQLException e){
                          JOptionPane.showMessageDialog(this, "Simpan Data Gagal", "Pesan",
                          JOptionPane.WARNING_MESSAGE);
                      }
        if (textPeriode_Kelompok03.getSelectedItem().equals("Per Tanggal")||textInput_Kelompok03.getText().equals("Contoh (31/12/2022)")) {
        try{
            if (textInput_Kelompok03.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Silahkan Inputkan Periode Terlebih Dahulu", "Pesan",
                          JOptionPane.WARNING_MESSAGE);
            }else {
                        String Respone = textInput_Kelompok03.getText();
                        Database objkoneksi = new Database();
                        Connection con =objkoneksi.configDB();
                        String fileName="src\\CetakLaporan\\LaporanMasterTransaksi.jrxml";
                        String filetoFill="src\\CetakLaporan\\LaporanMasterTransaksi.jasper";
                        JasperCompileManager.compileReport(fileName);
                        Map param= new HashMap();
                        param.put("PerTanggal", Respone);
                        JasperFillManager.fillReport(filetoFill, param, con);
                        JasperPrint jp=JasperFillManager.fillReport(filetoFill, param,con);
                        JasperViewer.viewReport(jp, false);
                    }
        }catch(Exception ex){
                           System.out.println(ex.toString());
                    }
    }
        else if (textPeriode_Kelompok03.getSelectedItem().equals("Per Bulan")){
        try{
            if (textInput_Kelompok03.getText().equals("")||textInput_Kelompok03.getText().equals("Contoh (Juli 2022)")) {
                JOptionPane.showMessageDialog(this, "Silahkan Inputkan Periode Terlebih Dahulu", "Pesan",
                          JOptionPane.WARNING_MESSAGE);
            }else {
                        String Respone = textInput_Kelompok03.getText();
                        Database objkoneksi = new Database();
                        Connection con =objkoneksi.configDB();
                        String fileName="src\\CetakLaporan\\LaporanMasterTransaksiBulan.jrxml";
                        String filetoFill="src\\CetakLaporan\\LaporanMasterTransaksiBulan.jasper";
                        JasperCompileManager.compileReport(fileName);
                        Map param= new HashMap();
                        param.put("PerBulan", Respone);
                        JasperFillManager.fillReport(filetoFill, param, con);
                        JasperPrint jp=JasperFillManager.fillReport(filetoFill, param,con);
                        JasperViewer.viewReport(jp, false);                    
                    }
        }catch(Exception ex){
                           System.out.println(ex.toString());
                    }
    }
        else if (textPeriode_Kelompok03.getSelectedItem().equals("Per Tahun")){
        try{
            if (textInput_Kelompok03.getText().equals("")||textInput_Kelompok03.getText().equals("Contoh (2022)")) {
                JOptionPane.showMessageDialog(this, "Silahkan Inputkan Periode Terlebih Dahulu", "Pesan",
                          JOptionPane.WARNING_MESSAGE);
            }else {
                        String Respone = textInput_Kelompok03.getText();
                        Database objkoneksi = new Database();
                        Connection con =objkoneksi.configDB();
                        String fileName="src\\CetakLaporan\\LaporanMasterTransaksiTahun.jrxml";
                        String filetoFill="src\\CetakLaporan\\LaporanMasterTransaksiTahun.jasper";
                        JasperCompileManager.compileReport(fileName);
                        Map param= new HashMap();
                        param.put("PerTahun", Respone);
                        JasperFillManager.fillReport(filetoFill, param, con);
                        JasperPrint jp=JasperFillManager.fillReport(filetoFill, param,con);
                        JasperViewer.viewReport(jp, false);                    
                    }
        }catch(Exception ex){
                           System.out.println(ex.toString());
                    }
    }
    }//GEN-LAST:event_labelCetakLaporan_Kelompok03MouseClicked

    private void panelCetakLaporan_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCetakLaporan_Kelompok03MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_panelCetakLaporan_Kelompok03MouseMoved

    private void tabelBahanBaku_kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBahanBaku_kelompok03MouseClicked
        // TODO add your handling code here:
        int baris=tabelBahanBaku_kelompok03.rowAtPoint(evt.getPoint());
        String kodeBahan = tabelBahanBaku_kelompok03.getValueAt(baris,0).toString();
        textKdBahani_Kelompok03.setText(kodeBahan);
        String namaBahan = tabelBahanBaku_kelompok03.getValueAt(baris,1).toString();
        textNamaBahani_Kelompok03.setText(namaBahan);
        String tglMasuk = tabelBahanBaku_kelompok03.getValueAt(baris,2).toString();
        ((JTextField)dateTglMasuk_Kelompok03.getDateEditor().getUiComponent()).setText(tglMasuk);
        String satuanJumlah = tabelBahanBaku_kelompok03.getValueAt(baris,3).toString();
        textSatuanJumlahi_Kelompok03.setText(satuanJumlah);
        String jumlahStok = tabelBahanBaku_kelompok03.getValueAt(baris,4).toString();
        textJumlahStocki_Kelompok03.setText(jumlahStok);
        String hargaBahan = tabelBahanBaku_kelompok03.getValueAt(baris,5).toString();
        textHargaBahan_Kelompok03.setText(hargaBahan);
    }//GEN-LAST:event_tabelBahanBaku_kelompok03MouseClicked

    private void panelSetPeriodeData_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSetPeriodeData_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelSetPeriodeData_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        panelSetPeriodeData_Kelompok03.setBackground(new java.awt.Color(57,161,255));
    }//GEN-LAST:event_panelSetPeriodeData_Kelompok03MouseMoved

    private void labelSetPeriodeData_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSetPeriodeData_Kelompok03MouseClicked
        // TODO add your handling code here:
        panelSetPeriodeDataDetail_Kelompok03.setSize(330, 230);
        HapusTabel();
    }//GEN-LAST:event_labelSetPeriodeData_Kelompok03MouseClicked

    private void labelSetPeriodeData_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSetPeriodeData_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelSetPeriodeData_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        panelSetPeriodeData_Kelompok03.setBackground(new java.awt.Color(57,161,255));
    }//GEN-LAST:event_labelSetPeriodeData_Kelompok03MouseMoved

    private void panelSetPeriodeDataDetail_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSetPeriodeDataDetail_Kelompok03MouseMoved
        // TODO add your handling code here:
        panelSet_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_panelSetPeriodeDataDetail_Kelompok03MouseMoved

    private void dateTglMasuk_Kelompok03PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateTglMasuk_Kelompok03PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_dateTglMasuk_Kelompok03PropertyChange

    private void dateTglMasuk_Kelompok03VetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_dateTglMasuk_Kelompok03VetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_dateTglMasuk_Kelompok03VetoableChange

    private void labelSimpanPerubahanl_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSimpanPerubahanl_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelSimpanPerubahanl_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        panelSimpanPerubahanl_Kelompok03.setBackground(new java.awt.Color(57,161,255));
    }//GEN-LAST:event_labelSimpanPerubahanl_Kelompok03MouseMoved

    private void labelSimpanPerubahanl_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSimpanPerubahanl_Kelompok03MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_labelSimpanPerubahanl_Kelompok03MouseClicked

    private void panelSimpanPerubahanl_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSimpanPerubahanl_Kelompok03MouseMoved
        // TODO add your handling code here:
        panelSimpanPerubahanl_Kelompok03.setBackground(new java.awt.Color(57,161,255));
        labelSimpanPerubahanl_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
    }//GEN-LAST:event_panelSimpanPerubahanl_Kelompok03MouseMoved

    private void labelKembali_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelKembali_Kelompok03MouseMoved
        // TODO add your handling code here:
        panelKembali_Kelompok03.setBackground(new java.awt.Color(57,161,255));
    }//GEN-LAST:event_labelKembali_Kelompok03MouseMoved

    private void labelKembali_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelKembali_Kelompok03MouseClicked
        // TODO add your handling code here:
        panelDetailBahanBaku_Kelompok03.setSize(530, 0);
    }//GEN-LAST:event_labelKembali_Kelompok03MouseClicked

    private void panelKembali_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelKembali_Kelompok03MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_panelKembali_Kelompok03MouseMoved

    private void GmbrDetail_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GmbrDetail_Kelompok03MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_GmbrDetail_Kelompok03MouseMoved

    private void panelGmbrDetail_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelGmbrDetail_Kelompok03MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_panelGmbrDetail_Kelompok03MouseMoved

    private void labelKet2_Kelompok4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelKet2_Kelompok4MouseMoved
        // TODO add your handling code here:
        panelSimpanPerubahanl_Kelompok03.setBackground(new java.awt.Color(21, 0, 53));
        labelSimpanPerubahanl_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        panelKembali_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_labelKet2_Kelompok4MouseMoved

    private void panelDetailBahanBaku_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelDetailBahanBaku_Kelompok03MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_panelDetailBahanBaku_Kelompok03MouseMoved

    private void labelSet_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSet_Kelompok03MouseMoved
        // TODO add your handling code here:
        panelSet_Kelompok03.setBackground(new java.awt.Color(57,161,255));
    }//GEN-LAST:event_labelSet_Kelompok03MouseMoved

    private void labelSet_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSet_Kelompok03MouseClicked
        // TODO add your handling code here:
        if (textPeriodeSet_Kelompok03.getText().equals("Per Tanggal")) {
            TampilkanDataBahanPerTanggal();
        }
        else if (textPeriodeSet_Kelompok03.getText().equals("Per Bulan")) {
            TampilkanDataBahanPerBulan();
        } else{
            TampilkanDataBahanPerTahun();
        }
    }//GEN-LAST:event_labelSet_Kelompok03MouseClicked

    private void panelSet_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSet_Kelompok03MouseMoved
        // TODO add your handling code here:
        panelSet_Kelompok03.setBackground(new java.awt.Color(57,161,255));
    }//GEN-LAST:event_panelSet_Kelompok03MouseMoved

    private void textInput_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textInput_Kelompok03MouseClicked
        // TODO add your handling code here:
        textInput_Kelompok03.setText("");
    }//GEN-LAST:event_textInput_Kelompok03MouseClicked

    private void textPeriode_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textPeriode_Kelompok03MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_textPeriode_Kelompok03MouseClicked

    private void textPeriode_Kelompok03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPeriode_Kelompok03ActionPerformed
        // TODO add your handling code here:
        if (textPeriode_Kelompok03.getSelectedItem().equals("Per Tanggal")) {
            textInput_Kelompok03.setText("Contoh (31/12/2022)");
            textPeriodeSet_Kelompok03.setText("Per Tanggal");
            textInput_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 16));
            textInput_Kelompok03.setForeground(new java.awt.Color(255,0,0));
            }
        else if (textPeriode_Kelompok03.getSelectedItem().equals("Per Bulan")) {
            textInput_Kelompok03.setText("Contoh (Juli 2022)");
            textPeriodeSet_Kelompok03.setText("Per Bulan");
            textInput_Kelompok03.setForeground(new java.awt.Color(255,0,0));
        }
        else {
            textInput_Kelompok03.setText("Contoh (2022)");
            textPeriodeSet_Kelompok03.setText("Per Tahun");
            textInput_Kelompok03.setForeground(new java.awt.Color(255,0,0));
        }
    }//GEN-LAST:event_textPeriode_Kelompok03ActionPerformed

    private void textPeriode_Kelompok03PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_textPeriode_Kelompok03PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_textPeriode_Kelompok03PropertyChange

    private void labelHelp_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelHelp_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelHelp_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Help Putih.png")));
    }//GEN-LAST:event_labelHelp_Kelompok03MouseMoved

    private void labelHelp_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelHelp_Kelompok03MouseClicked
        // TODO add your handling code here:
        panelBantuan1_Kelompok03.setSize(270, 110);
        panelSetPeriodeDataDetail_Kelompok03.setSize(330, 0);
    }//GEN-LAST:event_labelHelp_Kelompok03MouseClicked

    private void labelBantuan1_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBantuan1_Kelompok03MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_labelBantuan1_Kelompok03MouseMoved

    private void labelBantuan1_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBantuan1_Kelompok03MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_labelBantuan1_Kelompok03MouseClicked

    private void labelOke1_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelOke1_Kelompok03MouseMoved
        // TODO add your handling code here:
        panelOke1_Kelompok03.setBackground(new java.awt.Color(255, 176, 0));
    }//GEN-LAST:event_labelOke1_Kelompok03MouseMoved

    private void labelOke1_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelOke1_Kelompok03MouseClicked
        // TODO add your handling code here:
        panelBantuan1_Kelompok03.setSize(420, 0);
        panelBantuan2_Kelompok03.setSize(420, 110);
        panelSetPeriodeDataDetail_Kelompok03.setSize(330, 230);
    }//GEN-LAST:event_labelOke1_Kelompok03MouseClicked

    private void panelOke1_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOke1_Kelompok03MouseMoved
        // TODO add your handling code here:
        panelOke1_Kelompok03.setBackground(new java.awt.Color(255, 176, 0));
    }//GEN-LAST:event_panelOke1_Kelompok03MouseMoved

    private void panelBantuan1_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBantuan1_Kelompok03MouseMoved
        // TODO add your handling code here:
        panelOke1_Kelompok03.setBackground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_panelBantuan1_Kelompok03MouseMoved

    private void labelBantuan1_Kelompok4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBantuan1_Kelompok4MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_labelBantuan1_Kelompok4MouseMoved

    private void labelBantuan1_Kelompok4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBantuan1_Kelompok4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_labelBantuan1_Kelompok4MouseClicked

    private void labelOke2_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelOke2_Kelompok03MouseMoved
        // TODO add your handling code here:
        panelOke2_Kelompok03.setBackground(new java.awt.Color(255, 176, 0));
    }//GEN-LAST:event_labelOke2_Kelompok03MouseMoved

    private void labelOke2_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelOke2_Kelompok03MouseClicked
        // TODO add your handling code here:
        panelBantuan2_Kelompok03.setSize(420, 0);
        panelBantuan3_Kelompok03.setSize(420, 110);
    }//GEN-LAST:event_labelOke2_Kelompok03MouseClicked

    private void panelOke2_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOke2_Kelompok03MouseMoved
        // TODO add your handling code here:
        panelOke2_Kelompok03.setBackground(new java.awt.Color(255, 176, 0));
    }//GEN-LAST:event_panelOke2_Kelompok03MouseMoved

    private void panelBantuan2_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBantuan2_Kelompok03MouseMoved
        // TODO add your handling code here:
        panelOke2_Kelompok03.setBackground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_panelBantuan2_Kelompok03MouseMoved

    private void labelBantuan1_Kelompok7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBantuan1_Kelompok7MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_labelBantuan1_Kelompok7MouseMoved

    private void labelBantuan1_Kelompok7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBantuan1_Kelompok7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_labelBantuan1_Kelompok7MouseClicked

    private void labelOke2_Kelompok6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelOke2_Kelompok6MouseMoved
        // TODO add your handling code here:
        panelOke2_Kelompok6.setBackground(new java.awt.Color(255, 176, 0));
    }//GEN-LAST:event_labelOke2_Kelompok6MouseMoved

    private void labelOke2_Kelompok6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelOke2_Kelompok6MouseClicked
        // TODO add your handling code here:
        panelBantuan5_Kelompok03.setSize(420, 0);
    }//GEN-LAST:event_labelOke2_Kelompok6MouseClicked

    private void panelOke2_Kelompok6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOke2_Kelompok6MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_panelOke2_Kelompok6MouseMoved

    private void panelBantuan5_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBantuan5_Kelompok03MouseMoved
        // TODO add your handling code here:
        panelOke2_Kelompok6.setBackground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_panelBantuan5_Kelompok03MouseMoved

    private void labelBantuan1_Kelompok5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBantuan1_Kelompok5MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_labelBantuan1_Kelompok5MouseMoved

    private void labelBantuan1_Kelompok5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBantuan1_Kelompok5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_labelBantuan1_Kelompok5MouseClicked

    private void labelOke2_Kelompok4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelOke2_Kelompok4MouseMoved
        // TODO add your handling code here:
        panelOke2_Kelompok4.setBackground(new java.awt.Color(255, 176, 0));
    }//GEN-LAST:event_labelOke2_Kelompok4MouseMoved

    private void labelOke2_Kelompok4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelOke2_Kelompok4MouseClicked
        // TODO add your handling code here:
        panelBantuan3_Kelompok03.setSize(420, 0);
        panelBantuan4_Kelompok03.setSize(420, 110);
    }//GEN-LAST:event_labelOke2_Kelompok4MouseClicked

    private void panelOke2_Kelompok4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOke2_Kelompok4MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_panelOke2_Kelompok4MouseMoved

    private void panelBantuan3_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBantuan3_Kelompok03MouseMoved
        // TODO add your handling code here:
        panelOke2_Kelompok4.setBackground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_panelBantuan3_Kelompok03MouseMoved

    private void labelBantuan1_Kelompok6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBantuan1_Kelompok6MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_labelBantuan1_Kelompok6MouseMoved

    private void labelBantuan1_Kelompok6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBantuan1_Kelompok6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_labelBantuan1_Kelompok6MouseClicked

    private void labelOke2_Kelompok5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelOke2_Kelompok5MouseMoved
        // TODO add your handling code here:
        panelOke2_Kelompok5.setBackground(new java.awt.Color(255, 176, 0));
        
    }//GEN-LAST:event_labelOke2_Kelompok5MouseMoved

    private void labelOke2_Kelompok5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelOke2_Kelompok5MouseClicked
        // TODO add your handling code here:
        panelBantuan4_Kelompok03.setSize(420, 0);
        panelSetPeriodeDataDetail_Kelompok03.setSize(330, 0);
        panelBantuan5_Kelompok03.setSize(420, 110);
    }//GEN-LAST:event_labelOke2_Kelompok5MouseClicked

    private void panelOke2_Kelompok5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOke2_Kelompok5MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_panelOke2_Kelompok5MouseMoved

    private void panelBantuan4_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBantuan4_Kelompok03MouseMoved
        // TODO add your handling code here:
        panelOke2_Kelompok5.setBackground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_panelBantuan4_Kelompok03MouseMoved

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
            java.util.logging.Logger.getLogger(FormTransaksiAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTransaksiAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTransaksiAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTransaksiAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FormTransaksiAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GmbrDetail_Kelompok03;
    private javax.swing.JLabel Rahasia;
    private com.toedter.calendar.JDateChooser dateTglMasuk_Kelompok03;
    private javax.swing.JScrollPane jScrollPane1_kelompok03;
    private javax.swing.JLabel labelBahanBaku_Kelompok03;
    private javax.swing.JLabel labelBantuan1_Kelompok03;
    private javax.swing.JLabel labelBantuan1_Kelompok4;
    private javax.swing.JLabel labelBantuan1_Kelompok5;
    private javax.swing.JLabel labelBantuan1_Kelompok6;
    private javax.swing.JLabel labelBantuan1_Kelompok7;
    private javax.swing.JLabel labelBarang_Kelompok03;
    private javax.swing.JLabel labelCartin_Kelompok03;
    private javax.swing.JLabel labelCetakLaporan_Kelompok03;
    private javax.swing.JLabel labelFood_Kelompok03;
    private javax.swing.JLabel labelGambar_Kelompok03;
    private javax.swing.JLabel labelGmbr_Kelompok03;
    private javax.swing.JLabel labelHargaBahan_Kelompok03;
    private javax.swing.JLabel labelHelp_Kelompok03;
    private javax.swing.JLabel labelHome_Kelompok03;
    private javax.swing.JLabel labelIconEmailOri_Kelompok03;
    private javax.swing.JLabel labelIconJumlahOri_Kelompok03;
    private javax.swing.JLabel labelIconKdBrgOri_Kelompok03;
    private javax.swing.JLabel labelIconNamaBrgOri_Kelompok03;
    private javax.swing.JLabel labelIconTotalOri_Kelompok03;
    private javax.swing.JLabel labelIconmRahasia_Kelompok03;
    private javax.swing.JLabel labelInput_Kelompok03;
    private javax.swing.JLabel labelJumlahStocki_Kelompok03;
    private javax.swing.JLabel labelKdBahani_Kelompok03;
    private javax.swing.JLabel labelKeluar_Kelompok03;
    private javax.swing.JLabel labelKembali_Kelompok03;
    private javax.swing.JLabel labelKet2_Kelompok4;
    private javax.swing.JLabel labelKetDetail_Kelompok03;
    private javax.swing.JLabel labelNamaBahani_Kelompok03;
    private javax.swing.JLabel labelOke1_Kelompok03;
    private javax.swing.JLabel labelOke2_Kelompok03;
    private javax.swing.JLabel labelOke2_Kelompok4;
    private javax.swing.JLabel labelOke2_Kelompok5;
    private javax.swing.JLabel labelOke2_Kelompok6;
    private javax.swing.JLabel labelPelanggan_Kelompok03;
    private javax.swing.JLabel labelPeriode_Kelompok03;
    private javax.swing.JLabel labelSatuanJumlahi_Kelompok03;
    private javax.swing.JLabel labelSetPeriodeData_Kelompok03;
    private javax.swing.JLabel labelSet_Kelompok03;
    private javax.swing.JLabel labelSimpanPerubahanl_Kelompok03;
    private javax.swing.JLabel labelTransaksi_Kelompok03;
    private javax.swing.JLabel labeltanggalMasukl_Kelompok03;
    private ClassForGUI.PanelRound paneInput_Kelompok03;
    private ClassForGUI.PanelRound panelBantuan1_Kelompok03;
    private ClassForGUI.PanelRound panelBantuan2_Kelompok03;
    private ClassForGUI.PanelRound panelBantuan3_Kelompok03;
    private ClassForGUI.PanelRound panelBantuan4_Kelompok03;
    private ClassForGUI.PanelRound panelBantuan5_Kelompok03;
    private ClassForGUI.PanelRound panelCetakLaporan_Kelompok03;
    private ClassForGUI.PanelRound panelDetailBahanBaku_Kelompok03;
    private ClassForGUI.PanelRound panelGaris_Kelompok03;
    private ClassForGUI.PanelRound panelGmbrDetail_Kelompok03;
    private ClassForGUI.PanelRound panelGmbr_Kelompok03;
    private ClassForGUI.PanelRound panelHargaBahan_Kelompok03;
    private ClassForGUI.PanelRound panelJumlahStocki_Kelompok03;
    private ClassForGUI.PanelRound panelKdBahani_Kelompok03;
    private ClassForGUI.PanelRound panelKembali_Kelompok03;
    private ClassForGUI.PanelRound panelNamaBahani_Kelompok03;
    private ClassForGUI.PanelRound panelOke1_Kelompok03;
    private ClassForGUI.PanelRound panelOke2_Kelompok03;
    private ClassForGUI.PanelRound panelOke2_Kelompok4;
    private ClassForGUI.PanelRound panelOke2_Kelompok5;
    private ClassForGUI.PanelRound panelOke2_Kelompok6;
    private ClassForGUI.PanelRound panelPeriode_Kelompok03;
    private ClassForGUI.PanelRound panelRahasia_Kelompok03;
    private ClassForGUI.PanelRound panelSatuanJumlahi_Kelompok03;
    private ClassForGUI.PanelRound panelSetPeriodeDataDetail_Kelompok03;
    private ClassForGUI.PanelRound panelSetPeriodeData_Kelompok03;
    private ClassForGUI.PanelRound panelSet_Kelompok03;
    private ClassForGUI.PanelRound panelSimpanPerubahanl_Kelompok03;
    private javax.swing.JPanel panel_Kelompok03;
    private ClassForGUI.PanelRound paneltanggalMasukl_Kelompok03;
    private ClassForGUI.TableDark tabelBahanBaku_kelompok03;
    private javax.swing.JTextField textHargaBahan_Kelompok03;
    private javax.swing.JTextField textInput_Kelompok03;
    private javax.swing.JTextField textJumlahStocki_Kelompok03;
    public static javax.swing.JTextField textKdBahani_Kelompok03;
    private javax.swing.JTextField textNamaBahani_Kelompok03;
    public static javax.swing.JTextField textPeriodeSet_Kelompok03;
    private ClassForGUI.ComboBoxSuggestion textPeriode_Kelompok03;
    public static javax.swing.JTextField textRahasia2_Kelompok03;
    public static javax.swing.JTextField textRahasia_Kelompok03;
    private javax.swing.JTextField textSatuanJumlahi_Kelompok03;
    public static javax.swing.JTextField textTotalPendapatan_Kelompok03;
    // End of variables declaration//GEN-END:variables
}
