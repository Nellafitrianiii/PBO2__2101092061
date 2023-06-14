/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nella.model.Buku;
import nella.model.Peminjaman;

/**
 *
 * @author Asus
 */
public class PeminjamanDaoImpl implements PeminjamanDao {

    @Override
    public void insert(Connection con, Peminjaman pinjam) throws Exception {
        String sql = "insert into peminjaman values(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, pinjam.getKodeanggota());
        ps.setString(2, pinjam.getKodebuku());
        ps.setString(3, pinjam.getTglpinjam());
        ps.setString(4, pinjam.getTglkembali());
        ps.executeUpdate();
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Connection con, Peminjaman pinjam) throws Exception {
        String sql = "update peminjaman set tglkembali=? "+"where kodeanggota =? and kodebuku =? and tglpinjam =?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, pinjam.getTglkembali());
        ps.setString(2, pinjam.getKodeanggota());
        ps.setString(3, pinjam.getKodebuku());
        ps.setString(4, pinjam.getTglpinjam());
        ps.executeUpdate();
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Connection con, Peminjaman pinjam) throws Exception {
        String sql = "delete from pinjam "+ "where kodeanggota =? and kodebuku =? and tglpinjam=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, pinjam.getKodeanggota());
        ps.setString(2, pinjam.getKodebuku());
        ps.setString(3, pinjam.getTglpinjam());
        ps.executeUpdate();
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Peminjaman getPeminjaman(Connection con, String kodeanggota, String kodebuku, String tglpinjam) {
        try {
            String sql = "select * from pinjam"+"where kodeanggota =? and kodebuku =? and tglpinjam =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kodeanggota);
            ps.setString(2, kodebuku);
            ps.setString(3, tglpinjam);
            ResultSet rs = ps.executeQuery();
            Peminjaman pinjam = null;
            if(rs.next()){
                pinjam = new Peminjaman();
                pinjam.setKodeanggota(rs.getString(1));
                pinjam.setKodebuku(rs.getString(2));
                pinjam.setTglpinjam(rs.getString(3));
                pinjam.setTglkembali(rs.getString(4));
            }
            return pinjam;
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Peminjaman> getAllPeminjaman(Connection con) throws Exception {
        String sql = "select *from peminjaman";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Peminjaman> list = new ArrayList<>();
        Peminjaman pinjam = null;
        while(rs.next()){
            pinjam = new Peminjaman();
            pinjam.setKodeanggota(rs.getString(1));
            pinjam.setKodebuku(rs.getString(2));
            pinjam.setTglpinjam(rs.getString(3));
            pinjam.setTglkembali(rs.getString(4));
            list.add(pinjam);
        }
        return list;
//To change body of generated methods, choose Tools | Templates.
    }

    

    
    
}
