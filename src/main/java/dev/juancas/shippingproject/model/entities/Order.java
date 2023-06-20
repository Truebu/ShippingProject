package dev.juancas.shippingproject.model.entities;

import dev.juancas.shippingproject.model.dto.NewOrderDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "orders")
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "direccion",nullable = false,columnDefinition = "VARCHAR(50)", unique = false)
    private String direccion;

    @Column(name = "tipo_pedido",nullable = true,columnDefinition = "VARCHAR(20)", unique = false)
    private String tipoPedido;

    @ManyToOne
    @JoinColumn(name = "conductor_id", nullable=false)
    private Driver driver;

    public Order(NewOrderDto dto) {
        this.direccion = dto.getDireccion();
        this.tipoPedido = dto.getTipoPedido();
    }
}
