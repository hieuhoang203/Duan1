/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "ChiTietBaoHanh")
public class ChiTietBaoHanh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdHoaDon")
    private HoaDon idHoaDon;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdBaoHanh")
    private BaoHanh idBaoHanh;
    
    @Column(name = "NgayBaoHanh")
    private Date ngayBaoHanh;
    
    @Column(name = "NgayKetThuc")
    private Date ngayKetThuc;
    
    @Column(name = "TrangThai")
    private int trangThai;

    public ChiTietBaoHanh() {
    }

    public ChiTietBaoHanh(Integer id, HoaDon idHoaDon, BaoHanh idBaoHanh) {
        this.id = id;
        this.idHoaDon = idHoaDon;
        this.idBaoHanh = idBaoHanh;
        this.ngayBaoHanh = idHoaDon.getNgayMua();
        this.ngayKetThuc = new java.sql.Date(idHoaDon.getNgayMua().getTime() + TimeUnit.DAYS.toMillis(idBaoHanh.getThoiGian()*365));
        this.trangThai = 1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HoaDon getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(HoaDon idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public BaoHanh getIdBaoHanh() {
        return idBaoHanh;
    }

    public void setIdBaoHanh(BaoHanh idBaoHanh) {
        this.idBaoHanh = idBaoHanh;
    }

    public Date getNgayBaoHanh() {
        return ngayBaoHanh;
    }

    public void setNgayBaoHanh(Date ngayBaoHanh) {
        this.ngayBaoHanh = ngayBaoHanh;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return id.toString();
    }
      
}
