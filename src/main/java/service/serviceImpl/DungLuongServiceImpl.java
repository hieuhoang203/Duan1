/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.serviceImpl;

import java.util.ArrayList;
import modul.DungLuong;
import repository.DungLuongRepository;
import service.QuanLyDungLuongService;

/**
 *
 * @author admin
 */
public class DungLuongServiceImpl implements QuanLyDungLuongService {

    private DungLuongRepository dungLuongRepository;

    public DungLuongServiceImpl() {
        dungLuongRepository = new DungLuongRepository();
    }
    
    @Override
    public ArrayList<DungLuong> select() {
        return dungLuongRepository.select();
    }
    
    @Override
    public boolean insert(DungLuong dl) {
        if (checkData(dl) && checkMa(dl)) {
            dungLuongRepository.insert(dl);
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean update(Integer id, DungLuong dl) {
        if (checkData(dl)) {
            dungLuongRepository.update(id, dl);
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public void delete(Integer id) {
        dungLuongRepository.delete(id);
    }
    
    @Override
    public boolean checkMa(DungLuong dl) {
        if (dungLuongRepository.selectMa().contains(dl.getMa())) {
            return false;
        } else {
            return true;
        }
    }
    
    @Override
    public boolean checkData(DungLuong dl) {
        if (!dl.getMa().equals("") && !dl.getTen().equals("")) {
            return true;
        } else {
            return false;
        }
    }
    
}
