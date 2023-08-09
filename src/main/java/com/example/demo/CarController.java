package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1")
public class CarController {

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

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.validation.annotation.Validated;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.server.ResponseStatusException;

// // annotation small change to test git
// @RestController
// @RequestMapping("/car")
// public class CarController {

//     @Autowired
//     private CarsService carsService;
    
//     Car car;

//     @GetMapping("/")
//     public String helloCar() {
//         return "Hello Car!";
//     }

//     @GetMapping("{car_id}")
//     public Car get(@PathVariable String car_id) {
//         if (car == null) {
//             throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//         } else {
//             return carsService.get(car_id);
//         }
//     }

//     @GetMapping("/cars") 
//     public Iterable<Car> get() {
//         return carsService.get();
//     }

//     @DeleteMapping("/{car_id}")
//     public void deleteCar(@PathVariable String car_id) {
//         if (car == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//         this.car = carsService.remove(car_id);
//     }

//     @PostMapping
//     public ResponseEntity<String> createCarDetails(@RequestBody @Validated Car car) {
        
//         this.car = car;

//         if (car.getCar_id() == null) throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);

//         // jon to-do: fix car service to work with Integer car_id
//         carsService.put(car.getCar_id(), car);
       
//         return new ResponseEntity<String> (
//             String.format(
//                 "Car creation successful!\ncar_id: %s\nmake: %s\nmodel: %s", 
//                 car.getCar_id(), 
//                 car.getMake(),
//                 car.getModel()
//             ),
//             HttpStatus.CREATED
//         );

//     }
// }
