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
import nella.dao.BukuDao;
import nella.dao.BukuDaoImpl;
import nella.dao.Koneksi;
import nella.model.Buku;
import nella.view.FormBuku;

/**
 *
 * @author Asus
 */
public class BukuController {
    private FormBuku formbuku;
    private Buku buku;
    private BukuDao bukuDao;
    private Connection con;
    private Koneksi k;

    public BukuController(FormBuku formbuku) {
        try {
            this.formbuku = formbuku;
            bukuDao = new BukuDaoImpl();
            k = new Koneksi();
            con = k.getkoneksi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    
    public void clearForm(){
        formbuku.getTxtKodebuku().setText("");
        formbuku.getTxtJudulbuku().setText("");
        formbuku.getTxtPengarang().setText("");
        formbuku.getTxtPenerbit().setText("");
    }
    
    public void insert(){
        try {
            buku = new Buku();
            buku.setKodebuku(formbuku.getTxtKodebuku().getText());
            buku.setJudulbuku(formbuku.getTxtJudulbuku().getText());
            buku.setPengarang(formbuku.getTxtPengarang().getText());
            buku.setPenerbit(formbuku.getTxtPenerbit().getText());
            bukuDao.insert(con,buku);
            JOptionPane.showMessageDialog(formbuku, "Entri ok");
        } catch (Exception ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(){
        try {
            buku = new Buku();
            buku.setKodebuku(formbuku.getTxtKodebuku().getText());
            buku.setJudulbuku(formbuku.getTxtJudulbuku().getText());
            buku.setPengarang(formbuku.getTxtPengarang().getText());
            buku.setPenerbit(formbuku.getTxtPenerbit().getText());
            bukuDao.update(con, buku);
            JOptionPane.showMessageDialog(formbuku,"Update Ok");
        } catch (Exception ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(){
        try {
            bukuDao.delete(con, buku);
            JOptionPane.showMessageDialog(formbuku,"Delete Ok");
                    } catch (Exception ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cari(){
        try {
            String kode = formbuku.getTxtKodebuku().getText();
            buku = bukuDao.getBuku(con, kode);
            if(buku != null){
                formbuku.getTxtJudulbuku().setText(buku.getJudulbuku());
                formbuku.getTxtPengarang().setText(buku.getPengarang());
                formbuku.getTxtPenerbit().setText(buku.getPenerbit());
            }else{
                JOptionPane.showMessageDialog(formbuku, "Data Tidak Ditemukan");
            }
        } catch (Exception ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Tampil(){
        try {
            DefaultTableModel tabel = (DefaultTableModel) formbuku.getTblBuku().getModel();
            tabel.setRowCount(0);;
            List<Buku> list = bukuDao.getAllBuku(con);
            for(Buku buku1 : list){
                Object[] row = {
                    buku1.getKodebuku(),
                    buku1.getJudulbuku(),
                    buku1.getPengarang(),
                    buku1.getPenerbit()
                };
                tabel.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
    

