package com.example.bankingapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data  // Lombok:  Generates getters, setters, equals, hashCode, toString
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nombre is required")
    private String nombre;

    @NotBlank(message = "Genero is required")
    private String genero;

    @Min(value = 18, message = "Edad must be at least 18")
    private int edad;

    @NotBlank(message = "Identificacion is required")
    @Size(min = 10, max = 13, message = "Identificacion must be between 10 and 13 characters")
    @Column(unique = true)
    private String identificacion;

    @NotBlank(message = "Direccion is required")
    private String direccion;

    @NotBlank(message = "Telefono is required")
    private String telefono;

}