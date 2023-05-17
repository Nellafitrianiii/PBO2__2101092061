/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts_a.model;

/**
 *
 * @author Asus
 */
public class Pln {
    private String kodepelanggan;
    private String nampelanggan;
    private String Mbi;
    private String Mbl;
    private Double tarif;
    private Double potongan;
    private Double total;

    
    public Pln() {
    }

    public Pln(String kodepelanggan, String nampelanggan, String Mbi, String Mbl, Double tarif, Double potongan, Double total) {
        this.kodepelanggan = kodepelanggan;
        this.nampelanggan = nampelanggan;
        this.Mbi = Mbi;
        this.Mbl = Mbl;
        this.tarif = tarif;
        this.potongan = potongan;
        this.total = total;
    }

    public String getKodepelanggan() {
        return kodepelanggan;
    }

    public void setKodepelanggan(String kodepelanggan) {
        this.kodepelanggan = kodepelanggan;
    }

    public String getNampelanggan() {
        return nampelanggan;
    }

    public void setNampelanggan(String nampelanggan) {
        this.nampelanggan = nampelanggan;
    }

    public String getMbi() {
        return Mbi;
    }

    public void setMbi(String Mbi) {
        this.Mbi = Mbi;
    }

    public String getMbl() {
        return Mbl;
    }

    public void setMbl(String Mbl) {
        this.Mbl = Mbl;
    }

    public Double getTarif() {
        return tarif;
    }

    public void setTarif(Double tarif) {
        this.tarif = tarif;
    }

    public Double getPotongan() {
        return potongan;
    }

    public void setPotongan(Double potongan) {
        this.potongan = potongan;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    
}
