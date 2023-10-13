package com.nofacebox.viewshow.Repository;

import com.nofacebox.viewshow.Entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SessionRepositary extends JpaRepository<Session, Long> {

    @Query(nativeQuery = true,
            value = "select s.sid, s.linkid, s.avadate, s.avasession, s.hall, s.sid as xvalue, s.avasession as xtext from sessions s " +
                    "join link l on s.linkid=l.linkid " +
                    "join theater t on l.tid=t.tid " +
                    "join movie m on l.mid=m.mid " +
                    "join adate a on l.aid=a.aid " +
                    "where t.tid=?1 and m.mid=?2 and a.aid=?3 ")
    List<Map<String,Object>> getSessionDTOByLinkind( @Param("tid") Long tid,@Param("mid") Long mid,@Param("aid") Long aid);

//    static final String seat=":seat";
//    @Modifying
//    @Query(nativeQuery = true ,
//            value = "update sessions s set "+seat+" = ?2 where s.sid =:sid")
//    int bookSession(@Param("seat") String seat ,@Param("bookid") String bookid ,@Param("sid") Long sid);

}


