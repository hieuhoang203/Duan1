/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import javax.persistence.Query;
import modul.DongSp;
import org.hibernate.Session;
/**
 *
 * @author admin
 */
public class DongSpRepository {
    private Session session = HibernateConfig.getFACTORY().openSession();
    
    public ArrayList<DongSp> select(){
        Query q = session.createQuery("From DongSp");
        ArrayList<DongSp> list = (ArrayList<DongSp>) q.getResultList();
        return list;
    }
    
    public void insert(DongSp dongSp){
        session.beginTransaction();
        session.save(dongSp);
        session.getTransaction().commit();;
    }
    
    public void update(Integer id, DongSp dongSp){
        session.beginTransaction();
        String query = "update DongSp set ma =:ma, ten= :ten, giaNhap =:giaNhap, giaBan =:giaBan, "
                + "ngaySua=:ngaySua where id =:id";
        Query q = session.createQuery(query);
        q.setParameter("ma", dongSp.getMa());
        q.setParameter("ten", dongSp.getTen());
        q.setParameter("giaNhap", dongSp.getGiaNhap());
        q.setParameter("giaBan", dongSp.getGiaBan());
        q.setParameter("ngaySua", dongSp.getNgayThem());
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();;
    }
    
    public void delete(Integer id){
        session.beginTransaction();
        String query = "delete from DongSp where id=:id";
        Query q = session.createQuery(query);
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();;
    }
    
    public ArrayList<String> selectMa(){
        Query q = session.createQuery("Select d.ma from DongSp d");
        ArrayList<String> list = (ArrayList<String>) q.getResultList();
        return list;
    }
    
}
