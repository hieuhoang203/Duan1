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

    public MauSac(Integer id, String ma, String ten, Date ngayThem, Date ngaySua, int trangThai, List<LoaiSp> loaSPs) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.ngayThem = ngayThem;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
        this.loaSPs = loaSPs;
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

    public List<LoaiSp> getLoaSPs() {
        return loaSPs;
    }

    public void setLoaSPs(List<LoaiSp> loaSPs) {
        this.loaSPs = loaSPs;
    }

    
    @Override
    public String toString() {
        return ten;
    }
    
}
