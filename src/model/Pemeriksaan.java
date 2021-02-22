/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Leonardo
 */
public class Pemeriksaan {
    
    private String kodeBayi;
    private Integer beratBdn;
    private Integer tinggiBdn;
    private String tglPemeriksaan;
    private String kodePetugas;
    private String keterangan;
       
    public Pemeriksaan(String kodeBayi, int beratBdn, int tinggiBdn, String tglPemeriksaan, String kodePetugas, String keterangan){
        this.kodeBayi = kodeBayi;
        this.beratBdn = beratBdn;
        this.tinggiBdn = tinggiBdn;
        this.tglPemeriksaan = tglPemeriksaan;
        this.kodePetugas = kodePetugas;
        this.keterangan = keterangan;
    }
    
    public Pemeriksaan(String kodeBayi){
        this.kodeBayi = kodeBayi;
    }
    
    public String getKodeBayi(){
        return kodeBayi;
    }
    
    public void setKodeBayi(String kodeBayi){
        this.kodeBayi = kodeBayi;
    }
//    public String getNamaBayi(){
//        return namaBayi;
//    }
//    
//    public void setNamaBayi(String namaBayi){
//        this.namaBayi = namaBayi;
//    }  
//    public String toString(){
//        return this.namaBayi;
//    }

    public Integer getBeratBdn() {
        return beratBdn;
    }

    public String getTglPemeriksaan() {
        return tglPemeriksaan;
    }

    public Integer getTinggiBdn() {
        return tinggiBdn;
    }

    public String getKdPetugas() {
        return kodePetugas;
    }

    public String getKeterangan() {
        return keterangan;
    }
}
