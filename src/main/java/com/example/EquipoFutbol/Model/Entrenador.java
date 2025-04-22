package com.example.EquipoFutbol.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_entrenador;
    private String nombre;
    private String especialidad;

    //id_equipo
    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

}
