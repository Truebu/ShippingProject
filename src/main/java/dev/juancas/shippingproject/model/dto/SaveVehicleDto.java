package dev.juancas.shippingproject.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaveVehicleDto {

    @NotBlank(message = "El modelo es obligatorio")
    @Size(min = 4, max = 4, message = "El modelo debe de ser de 4 caracteres")
    private String modelo;

    @NotBlank(message = "La placa es obligatoria")
    @Size(min = 6, max = 7, message = "La placa debe de ser de 6 a 7 caracteres")
    private String placa;

    @Size(min = 1, max = 7, message = "La capacidad debe de ser de 1 a 7 caracteres")
    private String capacidad;

    public SaveVehicleDto(String modelo, String placa) {
        this.modelo = modelo;
        this.placa = placa;
    }
}
