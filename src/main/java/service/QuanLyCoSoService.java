/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import modul.CoSo;

/**
 *
 * @author admin
 */
public interface QuanLyCoSoService {
    ArrayList<CoSo> select();
    boolean insert(CoSo cs);
    boolean update(Integer id, CoSo cs);
    void delete(Integer id);
    boolean checkMa(CoSo cs);
    boolean checkData(CoSo cs);
}
