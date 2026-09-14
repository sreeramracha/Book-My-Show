package com.scaleracademy.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaleracademy.BookMyShow.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
