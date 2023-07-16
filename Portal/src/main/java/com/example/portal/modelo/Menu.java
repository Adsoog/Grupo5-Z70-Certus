package com.example.portal.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String tipodemenu;


    @Column
    private String nombremenu;


    @Column
    private String descripciondemenu;

    @Column
    private String costomenu;

    @Column
    private String dia;

    @Column
    private String chef;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipodemenu() {
        return tipodemenu;
    }

    public void setTipodemenu(String tipodemenu) {
        this.tipodemenu = tipodemenu;
    }

    public String getNombremenu() {
        return nombremenu;
    }

    public void setNombremenu(String nombremenu) {
        this.nombremenu = nombremenu;
    }

    public String getDescripciondemenu() {
        return descripciondemenu;
    }

    public void setDescripciondemenu(String descripciondemenu) {
        this.descripciondemenu = descripciondemenu;
    }

    public String getCostomenu() {
        return costomenu;
    }

    public void setCostomenu(String costomenu) {
        this.costomenu = costomenu;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getChef() {
        return chef;
    }

    public void setChef(String chef) {
        this.chef = chef;
    }
}

