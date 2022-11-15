/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import modul.LoaiSp;

/**
 *
 * @author admin
 */
public interface QuanLyLoaiSpService {
    ArrayList<LoaiSp> select();
    boolean insert(LoaiSp loaiSp);
    boolean update(Integer id, LoaiSp loaiSp);
    void delte(Integer id);
    boolean checkMa(LoaiSp loaiSp);
}
