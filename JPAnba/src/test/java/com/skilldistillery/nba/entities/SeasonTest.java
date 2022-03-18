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

class SeasonTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Season season;

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
		season = em.find(Season.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		season = null;
	}

	@Test
	void test_Season_Entity_Mapping() {
		assertNotNull(season);
		assertEquals(2021, season.getYear());
	}
	
	@Test
	void test_Season_Teams_Relationship() {
		assertNotNull(season);
		assertNotNull(season.getTeams());
		assertTrue(season.getTeams().size() > 0);
	}
	
	@Test
	void test_Season_Champion_Relationship() {
		assertNotNull(season);
		assertNotNull(season.getChampion());
		assertEquals("Suns", season.getChampion().getName());
	}

}
