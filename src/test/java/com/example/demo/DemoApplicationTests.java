package com.example.demo;

// import java.util.List;

// import org.hibernate.Session;
// import org.hibernate.SessionFactory;
// import org.hibernate.boot.MetadataSources;
// import org.hibernate.boot.registry.StandardServiceRegistry;
// import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Disabled;
// import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DemoApplicationTests {

	// private SessionFactory sessionFactory;

	// @Disabled
	// @Test
	// void contextLoads() {
	// }


	// @BeforeEach
	// protected void setUp() throws Exception {
	// 	// A SessionFactory is set up once for an application!
	// 	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
	// 				.configure() // configures settings from hibernate.cfg.xml
	// 				.build();
	// 	try {
	// 		sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	// 	}
	// 	catch (Exception e) {
	// 		// The registry would be destroyed by the SessionFactory,
	// 		// but we had trouble building the SessionFactory so destroy it manually.
	// 		StandardServiceRegistryBuilder.destroy( registry );
	// 	}
	// }

	// @AfterEach
	// protected void tearDown() throws Exception {
	// 	if ( sessionFactory != null ) {
	// 		sessionFactory.close();
	// 	}
	// }

	// @Test
	// void save_my_first_object_to_the_db() {

	// 	Car car = new Car("999", "honda", "accord");


	// 	try(Session session = sessionFactory.openSession()) {
	// 		session.beginTransaction();

	// 		// save
	// 		session.persist(car);

	// 		session.getTransaction().commit();
	// 	}
	// }

	// @Disabled
	// @SuppressWarnings("unchecked")
//     @Test

//     public void testBasicUsage() {
// 	   // create a couple of events...
// 	   Session session = sessionFactory.openSession();
// 	   session.beginTransaction();
// 	   session.remove(new Car("999", "honda", "accord"));
// 	   session.getTransaction().commit();
// 	   session.close();

// 	   session = sessionFactory.openSession();
// 	   session.beginTransaction();
// 	   List<Car> result = session.createQuery( "select c from Car c" , Car.class).list();
// 	   for ( Car car : result) {
// 		  System.out.println( "Car (" + car.getCar_id() + ") : " + car.getMake() );
// 	   }
// 	   session.getTransaction().commit();
// 	   session.close();
//     }

// 	@Test
//     public void marco_is_in_the_house() {
// 	   assertThat(1).isGreaterThanOrEqualTo(0);
//     }
}

