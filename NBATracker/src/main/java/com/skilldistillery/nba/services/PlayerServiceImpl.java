package com.skilldistillery.nba.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.nba.entities.Player;
import com.skilldistillery.nba.repositories.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	@Autowired
	private PlayerRepository repo;

	@Override
	public List<Player> getAllPlayers() {
		return repo.findAll();
	}

	@Override
	public Player getPlayerById(int playerId) {
		Player player = null;
		if(repo.findById(playerId).isPresent()) {
			player = repo.findById(playerId).get();
			return player;
		}
		return player;
	}

	@Override
	public Player createPlayer(Player player) {
		return repo.saveAndFlush(player);
	}

	@Override
	public Player updatePlayerById(int playerId, Player player) {
		Optional<Player> playerOpt = repo.findById(playerId);
		Player managed = null;
		if(playerOpt.isPresent()) {
			managed = playerOpt.get();
			managed.setAssists(player.getAssists());
			managed.setFirstName(player.getFirstName());
			managed.setHeight(player.getHeight());
			managed.setLastName(player.getLastName());
			managed.setNumber(playerId);
			managed.setPoints(player.getPoints());
			managed.setRebounds(player.getRebounds());
			managed.setSalary(player.getSalary());
			managed.setTeam(null);
		}
		return null;
	}

	@Override
	public boolean deletePlayerById(int playerId) {
		// TODO Auto-generated method stub
		return false;
	}

}
