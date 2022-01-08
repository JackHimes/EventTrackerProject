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
	void test_team() {
		assertNotNull(team);
		assertEquals("Nuggets", team.getName());
	}
	@Test
	void test_logoUrl() {
		assertNotNull(team);
		assertEquals("https://www.nba.com/nuggets/sites/nuggets/files/dnuggets-primary-web-150x150.png?", team.getLogoUrl());
	}

}
