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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "DongSP")
public class DongSp implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    
    @Column(name = "Ma")
    private String ma;
    
    @Column(name = "Ten")
    private String Ten;
    
    @Column(name = "GiaNhap")
    private int giaNhap;
    
    @Column(name = "GiaBan")
    private int giaBan;
    
    @ManyToOne
    @JoinColumn(name = "IdHang")
    private Hang idHang;
    
    @Column(name = "NgayThem")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayThem;
    
    @Column(name = "NgaySua")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngaySua;
    
    @OneToMany(mappedBy = "idDongSp", fetch = FetchType.EAGER)
    private List<ChiTietSP> chiTietSPs;
    
    public DongSp() {
    }

    public DongSp(Integer id, String ma, String Ten, int giaNhap, int giaBan, Hang idHang, Date ngayThem, Date ngaySua, List<ChiTietSP> chiTietSPs) {
        this.id = id;
        this.ma = ma;
        this.Ten = Ten;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.idHang = idHang;
        this.ngayThem = new Date(new Date().getTime());
        this.ngaySua = ngaySua;
        this.chiTietSPs = chiTietSPs;
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
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public int getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(int giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public Hang getIdHang() {
        return idHang;
    }

    public void setIdHang(Hang idHang) {
        this.idHang = idHang;
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

    public List<ChiTietSP> getChiTietSPs() {
        return chiTietSPs;
    }

    public void setChiTietSPs(List<ChiTietSP> chiTietSPs) {
        this.chiTietSPs = chiTietSPs;
    }
    
    @Override
    public String toString() {
        return Ten;
    }
    
}
