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
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Muhammad Dila
 */
public class FormPelanggaAdminDetail extends javax.swing.JFrame {

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
    
    private void kodeLaporanOtomatis(){
        if(textKd_Kelompok03.getText().equals("")){
            try {
            setKoneksi();
            String sql="select right (kode_pelanggan,2)+1 from t_akun_profile_pelanggan";
            ResultSet rs=st.executeQuery(sql);
              
            if(rs.next()){
                rs.last();
                String no=rs.getString(1);
                while (no.length()<3){
                    no="0"+no;
                    textKd_Kelompok03.setText("KP"+no);}
                }
            else 
            {
                textKd_Kelompok03.setText("KP001"); 
            }
            } catch (Exception e) 
            {
        }
        }
    }
    
    private void TampilkanDataPelanggan(){ 
        try{
            String sql="SELECT * FROM t_akun_profile_pelanggan WHERE kode_pelanggan ='"+textKd_Kelompok03.getText()+"'";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                String namaLengkap = res.getString("nama_lengkap");
                String alamt = res.getString("alamat");
                String noTlp = res.getString("no_telepon");
                String email = res.getString("email");
                String PW = res.getString("password");
                textNamaLengkap_Kelompok03.setText(namaLengkap);     
                textAlamat_Kelompok03.setText(alamt);
                textTeleponi_Kelompok03.setText(noTlp);
                textEmail_Kelompok03.setText(email);
                textPW_Kelompok03.setText(PW);
                }
            
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public void HapusField(){
        textEmail_Kelompok03.setText("");
        textTeleponi_Kelompok03.setText("");
        textKd_Kelompok03.setText("");
        textNamaLengkap_Kelompok03.setText("");
        textAlamat_Kelompok03.setText("");
    }
    
    public void HidePanel(){
        if(textRahasia_Kelompok03.getText().equals("")){
            panelSimpanPerubahanl_Kelompok03.setSize(0, 0);
        }else {
            panelSimpanData_Kelompok03.setSize(0, 0);
        }
    }
    
    public FormPelanggaAdminDetail() {
        initComponents();
        getContentPane().setBackground(new Color(255,255,255));
        textKd_Kelompok03.setText(FormPelangganAdmin.textKdBahani_Kelompok03.getText());
        textRahasia_Kelompok03.setText(FormPelangganAdmin.textRahasia_Kelompok03.getText());
        TampilkanDataPelanggan();
        kodeLaporanOtomatis();
        HidePanel();
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
        panelDetailBahanBaku_Kelompok03 = new ClassForGUI.PanelRound();
        panelRahasia_Kelompok03 = new ClassForGUI.PanelRound();
        Rahasia = new javax.swing.JLabel();
        labelIconmRahasia_Kelompok03 = new javax.swing.JLabel();
        textRahasia_Kelompok03 = new javax.swing.JTextField();
        panelNamaLengkap_Kelompok03 = new ClassForGUI.PanelRound();
        labelNamaLengkap_Kelompok03 = new javax.swing.JLabel();
        labelIconNamaBrgOri_Kelompok03 = new javax.swing.JLabel();
        textNamaLengkap_Kelompok03 = new javax.swing.JTextField();
        panelTeleponi_Kelompok03 = new ClassForGUI.PanelRound();
        labelTelepon_Kelompok03 = new javax.swing.JLabel();
        labelIconTotalOri_Kelompok03 = new javax.swing.JLabel();
        textTeleponi_Kelompok03 = new javax.swing.JTextField();
        panelEmail_Kelompok03 = new ClassForGUI.PanelRound();
        labelIconJumlahOri_Kelompok03 = new javax.swing.JLabel();
        textEmail_Kelompok03 = new javax.swing.JTextField();
        labelEmail_Kelompok03 = new javax.swing.JLabel();
        panelAlamat_Kelompok03 = new ClassForGUI.PanelRound();
        labelAlamat_Kelompok03 = new javax.swing.JLabel();
        labelIconEmailOri_Kelompok03 = new javax.swing.JLabel();
        textAlamat_Kelompok03 = new javax.swing.JTextField();
        panelPW_Kelompok03 = new ClassForGUI.PanelRound();
        labelPW_Kelompok03 = new javax.swing.JLabel();
        labelIconTotalOri_Kelompok4 = new javax.swing.JLabel();
        textPW_Kelompok03 = new javax.swing.JTextField();
        panelKd_Kelompok03 = new ClassForGUI.PanelRound();
        labelKd_Kelompok03 = new javax.swing.JLabel();
        labelIconKdBrgOri_Kelompok03 = new javax.swing.JLabel();
        textKd_Kelompok03 = new javax.swing.JTextField();
        panelSimpanData_Kelompok03 = new ClassForGUI.PanelRound();
        labelSimpanData_Kelompok03 = new javax.swing.JLabel();
        panelSimpanPerubahanl_Kelompok03 = new ClassForGUI.PanelRound();
        labelSimpanPerubahanl_Kelompok03 = new javax.swing.JLabel();
        panelKembali_Kelompok03 = new ClassForGUI.PanelRound();
        labelKembali_Kelompok03 = new javax.swing.JLabel();
        panelGmbrDetail_Kelompok03 = new ClassForGUI.PanelRound();
        GmbrDetail_Kelompok03 = new javax.swing.JLabel();
        labelKetDetail_Kelompok03 = new javax.swing.JLabel();
        labelKet2_Kelompok4 = new javax.swing.JLabel();
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
        labelPelanggan_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelPelanggan_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Pelanggan Home.png"))); // NOI18N
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
        textRahasia_Kelompok03.setBorder(null);
        textRahasia_Kelompok03.setOpaque(false);
        panelRahasia_Kelompok03.add(textRahasia_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 250, -1));

        panelDetailBahanBaku_Kelompok03.add(panelRahasia_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 440, 280, 0));

        panelNamaLengkap_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelNamaLengkap_Kelompok03.setRoundBottomLeft(25);
        panelNamaLengkap_Kelompok03.setRoundBottomRight(25);
        panelNamaLengkap_Kelompok03.setRoundTopLeft(25);
        panelNamaLengkap_Kelompok03.setRoundTopRight(25);
        panelNamaLengkap_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNamaLengkap_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelNamaLengkap_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelNamaLengkap_Kelompok03.setText("Nama Lengkap");
        panelNamaLengkap_Kelompok03.add(labelNamaLengkap_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        labelIconNamaBrgOri_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconNamaBrgOri_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelIconNamaBrgOri_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconNamaBrgOri_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Nama.png"))); // NOI18N
        panelNamaLengkap_Kelompok03.add(labelIconNamaBrgOri_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 40, 40));

        textNamaLengkap_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textNamaLengkap_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textNamaLengkap_Kelompok03.setBorder(null);
        textNamaLengkap_Kelompok03.setOpaque(false);
        panelNamaLengkap_Kelompok03.add(textNamaLengkap_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 520, -1));

        panelDetailBahanBaku_Kelompok03.add(panelNamaLengkap_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, 580, 60));

        panelTeleponi_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelTeleponi_Kelompok03.setRoundBottomLeft(25);
        panelTeleponi_Kelompok03.setRoundBottomRight(25);
        panelTeleponi_Kelompok03.setRoundTopLeft(25);
        panelTeleponi_Kelompok03.setRoundTopRight(25);
        panelTeleponi_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTelepon_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelTelepon_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelTelepon_Kelompok03.setText("No Telepon");
        panelTeleponi_Kelompok03.add(labelTelepon_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        labelIconTotalOri_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconTotalOri_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelIconTotalOri_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconTotalOri_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon No Telepon.png"))); // NOI18N
        panelTeleponi_Kelompok03.add(labelIconTotalOri_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 40, 40));

        textTeleponi_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textTeleponi_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textTeleponi_Kelompok03.setBorder(null);
        textTeleponi_Kelompok03.setOpaque(false);
        panelTeleponi_Kelompok03.add(textTeleponi_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 250, -1));

        panelDetailBahanBaku_Kelompok03.add(panelTeleponi_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 90, 280, 60));

        panelEmail_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelEmail_Kelompok03.setRoundBottomLeft(25);
        panelEmail_Kelompok03.setRoundBottomRight(25);
        panelEmail_Kelompok03.setRoundTopLeft(25);
        panelEmail_Kelompok03.setRoundTopRight(25);
        panelEmail_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelIconJumlahOri_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconJumlahOri_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelIconJumlahOri_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconJumlahOri_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Email.png"))); // NOI18N
        panelEmail_Kelompok03.add(labelIconJumlahOri_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 40, 40));

        textEmail_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textEmail_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textEmail_Kelompok03.setBorder(null);
        textEmail_Kelompok03.setOpaque(false);
        panelEmail_Kelompok03.add(textEmail_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 550, -1));

        labelEmail_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelEmail_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelEmail_Kelompok03.setText("Email Pelanggan");
        panelEmail_Kelompok03.add(labelEmail_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        panelDetailBahanBaku_Kelompok03.add(panelEmail_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 360, 580, 60));

        panelAlamat_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelAlamat_Kelompok03.setRoundBottomLeft(25);
        panelAlamat_Kelompok03.setRoundBottomRight(25);
        panelAlamat_Kelompok03.setRoundTopLeft(25);
        panelAlamat_Kelompok03.setRoundTopRight(25);
        panelAlamat_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelAlamat_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelAlamat_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelAlamat_Kelompok03.setText("Alamat Pelanggan");
        panelAlamat_Kelompok03.add(labelAlamat_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        labelIconEmailOri_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconEmailOri_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelIconEmailOri_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconEmailOri_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Alamat.png"))); // NOI18N
        panelAlamat_Kelompok03.add(labelIconEmailOri_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 40, 40));

        textAlamat_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textAlamat_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textAlamat_Kelompok03.setBorder(null);
        textAlamat_Kelompok03.setOpaque(false);
        panelAlamat_Kelompok03.add(textAlamat_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 520, -1));

        panelDetailBahanBaku_Kelompok03.add(panelAlamat_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 580, 60));

        panelPW_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelPW_Kelompok03.setRoundBottomLeft(25);
        panelPW_Kelompok03.setRoundBottomRight(25);
        panelPW_Kelompok03.setRoundTopLeft(25);
        panelPW_Kelompok03.setRoundTopRight(25);
        panelPW_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelPW_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelPW_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelPW_Kelompok03.setText("Password");
        panelPW_Kelompok03.add(labelPW_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        labelIconTotalOri_Kelompok4.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconTotalOri_Kelompok4.setForeground(new java.awt.Color(21, 0, 53));
        labelIconTotalOri_Kelompok4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconTotalOri_Kelompok4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Password.png"))); // NOI18N
        panelPW_Kelompok03.add(labelIconTotalOri_Kelompok4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 40, 40));

        textPW_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textPW_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textPW_Kelompok03.setBorder(null);
        textPW_Kelompok03.setOpaque(false);
        panelPW_Kelompok03.add(textPW_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 550, -1));

        panelDetailBahanBaku_Kelompok03.add(panelPW_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, 580, 60));

        panelKd_Kelompok03.setBackground(new java.awt.Color(222, 225, 229));
        panelKd_Kelompok03.setRoundBottomLeft(25);
        panelKd_Kelompok03.setRoundBottomRight(25);
        panelKd_Kelompok03.setRoundTopLeft(25);
        panelKd_Kelompok03.setRoundTopRight(25);
        panelKd_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelKd_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelKd_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelKd_Kelompok03.setText("Kode Pelanggan");
        panelKd_Kelompok03.add(labelKd_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        labelIconKdBrgOri_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconKdBrgOri_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelIconKdBrgOri_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconKdBrgOri_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Kode Barang.png"))); // NOI18N
        panelKd_Kelompok03.add(labelIconKdBrgOri_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 40, 40));

        textKd_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textKd_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textKd_Kelompok03.setBorder(null);
        textKd_Kelompok03.setEnabled(false);
        textKd_Kelompok03.setOpaque(false);
        panelKd_Kelompok03.add(textKd_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 250, -1));

        panelDetailBahanBaku_Kelompok03.add(panelKd_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 280, 60));

        panelSimpanData_Kelompok03.setBackground(new java.awt.Color(21, 0, 53));
        panelSimpanData_Kelompok03.setRoundBottomLeft(35);
        panelSimpanData_Kelompok03.setRoundBottomRight(35);
        panelSimpanData_Kelompok03.setRoundTopLeft(35);
        panelSimpanData_Kelompok03.setRoundTopRight(35);
        panelSimpanData_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelSimpanData_Kelompok03MouseMoved(evt);
            }
        });
        panelSimpanData_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelSimpanData_Kelompok03MouseClicked(evt);
            }
        });
        panelSimpanData_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelSimpanData_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelSimpanData_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelSimpanData_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSimpanData_Kelompok03.setText("Simpan Data");
        labelSimpanData_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelSimpanData_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelSimpanData_Kelompok03MouseMoved(evt);
            }
        });
        labelSimpanData_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSimpanData_Kelompok03MouseClicked(evt);
            }
        });
        panelSimpanData_Kelompok03.add(labelSimpanData_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 560, 30));

        panelDetailBahanBaku_Kelompok03.add(panelSimpanData_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 535, 580, 60));

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

        panelDetailBahanBaku_Kelompok03.add(panelSimpanPerubahanl_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 535, 580, 60));

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
        GmbrDetail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Logo Polos Besar.png"))); // NOI18N
        GmbrDetail_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                GmbrDetail_Kelompok03MouseMoved(evt);
            }
        });
        panelGmbrDetail_Kelompok03.add(GmbrDetail_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 550, 470));

        panelDetailBahanBaku_Kelompok03.add(panelGmbrDetail_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 530, 450));

        labelKetDetail_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelKetDetail_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelKetDetail_Kelompok03.setText("Detail Pelanggan");
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

        panel_Kelompok03.add(panelDetailBahanBaku_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1280, 640));

        labelGambar_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelGambar_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Artboard Admin.png"))); // NOI18N
        labelGambar_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelGambar_Kelompok03MouseMoved(evt);
            }
        });
        panel_Kelompok03.add(labelGambar_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 1270, 710));

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
        labelPelanggan_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Pelanggan Home Putih.png")));
        labelPelanggan_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
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
        labelBarang_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Barang Putih.png")));
        labelBarang_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelPelanggan_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Pelanggan Home.png")));
        labelPelanggan_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelTransaksi_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Transaksi Putih.png")));
        labelTransaksi_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelKeluar_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keluar Putih.png")));
        labelKeluar_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_labelGambar_Kelompok03MouseMoved

    private void labelSimpanPerubahanl_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSimpanPerubahanl_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelSimpanPerubahanl_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        panelSimpanPerubahanl_Kelompok03.setBackground(new java.awt.Color(57,161,255));
    }//GEN-LAST:event_labelSimpanPerubahanl_Kelompok03MouseMoved

    private void labelSimpanPerubahanl_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSimpanPerubahanl_Kelompok03MouseClicked
        // TODO add your handling code here:
        try{
          String sql= "UPDATE t_akun_profile_pelanggan SET nama_lengkap ='"+textNamaLengkap_Kelompok03.getText()
                  +"',alamat='"+textAlamat_Kelompok03.getText()+"',no_telepon='"+textTeleponi_Kelompok03.getText()
                  +"',email='"+textEmail_Kelompok03.getText()+"',password='"+textPW_Kelompok03.getText()+"' WHERE kode_pelanggan='"+textKd_Kelompok03.getText()+"'";
          
          java.sql.Connection conn=(Connection)Database.configDB();
          java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
          pstm.execute();
          JOptionPane.showMessageDialog(null, "Proses Perubahan Data Berhasil.");
      }catch(HeadlessException | SQLException e){
          JOptionPane.showMessageDialog(this, "Simpan Perubahan Gagal", "Pesan",
          JOptionPane.WARNING_MESSAGE);
      }
        TampilkanDataPelanggan();
        FormPelangganAdmin s = new FormPelangganAdmin();
        s.setVisible(true);
        this.dispose();
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
        FormPelangganAdmin s = new FormPelangganAdmin();
        s.setVisible(true);
        this.dispose();
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
        panelSimpanData_Kelompok03.setBackground(new java.awt.Color(21, 0, 53));
        labelSimpanData_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        panelKembali_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        HidePanel();
    }//GEN-LAST:event_labelKet2_Kelompok4MouseMoved

    private void panelDetailBahanBaku_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelDetailBahanBaku_Kelompok03MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_panelDetailBahanBaku_Kelompok03MouseMoved

    private void labelSimpanData_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSimpanData_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelSimpanData_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        panelSimpanData_Kelompok03.setBackground(new java.awt.Color(57,161,255));
    }//GEN-LAST:event_labelSimpanData_Kelompok03MouseMoved

    private void labelSimpanData_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSimpanData_Kelompok03MouseClicked
        // TODO add your handling code here:
        String defaultKata = "";
        try{
          String sql2 = "INSERT INTO t_akun_profile_pelanggan VALUES ('"+ textKd_Kelompok03.getText() + "','" + defaultKata +  "','" + defaultKata 
                        + defaultKata + "','" + textNamaLengkap_Kelompok03.getText() + "','" + defaultKata + "','" + defaultKata + "','" 
                        + defaultKata + "','" + textTeleponi_Kelompok03.getText() + "','" + textAlamat_Kelompok03.getText() + "','" + defaultKata + "','" + defaultKata + "','" + textEmail_Kelompok03.getText() + "','"
                        + textPW_Kelompok03.getText()+ "')";
          
          java.sql.Connection conn=(Connection)Database.configDB();
          java.sql.PreparedStatement pstm2 = conn.prepareStatement(sql2);
          pstm2.execute();
          HapusField();
        kodeLaporanOtomatis();
          JOptionPane.showMessageDialog(null, "Proses Simpan Data Berhasil.");
      }catch(HeadlessException | SQLException e){
          JOptionPane.showMessageDialog(this, "Simpan Data Gagal", "Pesan",
          JOptionPane.WARNING_MESSAGE);
      }
        FormPelangganAdmin s = new FormPelangganAdmin();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_labelSimpanData_Kelompok03MouseClicked

    private void panelSimpanData_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSimpanData_Kelompok03MouseMoved
        // TODO add your handling code here:
        panelSimpanData_Kelompok03.setBackground(new java.awt.Color(57,161,255));
        labelSimpanData_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
    }//GEN-LAST:event_panelSimpanData_Kelompok03MouseMoved

    private void panelSimpanData_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSimpanData_Kelompok03MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelSimpanData_Kelompok03MouseClicked

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
            java.util.logging.Logger.getLogger(FormPelanggaAdminDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPelanggaAdminDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPelanggaAdminDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPelanggaAdminDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPelanggaAdminDetail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GmbrDetail_Kelompok03;
    private javax.swing.JLabel Rahasia;
    private javax.swing.JLabel labelAlamat_Kelompok03;
    private javax.swing.JLabel labelBahanBaku_Kelompok03;
    private javax.swing.JLabel labelBarang_Kelompok03;
    private javax.swing.JLabel labelCartin_Kelompok03;
    private javax.swing.JLabel labelEmail_Kelompok03;
    private javax.swing.JLabel labelFood_Kelompok03;
    private javax.swing.JLabel labelGambar_Kelompok03;
    private javax.swing.JLabel labelHome_Kelompok03;
    private javax.swing.JLabel labelIconEmailOri_Kelompok03;
    private javax.swing.JLabel labelIconJumlahOri_Kelompok03;
    private javax.swing.JLabel labelIconKdBrgOri_Kelompok03;
    private javax.swing.JLabel labelIconNamaBrgOri_Kelompok03;
    private javax.swing.JLabel labelIconTotalOri_Kelompok03;
    private javax.swing.JLabel labelIconTotalOri_Kelompok4;
    private javax.swing.JLabel labelIconmRahasia_Kelompok03;
    private javax.swing.JLabel labelKd_Kelompok03;
    private javax.swing.JLabel labelKeluar_Kelompok03;
    private javax.swing.JLabel labelKembali_Kelompok03;
    private javax.swing.JLabel labelKet2_Kelompok4;
    private javax.swing.JLabel labelKetDetail_Kelompok03;
    private javax.swing.JLabel labelNamaLengkap_Kelompok03;
    private javax.swing.JLabel labelPW_Kelompok03;
    private javax.swing.JLabel labelPelanggan_Kelompok03;
    private javax.swing.JLabel labelSimpanData_Kelompok03;
    public static javax.swing.JLabel labelSimpanPerubahanl_Kelompok03;
    private javax.swing.JLabel labelTelepon_Kelompok03;
    private javax.swing.JLabel labelTransaksi_Kelompok03;
    private ClassForGUI.PanelRound panelAlamat_Kelompok03;
    private ClassForGUI.PanelRound panelDetailBahanBaku_Kelompok03;
    private ClassForGUI.PanelRound panelEmail_Kelompok03;
    private ClassForGUI.PanelRound panelGaris_Kelompok03;
    private ClassForGUI.PanelRound panelGmbrDetail_Kelompok03;
    private ClassForGUI.PanelRound panelKd_Kelompok03;
    private ClassForGUI.PanelRound panelKembali_Kelompok03;
    private ClassForGUI.PanelRound panelNamaLengkap_Kelompok03;
    private ClassForGUI.PanelRound panelPW_Kelompok03;
    private ClassForGUI.PanelRound panelRahasia_Kelompok03;
    public static ClassForGUI.PanelRound panelSimpanData_Kelompok03;
    public static ClassForGUI.PanelRound panelSimpanPerubahanl_Kelompok03;
    private ClassForGUI.PanelRound panelTeleponi_Kelompok03;
    private javax.swing.JPanel panel_Kelompok03;
    private javax.swing.JTextField textAlamat_Kelompok03;
    private javax.swing.JTextField textEmail_Kelompok03;
    private javax.swing.JTextField textKd_Kelompok03;
    private javax.swing.JTextField textNamaLengkap_Kelompok03;
    private javax.swing.JTextField textPW_Kelompok03;
    private javax.swing.JTextField textRahasia_Kelompok03;
    private javax.swing.JTextField textTeleponi_Kelompok03;
    // End of variables declaration//GEN-END:variables
}
