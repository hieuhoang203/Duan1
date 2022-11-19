/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import modul.BaoHanh;

/**
 *
 * @author admin
 */
public interface QuanLyBaoHanhService {
    boolean checkMa(BaoHanh bh);
    boolean checkData(BaoHanh bh);
    ArrayList<BaoHanh> select();
    boolean insert(BaoHanh bh);
    boolean update(Integer id, BaoHanh bh);
    void delete(Integer id);
}
