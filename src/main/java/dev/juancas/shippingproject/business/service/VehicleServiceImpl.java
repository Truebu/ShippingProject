package dev.juancas.shippingproject.business.service;

import dev.juancas.shippingproject.business.exception.ApiRequestException;
import dev.juancas.shippingproject.model.dto.MessageDto;
import dev.juancas.shippingproject.model.dto.SaveVehicleDto;
import dev.juancas.shippingproject.model.dto.VehicleDto;
import dev.juancas.shippingproject.model.entities.Vehicle;
import dev.juancas.shippingproject.model.repositories.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService{

    private final VehicleRepository vehicleRepository;

    @Override
    public ResponseEntity<List<VehicleDto>> getVehicles() {
        List<VehicleDto> vehicleDtos = new ArrayList<>();
        try {
            List<Vehicle> vehicles = vehicleRepository.findAll();
            for (Vehicle vehicle:
                    vehicles) {
                vehicleDtos.add(new VehicleDto(vehicle));
            }
            return new ResponseEntity<>(vehicleDtos, HttpStatus.OK);
        }catch (ApiRequestException e){
            throw new ApiRequestException("Hubo un error al recuperar los vehiculos");
        }
    }

    @Override
    public ResponseEntity<MessageDto> newVehicle(SaveVehicleDto dto) {
        Vehicle nVehicle = new Vehicle(dto);
        try{
            if (vehicleRepository.findByPlaca(dto.getPlaca()).isPresent())
                return new ResponseEntity<>(new MessageDto("El vehiculo ya existe"), HttpStatus.BAD_REQUEST);
            vehicleRepository.save(nVehicle);
            return new ResponseEntity<>(new MessageDto("Se guardo el Vehiculo con exito!"), HttpStatus.CREATED);
        }catch (ApiRequestException e){
            throw new ApiRequestException("Hubo un error al guardar  el vehiculo");
        }
    }

    @Override
    public Optional<Vehicle> findByPlaca(String placa) {
        return vehicleRepository.findByPlaca(placa);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
}
