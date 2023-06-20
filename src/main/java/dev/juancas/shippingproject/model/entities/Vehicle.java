package dev.juancas.shippingproject.model.entities;

import dev.juancas.shippingproject.model.dto.SaveVehicleDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "vehicle")
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "modelo",nullable = false,columnDefinition = "VARCHAR(4)", unique = false)
    private String modelo;

    @Column(name = "placa",nullable = false,columnDefinition = "VARCHAR(7)", unique = true)
    private String placa;

    @Column(name = "capacidad",nullable = true,columnDefinition = "VARCHAR(7)", unique = false)
    private String capacidad;

    @ManyToOne
    @JoinColumn(name = "conductor_id", nullable=true)
    private Driver driver;

    public Vehicle(SaveVehicleDto dto) {
        this.modelo = dto.getModelo();
        this.placa = dto.getPlaca();
        this.capacidad = dto.getCapacidad();
    }
}
