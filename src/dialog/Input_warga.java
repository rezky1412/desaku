/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialog;

import desa_ciapus.Koneksi;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author FUTURE-PC
 */
public class Input_warga extends javax.swing.JDialog {
    
    Koneksi koneksi = new Koneksi();
    int xMouse,yMouse;

    /**
     * Creates new form Input_warga
     */
    public Input_warga(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        reset();
        comboagama();
        combogol();
        combojk();
        combopendidikan();
        combosk();
        combort();
        comborw();
    }
    
    private void upper(KeyEvent f){
        if(Character.isLowerCase(f.getKeyChar())){
        char keyChar = f.getKeyChar();
        f.setKeyChar(Character.toUpperCase(keyChar));
        }
    }
    
    private void fbatasannik(KeyEvent c){
        if(nik.getText().length()>=16){
            c.consume();
            JOptionPane.showMessageDialog(null,"NIK Tidak Lebih Dari 16 Digit");
        }
    }
    
    private void fangka(KeyEvent a){
        if(Character.isAlphabetic(a.getKeyChar())){
            a.consume();
            JOptionPane.showMessageDialog(null,"Hanya Boleh Angka");
        }
    }
    
    private void combojk(){
    koneksi.koneksi();
    String sql ="select * from jenis_kelamin";
    try{
    koneksi.pst = koneksi.conn.prepareStatement(sql);
    koneksi.res = koneksi.pst.executeQuery();
    while (koneksi.res.next()){
    String isi = koneksi.res.getString("jenis_kelamin");
    jk.addItem(isi);
    }
    } catch (Exception e){
        System.out.println(e.getMessage());
    }
    }
    
    private void combogol(){
    koneksi.koneksi();
    String sql ="select * from t_gol_darah";
    try{
    koneksi.pst = koneksi.conn.prepareStatement(sql);
    koneksi.res = koneksi.pst.executeQuery();
    while (koneksi.res.next()){
    String isi = koneksi.res.getString("gol");
    gol.addItem(isi);
    }
    } catch (Exception e){
        System.out.println(e.getMessage());
    }
    }
    
    private void comboagama(){
    koneksi.koneksi();
    String sql ="select * from t_agama";
    try{
    koneksi.pst = koneksi.conn.prepareStatement(sql);
    koneksi.res = koneksi.pst.executeQuery();
    while (koneksi.res.next()){
    String isi = koneksi.res.getString("nama");
    agama.addItem(isi);
    }
    } catch (Exception e){
        System.out.println(e.getMessage());
    }
    }
    
    private void combosk(){
    koneksi.koneksi();
    String sql ="select * from t_status_kawin";
    try{
    koneksi.pst = koneksi.conn.prepareStatement(sql);
    koneksi.res = koneksi.pst.executeQuery();
    while (koneksi.res.next()){
    String isi = koneksi.res.getString("status");
    sk.addItem(isi);
    }
    } catch (Exception e){
        System.out.println(e.getMessage());
    }
    }
    
    private void combopendidikan(){
    koneksi.koneksi();
    String sql ="select * from t_pendidikan";
    try{
    koneksi.pst = koneksi.conn.prepareStatement(sql);
    koneksi.res = koneksi.pst.executeQuery();
    while (koneksi.res.next()){
    String isi = koneksi.res.getString("pendidikan");
    pendidikan.addItem(isi);
    }
    } catch (Exception e){
        System.out.println(e.getMessage());
    }
    }
    
    private void combort(){
    koneksi.koneksi();
    String sql ="select * from rt";
    try{
    koneksi.pst = koneksi.conn.prepareStatement(sql);
    koneksi.res = koneksi.pst.executeQuery();
    while (koneksi.res.next()){
    String isi = koneksi.res.getString("nama");
    rt.addItem(isi);
    }
    } catch (Exception e){
        System.out.println(e.getMessage());
    }
    }
    
    private void comborw(){
    koneksi.koneksi();
    String sql ="select * from rw";
    try{
    koneksi.pst = koneksi.conn.prepareStatement(sql);
    koneksi.res = koneksi.pst.executeQuery();
    while (koneksi.res.next()){
    String isi = koneksi.res.getString("nama");
    rw.addItem(isi);
    }
    } catch (Exception e){
        System.out.println(e.getMessage());
    }
    }
    
    private void reset(){
        nik.setText("");
        nama.setText("");
        kw.setSelectedIndex(0);
        alamat.setText("");
        tempat.setText("");
        tl.setDate(null);
        jk.setSelectedIndex(0);
        gol.setSelectedIndex(0);
        agama.setSelectedIndex(0);
        sk.setSelectedIndex(0);
        pendidikan.setSelectedIndex(0);
        pekerjaan.setText("");
        no.setText("");
        srt.setText("");
        srw.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_warga1 = new desa_ciapus.Bg_warga();
        exit = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        nik = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        kw = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        rt = new javax.swing.JComboBox<>();
        rw = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        tempat = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tl = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jk = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        gol = new javax.swing.JComboBox<>();
        agama = new javax.swing.JComboBox<>();
        sk = new javax.swing.JComboBox<>();
        pendidikan = new javax.swing.JComboBox<>();
        no = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        pekerjaan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        srt = new javax.swing.JTextField();
        srw = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("INPUT DATA WARGA");
        setUndecorated(true);

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit1.png"))); // NOI18N
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exitMouseReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("PEKERJAAN");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("NO TELEPON");

        nik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nikKeyTyped(evt);
            }
        });

        nama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                namaKeyTyped(evt);
            }
        });

        kw.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- PILIH -", "WNI", "WNA" }));

        alamat.setColumns(20);
        alamat.setLineWrap(true);
        alamat.setRows(2);
        alamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                alamatKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(alamat);

        rt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- PILIH -" }));

        rw.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- PILIH -" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("NIK");

        tempat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tempatKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("NAMA");

        tl.setDateFormatString("dd-MM-yyyy");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("KEWARGANEGARAAN");

        jk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- PILIH -" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("ALAMAT");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("RT");

        gol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- PILIH -" }));

        agama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- PILIH -" }));

        sk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- PILIH -" }));

        pendidikan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- PILIH -" }));

        no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                noKeyTyped(evt);
            }
        });

        jButton1.setText("OKE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("RESET");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("RW");

        pekerjaan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pekerjaanKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("TEMPAT LAHIR");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("TANGGAL LAHIR");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("JENIS KELAMIN");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("GOL DARAH");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("AGAMA");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("STATUS KAWIN");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("PENDIDIKAN");

        jLabel7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel7MouseDragged(evt);
            }
        });
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });

        javax.swing.GroupLayout bg_warga1Layout = new javax.swing.GroupLayout(bg_warga1);
        bg_warga1.setLayout(bg_warga1Layout);
        bg_warga1Layout.setHorizontalGroup(
            bg_warga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_warga1Layout.createSequentialGroup()
                .addGroup(bg_warga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bg_warga1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(exit))
                    .addGroup(bg_warga1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(bg_warga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(26, 26, 26)
                        .addGroup(bg_warga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bg_warga1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(bg_warga1Layout.createSequentialGroup()
                                .addGroup(bg_warga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nama)
                                    .addComponent(nik, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kw, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1)
                                    .addGroup(bg_warga1Layout.createSequentialGroup()
                                        .addGroup(bg_warga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(tl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tempat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bg_warga1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(rt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel6))
                                            .addComponent(jk, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                        .addComponent(rw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addGroup(bg_warga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16))
                                .addGap(69, 69, 69)
                                .addGroup(bg_warga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(gol, 0, 134, Short.MAX_VALUE)
                                    .addComponent(agama, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pendidikan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(no)
                                    .addGroup(bg_warga1Layout.createSequentialGroup()
                                        .addComponent(srt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47)
                                        .addComponent(srw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(pekerjaan))
                                .addGap(26, 26, 26)))))
                .addContainerGap())
        );
        bg_warga1Layout.setVerticalGroup(
            bg_warga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_warga1Layout.createSequentialGroup()
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(bg_warga1Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(bg_warga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bg_warga1Layout.createSequentialGroup()
                        .addGroup(bg_warga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(bg_warga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(bg_warga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(kw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(bg_warga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(bg_warga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(rt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(rw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(bg_warga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tempat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(bg_warga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(tl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bg_warga1Layout.createSequentialGroup()
                        .addGroup(bg_warga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(gol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(bg_warga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(agama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(bg_warga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(sk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(bg_warga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(pendidikan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(bg_warga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(pekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(bg_warga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(bg_warga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(srt, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(srw, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addGroup(bg_warga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(bg_warga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_warga1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_warga1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this,
                "Yakin Akan Menginputkan Data ?",
                "Konfirmasi Input Data Warga",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION){
            try {
                koneksi.koneksi();
                String sql ="SELECT * FROM rt WHERE nama='"+rt.getSelectedItem().toString()+"'";
                ResultSet rs = koneksi.cn.executeQuery(sql);
                if (rs.next()) {
                    srt.setText(rs.getString(1));
                }
                rs.close();
                koneksi.conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            try {
                koneksi.koneksi();
                String sql ="SELECT * FROM rw WHERE nama='"+rw.getSelectedItem().toString()+"'";
                ResultSet rs = koneksi.cn.executeQuery(sql);
                if (rs.next()) {
                    srw.setText(rs.getString(1));
                }
                rs.close();
                koneksi.conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            try{
                koneksi.koneksi();
                String ttl = new SimpleDateFormat("yyyy-MM-dd").format(tl.getDate());
                java.util.Date tanggal = new java.util.Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                String sql="INSERT INTO warga set nik='"+nik.getText()+"',nama='"+nama.getText()+"',kewarganegaraan='"+kw.getSelectedItem().toString()+"',alamat='"+alamat.getText()+"',id_rt='"+srt.getText()+"',"
                        + "id_rw='"+srw.getText()+"',tempat_lahir='"+tempat.getText()+"',tanggal_lahir='"+ttl+"',id_jk='"+jk.getSelectedIndex()+"',id_gol='"+gol.getSelectedIndex()+"',"
                        + "id_agama='"+agama.getSelectedIndex()+"',id_skawin='"+sk.getSelectedIndex()+"',id_pendidikan='"+pendidikan.getSelectedIndex()+"',pekerjaan='"+pekerjaan.getText()+"',"
                        + "nohp='"+no.getText()+"',date='"+sdf.format(tanggal)+"'";
                koneksi.cn.executeUpdate(sql);
                koneksi.conn.close();
                JOptionPane.showMessageDialog(this, "Input Data Berhasil");
                reset();
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Input Gagal");
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nikKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nikKeyTyped
        // TODO add your handling code here:
        fangka(evt);
        fbatasannik(evt);
    }//GEN-LAST:event_nikKeyTyped

    private void namaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namaKeyTyped
        // TODO add your handling code here:
        upper(evt);
    }//GEN-LAST:event_namaKeyTyped

    private void alamatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alamatKeyTyped
        // TODO add your handling code here:
        upper(evt);
    }//GEN-LAST:event_alamatKeyTyped

    private void pekerjaanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pekerjaanKeyTyped
        // TODO add your handling code here:
        upper(evt);
    }//GEN-LAST:event_pekerjaanKeyTyped

    private void tempatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tempatKeyTyped
        // TODO add your handling code here:
        upper(evt);
    }//GEN-LAST:event_tempatKeyTyped

    private void noKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noKeyTyped
        // TODO add your handling code here:
        fangka(evt);
    }//GEN-LAST:event_noKeyTyped

    private void exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseExited
        // TODO add your handling code here:
        ImageIcon tekan = new ImageIcon(getClass().getResource("/images/exit1.png"));
        exit.setIcon(tekan);
    }//GEN-LAST:event_exitMouseExited

    private void exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMousePressed
        // TODO add your handling code here:
        ImageIcon tekan = new ImageIcon(getClass().getResource("/images/exit2.png"));
        exit.setIcon(tekan);
    }//GEN-LAST:event_exitMousePressed

    private void exitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseReleased
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_exitMouseReleased

    private void jLabel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jLabel7MouseDragged

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jLabel7MousePressed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Input_warga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Input_warga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Input_warga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Input_warga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Input_warga dialog = new Input_warga(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> agama;
    private javax.swing.JTextArea alamat;
    private desa_ciapus.Bg_warga bg_warga1;
    private javax.swing.JLabel exit;
    private javax.swing.JComboBox<String> gol;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jk;
    private javax.swing.JComboBox<String> kw;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nik;
    private javax.swing.JTextField no;
    private javax.swing.JTextField pekerjaan;
    private javax.swing.JComboBox<String> pendidikan;
    private javax.swing.JComboBox<String> rt;
    private javax.swing.JComboBox<String> rw;
    private javax.swing.JComboBox<String> sk;
    private javax.swing.JTextField srt;
    private javax.swing.JTextField srw;
    private javax.swing.JTextField tempat;
    private com.toedter.calendar.JDateChooser tl;
    // End of variables declaration//GEN-END:variables
}
