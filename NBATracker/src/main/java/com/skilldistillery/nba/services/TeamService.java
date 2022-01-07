package com.skilldistillery.nba.services;

import java.util.List;

import com.skilldistillery.nba.entities.Team;

public interface TeamService {
	List<Team> getAllTeams();
	Team getTeamById(int teamId);

}
