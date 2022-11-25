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
@Table(name = "CuaHang")
public class CuaHang implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    
    @Column(name = "Ma")
    private String ma;
    
    @Column(name = "Ten")
    private String ten;
    
    @Column(name = "DiaChi")
    private String diaChi;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCoSo")
    private CoSo idCoSo;
    
    @Column(name = "TrangThai")
    private int trangThai;
    
    @Column(name = "NgayThem")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayThem;
    
    @Column(name = "NgaySua")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngaySua;

    @OneToMany(mappedBy = "idCuaHang", fetch = FetchType.LAZY)
    private List<ChiTietSP> chiTietSPs;
    
    @OneToMany(mappedBy = "idCuaHang", fetch = FetchType.LAZY)
    private List<NguoiDung> nguoiDungs;
    
    public CuaHang() {
    }
    
    public CuaHang(Integer id){
        this.id = id;
    }

    public CuaHang(Integer id, String ma, String ten, String diaChi, CoSo idCoSo, int trangThai, Date ngayThem, Date ngaySua, List<ChiTietSP> chiTietSPs, List<NguoiDung> nguoiDungs) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.idCoSo = idCoSo;
        this.trangThai = trangThai;
        this.ngayThem = new java.sql.Date(new Date().getTime());
        this.ngaySua = ngaySua;
        this.chiTietSPs = chiTietSPs;
        this.nguoiDungs = nguoiDungs;
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

    public List<ChiTietSP> getChiTietSPs() {
        return chiTietSPs;
    }

    public void setChiTietSPs(List<ChiTietSP> chiTietSPs) {
        this.chiTietSPs = chiTietSPs;
    }

    public List<NguoiDung> getNguoiDungs() {
        return nguoiDungs;
    }

    public void setNguoiDungs(List<NguoiDung> nguoiDungs) {
        this.nguoiDungs = nguoiDungs;
    }

    @Override
    public String toString() {
        return ten;
    }
    
}
