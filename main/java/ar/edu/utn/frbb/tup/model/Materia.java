package ar.edu.utn.frbb.tup.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Materia {
    private String nombre;
    private int id;
    private int anio;
    private int cuatrimestre;
    private Profesor profesor;
    private List<Materia> ListaCorrelatividades;

    public Materia(){};
    public Materia(String nombre,int id, int anio, int cuatrimestre, Profesor profesor) {
        this.anio = anio;
        this.id = id;
        this.cuatrimestre = cuatrimestre;
        this.nombre = nombre;
        this.profesor = profesor;
        this.ListaCorrelatividades = new ArrayList<>();
    }
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public int getAnio() { return anio;};

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(int cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Materia> getListaCorrelatividades() {
        return ListaCorrelatividades;
    }

    public void setListaCorrelatividades(List<Materia> listaCorrelatividades) {
        ListaCorrelatividades = listaCorrelatividades;
    }

    public Profesor getProfesor(){
        return profesor;
    }
    public void agregarCorrelatividad(Materia m){
        ListaCorrelatividades.add(m);
    }
    public List<Materia> getCorrelativas() {
        return ListaCorrelatividades;
    }
    @Override
    public String toString() {
        return "Materia{" +
                "nombre='" + nombre + '\'' +
                ",ID=" + id +
                ", año=" + anio +
                ", cuatrimestre=" + cuatrimestre +
                ", profesor=" + profesor +
                ", correlatividades=" + ListaCorrelatividades +
                '}';
    }
    @Override
    public boolean equals(Object materia) {
        if (this == materia){
            return true;
        }
        if (materia == null || getClass() != materia.getClass()) {
            return false;
        }

        Materia materiaControl = (Materia) materia;

        return Objects.equals(this.id,materiaControl.getId());
    }
}
