/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.serviceImpl;

import java.util.ArrayList;
import modul.ChiTietSP;
import modul.CuaHang;
import modul.DongSp;
import repository.ChiTietSpRepository;
import service.QuanLyChiTietSPService;

/**
 *
 * @author admin
 */
public class ChiTietSpServiceImpl implements QuanLyChiTietSPService{
    private ChiTietSpRepository chiTietSpRepository = new ChiTietSpRepository();
    
    @Override
    public ArrayList<ChiTietSP> select() {
        return chiTietSpRepository.select();
    }

    @Override
    public boolean insert(ChiTietSP ctsp) {
        if (checkData(ctsp) && checkImei(ctsp)) {
            chiTietSpRepository.insert(ctsp);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Integer id, ChiTietSP ctsp) {
        if (checkData(ctsp)) {
            chiTietSpRepository.update(id, ctsp);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void delete(Integer id) {
        chiTietSpRepository.delete(id);
    }

    @Override
    public boolean checkData(ChiTietSP ctsp) {
        if (ctsp.getImei().length() == 16) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ArrayList<ChiTietSP> search(String key) {
        return chiTietSpRepository.search(key);
    }

    @Override
    public boolean checkImei(ChiTietSP ctsp) {
        if (chiTietSpRepository.selectImei().contains(ctsp.getImei())) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public ArrayList<ChiTietSP> searchByStore(CuaHang ch) {
        return chiTietSpRepository.searchByStore(ch);
    }

    @Override
    public ChiTietSP searchById(Integer id) {
        return chiTietSpRepository.searchById(id);
    }

    @Override
    public ArrayList<ChiTietSP> select(int trang) {
        return chiTietSpRepository.select(trang);
    }
    
}
