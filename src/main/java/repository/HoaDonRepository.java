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
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author admin
 */
public class HoaDonRepository {
    private Session session;

    public HoaDonRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }
    
    public ArrayList<HoaDon> select(NguoiDung ng){
        session = HibernateConfig.getFACTORY().openSession();
        Query q = session.createQuery("from HoaDon where idNguoiDung =:idNguoiDung order by (ngayMua) desc");
        q.setParameter("idNguoiDung", ng);
        return (ArrayList<HoaDon>) q.getResultList();
    }
    
    public ArrayList<HoaDon> selectByTrangThai(NguoiDung ng, int tinhTrang){
        session = HibernateConfig.getFACTORY().openSession();
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
    
    public void updateTongTien(Integer id, long tongTien){
        session.beginTransaction();
        String query = "update HoaDon set tongTien =:tongTien where id =:id";
        Query q = session.createQuery(query);
        q.setParameter("tongTien", tongTien);
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    
    public ArrayList<HoaDon> select(int firtRecord, NguoiDung ng){
        session = HibernateConfig.getFACTORY().openSession();
        Query q = session.createQuery("from HoaDon where idNguoiDung =:idNguoiDung");
        q.setParameter("idNguoiDung", ng);
        q.setFirstResult(firtRecord);
        q.setMaxResults(5);
        return (ArrayList<HoaDon>) q.getResultList();
    }
    
    public long turnover(int month){
        String query = "select SUM(hd.tongTien) from HoaDon hd where month(hd.ngayMua) =:month and year(hd.ngayMua) = year(getdate())";
        Query q = session.createQuery(query);
        q.setParameter("month", month);
        List list = q.getResultList();
        if (list.get(0) != null) {
            return (long) list.get(0);
        } else {
            return 0;
        }
    }
    
}
