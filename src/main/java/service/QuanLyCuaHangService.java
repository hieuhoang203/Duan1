/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import modul.CuaHang;

/**
 *
 * @author admin
 */
public interface QuanLyCuaHangService {
    ArrayList<CuaHang> select();
    boolean insert(CuaHang ch);
    boolean update(Integer id, CuaHang ch);
    void delete(Integer id);
    boolean checkMa(CuaHang ch);
    boolean checkData(CuaHang ch);
    CuaHang search(Integer id);
}
