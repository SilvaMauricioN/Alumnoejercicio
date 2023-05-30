package ar.edu.utn.frbb.tup.model;

import ar.edu.utn.frbb.tup.model.exception.EstadoIncorrectoException;

import java.util.Objects;
import java.util.Optional;

public class Asignatura {
    private final Materia materia;
    private EstadoAsignatura estado;
    private Integer nota;
    public Asignatura(Materia materia) {
        this.materia = materia;
        this.estado = EstadoAsignatura.NO_CURSADA;
    }
    public Optional<Integer> getNota() {
        return Optional.ofNullable(nota);
    }
    public void setNota(int nota) {
        this.nota = nota;
    }
    public EstadoAsignatura getEstado() {
        return estado;
    }
    public void setEstado(EstadoAsignatura estado) {
        this.estado = estado;
    }
    public String getNombreAsignatura(){
        return this.materia.getNombre();
    }
    public Materia getMateria(){return this.materia;}
    public void cursarAsignatura(){
        this.estado = EstadoAsignatura.CURSADA;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "materia=" + materia +
                ", estado=" + estado +
                ", nota=" + nota +
                '}';
    }

    @Override
    public boolean equals(Object asignatura) {
        if (this == asignatura){
            return true;
        }
        if (asignatura == null || getClass() != asignatura.getClass()) {
            return false;
        }

        Asignatura asignaturaControl = (Asignatura) asignatura;

        return Objects.equals(this.materia.getNombre(),asignaturaControl.getMateria().getNombre());
    }

    public void aprobarAsignatura(int nota) throws EstadoIncorrectoException {
        if (nota<0 || nota>10){
            throw new IllegalArgumentException("La nota debe estar entre 0 y 10");
        }
        if (!this.estado.equals(EstadoAsignatura.CURSADA)) {
            throw new EstadoIncorrectoException("La materia debe estar cursada");
        }
        if (nota>=4 && nota<=10) {
            this.estado = EstadoAsignatura.APROBADA;
            this.nota = nota;
        }
    }
}
