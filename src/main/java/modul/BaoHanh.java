/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul;

import java.util.Date;
import java.util.List;
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
@Table(name = "BaoHanh")
public class BaoHanh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    
    @Column(name = "Ma")
    private String ma;
    
    @Column(name = "Ten")
    private String ten;
    
    @Column(name = "ThoiGian")
    private int thoiGian;
    
    @Column(name = "Gia")
    private int gia;
    
    @Column(name = "TrangThai")
    private int trangThai;

    @Column(name = "NgayThem")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayThem;
    
    @Column(name = "NgaySua")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngaySua;
    
    @OneToMany(mappedBy = "idBaoHanh", fetch = FetchType.LAZY)
    private List<ChiTietBaoHanh> chiTietBaoHanhs;

    public BaoHanh() {
    }

    public BaoHanh(Integer id, String ma, String ten, int thoiGian, int gia, int trangThai, Date ngayThem, Date ngaySua, List<ChiTietBaoHanh> chiTietBaoHanhs) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.thoiGian = thoiGian;
        this.gia = gia;
        this.trangThai = trangThai;
        this.ngayThem = new java.sql.Date(new Date().getTime());
        this.ngaySua = ngaySua;
        this.chiTietBaoHanhs = chiTietBaoHanhs;
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

    public int getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(int thoiGian) {
        this.thoiGian = thoiGian;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
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

    public List<ChiTietBaoHanh> getChiTietBaoHanhs() {
        return chiTietBaoHanhs;
    }

    public void setChiTietBaoHanhs(List<ChiTietBaoHanh> chiTietBaoHanhs) {
        this.chiTietBaoHanhs = chiTietBaoHanhs;
    }

    @Override
    public String toString() {
        return ten;
    }

}
