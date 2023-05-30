package ar.edu.utn.frbb.tup.model;

import java.util.List;

public class Profesor {
    private final String nombre;
    private final String apellido;
    private final String titulo;
    private List<Materia> materiasDicatadas;

    public Profesor(String nombre, String apellido, String titulo) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.titulo = titulo;
    }

    public String getNombre(){ return nombre;}
    public String getApellido(){ return apellido;}
    public String getTitulo(){return titulo;}

    @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", titulo='" + titulo + '\'' +
                ", materiasDicatadas=" + materiasDicatadas +
                '}';
    }

}
