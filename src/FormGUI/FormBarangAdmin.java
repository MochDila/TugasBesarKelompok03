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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Muhammad Dila
 */
public class FormBarangAdmin extends javax.swing.JFrame {

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
    
    private void TampilkanDataBahan(){
        DefaultTableModel model= new DefaultTableModel();
        model.addColumn("K. Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Tgl Masuk");
        model.addColumn("Stok Barang");
        model.addColumn("Harga Barang");
        try{
            String sql="SELECT * FROM t_master_barang";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4)
                ,res.getString(5)});
            }
            
            tabelBahanBaku_kelompok03.setModel(model);
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public FormBarangAdmin() {
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
        panelRahasia_Kelompok03 = new ClassForGUI.PanelRound();
        Rahasia = new javax.swing.JLabel();
        labelIconmRahasia_Kelompok03 = new javax.swing.JLabel();
        textRahasia_Kelompok03 = new javax.swing.JTextField();
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
        panelSimpanPerubahanl_Kelompok03 = new ClassForGUI.PanelRound();
        labelSimpanPerubahanl_Kelompok03 = new javax.swing.JLabel();
        panelKembali_Kelompok03 = new ClassForGUI.PanelRound();
        labelKembali_Kelompok03 = new javax.swing.JLabel();
        panelGmbrDetail_Kelompok03 = new ClassForGUI.PanelRound();
        GmbrDetail_Kelompok03 = new javax.swing.JLabel();
        labelKetDetail_Kelompok03 = new javax.swing.JLabel();
        labelKet2_Kelompok4 = new javax.swing.JLabel();
        panelGmbr_Kelompok03 = new ClassForGUI.PanelRound();
        labelGmbr_Kelompok03 = new javax.swing.JLabel();
        jScrollPane1_kelompok03 = new javax.swing.JScrollPane();
        tabelBahanBaku_kelompok03 = new ClassForGUI.TableDark();
        panelTambahBakan_Kelompok03 = new ClassForGUI.PanelRound();
        labelTambahBakan_Kelompok03 = new javax.swing.JLabel();
        panelEditBahanBaku_Kelompok03 = new ClassForGUI.PanelRound();
        labelEditBahanBaku_Kelompok03 = new javax.swing.JLabel();
        panelCetakLaporan_Kelompok03 = new ClassForGUI.PanelRound();
        labelCetakLaporan_Kelompok03 = new javax.swing.JLabel();
        labelGambar_Kelompok03 = new javax.swing.JLabel();
        panelKdBahani_Kelompok03 = new ClassForGUI.PanelRound();
        labelKdBahani_Kelompok03 = new javax.swing.JLabel();
        labelIconKdBrgOri_Kelompok03 = new javax.swing.JLabel();
        textKdBahani_Kelompok03 = new javax.swing.JTextField();

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
        labelBahanBaku_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Barang Putih.png"))); // NOI18N
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
        labelBarang_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelBarang_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Barang.png"))); // NOI18N
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
        labelTransaksi_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelTransaksi_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Transaksi Putih.png"))); // NOI18N
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
        panelRahasia_Kelompok03.add(textRahasia_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 250, -1));

        panel_Kelompok03.add(panelRahasia_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 440, 280, 0));

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

        panelTambahBakan_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelTambahBakan_Kelompok03.setRoundBottomLeft(35);
        panelTambahBakan_Kelompok03.setRoundBottomRight(35);
        panelTambahBakan_Kelompok03.setRoundTopLeft(35);
        panelTambahBakan_Kelompok03.setRoundTopRight(35);
        panelTambahBakan_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelTambahBakan_Kelompok03MouseMoved(evt);
            }
        });
        panelTambahBakan_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTambahBakan_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelTambahBakan_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelTambahBakan_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTambahBakan_Kelompok03.setText("Tambah Barang Baru");
        labelTambahBakan_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelTambahBakan_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelTambahBakan_Kelompok03MouseMoved(evt);
            }
        });
        labelTambahBakan_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelTambahBakan_Kelompok03MouseClicked(evt);
            }
        });
        panelTambahBakan_Kelompok03.add(labelTambahBakan_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 310, 30));

        panel_Kelompok03.add(panelTambahBakan_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 540, 330, 60));

        panelEditBahanBaku_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelEditBahanBaku_Kelompok03.setRoundBottomLeft(35);
        panelEditBahanBaku_Kelompok03.setRoundBottomRight(35);
        panelEditBahanBaku_Kelompok03.setRoundTopLeft(35);
        panelEditBahanBaku_Kelompok03.setRoundTopRight(35);
        panelEditBahanBaku_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelEditBahanBaku_Kelompok03MouseMoved(evt);
            }
        });
        panelEditBahanBaku_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelEditBahanBaku_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelEditBahanBaku_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelEditBahanBaku_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEditBahanBaku_Kelompok03.setText("Edit Barang");
        labelEditBahanBaku_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelEditBahanBaku_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelEditBahanBaku_Kelompok03MouseMoved(evt);
            }
        });
        labelEditBahanBaku_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelEditBahanBaku_Kelompok03MouseClicked(evt);
            }
        });
        panelEditBahanBaku_Kelompok03.add(labelEditBahanBaku_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 310, 30));

        panel_Kelompok03.add(panelEditBahanBaku_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 460, 330, 60));

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
        labelCetakLaporan_Kelompok03.setText("Cetak Laporan Barang");
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

        panel_Kelompok03.add(panelCetakLaporan_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 620, 330, 60));

        labelGambar_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelGambar_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Artboard Admin.png"))); // NOI18N
        labelGambar_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelGambar_Kelompok03MouseMoved(evt);
            }
        });
        panel_Kelompok03.add(labelGambar_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 1270, 710));

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

        panel_Kelompok03.add(panelKdBahani_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 280, 60));

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
        labelBarang_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Barang Putih.png")));
        labelBarang_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_labelBarang_Kelompok03MouseMoved

    private void labelPelanggan_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPelanggan_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelPelanggan_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Pelanggan Home.png")));
        labelPelanggan_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
    }//GEN-LAST:event_labelPelanggan_Kelompok03MouseMoved

    private void labelTransaksi_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTransaksi_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelTransaksi_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Transaksi.png")));
        labelTransaksi_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
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
        labelBarang_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Barang.png")));
        labelBarang_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelPelanggan_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Pelanggan Home Putih.png")));
        labelPelanggan_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelTransaksi_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Transaksi Putih.png")));
        labelTransaksi_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelKeluar_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keluar Putih.png")));
        labelKeluar_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        panelCetakLaporan_Kelompok03.setBackground(new java.awt.Color(21, 0, 53));
        labelCetakLaporan_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        panelEditBahanBaku_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelTambahBakan_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_labelGambar_Kelompok03MouseMoved

    private void labelEditBahanBaku_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEditBahanBaku_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelEditBahanBaku_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        panelEditBahanBaku_Kelompok03.setBackground(new java.awt.Color(57,161,255));
    }//GEN-LAST:event_labelEditBahanBaku_Kelompok03MouseMoved

    private void labelEditBahanBaku_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEditBahanBaku_Kelompok03MouseClicked
        // TODO add your handling code here:
        if(textKdBahani_Kelompok03.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Bahan Yang Ada Di Tabel", "Pesan", JOptionPane.ERROR_MESSAGE);
        }else {
            FormBarangAdminDetail s = new FormBarangAdminDetail();
            s.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_labelEditBahanBaku_Kelompok03MouseClicked

    private void panelEditBahanBaku_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelEditBahanBaku_Kelompok03MouseMoved
        // TODO add your handling code here:
        panelEditBahanBaku_Kelompok03.setBackground(new java.awt.Color(57,161,255));
        labelEditBahanBaku_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
    }//GEN-LAST:event_panelEditBahanBaku_Kelompok03MouseMoved

    private void labelTambahBakan_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTambahBakan_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelTambahBakan_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        panelTambahBakan_Kelompok03.setBackground(new java.awt.Color(57,161,255));
    }//GEN-LAST:event_labelTambahBakan_Kelompok03MouseMoved

    private void labelTambahBakan_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTambahBakan_Kelompok03MouseClicked
        // TODO add your handling code here:
        textKdBahani_Kelompok03.setText("");
        textRahasia_Kelompok03.setText("");
        FormBarangAdminDetail s = new FormBarangAdminDetail();
            s.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_labelTambahBakan_Kelompok03MouseClicked

    private void panelTambahBakan_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelTambahBakan_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelTambahBakan_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        panelTambahBakan_Kelompok03.setBackground(new java.awt.Color(57,161,255));
    }//GEN-LAST:event_panelTambahBakan_Kelompok03MouseMoved

    private void labelCetakLaporan_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCetakLaporan_Kelompok03MouseMoved
        // TODO add your handling code here:
        panelCetakLaporan_Kelompok03.setBackground(new java.awt.Color(57,161,255));
        labelCetakLaporan_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
    }//GEN-LAST:event_labelCetakLaporan_Kelompok03MouseMoved

    private void labelCetakLaporan_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCetakLaporan_Kelompok03MouseClicked
        // TODO add your handling code here:
        try{
                        Database objkoneksi = new Database();
                        Connection con =objkoneksi.configDB();
                        String fileName="src\\CetakLaporan\\LaporanMasterBarang.jrxml";
                        String filetoFill="src\\CetakLaporan\\LaporanMasterBarang.jasper";
                        JasperCompileManager.compileReport(fileName);
                        Map param= new HashMap();
                        JasperFillManager.fillReport(filetoFill, param, con);
                        JasperPrint jp=JasperFillManager.fillReport(filetoFill, param,con);
                        JasperViewer.viewReport(jp,false);
                        
//                        JasperReport jasperReport = JasperCompileManager.compileReport("C:\\Users\\Muhammad Dila\\Documents\\NetBeansProjects\\"
//                                        + "TugasBesarKelompok03\\src\\CetakLaporan\\LaporanMasterBahanBaku.jrxml");
//                        JRDataSource jRDataSource = new JREmptyDataSource();
//                        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jRDataSource);
//                        JasperExportManager.exportReportToPdfFile(jasperPrint, 
//                                          "C:\\Users\\Muhammad Dila\\Documents\\NetBeansProjects\\"
//                                        + "TugasBesarKelompok03\\src\\CetakLaporan\\LaporanMasterBahanBaku.pdf");

//                        JasperReport jasperReport = JasperCompileManager.compileReport("C:\\Users\\Muhammad Dila\\Documents\\NetBeansProjects\\"
//                                        + "TugasBesarKelompok03\\src\\CetakLaporan\\LaporanMasterBahanBaku.jrxml");
//                        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,"C:\\Users\\Muhammad Dila\\Documents\\NetBeansProjects\\"
//                                        + "TugasBesarKelompok03\\src\\CetakLaporan\\LaporanMasterBahanBaku.jasper",new  JREmptyDataSource()); 
//                        JasperExportManager.exportReportToPdfFile(jasperPrint, "D://Test.pdf");
                        
                    }catch(Exception ex){
                           System.out.println(ex.toString());
                    }
        TampilkanDataBahan();
    }//GEN-LAST:event_labelCetakLaporan_Kelompok03MouseClicked

    private void panelCetakLaporan_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCetakLaporan_Kelompok03MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_panelCetakLaporan_Kelompok03MouseMoved

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

    private void panelDetailBahanBaku_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelDetailBahanBaku_Kelompok03MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_panelDetailBahanBaku_Kelompok03MouseMoved

    private void labelKet2_Kelompok4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelKet2_Kelompok4MouseMoved
        // TODO add your handling code here:
        panelSimpanPerubahanl_Kelompok03.setBackground(new java.awt.Color(21, 0, 53));
        labelSimpanPerubahanl_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        panelKembali_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_labelKet2_Kelompok4MouseMoved

    private void tabelBahanBaku_kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBahanBaku_kelompok03MouseClicked
        // TODO add your handling code here:
        int baris=tabelBahanBaku_kelompok03.rowAtPoint(evt.getPoint());
        String kodeBahan = tabelBahanBaku_kelompok03.getValueAt(baris,0).toString();
        textKdBahani_Kelompok03.setText(kodeBahan);
        String namaBahan = tabelBahanBaku_kelompok03.getValueAt(baris,1).toString();
        textNamaBahani_Kelompok03.setText(namaBahan);
        String tglMasuk = tabelBahanBaku_kelompok03.getValueAt(baris,2).toString();
        ((JTextField)dateTglMasuk_Kelompok03.getDateEditor().getUiComponent()).setText(tglMasuk);
        String jumlahStok = tabelBahanBaku_kelompok03.getValueAt(baris,3).toString();
        textJumlahStocki_Kelompok03.setText(jumlahStok);
        String hargaBahan = tabelBahanBaku_kelompok03.getValueAt(baris,4).toString();
        textHargaBahan_Kelompok03.setText(hargaBahan);
        if (textKdBahani_Kelompok03.getText().equals("KBRCF03")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Baso Tahu Menu.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF01")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Food Original.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF02")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Food Medium.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF04")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Food Special.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF06")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Air Meneral.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF05")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Air Mineral 330 ml Keranjang.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF07")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Air Mineral 660 ml Keranjang.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF08")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Jus Botol Lemon.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF09")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keranjang Jus Alpukat.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF10")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keranjang Jus Strauberi.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF11")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keranjang Coca Cola.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF12")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keranjang Sprite.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF13")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keranjang Fanta.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF14")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keranjang Kopi Ori.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF15")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keranjang Capucino.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF16")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keranjang Misto.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF17")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Catering.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF18")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Catering Medium.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF19")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Catering Besar.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF20")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Frozen.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF21")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Frozen Siomay.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF22")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Frozen Dimsum.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF93")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Eceran Tahu.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF94")){
          labelGmbr_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Eceran.png")));
      }
    }//GEN-LAST:event_tabelBahanBaku_kelompok03MouseClicked

    private void dateTglMasuk_Kelompok03PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateTglMasuk_Kelompok03PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_dateTglMasuk_Kelompok03PropertyChange

    private void dateTglMasuk_Kelompok03VetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_dateTglMasuk_Kelompok03VetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_dateTglMasuk_Kelompok03VetoableChange

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
            java.util.logging.Logger.getLogger(FormBarangAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBarangAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBarangAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBarangAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormBarangAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GmbrDetail_Kelompok03;
    private javax.swing.JLabel Rahasia;
    private com.toedter.calendar.JDateChooser dateTglMasuk_Kelompok03;
    private javax.swing.JScrollPane jScrollPane1_kelompok03;
    private javax.swing.JLabel labelBahanBaku_Kelompok03;
    private javax.swing.JLabel labelBarang_Kelompok03;
    private javax.swing.JLabel labelCartin_Kelompok03;
    private javax.swing.JLabel labelCetakLaporan_Kelompok03;
    private javax.swing.JLabel labelEditBahanBaku_Kelompok03;
    private javax.swing.JLabel labelFood_Kelompok03;
    private javax.swing.JLabel labelGambar_Kelompok03;
    private javax.swing.JLabel labelGmbr_Kelompok03;
    private javax.swing.JLabel labelHargaBahan_Kelompok03;
    private javax.swing.JLabel labelHome_Kelompok03;
    private javax.swing.JLabel labelIconEmailOri_Kelompok03;
    private javax.swing.JLabel labelIconJumlahOri_Kelompok03;
    private javax.swing.JLabel labelIconKdBrgOri_Kelompok03;
    private javax.swing.JLabel labelIconNamaBrgOri_Kelompok03;
    private javax.swing.JLabel labelIconTotalOri_Kelompok03;
    private javax.swing.JLabel labelIconmRahasia_Kelompok03;
    private javax.swing.JLabel labelJumlahStocki_Kelompok03;
    private javax.swing.JLabel labelKdBahani_Kelompok03;
    private javax.swing.JLabel labelKeluar_Kelompok03;
    private javax.swing.JLabel labelKembali_Kelompok03;
    private javax.swing.JLabel labelKet2_Kelompok4;
    private javax.swing.JLabel labelKetDetail_Kelompok03;
    private javax.swing.JLabel labelNamaBahani_Kelompok03;
    private javax.swing.JLabel labelPelanggan_Kelompok03;
    private javax.swing.JLabel labelSatuanJumlahi_Kelompok03;
    private javax.swing.JLabel labelSimpanPerubahanl_Kelompok03;
    private javax.swing.JLabel labelTambahBakan_Kelompok03;
    private javax.swing.JLabel labelTransaksi_Kelompok03;
    private javax.swing.JLabel labeltanggalMasukl_Kelompok03;
    private ClassForGUI.PanelRound panelCetakLaporan_Kelompok03;
    private ClassForGUI.PanelRound panelDetailBahanBaku_Kelompok03;
    private ClassForGUI.PanelRound panelEditBahanBaku_Kelompok03;
    private ClassForGUI.PanelRound panelGaris_Kelompok03;
    private ClassForGUI.PanelRound panelGmbrDetail_Kelompok03;
    private ClassForGUI.PanelRound panelGmbr_Kelompok03;
    private ClassForGUI.PanelRound panelHargaBahan_Kelompok03;
    private ClassForGUI.PanelRound panelJumlahStocki_Kelompok03;
    private ClassForGUI.PanelRound panelKdBahani_Kelompok03;
    private ClassForGUI.PanelRound panelKembali_Kelompok03;
    private ClassForGUI.PanelRound panelNamaBahani_Kelompok03;
    private ClassForGUI.PanelRound panelRahasia_Kelompok03;
    private ClassForGUI.PanelRound panelSatuanJumlahi_Kelompok03;
    private ClassForGUI.PanelRound panelSimpanPerubahanl_Kelompok03;
    private ClassForGUI.PanelRound panelTambahBakan_Kelompok03;
    private javax.swing.JPanel panel_Kelompok03;
    private ClassForGUI.PanelRound paneltanggalMasukl_Kelompok03;
    private ClassForGUI.TableDark tabelBahanBaku_kelompok03;
    private javax.swing.JTextField textHargaBahan_Kelompok03;
    private javax.swing.JTextField textJumlahStocki_Kelompok03;
    public static javax.swing.JTextField textKdBahani_Kelompok03;
    private javax.swing.JTextField textNamaBahani_Kelompok03;
    public static javax.swing.JTextField textRahasia_Kelompok03;
    private javax.swing.JTextField textSatuanJumlahi_Kelompok03;
    // End of variables declaration//GEN-END:variables
}
