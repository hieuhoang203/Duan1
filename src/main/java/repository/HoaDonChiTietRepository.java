/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import org.hibernate.Session;
import hibernateConfig.HibernateConfig;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import modul.ChiTietSP;
import modul.HoaDon;
import modul.HoaDonChiTiet;
import modul.LoaiSp;
import org.hibernate.query.Query;

/**
 *
 * @author admin
 */
public class HoaDonChiTietRepository {
    private Session session;

    public HoaDonChiTietRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }
    
    public ArrayList<HoaDonChiTiet> select(HoaDon hd){
        session = HibernateConfig.getFACTORY().openSession();
        Query q = session.createQuery("from HoaDonChiTiet where idHoaDon =:idHoaDon");
        q.setParameter("idHoaDon", hd);
        return (ArrayList<HoaDonChiTiet>) q.getResultList();
    }
    
    public void insert(HoaDonChiTiet hdct){
        session.beginTransaction();
        session.save(hdct);
        session.getTransaction().commit();
    }
    
    public HoaDonChiTiet search(Integer id){
        String query = "from HoaDonChiTiet where id =:id";
        Query q = session.createQuery(query);
        q.setParameter("id", id);
        return (HoaDonChiTiet) q.getResultList().get(0);
    }
    
    public long getTongTien(HoaDon hd){
        String query = "select sum(thanhTien) from HoaDonChiTiet where idHoaDon =:idHoaDon";
        Query q = session.createQuery(query);
        q.setParameter("idHoaDon", hd);
        return (long) q.getResultList().get(0);
    }
    
    public void delete(Integer id, HoaDon hd){
        session.beginTransaction();
        String query = "delete from HoaDonChiTiet where id =:id and idHoaDon =:idHoaDon";
        Query q = session.createQuery(query);
        q.setParameter("id", id);
        q.setParameter("idHoaDon", hd);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    
    public float count(){
        String query = "select count(*) from HoaDonChiTiet";
        Query q = session.createQuery(query);
        List list = q.getResultList();
        return (long) list.get(0);
    }
    
    public float percent(LoaiSp idLoaiSp){
        String query = "select COUNT(*) from HoaDonChiTiet hd join ChiTietSP ct on hd.idSanPham = ct.id " +
                        "join LoaiSp ls on ct.idLoaiSp = ls.id " +
                        "where ct.idLoaiSp =:idLoaiSp " +
                        "group by (ls.id)";
        Query q = session.createQuery(query);
        q.setParameter("idLoaiSp", idLoaiSp);
        List list = q.getResultList();
        if (!list.isEmpty()) {
            return (float) ((long) list.get(0)/count()*100.00); 
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        float a = 5f;
        float b = 2f;
        HoaDonChiTietRepository hs = new HoaDonChiTietRepository();
        LoaiSp ls = new LoaiSp(1);
        System.out.println(hs.count());
        System.out.println(a/b);
        System.out.println(hs.percent(ls));
    }
}
