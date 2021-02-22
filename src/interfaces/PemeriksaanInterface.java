/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.Pemeriksaan;

/**
 *
 * @author Leonardo
 */
public interface PemeriksaanInterface {
    public boolean insert(Pemeriksaan p);
    public boolean update(Pemeriksaan p);
    public boolean delete(Pemeriksaan p);
    
    public List<Pemeriksaan> getAllPemeriksaan();
//    public Pemeriksaan getByID(String KodeBayi);
//    public List<Pemeriksaan> getByNama(String NamaBayi);
}
