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
@Table(name = "ChiTietSP")
public class ChiTietSP implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Imei")
    private String imei;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLoaiSp")
    private LoaiSp idLoaiSp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCuaHang")
    private CuaHang idCuaHang;

    @Column(name = "TrangThai")
    private int trangThai;

    @Column(name = "NgayThem")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayThem;

    @Column(name = "NgaySua")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngaySua;
    
    @OneToMany (mappedBy = "idSanPham", fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> hoaDonChiTiets;
    
    @OneToMany (mappedBy = "idSanPham", fetch = FetchType.LAZY)
    private List<GioHangChiTiet> gioHangChiTiets;

    public ChiTietSP() {
    }

    public ChiTietSP(Integer id, String imei, LoaiSp idLoaiSp, CuaHang idCuaHang, int trangThai, Date ngayThem, Date ngaySua, List<HoaDonChiTiet> hoaDonChiTiets, List<GioHangChiTiet> gioHangChiTiets) {
        this.id = id;
        this.imei = imei;
        this.idLoaiSp = idLoaiSp;
        this.idCuaHang = idCuaHang;
        this.trangThai = trangThai;
        this.ngayThem = new java.sql.Date(new Date().getTime());
        this.ngaySua = ngaySua;
        this.hoaDonChiTiets = hoaDonChiTiets;
        this.gioHangChiTiets = gioHangChiTiets;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public LoaiSp getIdLoaiSp() {
        return idLoaiSp;
    }

    public void setIdLoaiSp(LoaiSp idLoaiSp) {
        this.idLoaiSp = idLoaiSp;
    }

    public CuaHang getIdCuaHang() {
        return idCuaHang;
    }

    public void setIdCuaHang(CuaHang idCuaHang) {
        this.idCuaHang = idCuaHang;
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

    public List<HoaDonChiTiet> getHoaDonChiTiets() {
        return hoaDonChiTiets;
    }

    public void setHoaDonChiTiets(List<HoaDonChiTiet> hoaDonChiTiets) {
        this.hoaDonChiTiets = hoaDonChiTiets;
    }

    public List<GioHangChiTiet> getGioHangChiTiets() {
        return gioHangChiTiets;
    }

    public void setGioHangChiTiets(List<GioHangChiTiet> gioHangChiTiets) {
        this.gioHangChiTiets = gioHangChiTiets;
    }

    @Override
    public String toString() {
        return this.idLoaiSp.getMa();
    }

}
