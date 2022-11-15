/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul;

import java.util.Date;
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
 * @author DieuThuy
 */

@Entity
@Table (name = "LoaiSanPham")
public class LoaiSp {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "Id")
    private Integer id;
    
    @Column (name = "Ma")
    private String ma;
    
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "IdDongSp")
    private DongSp idDongSp;
    
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "IdMauSac")
    private MauSac idMauSac;
    
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "IdDungLuong")
    private DungLuong idDungLuong;
    
    @Column (name = "TrangThai")
    private int trangThai;
    
    @Column (name = "NgayTao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayThem;
    
    @Column (name = "NgaySua")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngaySua;
    
    public LoaiSp() {
    }

    public LoaiSp(Integer id, String ma, DongSp idDongSp, MauSac idMauSac, DungLuong idDungLuong, int trangThai, Date ngayThem, Date ngaySua) {
        this.id = id;
        this.ma = ma;
        this.idDongSp = idDongSp;
        this.idMauSac = idMauSac;
        this.idDungLuong = idDungLuong;
        this.trangThai = trangThai;
        this.ngayThem = new java.sql.Date(new Date().getTime());
        this.ngaySua = ngaySua;
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

    @Override
    public String toString() {
        return ma;
    }
    
    
}
