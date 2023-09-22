package com.nofacebox.viewshow.Repository;

import com.nofacebox.viewshow.Entity.Adate;
import com.nofacebox.viewshow.Entity.Link;
import com.nofacebox.viewshow.Entity.LinkPk;
import com.nofacebox.viewshow.Servic.LinkService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.mockito.internal.exceptions.ExceptionIncludingMockitoWarnings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
public class LinkRepositaryTests {
    @Autowired
    LinkRepositary linkRepositary;

    @Autowired
    AdateRepositary adateRepositary;

    @Autowired
    LinkService linkService;
    @Test
    @Transactional
    public void test2() throws Exception {
//        List<Link> all = linkRepositary.findAll();
//        all.stream().forEach(k-> System.out.println(k.toString()));
        List<Map<String, Object>> all = linkRepositary.getAllDatesByTheaterMovie(1, 2);
        all.stream().forEach(k-> System.out.println(k.values()));

        List<Map<String, Object>> allMovies = linkRepositary.getAllMoviesByTheater(5);
        allMovies.stream().forEach(k-> System.out.println(k.values()));

        LinkPk lik= linkService.getLink(1);
        System.out.println(lik.toString());
//        linkService.save();

        Optional<Adate> a1 = adateRepositary.findById(3L);
        Adate a2 = a1.orElseThrow(() -> new Exception("No found"));
        List<Link> set1 = a2.getTheaterMovieAdateLink();
        set1.forEach(k-> System.out.println(k.toString()));
//        System.out.println(set1.size());
//        set1.forEach(k-> System.out.println(k));

    }
}
