/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import modul.HoaDon;
import modul.HoaDonChiTiet;
import modul.LoaiSp;

/**
 *
 * @author admin
 */
public interface QuanLyChiTietHoaDonService {
    ArrayList<HoaDonChiTiet> select(HoaDon hd);
    void insert(HoaDonChiTiet hdct);
    HoaDonChiTiet search(Integer id);
    long getThanhTien(HoaDon hd);
    void delete(Integer id, HoaDon hd);
    double percent(LoaiSp idLoaiSp);
}
