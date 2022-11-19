package repository;

import org.hibernate.Session;
import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import modul.ChiTietSP;
import modul.CuaHang;
import modul.LoaiSp;

/**
 *
 * @author admin
 */
public class ChiTietSpRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();

    public ArrayList<ChiTietSP> select() {
        Query q = session.createQuery("From ChiTietSP where trangThai =:trangThai");
        q.setParameter("trangThai", 1);
        ArrayList<ChiTietSP> list = (ArrayList<ChiTietSP>) q.getResultList();
        return list;
    }

    public void insert(ChiTietSP ctsp) {
        session.beginTransaction();
        session.save(ctsp);
        session.getTransaction().commit();
    }

    public void update(Integer id, ChiTietSP ctsp) {
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

    public void delete(Integer id) {
        session.beginTransaction();
        String query = "update ChiTietSP set trangThai =:trangThai where id =:id";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 0);
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }

    public ArrayList<ChiTietSP> search(String keyWord) {
        String query = "select ct.id, ct.imei, ct.idLoaiSp, ct.idCuaHang from ChiTietSP ct "
                + "inner join LoaiSp ls on ls.id = ct.idLoaiSp "
                + "inner join DongSp ds on ds.id = ls.idDongSp "
                + "inner join Hang h on h.id = ds.idHang where h.ten like :keyWord and ct.trangThai =:trangThai";
        Query q = session.createQuery(query);
        q.setParameter("keyWord", keyWord + "%");
        q.setParameter("trangThai", 1);
        List<Object[]> list = q.getResultList();
        if (list.size() > 0) {
            ArrayList<ChiTietSP> arr = new ArrayList<>();
            list.forEach((t) -> {
                arr.add(new ChiTietSP((Integer) t[0], t[1].toString(), (LoaiSp) t[2], (CuaHang) t[3], 1, null, null, null, null));
            });
            return arr;
        } else {
            return null;
        }
    }

    public ArrayList<String> selectImei() {
        String query = "select ct.imei from ChiTietSP ct";
        Query q = session.createQuery(query);
        ArrayList<String> list = (ArrayList<String>) q.getResultList();
        return list;
    }
    
    public ArrayList<ChiTietSP> searchByStore(Integer idCuaHang){
        String query = "from ChiTietSP where idCuaHang =:idCuaHang and trangThai =:trangThai";
        Query q = session.createQuery(query);
        q.setParameter("idCuaHang", idCuaHang);
        q.setParameter("trangThai", 1);
        ArrayList<ChiTietSP> list = (ArrayList<ChiTietSP>) q.getResultList();
        return list;
    }

}
