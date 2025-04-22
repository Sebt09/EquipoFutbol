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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_jugador;
    private String nombre;
    private String posicion;
    private int dorsal;
    private LocalDate fecha_nacimiento;
    private String nacionalidad;

    //id_equipo
    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

    @OneToMany(mappedBy = "jugador")
    @JsonIgnore
    private List<EstadisticasJugador> estadisticasJugadorList;
}
