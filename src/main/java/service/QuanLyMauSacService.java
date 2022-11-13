/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import modul.MauSac;

/**
 *
 * @author admin
 */
public interface QuanLyMauSacService {
    ArrayList<MauSac> select();
    boolean insert(MauSac h);
    boolean update(Integer id, MauSac ms);
    void delete(Integer id);
    boolean checkMa(MauSac ms);
    boolean checkData(MauSac ms);
}
