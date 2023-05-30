package ar.edu.utn.frbb.tup.model;

import ar.edu.utn.frbb.tup.model.exception.AsignaturaInexistenteException;
import ar.edu.utn.frbb.tup.model.exception.CorrelatividadException;
import ar.edu.utn.frbb.tup.model.exception.EstadoIncorrectoException;
import ar.edu.utn.frbb.tup.model.exception.AsignaturaYaExistenteException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Alumno {
    private String nombre;
    private String apellido;
    private long dni;
    private List<Asignatura> listaAsignaturas;
    public Alumno(){};

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public List<Asignatura> getListaAsignaturas() {
        return listaAsignaturas;
    }

    public void setListaAsignaturas(List<Asignatura> listaAsignaturas) {
        this.listaAsignaturas = listaAsignaturas;
    }

    public Alumno(String nombre, String apellido, long dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        listaAsignaturas = new ArrayList<>();
    }
    public long getDni() {
        return this.dni;
    }

    public List<Asignatura> obtenerListaAsignaturas(){
        return this.listaAsignaturas;
    }
    public boolean puedeCursarMateria(Materia materia) {
        List <Materia> listaCorrelativas = materia.getCorrelativas();
        boolean puedeCursar = false;

        if (listaCorrelativas == null || listaCorrelativas.isEmpty()){
            return true;
        }

        for(Materia correlativa:listaCorrelativas){
            if(!listaAsignaturas.isEmpty()){
                for(Asignatura a: listaAsignaturas){
                    if(a.getNombreAsignatura().equals(correlativa.getNombre()) && EstadoAsignatura.APROBADA.equals(a.getEstado())){
                        puedeCursar = true;
                        break;
                    }
                }
                //si no tiene una materia aprobada (tieneCorrelativa=false) no puede cursar
                if (!puedeCursar){
                    return false;
                }
            }else{
                return false;
            }
        }
       return true;
    }
    public void setAsignatura(Asignatura asignatura){
        if(!listaAsignaturas.contains(asignatura)) {
            this.listaAsignaturas.add(asignatura);
        }
    }
    public void aprobarAsignatura(Materia materia, int nota) throws EstadoIncorrectoException, CorrelatividadException, AsignaturaInexistenteException {
        Asignatura asignaturaAAprobar = getAsignaturaAAprobar(materia);

        for (Materia correlativa : materia.getCorrelativas()) {
            chequearCorrelatividad(correlativa);
        }
        asignaturaAAprobar.aprobarAsignatura(nota);
    }
    //Chequea si la materia esta aprobada o no
    private void chequearCorrelatividad(Materia correlativa) throws CorrelatividadException {
        for (Asignatura a:
                listaAsignaturas) {
            if (correlativa.getNombre().equals(a.getNombreAsignatura())) {
                if (!EstadoAsignatura.APROBADA.equals(a.getEstado())) {
                    throw new CorrelatividadException("La asignatura " + a.getNombreAsignatura() + " no está aprobada");
                }
            }
        }
    }
    private Asignatura getAsignaturaAAprobar(Materia materia) throws AsignaturaInexistenteException {

        for (Asignatura asignatura: listaAsignaturas) {
            if (materia.getNombre().equals(asignatura.getNombreAsignatura())) {
                return asignatura;
            }
        }
        throw new AsignaturaInexistenteException("No se encontró la materia");
    }
    @Override
    public boolean equals(Object alumno) {
        if (this == alumno){
            return true;
        }
        if (alumno == null || getClass() != alumno.getClass()) {
            return false;
        }

        Alumno alumnoControl = (Alumno) alumno;

        return Objects.equals(this.dni,alumnoControl.getDni());
    }
    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", listaAsignaturas=" + listaAsignaturas +
                '}';
    }
}
