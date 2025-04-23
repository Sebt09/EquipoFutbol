package com.example.EquipoFutbol.Controller;

import com.example.EquipoFutbol.Model.Entrenador;
import com.example.EquipoFutbol.Service.EntrenadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("apientrenador")
public class EntrenadorController {

    private final EntrenadorService entrenadorService;

    public EntrenadorController(EntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @PostMapping("/guardar")
    public Entrenador guardarEntrenador(@RequestBody Entrenador entrenador){
        return entrenadorService.guardarEntrenador(entrenador);
    }

    @GetMapping("/listar")
    public List<Entrenador> listarEntrenador(){
        return entrenadorService.listarEntrenador();
    }

    @GetMapping("/buscar/{id}")
    public Optional<Entrenador> listarEntrenadorPorId(@PathVariable int id){
        return entrenadorService.listarEntrenadorPorId(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarEntrenador(@PathVariable int id){
        entrenadorService.eliminarEntrenador(id);
    }

    @PutMapping("/actualizar")
    public Entrenador actualizarEntrenador(@RequestBody Entrenador entrenador){
        return entrenadorService.guardarEntrenador(entrenador);
    }
}
