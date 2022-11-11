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
@Table(name = "ChiTietSP")
public class ChiTietSP implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private String id;
     
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDongSP")
    private DongSp idDongSp;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdMauSac")
    private MauSac idMauSac;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDungLuong")
    private DungLuong idDungLuong;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCuaHang")
    private CuaHang idCuaHang;
    
    @Column(name = "NgayThem")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayThem;
    
    @Column(name = "NgaySua")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngaySua;
    
    @Column(name = "SoLuong")
    private int soLuong;
    
    @Column(name = "TrangThai")
    private int trangThai;

    public ChiTietSP() {
    }

    public ChiTietSP(String id, DongSp idDongSp, MauSac idMauSac, DungLuong idDungLuong, CuaHang idCuaHang, Date ngayThem, Date ngaySua, int soLuong, int trangThai) {
        this.id = id;
        this.idDongSp = idDongSp;
        this.idMauSac = idMauSac;
        this.idDungLuong = idDungLuong;
        this.idCuaHang = idCuaHang;
        this.ngayThem = new Date(new java.util.Date().getTime());
        this.ngaySua = ngaySua;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DongSp getIdDongSp() {
        return idDongSp;
    }

    public void setIdDongSp(DongSp idDongSp) {
        this.idDongSp = idDongSp;
    }

    public MauSac getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(MauSac idMauSac) {
        this.idMauSac = idMauSac;
    }

    public DungLuong getIdDungLuong() {
        return idDungLuong;
    }

    public void setIdDungLuong(DungLuong idDungLuong) {
        this.idDungLuong = idDungLuong;
    }

    public CuaHang getIdCuaHang() {
        return idCuaHang;
    }

    public void setIdCuaHang(CuaHang idCuaHang) {
        this.idCuaHang = idCuaHang;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
}
