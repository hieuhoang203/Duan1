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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "NguoiDung")
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    
    @Column(name = "Ma")
    private String ma;
    
    @Column(name = "HoTen")
    private String hoTen;
    
    @Column(name = "GioiTinh")
    private int gioiTinh;
    
    @Column(name = "Sdt")
    private String sdt;
    
    @Column(name = "DiaChi")
    private String diaChi;
    
    @Column(name = "ThanhPho")
    private String thanhPho;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdChucVu")
    private ChucVu idChucVu;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdRank")
    private Rank idRank;
    
    @Column(name = "TrangThai")
    private int trangThai;
    
    @Column(name = "NgayThem")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayThem;
    
    @Column(name = "NgaySua")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngaySua;
    
    @OneToMany(mappedBy = "idNguoiDung", fetch = FetchType.LAZY)
    List<HoaDon> hoaDons;
    
    @OneToOne(mappedBy = "idNguoiDung", fetch = FetchType.LAZY)
    GioHang gioHangs;
    
    @OneToOne(mappedBy = "idNguoiDung")
    private Account idAccount;

    public NguoiDung() {
    }

    public NguoiDung(int id, String ma, String hoTen, int gioiTinh, String sdt, String diaChi, String thanhPho, ChucVu idChucVu, Rank idRank, int trangThai, Date ngayThem, Date ngaySua, List<HoaDon> hoaDons, GioHang gioHangs, Account acc) {
        this.id = id;
        this.ma = ma;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.idChucVu = idChucVu;
        this.idRank = idRank;
        this.trangThai = trangThai;
        this.ngayThem = new java.sql.Date(new Date().getTime());
        this.ngaySua = ngaySua;
        this.hoaDons = hoaDons;
        this.gioHangs = gioHangs;
        this.idAccount = acc;
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

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        if (gioiTinh == 1) {
            return "Nam";
        } else {
            return "Nữ";
        }
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
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

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }

    public ChucVu getIdChucVu() {
        return idChucVu;
    }

    public void setIdChucVu(ChucVu idChucVu) {
        this.idChucVu = idChucVu;
    }

    public Rank getIdRank() {
        return idRank;
    }

    public void setIdRank(Rank idRank) {
        this.idRank = idRank;
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

    public List<HoaDon> getHoaDons() {
        return hoaDons;
    }

    public void setHoaDons(List<HoaDon> hoaDons) {
        this.hoaDons = hoaDons;
    }

    public GioHang getGioHangs() {
        return gioHangs;
    }

    public void setGioHangs(GioHang gioHangs) {
        this.gioHangs = gioHangs;
    }

    public Account getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Account idAccount) {
        this.idAccount = idAccount;
    }

    @Override
    public String toString() {
        return hoTen;
    }

}
