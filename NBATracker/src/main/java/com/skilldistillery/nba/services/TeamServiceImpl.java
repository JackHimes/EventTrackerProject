package com.skilldistillery.nba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.nba.entities.Team;
import com.skilldistillery.nba.repositories.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService {
	
	@Autowired
	private TeamRepository repo;

	@Override
	public List<Team> getAllTeams() {
		return repo.findAll();
	}

	@Override
	public Team getTeamById(int teamId) {
		// TODO Auto-generated method stub
		return null;
	}

}
