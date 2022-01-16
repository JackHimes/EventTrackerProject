package com.skilldistillery.nba.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.nba.entities.Team;
import com.skilldistillery.nba.services.TeamService;

@RestController
@RequestMapping("api")
public class TeamController {

	@Autowired
	private TeamService serv;

	@GetMapping("teams")
	public List<Team> index(HttpServletResponse res) {
		List<Team> teams = serv.getAllTeams();
		if(teams != null) {
			res.setStatus(200);
			return teams;
		}
		else {
			res.setStatus(404);
			teams = null;
		}
		return teams;
	}

	@GetMapping("teams/{id}")
	public Team findTeamById(@PathVariable int id) {
		return serv.getTeamById(id);
	}

	@PostMapping("teams")
	public Team createTeam(@RequestBody Team team, HttpServletResponse res, HttpServletRequest req) {
		try {
			serv.createTeam(team);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(team.getId());
			res.setHeader("Location", url.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("INVALID JSON FOR NEW Team");
			res.setStatus(400);
			team = null;
		}
		return team;
	}

	@PutMapping("teams/{id}")
	public Team updateTeam(@PathVariable int id, @RequestBody Team team, HttpServletRequest req,
			HttpServletResponse res) {
		try {
			team = serv.updateTeamById(id, team);
			if (team == null) {
				res.setStatus(404);
			}else {
				res.setStatus(200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			team = null;
		}

		return team;
	}

	@DeleteMapping("teams/{id}")
	public void deleteTeam(@PathVariable int id, HttpServletResponse res) {

		try {
			if (serv.deleteTeamById(id)) {
				res.setStatus(204);
			} else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
	}

}
