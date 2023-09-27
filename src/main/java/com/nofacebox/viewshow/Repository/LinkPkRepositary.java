package com.nofacebox.viewshow.Repository;

import com.nofacebox.viewshow.Entity.LinkPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkPkRepositary extends JpaRepository<LinkPk,Long> {

}
