/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desa_ciapus;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author FUTURE-PC
 */
public class Bg_db extends JPanel{
    private Image image; // membuat variable image
     public Bg_db() {
        image = new ImageIcon(getClass().getResource("/images/db.png")).getImage();
        //memanggil sumber daya gambar
    }
     @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
     
        Graphics gd = (Graphics2D) g.create();
     
        gd.drawImage(image, 0,0,getWidth(),getHeight(), this);
        // menggambar image
        gd.dispose();
    }
    
}
