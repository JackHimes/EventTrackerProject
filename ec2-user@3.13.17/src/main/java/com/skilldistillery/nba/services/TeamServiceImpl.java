package com.skilldistillery.nba.services;

import java.util.List;
import java.util.Optional;

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
		Team team = null;
		if (repo.findById(teamId).isPresent()) {
			team = repo.findById(teamId).get();
			return team;
		}
		return team;
	}

	@Override
	public Team createTeam(Team team) {

		return repo.saveAndFlush(team);
	}

	@Override
	public Team updateTeamById(int teamId, Team team) {
		Optional<Team> teamOpt = repo.findById(teamId);
		Team managed = null;
		if (teamOpt.isPresent()) {
			managed = teamOpt.get();
			managed.setName(team.getName());
			managed.setCity(team.getCity());
			managed.setConference(team.getConference());
			managed.setLogoUrl(team.getLogoUrl());
			managed.setTwitterUrl(team.getTwitterUrl());
			managed.setVenue(team.getVenue());
			repo.saveAndFlush(managed);

		}

		return managed;
	}

	@Override
	public boolean deleteTeamById(int teamId) {
		boolean deleted = false;
		if (repo.existsById(teamId)) {
			repo.deleteById(teamId);
			deleted = true;
		}
		return deleted;
	}

}
