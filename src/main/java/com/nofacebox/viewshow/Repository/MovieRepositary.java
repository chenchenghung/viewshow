package com.nofacebox.viewshow.Repository;

import com.nofacebox.viewshow.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface MovieRepositary extends JpaRepository<Movie,Long> {

    @Query(nativeQuery = true,
            value = "select * from movie m where now() >=m.pubdate and now() <= m.offdate")
    public Optional<List<Map<String,Object>>> getAllMovies() ;
}
