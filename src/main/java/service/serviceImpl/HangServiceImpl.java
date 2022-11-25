/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.serviceImpl;

import java.util.ArrayList;
import modul.Hang;
import repository.HangRepository;
import service.QuanLyHangService;

/**
 *
 * @author admin
 */
public class HangServiceImpl implements QuanLyHangService{
    private HangRepository hangRepository;

    public HangServiceImpl() {
        hangRepository = new HangRepository();
    }

    @Override
    public ArrayList<Hang> select() {
        return hangRepository.select();
    }

    @Override
    public boolean insert(Hang h) {
        if (checkData(h) && checkMa(h)) {
            hangRepository.insert(h);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Integer id, Hang h) {
        if (checkData(h)) {
            hangRepository.update(id, h);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void delete(Integer id) {
        hangRepository.delete(id);
    }

    @Override
    public boolean checkMa(Hang h) {
        if (hangRepository.selectMa().contains(h.getMa())) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public boolean checkData(Hang h) {
        if (!h.getMa().equals("") && !h.getTen().equals("")) {
            return true;
        } else {
            return false;
        }
    }
}
