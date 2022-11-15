package service.serviceImpl;

import java.util.ArrayList;
import modul.MauSac;
import repository.MauSacRepository;
import service.QuanLyMauSacService;

/**
 *
 * @author admin
 */
public class MauSacServiceImpl implements QuanLyMauSacService {

    private MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    public ArrayList<MauSac> select() {
        return mauSacRepository.select();
    }
    
    @Override
    public boolean insert(MauSac ms) {
        if (checkData(ms) && checkMa(ms)) {
            mauSacRepository.insert(ms);
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean update(Integer id, MauSac ms) {
        if (checkData(ms)) {
            mauSacRepository.update(id, ms);
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public void delete(Integer id) {
        mauSacRepository.delete(id);
    }
    
    @Override
    public boolean checkMa(MauSac ms) {
        if (mauSacRepository.selectMa().contains(ms.getMa())) {
            return false;
        }
        return true;
    }
    
    @Override
    public boolean checkData(MauSac ms) {
        if (!ms.getMa().equals("") && !ms.getTen().equals("")) {
            return true;
        }
        return false;
    }
    
}
