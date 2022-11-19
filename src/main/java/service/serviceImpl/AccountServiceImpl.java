/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.serviceImpl;

import modul.Account;
import modul.NguoiDung;
import repository.AccountRepository;
import service.QuanLyAccountService;

/**
 *
 * @author admin
 */
public class AccountServiceImpl implements QuanLyAccountService{
    private static String pass = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    private AccountRepository accountRepository = new AccountRepository();
            
    @Override
    public boolean checkPass(Account acc) {
        if (acc.getPassWord().matches(pass)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void insert(Account acc) {
        accountRepository.insert(acc);
    }

    @Override
    public boolean update(String user, String pass) {
        if (pass.matches(pass)) {
            accountRepository.update(user, pass);
            return true;
        } else { 
            return false;
        }
    }

    @Override
    public void delete(String email) {
        accountRepository.delete(email);
    }

    @Override
    public Account search(String user, String pass) {
        return accountRepository.search(user, pass);
    }
    
}
