package repository;

import org.hibernate.Session;
import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import modul.ChiTietSP;
import modul.CuaHang;
import modul.DongSp;
import modul.DungLuong;
import modul.LoaiSp;
import modul.MauSac;

/**
 *
 * @author admin
 */
public class ChiTietSpRepository {

    private Session session;

    public ChiTietSpRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public ArrayList<ChiTietSP> select() {
        session = HibernateConfig.getFACTORY().openSession();
        Query q = session.createQuery("from ChiTietSP where trangThai =:trangThai order by (ngayThem) desc");
        q.setParameter("trangThai", 1);
        ArrayList<ChiTietSP> list = (ArrayList<ChiTietSP>) q.getResultList();
        return list;
    }

    public ArrayList<ChiTietSP> selectAll() {
        session = HibernateConfig.getFACTORY().openSession();
        Query q = session.createQuery("from ChiTietSP order by (ngayThem) desc");
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

    public void upload(Integer id) {
        session.beginTransaction();
        String query = "update ChiTietSP set trangThai =:trangThai where id =:id";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 1);
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

    public ArrayList<String> selectImei() {
        String query = "select ct.imei from ChiTietSP ct";
        Query q = session.createQuery(query);
        ArrayList<String> list = (ArrayList<String>) q.getResultList();
        return list;
    }

    public ArrayList<ChiTietSP> searchByStore(CuaHang ch) {
        session = HibernateConfig.getFACTORY().openSession();
        String query = "from ChiTietSP where idCuaHang =:idCuaHang and trangThai =:trangThai order by (ngayThem) desc";
        Query q = session.createQuery(query);
        q.setParameter("idCuaHang", ch);
        q.setParameter("trangThai", 1);
        ArrayList<ChiTietSP> list = (ArrayList<ChiTietSP>) q.getResultList();
        return list;
    }

    public ChiTietSP searchById(Integer id) {
        session = HibernateConfig.getFACTORY().openSession();
        String query = "from ChiTietSP where id =:id";
        Query q = session.createQuery(query);
        q.setParameter("id", id);
        return (ChiTietSP) q.getResultList().get(0);
    }

    public ArrayList<ChiTietSP> select(int trang, CuaHang ch) {
        session = HibernateConfig.getFACTORY().openSession();
        String query = "from ChiTietSP where idCuaHang =:idCuaHang and trangThai =:trangThai order by (ngayThem) desc";
        Query q = session.createQuery(query);
        q.setParameter("idCuaHang", ch);
        q.setParameter("trangThai", 1);
        q.setFirstResult(trang);
        q.setMaxResults(5);
        ArrayList<ChiTietSP> list = (ArrayList<ChiTietSP>) q.getResultList();
        return list;
    }

    public ArrayList<ChiTietSP> search(CuaHang idCuaHang, DongSp idDongSp) {
        session = HibernateConfig.getFACTORY().openSession();
        String query = "select ct.id, ct.imei, ct.idLoaiSp, ct.idCuaHang "
                + " from ChiTietSP ct inner join LoaiSp ls on ct.idLoaiSp = ls.id "
                + " where ct.trangThai =:trangThai "
                + " and ls.idDongSp =:idDongSp "
                + " and ct.idCuaHang =:idCuaHang order by (ct.ngayThem) desc";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 1);
        q.setParameter("idCuaHang", idCuaHang);
        q.setParameter("idDongSp", idDongSp);
        List<Object[]> list = q.getResultList();
        if (!list.isEmpty()) {
            ArrayList<ChiTietSP> arr = new ArrayList<>();
            list.forEach((t) -> {
                arr.add(new ChiTietSP((Integer) t[0], t[1].toString(), (LoaiSp) t[2], (CuaHang) t[3], 1, null, null, null, null));
            });
            return arr;
        } else {
            return new ArrayList<>();
        }
    }

    public ArrayList<ChiTietSP> search(CuaHang idCuaHang, MauSac idMauSac, DungLuong idDungLuong, DongSp idDongSp) {
        session = HibernateConfig.getFACTORY().openSession();
        String query = "select ct.id, ct.imei, ct.idLoaiSp, ct.idCuaHang from ChiTietSP ct inner join LoaiSp ls "
                + "on ct.idLoaiSp = ls.id "
                + "where ct.trangThai =:trangThai and "
                + "ct.idCuaHang =:idCuaHang and ls.idDongSp =:idDongSp "
                + "and ls.idDungLuong =:idDungLuong "
                + "and ls.idMauSac =:idMauSac order by (ct.ngayThem) desc";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 1);
        q.setParameter("idCuaHang", idCuaHang);
        q.setParameter("idDongSp", idDongSp);
        q.setParameter("idDungLuong", idDungLuong);
        q.setParameter("idMauSac", idMauSac);
        ArrayList<ChiTietSP> arr = new ArrayList<>();
        List<Object[]> list = q.getResultList();
            list.forEach((t) -> {
                arr.add(new ChiTietSP((Integer) t[0], t[1].toString(), (LoaiSp) t[2], (CuaHang) t[3], 1, null, null, null, null));
            });
            return arr;
    }
}
