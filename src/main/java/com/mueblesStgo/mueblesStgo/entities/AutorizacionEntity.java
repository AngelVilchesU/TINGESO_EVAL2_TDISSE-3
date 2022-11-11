package com.mueblesStgo.mueblesStgo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity // Indica que corresponde a una entidad de persistencia
@Table(name = "Autorizacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutorizacionEntity {
    @Id // Permite que la BD visualice el ID como tal
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generado automáticamente e incrementable
    @Column(unique = true, nullable = false) // Es único y no puede ser nulo
    private Long id;
    private LocalDate fechaHoraExtra; // Ejemplo de tipo de dato LocalDate: 2022-09-11
    private String rutEmpleado;
    private float horasExtra;

    public AutorizacionEntity(LocalDate fechaHoraExtra, String rutEmpleado, float horasExtra) {
        this.fechaHoraExtra = fechaHoraExtra;
        this.rutEmpleado = rutEmpleado;
        this.horasExtra = horasExtra;
    }
}
