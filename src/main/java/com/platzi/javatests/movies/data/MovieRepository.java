package com.platzi.javatests.movies.data;

import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;

import java.util.Collection;

public interface MovieRepository {

    Movie findById(long id);
    Collection<Movie> findAll();
    Void saveOrUpdate(Movie movie);
    Collection<Movie> findByNameContainsIgnoreCase(String name);
    Collection<Movie> findByDirector(String director);
    Collection<Movie> findByAttributes(String name, String director, Genre genre);
}
