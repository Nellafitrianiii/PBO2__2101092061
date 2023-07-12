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
public class Peminjaman {
    private String kodeAnggota;
    private String kodebuku;
    private String tglpinjam;
    private String tglkembali;
    public String getKodeanggota;

    public Peminjaman() {
    }

    public Peminjaman(String kodeanggota, String kodebuku, String tglpinjam, String tglkembali) {
        this.kodeAnggota = kodeAnggota;
        this.kodebuku = kodebuku;
        this.tglpinjam = tglpinjam;
        this.tglkembali = tglkembali;
    }

    public String getKodeAnggota() {
        return kodeAnggota;
    }

    public void setKodeAnggota(String kodeAnggota) {
        this.kodeAnggota = kodeAnggota;
    }

    public String getGetKodeanggota() {
        return getKodeanggota;
    }

    public String getKodebuku() {
        return kodebuku;
    }

    public void setKodebuku(String kodebuku) {
        this.kodebuku = kodebuku;
    }

    public String getTglpinjam() {
        return tglpinjam;
    }

    public void setTglpinjam(String tglpinjam) {
        this.tglpinjam = tglpinjam;
    }

    public String getTglkembali() {
        return tglkembali;
    }

    public void setTglkembali(String tglkembali) {
        this.tglkembali = tglkembali;
    }
    
    
}
