package repository;

import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import javax.persistence.Query;
import modul.Hang;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class HangRepository {
   private Session session = HibernateConfig.getFACTORY().openSession();
  public ArrayList<Hang> select(){
      String query="FRom Hang where trangThai =:trangThai";
      Query q=session.createQuery(query);
      q.setParameter("trangThai", 1);
      ArrayList<Hang> list=(ArrayList<Hang>) q.getResultList();
      return list;
  }
  public void insert(Hang h){
      session.beginTransaction();
      session.save(h);
      session.getTransaction().commit();
  }
  public void update(Integer id, Hang h){
      session.beginTransaction();
      String query="UPDATE Hang set ma=: ma, ten=: ten, ngaySua=: ngaySua Where id=: id";
      Query q=session.createQuery(query);
      q.setParameter("ma", h.getMa());
      q.setParameter("ten", h.getTen());
      q.setParameter("ngaySua", h.getNgayThem());
      q.setParameter("id", id);
      q.executeUpdate();
      session.getTransaction().commit();
  }
  public void delete(Integer id){
      session.beginTransaction();
      String query="update Hang set trangThai =:trangThai where id =:id";
      Query q=session.createQuery(query);
      q.setParameter("trangThai", 0);
      q.setParameter("id", id);
      q.executeUpdate();
      session.getTransaction().commit();
  }
  public ArrayList<String> selectMa(){
      String query="Select h.ma from Hang h";
      Query q=session.createQuery(query);
      ArrayList<String> list=(ArrayList<String>) q.getResultList();
      return list;
  }
}
