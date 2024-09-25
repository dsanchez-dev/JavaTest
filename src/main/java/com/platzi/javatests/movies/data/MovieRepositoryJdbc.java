package com.platzi.javatests.movies.data;

import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Collection;
import java.util.Collections;

public class MovieRepositoryJdbc implements MovieRepository {

    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        Object[] args = {id};
        return jdbcTemplate.queryForObject("select * from movies where id = ?", args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("select * from movies", movieMapper);
    }

    @Override
    public Void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("insert into movies (name, minutes, genre, director) values (?, ?, ?, ?)",
                movie.getName(), movie.getMinutes(), movie.getGenre().toString(), movie.getDirector());
        return null;
    }

    @Override
    public Collection<Movie> findByNameContainsIgnoreCase(String name) {
        String args = "%" + name.toLowerCase() + "%";
        return jdbcTemplate.query("select * from movies where lower(name) like ?", new Object[]{args}, movieMapper);
    }

    @Override
    public Collection<Movie> findByDirector(String director) {
        String args = "%" + director.toLowerCase() + "%";
        return jdbcTemplate.query("select * from movies where lower(director) like ?", new Object[]{args}, movieMapper);
    }

    @Override
    public Collection<Movie> findByAttributes(String name, String director, Genre genre) {
        String sql = "select * from movies where 1=1";
        if (name != null && !name.isEmpty()) {
            sql += " and lower(name) like '%" + name.toLowerCase() + "%'";
        }
        if (director != null && !director.isEmpty()) {
            sql += " and lower(director) like '%" + director.toLowerCase() + "%'";
        }
        if (genre != null) {
            sql += " and genre = '" + genre.toString() + "'";
        }
        return jdbcTemplate.query(sql, movieMapper);
    }

    private static RowMapper<Movie> movieMapper = (rs, i) -> new Movie(
        rs.getInt("id"),
        rs.getString("name"),
        rs.getInt("minutes"),
        Genre.valueOf(rs.getString("genre")),
        rs.getString("director")
    );
}