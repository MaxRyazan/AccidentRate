package ru.maxryazan.accidentrate.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.maxryazan.accidentrate.model.Driver;
import ru.maxryazan.accidentrate.repository.DriverRepository;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public ResponseEntity<Driver> showThisDriver(long id) {
        Driver myUser = driverRepository.findById(id).orElse(null);
        return new ResponseEntity<>(myUser, HttpStatus.OK);
    }
}