package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.persistence.exception.DaoException;

public interface AlumnoDao {

    void saveAlumno(Alumno a) throws DaoException;
    void actualizarAlumno(Alumno alumno);

    Alumno findAlumno(Long dni);
}
