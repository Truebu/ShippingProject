package dev.juancas.shippingproject.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssociateDriverDto {

    @NotBlank(message = "La identificación es obligatoria")
    @Size(min = 4, max = 11, message = "La identificacion debe de ser de 4 a 11 caracteres")
    private String identificacion;
    private List<String> placas;

}
