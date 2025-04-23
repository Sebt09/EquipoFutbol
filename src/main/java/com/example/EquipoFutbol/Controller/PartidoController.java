package com.example.EquipoFutbol.Controller;


import com.example.EquipoFutbol.Model.Partido;
import com.example.EquipoFutbol.Service.PartidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("apipartido")
public class PartidoController {
    
    private final PartidoService partidoService;

    public PartidoController(PartidoService partidoService) {
        this.partidoService = partidoService;
    }

    @PostMapping("/guardar")
    public Partido guardarPartido(@RequestBody Partido partido){
        return partidoService.guardarPartido(partido);
    }

    @GetMapping("/listar")
    public List<Partido> listarPartido(){
        return partidoService.listarPartido();
    }

    @GetMapping("/buscar/{id}")
    public Optional<Partido> listarPartidoPorId(@PathVariable int id){
        return partidoService.listarPartidoPorId(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarPartido(@PathVariable int id){
        partidoService.eliminarPartido(id);
    }

    @PutMapping("/actualizar")
    public Partido actualizarPartido(@RequestBody Partido partido){
        return partidoService.guardarPartido(partido);
    }

    @GetMapping("/goles/equipo/{id}")
    public int obtenerTotalGolesEquipo(@PathVariable int id) {
        return partidoService.obtenerTotalGolesEquipo(id);
    }

    @GetMapping("/resultados")
    public List<Object[]> obtenerResultadosPartidos() {
        return partidoService.obtenerResultadosPartidos();
    }

}
