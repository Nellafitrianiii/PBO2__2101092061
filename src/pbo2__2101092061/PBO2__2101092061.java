/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo2__2101092061;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import nella.dao.Koneksi;

/**
 *
 * @author Asus
 */
public class PBO2__2101092061 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Koneksi koneksi = new Koneksi();
            Connection con = koneksi.getkoneksi();
            JOptionPane.showMessageDialog(null,"Koneksi OK");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error :" +ex.getMessage());
            Logger.getLogger(PBO2__2101092061.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }    
}
