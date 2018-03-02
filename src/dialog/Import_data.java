/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialog;
import desa_ciapus.Koneksi;
import java.io.*;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
//Apache POI Libraries
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 *
 * @author FUTURE-PC
 */
public class Import_data extends javax.swing.JDialog {
    
    Koneksi koneksi = new Koneksi();
    
    int xMouse,yMouse;

    /**
     * Creates new form Import_data
     */
    public Import_data(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cek();
    }
    
    private void cek(){
        if(jTextField1.getText().equals("")){
            jButton2.setEnabled(false);
        }else{
            jButton2.setEnabled(true);
        }
    }
    
    public static ArrayList readExcelFile(String fileName){
    
    ArrayList cellArrayLisstHolder = new ArrayList();

    try{
    /** Creating Input Stream**/
        FileInputStream myInput = new FileInputStream(fileName);

        /** Create a POIFSFileSystem object**/
        POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

        /** Create a workbook using the File System**/
        HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);

         /** Get the first sheet from workbook**/
        HSSFSheet mySheet = myWorkBook.getSheetAt(0);

        /** We now need something to iterate through the cells.**/
        Iterator rowIter = mySheet.rowIterator();
        while(rowIter.hasNext()){
            HSSFRow myRow = (HSSFRow) rowIter.next();
            Iterator cellIter = myRow.cellIterator();
            ArrayList cellStoreArrayList=new ArrayList();
            while(cellIter.hasNext()){
                HSSFCell myCell = (HSSFCell) cellIter.next();
                cellStoreArrayList.add(myCell);
            }
            cellArrayLisstHolder.add(cellStoreArrayList);
        }
    }catch (Exception e){
        e.printStackTrace(); 
    }
    return cellArrayLisstHolder;
    }
    
    public void importexcel(){
        // Nama dan Path File Excel
        String fileName = jTextField1.getText();
        String jk = null,gol = null, agama = null, skawin =null, pend=null;
        //Read an Excel File and Store in a ArrayList
        ArrayList dataHolder=readExcelFile(fileName);
        try {
            java.util.Date tanggal = new java.util.Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
            koneksi.koneksi();
            String query="insert into warga (nik, nama, kewarganegaraan, alamat, id_rt, id_rw, tempat_lahir, tanggal_lahir, id_jk, id_gol, id_agama, id_skawin, id_pendidikan, pekerjaan, nohp, date) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            koneksi.pst = koneksi.koneksi().prepareStatement(query);
            int count=0;
            ArrayList cellStoreArrayList=null;
            //insert into database
            for (int i=1;i < dataHolder.size(); i++) {
                cellStoreArrayList=(ArrayList)dataHolder.get(i);
                try{
                    Date tanggal2 = df.parse(((HSSFCell)cellStoreArrayList.get(8)).toString());
                    
                    koneksi.pst.setString(1,((HSSFCell)cellStoreArrayList.get(1)).toString());
                    koneksi.pst.setString(2,((HSSFCell)cellStoreArrayList.get(2)).toString());
                    koneksi.pst.setString(3,((HSSFCell)cellStoreArrayList.get(3)).toString());
                    koneksi.pst.setString(4,((HSSFCell)cellStoreArrayList.get(4)).toString());  
                    koneksi.pst.setString(5,((HSSFCell)cellStoreArrayList.get(5)).toString());  
                    koneksi.pst.setString(6,((HSSFCell)cellStoreArrayList.get(6)).toString());  
                    koneksi.pst.setString(7,((HSSFCell)cellStoreArrayList.get(7)).toString());  
                    koneksi.pst.setString(8,sdf.format(tanggal2));  
                    koneksi.pst.setString(9,((HSSFCell)cellStoreArrayList.get(9)).toString());  
                    koneksi.pst.setString(10,((HSSFCell)cellStoreArrayList.get(10)).toString());  
                    koneksi.pst.setString(11,((HSSFCell)cellStoreArrayList.get(11)).toString());  
                    koneksi.pst.setString(12,((HSSFCell)cellStoreArrayList.get(12)).toString());  
                    koneksi.pst.setString(13,((HSSFCell)cellStoreArrayList.get(13)).toString());  
                    koneksi.pst.setString(14,((HSSFCell)cellStoreArrayList.get(14)).toString());  
                    koneksi.pst.setString(15,((HSSFCell)cellStoreArrayList.get(15)).toString()); 
                    koneksi.pst.setString(16,sdf.format(tanggal)); 
                    //koneksi.pst.setString(urutan db dari 1,((HSSFCell)cellStoreArrayList.get(urutan excel dari 0)).toString());
                    count= koneksi.pst.executeUpdate();
                }catch (Exception e){
                    JOptionPane.showMessageDialog(this,"Gagal Membaca File \n"+e.getMessage());
                    System.out.println(e.getMessage());     
                } 
            }
            JOptionPane.showMessageDialog(this,"Import Sukses");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Import Gagal \n"+ex.getMessage());
            System.out.print(ex.getMessage());
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

        bg_import1 = new desa_ciapus.Bg_import();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jFileChooser1 = new javax.swing.JFileChooser();
        exit = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("IMPORT DATA");
        setUndecorated(true);

        jTextField1.setEditable(false);

        jButton1.setText("BROWSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("IMPOR");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("PILIH DATA");

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

        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel2MouseDragged(evt);
            }
        });
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        jButton3.setText("SAMPLE");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bg_import1Layout = new javax.swing.GroupLayout(bg_import1);
        bg_import1.setLayout(bg_import1Layout);
        bg_import1Layout.setHorizontalGroup(
            bg_import1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_import1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(bg_import1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(bg_import1Layout.createSequentialGroup()
                        .addGroup(bg_import1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(bg_import1Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3))
                            .addComponent(jFileChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bg_import1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exit)
                .addContainerGap())
        );
        bg_import1Layout.setVerticalGroup(
            bg_import1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bg_import1Layout.createSequentialGroup()
                .addGroup(bg_import1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(bg_import1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bg_import1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(bg_import1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(17, 17, 17)
                        .addGroup(bg_import1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3))))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_import1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_import1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jFileChooser1.setFileFilter(new FileNameExtensionFilter("XLS File", "xls"));
        int result = jFileChooser1.showOpenDialog(this);
        if(result==JFileChooser.APPROVE_OPTION){
            File file = jFileChooser1.getSelectedFile();
            jTextField1.setText(file.getPath());
        }
        cek();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        importexcel();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMousePressed
        // TODO add your handling code here:
        ImageIcon tekan = new ImageIcon(getClass().getResource("/images/exit2.png"));
        exit.setIcon(tekan);
    }//GEN-LAST:event_exitMousePressed

    private void exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseExited
        // TODO add your handling code here:
        ImageIcon tekan = new ImageIcon(getClass().getResource("/images/exit1.png"));
        exit.setIcon(tekan);
    }//GEN-LAST:event_exitMouseExited

    private void exitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseReleased
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_exitMouseReleased

    private void jLabel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jLabel2MouseDragged

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jLabel2MousePressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String tempat = null;
        
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("XLS File", "xls"));

        int r = chooser.showSaveDialog(this);
        if (r == JFileChooser.APPROVE_OPTION) {
            File sf = chooser.getSelectedFile();
            try {
                tempat = sf.getPath()+".xls";
                File SourceFile = new File("Data Warga.xls");
                File destinationFile = new File(tempat);
                Files.copy(SourceFile.toPath(), destinationFile.toPath());
                JOptionPane.showMessageDialog(this, "File Sample Berhasil Tersimpan");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        /*
        File SourceFile = new File("Data Warga.xls");
        File destinationFile = new File("Data Warga.xls");
        
        try {
            Files.copy(SourceFile.toPath(), destinationFile.toPath());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        */
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        // TODO add your handling code here:
        jButton3.setToolTipText("Download File Sample");
    }//GEN-LAST:event_jButton3MouseEntered

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
            java.util.logging.Logger.getLogger(Import_data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Import_data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Import_data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Import_data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Import_data dialog = new Import_data(new javax.swing.JFrame(), true);
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
    private desa_ciapus.Bg_import bg_import1;
    private javax.swing.JLabel exit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
