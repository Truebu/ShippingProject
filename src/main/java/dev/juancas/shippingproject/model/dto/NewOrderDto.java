package dev.juancas.shippingproject.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NewOrderDto {

    @NotBlank(message = "La dirección es obligatoria")
    @Size(min = 2, max = 50, message = "La direccion debe de ser de 2 a 50 caracteres")
    private String direccion;

    @Size(min = 2, max = 20, message = "El tipo de pedido debe de ser de 2 a 20 caracteres")
    private String tipoPedido;
}
