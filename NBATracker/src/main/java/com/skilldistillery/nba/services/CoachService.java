package com.skilldistillery.nba.services;

import java.util.List;

import com.skilldistillery.nba.entities.Coach;

public interface CoachService {
	List<Coach> getAllCoaches();
	Coach getCoachById(int coachId);
	Coach createCoach(Coach coach);
	Coach updateCoachById(int coachId, Coach coach);
	boolean deleteCoachById(int coachId);

}
