package com.example.portal.Repositorio;


import com.example.portal.modelo.Menu;

import org.springframework.data.repository.Repository;

import java.awt.*;
import java.util.List;

public interface MenuRepositorio extends Repository<Menu, Integer> {
    List<Menu> findAll();
    Menu findById(int id);
    Menu save(Menu p);

    Void delete(Menu p);
}
