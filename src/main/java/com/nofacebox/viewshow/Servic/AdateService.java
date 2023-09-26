package com.nofacebox.viewshow.Servic;

import com.nofacebox.viewshow.Entity.Adate;
import com.nofacebox.viewshow.Model.ResponseVo;
import com.nofacebox.viewshow.Repository.AdateRepositary;
import com.nofacebox.viewshow.Servic.Interface.IAdateService;
import com.nofacebox.viewshow.Utils.NativeQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
    public Long findAidbyDate(Date date) throws Exception {
        Map<String, Object> a = adateRepositary.getAidByXdate(new java.sql.Date(date.getTime())).orElseThrow(() -> new Exception("not found"));
        Long aid = Long.valueOf( a.get("aid").toString());
        return aid;
    }
}
