package com.skilldistillery.nba.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	
	@Column(name = "logo_url")
	private String logoUrl;
	
	@Column(name= "twitter_url")
	private String twitterUrl;

	private String city;

	private String venue;
	
	private String conference;
	
	@OneToMany(mappedBy = "team")
	private List<Player> roster;
	
	@ManyToMany(mappedBy = "teams")
	private List<Season> seasons;
	
//	@OneToMany(mappedBy = "team")
//	private List<Coach> coaches;

	public Team() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getTwitterUrl() {
		return twitterUrl;
	}

	public void setTwitterUrl(String twitterUrl) {
		this.twitterUrl = twitterUrl;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}
	
	

	public String getConference() {
		return conference;
	}

	public void setConference(String conference) {
		this.conference = conference;
	}
	

	public List<Player> getRoster() {
		return roster;
	}

	public void setRoster(List<Player> roster) {
		this.roster = roster;
	}
	
	
	
	

//	public List<Coach> getCoaches() {
//		return coaches;
//	}
//
//	public void setCoaches(List<Coach> coaches) {
//		this.coaches = coaches;
//	}

	public List<Season> getSeasons() {
		return seasons;
	}

	public void setSeasons(List<Season> seasons) {
		this.seasons = seasons;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, conference, id, logoUrl, name, roster, seasons, twitterUrl, venue);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		return Objects.equals(city, other.city) && Objects.equals(conference, other.conference) && id == other.id
				&& Objects.equals(logoUrl, other.logoUrl) && Objects.equals(name, other.name)
				&& Objects.equals(roster, other.roster) && Objects.equals(seasons, other.seasons)
				&& Objects.equals(twitterUrl, other.twitterUrl) && Objects.equals(venue, other.venue);
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", logoUrl=" + logoUrl + ", twitterUrl=" + twitterUrl + ", city="
				+ city + ", venue=" + venue + ", conference=" + conference + ", roster=" + roster + ", seasons="
				+ seasons + "]";
	}

}
