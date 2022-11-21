/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import modul.BaoHanh;
import modul.ChiTietBaoHanh;
import modul.HoaDon;

/**
 *
 * @author admin
 */
public interface QuanLyChiTietBaoHanhService {
    ArrayList<ChiTietBaoHanh> select(HoaDon hd);
    void inser(ChiTietBaoHanh ctbh);
    void delete(BaoHanh bh, HoaDon hd);
    long tienBaoHanh(HoaDon hd);
}
