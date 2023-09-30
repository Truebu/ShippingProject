package dev.juancas.shippingproject.model.dto;

import dev.juancas.shippingproject.model.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrdersDto {

    private String direccion;
    private String tipoPedido;
    private String conductor;

    public OrdersDto(Order order) {
        this.direccion = order.getDireccion();
        this.tipoPedido = order.getTipoPedido();
        this.conductor = order.getDriver() == null? null : order.getDriver().getIdentificacion();
    }
}
