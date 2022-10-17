package ru.maxryazan.accidentrate.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.maxryazan.accidentrate.exceptions.DriverNotFoundException;
import ru.maxryazan.accidentrate.exceptions.Response;
import ru.maxryazan.accidentrate.model.Driver;
import ru.maxryazan.accidentrate.repository.DriverRepository;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public ResponseEntity<?> showThisDriver(long id) {
        Driver driver = driverRepository.findById(id).orElse(null);
        if(driver == null){
            throw new DriverNotFoundException();
        }
        Response response = new Response(driver, "200");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}