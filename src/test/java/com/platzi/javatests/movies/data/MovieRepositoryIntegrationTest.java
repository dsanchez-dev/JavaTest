package com.platzi.javatests.movies.data;

import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {

    private DataSource dataSource;

    private MovieRepository movieRepository;

    @Before
    public void setUp() throws Exception {
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepository = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    public void load_all_movies() throws SQLException {

        Collection<Movie> movies = movieRepository.findAll();

        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION, "Christopher Nolan"),
                new Movie(2, "Memento", 113, Genre.THRILLER, "Christopher Nolan"),
                new Movie(3, "Matrix", 136, Genre.ACTION, "Lana Wachowski"),
                new Movie(4, "Super 8", 112, Genre.THRILLER, "J.J. Abrams"),
                new Movie(5, "Inception", 148, Genre.ACTION, "Christopher Nolan")

        )));
    }

    @Test
    public void load_movie_by_id() {
        Movie movie = movieRepository.findById(2);
        assertThat(movie, is(new Movie(2, "Memento", 113, Genre.THRILLER, "Christopher Nolan")));
    }

    @Test
    public void insert_a_movie() {
        Movie movie = new Movie(5, "Inception", 148, Genre.ACTION, "Christopher Nolan");
        movieRepository.saveOrUpdate(movie);
        Movie movieFromDb = movieRepository.findById(5);
        assertThat(movieFromDb, is(new Movie(5, "Inception", 148, Genre.ACTION, "Christopher Nolan")));
    }

    @Test
    public void load_movies_by_name() {
        Collection<Movie> movies = movieRepository.findByNameContainsIgnoreCase("dark");
        assertThat(movies, is(Arrays.asList(new Movie(1, "Dark Knight", 152, Genre.ACTION, "Christopher Nolan"))));
    }

    @Test
    public void search_movie_by_name_case_insensitive() {
        Collection<Movie> movies = movieRepository.findByNameContainsIgnoreCase("super");
        assertThat(movies, is(Arrays.asList(new Movie(4, "Super 8", 112, Genre.THRILLER, "J.J. Abrams"))));
    }

    @Test
    public void search_movie_by_director() {
        Collection<Movie> movies = movieRepository.findByDirector("Christopher Nolan");
        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION, "Christopher Nolan"),
                new Movie(2, "Memento", 113, Genre.THRILLER, "Christopher Nolan"),
                new Movie(5, "Inception", 148, Genre.ACTION, "Christopher Nolan")
        )));
    }

    @Test
    public void search_movie_by_attributes() {
        Collection<Movie> movies = movieRepository.findByAttributes("Dark Knight", "Christopher Nolan", Genre.ACTION);
        assertThat(movies, is(Arrays.asList(new Movie(1, "Dark Knight", 152, Genre.ACTION, "Christopher Nolan"))));
    }

    @After
    public void tearDown() throws Exception {
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files");
    }
}