/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import desa_ciapus.Koneksi;
import desa_ciapus.Ss_user;
import dialog.Input_db;
import dialog.Input_profil;
import java.io.File;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Future
 */
public class Login extends javax.swing.JFrame {
    
    Koneksi koneksi = new Koneksi();
    
    int xMouse,yMouse;
    
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        tool();
    }
    
    private void tool(){
        File data = new File ("data.txt");
        if (data.exists()) {
            setting.setVisible(true);
        }else{
            setting.setVisible(false);
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

        bg_login1 = new desa_ciapus.Bg_login();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        geser = new javax.swing.JLabel();
        setting = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(15, 187, 191));
        jLabel1.setText("USERNAME");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(15, 187, 191));
        jLabel2.setText("PASSWORD");

        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(15, 187, 191));
        jButton1.setText("Log In");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit1.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel3MouseReleased(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mini1.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel4MouseReleased(evt);
            }
        });

        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });

        geser.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                geserMouseDragged(evt);
            }
        });
        geser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                geserMousePressed(evt);
            }
        });

        setting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setting.png"))); // NOI18N
        setting.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                settingMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                settingMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout bg_login1Layout = new javax.swing.GroupLayout(bg_login1);
        bg_login1.setLayout(bg_login1Layout);
        bg_login1Layout.setHorizontalGroup(
            bg_login1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_login1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(bg_login1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(66, 66, 66)
                .addGroup(bg_login1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(user)
                    .addGroup(bg_login1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addComponent(pass, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                .addContainerGap(111, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bg_login1Layout.createSequentialGroup()
                .addGroup(bg_login1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bg_login1Layout.createSequentialGroup()
                        .addComponent(geser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bg_login1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(setting)))
                .addContainerGap())
        );
        bg_login1Layout.setVerticalGroup(
            bg_login1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_login1Layout.createSequentialGroup()
                .addGroup(bg_login1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(geser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(127, 127, 127)
                .addGroup(bg_login1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(bg_login1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(setting)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_login1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_login1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        // TODO add your handling code here:
        ImageIcon ttekan = new ImageIcon(getClass().getResource("/images/exit1.png"));
        jLabel3.setIcon(ttekan);
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        // TODO add your handling code here:
        ImageIcon ttekan = new ImageIcon(getClass().getResource("/images/exit2.png"));
        jLabel3.setIcon(ttekan);
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseReleased
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this,
                "Yakin Untuk Keluar",
                "Konfirmasi Keluar Program",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
 
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel3MouseReleased

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        // TODO add your handling code here:
        ImageIcon ttekan = new ImageIcon(getClass().getResource("/images/mini1.png"));
        jLabel4.setIcon(ttekan);
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        // TODO add your handling code here:
        ImageIcon ttekan = new ImageIcon(getClass().getResource("/images/mini2.png"));
        jLabel4.setIcon(ttekan);
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseReleased
        // TODO add your handling code here:
        this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_jLabel4MouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        File data = new File ("data.txt");
        if(data.exists()){
            try {
                Scanner in = new Scanner (data);

                Vector<String> v = new Vector<String>();

                while (in.hasNextLine()) {
                    v.add(in.nextLine());
                }
                Ss_user.setHost(v.get(0));
                Ss_user.setPort(v.get(1));
                Ss_user.setDb(v.get(2));
                Ss_user.setIuser(v.get(3));
                Ss_user.setIpass(v.get(4));
                
                try {
                    if (user.getText().length()==0){
                        JOptionPane.showMessageDialog(rootPane, "Username Kosong");
                        user.requestFocus();
                    }else if (pass.getText().length()==0){
                        JOptionPane.showMessageDialog(rootPane, "Password Kosong");
                        pass.requestFocus();
                    }else{
                        try{
                            koneksi.koneksi();
                            koneksi.res=koneksi.cn.executeQuery("SELECT * FROM user WHERE username='"+user.getText()+"'");
                            if(koneksi.res.next()){
                                if(pass.getText().equals(koneksi.res.getString("password"))){
                                    Ss_user.setUser(koneksi.res.getString(2));
                                    Ss_user.setUser2(koneksi.res.getString(4));
                                    
                                    try {
                                        koneksi.koneksi();
                                        String sql = "SELECT * FROM profil_desa";
                                        ResultSet rs = koneksi.cn.executeQuery(sql);
                                        if (rs.next()) {
                                            new Index().show();
                                            this.dispose();                                            
                                        }else{
                                            new Input_profil(this, rootPaneCheckingEnabled).show();
                                        }
                                        rs.close();
                                        koneksi.conn.close();
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(rootPane,"Password Salah");
                                    pass.setText("");
                                    pass.requestFocus();
                                }
                            }else{
                                JOptionPane.showMessageDialog(rootPane,"Username belum terdaftar");
                                user.setText("");
                                pass.setText("");
                                user.requestFocus();
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(rootPane, "Database Problem");
                            System.out.println(e.getMessage());
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"File Tidak Ada");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Database Belum Dibuat, Silahkan Buat Dahulu Di Form Selanjutnya");
            new Input_db(this, rootPaneCheckingEnabled).show();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
        jButton1.doClick();
    }//GEN-LAST:event_passActionPerformed

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
        jButton1.doClick();
    }//GEN-LAST:event_userActionPerformed

    private void geserMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_geserMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xMouse, y - yMouse);
        
    }//GEN-LAST:event_geserMouseDragged

    private void geserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_geserMousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_geserMousePressed

    private void settingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingMouseEntered
        // TODO add your handling code here:
        ImageIcon ttekan = new ImageIcon(getClass().getResource("/images/setting_hover.png"));
        setting.setIcon(ttekan);
    }//GEN-LAST:event_settingMouseEntered

    private void settingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingMouseExited
        // TODO add your handling code here:
        ImageIcon ttekan = new ImageIcon(getClass().getResource("/images/setting.png"));
        setting.setIcon(ttekan);
    }//GEN-LAST:event_settingMouseExited

    private void settingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingMousePressed
        // TODO add your handling code here:
        ImageIcon ttekan = new ImageIcon(getClass().getResource("/images/setting_tekan.png"));
        setting.setIcon(ttekan);
    }//GEN-LAST:event_settingMousePressed

    private void settingMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingMouseReleased
        // TODO add your handling code here:
        ImageIcon ttekan = new ImageIcon(getClass().getResource("/images/setting_hover.png"));
        setting.setIcon(ttekan);
        
        new Input_db(this, rootPaneCheckingEnabled).show();
    }//GEN-LAST:event_settingMouseReleased

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        tool();
    }//GEN-LAST:event_formWindowGainedFocus

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private desa_ciapus.Bg_login bg_login1;
    private javax.swing.JLabel geser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField pass;
    private javax.swing.JLabel setting;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
