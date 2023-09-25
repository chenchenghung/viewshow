package com.nofacebox.viewshow.Controller;

import com.nofacebox.viewshow.Entity.Theater;
import com.nofacebox.viewshow.Servic.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theater")
public class TheaterController {
    @Autowired
    TheaterService theaterService;

    @GetMapping("/{tid}")
    public ResponseEntity getTheater(@PathVariable long tid){
         return ResponseEntity.ok(theaterService.getTheaterById(tid));
    }
    @GetMapping("/all")
    public ResponseEntity getAllTheaters(){
        return ResponseEntity.ok(theaterService.getAllTheaters());
    }
    @PostMapping
    public ResponseEntity save(@RequestBody Theater saveItem){
        Assert.notNull(saveItem,"This entity can not be null");
        Assert.isNull(theaterService.getTheaterById(saveItem.getTid()),"ready to insert");
        return ResponseEntity.ok(theaterService.saveTheater(saveItem));
    }

    
}
