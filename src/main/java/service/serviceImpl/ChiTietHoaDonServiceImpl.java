/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.serviceImpl;

import java.util.ArrayList;
import modul.ChiTietSP;
import modul.HoaDon;
import modul.HoaDonChiTiet;
import modul.LoaiSp;
import repository.HoaDonChiTietRepository;

import service.QuanLyChiTietHoaDonService;

/**
 *
 * @author admin
 */
public class ChiTietHoaDonServiceImpl implements QuanLyChiTietHoaDonService{
    private HoaDonChiTietRepository hoaDonChiTietRepository;

    public ChiTietHoaDonServiceImpl() {
        hoaDonChiTietRepository = new HoaDonChiTietRepository();
    }
    
    @Override
    public ArrayList<HoaDonChiTiet> select(HoaDon hd) {
        return hoaDonChiTietRepository.select(hd);
    }

    @Override
    public void insert(HoaDonChiTiet hdct) {
        hoaDonChiTietRepository.insert(hdct);
    }

    @Override
    public HoaDonChiTiet search(Integer id) {
        return hoaDonChiTietRepository.search(id);
    }

    @Override
    public long getThanhTien(HoaDon hd) {
        return hoaDonChiTietRepository.getTongTien(hd);
    }

    @Override
    public void delete(Integer id, HoaDon hd) {
        hoaDonChiTietRepository.delete(id, hd);
    }

    @Override
    public double percent(LoaiSp iLoaiSp) {
        return hoaDonChiTietRepository.percent(iLoaiSp);
    }
    
}
