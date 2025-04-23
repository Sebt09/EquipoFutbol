package com.example.EquipoFutbol.Service;

import com.example.EquipoFutbol.Model.Jugador;
import com.example.EquipoFutbol.Repository.EquipoRepository;
import com.example.EquipoFutbol.Repository.JugadorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {
    
    private final JugadorRepository jugadorRepository;
    private final EquipoRepository equipoRepository;

    public JugadorService(JugadorRepository jugadorRepository, EquipoRepository equipoRepository) {
        this.jugadorRepository = jugadorRepository;
        this.equipoRepository = equipoRepository;
    }

    public Jugador guardarJugador(Jugador jugador){
        try{
            if(jugador.getEquipo() == null || jugador.getNombre() == null){
                throw new IllegalArgumentException("Ingrese un jugador y un partido para las estadisticas del Jugador");
            }
            return jugadorRepository.save(jugador);
        }catch(Exception e){
            throw new RuntimeException("No se pudo guardar el jugador ", e);
        }
    }

    public List<Jugador> listarJugador(){
        try{
            return jugadorRepository.findAll();
        }catch (Exception e){
            throw new RuntimeException("Error al listar las estadisticas de los Jugadores");
        }
    }

    public Optional<Jugador> listarJugadorPorId(int id) {
        try{
            if(!jugadorRepository.existsById(id)){
                throw new IllegalArgumentException("No se encontraron las estadisticas del Jugador con ID: " + id);
            }
            return jugadorRepository.findById(id);
        }catch(Exception e){
            throw new RuntimeException("Error al buscar el estadisticas del jugador por ID: " + id + e.getMessage(), e);
        }
    }

    public void eliminarJugador(int id){
        try{
            if(!jugadorRepository.existsById(id)){
                throw new IllegalArgumentException("No se encontro las estadisticas del Jugador con ID: " + id);
            }
            jugadorRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Error al eliminar las estadisticas del Jugador");
        }
    }

    public List<Jugador> listarJugadoresPorEquipo(int id){
        try{
            if(!equipoRepository.existsById(id)){
                throw new IllegalArgumentException("No se encontro el equipo con ID: " + id);
            }
            return jugadorRepository.listarJugadoresPorEquipo(id);
        }catch(Exception e){
            System.out.println("Error al listar los jugadores del equipo " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<Jugador> listarJugadoresConMasDeXGoles(int minGoles) {
        return jugadorRepository.listarJugadoresConMasDeXGoles(minGoles);
    }



}
