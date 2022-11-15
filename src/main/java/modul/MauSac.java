/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "MauSac")
public class MauSac implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    
    @Column(name = "Ma")
    private String ma;
    
    @Column(name = "Ten")
    private String ten;
    
    @Column(name = "TrangThai")
    private boolean trangThai;
    
    @Column(name = "NgayThem")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayThem;
    
    @Column(name = "NgaySua")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngaySua;
    
    @Column (name = "TrangThai")
    private int trangThai;
        
    @OneToMany(mappedBy = "idMauSac")
    private List<LoaiSp> loaSPs;

    public MauSac() {
        
    }

<<<<<<< HEAD
    public MauSac(Integer id, String ma, String ten, Date ngayThem, Date ngaySua, int trangThai, List<LoaiSp> loaSPs) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.ngayThem = ngayThem;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
        this.loaSPs = loaSPs;
=======
    public MauSac(Integer id, String ma, String ten, boolean trangThai, Date ngayThem, Date ngaySua, List<ChiTietSP> chiTietSPs) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
        this.ngayThem = new java.sql.Date(new java.util.Date().getTime());
        this.ngaySua = ngaySua;
        this.chiTietSPs = chiTietSPs;
>>>>>>> 0443d971bd2c5dec5afe790f62d7221fb58bea94
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayThem() {
        return ngayThem;
    }

    public void setNgayThem(Date ngayThem) {
        this.ngayThem = ngayThem;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

<<<<<<< HEAD
    public List<LoaiSp> getLoaSPs() {
        return loaSPs;
    }

    public void setLoaSPs(List<LoaiSp> loaSPs) {
        this.loaSPs = loaSPs;
    }

    
=======


>>>>>>> 0443d971bd2c5dec5afe790f62d7221fb58bea94
    @Override
    public String toString() {
        return ten;
    }
    
}
