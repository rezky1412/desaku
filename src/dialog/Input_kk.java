/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialog;

import desa_ciapus.Autonik;
import desa_ciapus.Koneksi;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author FUTURE-PC
 */
public class Input_kk extends javax.swing.JDialog {
       
    Koneksi koneksi = new Koneksi();
    JasperReport jasperReport;
    JasperDesign jasperDesign;
    JasperPrint jasperPrint;
    Map<String, Object> param = new HashMap <String, Object>();
    
    Autonik Autonik = new Autonik();
    
    String nkk,irt,irw,ialamat,jak;
    int xMouse,yMouse;

    /**
     * Creates new form Input_kk
     */
    public Input_kk(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        nik.getEditor().getEditorComponent().addKeyListener(new KeyAdapter(){
        
        @Override
        public void keyReleased(KeyEvent evt){
        
            String biodata=nik.getEditor().getItem().toString();
            
            if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            isi(biodata);
            }
            
            if(evt.getKeyCode()>=65 && evt.getKeyCode()<=90 || evt.getKeyCode()>=96 && evt.getKeyCode()<=105 || evt.getKeyCode()==8){}
            
                nik.setModel(Autonik.getList(biodata));
                if(nik.getItemCount()>0){
                
                    nik.showPopup();
                    if(evt.getKeyCode()!=8){
                    
                        ((JTextComponent)nik.getEditor().getEditorComponent()).select(biodata.length(), nik.getEditor().getItem().toString().length());
                        
                    }else{
                    nik.getEditor().setItem(biodata);
                    }
                    
                }else{
                nik.addItem(biodata);
                }
            
        }    
            
        });
        
        autono();
        autonokks();
        reset();
        d_anggota();
        tombol();
    }
    
    private void jumlah(){
        try {
            koneksi.koneksi();
            String sql = "SELECT COUNT(nama) FROM warga WHERE nokk ='"+nokks.getText()+"'";
            ResultSet rs = koneksi.cn.executeQuery(sql);
            if (rs.next()) {
                jak=rs.getString(1);
            }
            rs.close();
            koneksi.conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
    }
    
    private void tombol(){
        if(jTable1.getRowCount()>0){
            jButton2.setEnabled(true);
        }else{
            jButton2.setEnabled(false);
        }    
    }
    
    private void d_anggota(){
        DefaultTableModel tbla = new DefaultTableModel();
        tbla.addColumn("Nama Anggota");
        try{
            koneksi.koneksi();
            String sql="SELECT nama FROM warga WHERE nokk ='"+nokks.getText()+"'";
            ResultSet rs=koneksi.cn.executeQuery(sql);
            while (rs.next())
            {
                tbla.addRow(new Object[]{
                rs.getString(1)
            });
            }
            jTable1.setModel(tbla);
            koneksi.conn.close();
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null,"Ada Kesalahan...."); 
            System.out.println(e.getMessage());
        }
    }
    
    private void reset(){
        nama.setText("");
        id.setText("");
        alamat.setText("");
        rt.setText("");
        rw.setText("");
        nik.setSelectedItem("");
    }
    
    public void isi(String nik){
        String data[]=Autonik.isi(nik);
        if(data[0]!=null){
        nama.setText(data[1]);
        id.setText(data[0]);
        alamat.setText(data[4]);
        rt.setText(data[5]);
        rw.setText(data[6]);
    }else{
        JOptionPane.showMessageDialog(null, "No NIK belum Pernah Terdaftar, Silahkan Input Data Warga");
    }
    }
    
    private void autonokks(){
        java.util.Date tanggal = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy");
        try {
            koneksi.koneksi();
            String sql = "SELECT * FROM r_kk ORDER BY nokk DESC";
            ResultSet rs = koneksi.cn.executeQuery(sql);
            if (rs.next()) {
                String no_reg = rs.getString("nokk").substring(6);
                String AN = "" + (Integer.parseInt(no_reg) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "0000";}
                else if(AN.length()==2)
                {Nol = "000";}
                else if(AN.length()==3)
                {Nol = "00";}
                else if(AN.length()==4)
                {Nol = "0";}
                else if(AN.length()==5)
                {Nol = "";}
                nokks.setText("KKS"+ sdf.format(tanggal) + Nol + AN);
            } else {
                nokks.setText("KKS1800001");
            }
            rs.close();
            koneksi.conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }    
    }
    
    private void autono(){
        java.util.Date tanggal = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy");
        try {
            koneksi.koneksi();
            String sql = "SELECT * FROM r_kk ORDER BY no_reg DESC";
            ResultSet rs = koneksi.cn.executeQuery(sql);
            if (rs.next()) {
                String no_reg = rs.getString("no_reg").substring(6);
                String AN = "" + (Integer.parseInt(no_reg) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "0000";}
                else if(AN.length()==2)
                {Nol = "000";}
                else if(AN.length()==3)
                {Nol = "00";}
                else if(AN.length()==4)
                {Nol = "0";}
                else if(AN.length()==5)
                {Nol = "";}
                noreg.setText("F101"+ sdf.format(tanggal) + Nol + AN);
            } else {
                noreg.setText("F1011800001");
            }
            rs.close();
            koneksi.conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
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

        bg_rkk1 = new desa_ciapus.Bg_rkk();
        exit = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        noreg = new javax.swing.JTextField();
        nik = new javax.swing.JComboBox<>();
        nama = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        nokks = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        alamat = new javax.swing.JTextField();
        rt = new javax.swing.JTextField();
        rw = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REGISTRASI KK");
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

        jButton2.setText("CETAK");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("NO REGISTRASI");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("NIK");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("NAMA");

        noreg.setEditable(false);

        nik.setEditable(true);

        nama.setEditable(false);

        jButton1.setText("MASUKKAN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel4MouseDragged(evt);
            }
        });
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });

        javax.swing.GroupLayout bg_rkk1Layout = new javax.swing.GroupLayout(bg_rkk1);
        bg_rkk1.setLayout(bg_rkk1Layout);
        bg_rkk1Layout.setHorizontalGroup(
            bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_rkk1Layout.createSequentialGroup()
                .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bg_rkk1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exit))
                    .addGroup(bg_rkk1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(bg_rkk1Layout.createSequentialGroup()
                                .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(nokks, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bg_rkk1Layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(noreg)
                                                .addComponent(nik, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton1))
                                        .addGap(53, 53, 53)
                                        .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton2)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(bg_rkk1Layout.createSequentialGroup()
                                        .addGap(133, 133, 133)
                                        .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 69, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(bg_rkk1Layout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rt)
                    .addComponent(rw))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bg_rkk1Layout.setVerticalGroup(
            bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_rkk1Layout.createSequentialGroup()
                .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bg_rkk1Layout.createSequentialGroup()
                        .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(noreg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nokks, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rt, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(rw, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_rkk1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_rkk1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(jTable1.getRowCount()==0){
            try{
            koneksi.koneksi();
            String sql="INSERT INTO k_kk set no_reg='"+noreg.getText()+"',id_warga='"+id.getText()+"',nokk='"+nokks.getText()+"'";
            String sql2="UPDATE warga set nokk='"+nokks.getText()+"' WHERE id_warga='"+id.getText()+"'";
            koneksi.cn.executeUpdate(sql);
            koneksi.cn.executeUpdate(sql2);
            koneksi.conn.close();
            d_anggota();
            nkk = nama.getText();
            irt = rt.getText();
            irw = rw.getText();
            ialamat = alamat.getText();
            reset();
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Gagal");
            System.out.println(e.getMessage());
        }            
        }else{
            try{
            koneksi.koneksi();
            String sql="UPDATE warga set nokk='"+nokks.getText()+"' WHERE id_warga='"+id.getText()+"'";
            koneksi.cn.executeUpdate(sql);
            koneksi.conn.close();
            d_anggota();
            reset();
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Gagal");
            System.out.println(e.getMessage());
        }        
        }
        tombol();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:       
        int table=jTable1.getSelectedRow();
        //mengambil data dari table
        String a=jTable1.getValueAt(table,0).toString();
        
        int confirm = JOptionPane.showConfirmDialog(this,
                "Yakin Untuk Menghapus Anggota Ini ?",
                "Konfirmasi Hapus Data",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
 
        if (confirm == JOptionPane.YES_OPTION) {
            try {
            koneksi.koneksi();
            String cek ="SELECT warga.nama FROM warga, k_kk WHERE warga.id_warga=k_kk.id_warga AND warga.nama ='"+a+"' AND k_kk.nokk = '"+nokks.getText()+"'";
            ResultSet rs = koneksi.cn.executeQuery(cek);
            if (rs.next()) {
                try {
                koneksi.koneksi();
                String ed ="UPDATE warga set nokk='' WHERE nokk ='"+nokks.getText()+"'";
                String del ="DELETE FROM k_kk WHERE nokk ='"+nokks.getText()+"'";
                koneksi.cn.executeUpdate(ed);
                koneksi.cn.executeUpdate(del);
                koneksi.conn.close();
                d_anggota();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(this, "Proses Hapus Gagal");
            }
            }else {
                try {
                koneksi.koneksi();
                String ed ="UPDATE warga set nokk='' WHERE nama='"+a+"' AND nokk ='"+nokks.getText()+"'";
                koneksi.cn.executeUpdate(ed);
                koneksi.conn.close();
                d_anggota();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(this, "Proses Hapus Gagal");
            }
            }
            rs.close();
            koneksi.conn.close();
            d_anggota();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "Proses Hapus Gagal");
        }
        }
        tombol();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this,
                "Ingin Cetak Formulir ?",
                "Konfirmasi Cetak",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION){
                try{
                    java.util.Date tanggal = new java.util.Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    koneksi.koneksi();
                    String sql  ="INSERT INTO r_kk set no_reg='"+noreg.getText()+"',nokk='"+nokks.getText()+"',date='"+sdf.format(tanggal)+"'";
                    koneksi.cn.executeUpdate(sql);
                    koneksi.conn.close();
                    jumlah();
                    
                    try {
                        File file = new File("src/report/cf_kk.jrxml");
                        jasperDesign = JRXmlLoader.load(file);
                        //param.clear();
                        param.put("no", noreg.getText());
                        param.put("nokk", nokks.getText());
                        param.put("nkk", nkk);
                        param.put("alamat", ialamat);
                        param.put("rt", irt);
                        param.put("rw", irw);
                        param.put("jak", jak);
                        jasperReport = JasperCompileManager.compileReport(jasperDesign);
                        jasperPrint = JasperFillManager.fillReport(jasperReport, param, koneksi.getConnection());
                        JasperViewer.viewReport(jasperPrint, false);
                        
                    } catch (Exception e){
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Cetak Gagal "+e.getMessage());
                    }
                    
                    this.dispose();
                    
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, "Gagal");
                    System.out.println(e.getMessage());
                }
                
            }else if (confirm == JOptionPane.NO_OPTION){
                try{
                    java.util.Date tanggal = new java.util.Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    koneksi.koneksi();
                    String sql  ="INSERT INTO r_kk set no_reg='"+noreg.getText()+"',nokk='"+nokks.getText()+"',date='"+sdf.format(tanggal)+"'";
                    koneksi.cn.executeUpdate(sql);
                    koneksi.conn.close();
                    autono();
                    autonokks();
                    d_anggota();
                    reset();
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, "Gagal");
                    System.out.println(e.getMessage());
                }
                
            }
        
    }//GEN-LAST:event_jButton2ActionPerformed

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

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jLabel4MouseDragged

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
            java.util.logging.Logger.getLogger(Input_kk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Input_kk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Input_kk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Input_kk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Input_kk dialog = new Input_kk(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField alamat;
    private desa_ciapus.Bg_rkk bg_rkk1;
    private javax.swing.JLabel exit;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nama;
    private javax.swing.JComboBox<String> nik;
    private javax.swing.JTextField nokks;
    private javax.swing.JTextField noreg;
    private javax.swing.JTextField rt;
    private javax.swing.JTextField rw;
    // End of variables declaration//GEN-END:variables
}
