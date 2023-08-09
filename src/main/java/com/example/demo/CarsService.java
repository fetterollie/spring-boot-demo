// package com.example.demo;

// import java.util.Collection;
// import java.util.HashMap;
// import java.util.Map;

// import org.springframework.stereotype.Service;

// @Service
// public class CarsService {

    
//     private Map<String, Car> db = new HashMap<>() {{
//         // a place to hold a list of cars
//     }};

//     public Collection<Car> get() {
//         return db.values();
//     }

//     public void put(String car_id, Car car) {
//         // jon to-do: fixx
//         db.put(car.getCar_id(), car); 
//     }

//     public Car get(String car_id) {
//         return db.get(car_id);
//     }

//     public Car remove(String car_id) {
//         return db.remove(car_id);
//     }

// }