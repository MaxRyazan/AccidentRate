package ru.maxryazan.accidentrate.controller;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.maxryazan.accidentrate.service.DriverService;

@RestController
public class DriverController {

    private final DriverService driverService;


    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping(value = "api/v1/{firstName}/{patronymic}/{lastName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> showOneById(@PathVariable("firstName") String firstName,
                                         @PathVariable("lastName") String lastName,
                                         @PathVariable("patronymic") String patronymic){
        return driverService.showThisDriver(firstName,lastName, patronymic);
    }
}
