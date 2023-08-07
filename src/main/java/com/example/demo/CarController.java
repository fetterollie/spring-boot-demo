package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

// annotation
@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarsService carsService;
    
    Car car;

    @GetMapping("/")
    public String helloCar() {
        return "Hello Car!";
    }

    @GetMapping("{car_id}")
    public Car get(@PathVariable String car_id) {
        if (car == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return carsService.get(car_id);
        }
    }

    @GetMapping("/cars") 
    public Iterable<Car> get() {
        return carsService.get();
    }

    @DeleteMapping("/{car_id}")
    public void deleteCar(@PathVariable String car_id) {
        if (car == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        this.car = carsService.remove(car_id);
    }

    @PostMapping
    public ResponseEntity<String> createCarDetails(@RequestBody @Validated Car car) {
        
        this.car = car;

        if (car.getCar_id() == null) throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);

        carsService.put(car.getCar_id(), car);
       
        return new ResponseEntity<String> (
            String.format(
                "Car creation successful!\ncar_id: %s\nmake: %s\nmodel: %s", 
                car.getCar_id(), 
                car.getMake(),
                car.getModel()
            ),
            HttpStatus.CREATED
        );

    }
}
