/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import nella.model.Buku;

/**
 *
 * @author Asus
 */
public class BukuDaoImpl implements BukuDao{

    @Override
    public void insert(Connection con, Buku buku) throws Exception {
        String sql = "insert into buku value(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, buku.getKodebuku());
        ps.setString(2, buku.getJudulbuku());
        ps.setString(3, buku.getPengarang());
        ps.setString(4, buku.getPenerbit());
        ps.executeUpdate();
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Connection con, Buku buku) throws Exception {
        String sql = "Update buku set judul=?, pengarang=?, penerbit=? where kodebuku=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, buku.getJudulbuku());
        ps.setString(2, buku.getKodebuku());
        ps.setString(3, buku.getPengarang());
        ps.setString(4, buku.getPenerbit());
        ps.executeUpdate();
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Connection con, Buku buku) throws Exception {
        String sql = "delete from buku " + "where kodebuku = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, buku.getKodebuku());
        ps.executeUpdate();      
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Buku getBuku(Connection con, String kode) throws Exception {
        String sql = "select * from buku " + "where kodebuku =?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        Buku buku = null;
        if(rs.next());{
            buku = new Buku();
            buku.setKodebuku(rs.getString(1));
            buku.setJudulbuku(rs.getString(2));
            buku.setPengarang(rs.getString(3));
            buku.setPenerbit(rs.getString(4));
        }
        return buku;
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Buku> getAllBuku(Connection con) throws Exception {
        String sql = "select * from buku";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Buku> list = new ArrayList<>();
        Buku buku = null;
        while (rs.next()){
            buku = new Buku();
            buku.setKodebuku(rs.getString(1));
            buku.setJudulbuku(rs.getString(2));
            buku.setPengarang(rs.getString(3));
            buku.setPenerbit(rs.getString(4));
            list.add(buku);
        }
        return list;
        
//To change body of generated methods, choose Tools | Templates.
    }
    
}
