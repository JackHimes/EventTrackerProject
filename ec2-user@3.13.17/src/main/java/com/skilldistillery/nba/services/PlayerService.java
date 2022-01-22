package com.skilldistillery.nba.services;

import java.util.List;

import com.skilldistillery.nba.entities.Player;

public interface PlayerService {
	List<Player> getAllPlayers();
	Player getPlayerById(int playerId);
	Player createPlayer(Player player);
	Player updatePlayerById(int playerId, Player player);
	boolean deletePlayerById(int playerId);


}
