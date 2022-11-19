/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import modul.NguoiDung;

/**
 *
 * @author admin
 */
public interface QuanLyNguoiDungService {
    boolean checkData(NguoiDung ng);
    boolean checkEmail(NguoiDung ng);
    boolean insert(NguoiDung ng);
    boolean update(Integer id, NguoiDung ng);
    void delete(Integer id);
    ArrayList<NguoiDung> select();
    ArrayList<NguoiDung> search(String name);
    NguoiDung searchByEmail(String email);
}
