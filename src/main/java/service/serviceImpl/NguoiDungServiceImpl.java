/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.serviceImpl;

import java.util.ArrayList;
import modul.NguoiDung;
import repository.NguoiDungRepository;
import service.QuanLyNguoiDungService;

/**
 *
 * @author admin
 */
public class NguoiDungServiceImpl implements QuanLyNguoiDungService{
    private NguoiDungRepository nguoiDungRepository = new NguoiDungRepository();
    private static String email = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    
    @Override
    public boolean checkData(NguoiDung ng) {
        if (!ng.getHoTen().equals("") && !ng.getDiaChi().equals("") 
                && ng.getEmail().matches(email) && !ng.getAnh().equals("") && ng.getNgaySinh()!=null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkEmail(NguoiDung ng) {
        if (nguoiDungRepository.selectEmail().contains(ng.getEmail())) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean insert(NguoiDung ng) {
        if (checkData(ng) && checkEmail(ng)) {
            nguoiDungRepository.insert(ng);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Integer id, NguoiDung ng) {
        if (checkData(ng)) {
            nguoiDungRepository.update(id, ng);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void delete(Integer id) {
        nguoiDungRepository.delete(id);
    }

    @Override
    public ArrayList<NguoiDung> select() {
        return nguoiDungRepository.select();
    }

    @Override
    public ArrayList<NguoiDung> search(String name, int trang) {
        return nguoiDungRepository.search(name, trang);
    }

    @Override
    public NguoiDung searchByEmail(String email) {
        return nguoiDungRepository.searchByEmail(email);
    }

    @Override
    public ArrayList<NguoiDung> select(int trang) {
        return nguoiDungRepository.select(trang);
    }

}
