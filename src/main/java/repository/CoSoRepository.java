/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import org.hibernate.Session;
import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import javax.persistence.Query;
import modul.CoSo;

/**
 *
 * @author admin
 */
public class CoSoRepository {
    private static Session session = HibernateConfig.getFACTORY().openSession();
    private static CuaHangRepository cuaHangRepository = new CuaHangRepository();
    
    public static ArrayList<CoSo> select(){
        session.beginTransaction();
        Query q = session.createQuery("From CoSo");
        ArrayList<CoSo> list = (ArrayList<CoSo>) q.getResultList();
        session.close();
        return list;
    }
    
    public void insert(CoSo cs){
        session.beginTransaction();
        session.save(cs);
        session.getTransaction().commit();
        session.close();
    }
    
    public void update(String id, CoSo cs){
        session.beginTransaction();
        String query = "update CoSo set ma =:ma,"
                + "ten =:ten, ngaySua =:ngayThem where id =:id";
        Query q = session.createQuery(query);
        q.setParameter("ma", cs.getMa());
        q.setParameter("ten", cs.getTen());
        q.setParameter("ngaySua", cs.getNgayThem());
        q.setParameter("id", id);
        q.executeUpdate();
        session.close();
    }
    
    public void delete(String id){
        session.beginTransaction();
        String query = "Delete from CoSo where id =:id";
        Query q = session.createQuery(query);
        q.setParameter("id", id);
        q.executeUpdate();
        session.close();
    }
    
    public ArrayList<String> selectMa(){
        session.beginTransaction();
        Query q = session.createQuery("Select CoSo.ma from CoSo");
        ArrayList<String> list = (ArrayList<String>) q.getResultList();
        session.close();
        return list;
    }
    
}
