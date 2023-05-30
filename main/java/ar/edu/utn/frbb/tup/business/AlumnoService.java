package ar.edu.utn.frbb.tup.business;

import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.model.exception.CorrelatividadesNoAprobadasException;
import ar.edu.utn.frbb.tup.model.exception.EstadoIncorrectoException;
import ar.edu.utn.frbb.tup.persistence.exception.DaoException;

import java.util.List;

public interface AlumnoService {
    void cargarAlumno() throws DaoException;
    Alumno buscarAlumno(Long dni) throws DaoException;
    void inicializarAsignatura(Asignatura asignatura, Long dni)throws DaoException;
    void aprobarAsignatura(int materiaId, int nota, Long dni) throws EstadoIncorrectoException, CorrelatividadesNoAprobadasException;

}
