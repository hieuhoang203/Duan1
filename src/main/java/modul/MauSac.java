/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private String id;
    
    @Column(name = "Ma")
    private String ma;
    
    @Column(name = "Ten")
    private String ten;
    
    @Column(name = "NgayThem")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayThem;
    
    @Column(name = "NgaySua")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngaySua;
    
    @OneToMany(mappedBy = "idMauSac")
    private ArrayList<ChiTietSP> chiTietSPs;

    public MauSac() {
        
    }

    public MauSac(String id, String ma, String ten, Date ngayThem, Date ngaySuaDate, ArrayList<ChiTietSP> chiTietSPs) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.ngayThem = new Date(new java.util.Date().getTime());
        this.ngaySua = ngaySuaDate;
        this.chiTietSPs = chiTietSPs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public ArrayList<ChiTietSP> getChiTietSPs() {
        return chiTietSPs;
    }

    public void setChiTietSPs(ArrayList<ChiTietSP> chiTietSPs) {
        this.chiTietSPs = chiTietSPs;
    }

    @Override
    public String toString() {
        return ten;
    }
    
}
