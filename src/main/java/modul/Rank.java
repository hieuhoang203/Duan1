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

/**
 *
 * @author DieuThuy
 */
@Entity
@Table (name = "Rank")
public class Rank {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "Id")
    private int id;
    
    @Column(name = "Ma")
    private String ma;
    
    @Column (name = "Ten")
    private String ten;
    
    @Column (name = "MucChi")
    private double mucChi;
    
    @Column (name = "NgayThem")
    private Date ngayThem;
    
    @Column (name = "NgaySua")
    private Date ngaySua;
    
    @Column (name = "TrangThai")
    private int trangThai;

    @OneToMany(mappedBy = "idRank", fetch = FetchType.LAZY)
    private List<NguoiDung> nguoiDungs;
            
    public Rank() {
    }

    public Rank(int id, String ma, String ten, double mucChi, int trangThai, Date ngayThem, Date ngaySua, List<NguoiDung> nguoiDungs) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.mucChi = mucChi;
        this.ngayThem = new java.sql.Date(new Date().getTime());
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
        this.nguoiDungs = nguoiDungs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public double getMucChi() {
        return mucChi;
    }

    public void setMucChi(double mucChi) {
        this.mucChi = mucChi;
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
