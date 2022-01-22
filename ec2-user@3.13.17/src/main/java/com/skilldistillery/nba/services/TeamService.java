package com.skilldistillery.nba.services;

import java.util.List;

import com.skilldistillery.nba.entities.Team;

public interface TeamService {
	List<Team> getAllTeams();
	Team getTeamById(int teamId);
	Team createTeam(Team team);
	Team updateTeamById(int teamId, Team team);
	boolean deleteTeamById(int teamId);

}
