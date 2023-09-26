package com.nofacebox.viewshow.Repository;

import com.nofacebox.viewshow.Entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Repository
public interface TheaterRepositary extends JpaRepository<Theater,Long> {
    @Query(nativeQuery = true,
            value = "select * from theater t where t.region=?1")
    public Optional<List<Map<String,String>>> getTheaterByRegion(@Param("region") String region) ;

}
