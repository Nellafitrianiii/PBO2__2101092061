/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nella.model;

/**
 *
 * @author Asus
 */
public class Buku {
    private String kodebuku;
    private String judulbuku;
    private String Pengarang;
    private String penerbit;

    public Buku() {
    }

    public Buku(String kodebuku, String judulbuku, String Pengarang, String penerbit) {
        this.kodebuku = kodebuku;
        this.judulbuku = judulbuku;
        this.Pengarang = Pengarang;
        this.penerbit = penerbit;
    }

    public String getKodebuku() {
        return kodebuku;
    }

    public void setKodebuku(String kodebuku) {
        this.kodebuku = kodebuku;
    }

    public String getJudulbuku() {
        return judulbuku;
    }

    public void setJudulbuku(String judulbuku) {
        this.judulbuku = judulbuku;
    }

    public String getPengarang() {
        return Pengarang;
    }

    public void setPengarang(String Pengarang) {
        this.Pengarang = Pengarang;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }
    
    
}
