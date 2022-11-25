/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.serviceImpl;

import java.util.ArrayList;
import modul.ChucVu;
import repository.ChucVuRepo;
import service.QuanLyChucVuService;

/**
 *
 * @author admin
 */
public class ChucVuServiceImpl implements QuanLyChucVuService{
    private ChucVuRepo cvrp;

    public ChucVuServiceImpl() {
        cvrp = new ChucVuRepo();
    }
    
    @Override
    public boolean checkMa(ChucVu cv) {
        if (cvrp.selectMa().contains(cv.getMa()) ) {
            return false;
        }else
            return true;
    }

    @Override
    public boolean checkData(ChucVu cv) {
        if (!cv.getMa().equals("") && !cv.getTen().equals("") ) {
            return true;
        }else
            return false;
    }

    @Override
    public boolean insert(ChucVu cv) {
        if (checkMa(cv) && checkData(cv)) {
            cvrp.insert(cv);
            return true;
        }else
            return false;
    }

    @Override
    public boolean update(int id, ChucVu cv) {
        if (checkData(cv)) {
            cvrp.update(id, cv);
            return true;
        }else
            return false;
    }

    @Override
    public void delete(int id) {
        cvrp.delete(id);
    }

    @Override
    public ArrayList<ChucVu> select() {
        return cvrp.select();
    }
    
}
