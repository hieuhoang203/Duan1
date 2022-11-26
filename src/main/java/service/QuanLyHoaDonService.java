/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import modul.HoaDon;
import modul.NguoiDung;

/**
 *
 * @author admin
 */
public interface QuanLyHoaDonService {
    ArrayList<HoaDon> select(NguoiDung ng);
    ArrayList<HoaDon> select(int trang, NguoiDung ng);
    ArrayList<HoaDon> selectByTrangThai(NguoiDung ng, int trangThai);
    boolean insert(HoaDon hd);
    boolean update(String maHd);
    HoaDon searchByMa(String ma);
    void updateTongTien(Integer id, long tongTien);
    long turnover(int month);
}
