package com.example.EquipoFutbol.Service;


import com.example.EquipoFutbol.Model.EstadisticasJugador;
import com.example.EquipoFutbol.Repository.EstadisticasJugadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadisticasJugadorService {

    private final EstadisticasJugadorRepository estadisticasJugadorRepository;


    public EstadisticasJugadorService(EstadisticasJugadorRepository estadisticasJugadorRepository) {
        this.estadisticasJugadorRepository = estadisticasJugadorRepository;
    }

    public EstadisticasJugador guardarEstadisticasJugador(EstadisticasJugador estadisticasJugador){
        try{
            if(estadisticasJugador.getJugador() == null || estadisticasJugador.getPartido() == null){
                throw new IllegalArgumentException("Ingrese un jugador y un partido para las estadisticas del Jugador");
            }
            return estadisticasJugadorRepository.save(estadisticasJugador);
        }catch(Exception e){
            throw new RuntimeException("No se pudo guardar el estadisticasJugador ", e);
        }
    }

    public List<EstadisticasJugador> listarEstadisticasJugador(){
        try{
            return estadisticasJugadorRepository.findAll();
        }catch (Exception e){
            throw new RuntimeException("Error al listar las estadisticas de los Jugadores");
        }
    }

    public Optional<EstadisticasJugador> listarEstadisticasJugadorPorId(int id) {
        try{
            if(!estadisticasJugadorRepository.existsById(id)){
                throw new IllegalArgumentException("No se encontraron las estadisticas del Jugador con ID: " + id);
            }
            return estadisticasJugadorRepository.findById(id);
        }catch(Exception e){
            throw new RuntimeException("Error al buscar el estadisticas del jugador por ID: " + id + e.getMessage(), e);
        }
    }

    public void eliminarEstadisticasJugador(int id){
        try{
            if(!estadisticasJugadorRepository.existsById(id)){
                throw new IllegalArgumentException("No se encontro las estadisticas del Jugador con ID: " + id);
            }
            estadisticasJugadorRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Error al eliminar las estadisticas del Jugador");
        }
    }
}
