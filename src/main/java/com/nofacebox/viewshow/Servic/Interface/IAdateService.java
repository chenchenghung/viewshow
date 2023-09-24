package com.nofacebox.viewshow.Servic.Interface;

import com.nofacebox.viewshow.Entity.Adate;
import com.nofacebox.viewshow.Model.ResponseVo;

import java.util.Date;

public interface IAdateService {
    public Adate getAdate(long id);

    public  Adate saveAdate(Adate saveItem);

    public Adate modifyAdate(Adate modify);

    public ResponseVo deleteAdate(long id);

    public long findAidbyDate(Date date);

}
