package dev.juancas.shippingproject.business.controller;

import dev.juancas.shippingproject.business.service.VehicleService;
import dev.juancas.shippingproject.model.dto.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping("/get")
    public ResponseEntity<List<VehicleDto>> getVehicles(){
        return vehicleService.getVehicles();
    }

    @PostMapping("/newVehicle")
    public ResponseEntity<MessageDto> newVehicle(@Valid  @RequestBody SaveVehicleDto dto){
        return vehicleService.newVehicle(dto);
    }
}
