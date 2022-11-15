/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import org.hibernate.Session;
import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import javax.persistence.Query;
import modul.CuaHang;

/**
 *
 * @author admin
 */
public class CuaHangRepository {
    private Session session = HibernateConfig.getFACTORY().openSession();
    
    public ArrayList<CuaHang> select(){
        Query q = session.createQuery("From CuaHang");
        ArrayList<CuaHang> list = (ArrayList<CuaHang>) q.getResultList();
        return list;
    }
    
    public void insert(CuaHang ch){
        session.beginTransaction();
        session.save(ch);
        session.getTransaction().commit();
    }
    
    public void update(Integer id, CuaHang ch){
        session.beginTransaction();
        String query = "update CuaHang set ma =:ma, ten =:ten, "
                + "diaChi =:diaChi, idCoSo =:idCoSo, ngaySua=: ngaySua where id =:id";
        Query q = session.createQuery(query);
        q.setParameter("ma", ch.getMa());
        q.setParameter("ten", ch.getTen());
        q.setParameter("diaChi", ch.getDiaChi());
        q.setParameter("idCoSo", ch.getIdCoSo());
        q.setParameter("ngaySua", ch.getNgayThem());
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    
    public void delete(Integer id){
        session.beginTransaction();
        String query = "delete from CuaHang where id =:id";
        Query q = session.createQuery(query);
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    
    public ArrayList<String> selectMa(){
        Query q = session.createQuery("select h.ma from CuaHang h");
        ArrayList<String> list = (ArrayList<String>) q.getResultList();
        return list;
    }
}
