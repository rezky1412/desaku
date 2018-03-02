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
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class Input_kkp extends javax.swing.JDialog {
        
    Koneksi koneksi = new Koneksi();
    JasperReport jasperReport;
    JasperDesign jasperDesign;
    JasperPrint jasperPrint;
    Map<String, Object> param = new HashMap <String, Object>();
    
    String jak;
    int xMouse,yMouse;
    
    Autonik Autonik = new Autonik();

    /**
     * Creates new form Input_kkp
     */
    public Input_kkp(java.awt.Frame parent, boolean modal) {
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
        
        nokk.getEditor().getEditorComponent().addKeyListener(new KeyAdapter(){
        
        @Override
        public void keyReleased(KeyEvent evt){
        
            String biodata2=nokk.getEditor().getItem().toString();
            
            if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            isi2(biodata2);
            }
            
            if(evt.getKeyCode()>=65 && evt.getKeyCode()<=90 || evt.getKeyCode()>=96 && evt.getKeyCode()<=105 || evt.getKeyCode()==8){}
            
                nokk.setModel(Autonik.getList2(biodata2));
                if(nokk.getItemCount()>0){
                
                    nokk.showPopup();
                    if(evt.getKeyCode()!=8){
                    
                        ((JTextComponent)nokk.getEditor().getEditorComponent()).select(biodata2.length(), nokk.getEditor().getItem().toString().length());
                        
                    }else{
                    nokk.getEditor().setItem(biodata2);
                    }
                    
                }else{
                nokk.addItem(biodata2);
                }
            
        }    
            
        });
        
        autono();
        d_anggota();
        tombol();
    }
    
    private void jumlah(){
        try {
            koneksi.koneksi();
            String sql = "SELECT COUNT(nama) FROM warga WHERE nokk ='"+nokk.getSelectedItem()+"'";
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
    
    public void isi2(String no_kk){
        String data[]=Autonik.isi2(no_kk);
        if(data[0]!=null){
        nkk.setText(data[1]);
        alamat.setText(data[2]);
        rt.setText(data[3]);
        rw.setText(data[4]);
        d_anggota();
        tombol();
        }else{
            JOptionPane.showMessageDialog(null, "No KK belum Pernah Terdaftar");
        }
        
    }
    
    public void isi(String nik){
        String data[]=Autonik.isi(nik);
        if(data[0]!=null){
        nama.setText(data[1]);
        id.setText(data[0]);
    }else{
        JOptionPane.showMessageDialog(null, "No NIK belum Pernah Terdaftar, Silahkan Input Data Warga");
    }
    }
    
    private void tombol(){
        if(jTable1.getRowCount()>0){
            jButton2.setEnabled(true);
            nik.setEnabled(true);
        }else{
            jButton2.setEnabled(false);
            nik.setEnabled(false);
        }    
    }
    
    private void d_anggota(){
        DefaultTableModel tbla = new DefaultTableModel();
        tbla.addColumn("Nama Anggota");
        try{
            koneksi.koneksi();
            String sql="SELECT nama FROM warga WHERE nokk ='"+nokk.getSelectedItem()+"'";
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
        jLabel4 = new javax.swing.JLabel();
        noreg = new javax.swing.JTextField();
        nokk = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        nik = new javax.swing.JComboBox<>();
        nama = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        rt = new javax.swing.JTextField();
        rw = new javax.swing.JTextField();
        alamat = new javax.swing.JTextField();
        nkk = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REGISTRASI KK LAMA");
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

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("NAMA");

        noreg.setEditable(false);

        nokk.setEditable(true);

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

        nik.setEditable(true);
        nik.setEnabled(false);

        nama.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("NO REGISTRASI");

        jButton1.setText("MASUKKAN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("NO KK");

        jButton2.setText("CETAK");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("NIK");

        jLabel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel5MouseDragged(evt);
            }
        });
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });

        javax.swing.GroupLayout bg_rkk1Layout = new javax.swing.GroupLayout(bg_rkk1);
        bg_rkk1.setLayout(bg_rkk1Layout);
        bg_rkk1Layout.setHorizontalGroup(
            bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_rkk1Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(exit)
                .addContainerGap())
            .addGroup(bg_rkk1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bg_rkk1Layout.createSequentialGroup()
                        .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(41, 41, 41)
                        .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(noreg)
                            .addComponent(nokk, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bg_rkk1Layout.createSequentialGroup()
                        .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(98, 98, 98)
                        .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nik, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(bg_rkk1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(bg_rkk1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rw, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bg_rkk1Layout.createSequentialGroup()
                        .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bg_rkk1Layout.createSequentialGroup()
                        .addComponent(nkk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))))
        );
        bg_rkk1Layout.setVerticalGroup(
            bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_rkk1Layout.createSequentialGroup()
                .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bg_rkk1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(noreg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nokk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bg_rkk1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addGap(18, 18, 18)
                .addGroup(bg_rkk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rt, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rw, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nkk, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 36, Short.MAX_VALUE))
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
                    String sql  ="INSERT INTO r_kk set no_reg='"+noreg.getText()+"',nokk='"+nokk.getSelectedItem()+"',date='"+sdf.format(tanggal)+"'";
                    koneksi.cn.executeUpdate(sql);
                    koneksi.conn.close();
                    jumlah();
                    
                    try {
                        File file = new File("src/report/cf_kk.jrxml");
                        jasperDesign = JRXmlLoader.load(file);
                        //param.clear();
                        param.put("no", noreg.getText());
                        param.put("nokk", nokk.getSelectedItem());
                        param.put("nkk", nkk.getText());
                        param.put("alamat", alamat.getText());
                        param.put("rt", rt.getText());
                        param.put("rw", rw.getText());
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
                    String sql  ="INSERT INTO r_kk set no_reg='"+noreg.getText()+"',nokk='"+nokk.getSelectedItem()+"',date='"+sdf.format(tanggal)+"'";
                    koneksi.cn.executeUpdate(sql);
                    koneksi.conn.close();
                    autono();
                    nokk.setSelectedItem("");
                    d_anggota();
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, "Gagal");
                    System.out.println(e.getMessage());
                }
                
            }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
            koneksi.koneksi();
            String sql="UPDATE warga set nokk='"+nokk.getSelectedItem()+"' WHERE id_warga='"+id.getText()+"'";
            koneksi.cn.executeUpdate(sql);
            koneksi.conn.close();
            d_anggota();
            nama.setText("");
            id.setText("");
            nik.setSelectedItem("");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Gagal");
            System.out.println(e.getMessage());
        }   
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
            String cek ="SELECT warga.nama FROM warga, k_kk WHERE warga.id_warga=k_kk.id_warga AND warga.nama ='"+a+"' AND k_kk.nokk = '"+nokk.getSelectedItem()+"'";
            ResultSet rs = koneksi.cn.executeQuery(cek);
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Kepala Keluarga Tidak Dapat Dihapus");
            }else {
                try {
                koneksi.koneksi();
                String ed ="UPDATE warga set nokk='' WHERE nama='"+a+"' AND nokk ='"+nokk.getSelectedItem()+"'";
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

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jLabel5MousePressed

    private void jLabel5MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jLabel5MouseDragged

    private void exitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseReleased
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_exitMouseReleased

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
            java.util.logging.Logger.getLogger(Input_kkp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Input_kkp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Input_kkp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Input_kkp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Input_kkp dialog = new Input_kkp(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nama;
    private javax.swing.JComboBox<String> nik;
    private javax.swing.JTextField nkk;
    private javax.swing.JComboBox<String> nokk;
    private javax.swing.JTextField noreg;
    private javax.swing.JTextField rt;
    private javax.swing.JTextField rw;
    // End of variables declaration//GEN-END:variables
}
