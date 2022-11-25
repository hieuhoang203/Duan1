/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.serviceImpl;

import java.util.ArrayList;
import modul.DongSp;
import repository.DongSpRepository;
import service.QuanLyDongSpService;

/**
 *
 * @author admin
 */
public class DongSpServiceImpl implements QuanLyDongSpService{
    private DongSpRepository dongSpRepository;

    public DongSpServiceImpl() {
        dongSpRepository = new DongSpRepository();
    }
    
    @Override
    public ArrayList<DongSp> select() {
        return dongSpRepository.select();
    }

    @Override
    public boolean insert(DongSp dsp) {
        if (checkData(dsp) && checkMa(dsp)) {
            dongSpRepository.insert(dsp);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Integer id, DongSp dsp) {
        if (checkData(dsp)) {
            dongSpRepository.update(id, dsp);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void delete(Integer id) {
        dongSpRepository.delete(id);
    }

    @Override
    public boolean checkMa(DongSp dsp) {
        if (dongSpRepository.selectMa().contains(dsp.getMa())) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean checkData(DongSp dsp) {
        if (!dsp.getMa().equals("") && !dsp.getTen().equals("") && 
                dsp.getGiaNhap()>0 && dsp.getGiaBan()>0) {
            return true;
        } else {
            return false;
        }
    }
}
