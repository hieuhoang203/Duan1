/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import org.hibernate.Session;
import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import modul.CuaHang;

/**
 *
 * @author admin
 */
public class CuaHangRepository {
    private static Session session = HibernateConfig.getFACTORY().openSession();
    
}
