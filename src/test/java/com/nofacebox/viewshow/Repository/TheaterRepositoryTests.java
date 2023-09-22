package com.nofacebox.viewshow.Repository;


import com.nofacebox.viewshow.Entity.Theater;
import com.nofacebox.viewshow.Servic.TheaterService;
import jakarta.transaction.Transactional;
import jdk.dynalink.linker.support.Guards;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
public class TheaterRepositoryTests {
    @Autowired
    private TheaterService theaterService;
    @Autowired
    private TheaterRepositary theaterRepositary;

    @Test
    @Transactional
    public void testselect () throws Exception {
//        Theater t1 = new Theater();
//        t1.setName("板橋大遠百威秀影城");
//        t1.setRegion("新北");
//        Theater theater1 = theaterService.saveTheater(t1);
//        System.out.println("theater"+t1);
//        assertThat(theaterService.getTheater((long)3)).isNotNull();

        Optional<List<Map<String,String>>> lis = theaterRepositary.getTheaterByRegion("台北");
        List<Map<String,String>> t1 = lis.orElseThrow(() -> new Exception("查無資料"));
        t1.stream().forEach(k-> System.out.println(k.get(k)+":"+k.values()));
        t1.stream().forEach(k-> k.keySet());

    }


}
