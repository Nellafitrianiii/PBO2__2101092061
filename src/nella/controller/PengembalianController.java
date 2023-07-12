/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nella.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import nella.dao.AnggotaDao;
import nella.dao.AnggotaDaoImpl;
import nella.dao.BukuDao;
import nella.dao.BukuDaoImpl;
import nella.dao.Koneksi;
import nella.dao.PeminjamanDao;
import nella.dao.PeminjamanDaoImpl;
import nella.dao.PengembalianDao;
import nella.dao.PengembalianDaoImpl;
import nella.model.Anggota;
import nella.model.Peminjaman;
import nella.model.Pengembalian;
import nella.view.FormPengembalian;

/**
 *
 * @author Asus
 */
public class PengembalianController {
    FormPengembalian formPengembalian;
    AnggotaDao anggotaDao;
    BukuDao bukuDao;
    PeminjamanDao pinjamDao;
    PengembalianDao pengembalianDao;
    Pengembalian pengembalian;
    Connection con;

    public PengembalianController(FormPengembalian formPengembalian) {
        try {
            this.formPengembalian = formPengembalian;
            anggotaDao = new AnggotaDaoImpl();
            bukuDao = new BukuDaoImpl();
            pinjamDao = new PeminjamanDaoImpl();
            pengembalianDao = new PengembalianDaoImpl();
            Koneksi k = new Koneksi();
            con = k.getkoneksi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void clearForm(){
        formPengembalian.getTxtTglPinjam().setText("");
        formPengembalian.getTxtTglKembali().setText("");
        formPengembalian.getTxttglDikembalikan().setText("");
        formPengembalian.getTxtTerlambat().setText("");
        formPengembalian.getTxtDenda().setText("");
        formPengembalian.getTxtKodeanggota().setText("");
        formPengembalian.getTxtKodebuku().setText("");
    }
    
    public void tampil(){
        try {
            DefaultTableModel tabel = (DefaultTableModel) formPengembalian.getTabelPengembalian().getModel();
            tabel.setRowCount(0);
            List<Pengembalian> list = pengembalianDao.getAllPengembalian(con);
            for(Pengembalian p : list){
                Anggota anggota = anggotaDao.getAnggota(con, p.getKodeAnggota());
                Peminjaman pinjam = pinjamDao.getPeminjaman(con, p.getKodeAnggota(), p.getKodebuku(), p.getTglpinjam());
                Object[]row = {
                    p.getKodeAnggota(),
                    anggota.getNamaAnggota(),
                    p.getKodebuku(),
                    pinjam.getTglpinjam(),
                    pinjam.getTglkembali(),
                    p.getTgldikembalikan(),
                    p.getTerlambat(),
                    p.getDenda()
                };
                tabel.addRow(row);  
            }
        } catch (Exception ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
        
        
    
    public void getPengembalian(){
        try {
            String kodeanggota = formPengembalian.getTabelPengembalian().getValueAt(formPengembalian.getTabelPengembalian().getSelectedRow(), 0).toString();
            String kodebuku = formPengembalian.getTabelPengembalian().getValueAt(formPengembalian.getTabelPengembalian().getSelectedRow(), 2).toString();
            String tglpinjam = formPengembalian.getTabelPengembalian().getValueAt(formPengembalian.getTabelPengembalian().getSelectedRow(), 3).toString();
            pengembalian = new Pengembalian();
            Peminjaman pinjam = pinjamDao.getPeminjaman(con, kodeanggota, kodebuku, tglpinjam);
            int terlambat = pengembalianDao.selisihTanggal(con,pengembalian.getTgldikembalikan(),pinjam.getTglkembali());
            pengembalian.setTerlambat(terlambat);
            double denda = pengembalian.getDenda();
            formPengembalian.getTxtKodeanggota().setText(kodeanggota);
            formPengembalian.getTxtKodebuku().setText(kodebuku);
            formPengembalian.getTxtTglPinjam().setText(tglpinjam);
            formPengembalian.getTxtTglKembali().setText(pinjam.getTglkembali());
            formPengembalian.getTxttglDikembalikan().setText(pengembalian.getTgldikembalikan());
            formPengembalian.getTxtTerlambat().setText(terlambat+"");
            formPengembalian.getTxtDenda().setText(denda+"");
        } catch (Exception ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    

    
    
    
    



