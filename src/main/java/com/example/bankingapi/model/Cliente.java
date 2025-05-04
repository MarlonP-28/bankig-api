package com.example.bankingapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Persona {

    @NotBlank(message = "Se requiere contraseña")
    private String contrasena;

    private boolean estado;

    // Puedes agregar más métodos si necesitas, como validaciones adicionales.
}
