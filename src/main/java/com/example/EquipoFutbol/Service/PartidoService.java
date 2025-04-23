package com.example.EquipoFutbol.Service;

import com.example.EquipoFutbol.Model.Partido;
import com.example.EquipoFutbol.Repository.PartidoRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PartidoService {
    
    private final PartidoRepository partidoRepository;
    
    public PartidoService(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }

    public Partido guardarPartido(Partido partido){
        try{
            if(partido.getEquipo_local() == null || partido.getEquipo_visita() == null){
                throw new IllegalArgumentException("Ingrese un equipo local y un equipo visitante para las estadisticas del Partido");
            }
            return partidoRepository.save(partido);
        }catch(Exception e){
            throw new RuntimeException("No se pudo guardar el partido ", e);
        }
    }

    public List<Partido> listarPartido(){
        try{
            return partidoRepository.findAll();
        }catch (Exception e){
            throw new RuntimeException("Error al listar los partidos");
        }
    }

    public Optional<Partido> listarPartidoPorId(int id) {
        try{
            if(!partidoRepository.existsById(id)){
                throw new IllegalArgumentException("No se encontro el Partido con ID: " + id);
            }
            return partidoRepository.findById(id);
        }catch(Exception e){
            throw new RuntimeException("Error al buscar el partido por ID: " + id + e.getMessage(), e);
        }
    }

    public void eliminarPartido(int id){
        try{
            if(!partidoRepository.existsById(id)){
                throw new IllegalArgumentException("No se encontro las estadisticas del Partido con ID: " + id);
            }
            partidoRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Error al eliminar las estadisticas del Partido");
        }
    }

    public int obtenerTotalGolesEquipo(int idEquipo) {
        return partidoRepository.totalGolesPorEquipo(idEquipo);
    }

    public List<Object[]> obtenerResultadosPartidos() {
        return partidoRepository.obtenerResultadosConNombresEquipos();
    }


}
