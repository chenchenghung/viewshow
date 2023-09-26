package com.nofacebox.viewshow.Repository;

import com.nofacebox.viewshow.Entity.Adate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface AdateRepositary extends JpaRepository<Adate,Long> {

    @Query(nativeQuery = true,
            value = "select a.aid from adate a where a.xdate= ?1")
    public Optional<Map<String,Object>> getAidByXdate(Date xdate) ;
}
