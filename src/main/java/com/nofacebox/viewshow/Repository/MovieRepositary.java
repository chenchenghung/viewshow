package com.nofacebox.viewshow.Repository;

import com.nofacebox.viewshow.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepositary extends JpaRepository<Movie,Long> {
}
