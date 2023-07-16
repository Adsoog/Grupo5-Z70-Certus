package com.example.portal.Controlador;

import com.example.portal.Interfaces.PersonaServicio;
import com.example.portal.modelo.Persona;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/",maxAge = 3600)
@RestController
@RequestMapping({"/personas"})
public class controladorPersona {

    @Autowired
    PersonaServicio servicio;

    @GetMapping
    public List<Persona> listar(){
        return servicio.listar();
    }

    @PostMapping
    public Persona agregar(@RequestBody Persona p){
        return servicio.add(p);
    }

    @GetMapping(path= {"/{id}"})
    public Persona listarId(@PathVariable("id")int id ){
        return servicio.listarId(id);
    }

    @PutMapping (path= {"/{id}"})
    public Persona editar(@RequestBody Persona p,@PathVariable("id") int id){
        p.setId(id);
        return servicio.edit(p);

    }

    @DeleteMapping(path= {"/{id}"})
    public Persona delete(@PathVariable("id") int id){
        return servicio.delete(id);
    }


}
