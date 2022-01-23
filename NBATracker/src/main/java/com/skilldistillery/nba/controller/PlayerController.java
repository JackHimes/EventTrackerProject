package com.skilldistillery.nba.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.nba.entities.Player;
import com.skilldistillery.nba.services.PlayerService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class PlayerController {
	
	@Autowired
	private PlayerService serv;
	
	@GetMapping("players")
	public List<Player> index(){
		return serv.getAllPlayers();
	}
	
	@GetMapping("players/{id}")
	public Player findPlayerById(@PathVariable int id) {
		return serv.getPlayerById(id);
	}
	
	@PostMapping("players")
	public Player createPlayer(@RequestBody Player player, HttpServletResponse res, HttpServletRequest req) {
		try {
			serv.createPlayer(player);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(player.getId());
			res.setHeader("Location", url.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("INVALID JSON FOR NEW Player");
			res.setStatus(400);
			player = null;
		}
		return player;
	}
	
	@PutMapping("players/{id}")
	public Player updatePlayer(@PathVariable int id, @RequestBody Player player, HttpServletRequest req, HttpServletResponse res) {
		try {
			player = serv.updatePlayerById(id, player);
			if(player == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			player = null;
		}
		
		return player;
	}
	
	@DeleteMapping("players/{id}")
	public void deleteTeam(@PathVariable int id, HttpServletResponse res) {

		try {
			if (serv.deletePlayerById(id)) {
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
