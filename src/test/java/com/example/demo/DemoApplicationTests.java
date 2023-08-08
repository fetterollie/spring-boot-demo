package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.web.ServerProperties.Reactive.Session;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}

// @Test
// void save_my_first_object_to_the_db(){
// 	try (Session session = sessionFactory.openSession()) {
// 		session.beginTransaction();

// 		// save the stuff

// 		session.getTransaction().commit();
// 	}
// }