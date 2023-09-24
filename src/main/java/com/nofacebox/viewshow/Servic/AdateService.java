package com.nofacebox.viewshow.Servic;

import com.nofacebox.viewshow.Entity.Adate;
import com.nofacebox.viewshow.Model.ResponseVo;
import com.nofacebox.viewshow.Repository.AdateRepositary;
import com.nofacebox.viewshow.Servic.Interface.IAdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AdateService implements IAdateService {
    @Autowired
    private AdateRepositary adateRepositary;
    @Override
    public Adate getAdate(long id) {
        return adateRepositary.findById(id).orElse(null);
    }

    @Override
    public Adate saveAdate(Adate saveItem) {
        return adateRepositary.save(saveItem);
    }

    @Override
    public Adate modifyAdate(Adate modify) {
        return adateRepositary.save(modify);
    }

    @Override
    public ResponseVo deleteAdate(long id) {
        ResponseVo res = new ResponseVo();
        if(adateRepositary.findById(id).isPresent()){
            adateRepositary.deleteById(id);
            res.setMessage("OK");
        }else{
            res.setMessage("FAILED");
        }
        return res;
    }

    @Override
    public long findAidbyDate(Date date) {
        return 0;
    }
}
