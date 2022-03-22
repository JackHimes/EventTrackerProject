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

class GameTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Game game;

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
		game = em.find(Game.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		game = null;
	}

	@Test
	void test_Game_Entity_Mapping() {
		assertNotNull(game);
		assertEquals(101, game.getAwayScore());
	}
	
	@Test
	void test_Game_HomeTeam_Relational_Mapping() {
		assertNotNull(game);
		assertNotNull(game.getHomeTeam());
		assertEquals("Thunder", game.getHomeTeam().getName());
	}
	
	@Test
	void test_Game_AwayTeam_Relational_Mapping() {
		assertNotNull(game);
		assertNotNull(game.getAwayTeam());
		assertEquals("Nuggets", game.getAwayTeam().getName());
	}

	@Test
	void test_Game_Season_Relational_Mapping() {
		assertNotNull(game);
		assertNotNull(game.getSeason());
		assertEquals(2021, game.getSeason().getYear());
	}

}
