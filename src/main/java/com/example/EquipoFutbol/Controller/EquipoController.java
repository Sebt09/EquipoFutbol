package com.example.EquipoFutbol.Controller;


import com.example.EquipoFutbol.Model.Equipo;
import com.example.EquipoFutbol.Service.EquipoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("apiequipo")
public class EquipoController {
    
    private final EquipoService equipoService;


    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @PostMapping("/guardar")
    public Equipo guardarEquipo(@RequestBody Equipo equipo){
        return equipoService.guardarEquipo(equipo);
    }

    @GetMapping("/listar")
    public List<Equipo> listarEquipo(){
        return equipoService.listarEquipo();
    }

    @GetMapping("/buscar/{id}")
    public Optional<Equipo> listarEquipoPorId(@PathVariable int id){
        return equipoService.listarEquipoPorId(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarEquipo(@PathVariable int id){
        equipoService.eliminarEquipo(id);
    }

    @PutMapping("/actualizar")
    public Equipo actualizarEquipo(@RequestBody Equipo equipo){
        return equipoService.guardarEquipo(equipo);
    }
}
