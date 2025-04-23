package com.example.EquipoFutbol.Repository;

import com.example.EquipoFutbol.Model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Integer> {

    @Query(value = "SELECT SUM(CASE WHEN p.equipo_local = :id THEN p.goles_local " +
            "WHEN p.equipo_visita = :id THEN p.goles_visita ELSE 0 END) " +
            "FROM partido p", nativeQuery = true)
    Integer totalGolesPorEquipo(@Param("id") int idEquipo);

    @Query(value = "SELECT p.id_partido, p.fecha, p.estadio, el.nombre AS nombre_local, ev.nombre AS nombre_visita, " +
            "p.goles_local, p.goles_visita " +
            "FROM partido p " +
            "JOIN equipo el ON p.equipo_local = el.id_equipo " +
            "JOIN equipo ev ON p.equipo_visita = ev.id_equipo", nativeQuery = true)
    List<Object[]> obtenerResultadosConNombresEquipos();


}
