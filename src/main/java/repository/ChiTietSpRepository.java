package repository;

import org.hibernate.Session;
import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
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
        Query q = session.createQuery("From ChiTietSP where trangThai =:trangThai");
        q.setParameter("trangThai", 1);
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
        String query = "update ChiTietSP set idLoaiSp =:idLoaiSp, idCuaHang =:idCuaHang,"
                + " ngaySua =:ngaySua where id =:id";
        Query q = session.createQuery(query);   
        q.setParameter("idLoaiSp", ctsp.getIdLoaiSp());
        q.setParameter("idCuaHang", ctsp.getIdCuaHang());
        q.setParameter("ngaySua", ctsp.getNgayThem());
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    
    public void delete(Integer id){
        session.beginTransaction();
        String query = "update ChiTietSP set trangThai =:trangThai where id =:id";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 0);
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    
    public ArrayList<ChiTietSP> search(String keyWord){
        String query = "select ct.id, ct.imei, ct.idLoaiSp, ct.idCuaHang, ct.trangThai, ct.ngayThem, ct.ngaySua from ChiTietSP ct "
                + "inner join LoaiSp ls on ls.id = ct.idLoaiSp "
                + "inner join DongSp ds on ds.id = ls.idDongSp where ds.ten like :keyWord";
        Query q = session.createQuery(query);
        q.setParameter("keyWord", keyWord + "%");
        ArrayList<ChiTietSP> list = (ArrayList<ChiTietSP>) q.getResultList();
        return list;
    }
    
    public ArrayList<String> selectImei(){
        String query = "select ct.imei from ChiTietSP ct";
        Query q = session.createQuery(query);
        ArrayList<String> list = (ArrayList<String>) q.getResultList();
        return list;
    }
    
    public static void main(String[] args) {
        ChiTietSpRepository cts = new ChiTietSpRepository();
        for (ChiTietSP chiTietSP : cts.search("iPhone")) {
            System.out.println(chiTietSP.getImei());
        }
    }
}
