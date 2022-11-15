/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import org.hibernate.Session;
import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import javax.persistence.Query;
import modul.LoaiSp;

/**
 *
 * @author admin
 */
public class LoaiSpRepository {
    private Session session = HibernateConfig.getFACTORY().openSession();
    
    public ArrayList<LoaiSp> select(){
        Query q = session.createQuery("from LoaiSp where trangThai =:trangThai");
        q.setParameter("trangThai", 1);
        ArrayList<LoaiSp> list = (ArrayList<LoaiSp>) q.getResultList();
        return list;
    }
    
    public void insert(LoaiSp loaiSp){
        session.beginTransaction();
        session.save(loaiSp);
        session.getTransaction().commit();
    }
    
    public void update(Integer id, LoaiSp loaiSp){
        session.beginTransaction();
        String query = "update LoaiSp set ma =:ma, idDongSp =:idDongSp, "
                + "idMauSac =:idMauSac, idDungLuong =:idDungLuong, ngaySua =:ngaySua "
                + "where id =:id";
        Query q = session.createQuery(query);
        q.setParameter("ma", loaiSp.getMa());
        q.setParameter("idDongSp", loaiSp.getIdDongSp());
        q.setParameter("idDungLuong", loaiSp.getIdDungLuong());
        q.setParameter("idMauSac", loaiSp.getIdMauSac());
        q.setParameter("ngaySua", loaiSp.getNgayThem());
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    
    public void delete(Integer id){
        session.beginTransaction();
        String query = "update LoaiSp set trangThai =:trangThai"
                + " where id =:id";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 0);
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    
    public ArrayList<String> selectMa(){
        Query q = session.createQuery("select l.ma from LoaiSp l");
        ArrayList<String> list = (ArrayList<String>) q.getResultList();
        return list;
    }
}
