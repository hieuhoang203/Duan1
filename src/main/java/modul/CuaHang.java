/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "CuaHang")
public class CuaHang implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private String id;
    
    @Column(name = "Ma")
    private String ma;
    
    @Column(name = "Ten")
    private String ten;
    
    @Column(name = "DiaChi")
    private String diaChi;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCoSo")
    private CoSo idCoSo;
    
    @Column(name = "NgayThem")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayThem;
    
    @Column(name = "NgaySua")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngaySua;

    public CuaHang() {
    }

    public CuaHang(String id, String ma, String ten, String diaChi, CoSo idCoSo, Date ngayThem, Date ngaySua) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.idCoSo = idCoSo;
        this.ngayThem = new Date(new java.util.Date().getTime());
        this.ngaySua = ngaySua;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public CoSo getIdCoSo() {
        return idCoSo;
    }

    public void setIdCoSo(CoSo idCoSo) {
        this.idCoSo = idCoSo;
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

    @Override
    public String toString() {
        return ten;
    }
    
}
