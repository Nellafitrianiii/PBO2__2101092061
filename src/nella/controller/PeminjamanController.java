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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import nella.dao.AnggotaDao;
import nella.dao.AnggotaDaoImpl;
import nella.dao.BukuDao;
import nella.dao.BukuDaoImpl;
import nella.dao.Koneksi;
import nella.dao.PeminjamanDao;
import nella.dao.PeminjamanDaoImpl;
import nella.model.Anggota;
import nella.model.Buku;
import nella.model.Peminjaman;
import nella.view.FormPeminjaman;

/**
 *
 * @author Asus
 */
public class PeminjamanController {
    private FormPeminjaman formPinjam;
    private Peminjaman pinjam;
    private PeminjamanDao pinjamDao;
    private AnggotaDao angggotaDao;
    private BukuDao bukuDao;
    private Connection con;
    private Koneksi k;

    public PeminjamanController(FormPeminjaman formPinjam) {
        try {
            this.formPinjam = formPinjam;
            pinjamDao = new PeminjamanDaoImpl();
            angggotaDao = new AnggotaDaoImpl();
            bukuDao = new BukuDaoImpl();
            Koneksi k = new Koneksi();
            con = k.getkoneksi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void clearForm(){
        formPinjam.getTxtTglpinjam().setText("");
        formPinjam.getTxtTglkembali().setText("");
    }
    
    public void isiCombo(){
        try {
            formPinjam.getCboKodeanggota().removeAllItems();
            formPinjam.getCboKodebuku().removeAllItems();
            List<Anggota> anggotaList = angggotaDao.getAllAnggota(con);
            List<Buku> bukuList = bukuDao.getAllBuku(con);
            for (Anggota anggota : anggotaList){
                formPinjam.getCboKodeanggota().addItem(anggota.getKodeAnggota()+"-"+anggota.getNamaAnggota());
            }
            for (Buku buku : bukuList){
                formPinjam.getCboKodebuku().addItem(buku.getKodebuku());
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insert(){
        try {
            pinjam = new Peminjaman();
            pinjam.setKodeAnggota(formPinjam.getCboKodeanggota().getSelectedItem().toString().split("-")[0]);
            pinjam.setKodebuku(formPinjam.getCboKodebuku().getSelectedItem().toString());
            pinjam.setTglpinjam(formPinjam.getTxtTglpinjam().getText());
            pinjam.setTglkembali(formPinjam.getTxtTglkembali().getText());
            pinjamDao.insert(con,pinjam);
            JOptionPane.showMessageDialog(formPinjam, "Entri Data OK!");
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void getPeminjaman(){
        String kodeanggota = formPinjam.getTblPeminjaman().getValueAt(formPinjam.getTblPeminjaman().getSelectedRow(),0).toString();
        String kodebuku = formPinjam.getTblPeminjaman().getValueAt(formPinjam.getTblPeminjaman().getSelectedRow(),1).toString();
        String tglpinjam = formPinjam.getTblPeminjaman().getValueAt(formPinjam.getTblPeminjaman().getSelectedRow(),2).toString();
        pinjam = pinjamDao.getPeminjaman(con, kodeanggota, kodebuku, tglpinjam);
        if(pinjam!=null){
            try {
                Anggota anggota = angggotaDao.getAnggota(con,pinjam.getKodeAnggota());
                formPinjam.getCboKodeanggota().setSelectedItem(anggota.getKodeAnggota()+"-"+anggota.getNamaAnggota());
                formPinjam.getCboKodebuku().setSelectedItem(pinjam.getKodebuku());
                formPinjam.getTxtTglpinjam().setText(pinjam.getTglpinjam());
                formPinjam.getTxtTglkembali().setText(pinjam.getTglkembali());
            } catch (Exception ex) {
                Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void update(){
        try {
            pinjam = new Peminjaman();
            pinjam.setKodeAnggota(formPinjam.getCboKodeanggota().getSelectedItem().toString().split("-")[0]);
            pinjam.setKodebuku(formPinjam.getCboKodebuku().getSelectedItem().toString());
            pinjam.setTglpinjam(formPinjam.getTxtTglpinjam().getText());
            pinjam.setTglkembali(formPinjam.getTxtTglkembali().getText());
            pinjamDao.update(con, pinjam);
            JOptionPane.showMessageDialog(formPinjam, "Update data OK!");
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(){
        try {
            pinjamDao.delete(con, pinjam);
            JOptionPane.showMessageDialog(formPinjam, "Delete Ok!");
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cari(){
        
    }
    
    public void tampil(){
        try {
            DefaultTableModel tabel = (DefaultTableModel) formPinjam.getTblPeminjaman().getModel();
            tabel.setRowCount(0);
            List<Peminjaman> list = pinjamDao.getAllPeminjaman(con);
            for (Peminjaman pinjam1 : list){
                Object[] row = {
                    pinjam1.getKodeAnggota(),
                    pinjam1.getKodebuku(),
                    pinjam1.getTglpinjam(),
                    pinjam1.getTglkembali()
                };
                tabel.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
