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

import com.skilldistillery.nba.entities.Coach;
import com.skilldistillery.nba.services.CoachService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class CoachController {
	
	@Autowired
	private CoachService coachServ;
	
	@GetMapping("coaches")
	public List<Coach> index(){
		return coachServ.getAllCoaches();
	}
	
	@GetMapping("coaches/{cId}")
	public Coach findCoachById(@PathVariable int cId) {
		return coachServ.getCoachById(cId);
	}
	
	@PostMapping("coaches")
	public Coach createCoach(@RequestBody Coach coach, HttpServletResponse res, HttpServletRequest req) {
		try {
			coachServ.createCoach(coach);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(coach.getId());
			res.setHeader("Location", url.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("INVALID JSON FOR NEW Coach");
			res.setStatus(400);
			coach = null;
		}
		return coach;
	}
	
	@PutMapping("coaches/{cId}")
	public Coach updateCoach(@PathVariable int cId, @RequestBody Coach coach, HttpServletRequest req, HttpServletResponse res) {
		try {
			coach = coachServ.updateCoachById(cId, coach);
			if(coach == null) {
				res.setStatus(404);
			}else {
				res.setStatus(200);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			coach = null;
		}
		return coach;
	}
	
	@DeleteMapping("coaches/{cId}")
	public void deleteCoach(@PathVariable int cId, HttpServletResponse res, HttpServletRequest req) {
		try {
			if(coachServ.deleteCoachById(cId)) {
				res.setStatus(204);
			}else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
	}

}
