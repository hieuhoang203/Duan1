/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.serviceImpl;

import java.util.ArrayList;
import modul.BaoHanh;
import repository.BaoHanhRepository;
import service.QuanLyBaoHanhService;

/**
 *
 * @author admin
 */
public class BaoHanhServiceImpl implements QuanLyBaoHanhService{
    private BaoHanhRepository baoHanhRepository;

    public BaoHanhServiceImpl() {
        baoHanhRepository = new BaoHanhRepository();
    }
    
    @Override
    public boolean checkMa(BaoHanh bh) {
        if (baoHanhRepository.selectMa().contains(bh.getMa())) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean checkData(BaoHanh bh) {
        if (!bh.getMa().equals("") && !bh.getTen().equals("") 
                && bh.getGia()>0 && bh.getThoiGian()>0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ArrayList<BaoHanh> select() {
        return baoHanhRepository.select();
    }

    @Override
    public boolean insert(BaoHanh bh) {
        if (checkData(bh) && checkMa(bh)) {
            baoHanhRepository.insert(bh);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Integer id, BaoHanh bh) {
        if (checkData(bh)) {
            baoHanhRepository.update(id, bh);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void delete(Integer id) {
        baoHanhRepository.delete(id);
    }

    @Override
    public BaoHanh search(String ten) {
        return baoHanhRepository.search(ten);
    }
    
}
