package com.nofacebox.viewshow.Servic;

import com.nofacebox.viewshow.Entity.Movie;
import com.nofacebox.viewshow.Model.ResponseVo;
import com.nofacebox.viewshow.Repository.MovieRepositary;
import com.nofacebox.viewshow.Servic.Interface.IMovieService;
import com.nofacebox.viewshow.Utils.NativeQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class MovieService implements IMovieService {
    @Autowired
    MovieRepositary movieRepositary;

    @Override
    public Movie getMovie(Long id) {
        return movieRepositary.findById(id).orElse(null);
    }

    @Override
    public Movie saveMovie(Movie saveItem) {
        return movieRepositary.save(saveItem);
    }

    @Override
    public Movie modifyMovie(Movie modify) throws Exception {
        Movie m = movieRepositary.findById(modify.getMid()).orElseThrow(()->new Exception("not found"));
        m.setMname(modify.getMname());
        m.setPubdate(modify.getPubdate());
        m.setOffdate(modify.getOffdate());
        return movieRepositary.save(m);
    }

    @Override
    public ResponseVo deleteMovie(Long id) {
        ResponseVo res = new ResponseVo();
        if(movieRepositary.findById(id).isPresent()){
            movieRepositary.deleteById(id);
            res.setMessage("OK");
        }else{
            res.setMessage("FAILED");
        }
        return res;
    }

    @Override
    public List<Movie> getMovies() throws Exception {
        List<Map<String, Object>> li = movieRepositary.getAllMovies().orElseThrow(() -> new Exception("not found"));
        List<Movie> ret = NativeQueryConverter.convert(li, Movie.class);
        return ret;
    }
}
