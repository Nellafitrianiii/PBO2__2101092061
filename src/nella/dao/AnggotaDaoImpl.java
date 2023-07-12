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
import nella.model.Anggota;

/**
 *
 * @author Asus
 */
public class AnggotaDaoImpl implements AnggotaDao {

    @Override
    public void insert(Connection con, Anggota anggota)throws Exception {
        String sql = "Insert into anggota values (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, anggota.getKodeAnggota());
        ps.setString(2, anggota.getNamaAnggota());
        ps.setString(3, anggota.getAlamat());
        ps.setString(4, anggota.getJenisKelamin());
        ps.executeUpdate();
    }//To change body of generated methods, choose Tools | Templates. {    

    @Override
    public void update(Connection con, Anggota anggota) throws Exception {
         String sql = "Update anggota set namaanggota=? alamat =?," + " jeniskelamin=? where kodeanggota=?";
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setString(1,anggota.getNamaAnggota());
         ps.setString(2,anggota.getAlamat());
         ps.setString(3,anggota.getJenisKelamin());
         ps.setString(4,anggota.getKodeAnggota());
         ps.executeUpdate();
         
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Connection con, Anggota anggota) throws Exception {
        String sql = "delete from anggota" +"where kodeanggota = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, anggota.getKodeAnggota());
        ps.executeUpdate();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Anggota getAnggota(Connection con, String kode) throws Exception {
        String sql = "select * from "+ "where kodeanggota=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        Anggota anggota = null;
        if(rs.next()){
            anggota = new Anggota();
            anggota.setKodeAnggota(rs.getString(1));
            anggota.setNamaAnggota(rs.getString(2));
            anggota.setAlamat(rs.getString(3));
            anggota.setJenisKelamin(rs.getString(4));
         }
         return anggota;
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Anggota> getAllAnggota(Connection con) throws Exception {
        String sql = "select * from anggota";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Anggota> list = new ArrayList<>();
        Anggota anggota = null;
        while (rs.next()){
            anggota = new Anggota();
            anggota.setKodeAnggota(rs.getString(1));
            anggota.setNamaAnggota(rs.getString(2));
            anggota.setAlamat(rs.getString(3));
            anggota.setJenisKelamin(rs.getString(4));
            list.add(anggota);
        }
        return list;
        //To change body of generated methods, choose Tools | Templates.
    }  



}
