/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import java.util.Observable;
import dao.PemeriksaanDAO;
import model.Pemeriksaan;
import model.OperasiCRUD;
import interfaces.PemeriksaanInterface;
/**
 *
 * @author Leonardo
 */
public class PemeriksaanController extends Observable{
   private PemeriksaanInterface dao = new PemeriksaanDAO();
    private OperasiCRUD crud;
    public void setDAO(PemeriksaanInterface p){
        dao = p;
    }
    
    public void setDml(Pemeriksaan p, OperasiCRUD c){
        boolean hasil = false;
        this.crud = c;
        switch(c){
            case INSERT: hasil = dao.insert(p);
                break;
            case UPDATE: hasil = dao.update(p);
                break;
            case DELETE: hasil = dao.delete(p);
                break;
        }
        setChanged();
        if(hasil){
            notifyObservers(p);
        }else{
            notifyObservers();
        }
    }
    public OperasiCRUD getCrudState(){
        return crud;
    }
    public List<Pemeriksaan> getAllPemeriksaan(){
        return dao.getAllPemeriksaan();
    }
}