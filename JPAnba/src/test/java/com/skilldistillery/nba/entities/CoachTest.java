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

class CoachTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Coach coach;

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
		coach = em.find(Coach.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		coach = null;
	}

	@Test
	void test_Coach_Entity_Mapping() {
		assertNotNull(coach);
		assertEquals("Mike", coach.getFirstName());
	}
	
	@Test
	void test_Coach_Team_Mapping() {
		assertNotNull(coach);
		assertEquals("Nuggets", coach.getTeam().getName());
	}

}
