package dev.juancas.shippingproject.business.controller;

import dev.juancas.shippingproject.business.service.DriverService;
import dev.juancas.shippingproject.model.dto.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/driver")
public class DriverController {

    private final DriverService driverService;

    @GetMapping("/get")
    public ResponseEntity<List<DriverDto>> getDrivers(){
        return driverService.getDrivers();
    }

    @PostMapping("/newDriver")
    public ResponseEntity<MessageDto> newDriver(@RequestBody SaveDriverDto dto){
        return driverService.newDriver(dto);
    }

    @PutMapping("/associate")
    public ResponseEntity<MessageDto> toAssociateDriver(@Valid @RequestBody AssociateDriverDto dto){
        return driverService.toAssociateDriver(dto);
    }

    @PutMapping("/disassociate")
    public ResponseEntity<MessageDto> toDisAssociateDriver(@Valid @RequestBody DisAssociateDriverDto dto){
        return driverService.toDisAssociateDriver(dto);
    }
}