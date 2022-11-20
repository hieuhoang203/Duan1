/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import org.hibernate.Session;
import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import modul.ChiTietBaoHanh;
import modul.HoaDon;
import modul.HoaDonChiTiet;
import org.hibernate.query.Query;

/**
 *
 * @author admin
 */
public class ChiTietBaoHanhRepository {
    private Session session = HibernateConfig.getFACTORY().openSession();
    
    public ArrayList<ChiTietBaoHanh> select(HoaDon idHoaDon){
        String query = "from ChiTietBaoHanh where idHoaDon =:idHoaDon";
        Query q = session.createQuery(query);
        q.setParameter("idHoaDon", idHoaDon);
        return (ArrayList<ChiTietBaoHanh>) q.getResultList();
    }
    
    public void insert(ChiTietBaoHanh ctbh){
        session.beginTransaction();
        session.save(ctbh);
        session.getTransaction().commit();
    }
    
    public void delete(Integer id){
        session.beginTransaction();
        String query = "delete from ChiTietBaoHanh where id =:id";
        Query q = session.createQuery(query);
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    
    public long tienBaoHanh(HoaDon hd){
        String query = "select sum(bh.gia) from BaoHanh bh join ChiTietBaoHanh ct "
                + "on bh.id = ct.idBaoHanh where ct.idHoaDon =:idHoaDon";
        Query q = session.createQuery(query);
        q.setParameter("idHoaDon", hd);
        if (q.getResultList().get(0) != null) {
            return (long) q.getResultList().get(0);
        } else {
            return 0;
        }
    }

}
