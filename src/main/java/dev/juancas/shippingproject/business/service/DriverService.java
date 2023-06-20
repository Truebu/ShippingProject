package dev.juancas.shippingproject.business.service;

import dev.juancas.shippingproject.model.dto.*;
import dev.juancas.shippingproject.model.entities.Driver;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface DriverService {
    ResponseEntity<List<DriverDto>> getDrivers();

    ResponseEntity<MessageDto>  newDriver(SaveDriverDto dto);

    ResponseEntity<MessageDto>  toAssociateDriver(AssociateDriverDto dto);

    ResponseEntity<MessageDto>  toDisAssociateDriver(DisAssociateDriverDto dto);

    Optional<Driver> findDriver();
}
