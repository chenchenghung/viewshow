package com.nofacebox.viewshow.Repository;

import com.nofacebox.viewshow.Entity.Link;
import com.nofacebox.viewshow.Entity.LinkPk;
import com.nofacebox.viewshow.Model.LinkDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Map;
@Repository
public interface LinkRepositary extends JpaRepository<Link,Long> {
//    Link findById(LinkPk id);
    @Query(nativeQuery = true,
    value = "select m.mid,m.mname from link l " +
            "join theater t on l.tid=t.tid " +
            "join movie m on l.mid=m.mid " +
            "where l.tid=?1 and cast(now() as date) >= pubdate and cast(now() as date)<=offdate")
    List<Map<String,Object>> getAllMoviesByTheater(@Param("tid")Long tid );
    @Query(nativeQuery = true,
    value = "select a.aid,a.xdate from link l " +
            "join theater t on l.tid=t.tid " +
            "join movie m on l.mid=m.mid " +
            "join adate a on l.aid=a.aid " +
            "where l.tid=?1 and l.mid=?2")
    List<Map<String,Object>> getAllDatesByTheaterMovie(@Param("tid")Long tid , @Param("mid") Long mid);

    @Query(nativeQuery = true,
            value = "select l.linkid, t.tid, t.name, m.mid, m.mname,a.aid,a.xdate from link l " +
                    "join theater t on l.tid=t.tid " +
                    "join movie m on l.mid=m.mid " +
                    "join adate a on l.aid=a.aid " +
                    "where l.tid=?1 and cast(now() as date) > m.pubdate and cast(now() as date) <= m.offdate")
    List<Map<String,Object>> getLinkDTOByTheater(@Param("tid")Long tid );
}
