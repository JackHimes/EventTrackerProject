package com.skilldistillery.nba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.nba.entities.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
