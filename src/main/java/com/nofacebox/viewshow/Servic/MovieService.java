package com.nofacebox.viewshow.Servic;

import com.nofacebox.viewshow.Entity.Movie;
import com.nofacebox.viewshow.Model.ResponseVo;
import com.nofacebox.viewshow.Repository.MovieRepositary;
import com.nofacebox.viewshow.Servic.Interface.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MovieService implements IMovieService {
    @Autowired
    MovieRepositary movieRepositary;

    @Override
    public Movie getMovie(long id) {
        return movieRepositary.findById(id).orElse(null);
    }

    @Override
    public Movie saveMovie(Movie saveItem) {
        return movieRepositary.save(saveItem);
    }

    @Override
    public Movie modifyMovie(Movie modify) {
        return movieRepositary.save(modify);
    }

    @Override
    public ResponseVo deleteMovie(long id) {
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
    public List<Movie> getMovie(Set<Movie> movieSet) {
        return null;
    }
}
