/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import modul.ChucVu;

/**
 *
 * @author admin
 */
public interface QuanLyChucVuService {
    boolean checkMa(ChucVu cv);
    boolean checkData(ChucVu cv);
    boolean insert(ChucVu cv);
    boolean update(int id, ChucVu cv);
    void delete(int id);
    ArrayList<ChucVu> select();
}
