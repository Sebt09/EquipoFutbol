package com.example.EquipoFutbol.Repository;

import com.example.EquipoFutbol.Model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Integer> {
}
