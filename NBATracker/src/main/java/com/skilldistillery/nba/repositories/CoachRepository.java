package com.skilldistillery.nba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.nba.entities.Coach;

public interface CoachRepository extends JpaRepository<Coach, Integer> {

}
