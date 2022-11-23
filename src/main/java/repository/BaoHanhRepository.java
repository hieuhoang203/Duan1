/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import org.hibernate.Session;
import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import modul.BaoHanh;
import org.hibernate.query.Query;

/**
 *
 * @author admin
 */
public class BaoHanhRepository {
    private Session session;

    public BaoHanhRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }
    
    public ArrayList<BaoHanh> select(){
        Query q = session.createQuery("from BaoHanh where trangThai =:trangThai");
        q.setParameter("trangThai", 1);
        ArrayList<BaoHanh> list = (ArrayList<BaoHanh>) q.getResultList();
        return list;
    }
    
    public void insert(BaoHanh bh){
        session.beginTransaction();
        session.save(bh);
        session.getTransaction().commit();
    }
    
    public void update(Integer id, BaoHanh bh){
        session.beginTransaction();
        String query = "update BaoHanh set ma =:ma, ten =:ten, gia =:gia, "
                + "thoiGian =:thoiGian where id =:id";
        Query q = session.createQuery(query);
        q.setParameter("ma", bh.getMa());
        q.setParameter("ten", bh.getTen());
        q.setParameter("gia", bh.getGia());
        q.setParameter("thoiGian", bh.getThoiGian());
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    
    public void delete(Integer id){
        session.beginTransaction();
        String query = "update BaoHanh set trangThai =:trangThai where id=:id";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 0);
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    
    public BaoHanh search(String ten){
        String query = "from BaoHanh where ten =:ten";
        Query q = session.createQuery(query);
        q.setParameter("ten", ten);
        return (BaoHanh) q.getResultList().get(0);
    }
    
    public ArrayList<String> selectMa(){
        String query = "select bh.ma from BaoHanh bh";
        Query q = session.createQuery(query);
        ArrayList<String> list = (ArrayList<String>) q.getResultList();
        return list;
    }
}
