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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    
    @Column(name = "Ma")
    private String ma;
    
    @OneToOne
    @JoinColumn(name = "IdNguoiDung")
    private NguoiDung idNguoiDung;
    
    @Column(name = "NgayMua")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayMua;
    
    @Column(name = "Sdt")
    private String sdt;
    
    @Column(name = "DiaChi")
    private String diaChi;
    
    @Column(name = "TongTien")
    private static double tongTien;
    
    @Column(name = "TinhTrang")
    private int tinhTrang;
    
    @OneToMany(mappedBy = "idHoaDon", fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> hoaDonChiTiets;
    
    @OneToMany(mappedBy = "idHoaDon", fetch = FetchType.LAZY)
    private List<ChiTietBaoHanh> chiTietBaoHanhs;

    public HoaDon() {
    }

    public HoaDon(Integer id, String ma, NguoiDung idNguoiDung, Date ngayMua, String sdt, String diaChi, int tinhTrang, List<HoaDonChiTiet> hoaDonChiTiets, List<ChiTietBaoHanh> chiTietBaoHanhs) {
        this.id = id;
        this.ma = ma;
        this.idNguoiDung = idNguoiDung;
        this.ngayMua = ngayMua;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.tongTien = 0;
        this.tinhTrang = tinhTrang;
        this.hoaDonChiTiets = hoaDonChiTiets;
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

    public NguoiDung getIdNguoiDung() {
        return idNguoiDung;
    }

    public void setIdNguoiDung(NguoiDung idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public static double getTongTien() {
        return tongTien;
    }

    public static void setTongTien(double tongTien) {
        HoaDon.tongTien = tongTien;
    }
    

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public List<HoaDonChiTiet> getHoaDonChiTiets() {
        return hoaDonChiTiets;
    }

    public void setHoaDonChiTiets(List<HoaDonChiTiet> hoaDonChiTiets) {
        this.hoaDonChiTiets = hoaDonChiTiets;
    }

    public List<ChiTietBaoHanh> getChiTietBaoHanhs() {
        return chiTietBaoHanhs;
    }

    public void setChiTietBaoHanhs(List<ChiTietBaoHanh> chiTietBaoHanhs) {
        this.chiTietBaoHanhs = chiTietBaoHanhs;
    }

    @Override
    public String toString() {
        return ma;
    }
    
}
