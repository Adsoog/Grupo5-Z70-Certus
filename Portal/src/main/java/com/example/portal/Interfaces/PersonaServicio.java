package com.example.portal.Interfaces;

import com.example.portal.modelo.Persona;

import java.util.List;

public interface PersonaServicio {
    List<Persona>listar();
    Persona listarId(int id);
    Persona add(Persona p);
    Persona edit(Persona p);

    Persona delete(int id);
}
