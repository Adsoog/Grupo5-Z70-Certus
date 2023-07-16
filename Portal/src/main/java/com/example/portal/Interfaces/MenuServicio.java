package com.example.portal.Interfaces;

import com.example.portal.modelo.Menu;

import java.util.List;

public interface MenuServicio {

    List<Menu> listar();
    Menu listarId(int id);
    Menu add(Menu p);
    Menu edit(Menu p);

    Menu delete(int id);
}
