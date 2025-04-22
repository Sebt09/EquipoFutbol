package com.example.EquipoFutbol.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_equipo;
    private String nombre;
    private String ciudad;
    private LocalDate fundacion;

    @OneToMany(mappedBy = "equipo")
    @JsonIgnore
    private List<Jugador> jugadores;

    @OneToMany(mappedBy = "equipo")
    @JsonIgnore
    private List<Entrenador> entrenadores;

    @OneToMany(mappedBy = "equipo_local")
    @JsonIgnore
    private List<Partido> partidos_local;


    @OneToMany(mappedBy = "equipo_visita")
    @JsonIgnore
    private List<Partido> partidos_visita;
}
