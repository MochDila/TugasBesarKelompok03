/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormGUI;

import Database.Database;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Muhammad Dila
 */
public class FormAkun extends javax.swing.JFrame {

    Connection conn;
    Statement st;
    ResultSet rs;
    
    public FormAkun() {
        initComponents();
        try {
                Class.forName("com.mysql.jdbc.Driver");
                conn =DriverManager.getConnection("jdbc:mysql://localhost/db_tugasbesar_kelompok03","root","");
                st = conn.createStatement();
                       
            }
            catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Gagal terkoneksiKarena " + ex);
            }
        textEmail_Kelompok03.setText(FormLogin.textEmail_Kelompok03.getText());
        TampilkanDataPelanggan();
    }
      
    private void HapusTextField(){
        textCekEmail_Kelompok03.setText("");  
        textCekPassword_Kelompok03.setText("");
    }
    
    private void CekLogin(){
        try{
            if(textCekEmail_Kelompok03.getText().equals("") || textCekPassword_Kelompok03.getPassword().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Data Tidak Boleh Kosong", "Pesan", JOptionPane.ERROR_MESSAGE);
                textCekEmail_Kelompok03.requestFocus();
                HapusTextField();
            }
            else{
                st = conn.createStatement();
                String sql = ("SELECT * FROM t_akun_profile_pelanggan WHERE email ='" + textCekEmail_Kelompok03.getText()+"' AND password ='" + String.valueOf(textCekPassword_Kelompok03.getPassword())+"'");
                ResultSet rs = st.executeQuery(sql); 
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "Berhasil Masuk");
                    TampilkanDataPelanggan();
                    panelCekLogin_Kelompok03.setSize(0, 0);
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "UserName dan Password Salah\nAtau Akun Belum Terdaftar", "Pesan",
                    JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void TampilkanDataPelanggan(){ 
        try{
            String sql="SELECT * FROM t_akun_profile_pelanggan WHERE email ='"+textEmail_Kelompok03.getText()+"'";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                String kodePelanggan = res.getString("kode_pelanggan");
                String namaDepan = res.getString("nama_depan");
                String namaBelakang = res.getString("nama_belakang");
                String namaLengkap = res.getString("nama_lengkap");
                String tempatLahir = res.getString("tempat_lahir");
                String tanggalLahir = res.getString("tanggal_lahir");
                String jenisKelamin = res.getString("jenis_kelamin");
                String noTelepon = res.getString("no_telepon");
                String alamat = res.getString("alamat");
                String kelurahan = res.getString("kelurahan");
                String kecamatan = res.getString("kecamatan");
                String email = res.getString("email");
                String password = res.getString("password");
                textKodePelanggan_Kelompok03.setText(kodePelanggan);           
                textNamaDepan_Kelompok03.setText(namaDepan);      
                textNamaBelakang_Kelompok03.setText(namaBelakang);
                textNamaLkp_Kelompok03.setText(namaLengkap);
                textTempatLahir_Kelompok03.setText(tempatLahir);
                ((JTextField)dateTglLahir_Kelompok03.getDateEditor().getUiComponent()).setText(tanggalLahir);
                comboJenisKelamin_Kelompok03.setSelectedItem(jenisKelamin);
                textTelepon_Kelompok03.setText(noTelepon);
                textAlamat_Kelompok03.setText(alamat);
                textKelurahan_Kelompok03.setText(kelurahan);
                textKecamatan_Kelompok03.setText(kecamatan);
                textEmail_Kelompok03.setText(email);
                textPassword_Kelompok03.setText(password);
                }
            
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    private void tombolEdit(){
        textNamaDepan_Kelompok03.setEnabled(true);
        textNamaBelakang_Kelompok03.setEnabled(true);
        textNamaLkp_Kelompok03.setEnabled(true);
        textTempatLahir_Kelompok03.setEnabled(true);
        dateTglLahir_Kelompok03.setEnabled(true);
        comboJenisKelamin_Kelompok03.setEnabled(true);
        textTelepon_Kelompok03.setEnabled(true);
        textAlamat_Kelompok03.setEnabled(true);
        textKelurahan_Kelompok03.setEnabled(true);
        textKecamatan_Kelompok03.setEnabled(true);
        textPassword_Kelompok03.setEnabled(true);
        textPassword_Kelompok03.setEchoChar((char) 0);
        panelNamaDepan_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelNamaBelakang_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelNamaLkp_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelTempatLahir_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelTglLahir_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelKelamin_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelTelepon_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelAlamat_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelKelurahan_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelKecamatan_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelPassword_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        comboJenisKelamin_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        dateTglLahir_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
    }
    
    private void tombolSave(){
        textNamaDepan_Kelompok03.setEnabled(false);
        textNamaBelakang_Kelompok03.setEnabled(false);
        textNamaLkp_Kelompok03.setEnabled(false);
        textTempatLahir_Kelompok03.setEnabled(false);
        dateTglLahir_Kelompok03.setEnabled(false);
        comboJenisKelamin_Kelompok03.setEnabled(false);
        textTelepon_Kelompok03.setEnabled(false);
        textAlamat_Kelompok03.setEnabled(false);
        textKelurahan_Kelompok03.setEnabled(false);
        textKecamatan_Kelompok03.setEnabled(false);
        textEmail_Kelompok03.setEnabled(false);
        textPassword_Kelompok03.setEnabled(false);
        panelNamaDepan_Kelompok03.setBackground(new java.awt.Color(222,225,229));
        panelNamaBelakang_Kelompok03.setBackground(new java.awt.Color(222,225,229));
        panelNamaLkp_Kelompok03.setBackground(new java.awt.Color(222,225,229));
        panelTempatLahir_Kelompok03.setBackground(new java.awt.Color(222,225,229));
        panelTglLahir_Kelompok03.setBackground(new java.awt.Color(222,225,229));
        panelKelamin_Kelompok03.setBackground(new java.awt.Color(222,225,229));
        panelTelepon_Kelompok03.setBackground(new java.awt.Color(222,225,229));
        panelAlamat_Kelompok03.setBackground(new java.awt.Color(222,225,229));
        panelKelurahan_Kelompok03.setBackground(new java.awt.Color(222,225,229));
        panelKecamatan_Kelompok03.setBackground(new java.awt.Color(222,225,229));
        panelEmail_Kelompok03.setBackground(new java.awt.Color(222,225,229));
        panelPassword_Kelompok03.setBackground(new java.awt.Color(222,225,229));
        comboJenisKelamin_Kelompok03.setBackground(new java.awt.Color(222,225,229));
        dateTglLahir_Kelompok03.setBackground(new java.awt.Color(222,225,229));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
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
        panelCekLogin_Kelompok03 = new ClassForGUI.PanelRound();
        labelSelamatDatang_Kelompok03 = new javax.swing.JLabel();
        labelMasukanAkun_Kelompok03 = new javax.swing.JLabel();
        panelCekEmail_Kelompok03 = new ClassForGUI.PanelRound();
        labelCekEmail_Kelompok03 = new javax.swing.JLabel();
        textCekEmail_Kelompok03 = new javax.swing.JTextField();
        labelIconCekEmail_Kelompok03 = new javax.swing.JLabel();
        panelCekPassword_Kelompok03 = new ClassForGUI.PanelRound();
        labelCekPassword_Kelompok03 = new javax.swing.JLabel();
        textCekPassword_Kelompok03 = new javax.swing.JPasswordField();
        labelIconCekPassword_Kelompok03 = new javax.swing.JLabel();
        panelMasukAkun_Kelompok03 = new ClassForGUI.PanelRound();
        labelMasukAkun_Kelompok03 = new javax.swing.JLabel();
        labelBelumPunya_Kelompok03 = new javax.swing.JLabel();
        panelHapus_Kelompok03 = new ClassForGUI.PanelRound();
        labelHapus_Kelompok03 = new javax.swing.JLabel();
        labelKet1_Kelompok03 = new javax.swing.JLabel();
        labelKet2_Kelompok03 = new javax.swing.JLabel();
        labelKet3_Kelompok03 = new javax.swing.JLabel();
        panelGaris_Kelompok03 = new ClassForGUI.PanelRound();
        panelTelepon_Kelompok03 = new ClassForGUI.PanelRound();
        labelIconTelepon_Kelompok03 = new javax.swing.JLabel();
        labelTelepon_Kelompok03 = new javax.swing.JLabel();
        textTelepon_Kelompok03 = new javax.swing.JTextField();
        panelTglLahir_Kelompok03 = new ClassForGUI.PanelRound();
        labelTglLahir_Kelompok03 = new javax.swing.JLabel();
        dateTglLahir_Kelompok03 = new com.toedter.calendar.JDateChooser();
        panelKecamatan_Kelompok03 = new ClassForGUI.PanelRound();
        labelIconKecamatan_Kelompok03 = new javax.swing.JLabel();
        labelKecamatan_Kelompok03 = new javax.swing.JLabel();
        textKecamatan_Kelompok03 = new javax.swing.JTextField();
        panelKelurahan_Kelompok03 = new ClassForGUI.PanelRound();
        labelIconKelurahan_Kelompok03 = new javax.swing.JLabel();
        lalbeKelurahan_Kelompok03 = new javax.swing.JLabel();
        textKelurahan_Kelompok03 = new javax.swing.JTextField();
        panelKelamin_Kelompok03 = new ClassForGUI.PanelRound();
        labelKelamin_Kelompok03 = new javax.swing.JLabel();
        comboJenisKelamin_Kelompok03 = new ClassForGUI.ComboBoxSuggestion();
        panelTempatLahir_Kelompok03 = new ClassForGUI.PanelRound();
        labelIconTempatLahir_Kelompok03 = new javax.swing.JLabel();
        labelTempatLahir_Kelompok03 = new javax.swing.JLabel();
        textTempatLahir_Kelompok03 = new javax.swing.JTextField();
        panelNamaLkp_Kelompok03 = new ClassForGUI.PanelRound();
        labelIconNamaLkp_Kelompok03 = new javax.swing.JLabel();
        labelNamaLkp_Kelompok03 = new javax.swing.JLabel();
        textNamaLkp_Kelompok03 = new javax.swing.JTextField();
        panelEmail_Kelompok03 = new ClassForGUI.PanelRound();
        labelIconEmail_Kelompok03 = new javax.swing.JLabel();
        labelEmail_Kelompok03 = new javax.swing.JLabel();
        textEmail_Kelompok03 = new javax.swing.JTextField();
        panelAlamat_Kelompok03 = new ClassForGUI.PanelRound();
        labelIconAlamat_Kelompok03 = new javax.swing.JLabel();
        labelAlamat_Kelompok03 = new javax.swing.JLabel();
        textAlamat_Kelompok03 = new javax.swing.JTextField();
        panelNamaBelakang_Kelompok03 = new ClassForGUI.PanelRound();
        labelIconNamaBelakang_Kelompok03 = new javax.swing.JLabel();
        labelNamaBelakang_Kelompok03 = new javax.swing.JLabel();
        textNamaBelakang_Kelompok03 = new javax.swing.JTextField();
        panelNamaDepan_Kelompok03 = new ClassForGUI.PanelRound();
        labelIconNamaDepan_Kelompok03 = new javax.swing.JLabel();
        textNamaDepan_Kelompok03 = new javax.swing.JTextField();
        labelNamaDepan_Kelompok5 = new javax.swing.JLabel();
        panelPassword_Kelompok03 = new ClassForGUI.PanelRound();
        labelPassword_Kelompok03 = new javax.swing.JLabel();
        labelIconPW_Kelompok03 = new javax.swing.JLabel();
        textPassword_Kelompok03 = new javax.swing.JPasswordField();
        panelGmbProfil_Kelompok03 = new ClassForGUI.PanelRound();
        panelKode_Kelompok03 = new ClassForGUI.PanelRound();
        textKodePelanggan_Kelompok03 = new javax.swing.JTextField();
        labelIconGmbProfil_Kelompok03 = new javax.swing.JLabel();
        panelEdit_Kelompok03 = new ClassForGUI.PanelRound();
        labelEdit_Kelompok03 = new javax.swing.JLabel();
        panelSave_Kelompok03 = new ClassForGUI.PanelRound();
        labelSave_Kelompok03 = new javax.swing.JLabel();
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
        labelAkun_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelAkun_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Akun.png"))); // NOI18N
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
        labelPembayaran_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelPembayaran_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Pembayaran Putih.png"))); // NOI18N
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

        panelCekLogin_Kelompok03.setBackground(new java.awt.Color(57, 161, 255));
        panelCekLogin_Kelompok03.setRoundBottomLeft(25);
        panelCekLogin_Kelompok03.setRoundBottomRight(25);
        panelCekLogin_Kelompok03.setRoundTopLeft(25);
        panelCekLogin_Kelompok03.setRoundTopRight(25);
        panelCekLogin_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelCekLogin_Kelompok03MouseMoved(evt);
            }
        });
        panelCekLogin_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelSelamatDatang_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelSelamatDatang_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelSelamatDatang_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSelamatDatang_Kelompok03.setText("Selamat Datang di Form Profile");
        panelCekLogin_Kelompok03.add(labelSelamatDatang_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 460, -1));

        labelMasukanAkun_Kelompok03.setFont(new java.awt.Font("Urbanist Black", 1, 36)); // NOI18N
        labelMasukanAkun_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelMasukanAkun_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMasukanAkun_Kelompok03.setText("Masukan Akun Anda");
        panelCekLogin_Kelompok03.add(labelMasukanAkun_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 460, -1));

        panelCekEmail_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelCekEmail_Kelompok03.setRoundBottomLeft(25);
        panelCekEmail_Kelompok03.setRoundBottomRight(25);
        panelCekEmail_Kelompok03.setRoundTopLeft(25);
        panelCekEmail_Kelompok03.setRoundTopRight(25);
        panelCekEmail_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelCekEmail_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelCekEmail_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelCekEmail_Kelompok03.setText("Email");
        panelCekEmail_Kelompok03.add(labelCekEmail_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        textCekEmail_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textCekEmail_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textCekEmail_Kelompok03.setBorder(null);
        textCekEmail_Kelompok03.setOpaque(false);
        panelCekEmail_Kelompok03.add(textCekEmail_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 340, -1));

        labelIconCekEmail_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconCekEmail_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelIconCekEmail_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconCekEmail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Email.png"))); // NOI18N
        panelCekEmail_Kelompok03.add(labelIconCekEmail_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 10, 40, 40));

        panelCekLogin_Kelompok03.add(panelCekEmail_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 230, 420, 60));

        panelCekPassword_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelCekPassword_Kelompok03.setRoundBottomLeft(25);
        panelCekPassword_Kelompok03.setRoundBottomRight(25);
        panelCekPassword_Kelompok03.setRoundTopLeft(25);
        panelCekPassword_Kelompok03.setRoundTopRight(25);
        panelCekPassword_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelCekPassword_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelCekPassword_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelCekPassword_Kelompok03.setText("Password");
        panelCekPassword_Kelompok03.add(labelCekPassword_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        textCekPassword_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textCekPassword_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textCekPassword_Kelompok03.setBorder(null);
        textCekPassword_Kelompok03.setOpaque(false);
        panelCekPassword_Kelompok03.add(textCekPassword_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 350, -1));

        labelIconCekPassword_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconCekPassword_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelIconCekPassword_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconCekPassword_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Password.png"))); // NOI18N
        panelCekPassword_Kelompok03.add(labelIconCekPassword_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 10, 40, 40));

        panelCekLogin_Kelompok03.add(panelCekPassword_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 310, 420, 60));

        panelMasukAkun_Kelompok03.setBackground(new java.awt.Color(21, 0, 53));
        panelMasukAkun_Kelompok03.setRoundBottomLeft(35);
        panelMasukAkun_Kelompok03.setRoundBottomRight(35);
        panelMasukAkun_Kelompok03.setRoundTopLeft(35);
        panelMasukAkun_Kelompok03.setRoundTopRight(35);
        panelMasukAkun_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelMasukAkun_Kelompok03MouseMoved(evt);
            }
        });
        panelMasukAkun_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelMasukAkun_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelMasukAkun_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelMasukAkun_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMasukAkun_Kelompok03.setText("Masuk");
        labelMasukAkun_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelMasukAkun_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelMasukAkun_Kelompok03MouseMoved(evt);
            }
        });
        labelMasukAkun_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMasukAkun_Kelompok03MouseClicked(evt);
            }
        });
        panelMasukAkun_Kelompok03.add(labelMasukAkun_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 180, 30));

        panelCekLogin_Kelompok03.add(panelMasukAkun_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 390, 200, 60));

        labelBelumPunya_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelBelumPunya_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelBelumPunya_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBelumPunya_Kelompok03.setText("Hal ini dilakukan untuk memastika bahwa ini akun anda");
        panelCekLogin_Kelompok03.add(labelBelumPunya_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 460, -1));

        panelHapus_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelHapus_Kelompok03.setRoundBottomLeft(35);
        panelHapus_Kelompok03.setRoundBottomRight(35);
        panelHapus_Kelompok03.setRoundTopLeft(35);
        panelHapus_Kelompok03.setRoundTopRight(35);
        panelHapus_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelHapus_Kelompok03MouseMoved(evt);
            }
        });
        panelHapus_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelHapus_Kelompok03.setBackground(new java.awt.Color(102, 102, 102));
        labelHapus_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelHapus_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelHapus_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHapus_Kelompok03.setText("Hapus Field");
        labelHapus_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelHapus_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelHapus_Kelompok03MouseClicked(evt);
            }
        });
        panelHapus_Kelompok03.add(labelHapus_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 180, 30));

        panelCekLogin_Kelompok03.add(panelHapus_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, 200, 60));

        panel_Kelompok03.add(panelCekLogin_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1250, 0));

        labelKet1_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelKet1_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelKet1_Kelompok03.setText("Informasi Akun");
        panel_Kelompok03.add(labelKet1_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, -1, -1));

        labelKet2_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelKet2_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelKet2_Kelompok03.setText("Informasi Pribadi");
        panel_Kelompok03.add(labelKet2_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, -1, -1));

        labelKet3_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelKet3_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelKet3_Kelompok03.setText("Informasi Tempat Tinggal");
        panel_Kelompok03.add(labelKet3_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, -1, -1));

        panelGaris_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panel_Kelompok03.add(panelGaris_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1280, 5));

        panelTelepon_Kelompok03.setBackground(new java.awt.Color(222, 225, 229));
        panelTelepon_Kelompok03.setRoundBottomLeft(25);
        panelTelepon_Kelompok03.setRoundBottomRight(25);
        panelTelepon_Kelompok03.setRoundTopLeft(25);
        panelTelepon_Kelompok03.setRoundTopRight(25);
        panelTelepon_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelIconTelepon_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconTelepon_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelIconTelepon_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconTelepon_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon No Telepon.png"))); // NOI18N
        panelTelepon_Kelompok03.add(labelIconTelepon_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 10, 40, 40));

        labelTelepon_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelTelepon_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelTelepon_Kelompok03.setText("No Telepon");
        panelTelepon_Kelompok03.add(labelTelepon_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        textTelepon_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textTelepon_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textTelepon_Kelompok03.setBorder(null);
        textTelepon_Kelompok03.setEnabled(false);
        textTelepon_Kelompok03.setOpaque(false);
        panelTelepon_Kelompok03.add(textTelepon_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 150, -1));

        panel_Kelompok03.add(panelTelepon_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 280, 180, 60));

        panelTglLahir_Kelompok03.setBackground(new java.awt.Color(222, 225, 229));
        panelTglLahir_Kelompok03.setRoundBottomLeft(25);
        panelTglLahir_Kelompok03.setRoundBottomRight(25);
        panelTglLahir_Kelompok03.setRoundTopLeft(25);
        panelTglLahir_Kelompok03.setRoundTopRight(25);
        panelTglLahir_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTglLahir_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelTglLahir_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelTglLahir_Kelompok03.setText("Tanggal Lahir");
        panelTglLahir_Kelompok03.add(labelTglLahir_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        dateTglLahir_Kelompok03.setDateFormatString("yyyy-MM-dd");
        dateTglLahir_Kelompok03.setEnabled(false);
        dateTglLahir_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        dateTglLahir_Kelompok03.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateTglLahir_Kelompok03PropertyChange(evt);
            }
        });
        dateTglLahir_Kelompok03.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                dateTglLahir_Kelompok03VetoableChange(evt);
            }
        });
        panelTglLahir_Kelompok03.add(dateTglLahir_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, 160, 30));

        panel_Kelompok03.add(panelTglLahir_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 280, 180, 60));

        panelKecamatan_Kelompok03.setBackground(new java.awt.Color(222, 225, 229));
        panelKecamatan_Kelompok03.setRoundBottomLeft(25);
        panelKecamatan_Kelompok03.setRoundBottomRight(25);
        panelKecamatan_Kelompok03.setRoundTopLeft(25);
        panelKecamatan_Kelompok03.setRoundTopRight(25);
        panelKecamatan_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelIconKecamatan_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconKecamatan_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelIconKecamatan_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconKecamatan_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Kecamatan.png"))); // NOI18N
        panelKecamatan_Kelompok03.add(labelIconKecamatan_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 10, 40, 40));

        labelKecamatan_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelKecamatan_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelKecamatan_Kelompok03.setText("Kecamatan");
        panelKecamatan_Kelompok03.add(labelKecamatan_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        textKecamatan_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textKecamatan_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textKecamatan_Kelompok03.setBorder(null);
        textKecamatan_Kelompok03.setEnabled(false);
        textKecamatan_Kelompok03.setOpaque(false);
        panelKecamatan_Kelompok03.add(textKecamatan_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 150, -1));

        panel_Kelompok03.add(panelKecamatan_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 400, 180, 60));

        panelKelurahan_Kelompok03.setBackground(new java.awt.Color(222, 225, 229));
        panelKelurahan_Kelompok03.setRoundBottomLeft(25);
        panelKelurahan_Kelompok03.setRoundBottomRight(25);
        panelKelurahan_Kelompok03.setRoundTopLeft(25);
        panelKelurahan_Kelompok03.setRoundTopRight(25);
        panelKelurahan_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelIconKelurahan_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconKelurahan_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelIconKelurahan_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconKelurahan_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Kelurahan.png"))); // NOI18N
        panelKelurahan_Kelompok03.add(labelIconKelurahan_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 10, 40, 40));

        lalbeKelurahan_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        lalbeKelurahan_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        lalbeKelurahan_Kelompok03.setText("Kelurahan/ Desa");
        panelKelurahan_Kelompok03.add(lalbeKelurahan_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        textKelurahan_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textKelurahan_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textKelurahan_Kelompok03.setBorder(null);
        textKelurahan_Kelompok03.setEnabled(false);
        textKelurahan_Kelompok03.setOpaque(false);
        panelKelurahan_Kelompok03.add(textKelurahan_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 150, -1));

        panel_Kelompok03.add(panelKelurahan_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 400, 180, 60));

        panelKelamin_Kelompok03.setBackground(new java.awt.Color(222, 225, 229));
        panelKelamin_Kelompok03.setRoundBottomLeft(25);
        panelKelamin_Kelompok03.setRoundBottomRight(25);
        panelKelamin_Kelompok03.setRoundTopLeft(25);
        panelKelamin_Kelompok03.setRoundTopRight(25);
        panelKelamin_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelKelamin_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelKelamin_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelKelamin_Kelompok03.setText("Jenis Kelamin");
        panelKelamin_Kelompok03.add(labelKelamin_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        comboJenisKelamin_Kelompok03.setBackground(new java.awt.Color(222, 225, 229));
        comboJenisKelamin_Kelompok03.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pria", "Wanita" }));
        comboJenisKelamin_Kelompok03.setSelectedIndex(-1);
        comboJenisKelamin_Kelompok03.setEnabled(false);
        comboJenisKelamin_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        panelKelamin_Kelompok03.add(comboJenisKelamin_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, 160, 30));

        panel_Kelompok03.add(panelKelamin_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 280, 180, 60));

        panelTempatLahir_Kelompok03.setBackground(new java.awt.Color(222, 225, 229));
        panelTempatLahir_Kelompok03.setRoundBottomLeft(25);
        panelTempatLahir_Kelompok03.setRoundBottomRight(25);
        panelTempatLahir_Kelompok03.setRoundTopLeft(25);
        panelTempatLahir_Kelompok03.setRoundTopRight(25);
        panelTempatLahir_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelIconTempatLahir_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconTempatLahir_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelIconTempatLahir_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconTempatLahir_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Tempat Lahir.png"))); // NOI18N
        panelTempatLahir_Kelompok03.add(labelIconTempatLahir_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 10, 40, 40));

        labelTempatLahir_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelTempatLahir_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelTempatLahir_Kelompok03.setText("Tempat Lahir");
        panelTempatLahir_Kelompok03.add(labelTempatLahir_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        textTempatLahir_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textTempatLahir_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textTempatLahir_Kelompok03.setBorder(null);
        textTempatLahir_Kelompok03.setEnabled(false);
        textTempatLahir_Kelompok03.setOpaque(false);
        panelTempatLahir_Kelompok03.add(textTempatLahir_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 150, -1));

        panel_Kelompok03.add(panelTempatLahir_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 180, 60));

        panelNamaLkp_Kelompok03.setBackground(new java.awt.Color(222, 225, 229));
        panelNamaLkp_Kelompok03.setRoundBottomLeft(25);
        panelNamaLkp_Kelompok03.setRoundBottomRight(25);
        panelNamaLkp_Kelompok03.setRoundTopLeft(25);
        panelNamaLkp_Kelompok03.setRoundTopRight(25);
        panelNamaLkp_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelIconNamaLkp_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconNamaLkp_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelIconNamaLkp_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconNamaLkp_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Nama.png"))); // NOI18N
        panelNamaLkp_Kelompok03.add(labelIconNamaLkp_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 10, 40, 40));

        labelNamaLkp_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelNamaLkp_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelNamaLkp_Kelompok03.setText("Nama Lengkap");
        panelNamaLkp_Kelompok03.add(labelNamaLkp_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        textNamaLkp_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textNamaLkp_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textNamaLkp_Kelompok03.setBorder(null);
        textNamaLkp_Kelompok03.setEnabled(false);
        textNamaLkp_Kelompok03.setOpaque(false);
        panelNamaLkp_Kelompok03.add(textNamaLkp_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 340, -1));

        panel_Kelompok03.add(panelNamaLkp_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 190, 380, 60));

        panelEmail_Kelompok03.setBackground(new java.awt.Color(222, 225, 229));
        panelEmail_Kelompok03.setRoundBottomLeft(25);
        panelEmail_Kelompok03.setRoundBottomRight(25);
        panelEmail_Kelompok03.setRoundTopLeft(25);
        panelEmail_Kelompok03.setRoundTopRight(25);
        panelEmail_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelIconEmail_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconEmail_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelIconEmail_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconEmail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Email.png"))); // NOI18N
        panelEmail_Kelompok03.add(labelIconEmail_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 10, 40, 40));

        labelEmail_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelEmail_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelEmail_Kelompok03.setText("Email");
        panelEmail_Kelompok03.add(labelEmail_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        textEmail_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textEmail_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textEmail_Kelompok03.setBorder(null);
        textEmail_Kelompok03.setEnabled(false);
        textEmail_Kelompok03.setOpaque(false);
        panelEmail_Kelompok03.add(textEmail_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 340, -1));

        panel_Kelompok03.add(panelEmail_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 520, 380, 60));

        panelAlamat_Kelompok03.setBackground(new java.awt.Color(222, 225, 229));
        panelAlamat_Kelompok03.setRoundBottomLeft(25);
        panelAlamat_Kelompok03.setRoundBottomRight(25);
        panelAlamat_Kelompok03.setRoundTopLeft(25);
        panelAlamat_Kelompok03.setRoundTopRight(25);
        panelAlamat_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelIconAlamat_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconAlamat_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelIconAlamat_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconAlamat_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Alamat.png"))); // NOI18N
        panelAlamat_Kelompok03.add(labelIconAlamat_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 10, 40, 40));

        labelAlamat_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelAlamat_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelAlamat_Kelompok03.setText("Alamat (RT/ RW)");
        panelAlamat_Kelompok03.add(labelAlamat_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        textAlamat_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textAlamat_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textAlamat_Kelompok03.setBorder(null);
        textAlamat_Kelompok03.setEnabled(false);
        textAlamat_Kelompok03.setOpaque(false);
        panelAlamat_Kelompok03.add(textAlamat_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 340, -1));

        panel_Kelompok03.add(panelAlamat_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 400, 380, 60));

        panelNamaBelakang_Kelompok03.setBackground(new java.awt.Color(222, 225, 229));
        panelNamaBelakang_Kelompok03.setRoundBottomLeft(25);
        panelNamaBelakang_Kelompok03.setRoundBottomRight(25);
        panelNamaBelakang_Kelompok03.setRoundTopLeft(25);
        panelNamaBelakang_Kelompok03.setRoundTopRight(25);
        panelNamaBelakang_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelIconNamaBelakang_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconNamaBelakang_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelIconNamaBelakang_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconNamaBelakang_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Nama.png"))); // NOI18N
        panelNamaBelakang_Kelompok03.add(labelIconNamaBelakang_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 10, 40, 40));

        labelNamaBelakang_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelNamaBelakang_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelNamaBelakang_Kelompok03.setText("Nama Belakang");
        panelNamaBelakang_Kelompok03.add(labelNamaBelakang_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        textNamaBelakang_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textNamaBelakang_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textNamaBelakang_Kelompok03.setBorder(null);
        textNamaBelakang_Kelompok03.setEnabled(false);
        textNamaBelakang_Kelompok03.setOpaque(false);
        panelNamaBelakang_Kelompok03.add(textNamaBelakang_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 150, -1));

        panel_Kelompok03.add(panelNamaBelakang_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, 180, 60));

        panelNamaDepan_Kelompok03.setBackground(new java.awt.Color(222, 225, 229));
        panelNamaDepan_Kelompok03.setRoundBottomLeft(25);
        panelNamaDepan_Kelompok03.setRoundBottomRight(25);
        panelNamaDepan_Kelompok03.setRoundTopLeft(25);
        panelNamaDepan_Kelompok03.setRoundTopRight(25);
        panelNamaDepan_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelIconNamaDepan_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconNamaDepan_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelIconNamaDepan_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconNamaDepan_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Nama.png"))); // NOI18N
        panelNamaDepan_Kelompok03.add(labelIconNamaDepan_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 10, 40, 40));

        textNamaDepan_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textNamaDepan_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textNamaDepan_Kelompok03.setBorder(null);
        textNamaDepan_Kelompok03.setEnabled(false);
        textNamaDepan_Kelompok03.setOpaque(false);
        panelNamaDepan_Kelompok03.add(textNamaDepan_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 150, 20));

        labelNamaDepan_Kelompok5.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelNamaDepan_Kelompok5.setForeground(new java.awt.Color(21, 0, 53));
        labelNamaDepan_Kelompok5.setText("Nama Depan");
        panelNamaDepan_Kelompok03.add(labelNamaDepan_Kelompok5, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        panel_Kelompok03.add(panelNamaDepan_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 180, 60));

        panelPassword_Kelompok03.setBackground(new java.awt.Color(222, 225, 229));
        panelPassword_Kelompok03.setRoundBottomLeft(25);
        panelPassword_Kelompok03.setRoundBottomRight(25);
        panelPassword_Kelompok03.setRoundTopLeft(25);
        panelPassword_Kelompok03.setRoundTopRight(25);
        panelPassword_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelPassword_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelPassword_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelPassword_Kelompok03.setText("Password");
        panelPassword_Kelompok03.add(labelPassword_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        labelIconPW_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconPW_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelIconPW_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconPW_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Password.png"))); // NOI18N
        panelPassword_Kelompok03.add(labelIconPW_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 10, 40, 40));

        textPassword_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textPassword_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textPassword_Kelompok03.setBorder(null);
        textPassword_Kelompok03.setEnabled(false);
        textPassword_Kelompok03.setOpaque(false);
        panelPassword_Kelompok03.add(textPassword_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 350, -1));

        panel_Kelompok03.add(panelPassword_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 520, 380, 60));

        panelGmbProfil_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelGmbProfil_Kelompok03.setRoundBottomLeft(25);
        panelGmbProfil_Kelompok03.setRoundBottomRight(25);
        panelGmbProfil_Kelompok03.setRoundTopLeft(25);
        panelGmbProfil_Kelompok03.setRoundTopRight(25);
        panelGmbProfil_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelKode_Kelompok03.setBackground(new java.awt.Color(222, 225, 229));
        panelKode_Kelompok03.setRoundBottomLeft(35);
        panelKode_Kelompok03.setRoundBottomRight(35);
        panelKode_Kelompok03.setRoundTopLeft(35);
        panelKode_Kelompok03.setRoundTopRight(35);
        panelKode_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textKodePelanggan_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textKodePelanggan_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textKodePelanggan_Kelompok03.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textKodePelanggan_Kelompok03.setBorder(null);
        textKodePelanggan_Kelompok03.setEnabled(false);
        textKodePelanggan_Kelompok03.setOpaque(false);
        panelKode_Kelompok03.add(textKodePelanggan_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 150, -1));

        panelGmbProfil_Kelompok03.add(panelKode_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 270, 60));

        labelIconGmbProfil_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconGmbProfil_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Profile.jpg"))); // NOI18N
        panelGmbProfil_Kelompok03.add(labelIconGmbProfil_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 210, -1));

        panel_Kelompok03.add(panelGmbProfil_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 370, 380));

        panelEdit_Kelompok03.setBackground(new java.awt.Color(21, 0, 53));
        panelEdit_Kelompok03.setRoundBottomLeft(35);
        panelEdit_Kelompok03.setRoundBottomRight(35);
        panelEdit_Kelompok03.setRoundTopLeft(35);
        panelEdit_Kelompok03.setRoundTopRight(35);
        panelEdit_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelEdit_Kelompok03MouseMoved(evt);
            }
        });
        panelEdit_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelEdit_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelEdit_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelEdit_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEdit_Kelompok03.setText("Edit Profile");
        labelEdit_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelEdit_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelEdit_Kelompok03MouseClicked(evt);
            }
        });
        panelEdit_Kelompok03.add(labelEdit_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 150, 30));

        panel_Kelompok03.add(panelEdit_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 570, 170, 60));

        panelSave_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelSave_Kelompok03.setRoundBottomLeft(35);
        panelSave_Kelompok03.setRoundBottomRight(35);
        panelSave_Kelompok03.setRoundTopLeft(35);
        panelSave_Kelompok03.setRoundTopRight(35);
        panelSave_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelSave_Kelompok03MouseMoved(evt);
            }
        });
        panelSave_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelSave_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelSave_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelSave_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSave_Kelompok03.setText("Save Profile");
        labelSave_Kelompok03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelSave_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelSave_Kelompok03MouseMoved(evt);
            }
        });
        labelSave_Kelompok03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSave_Kelompok03MouseClicked(evt);
            }
        });
        panelSave_Kelompok03.add(labelSave_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 150, 30));

        panel_Kelompok03.add(panelSave_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, 170, 60));

        labelGambar_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        labelGambar_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Form Home 2.png"))); // NOI18N
        labelGambar_Kelompok03.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                labelGambar_Kelompok03MouseMoved(evt);
            }
        });
        panel_Kelompok03.add(labelGambar_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1280, 720));

        getContentPane().add(panel_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(1296, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void labelMenu_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMenu_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelMenu_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Menu.png")));
        labelMenu_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
    }//GEN-LAST:event_labelMenu_Kelompok03MouseMoved

    private void labelHome_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelHome_Kelompok03MouseMoved
        // TODO add your handling code here
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
        labelPembayaran_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Pembayaran .png")));
        labelPembayaran_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
    }//GEN-LAST:event_labelPembayaran_Kelompok03MouseMoved

    private void labelAkun_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAkun_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelAkun_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Akun Putih.png")));
        labelAkun_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
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

    private void labelSave_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSave_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelSave_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        panelSave_Kelompok03.setBackground(new java.awt.Color(255, 176, 0));
    }//GEN-LAST:event_labelSave_Kelompok03MouseMoved

    private void panelSave_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSave_Kelompok03MouseMoved
        // TODO add your handling code here:
        panelSave_Kelompok03.setBackground(new java.awt.Color(255, 176, 0));
    }//GEN-LAST:event_panelSave_Kelompok03MouseMoved

    private void panelEdit_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelEdit_Kelompok03MouseMoved
        // TODO add your handling code here:
        panelEdit_Kelompok03.setBackground(new java.awt.Color(255, 176, 0));
        labelEdit_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
    }//GEN-LAST:event_panelEdit_Kelompok03MouseMoved

    private void labelMasukAkun_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMasukAkun_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelMasukAkun_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
    }//GEN-LAST:event_labelMasukAkun_Kelompok03MouseMoved

    private void labelMasukAkun_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMasukAkun_Kelompok03MouseClicked
        // TODO add your handling code here:
        CekLogin();
    }//GEN-LAST:event_labelMasukAkun_Kelompok03MouseClicked

    private void panelMasukAkun_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMasukAkun_Kelompok03MouseMoved
        // TODO add your handling code here:
        panelMasukAkun_Kelompok03.setBackground(new java.awt.Color(255, 176, 0));
        labelMasukAkun_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
    }//GEN-LAST:event_panelMasukAkun_Kelompok03MouseMoved

    private void panelCekLogin_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCekLogin_Kelompok03MouseMoved
        // TODO add your handling code here:
        panelMasukAkun_Kelompok03.setBackground(new java.awt.Color(21, 0, 53));
        labelMasukAkun_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        panelHapus_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_panelCekLogin_Kelompok03MouseMoved

    private void labelHapus_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelHapus_Kelompok03MouseClicked
        // TODO add your handling code here:
        HapusTextField();
    }//GEN-LAST:event_labelHapus_Kelompok03MouseClicked

    private void panelHapus_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHapus_Kelompok03MouseMoved
        // TODO add your handling code here:
        panelHapus_Kelompok03.setBackground(new java.awt.Color(255, 176, 0));
    }//GEN-LAST:event_panelHapus_Kelompok03MouseMoved

    private void labelEdit_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEdit_Kelompok03MouseClicked
        // TODO add your handling code here:
        tombolEdit();
    }//GEN-LAST:event_labelEdit_Kelompok03MouseClicked

    private void labelSave_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSave_Kelompok03MouseClicked
        // TODO add your handling code here:
        String tampilan ="yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(dateTglLahir_Kelompok03.getDate()));
        try{
//          String sql= "UPDATE t_akun_profile_pelanggan SET kode_pelanggan ='"+textAlamat_Kelompok03.getText()+"',nama_depan='"+textNamaDepan_Kelompok03.getText()+"',nama_belakang='"
//                  +textNamaBelakang_Kelompok03.getText()+"',nama_lengkapr='"+textNamaLkp_Kelompok03.getText()+"',tempat_lahir='"+textTempatLahir_Kelompok03.getText()
//                  +"',tanggal_lahir='"+textAlamat_Kelompok03+"',jenis_kelamin='"+textKelamin_Kelompok03.getText()+"',no_telepon='"
//                  +textTelepon_Kelompok03.getText()+"',alamat='"+textAlamat_Kelompok03.getText()+"',kelurahan='"+textKelurahan_Kelompok03.getText()
//                  +"',kecamatan='"+textKecamatan_Kelompok03.getText()+"',email='"+textEmail_Kelompok03.getText()+"',password='"+textPassword_Kelompok03.getPassword()
//                  +"' WHERE kode_pelanggan='"+labelKode_Kelompok03.getText()+"'";

          String sql= "UPDATE t_akun_profile_pelanggan SET kode_pelanggan ='"+textKodePelanggan_Kelompok03.getText()+"',nama_depan='"+textNamaDepan_Kelompok03.getText()
                  +"',nama_belakang='"+textNamaBelakang_Kelompok03.getText()+"',nama_lengkap='"+textNamaLkp_Kelompok03.getText()+"',tempat_lahir='"+textTempatLahir_Kelompok03.getText()
                  +"',tanggal_lahir='"+tanggal+"',jenis_kelamin='"+comboJenisKelamin_Kelompok03.getSelectedItem()+"',no_telepon='"+textTelepon_Kelompok03.getText()
                  +"',alamat='"+textAlamat_Kelompok03.getText()+"',kelurahan='"+textKelurahan_Kelompok03.getText()+"',kecamatan='"+textKecamatan_Kelompok03.getText()
                  +"',email='"+textEmail_Kelompok03.getText()+"',password='"+String.valueOf(textPassword_Kelompok03.getPassword())+"' WHERE kode_pelanggan='"+textKodePelanggan_Kelompok03.getText()+"'";
          
          java.sql.Connection conn=(Connection)Database.configDB();
          java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
          pstm.execute();
          JOptionPane.showMessageDialog(null, "Proses Simpan Data Berhasil.");
      }catch(HeadlessException | SQLException e){
          JOptionPane.showMessageDialog(this, "Simpan Data Gagal", "Pesan",
          JOptionPane.WARNING_MESSAGE);
      }
        TampilkanDataPelanggan();
        tombolSave();
    }//GEN-LAST:event_labelSave_Kelompok03MouseClicked

    private void dateTglLahir_Kelompok03PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateTglLahir_Kelompok03PropertyChange
        // TODO add your handling code here:
        panelCekLogin_Kelompok03.setSize(0, 0);
    }//GEN-LAST:event_dateTglLahir_Kelompok03PropertyChange

    private void dateTglLahir_Kelompok03VetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_dateTglLahir_Kelompok03VetoableChange
        // TODO add your handling code here:
        panelCekLogin_Kelompok03.setSize(0, 0);
    }//GEN-LAST:event_dateTglLahir_Kelompok03VetoableChange

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
        labelPembayaran_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Pembayaran Putih.png")));
        labelPembayaran_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        labelAkun_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Akun.png")));
        labelAkun_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelKeluar_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keluar Putih.png")));
        labelKeluar_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
        panelSave_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelEdit_Kelompok03.setBackground(new java.awt.Color(21, 0, 53));
        labelEdit_Kelompok03.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_labelGambar_Kelompok03MouseMoved

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
            java.util.logging.Logger.getLogger(FormAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new FormAkun().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private ClassForGUI.ComboBoxSuggestion comboJenisKelamin_Kelompok03;
    private com.toedter.calendar.JDateChooser dateTglLahir_Kelompok03;
    private javax.swing.JLabel labelAkun_Kelompok03;
    private javax.swing.JLabel labelAlamat_Kelompok03;
    private javax.swing.JLabel labelBelumPunya_Kelompok03;
    private javax.swing.JLabel labelCartin_Kelompok03;
    private javax.swing.JLabel labelCekEmail_Kelompok03;
    private javax.swing.JLabel labelCekPassword_Kelompok03;
    private javax.swing.JLabel labelEdit_Kelompok03;
    private javax.swing.JLabel labelEmail_Kelompok03;
    private javax.swing.JLabel labelFood_Kelompok03;
    private javax.swing.JLabel labelGambar_Kelompok03;
    private javax.swing.JLabel labelHapus_Kelompok03;
    private javax.swing.JLabel labelHome_Kelompok03;
    private javax.swing.JLabel labelIconAlamat_Kelompok03;
    private javax.swing.JLabel labelIconCekEmail_Kelompok03;
    private javax.swing.JLabel labelIconCekPassword_Kelompok03;
    private javax.swing.JLabel labelIconEmail_Kelompok03;
    private javax.swing.JLabel labelIconGmbProfil_Kelompok03;
    private javax.swing.JLabel labelIconKecamatan_Kelompok03;
    private javax.swing.JLabel labelIconKelurahan_Kelompok03;
    private javax.swing.JLabel labelIconNamaBelakang_Kelompok03;
    private javax.swing.JLabel labelIconNamaDepan_Kelompok03;
    private javax.swing.JLabel labelIconNamaLkp_Kelompok03;
    private javax.swing.JLabel labelIconPW_Kelompok03;
    private javax.swing.JLabel labelIconTelepon_Kelompok03;
    private javax.swing.JLabel labelIconTempatLahir_Kelompok03;
    private javax.swing.JLabel labelKecamatan_Kelompok03;
    private javax.swing.JLabel labelKelamin_Kelompok03;
    private javax.swing.JLabel labelKeluar_Kelompok03;
    private javax.swing.JLabel labelKeranjang_Kelompok03;
    private javax.swing.JLabel labelKet1_Kelompok03;
    private javax.swing.JLabel labelKet2_Kelompok03;
    private javax.swing.JLabel labelKet3_Kelompok03;
    private javax.swing.JLabel labelLayanan_Kelompok03;
    private javax.swing.JLabel labelMasukAkun_Kelompok03;
    private javax.swing.JLabel labelMasukanAkun_Kelompok03;
    private javax.swing.JLabel labelMenu_Kelompok03;
    private javax.swing.JLabel labelNamaBelakang_Kelompok03;
    private javax.swing.JLabel labelNamaDepan_Kelompok5;
    private javax.swing.JLabel labelNamaLkp_Kelompok03;
    private javax.swing.JLabel labelPassword_Kelompok03;
    private javax.swing.JLabel labelPembayaran_Kelompok03;
    private javax.swing.JLabel labelSave_Kelompok03;
    private javax.swing.JLabel labelSelamatDatang_Kelompok03;
    private javax.swing.JLabel labelTelepon_Kelompok03;
    private javax.swing.JLabel labelTempatLahir_Kelompok03;
    private javax.swing.JLabel labelTglLahir_Kelompok03;
    private javax.swing.JLabel lalbeKelurahan_Kelompok03;
    private ClassForGUI.PanelRound panelAlamat_Kelompok03;
    private ClassForGUI.PanelRound panelCekEmail_Kelompok03;
    private ClassForGUI.PanelRound panelCekLogin_Kelompok03;
    private ClassForGUI.PanelRound panelCekPassword_Kelompok03;
    private ClassForGUI.PanelRound panelEdit_Kelompok03;
    private ClassForGUI.PanelRound panelEmail_Kelompok03;
    private ClassForGUI.PanelRound panelGaris_Kelompok03;
    private ClassForGUI.PanelRound panelGmbProfil_Kelompok03;
    private ClassForGUI.PanelRound panelHapus_Kelompok03;
    private ClassForGUI.PanelRound panelKecamatan_Kelompok03;
    private ClassForGUI.PanelRound panelKelamin_Kelompok03;
    private ClassForGUI.PanelRound panelKelurahan_Kelompok03;
    private ClassForGUI.PanelRound panelKode_Kelompok03;
    private ClassForGUI.PanelRound panelMasukAkun_Kelompok03;
    private ClassForGUI.PanelRound panelNamaBelakang_Kelompok03;
    private ClassForGUI.PanelRound panelNamaDepan_Kelompok03;
    private ClassForGUI.PanelRound panelNamaLkp_Kelompok03;
    private ClassForGUI.PanelRound panelPassword_Kelompok03;
    private ClassForGUI.PanelRound panelSave_Kelompok03;
    private ClassForGUI.PanelRound panelTelepon_Kelompok03;
    private ClassForGUI.PanelRound panelTempatLahir_Kelompok03;
    private ClassForGUI.PanelRound panelTglLahir_Kelompok03;
    private javax.swing.JPanel panel_Kelompok03;
    private javax.swing.JTextField textAlamat_Kelompok03;
    private javax.swing.JTextField textCekEmail_Kelompok03;
    private javax.swing.JPasswordField textCekPassword_Kelompok03;
    private javax.swing.JTextField textEmail_Kelompok03;
    private javax.swing.JTextField textKecamatan_Kelompok03;
    private javax.swing.JTextField textKelurahan_Kelompok03;
    private javax.swing.JTextField textKodePelanggan_Kelompok03;
    private javax.swing.JTextField textNamaBelakang_Kelompok03;
    private javax.swing.JTextField textNamaDepan_Kelompok03;
    private javax.swing.JTextField textNamaLkp_Kelompok03;
    private javax.swing.JPasswordField textPassword_Kelompok03;
    private javax.swing.JTextField textTelepon_Kelompok03;
    private javax.swing.JTextField textTempatLahir_Kelompok03;
    // End of variables declaration//GEN-END:variables
}
