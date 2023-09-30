package dev.juancas.shippingproject.model.dto;

import dev.juancas.shippingproject.model.entities.Driver;
import dev.juancas.shippingproject.model.entities.Vehicle;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class DriverDto {

    private Long id;
    private String identificacion;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private Set<String> vehiculos = new HashSet<>();

    public DriverDto(Driver driver) {
        this.id = driver.getId();
        this.identificacion = driver.getIdentificacion();
        this.nombre = driver.getNombre();
        this.apellido = driver.getApellido();
        this.telefono = driver.getTelefono();
        this.direccion = driver.getDireccion();
        for (Vehicle vehicle:
             driver.getVehicles()) {
            vehiculos.add(vehicle.getPlaca());
        }
    }
}
