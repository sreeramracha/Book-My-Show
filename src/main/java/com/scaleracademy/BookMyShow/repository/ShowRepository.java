package com.scaleracademy.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaleracademy.BookMyShow.model.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {

}
