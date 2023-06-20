package dev.juancas.shippingproject.business.service;

import dev.juancas.shippingproject.business.exception.ApiRequestException;
import dev.juancas.shippingproject.model.dto.*;
import dev.juancas.shippingproject.model.entities.Driver;
import org.springframework.http.HttpStatus;
import dev.juancas.shippingproject.model.entities.Vehicle;
import dev.juancas.shippingproject.model.repositories.DriverRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class DriverServiceImpl implements DriverService{

    private final DriverRepository driverRepository;
    private final VehicleService vehicleService;

    @Override
    public ResponseEntity<List<DriverDto>> getDrivers() {
        List<DriverDto> driverDtos = new ArrayList<>();
        try {
            List<Driver> drivers = driverRepository.findAll();
            for (Driver driver:
                    drivers) {
                driverDtos.add(new DriverDto(driver));
            }
            return new ResponseEntity<>(driverDtos, HttpStatus.OK);
        }catch (ApiRequestException e){
            throw new ApiRequestException("Hubo un error al recuperar los conductores");
        }
    }

    @Override
    public ResponseEntity<MessageDto> newDriver(SaveDriverDto dto) {
        Driver nDriver = new Driver(dto);
        try{
            if (driverRepository.findByIdentificacion(dto.getIdentificacion()).isPresent())
                return new ResponseEntity<>(new MessageDto("El conductor ya existe"), HttpStatus.BAD_REQUEST);
            if (driverRepository.findByTelefono(dto.getTelefono()).isPresent())
                return new ResponseEntity<>(new MessageDto("El telefono ya fue tomado"), HttpStatus.BAD_REQUEST);
            driverRepository.save(nDriver);
            return new ResponseEntity<>(new MessageDto("Se guardo el conductor con exito!"), HttpStatus.CREATED);
        }catch (ApiRequestException e){
            throw new ApiRequestException("Hubo un error al guardar  el conductor");
        }
    }

    @Override
    public ResponseEntity<MessageDto> toAssociateDriver(AssociateDriverDto dto) {
        Set<Vehicle> vehicles = new HashSet<>();
        try {
            Optional<Driver> currentDriver = driverRepository.findByIdentificacion(dto.getIdentificacion());
            if (currentDriver.isEmpty()){
                return new ResponseEntity<>(new MessageDto("No se encontró al conductor"), HttpStatus.NOT_FOUND);
            }
            for (Vehicle vehicle:
                 currentDriver.get().getVehicles()) {
                for (String placa:
                        dto.getPlacas()) {
                    if (vehicle.getPlaca().equals(placa))
                        return new ResponseEntity<>(new MessageDto(
                                "El conductor ya tiene el vehiculo "+ placa +" asociado"
                        ), HttpStatus.BAD_REQUEST);
                }
                vehicles.add(vehicle);
            }
            for (String placa:
                    dto.getPlacas()) {
                Optional<Vehicle> vehicle = vehicleService.findByPlaca(placa);
                if (vehicle.isEmpty())
                    return new ResponseEntity<>(new MessageDto("No se encontró el vehiculo " + placa), HttpStatus.NOT_FOUND);
                if(vehicle.get().getDriver() != null)
                    return new ResponseEntity<>(new MessageDto("El vehiculo " + placa + " ya está asociado a otro conductor"), HttpStatus.NOT_FOUND);
                vehicle.get().setDriver(currentDriver.get());
                vehicles.add(vehicle.get());
            }
            currentDriver.get().setVehicles(vehicles);
            driverRepository.save(currentDriver.get());
            for (Vehicle vehicle:
                    vehicles) {
                vehicleService.updateVehicle(vehicle);
            }
            return new ResponseEntity<>(new MessageDto("Se asociaron los vehiculos de manera exitosa!"), HttpStatus.OK);
        }catch (ApiRequestException e){
            throw new ApiRequestException("Hubo un error al asociar  el conductor");
        }
    }

    @Override
    public ResponseEntity<MessageDto> toDisAssociateDriver(DisAssociateDriverDto dto) {
        try {
            Optional<Driver> currentDriver = driverRepository.findByIdentificacion(dto.getIdentificacion());
            if (currentDriver.isEmpty())
                return new ResponseEntity<>(new MessageDto("No se encontró al conductor"), HttpStatus.NOT_FOUND);
            Optional<Vehicle> vehicle = vehicleService.findByPlaca(dto.getPlaca());
            if (vehicle.isEmpty())
                return new ResponseEntity<>(new MessageDto(
                        "No se encontró el vehiculo" + dto.getPlaca()
                ), HttpStatus.NOT_FOUND);
            Set<Vehicle> vehicles = currentDriver.get().getVehicles();
            if (!vehicles.contains(vehicle.get()))
                return new ResponseEntity<>(new MessageDto("" +
                        "El conductor no tiene asociado el vehiculo de placa " + dto.getPlaca()
                ), HttpStatus.BAD_REQUEST);
            vehicles.remove(vehicle.get());
            currentDriver.get().setVehicles(vehicles);
            driverRepository.save(currentDriver.get());
            vehicle.get().setDriver(null);
            vehicleService.updateVehicle(vehicle.get());
            return new ResponseEntity<>(new MessageDto("Se desasocio el vehiculo de manera exitosa!"), HttpStatus.OK);
        }catch (ApiRequestException e){
            throw new ApiRequestException("Hubo un error al asociar  el conductor");
        }
    }

    @Override
    public Optional<Driver> findDriver() {
        return driverRepository.findRand();
    }
}
