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
import javax.xml.crypto.Data;
import org.hibernate.annotations.ManyToAny;

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
    private int id;
    @Column (name = "Ma")
    private String ma;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "IdDongSp")
    private DongSp idDongSp;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "IdmauSac")
    private MauSac idMauSac;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "IdDungLuong")
    private DungLuong idDungLuong;
    @Column (name = "TrangThai")
    private int trangThai;
    @Column (name = "NgayThem")
    private Date ngayThem;
    @Column (name = "NgaySua")
    private Date ngaySua;

    
    
    public LoaiSp() {
    }

    

    @Override
    public String toString() {
        return ma;
    }
    
    
}
