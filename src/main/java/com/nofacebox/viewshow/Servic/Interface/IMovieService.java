package com.nofacebox.viewshow.Servic.Interface;

import com.nofacebox.viewshow.Entity.Movie;
import com.nofacebox.viewshow.Model.ResponseVo;

import java.util.List;
import java.util.Set;

public interface IMovieService {
    public Movie getMovie(long id);

    public Movie saveMovie(Movie saveItem);

    public Movie modifyMovie(Movie modify);

    public ResponseVo deleteMovie(long id);

    public List<Movie> getMovie(Set<Movie> movieSet);
}
