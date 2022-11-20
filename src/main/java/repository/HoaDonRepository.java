/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import modul.HoaDon;
import modul.NguoiDung;
import org.hibernate.Session;
import hibernateConfig.HibernateConfig;
import org.hibernate.query.Query;

/**
 *
 * @author admin
 */
public class HoaDonRepository {
    private Session session = HibernateConfig.getFACTORY().openSession();
    
    public ArrayList<HoaDon> select(NguoiDung ng){
        Query q = session.createQuery("from HoaDon where idNguoiDung =:idNguoiDung");
        q.setParameter("idNguoiDung", ng);
        return (ArrayList<HoaDon>) q.getResultList();
    }
    
    public ArrayList<HoaDon> selectByTrangThai(NguoiDung ng, int tinhTrang){
        String query = "from HoaDon where idNguoiDung =:idNguoiDung and tinhTrang =:tinhTrang";
        Query q = session.createQuery(query);
        q.setParameter("idNguoiDung", ng);
        q.setParameter("tinhTrang", tinhTrang);
        return (ArrayList<HoaDon>) q.getResultList();
    }
    
    public void insert(HoaDon hd){
        session.beginTransaction();
        session.save(hd);
        session.getTransaction().commit();
    }
    
    public void update(String maHd){
        session.beginTransaction();
        String query = "update HoaDon set tinhTrang =:tinhTrang where ma =:ma";
        Query q = session.createQuery(query);
        q.setParameter("tinhTrang", 1);
        q.setParameter("ma", maHd);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    
    public HoaDon searchByMa(String ma){
        Query q = session.createQuery("from HoaDon where ma =:ma");
        q.setParameter("ma", ma);
        return (HoaDon) q.getResultList().get(0);
    }
}
