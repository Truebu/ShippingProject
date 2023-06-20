package dev.juancas.shippingproject.model.entities;

import dev.juancas.shippingproject.model.dto.SaveDriverDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "driver")
@Table(name = "driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "identificacion",nullable = false,columnDefinition = "VARCHAR(11)", unique = true)
    private String identificacion;

    @Column(name = "nombre",nullable = false,columnDefinition = "VARCHAR(20)", unique = false)
    private String nombre;

    @Column(name = "apellido",nullable = true,columnDefinition = "VARCHAR(20)", unique = false)
    private String apellido;

    @Column(name = "telefono",nullable = false,columnDefinition = "VARCHAR(10)", unique = true)
    private String telefono;

    @Column(name = "direccion",nullable = true,columnDefinition = "VARCHAR(50)", unique = false)
    private String direccion;

    @OneToMany(mappedBy = "driver")
    private Set<Vehicle> vehicles = new HashSet<>();

    @OneToMany(mappedBy = "driver")
    private Set<Order> orders = new HashSet<>();

    public Driver(SaveDriverDto dto) {
        this.identificacion = dto.getIdentificacion();
        this.nombre = dto.getNombre();
        this.apellido = dto.getApellido();
        this.telefono = dto.getTelefono();
        this.direccion = dto.getDireccion();
    }
}
