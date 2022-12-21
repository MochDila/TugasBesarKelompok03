/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormGUI;

import Database.Database;
import static FormGUI.FormBarangAdmin.textKdBahani_Kelompok03;
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
public class FormBarangAdminDetail extends javax.swing.JFrame {

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
        if(textKdBahani_Kelompok03.getText().equals("")){
            try {
            setKoneksi();
            String sql="select right (kode_barang,2)+1 from t_master_barang";
            ResultSet rs=st.executeQuery(sql);
            
            if(rs.next()){
                rs.last();
                String no=rs.getString(1);
                while (no.length()<3){
                    no="0"+no;
                    textKdBahani_Kelompok03.setText("KBRCF"+no);}
                }
            else 
            {
                textKdBahani_Kelompok03.setText("KBRCF01"); 
            }
            } catch (Exception e) 
            {
        }
        }
    }
    
    private void TampilkanDataPelanggan(){ 
        try{
            String sql="SELECT * FROM t_master_barang WHERE kode_barang ='"+textKdBahani_Kelompok03.getText()+"'";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                String namaBahan = res.getString("nama_barang");
                String tglMasuk = res.getString("tgl_masuk");
                String jumlahStok = res.getString("jumlah_barang");
                String hargaBahan = res.getString("harga_barang");
                textNamaBahani_Kelompok03.setText(namaBahan);           
                ((JTextField)dateTglMasuk_Kelompok03.getDateEditor().getUiComponent()).setText(tglMasuk);     
                textJumlahStocki_Kelompok03.setText(jumlahStok);
                textHargaBahan_Kelompok03.setText(hargaBahan);
                }
            
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public void Gambar(){
        if (textKdBahani_Kelompok03.getText().equals("KBRCF03")){
          GmbrDetail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Baso Tahu Menu.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF01")){
          GmbrDetail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Food Original.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF02")){
          GmbrDetail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Food Medium.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF04")){
          GmbrDetail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Food Special.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF06")){
          GmbrDetail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Air Meneral.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF05")){
          GmbrDetail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Air Mineral 330 ml Keranjang.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF07")){
          GmbrDetail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Air Mineral 660 ml Keranjang.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF08")){
          GmbrDetail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Jus Botol Lemon.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF09")){
          GmbrDetail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keranjang Jus Alpukat.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF10")){
          GmbrDetail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keranjang Jus Strauberi.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF11")){
          GmbrDetail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keranjang Coca Cola.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF12")){
          GmbrDetail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keranjang Sprite.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF13")){
          GmbrDetail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keranjang Fanta.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF14")){
          GmbrDetail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keranjang Kopi Ori.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF15")){
          GmbrDetail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keranjang Capucino.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF16")){
          GmbrDetail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Keranjang Misto.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF17")){
          GmbrDetail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Catering.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF18")){
          GmbrDetail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Catering Medium.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF19")){
          GmbrDetail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Catering Besar.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF20")){
          GmbrDetail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Frozen.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF21")){
          GmbrDetail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Frozen Siomay.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF22")){
          GmbrDetail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Frozen Dimsum.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF93")){
          GmbrDetail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Eceran Tahu.png")));
      }
      else if (textKdBahani_Kelompok03.getText().equals("KBRCF94")){
          GmbrDetail_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Eceran.png")));
      }
    }
    
    public void HapusField(){
        textHargaBahan_Kelompok03.setText("");
        textJumlahStocki_Kelompok03.setText("");
        textKdBahani_Kelompok03.setText("");
        textNamaBahani_Kelompok03.setText("");
    }
    
    public void HidePanel(){
        if(textRahasia_Kelompok03.getText().equals("")){
            panelSimpanPerubahanl_Kelompok03.setSize(0, 0);
        }else {
            panelSimpanData_Kelompok03.setSize(0, 0);
        }
    }
    
    public FormBarangAdminDetail() {
        initComponents();
        getContentPane().setBackground(new Color(255,255,255));
        textKdBahani_Kelompok03.setText(FormBarangAdmin.textKdBahani_Kelompok03.getText());
        textRahasia_Kelompok03.setText(FormBarangAdmin.textRahasia_Kelompok03.getText());
        TampilkanDataPelanggan();
        kodeLaporanOtomatis();
        HidePanel();
        Gambar();
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
        paneltanggalMasukl_Kelompok03 = new ClassForGUI.PanelRound();
        labeltanggalMasukl_Kelompok03 = new javax.swing.JLabel();
        dateTglMasuk_Kelompok03 = new com.toedter.calendar.JDateChooser();
        panelRahasia_Kelompok03 = new ClassForGUI.PanelRound();
        Rahasia = new javax.swing.JLabel();
        labelIconmRahasia_Kelompok03 = new javax.swing.JLabel();
        textRahasia_Kelompok03 = new javax.swing.JTextField();
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
        panelKdBahani_Kelompok03 = new ClassForGUI.PanelRound();
        labelKdBahani_Kelompok03 = new javax.swing.JLabel();
        labelIconKdBrgOri_Kelompok03 = new javax.swing.JLabel();
        textKdBahani_Kelompok03 = new javax.swing.JTextField();
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
        paneltanggalMasukl_Kelompok03.add(dateTglMasuk_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, 260, 30));

        panelDetailBahanBaku_Kelompok03.add(paneltanggalMasukl_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, 280, 60));

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

        panelNamaBahani_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelNamaBahani_Kelompok03.setRoundBottomLeft(25);
        panelNamaBahani_Kelompok03.setRoundBottomRight(25);
        panelNamaBahani_Kelompok03.setRoundTopLeft(25);
        panelNamaBahani_Kelompok03.setRoundTopRight(25);
        panelNamaBahani_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNamaBahani_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelNamaBahani_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelNamaBahani_Kelompok03.setText("Nama Barang");
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

        panelDetailBahanBaku_Kelompok03.add(panelJumlahStocki_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 180, 280, 60));

        panelHargaBahan_Kelompok03.setBackground(new java.awt.Color(255, 255, 255));
        panelHargaBahan_Kelompok03.setRoundBottomLeft(25);
        panelHargaBahan_Kelompok03.setRoundBottomRight(25);
        panelHargaBahan_Kelompok03.setRoundTopLeft(25);
        panelHargaBahan_Kelompok03.setRoundTopRight(25);
        panelHargaBahan_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelHargaBahan_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelHargaBahan_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelHargaBahan_Kelompok03.setText("Harga Barang");
        panelHargaBahan_Kelompok03.add(labelHargaBahan_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        labelIconJumlahOri_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelIconJumlahOri_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelIconJumlahOri_Kelompok03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconJumlahOri_Kelompok03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Harga Barang.png"))); // NOI18N
        panelHargaBahan_Kelompok03.add(labelIconJumlahOri_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 40, 40));

        textHargaBahan_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 18)); // NOI18N
        textHargaBahan_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        textHargaBahan_Kelompok03.setBorder(null);
        textHargaBahan_Kelompok03.setOpaque(false);
        panelHargaBahan_Kelompok03.add(textHargaBahan_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 250, -1));

        panelDetailBahanBaku_Kelompok03.add(panelHargaBahan_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 280, 60));

        panelKdBahani_Kelompok03.setBackground(new java.awt.Color(222, 225, 229));
        panelKdBahani_Kelompok03.setRoundBottomLeft(25);
        panelKdBahani_Kelompok03.setRoundBottomRight(25);
        panelKdBahani_Kelompok03.setRoundTopLeft(25);
        panelKdBahani_Kelompok03.setRoundTopRight(25);
        panelKdBahani_Kelompok03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelKdBahani_Kelompok03.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        labelKdBahani_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        labelKdBahani_Kelompok03.setText("Kode Barang");
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

        panelDetailBahanBaku_Kelompok03.add(panelSimpanData_Kelompok03, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 360, 580, 60));

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
        labelKetDetail_Kelompok03.setText("Detail Barang");
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
    }//GEN-LAST:event_labelGambar_Kelompok03MouseMoved

    private void labelSimpanPerubahanl_Kelompok03MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSimpanPerubahanl_Kelompok03MouseMoved
        // TODO add your handling code here:
        labelSimpanPerubahanl_Kelompok03.setForeground(new java.awt.Color(21, 0, 53));
        panelSimpanPerubahanl_Kelompok03.setBackground(new java.awt.Color(57,161,255));
    }//GEN-LAST:event_labelSimpanPerubahanl_Kelompok03MouseMoved

    private void labelSimpanPerubahanl_Kelompok03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSimpanPerubahanl_Kelompok03MouseClicked
        // TODO add your handling code here:
        String tampilan ="dd/MM/yyyy";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(dateTglMasuk_Kelompok03.getDate()));
        try{
          String sql= "UPDATE t_master_barang SET nama_barang ='"+textNamaBahani_Kelompok03.getText()+"',tgl_masuk='"+tanggal
                  +"',jumlah_barang='"+textJumlahStocki_Kelompok03.getText()
                  +"',harga_barang='"+textHargaBahan_Kelompok03.getText()+"' WHERE kode_barang='"+textKdBahani_Kelompok03.getText()+"'";
          
          java.sql.Connection conn=(Connection)Database.configDB();
          java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
          pstm.execute();
          JOptionPane.showMessageDialog(null, "Proses Perubahan Data Berhasil.");
      }catch(HeadlessException | SQLException e){
          JOptionPane.showMessageDialog(this, "Simpan Perubahan Gagal", "Pesan",
          JOptionPane.WARNING_MESSAGE);
      }
        TampilkanDataPelanggan();
        FormBarangAdmin s = new FormBarangAdmin();
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
        FormBarangAdmin s = new FormBarangAdmin();
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
        String tampilan ="dd/MM/yyyy";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(dateTglMasuk_Kelompok03.getDate()));
        try{
          String sql2 = "INSERT INTO t_master_barang VALUES ('"+textKdBahani_Kelompok03.getText()+ "','" + textNamaBahani_Kelompok03.getText()
                  + "','" + tanggal+ "','" + textJumlahStocki_Kelompok03.getText()
                  + "','" +textHargaBahan_Kelompok03.getText()+"')";
          
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
        FormBarangAdmin s = new FormBarangAdmin();
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
            java.util.logging.Logger.getLogger(FormBarangAdminDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBarangAdminDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBarangAdminDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBarangAdminDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FormBarangAdminDetail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GmbrDetail_Kelompok03;
    private javax.swing.JLabel Rahasia;
    private com.toedter.calendar.JDateChooser dateTglMasuk_Kelompok03;
    private javax.swing.JLabel labelBahanBaku_Kelompok03;
    private javax.swing.JLabel labelBarang_Kelompok03;
    private javax.swing.JLabel labelCartin_Kelompok03;
    private javax.swing.JLabel labelFood_Kelompok03;
    private javax.swing.JLabel labelGambar_Kelompok03;
    private javax.swing.JLabel labelHargaBahan_Kelompok03;
    private javax.swing.JLabel labelHome_Kelompok03;
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
    private javax.swing.JLabel labelSimpanData_Kelompok03;
    public static javax.swing.JLabel labelSimpanPerubahanl_Kelompok03;
    private javax.swing.JLabel labelTransaksi_Kelompok03;
    private javax.swing.JLabel labeltanggalMasukl_Kelompok03;
    private ClassForGUI.PanelRound panelDetailBahanBaku_Kelompok03;
    private ClassForGUI.PanelRound panelGaris_Kelompok03;
    private ClassForGUI.PanelRound panelGmbrDetail_Kelompok03;
    private ClassForGUI.PanelRound panelHargaBahan_Kelompok03;
    private ClassForGUI.PanelRound panelJumlahStocki_Kelompok03;
    private ClassForGUI.PanelRound panelKdBahani_Kelompok03;
    private ClassForGUI.PanelRound panelKembali_Kelompok03;
    private ClassForGUI.PanelRound panelNamaBahani_Kelompok03;
    private ClassForGUI.PanelRound panelRahasia_Kelompok03;
    public static ClassForGUI.PanelRound panelSimpanData_Kelompok03;
    public static ClassForGUI.PanelRound panelSimpanPerubahanl_Kelompok03;
    private javax.swing.JPanel panel_Kelompok03;
    private ClassForGUI.PanelRound paneltanggalMasukl_Kelompok03;
    private javax.swing.JTextField textHargaBahan_Kelompok03;
    private javax.swing.JTextField textJumlahStocki_Kelompok03;
    private javax.swing.JTextField textKdBahani_Kelompok03;
    private javax.swing.JTextField textNamaBahani_Kelompok03;
    private javax.swing.JTextField textRahasia_Kelompok03;
    // End of variables declaration//GEN-END:variables
}
