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
    
    public ArrayList<CoSo> select(){
        session.beginTransaction();
        Query q = session.createQuery("From Hang");
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
        
    }
}
