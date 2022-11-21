/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.serviceImpl;

import java.util.ArrayList;
import modul.BaoHanh;
import modul.ChiTietBaoHanh;
import modul.HoaDon;
import repository.ChiTietBaoHanhRepository;
import service.QuanLyChiTietBaoHanhService;

/**
 *
 * @author admin
 */
public class ChiTietBaoHanhServiceImpl implements QuanLyChiTietBaoHanhService{
    private ChiTietBaoHanhRepository chiTietBaoHanhRepository = new ChiTietBaoHanhRepository();
    
    @Override
    public ArrayList<ChiTietBaoHanh> select(HoaDon hd) {
        return chiTietBaoHanhRepository.select(hd);
    }

    @Override
    public void inser(ChiTietBaoHanh ctbh) {
        chiTietBaoHanhRepository.insert(ctbh);
    }

    @Override
    public void delete(BaoHanh bh, HoaDon hd) {
        chiTietBaoHanhRepository.delete(bh, hd);
    }

    @Override
    public long tienBaoHanh(HoaDon hd) {
        return chiTietBaoHanhRepository.tienBaoHanh(hd);
    }
    
}
