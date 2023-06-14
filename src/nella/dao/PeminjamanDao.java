/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nella.dao;

import java.sql.Connection;
import java.util.List;
import nella.model.Buku;
import nella.model.Peminjaman;

/**
 *
 * @author Asus
 */
public interface PeminjamanDao {
    public void insert(Connection con, Peminjaman pinjam) throws Exception;
    public void update (Connection con,Peminjaman pinjam) throws Exception;
    public void delete (Connection con, Peminjaman pinjam) throws Exception;
     public Peminjaman getPeminjaman(Connection con, String kodeanggota, String kodebuku, String tglpinjam);
    public List<Peminjaman> getAllPeminjaman(Connection con) throws Exception;
   
}
