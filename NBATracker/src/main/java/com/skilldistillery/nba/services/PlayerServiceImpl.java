package com.skilldistillery.nba.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.nba.entities.Player;
import com.skilldistillery.nba.entities.Team;
import com.skilldistillery.nba.repositories.PlayerRepository;
import com.skilldistillery.nba.repositories.TeamRepository;

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
			managed.setTeam(player.getTeam());
			managed.setPosition(player.getPosition());
			repo.saveAndFlush(managed);
		}
		return managed;
	}

	@Override
	public boolean deletePlayerById(int playerId) {
		boolean deleted = false;
		if(repo.existsById(playerId)) {
			repo.deleteById(playerId);
			deleted = true;
		}
		return deleted;
	}

}
