/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desa_ciapus;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Future
 */
public class Koneksi {
    
    public Connection conn;
    public Statement cn;
    public ResultSet res;
    public PreparedStatement pst;
    
    Connection connection;
    String host,port,db,user,pass,url;
    
    public Connection koneksi(){
        try{
            host = Ss_user.getHost();
            port = Ss_user.getPort();
            db = Ss_user.getDb();
            user = Ss_user.getIuser();
            pass = Ss_user.getIpass();
            url = "jdbc:mysql://"+host+":"+port+"/"+db;
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url,user,pass);
            cn=conn.createStatement();
        } catch(ClassNotFoundException | SQLException e) {          
            JOptionPane.showMessageDialog(null, "koneksi gagal....");
            System.out.println(e.getMessage());
            System.out.println(Ss_user.getHost()+","+Ss_user.getPort()+","+Ss_user.getDb()+","+Ss_user.getIuser()+","+Ss_user.getIpass());
        }
        return conn;
    }

    public Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Koneksi Oke");
            } catch (Exception e){
            }
        return connection;
    }
}
