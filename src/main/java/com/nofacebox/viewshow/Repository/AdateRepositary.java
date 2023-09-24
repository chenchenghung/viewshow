package com.nofacebox.viewshow.Repository;

import com.nofacebox.viewshow.Entity.Adate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdateRepositary extends JpaRepository<Adate,Long> {

}
