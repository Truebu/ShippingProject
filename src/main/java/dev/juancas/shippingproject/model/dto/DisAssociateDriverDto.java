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
public class DisAssociateDriverDto {

    @NotBlank(message = "La identificación es obligatoria")
    @Size(min = 4, max = 11, message = "La identificacion debe de ser de 4 a 11 caracteres")
    private String identificacion;
    @NotBlank(message = "La placa es obligatoria")
    @Size(min = 6, max = 7, message = "La placa debe de ser de 6 a 7 caracteres")
    private String placa;
}
