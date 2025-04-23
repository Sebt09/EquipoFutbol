package com.example.EquipoFutbol.Controller;


import com.example.EquipoFutbol.Model.EstadisticasJugador;
import com.example.EquipoFutbol.Service.EstadisticasJugadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("apiestadisticasjugador")
public class EstadisticasJugadorController {

    private final EstadisticasJugadorService estadisticasJugadorService;


    public EstadisticasJugadorController(EstadisticasJugadorService estadisticasJugadorService) {
        this.estadisticasJugadorService = estadisticasJugadorService;
    }

    @PostMapping("/guardar")
    public EstadisticasJugador guardarEstadisticasJugador(@RequestBody EstadisticasJugador estadisticasJugador){
        return estadisticasJugadorService.guardarEstadisticasJugador(estadisticasJugador);
    }

    @GetMapping("/listar")
    public List<EstadisticasJugador> listarEstadisticasJugador(){
        return estadisticasJugadorService.listarEstadisticasJugador();
    }

    @GetMapping("/buscar/{id}")
    public Optional<EstadisticasJugador> listarEstadisticasJugadorPorId(@PathVariable int id){
        return estadisticasJugadorService.listarEstadisticasJugadorPorId(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarEstadisticasJugador(@PathVariable int id){
        estadisticasJugadorService.eliminarEstadisticasJugador(id);
    }

    @PutMapping("/actualizar")
    public EstadisticasJugador actualizarEstadisticasJugador(@RequestBody EstadisticasJugador estadisticasJugador){
        return estadisticasJugadorService.guardarEstadisticasJugador(estadisticasJugador);
    }
}
