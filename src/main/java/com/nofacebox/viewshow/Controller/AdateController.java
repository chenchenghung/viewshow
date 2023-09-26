package com.nofacebox.viewshow.Controller;

import com.nofacebox.viewshow.Servic.AdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/v1")
public class AdateController {
    @Autowired
    AdateService adateService;
    @GetMapping(value= "/adate")
    public ResponseEntity<Long> getAid(@RequestParam("xdate") @DateTimeFormat(pattern ="yyyy-MM-dd") Date adate) throws Exception {
        return ResponseEntity.ok(adateService.findAidbyDate(adate));

    }

}
