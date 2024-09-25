package com.platzi.javatests.movies.service;

import com.platzi.javatests.movies.data.MovieRepository;
import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByLength(int lenght) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getMinutes() <= lenght).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByName(String name) {
        return movieRepository.findByNameContainsIgnoreCase(name);
    }

    public Collection<Movie> findMoviesByDirector(String director) {
        return movieRepository.findByDirector(director);
    }
}
