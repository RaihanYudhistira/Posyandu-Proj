/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Pemeriksaan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import interfaces.PemeriksaanInterface;
/**
 *
 * @author Leonardo
 */
public class PemeriksaanDAO implements PemeriksaanInterface{

    @Override
    public boolean insert(Pemeriksaan p) {
        String sql = "INSERT INTO pemeriksaan values (?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement statement = Koneksi.bukaKoneksi().prepareStatement(sql);
                statement.setString(1, p.getKodeBayi());
                statement.setInt(2, p.getBeratBdn());
                statement.setInt(3, p.getTinggiBdn());
                statement.setString(4, p.getTglPemeriksaan());
                statement.setString(5, p.getKdPetugas());
                statement.setString(6, p.getKeterangan());
            
            int row = statement.executeUpdate();
            if(row > 0){
                return true;
            }
            statement.close();
        }catch(Exception e){
            Logger.getLogger(Pemeriksaan.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean update(Pemeriksaan p) {
        String sql = "UPDATE pemeriksaan SET kdBayi =?, beratBdn=?, tinggiBdn=?, tglPemeriksaan=?, kdPetugas=?, keterangan=? WHERE kdBayi=?";
        try{
            PreparedStatement statement = Koneksi.bukaKoneksi().prepareStatement(sql);
            statement.setString(1, p.getKodeBayi());
            statement.setInt(2, p.getBeratBdn());
            statement.setInt(3, p.getTinggiBdn());
            statement.setString(4, p.getTglPemeriksaan());
            statement.setString(5, p.getKdPetugas());
            statement.setString(6, p.getKeterangan());
            statement.setString(7, p.getKodeBayi());
            
            int row = statement.executeUpdate();
            statement.close();
        }catch(Exception e){
            Logger.getLogger(Pemeriksaan.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean delete(Pemeriksaan p) {
        String sql ="DELETE FROM pemeriksaan WHERE kdBayi=?";
        try{
            PreparedStatement statement = Koneksi.bukaKoneksi().prepareStatement(sql);
            statement.setString(1, p.getKodeBayi());
            int row = statement.executeUpdate();
            statement.close();
        }catch(Exception e){
            Logger.getLogger(Pemeriksaan.class.getName()).log(Level.SEVERE, null, e);
    }
        return false;
    }

    @Override
    public List<Pemeriksaan> getAllPemeriksaan() {
       List<Pemeriksaan> pemeriksaan = new ArrayList<Pemeriksaan>();
        String sql = "SELECT * FROM pemeriksaan";
        try{
            if(Koneksi.bukaKoneksi()== null) {
                return null;
            }else{
                PreparedStatement statement = Koneksi.bukaKoneksi().prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
                while(rs.next()) {
                    Pemeriksaan j = new Pemeriksaan(rs.getString(1), rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6));
                    pemeriksaan.add(j);
                }
                statement.close();
            }
        }catch(Exception e) {
            Logger.getLogger(Pemeriksaan.class.getName()).log(Level.SEVERE, null, e);
        }
        return pemeriksaan;
    }

//    @Override
//    public Pemeriksaan getByID(String KodeBayi) {
//        throw new UnsupportedOperationException("Not supported yet."); 
//    }

//    @Override
//    public List<Pemeriksaan> getByNama(String NamaBayi) {
//        throw new UnsupportedOperationException("Not supported yet."); 
//    }
    
}
