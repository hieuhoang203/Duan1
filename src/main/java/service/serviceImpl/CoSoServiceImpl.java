/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.serviceImpl;

import java.util.ArrayList;
import modul.CoSo;
import repository.CoSoRepository;
import service.QuanLyCoSoService;

/**
 *
 * @author admin
 */
public class CoSoServiceImpl implements QuanLyCoSoService{
    private CoSoRepository coSoRepository = new CoSoRepository();
    
    @Override
    public ArrayList<CoSo> select() {
        return coSoRepository.select();
    }

    @Override
    public boolean insert(CoSo cs) {
        if (checkData(cs) && checkMa(cs)) {
            coSoRepository.insert(cs);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(String id, CoSo cs) {
        if (checkData(cs)) {
            coSoRepository.update(id, cs);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void delete(String id) {
        coSoRepository.delete(id);
    }

    @Override
    public boolean checkMa(CoSo cs) {
        if (coSoRepository.selectMa().contains(cs.getMa())) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean checkData(CoSo cs) {
        if (!cs.getMa().equals("") && !cs.getTen().equals("")) {
            return true;
        } else {
            return false;
        }
    }
    
}
