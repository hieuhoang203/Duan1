/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import modul.ChiTietSP;

/**
 *
 * @author admin
 */
public interface QuanLyChiTietSPService {
    ArrayList<ChiTietSP> select();
    boolean insert(ChiTietSP ctsp);
    boolean update(Integer id, ChiTietSP ctsp);
    void delete(Integer id);
    boolean checkMa(ChiTietSP ctsp);
    boolean checkData(ChiTietSP ctsp);
    ChiTietSP search(Integer id);
}
