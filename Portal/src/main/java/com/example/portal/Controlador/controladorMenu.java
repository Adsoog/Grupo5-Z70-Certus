package com.example.portal.Controlador;


import com.example.portal.Interfaces.MenuServicio;
import com.example.portal.modelo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/",maxAge = 3600)
@RestController
@RequestMapping({"/menu"})
public class controladorMenu {
    @Autowired
    MenuServicio servicio;

    @GetMapping
    public List<Menu> listar(){
        return servicio.listar();
    }

    @PostMapping
    public Menu agregar(@RequestBody Menu p){
        return servicio.add(p);
    }

    @GetMapping(path= {"/{id}"})
    public Menu listarId(@PathVariable("id")int id ){
        return servicio.listarId(id);
    }

    @PutMapping (path= {"/{id}"})
    public Menu editar(@RequestBody Menu p,@PathVariable("id") int id){
        p.setId(id);
        return servicio.edit(p);

    }

    @DeleteMapping(path= {"/{id}"})
    public Menu delete(@PathVariable("id") int id){
        return servicio.delete(id);
    }
}
