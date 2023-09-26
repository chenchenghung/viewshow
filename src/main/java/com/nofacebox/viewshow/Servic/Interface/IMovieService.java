package com.nofacebox.viewshow.Servic.Interface;

import com.nofacebox.viewshow.Entity.Movie;
import com.nofacebox.viewshow.Model.ResponseVo;

import java.util.List;
import java.util.Set;

public interface IMovieService {
    public Movie getMovie(Long id);

    public Movie saveMovie(Movie saveItem);

    public Movie modifyMovie(Movie modify) throws Exception;

    public ResponseVo deleteMovie(Long id);

    public List<Movie> getMovies() throws Exception;
}
