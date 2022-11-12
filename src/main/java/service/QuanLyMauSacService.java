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
    void insert(MauSac h);
    void update(String id, MauSac ms);
    void delete(String id);
    boolean checkMa(MauSac ms);
    boolean checkData(MauSac ms);
}
