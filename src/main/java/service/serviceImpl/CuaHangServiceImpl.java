/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.serviceImpl;

import java.util.ArrayList;
import modul.CuaHang;
import repository.CuaHangRepository;
import service.QuanLyCuaHangService;

/**
 *
 * @author admin
 */
public class CuaHangServiceImpl implements QuanLyCuaHangService{

    private CuaHangRepository cuaHangRepository = new CuaHangRepository();

    @Override
    public ArrayList<CuaHang> select() {
        return cuaHangRepository.select();
    }

    @Override
    public boolean insert(CuaHang ch) {
        if (checkData(ch) && checkMa(ch)) {
            cuaHangRepository.insert(ch);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Integer id, CuaHang ch) {
        if (checkData(ch)) {
            cuaHangRepository.update(id, ch);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void delete(Integer id) {
        cuaHangRepository.delete(id);
    }

    @Override
    public boolean checkMa(CuaHang ch) {
        if (cuaHangRepository.selectMa().contains(ch.getMa())) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean checkData(CuaHang ch) {
        if (!ch.getMa().equals("") && !ch.getTen().equals("") && !ch.getDiaChi().equals("")) {
            return true;
        } else {
            return false;
        }
    }

}
