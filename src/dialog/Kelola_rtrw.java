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
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author FUTURE-PC
 */
public class Kelola_rtrw extends javax.swing.JDialog {
    
    Koneksi koneksi = new Koneksi();
    Autonik Autonik = new Autonik();
    
    int xMouse,yMouse;

    /**
     * Creates new form Input_warga
     */
    public Kelola_rtrw(java.awt.Frame parent, boolean modal) {
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
        
        nik2.getEditor().getEditorComponent().addKeyListener(new KeyAdapter(){
        
        @Override
        public void keyReleased(KeyEvent evt){
        
            String biodata=nik2.getEditor().getItem().toString();
            
            if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            isi(biodata);
            }
            
            if(evt.getKeyCode()>=65 && evt.getKeyCode()<=90 || evt.getKeyCode()>=96 && evt.getKeyCode()<=105 || evt.getKeyCode()==8){}
            
                nik2.setModel(Autonik.getList(biodata));
                if(nik2.getItemCount()>0){
                
                    nik2.showPopup();
                    if(evt.getKeyCode()!=8){
                    
                        ((JTextComponent)nik2.getEditor().getEditorComponent()).select(biodata.length(), nik2.getEditor().getItem().toString().length());
                        
                    }else{
                    nik2.getEditor().setItem(biodata);
                    }
                    
                }else{
                nik2.addItem(biodata);
                }
            
        }    
            
        });
        
        
        
        rt();
        rw();
    }
    
    public void isi(String nik){
        String data[]=Autonik.isi(nik);
        if(data[0]!=null){
        nrt.setText(data[1]);
        nrw.setText(data[1]);
        id.setText(data[0]);    
    }else{
        JOptionPane.showMessageDialog(null, "No NIK belum Pernah Terdaftar, Silahkan Input Data Warga");
    }
    }
    
    private void rt(){
        DefaultTableModel tbla = new DefaultTableModel();
        tbla.addColumn("RT");
        try{
            koneksi.koneksi();
            String sql="SELECT nama FROM rt";
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
    
    private void rw(){
        DefaultTableModel tbla = new DefaultTableModel();
        tbla.addColumn("RW");
        try{
            koneksi.koneksi();
            String sql="SELECT nama FROM rw";
            ResultSet rs=koneksi.cn.executeQuery(sql);
            while (rs.next())
            {
                tbla.addRow(new Object[]{
                rs.getString(1)
            });
            }
            jTable2.setModel(tbla);
            koneksi.conn.close();
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null,"Ada Kesalahan...."); 
            System.out.println(e.getMessage());
        }
    
    }
    
    
    private void b_angka(KeyEvent a){
        if(Character.isAlphabetic(a.getKeyChar())){
            a.consume();
            JOptionPane.showMessageDialog(null,"Hanya Boleh Angka");
        }
    }
    
    private void batasanrw(KeyEvent e){
        if(rw.getText().length()>=3){
            e.consume();
            JOptionPane.showMessageDialog(null,"RW Tidak Lebih Dari 3 Digit");
        }
    }
    
    private void batasanrt(KeyEvent e){
        if(rt.getText().length()>=3){
            e.consume();
            JOptionPane.showMessageDialog(null,"RT Tidak Lebih Dari 3 Digit");
        }
    }
    
    private void reset(){
        rt.setText("");
        rw.setText("");
        id.setText("");
        nik.setSelectedItem("");
        nik2.setSelectedItem("");
        nrt.setText("");
        nrw.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_rtrw1 = new desa_ciapus.Bg_rtrw();
        jLabel6 = new javax.swing.JLabel();
        nik2 = new javax.swing.JComboBox<>();
        rw = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nrw = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        rt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nrt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        nik = new javax.swing.JComboBox<>();
        exit = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        not = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("NAMA RW");

        nik2.setEditable(true);

        rw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rwKeyTyped(evt);
            }
        });

        jButton2.setText("TAMBAH");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable2);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("NIK");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("NAMA");

        nrw.setEditable(false);

        jButton4.setText("PILIH KETUA");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("NAMA RT");

        rt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rtKeyTyped(evt);
            }
        });

        jButton1.setText("TAMBAH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("NIK");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("NAMA");

        nrt.setEditable(false);
        nrt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nrtActionPerformed(evt);
            }
        });

        jButton3.setText("PILIH KETUA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        nik.setEditable(true);

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

        javax.swing.GroupLayout bg_rtrw1Layout = new javax.swing.GroupLayout(bg_rtrw1);
        bg_rtrw1.setLayout(bg_rtrw1Layout);
        bg_rtrw1Layout.setHorizontalGroup(
            bg_rtrw1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_rtrw1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(bg_rtrw1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bg_rtrw1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(bg_rtrw1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(bg_rtrw1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nrt)
                            .addGroup(bg_rtrw1Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(nik, 0, 184, Short.MAX_VALUE)))
                    .addGroup(bg_rtrw1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addComponent(rt, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton1)))
                .addGap(50, 50, 50))
            .addGroup(bg_rtrw1Layout.createSequentialGroup()
                .addGroup(bg_rtrw1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bg_rtrw1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(bg_rtrw1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bg_rtrw1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(rw, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton2))
                            .addGroup(bg_rtrw1Layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(bg_rtrw1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(bg_rtrw1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nrw)
                                    .addComponent(nik2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(bg_rtrw1Layout.createSequentialGroup()
                                        .addGroup(bg_rtrw1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton4)
                                            .addGroup(bg_rtrw1Layout.createSequentialGroup()
                                                .addComponent(not, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(28, 28, 28)
                                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(67, 67, 67))))))
                    .addGroup(bg_rtrw1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bg_rtrw1Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(exit)
                .addContainerGap())
        );
        bg_rtrw1Layout.setVerticalGroup(
            bg_rtrw1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_rtrw1Layout.createSequentialGroup()
                .addGroup(bg_rtrw1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(bg_rtrw1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(bg_rtrw1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bg_rtrw1Layout.createSequentialGroup()
                        .addGroup(bg_rtrw1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(bg_rtrw1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nrt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(bg_rtrw1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(bg_rtrw1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bg_rtrw1Layout.createSequentialGroup()
                        .addGroup(bg_rtrw1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(nik2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(bg_rtrw1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(nrw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)))
                .addGap(31, 31, 31)
                .addComponent(not, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_rtrw1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_rtrw1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rtKeyTyped
        // TODO add your handling code here:
        b_angka(evt);
        batasanrt(evt);
    }//GEN-LAST:event_rtKeyTyped

    private void rwKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rwKeyTyped
        // TODO add your handling code here:
        b_angka(evt);
        batasanrw(evt);
    }//GEN-LAST:event_rwKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
            koneksi.koneksi();
            String sql="INSERT INTO rt set nama='"+rt.getText()+"'";
            koneksi.cn.executeUpdate(sql);
            koneksi.conn.close();
            rt();
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "RT Tidak Boleh Sama");
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
            koneksi.koneksi();
            String sql="INSERT INTO rw set nama='"+rw.getText()+"'";
            koneksi.cn.executeUpdate(sql);
            koneksi.conn.close();
            rw();
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "RW Tidak Boleh Sama");
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int table=jTable1.getSelectedRow();
        //mengambil data dari table
        String a=jTable1.getValueAt(table,0).toString();
        not.setText(a);
             
         try {
                koneksi.koneksi();
                String sql ="SELECT warga.nama, warga.nik, rt.nama FROM warga, rt WHERE warga.id_warga=rt.id_warga AND rt.nama='"+not.getText()+"'";
                ResultSet rs = koneksi.cn.executeQuery(sql);
                if (rs.next()) {
                    nrt.setText(rs.getString(1));
                    nik.setSelectedItem(rs.getString(2));
                }else {
                    nrt.setText("Belum Ada Ketua");
                    nik.setSelectedItem("");
                }
                rs.close();
                koneksi.conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try{
            koneksi.koneksi();
            String sql="UPDATE rw set id_warga='"+id.getText()+"' WHERE nama='"+not.getText()+"'";
            koneksi.cn.executeUpdate(sql);
            koneksi.conn.close();
            reset();
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "GAGAL");
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int table=jTable2.getSelectedRow();
        //mengambil data dari table
        String a=jTable2.getValueAt(table,0).toString();
        not.setText(a);
        
        try {
                koneksi.koneksi();
                String sql ="SELECT warga.nama, warga.nik, rw.nama FROM warga, rw WHERE warga.id_warga=rw.id_warga AND rw.nama='"+not.getText()+"'";
                ResultSet rs = koneksi.cn.executeQuery(sql);
                if (rs.next()) {
                    nrw.setText(rs.getString(1));
                    nik2.setSelectedItem(rs.getString(2));
                }else {
                    nrw.setText("Belum Ada Ketua");
                    nik2.setSelectedItem("");
                }
                rs.close();
                koneksi.conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try{
            koneksi.koneksi();
            String sql="UPDATE rt set id_warga='"+id.getText()+"' WHERE nama='"+not.getText()+"'";
            koneksi.cn.executeUpdate(sql);
            koneksi.conn.close();
            reset();
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "GAGAL");
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseEntered

    private void nrtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nrtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nrtActionPerformed

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

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jLabel7MousePressed

    private void jLabel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jLabel7MouseDragged

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
            java.util.logging.Logger.getLogger(Kelola_rtrw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kelola_rtrw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kelola_rtrw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kelola_rtrw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Kelola_rtrw dialog = new Kelola_rtrw(new javax.swing.JFrame(), true);
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
    private desa_ciapus.Bg_rtrw bg_rtrw1;
    private javax.swing.JLabel exit;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox<String> nik;
    private javax.swing.JComboBox<String> nik2;
    private javax.swing.JTextField not;
    private javax.swing.JTextField nrt;
    private javax.swing.JTextField nrw;
    private javax.swing.JTextField rt;
    private javax.swing.JTextField rw;
    // End of variables declaration//GEN-END:variables
}
