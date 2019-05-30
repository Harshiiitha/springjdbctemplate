package com.stackroute.springJdbc.controller;

import com.stackroute.springJdbc.domain.Movie;
import com.stackroute.springJdbc.repository.SpringJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class SpringJdbcController {
    @Autowired
    private SpringJdbcRepository springJdbcRepository;

    public ResponseEntity<String> executeShow(int id) {
        Movie movie = springJdbcRepository.get(id);
        return new ResponseEntity("Movie: " + movie.getMovieId()+","+movie.getMovieName()+","+movie.getMovieReleaseYear()+","+movie.getMovieRating(), HttpStatus.OK);
    }

    public ResponseEntity<String> insert() {
        Movie movie = new Movie(104,"Mahanati",2018,4.5f);
        springJdbcRepository.add(movie);
        return new ResponseEntity("Movie Add: " + movie.getMovieId()
                + ", " + movie.getMovieName()+" ,"+movie.getMovieReleaseYear()+","+movie.getMovieRating(), HttpStatus.OK);
    }

    public ResponseEntity<String> read() {
        Movie movie = springJdbcRepository.get(103);
        return new ResponseEntity("Movie Get: " + movie.getMovieId()
                + ", " + movie.getMovieName()+","+movie.getMovieReleaseYear()+","+movie.getMovieRating(), HttpStatus.OK);
    }

    public ResponseEntity<String> update() {
        Movie movie= new Movie(103,"PK",2017,3.8f);
        springJdbcRepository.update(movie);
        return new ResponseEntity("Movie Update: " + movie.getMovieId()
                + ", " +movie.getMovieName()+","+movie.getMovieReleaseYear()+","+movie.getMovieRating(), HttpStatus.OK);
    }

    public ResponseEntity<String> delete() {
        Movie movie= new Movie(101,"Maharshi",2019,4);
        springJdbcRepository.delete(movie);
        return new ResponseEntity("Movie Delete: " +movie.getMovieId()
                + ", " + movie.getMovieName()+","+movie.getMovieReleaseYear()+","+movie.getMovieRating(), HttpStatus.OK);
    }
    public ResponseEntity<?> getAll() {
        List<Movie> movieList =springJdbcRepository.getAll();
        return new ResponseEntity<List<Movie>>(movieList,HttpStatus.OK);
    }
}