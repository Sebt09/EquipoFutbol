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
public class EstadisticasJugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_estadistica;

    //Id_jugador
    @ManyToOne
    @JoinColumn(name = "id_jugador")
    private Jugador jugador;

    //id_partido
    @ManyToOne
    @JoinColumn(name = "id_partido")
    private Partido partido;

    private int minutos_jugados;
    private int goles;
    private int asistencias;
    private int tarjetas_amarillas;
    private int tarjetas_rojas;
}
