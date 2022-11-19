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
    
    @Column(name = "TenDongSP")
    private String ten;
    
    @Column(name = "GiaNhap")
    private int giaNhap;
    
    @Column(name = "GiaBan")
    private int giaBan;
    
    @ManyToOne
    @JoinColumn(name = "IdHang")
    private Hang idHang;
    
    @Column(name = "TrangThai")
    private int trangThai;
    
    @Column(name = "NgayThem")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayThem;
    
    @Column(name = "NgaySua")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngaySua;
    
    @OneToMany(mappedBy = "idDongSp", fetch = FetchType.LAZY)
    private List<LoaiSp> loaiSps;
    
    
    public DongSp() {    
    }

    public DongSp(Integer id, String ma, String ten, int giaNhap, int giaBan, Hang idHang, int trangThai, Date ngayThem, Date ngaySua, List<LoaiSp> loaiSps) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.idHang = idHang;
        this.trangThai = trangThai;
        this.ngayThem = new java.sql.Date(new Date().getTime());
        this.ngaySua = ngaySua;
        this.loaiSps = loaiSps;
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
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

    public List<LoaiSp> getLoaiSps() {
        return loaiSps;
    }

    public void setLoaiSps(List<LoaiSp> loaiSps) {
        this.loaiSps = loaiSps;
    }

    @Override
    public String toString() {
        return ten;
    }

    
}
