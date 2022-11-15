/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import org.hibernate.Session;
import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import modul.ChiTietSP;
import modul.DongSp;
/**
 *
 * @author admin
 */
public class ChiTietSpRepository {
    private Session session = HibernateConfig.getFACTORY().openSession();
    
    public ArrayList<ChiTietSP> select(){
        Query q = session.createQuery("From ChiTietSP");
        ArrayList<ChiTietSP> list = (ArrayList<ChiTietSP>) q.getResultList();
        return list;
    }
    
    public void insert(ChiTietSP ctsp){
        session.beginTransaction();
        session.save(ctsp);
        session.getTransaction().commit();
    }
    
    public void update(Integer id, ChiTietSP ctsp){
        session.beginTransaction();
        String query = "update ChiTietSP set idDongSp =:idDongSp, idMauSac =:idMauSac, "
                + "idDungLuong =:idDungLuong, idCuaHang =:idCuaHang, ngaySua =:ngayThem, "
                + "trangThai =: trangThai where id =:id";
        Query q = session.createQuery(query);
        q.setParameter("idDongSp", ctsp.getIdDongSp());
        q.setParameter("idMauSac", ctsp.getIdMauSac());
        q.setParameter("idDungLuong", ctsp.getIdDungLuong());
        q.setParameter("idCuaHang", ctsp.getIdCuaHang());
        q.setParameter("trangThai", ctsp.getTrangThai());
        q.executeUpdate();
        session.getTransaction().commit();
    }
    
    public void delete(Integer id){
        session.beginTransaction();
        String query = "delete from ChiTietSP where id=:id";
        Query q = session.createQuery(query);
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    
    public ArrayList<ChiTietSP> search(Integer keyWord){
        String query = "from ChiTietSP where idDongSp =: idDongSp";
        Query q = session.createQuery(query);
        q.setParameter("idDongSp", keyWord);
        ArrayList<ChiTietSP> list = (ArrayList<ChiTietSP>) q.getResultList();
        return list;
    }
    
    public void updateAll(long number, DongSp dongSp){
        session.beginTransaction();
        String query = "update ChiTietSP set soLuong =:soLuong where idDongSp =:idDongSp";
        Query q = session.createQuery(query);
        q.setParameter("soLuong", number);
        q.setParameter("idDongSp", dongSp);
        q.executeUpdate();
        session.getTransaction().commit();
    }
}
