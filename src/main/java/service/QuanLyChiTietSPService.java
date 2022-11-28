/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import modul.ChiTietSP;
import modul.CuaHang;
import modul.DongSp;
import modul.DungLuong;
import modul.MauSac;

/**
 *
 * @author admin
 */
public interface QuanLyChiTietSPService {

    ArrayList<ChiTietSP> select();

    ArrayList<ChiTietSP> selectAll();

    ArrayList<ChiTietSP> search(CuaHang idCuaHang, DongSp idDongSp);

    ArrayList<ChiTietSP> search(CuaHang idCuaHang, MauSac idMauSac, DungLuong idDungLuong, DongSp idDongSp);

    boolean insert(ChiTietSP ctsp);

    boolean update(Integer id, ChiTietSP ctsp);

    void upload(Integer key);

    void delete(Integer key);

    boolean checkData(ChiTietSP ctsp);

    boolean checkImei(ChiTietSP ctsp);

    ArrayList<ChiTietSP> searchByStore(CuaHang ch);

    ChiTietSP searchById(Integer id);

    ArrayList<ChiTietSP> select(int trang, CuaHang ch);

}
