/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernateConfig;

import java.util.Properties;
import modul.Account;
import modul.BaoHanh;
import modul.ChiTietBaoHanh;
import modul.ChiTietSP;
import modul.ChucVu;
import modul.CoSo;
import modul.CuaHang;
import modul.DongSp;
import modul.DungLuong;
import modul.GioHang;
import modul.GioHangChiTiet;
import modul.Hang;
import modul.HoaDon;
import modul.HoaDonChiTiet;
import modul.LoaiSp;
import modul.MauSac;
import modul.NguoiDung;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author admin
 */
public class HibernateConfig {
    private static final SessionFactory FACTORY;
    
    static {
        Configuration conf = new Configuration();
        
        Properties props = new Properties();
        props.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        props.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        props.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=DuAn1_CuaHangDienThoai");
        props.put(Environment.USER, "sa");
        props.put(Environment.PASS, "123456");
        props.put(Environment.SHOW_SQL, "true");
        
        conf.setProperties(props);
        conf.addAnnotatedClass(CoSo.class);
        conf.addAnnotatedClass(ChiTietSP.class);
        conf.addAnnotatedClass(CuaHang.class);
        conf.addAnnotatedClass(DongSp.class);
        conf.addAnnotatedClass(DungLuong.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(Hang.class);
        conf.addAnnotatedClass(LoaiSp.class);
        conf.addAnnotatedClass(Account.class);
        conf.addAnnotatedClass(NguoiDung.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(HoaDonChiTiet.class);
        conf.addAnnotatedClass(GioHang.class);
        conf.addAnnotatedClass(GioHangChiTiet.class);
        conf.addAnnotatedClass(BaoHanh.class);
        conf.addAnnotatedClass(ChiTietBaoHanh.class);
        conf.addAnnotatedClass(ChucVu.class);
        
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        
        FACTORY = conf.buildSessionFactory(registry);
    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
    
    public static void main(String[] args) {
        getFACTORY();
    }
}
