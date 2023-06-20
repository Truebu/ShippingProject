package dev.juancas.shippingproject.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaveDriverDto {

    @NotBlank(message = "La identificación es obligatoria")
    @Size(min = 4, max = 11, message = "La identificacion debe de ser de 4 a 11 caracteres")
    private String identificacion;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 20, message = "El nombre debe de ser de 2 a 20 caracteres")
    private String nombre;

    @Size(min = 2, max = 20, message = "El apellido debe de ser de 2 a 20 caracteres")
    private String apellido;

    @NotBlank(message = "El telefono es obligatorio")
    @Size(min = 5, max = 10, message = "El telefono debe de ser de 5 a 10 caracteres")
    private String telefono;

    @Size(min = 2, max = 50, message = "La direccion debe de ser de 2 a 50 caracteres")
    private String direccion;

    public SaveDriverDto(String identificacion, String nombre, String telefono) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.telefono = telefono;
    }
}
