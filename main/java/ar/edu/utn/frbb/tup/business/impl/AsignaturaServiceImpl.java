package ar.edu.utn.frbb.tup.business.impl;
import ar.edu.utn.frbb.tup.business.AsignaturaService;
import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.model.EstadoAsignatura;
import ar.edu.utn.frbb.tup.model.exception.EstadoIncorrectoException;
import ar.edu.utn.frbb.tup.persistence.*;
import ar.edu.utn.frbb.tup.persistence.exception.DaoException;

import java.util.List;

public class AsignaturaServiceImpl implements AsignaturaService {
    AlumnoDao repositorioAlumno = AlumnoDaoMemoryImpl.getInstance();
    AsignaturaDao repositorioAsignatura = new AsignaturaDaoMemoryImpl();
    public AsignaturaServiceImpl() throws DaoException {
    }
    public void setAsignatura(Asignatura asignatura) throws DaoException {
        repositorioAsignatura.saveAsignatura(asignatura);
    }
    public String aprobarAsignatura(int nota, Asignatura asignatura) throws EstadoIncorrectoException {
        if (!asignatura.getEstado().equals(EstadoAsignatura.CURSADA)) {
            throw new EstadoIncorrectoException("La materia debe estar cursada");
        }
        if (nota>=4 && nota<=10) {
            asignatura.setEstado(EstadoAsignatura.APROBADA);
            asignatura.setNota(nota);
            return "Nota cargada Existosamente";
        }
        return "no se puede aprobar con " + nota ;
    }
    public void cursarAsignatura(Asignatura asignatura,Long dni){
        Alumno alumno = repositorioAlumno.findAlumno(dni);
        List<Asignatura> listaAsignatura = alumno.obtenerListaAsignaturas();

        if(listaAsignatura == null){
            System.out.println("La Asignatura no está inicializada");
        }else{
            for(Asignatura a : listaAsignatura){
                if(a.equals(asignatura)){
                    a.setEstado(EstadoAsignatura.CURSADA);
                }
            }
            repositorioAlumno.actualizarAlumno(alumno);
        }
    }
}
