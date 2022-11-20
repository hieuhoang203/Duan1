/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.serviceImpl;

import java.util.ArrayList;
import modul.HoaDon;
import modul.NguoiDung;
import repository.HoaDonRepository;
import service.QuanLyHoaDonService;

/**
 *
 * @author admin
 */
public class HoaDonServiceImpl implements QuanLyHoaDonService{
    private HoaDonRepository hoaDonRepository = new HoaDonRepository();
    
    @Override
    public ArrayList<HoaDon> select(NguoiDung ng) {
        return hoaDonRepository.select(ng);
    }

    @Override
    public ArrayList<HoaDon> selectByTrangThai(NguoiDung ng, int trangThai) {
        return hoaDonRepository.selectByTrangThai(ng, trangThai);
    }

    @Override
    public boolean insert(HoaDon hd) {
        try {
            hoaDonRepository.insert(hd);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(String maHd) {
        try {
            hoaDonRepository.update(maHd);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public HoaDon searchByMa(String ma) {
        return hoaDonRepository.searchByMa(ma);
    }

    @Override
    public void updateTongTien(Integer id, long tongTien) {
        hoaDonRepository.updateTongTien(id, tongTien);
    }
    
}
