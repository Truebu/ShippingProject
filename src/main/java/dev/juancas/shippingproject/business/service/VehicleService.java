package dev.juancas.shippingproject.business.service;

import dev.juancas.shippingproject.model.dto.SaveVehicleDto;
import dev.juancas.shippingproject.model.dto.MessageDto;
import dev.juancas.shippingproject.model.dto.VehicleDto;
import dev.juancas.shippingproject.model.entities.Vehicle;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    ResponseEntity<List<VehicleDto>> getVehicles();

    ResponseEntity<MessageDto> newVehicle(SaveVehicleDto dto);

    Optional<Vehicle> findByPlaca(String placa);

    Vehicle updateVehicle(Vehicle vehicle);
}
