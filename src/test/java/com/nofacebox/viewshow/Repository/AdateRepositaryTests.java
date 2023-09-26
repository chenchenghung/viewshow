package com.nofacebox.viewshow.Repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.mockito.internal.exceptions.ExceptionIncludingMockitoWarnings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@SpringBootTest
public class AdateRepositaryTests {

    @Autowired
    AdateRepositary adateRepositary;


    @Test
    @Transactional
    public void testselect () throws Exception {
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        Date d = ft.parse("2023-09-10");
        Map<String, Object> a = adateRepositary.getAidByXdate(new java.sql.Date(d.getTime())).orElseThrow(() -> new Exception("not found"));
        Long aid = Long.valueOf(a.get("aid").toString());
        System.out.println(aid);
    }
}
