package com.stackroute.springJdbc.mapper;

import com.stackroute.springJdbc.domain.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(final ResultSet resultSet, final int rowNum) throws SQLException
    {
        final Movie movie = new Movie();
        movie.setMovieId(resultSet.getInt("Id"));
        movie.setMovieName(resultSet.getString("Name"));
        movie.setMovieReleaseYear(resultSet.getInt("Year"));
        movie.setMovieRating(resultSet.getFloat("Rating"));
        return movie;
    }
}