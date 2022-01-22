package com.skilldistillery.nba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.nba.entities.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {

}
