/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import modul.ChucVu;
import org.hibernate.Session;
import org.hibernate.query.Query;
import hibernateConfig.HibernateConfig;

/**
 *
 * @author DieuThuy
 */
public class ChucVuRepo {
    private Session session;

    public ChucVuRepo() {
        session = HibernateConfig.getFACTORY().openSession();
    }
    
    public ArrayList<ChucVu> select(){
        String query = "from ChucVu where trangThai =:trangThai ";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 1);
        ArrayList<ChucVu> list = (ArrayList<ChucVu>) q.getResultList();
        return list;
        
    }
    
    public void insert(ChucVu cv){
        session.beginTransaction();
        session.save(cv);
        session.getTransaction().commit();
    }
    
    public void delete(Integer id){
        session.beginTransaction();
        String query = "update ChucVu set trangThai =: trangThai where id =: id ";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 0);
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
        
    }
    
    public void update(Integer id, ChucVu cv){
        session.beginTransaction();
        String query = "update ChucVu set ma =: ma, ten =: ten, ngaySua =: ngaySua where id =: id ";
        Query q = session.createQuery(query);
        q.setParameter("ma", cv.getMa());
        q.setParameter("ten", cv.getTen());
        q.setParameter("ngaySua", cv.getNgayThem());
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    
    public ArrayList<String> selectMa(){
        String query = "select cv.ma from ChucVu cv ";
        Query q = session.createQuery(query);
        ArrayList<String> list = (ArrayList<String>) q.getResultList();
        return list;
    }
}
