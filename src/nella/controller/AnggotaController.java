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
import nella.dao.Koneksi;
import nella.model.Anggota;
import nella.view.FormAnggota;

/**
 *
 * @author Asus
 */
public class AnggotaController {
    private FormAnggota formAnggota;
    private Anggota anggota;
    private AnggotaDao anggotaDao;
    private Connection con;
    private Koneksi koneksi;
    
    
    
    public AnggotaController(FormAnggota formAnggota){
        try {
            this.formAnggota = formAnggota;
            anggotaDao = new AnggotaDaoImpl();
            con = new Koneksi().getkoneksi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tabelKlik(){
        try {
            String kode = formAnggota.getTblAnggota().getValueAt(formAnggota.getTblAnggota().getSelectedRow(),0).toString();
            anggota = anggotaDao.getAnggota(con, kode);
            formAnggota.getTxtKodeAnggota().setText(anggota.getKodeAnggota());
            formAnggota.getTxtNama().setText(anggota.getNamaAnggota());
            formAnggota.getTxtAlamat().setText(anggota.getAlamat());
            formAnggota.getCboJenisKelamin().setSelectedItem(anggota.getJenisKelamin()); 
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insert(){
        try {
            anggota = new Anggota ();
            anggota.setKodeAnggota(
                    formAnggota.getTxtKodeAnggota().getText());
            anggota.setNamaAnggota(
                    formAnggota.getTxtNama().getText());
            anggota.setAlamat(
                    formAnggota.getTxtAlamat().getText());
            anggota.setJenisKelamin (
                    formAnggota.getCboJenisKelamin().getSelectedItem().toString());
            anggotaDao.insert(con,anggota);
            JOptionPane.showMessageDialog(formAnggota, "Entri Ok");
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Update (){
        try {
            anggota = new Anggota();
            anggota.setKodeAnggota(
                    formAnggota.getTxtKodeAnggota().getText());
            anggota.setNamaAnggota(
                    formAnggota.getTxtNama().getText());
            anggota.setAlamat(
                    formAnggota.getTxtAlamat().getText());
            anggota.setJenisKelamin (
                    formAnggota.getCboJenisKelamin().getSelectedItem().toString());
            anggotaDao.insert(con,anggota);
            JOptionPane.showMessageDialog(formAnggota, "Update Ok"); 
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(){
        try {
            anggotaDao.delete(con, anggota);
            JOptionPane.showMessageDialog(formAnggota,"Delete Ok");
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cari(){
        try {
            String kode = formAnggota.getTxtKodeAnggota().getText();
            anggota = anggotaDao.getAnggota(con, kode);
            if(anggota != null){
                formAnggota.getTxtNama().setText(anggota.getNamaAnggota());
                formAnggota.getTxtAlamat().setText(anggota.getAlamat());
                formAnggota.getCboJenisKelamin().setSelectedItem(anggota.getJenisKelamin());
            }else{
                JOptionPane.showMessageDialog(formAnggota,"Data Tidak Ada");
            }
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tampil(){
        try {
            DefaultTableModel tabel = (DefaultTableModel) formAnggota.getTblAnggota().getModel();
            tabel.setRowCount(0);
            List<Anggota> list = anggotaDao.getAllAnggota(con);
            for (Anggota anggota1 : list){
                Object[] row = {
                    anggota1.getKodeAnggota(),
                    anggota1.getNamaAnggota(),
                    anggota1.getJenisKelamin()
                };
                tabel.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void clearForm(){
        formAnggota.getTxtKodeAnggota().setText("");
        formAnggota.getTxtNama().setText("");
        formAnggota.getTxtAlamat().setText("");
    }
    
    public void isiCboJenisKelamin(){
        formAnggota.getCboJenisKelamin().removeAllItems();
        formAnggota.getCboJenisKelamin().addItem("L");
        formAnggota.getCboJenisKelamin().addItem("P");
    }

   
    
}
