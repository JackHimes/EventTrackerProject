package com.skilldistillery.nba.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Season {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int year;
	
	@ManyToMany
	@JoinTable(name = "season_has_team",
		joinColumns = @JoinColumn(name="season_id"),
			inverseJoinColumns = @JoinColumn(name="team_id"))
	private List<Team> teams;
	
	@OneToOne
	@JoinColumn(name="champion_id")
	private Team champion;
	
	

	public Season() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public Team getChampion() {
		return champion;
	}

	public void setChampion(Team champion) {
		this.champion = champion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(champion, id, teams, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Season other = (Season) obj;
		return Objects.equals(champion, other.champion) && id == other.id && Objects.equals(teams, other.teams)
				&& year == other.year;
	}

	@Override
	public String toString() {
		return "Season [id=" + id + ", year=" + year + ", teams=" + teams + ", champion=" + champion + "]";
	}
	
	
	
	

}
