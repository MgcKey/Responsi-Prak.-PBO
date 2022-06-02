package Movie;

import java.sql.*;
import javax.swing.*;

public class model {
    String DBurl = "jdbc:mysql://localhost/movie_db";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;

    public model() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            System.out.println("Koneksi gagal");
        }
    }
    
    public int getBanyakData(){
        int jumlahData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM movie";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jumlahData++;
            }
            return jumlahData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public String [][] listFilm(){
        try{
            int jumlahData = 0;
            String data[][] = new String[getBanyakData()][5]; 
            String query = "SELECT * FROM movie"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jumlahData][0] = resultSet.getString("judul"); 
                data[jumlahData][1] = resultSet.getString("alur");                
                data[jumlahData][2] = resultSet.getString("penokohan");
                data[jumlahData][3] = resultSet.getString("akting");
                data[jumlahData][4] = resultSet.getString("nilai");
                jumlahData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void tambahFilm(String judul, String alur, String penokohan, String akting){
        int jumlahData=0;
        double fAlur = Double.parseDouble(alur);
        double fPenokohan = Double.parseDouble(penokohan);
        double fAkting = Double.parseDouble(akting);
        double nilai = (fAlur + fPenokohan +fAkting) / 3;
        try {
           String query = "SELECT * FROM movie WHERE judul = '" + judul + "' "; 
           ResultSet resultSet = statement.executeQuery(query);
           while (resultSet.next()){ 
                jumlahData++;
            }    
            if (jumlahData==0) {
                query = "INSERT INTO movie VALUES('"+judul+"','"+fAlur+"','"+fPenokohan+"','"+fAkting+"','"+nilai+"')";
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query);
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data film berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data film sudah ada");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());   
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void updateFilm(String judul, String alur, String penokohan, String akting){
        int jumlahData=0;
        double fAlur = Double.parseDouble(alur);
        double fPenokohan = Double.parseDouble(penokohan);
        double fAkting = Double.parseDouble(akting);
        double nilai = (fAlur + fPenokohan +fAkting) / 3;
        try {
           String query = "SELECT * FROM movie WHERE judul = '" + judul + "' "; 
           ResultSet resultSet = statement.executeQuery(query);
           while (resultSet.next()){ 
                jumlahData++;
            }    
            if (jumlahData==0) {
                JOptionPane.showMessageDialog(null, "Data film tidak tersedia");
            }
            else {
                query = "UPDATE movie SET alur='" + fAlur + "', penokohan='" + fPenokohan + "', akting='" + fAkting + "', nilai = '" + nilai +"' WHERE judul='" + judul +"'";
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Data film berhasil diperbaharui");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());   
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void hapusFilm(String judul){
        try{
            String query = "DELETE FROM movie WHERE judul = '"+judul+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data film berhasil dihapus");
            
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
}
