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

    @NotBlank(message = "El Nombre es requerido")
    private String nombre;

    @NotBlank(message = "El Genero es requerido")
    private String genero;

    @Min(value = 18, message = "La edad debe ser al menos 18 años")
    private int edad;

    @NotBlank(message = "La Identificacion es requerido")
    @Size(min = 10, max = 13, message = "La identificación debe tener entre 10 y 13 caracteres.")
    @Column(unique = true)
    private String identificacion;

    @NotBlank(message = "La Direccion es requerido")
    private String direccion;

    @NotBlank(message = "El Telefono es requerido")
    private String telefono;

}