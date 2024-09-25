package com.platzi.javatests.movies.model;

import java.util.Objects;

public class Movie {
    private  Integer id;
    private String name;
    private Integer minutes;
    private Genre genre;


    public Movie(String name, int minutes, Genre genre){
        this(null, name, minutes, genre);
    }

    public Movie(Integer id, String name, int minutes, Genre genre){
        this.id = id;
        this.name = name;
        this.minutes = minutes;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(name, movie.name) && Objects.equals(minutes, movie.minutes) && genre == movie.genre;
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(minutes);
        result = 31 * result + Objects.hashCode(genre);
        return result;
    }
}
