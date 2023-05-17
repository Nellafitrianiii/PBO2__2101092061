/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts_a.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import uts_a.dao.Koneksi;
import uts_a.dao.PlnDao;
import uts_a.dao.PlnDaoImpl;
import uts_a.view.FormPLN;
import uts_a.model.Pln;

/**
 *
 * @author Asus
 */
public class PlnController {
    private FormPLN formpln;
    private Pln pln;
    private PlnDao plndao;
    private Connection con;
    private Koneksi koneksi;

    public PlnController(FormPLN formpln) throws Exception {
        this.formpln = formpln;
        plndao = new PlnDaoImpl;
        try {
            con = new Koneksi().getkoneksi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PlnController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insert(){
        pln = new Pln();
            pln.setKodepelanggan(formpln.getTxtKode().getText());
            pln.setNampelanggan(formpln.getTxtNama().getText());
            pln.setMbi(formpln.getTxtMbi().getText());
            pln.setMbl(formpln.getTxtMbl().getText());
            pln.setTarif(formpln.getTxtTarif()).getDouble());
            plndao.insert(con,pln);
            JOptionPane.showMessageDialog(formpln, "Entri Ok");
    }
    
    public void update(){
         pln = new Pln();
            pln.setKodepelanggan(formpln.getTxtKode().getText());
            pln.setNampelanggan(formpln.getTxtNama().getText());
            pln.setMbi(formpln.getTxtMbi().getText());
            pln.setMbl(formpln.getTxtMbl().getText());
            pln.setTarif(formpln.getTxtTarif()).getDouble());
            plndao.insert(con,pln);
            JOptionPane.showMessageDialog(formpln, "Update Ok");
        
    }
    
    public void delete(){
        plndao.delete(con,pln);
        JOptionPane.showMessageDialog(formpln,"Delete Ok");
    }
    
    public void clearForm(){
        formpln.getTxtKode().setText("");
        formpln.getTxtNama().setText("");
        formpln.getTxtMbi().setText("");
        formpln.getTxtMbl().setText("");
        formpln.getTxtTarif().setText("");
    }
    
    
    
    public void tampil(){
        try {
            DefaultTableModel tabel = (DefaultTableModel) formpln.getTblPln().getModel();
            tabel.setRowCount(0);
            List<Pln> list = plndao.getAllPln(con);
            for (pln pln1 : list){
                Object[] row = {
                    pln1.getKode(),
                    pln1.getNama(),
                    pln1.getMbi(),
                    pln1.getMbl(),
                    pln1.getTarif()
                    
                };
                tabel.addRow(row);
            }
        

    public void clearForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
