/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import javax.persistence.Query;
import modul.MauSac;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class MauSacRepository {

    private Session session;

    public MauSacRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public ArrayList<MauSac> select() {
        String query = "from MauSac where trangThai =:trangThai";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 1);
        ArrayList<MauSac> list = (ArrayList<MauSac>) q.getResultList();
        return list;
    }

    public void insert(MauSac ms) {
        session.beginTransaction();
        session.save(ms);
        session.getTransaction().commit();
    }

    public void update(Integer id, MauSac ms) {
        session.beginTransaction();
        String query = "Update MauSac set ma=:ma, ten=:ten, ngaySua=:ngaySua Where id=:id";
        Query q = session.createQuery(query);
        q.setParameter("ma", ms.getMa());
        q.setParameter("ten", ms.getTen());
        q.setParameter("ngaySua", ms.getNgayThem());
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }

    public void delete(Integer id) {
        session.beginTransaction();
        String query = "update MauSac set trangThai =:trangThai WHERE id=:id";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 0);
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }

    public ArrayList<String> selectMa() {
        String query = "SELECT ms.ma from MauSac ms";
        Query q = session.createQuery(query);
        ArrayList<String> list = (ArrayList<String>) q.getResultList();
        return list;
    }
}
