/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.serviceImpl;

import java.util.ArrayList;
import modul.LoaiSp;
import repository.LoaiSpRepository;
import service.QuanLyLoaiSpService;

/**
 *
 * @author admin
 */
public class LoaiSpServiceImpl implements QuanLyLoaiSpService{
    private LoaiSpRepository loaiSpRepository;

    public LoaiSpServiceImpl() {
        loaiSpRepository = new LoaiSpRepository();
    }
    
    @Override
    public ArrayList<LoaiSp> select() {
        return loaiSpRepository.select();
    }

    @Override
    public boolean insert(LoaiSp loaiSp) {
        if (checkMa(loaiSp) && !loaiSp.getMa().equals("")) {
            loaiSpRepository.insert(loaiSp);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Integer id, LoaiSp loaiSp) {
        if (!loaiSp.getMa().equals("")) {
            loaiSpRepository.update(id, loaiSp);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void delte(Integer id) {
        loaiSpRepository.delete(id);
    }

    @Override
    public boolean checkMa(LoaiSp loaiSp) {
        if (loaiSpRepository.selectMa().contains(loaiSp.getMa())) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public LoaiSp search(String ma) {
        return loaiSpRepository.search(ma);
    }
    
}
