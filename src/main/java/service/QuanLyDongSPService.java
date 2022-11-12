/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import modul.DongSp;

/**
 *
 * @author admin
 */
public interface QuanLyDongSPService {
    ArrayList<DongSp> select();
    boolean insert(DongSp dsp);
    boolean update(String id, DongSp dsp);
    void delete(String id);
    boolean checkMa(DongSp dsp);
    boolean checkData(DongSp dsp);
}
