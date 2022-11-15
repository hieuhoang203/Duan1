/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import javax.persistence.Query;
import modul.DungLuong;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class DungLuongRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();

    public ArrayList<DungLuong> select() {
        String query = "FRom DungLuong where trangThai =:trangThai";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 1);
        ArrayList<DungLuong> list = (ArrayList<DungLuong>) q.getResultList();
        return list;
    }

    public void insert(DungLuong dl) {
        session.beginTransaction();
        session.save(dl);
        session.getTransaction().commit();
    }

    public void update(Integer id, DungLuong dl) {
        session.beginTransaction();
        String query = "UPDATE DungLuong set ma=:ma, ten=:ten, ngaySua=:ngaySua Where id=:id";
        Query q = session.createQuery(query);
        q.setParameter("ma", dl.getMa());
        q.setParameter("ten", dl.getTen());
        q.setParameter("ngaySua", dl.getNgayThem());
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }

    public void delete(Integer id) {
        session.beginTransaction();
        String query = "update DungLuong set trangThai =:trangThai where id =:id";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 0);
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }

    public ArrayList<String> selectMa() {
        String query = "Select dl.ma from DungLuong dl";
        Query q = session.createQuery(query);
        ArrayList<String> list = (ArrayList<String>) q.getResultList();
        return list;
    }
}
