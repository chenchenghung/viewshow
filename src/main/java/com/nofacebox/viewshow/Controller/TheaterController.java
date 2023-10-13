package com.nofacebox.viewshow.Controller;

import com.nofacebox.viewshow.Entity.Theater;
import com.nofacebox.viewshow.Model.ResponseVo;
import com.nofacebox.viewshow.Model.ResultDto;
import com.nofacebox.viewshow.Servic.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class TheaterController {
    @Autowired
    TheaterService theaterService;

    @GetMapping("/theater/{tid}")
    public ResponseEntity<Theater> getTheater(@PathVariable long tid){
         return ResponseEntity.ok(theaterService.getTheaterById(tid));
    }
    @GetMapping("/theaters")
    public ResponseEntity<List<Theater>> getAllTheaters(){
        return ResponseEntity.ok(theaterService.getAllTheaters());
    }

    @GetMapping("/link/GetLstDicTheater")
    public ResponseEntity<List<ResultDto>> getAllTheatersResult() throws Exception {
        return ResponseEntity.ok(theaterService.getAllTheatersToResult());
    }


    @PostMapping( value="/theater",produces = "application/json")
    public ResponseEntity<Theater> save(@RequestBody Theater saveItem){
        Assert.notNull(saveItem,"This entity can not be null");
        return ResponseEntity.ok(theaterService.saveTheater(saveItem));
    }
    @PutMapping( value="/theater",produces = "application/json")
    public ResponseEntity<Theater> modify(@RequestBody Theater modify) throws Exception {
        Assert.notNull(modify,"This entity can not be null");
        return ResponseEntity.ok(theaterService.modifyTheater(modify));
    }
    @DeleteMapping("/theater/{tid}")
    public ResponseEntity<ResponseVo> delete(@PathVariable long tid){
        return ResponseEntity.ok(theaterService.deleteTheater(tid));
    }


    
}
