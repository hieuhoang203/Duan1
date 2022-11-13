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
            
        }
    }

    @Override
    public boolean update(Integer id, CuaHang ch) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
