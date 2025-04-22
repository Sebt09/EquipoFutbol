package com.example.EquipoFutbol.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_partido;
    private LocalDate fecha;
    private String estadio;

    //equipo_local
    @ManyToOne
    @JoinColumn(name = "equipo_local")
    private Equipo equipo_local;

    //equipo_visita
    @ManyToOne
    @JoinColumn(name = "equipo_visita")
    private Equipo equipo_visita;

    private int goles_local;
    private int goles_visita;

    @OneToMany(mappedBy = "partido")
    @JsonIgnore
    private List<EstadisticasJugador> estadisticasJugadorList;
}
