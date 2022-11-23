/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.serviceImpl;

import repository.EmailRepository;
import service.QuanLyGuiMailService;

/**
 *
 * @author admin
 */
public class GuiMailServiceImpl implements QuanLyGuiMailService{
    private EmailRepository emailRepository = new EmailRepository();
    
    @Override
    public void sendEmail(String email) {
        emailRepository.sendEmail(email);
    }
    
}
