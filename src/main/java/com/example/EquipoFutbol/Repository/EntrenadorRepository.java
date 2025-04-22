package com.example.EquipoFutbol.Repository;

import com.example.EquipoFutbol.Model.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenadorRepository extends JpaRepository<Entrenador, Integer> {
}
