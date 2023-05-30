package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.persistence.exception.DaoException;

public interface AsignaturaDao {
    void saveAsignatura(Asignatura asignatura) throws DaoException;
    Asignatura findAsignatura(int id) throws DaoException;
    void actualizarAsignatura(Asignatura asignatura) throws DaoException;
}
