package com.example.EquipoFutbol.Service;


import com.example.EquipoFutbol.Model.Equipo;
import com.example.EquipoFutbol.Repository.EquipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    private final EquipoRepository equipoRepository;

    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    public Equipo guardarEquipo(Equipo equipo){
        try{
            if(equipo.getNombre() == null || equipo.getNombre().isEmpty()){
                throw new IllegalArgumentException("Ingrese un nombre para el equipo");
            }
            return equipoRepository.save(equipo);
        }catch(Exception e){
            throw new RuntimeException("No se pudo guardar el equipo ", e);
        }
    }

    public List<Equipo> listarEquipo(){
        try{
            return equipoRepository.findAll();
        }catch (Exception e){
            throw new RuntimeException("Error al listar los equipoes");
        }
    }

    public Optional<Equipo> listarEquipoPorId(int id) {
        try{
            if(!equipoRepository.existsById(id)){
                throw new IllegalArgumentException("No se encontro el equipo con ID: " + id);
            }
            return equipoRepository.findById(id);
        }catch(Exception e){
            throw new RuntimeException("Error al buscar el entrnador por ID: " + id + e.getMessage(), e);
        }
    }

    public void eliminarEquipo(int id){
        try{
            if(!equipoRepository.existsById(id)){
                throw new IllegalArgumentException("No se encontro el equipo con ID: " + id);
            }
            equipoRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Error al eliminar al equipo");
        }
    }
}
