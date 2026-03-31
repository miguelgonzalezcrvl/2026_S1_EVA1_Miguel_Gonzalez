package cl.duoc.miguel_gonzalez.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Solicitudes {

    @NotNull(message = "El id no puede tener espacio nulo")
    private long id;

    @NotBlank(message = "El nombre del paciente debe ser obligatorio")
    private String paciente;

    @NotNull (message = "Se debe asignar una prioridad")
    private Integer prioridad;

    @NotBlank(message = "La estado no puede estar vacia")
    private String estado;
}
