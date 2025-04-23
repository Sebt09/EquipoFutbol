package com.example.EquipoFutbol.Repository;

import com.example.EquipoFutbol.Model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {

    @Query(value = "SELECT * FROM jugador WHERE id_equipo = :idEquipo", nativeQuery = true)
    List<Jugador> listarJugadoresPorEquipo(@Param("idEquipo") int idEquipo);

    @Query(value = "SELECT j.* FROM jugador j " +
            "JOIN estadisticas_jugador ej ON j.id_jugador = ej.id_jugador " +
            "GROUP BY j.id_jugador " +
            "HAVING SUM(ej.goles) > :minGoles", nativeQuery = true)
    List<Jugador> listarJugadoresConMasDeXGoles(@Param("minGoles") int minGoles);

}
