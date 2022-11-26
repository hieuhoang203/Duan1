/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import org.hibernate.Session;
import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import java.util.List;
import modul.NguoiDung;
import org.hibernate.query.Query;

/**
 *
 * @author admin
 */
public class NguoiDungRepository {
    private Session session;

    public NguoiDungRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }
    
    public void insert(NguoiDung ng){
        session.beginTransaction();
        session.save(ng);
        session.getTransaction().commit();
    }
    
    public void update(Integer id, NguoiDung ng){
        session.beginTransaction();
        String query = "update NguoiDung set ma =:ma, hoTen =:hoTen, gioiTinh =:gioiTinh, "
                + "ngaySinh =:ngaySinh, diaChi =:diaChi, "
                + "anh =:anh, chucVu =:chucVu, cuaHang =:cuaHang where id =:id";
        Query q = session.createQuery(query);
        q.setParameter("ma", ng.getMa());
        q.setParameter("hoTen", ng.getHoTen());
        q.setParameter("gioiTinh", ng.getGioiTinh());
        q.setParameter("ngaySinh", ng.getNgaySinh());
        q.setParameter("diaChi", ng.getDiaChi());
        q.setParameter("anh", ng.getAnh());
        q.setParameter("chucVu", ng.getIdChucVu());
        q.setParameter("cuaHang", ng.getIdCuaHang());
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    
    public void delete(Integer id){
        session.beginTransaction();
        String query = "update NguoiDung set trangThai =:trangThai where id =:id";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 0);
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    
    public ArrayList<NguoiDung> select(){
        session = HibernateConfig.getFACTORY().openSession();
        Query q = session.createQuery("from NguoiDung where trangThai =:trangThai order by (NgayThem) desc");
        q.setParameter("trangThai", 1);
        ArrayList<NguoiDung> list = (ArrayList<NguoiDung>) q.getResultList();
        return list;
    }
    
    public ArrayList<NguoiDung> select(int trang){
        session = HibernateConfig.getFACTORY().openSession();
        Query q = session.createQuery("from NguoiDung where trangThai =:trangThai order by (NgayThem) desc");
        q.setParameter("trangThai", 1);
        q.setFirstResult(trang);
        q.setMaxResults(5);
        ArrayList<NguoiDung> list = (ArrayList<NguoiDung>) q.getResultList();
        return list;
    }
    
    public ArrayList<NguoiDung> search(String hoTen, int trang){
        String query = "from NguoiDung where hoTen =:hoTen and trangThai =:trangThai order by (NgayThem) desc";
        Query q = session.createQuery(query);
        q.setParameter("hoTen", hoTen);
        q.setParameter("trangThai", 1);
        q.setFirstResult(trang);
        q.setMaxResults(5);
        ArrayList<NguoiDung> list = (ArrayList<NguoiDung>) q.getResultList();
        return list;
    }
    
    public NguoiDung searchByEmail(String email){
        String query = "from NguoiDung where email =:email";
        Query q = session.createQuery(query);
        q.setParameter("email", email);
        List list = q.getResultList();
        return (NguoiDung) list.get(0);
    }
    
    public ArrayList<String> selectEmail(){
        String query = "select ng.email from NguoiDung ng";
        Query q = session.createQuery(query);
        ArrayList<String> list = (ArrayList<String>) q.getResultList();
        return list;
    }
}
