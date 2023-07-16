package com.example.portal.ServicioImple;

import com.example.portal.Interfaces.MenuServicio;
import com.example.portal.Repositorio.MenuRepositorio;
import com.example.portal.Repositorio.PersonaRepositorio;
import com.example.portal.modelo.Menu;
import com.example.portal.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServicioImplement implements MenuServicio {

    @Autowired
    private MenuRepositorio repositorio;
    @Override
    public List<Menu> listar() {
        return repositorio.findAll();
    }


    @Override
    public Menu listarId(int id) {
        return repositorio.findById(id);
    }

    @Override
    public Menu add(Menu p) {
        return repositorio.save(p);
    }

    @Override
    public Menu edit(Menu p) {
        return repositorio.save(p);
    }

    @Override
    public Menu delete(int id) {
        Menu p = repositorio.findById(id);
        if(p!=null){
            repositorio.delete(p);
        }
        return p;
    }
}
