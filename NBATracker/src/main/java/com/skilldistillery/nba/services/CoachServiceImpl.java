package com.skilldistillery.nba.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.nba.entities.Coach;
import com.skilldistillery.nba.entities.Team;
import com.skilldistillery.nba.repositories.CoachRepository;

@Service
public class CoachServiceImpl implements CoachService {
	
	@Autowired
	CoachRepository coachRepo;

	@Override
	public List<Coach> getAllCoaches() {
		return coachRepo.findAll();
	}

	@Override
	public Coach getCoachById(int coachId) {
		Coach coach = null;
		if(coachRepo.findById(coachId).isPresent()) {
			coach = coachRepo.findById(coachId).get();
		}
		return coach;
	}

	@Override
	public Coach createCoach(Coach coach) {
		coach.setTeam(null);
		return coachRepo.saveAndFlush(coach);
	}

	@Override
	public Coach updateCoachById(int coachId, Coach coach) {
		Optional<Coach> coachOpt = coachRepo.findById(coachId);
		Coach managed = null;
		if(coachOpt.isPresent()) {
			managed = coachOpt.get();
			managed.setFirstName(coach.getFirstName());
			managed.setLastName(coach.getLastName());
			managed.setPosition(coach.getPosition());
			managed.setSalary(coach.getSalary());
			managed.setTeam(coach.getTeam());
			coachRepo.saveAndFlush(managed);
		}
		return managed;
		
	}
	
	

	@Override
	public boolean deleteCoachById(int coachId) {
		boolean deleted = false;
		if(coachRepo.existsById(coachId)) {
			coachRepo.deleteById(coachId);
			deleted = true;
		}
		return deleted;
	}


}
