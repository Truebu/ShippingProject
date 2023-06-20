package dev.juancas.shippingproject.model.dto;

import dev.juancas.shippingproject.model.entities.Driver;
import lombok.*;

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

    public DriverDto(Driver driver) {
        this.id = driver.getId();
        this.identificacion = driver.getIdentificacion();
        this.nombre = driver.getNombre();
        this.apellido = driver.getApellido();
        this.telefono = driver.getTelefono();
        this.direccion = driver.getDireccion();
    }
}
