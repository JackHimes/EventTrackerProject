package com.skilldistillery.nba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public List<Team> index(){
		return serv.getAllTeams();
	}

}
