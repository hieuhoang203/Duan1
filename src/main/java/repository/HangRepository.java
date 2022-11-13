/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import hibernateConfig.HibernateConfig;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class HangRepository {
   private Session session=HibernateConfig.getFACTORY().openSession();
  
}
