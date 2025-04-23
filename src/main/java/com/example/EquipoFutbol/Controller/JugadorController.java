package com.example.EquipoFutbol.Controller;

import com.example.EquipoFutbol.Model.Jugador;
import com.example.EquipoFutbol.Service.JugadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("apijugador")
public class JugadorController {
    
    private final JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @PostMapping("/guardar")
    public Jugador guardarJugador(@RequestBody Jugador jugador){
        return jugadorService.guardarJugador(jugador);
    }

    @GetMapping("/listar")
    public List<Jugador> listarJugador(){
        return jugadorService.listarJugador();
    }

    @GetMapping("/buscar/{id}")
    public Optional<Jugador> listarJugadorPorId(@PathVariable int id){
        return jugadorService.listarJugadorPorId(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarJugador(@PathVariable int id){
        jugadorService.eliminarJugador(id);
    }

    @PutMapping("/actualizar")
    public Jugador actualizarJugador(@RequestBody Jugador jugador){
        return jugadorService.guardarJugador(jugador);
    }

    @GetMapping("/listar/jugadores/equipo/{id}")
    public List<Jugador> listarJugadoresPorEquipo(@PathVariable int id){
        return jugadorService.listarJugadoresPorEquipo(id);
    }

    @GetMapping("/listar/jugadores/goles/{minGoles}")
    public List<Jugador> listarJugadoresConMasDeXGoles(@PathVariable int minGoles) {
        return jugadorService.listarJugadoresConMasDeXGoles(minGoles);
    }

}
