/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nella.dao;

import java.sql.Connection;
import nella.model.Anggota;

/**
 *
 * @author Asus
 */
public interface AnggotaDao {
    void insert (Connection con, Anggota anggota) throws Exception;
}
