package com.nofacebox.viewshow.Controller;

import com.nofacebox.viewshow.Entity.Movie;
import com.nofacebox.viewshow.Model.ResponseVo;
import com.nofacebox.viewshow.Servic.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies() throws Exception {
        return ResponseEntity.ok(movieService.getMovies());
    }

    @GetMapping("/movie/{mid}")
    public ResponseEntity<Movie> getMovie (@PathVariable Long mid){
        return ResponseEntity.ok(movieService.getMovie(mid));
    }
    @PostMapping(value= "/movie",produces = "application/json")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie saveItem){
        Assert.notNull(saveItem,"This entity can not be null");
        return ResponseEntity.ok(movieService.saveMovie(saveItem));
    }
    @PutMapping(value= "/movie",produces = "application/json")
    public ResponseEntity<Movie> upateMovie(@RequestBody Movie modify) throws Exception {
        Assert.notNull(modify,"This entity can not be null");
        return ResponseEntity.ok(movieService.modifyMovie(modify));
    }
    @DeleteMapping("/movie/{mid}")
    public ResponseEntity<ResponseVo> deleteMovie(@PathVariable Long mid){
        return ResponseEntity.ok(movieService.deleteMovie(mid));
    }




}
