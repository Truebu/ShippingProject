package dev.juancas.shippingproject.model.dto;

import dev.juancas.shippingproject.model.entities.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VehicleDto {

    private Long id;
    private String modelo;
    private String placa;
    private String capacidad;

    public VehicleDto(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.modelo = vehicle.getModelo();
        this.placa = vehicle.getPlaca();
        this.capacidad = vehicle.getCapacidad();
    }
}
