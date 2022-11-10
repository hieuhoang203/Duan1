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
import javax.persistence.FetchType;
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
@Table(name = "CoSo")
public class CoSo implements Serializable{
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
    
    @OneToMany(mappedBy = "idCoSo", fetch = FetchType.LAZY)
    private ArrayList<CuaHang> cuaHangs;

    public CoSo() {
    }

    public CoSo(String id, String ma, String ten, Date ngayThem, Date ngaySuaDate, ArrayList<CuaHang> cuaHangs) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.ngayThem = new Date(new java.util.Date().getTime());
        this.ngaySua = ngaySuaDate;
        this.cuaHangs = cuaHangs;
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

    public ArrayList<CuaHang> getCuaHangs() {
        return cuaHangs;
    }

    public void setCuaHangs(ArrayList<CuaHang> cuaHangs) {
        this.cuaHangs = cuaHangs;
    }

    @Override
    public String toString() {
        return ten;
    }
    
}
