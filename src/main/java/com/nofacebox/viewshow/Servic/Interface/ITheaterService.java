package com.nofacebox.viewshow.Servic.Interface;

import com.nofacebox.viewshow.Entity.Theater;
import com.nofacebox.viewshow.Model.ResponseVo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ITheaterService {

    public Theater getTheater(Long id);

    public Theater saveTheater(Theater saveItem);

    public Theater modifyTheater(Theater modify);

    public ResponseVo deleteTheater(Long id);

//    public List<Map<String, Object>>getTheaterByRegion(String region);
    public List<Theater> getTheater(Set<String> ss);
}
