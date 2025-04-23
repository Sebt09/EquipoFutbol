package com.example.EquipoFutbol.Service;

import com.example.EquipoFutbol.Model.Entrenador;
import com.example.EquipoFutbol.Repository.EntrenadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrenadorService {

    private final EntrenadorRepository entrenadorRepository;

    public EntrenadorService(EntrenadorRepository entrenadorRepository) {
        this.entrenadorRepository = entrenadorRepository;
    }

    public Entrenador guardarEntrenador(Entrenador entrenador){
        try{
            if(entrenador.getNombre() == null || entrenador.getNombre().isEmpty() || entrenador.getEquipo() == null){
                throw new IllegalArgumentException("Ingrese un nombre para el entrenador");
            }else{
                int id_equipo = entrenador.getEquipo().getId_equipo();
                if(id_equipo >= 0){
                    throw new IllegalArgumentException("Equipo no valido");
                }else {
                    return entrenadorRepository.save(entrenador);
                }
            }
        }catch(Exception e){
            throw new RuntimeException("No se pudo guardar el entrenador ", e);
        }
    }

    public List<Entrenador> listarEntrenador(){
        try{
            return entrenadorRepository.findAll();
        }catch (Exception e){
            throw new RuntimeException("Error al listar los entrenadores");
        }
    }

    public Optional<Entrenador> listarEntrenadorPorId(int id) {
        try{
            if(!entrenadorRepository.existsById(id)){
                throw new IllegalArgumentException("No se encontro el entrenador con ID: " + id);
            }
            return entrenadorRepository.findById(id);
        }catch(Exception e){
            throw new RuntimeException("Error al buscar el entrnador por ID: " + id + e.getMessage(), e);
        }
    }

    public void eliminarEntrenador(int id){
        try{
            if(!entrenadorRepository.existsById(id)){
                throw new IllegalArgumentException("No se encontro el entrenador con ID: " + id);
            }
            entrenadorRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Error al eliminar al entrenador");
        }
    }
}
