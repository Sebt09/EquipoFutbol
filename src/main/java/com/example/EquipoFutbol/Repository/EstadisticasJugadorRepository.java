package com.example.EquipoFutbol.Repository;

import com.example.EquipoFutbol.Model.EstadisticasJugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadisticasJugadorRepository extends JpaRepository<EstadisticasJugador, Integer> {

}
