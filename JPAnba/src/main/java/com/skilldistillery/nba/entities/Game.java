package com.skilldistillery.nba.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "away_score")
	private int awayScore;
	
	@Column(name = "home_score")
	private int homeScore;
	
	@ManyToOne
	@JoinColumn(name = "home_team")
	private Team homeTeam;

	@ManyToOne
	@JoinColumn(name = "away_team")
	private Team awayTeam;
	
	@ManyToOne
	@JoinColumn(name = "season_id")
	private Season season;

	public Game() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAwayScore() {
		return awayScore;
	}

	public void setAwayScore(int awayScore) {
		this.awayScore = awayScore;
	}

	public int getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}
	

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}
	
	public Team getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}
	
	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	@Override
	public int hashCode() {
		return Objects.hash(awayScore, awayTeam, homeScore, homeTeam, id, season);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return awayScore == other.awayScore && Objects.equals(awayTeam, other.awayTeam) && homeScore == other.homeScore
				&& Objects.equals(homeTeam, other.homeTeam) && id == other.id && Objects.equals(season, other.season);
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", awayScore=" + awayScore + ", homeScore=" + homeScore + ", homeTeam=" + homeTeam
				+ ", awayTeam=" + awayTeam + ", season=" + season + "]";
	}
	
	

}
