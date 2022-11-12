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
    void insert(CuaHang ch);
    void update(String id, CuaHang ch);
    void delete(String id);
    boolean checkMa(CuaHang ch);
    boolean checkData(CuaHang ch);
}
