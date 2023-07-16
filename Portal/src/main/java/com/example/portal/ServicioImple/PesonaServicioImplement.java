package com.example.portal.ServicioImple;

import com.example.portal.Interfaces.PersonaServicio;
import com.example.portal.Repositorio.PersonaRepositorio;
import com.example.portal.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PesonaServicioImplement implements PersonaServicio {

    @Autowired
    private PersonaRepositorio repositorio;

    @Override
    public List<Persona> listar() {
        return repositorio.findAll();
    }

    @Override
    public Persona listarId(int id) {
        return repositorio.findById(id);
    }

    @Override
    public Persona add(Persona p) {
        return repositorio.save(p);
    }

    @Override
    public Persona edit(Persona p) {
        return repositorio.save(p);
    }

    @Override
    public Persona delete(int id) {
        Persona p = repositorio.findById(id);
        if(p!=null){
            repositorio.delete(p);
        }
        return p;
    }


}
