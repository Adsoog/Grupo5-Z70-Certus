package com.example.portal.Repositorio;

import com.example.portal.modelo.Persona;

import org.springframework.data.repository.Repository;


import java.util.List;






public interface PersonaRepositorio extends Repository<Persona, Integer> {
    List<Persona>findAll();
    Persona findById(int id);
    Persona save(Persona p);

    Void delete(Persona p);

}
