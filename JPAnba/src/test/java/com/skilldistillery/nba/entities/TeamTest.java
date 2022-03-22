package com.skilldistillery.nba.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TeamTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Team team;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAnba");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		team = em.find(Team.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		team = null;
	}

	@Test
	void test_Team_Entity_Mapping() {
		assertNotNull(team);
		assertEquals("Nuggets", team.getName());
	}

	@Test
	void test_logoUrl() {
		assertNotNull(team);
		assertEquals("https://www.nba.com/nuggets/sites/nuggets/files/dnuggets-primary-web-150x150.png?",
				team.getLogoUrl());
	}
	
	@Test
	void test_Team_Roster_Mapping() {
		assertNotNull(team);
		assertNotNull(team.getRoster());
		assertTrue(team.getRoster().size() > 0);
	}

	@Test
	void test_Team_AwayGame_Mapping() {
		assertNotNull(team);
		assertNotNull(team.getAwayGames());
		assertTrue(team.getAwayGames().size() > 0);
	}

	@Test
	void test_Team_HomeGame_Mapping() {
		assertNotNull(team);
		assertNotNull(team.getHomeGames());
		assertTrue(team.getHomeGames().size() == 0);
	}
	
//	@Test
//	void test_Team_Coaches_Mapping() {
//		assertNotNull(team);
//		assertNotNull(team.getCoaches());
//		assertTrue(team.getCoaches().size() > 0);
//	}

}
