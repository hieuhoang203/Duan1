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
    private Session session = HibernateConfig.getFACTORY().openSession();
    
    public ArrayList<CoSo> select(){
        Query q = session.createQuery("From CoSo");
        ArrayList<CoSo> list = (ArrayList<CoSo>) q.getResultList();
        return list;
    }
    
    public void insert(CoSo cs){
        session.beginTransaction();
        session.save(cs);
        session.getTransaction().commit();
    }
    
    public void update(Integer id, CoSo cs){
        session.beginTransaction();
        String query = "update CoSo set ma =:ma, "
                + "ten =:ten, ngaySua =:ngaySua where id =:id";
        Query q = session.createQuery(query);
        q.setParameter("ma", cs.getMa());
        q.setParameter("ten", cs.getTen());
        q.setParameter("ngaySua", cs.getNgayThem());
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    
    public void delete(Integer id){
        session.beginTransaction();
        String query = "Delete from CoSo where id =:id";
        Query q = session.createQuery(query);
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    
    public ArrayList<String> selectMa(){
        Query q = session.createQuery("Select c.ma from CoSo c");
        ArrayList<String> list = (ArrayList<String>) q.getResultList();
        return list;
    }
    
}
