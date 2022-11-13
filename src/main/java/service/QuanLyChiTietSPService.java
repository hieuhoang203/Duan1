/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import modul.ChiTietSP;
import modul.DongSp;

/**
 *
 * @author admin
 */
public interface QuanLyChiTietSPService {
    ArrayList<ChiTietSP> select();
    boolean insert(ChiTietSP ctsp);
    boolean update(Integer id, ChiTietSP ctsp);
    void delete(Integer id);
    boolean checkData(ChiTietSP ctsp);
    ArrayList<ChiTietSP> search(Integer id);
    long totalUnsold(int trangThai, DongSp idDongSp); 
}
