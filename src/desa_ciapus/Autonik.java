/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desa_ciapus;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author FUTURE
 */
public class Autonik {
    Koneksi koneksi = new Koneksi();
    
    public DefaultComboBoxModel getList(String biodata){
    
        DefaultComboBoxModel modeli= new DefaultComboBoxModel();
        
        try {
            
            String query="SELECT nik from warga WHERE nik LIKE '"+biodata+"%' group by nik desc";
            
            koneksi.koneksi();
            koneksi.res=koneksi.cn.executeQuery(query);
            
            while(koneksi.res.next()){
                modeli.addElement(koneksi.res.getString("nik"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Autonik.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modeli;
    }
    
    public DefaultComboBoxModel getList2(String biodata2){
    
        DefaultComboBoxModel modeli= new DefaultComboBoxModel();
        
        try {
            
            String query="SELECT nokk from k_kk WHERE nokk LIKE '"+biodata2+"%' group by nokk desc";
            
            koneksi.koneksi();
            koneksi.res=koneksi.cn.executeQuery(query);
            
            while(koneksi.res.next()){
                modeli.addElement(koneksi.res.getString("nokk"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Autonik.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modeli;
    }
    
    public String[] isi(String nik){
        String[] data=new String[7];
        try {
            
            String query="SELECT warga.id_warga, warga.nama, warga.nik, warga.nokk, warga.alamat, rt.nama, rw.nama FROM warga, rt, rw WHERE warga.id_rt=rt.id_rt AND warga.id_rw=rw.id_rw AND nik='"+nik+"'";
            koneksi.koneksi();
            koneksi.res=koneksi.cn.executeQuery(query);
            while(koneksi.res.next()){
                for (int i = 0;i < data.length; i++){
                    data[i]=koneksi.res.getString(i+1);
                }
            }   
        } catch (SQLException ex) {
            return null;
        }
        return data; 
   }
    
    public String[] isi2(String no_kk){
        String[] data=new String[5];
        try {
            
            String query="SELECT k_kk.nokk, warga.nama, warga.alamat, rt.nama, rw.nama FROM k_kk, warga, rt, rw WHERE k_kk.id_warga=warga.id_warga AND warga.id_rt=rt.id_rt AND warga.id_rw=rw.id_rw AND k_kk.nokk='"+no_kk+"'";
            koneksi.koneksi();
            koneksi.res=koneksi.cn.executeQuery(query);
            while(koneksi.res.next()){
                for (int i = 0;i < data.length; i++){
                    data[i]=koneksi.res.getString(i+1);
                }
            }   
        } catch (SQLException ex) {
            return null;
        }
        return data; 
   }
    
}
