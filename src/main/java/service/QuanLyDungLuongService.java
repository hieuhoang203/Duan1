/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import modul.DungLuong;

/**
 *
 * @author admin
 */
public interface QuanLyDungLuongService {
    ArrayList<DungLuong> select();
    boolean insert(DungLuong dsp);
    boolean update(Integer id, DungLuong dl);
    void delete(Integer id);
    boolean checkMa(DungLuong dl);
    boolean checkData(DungLuong dl);
}
