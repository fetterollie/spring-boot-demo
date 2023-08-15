package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;


// rest controller annoataion
@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1")
public class CarController {

    // Autowired annotation to enable repository methods
    @Autowired
    private CarRepository carRepository;

    // get cars REST api
    @GetMapping("/cars")
    public List<Car> getAllCar() {
        return this.carRepository.findAll();
    }

    // get car by car_id REST api
    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable(value = "id") Long carId)
        throws ResourceNotFoundException {
            Car car = carRepository.findById(carId)
                .orElseThrow(() -> new ResourceNotFoundException("Car record not found for this id :: " + carId));
            return ResponseEntity.ok().body(car);
        }


    // save car REST api
    @PostMapping("/cars")
    public Car createCar(@Valid @RequestBody Car car) {
        return this.carRepository.save(car);
    }

    //update car REST api
    @PutMapping("/cars/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable(value = "id") Long carId, @Valid @RequestBody Car carDetails) throws ResourceNotFoundException{

        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new ResourceNotFoundException("Car record not found for this id :: " + carId));

        car.setMake(carDetails.getMake());
        car.setModel(carDetails.getModel());
        car.setYear(carDetails.getYear());
        car.setColor(carDetails.getColor());
        car.setImgurl(carDetails.getImgurl());
        car.setPowerwindows(carDetails.getPowerwindows());
        car.setPowerlocks(carDetails.getPowerlocks());
        car.setBackupcamera(carDetails.getBackupcamera());

        return ResponseEntity.ok(this.carRepository.save(car));
    }

    // delete car REST api
    @DeleteMapping("/cars/{id}")
    public Map<String, Boolean> deleteCar(@PathVariable(value = "id") Long carId) throws ResourceNotFoundException{

        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new ResourceNotFoundException("Car record not found for this id :: " + carId));

        this.carRepository.delete(car);

        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);

        return response;

    }
}
