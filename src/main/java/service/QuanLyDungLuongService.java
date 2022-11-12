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
    void insert(DungLuong dsp);
    void update(String id, DungLuong dl);
    void delete(String id);
    boolean checkMa(DungLuong dl);
    boolean checkData(DungLuong dl);
}
