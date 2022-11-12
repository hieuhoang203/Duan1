/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import modul.Hang;

/**
 *
 * @author admin
 */
public interface QuanLyHangService {
    ArrayList<Hang> select();
    boolean insert(Hang h);
    boolean update(String id, Hang h);
    void delete(String id);
    boolean checkMa(Hang h);
    boolean checkData(Hang h);
}
