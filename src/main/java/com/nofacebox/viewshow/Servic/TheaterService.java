package com.nofacebox.viewshow.Servic;

import com.nofacebox.viewshow.Entity.Theater;
import com.nofacebox.viewshow.Model.ResponseVo;
import com.nofacebox.viewshow.Repository.TheaterRepositary;
import com.nofacebox.viewshow.Servic.Interface.ITheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
@Service
public class TheaterService implements ITheaterService {
    @Autowired
    private TheaterRepositary theaterRepositary;
    @Override
    public Theater getTheater(Long id) {
        return theaterRepositary.findById(id).orElse(null) ;
    }

    @Override
    public Theater saveTheater(Theater saveItem) {
        return theaterRepositary.save(saveItem);
    }

    @Override
    public Theater modifyTheater(Theater modify) {
        return theaterRepositary.save(modify);
    }

    @Override
    public ResponseVo deleteTheater(Long id) {
        ResponseVo res = new ResponseVo();
        if(theaterRepositary.findById(id).isPresent()){
            theaterRepositary.deleteById(id);
            res.setMessage("OK");
        }else{
            res.setMessage("FAILED");
        }
        return res;
    }


    @Override
    public List<Theater> getTheater(Set<String> ss) {
        return null;
    }
}
