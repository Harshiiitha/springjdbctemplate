package com.stackroute.springJdbc.repository;

import com.stackroute.springJdbc.domain.Movie;
import com.stackroute.springJdbc.mapper.MovieRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class SpringJdbcRepository
{
    private JdbcTemplate jdbcTemplate ;
    public SpringJdbcRepository() {}

    @Autowired
    public void  setDataSource(final DataSource dataSource)
    {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Movie> getAll()
    {
        return jdbcTemplate.query("SELECT * FROM Movie", new MovieRowMapper());
    }


    public int add(Movie movie)
    {
        return jdbcTemplate.update("INSERT INTO Movie VALUES (?, ?,?,?)", movie.getMovieId(),movie.getMovieName(),movie.getMovieReleaseYear(),movie.getMovieRating());
    }

    public Movie get(final Integer id)
    {
        final String query = "SELECT * FROM Movie WHERE ID = ?";
        return jdbcTemplate.queryForObject(query, new Object[] { id }, new MovieRowMapper());
    }

    public int update(Movie movie) {
        return jdbcTemplate.update("UPDATE Movie SET Rating=?,Year=? WHERE ID=?", movie.getMovieRating(),movie.getMovieReleaseYear(),movie.getMovieId());
    }


    public int delete(Movie movie) {
        return jdbcTemplate.update("DELETE FROM Movie WHERE ID=?", movie.getMovieId());
    }

}