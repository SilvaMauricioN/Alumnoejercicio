package ar.edu.utn.frbb.tup.business;

import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.persistence.exception.DaoException;

import java.util.List;

public interface MateriaService {
    List<Materia> getMateriaCorrelativas(int id);
    void setCorrelativa(int id, Materia materiaCorrelativa) throws DaoException;
    void cargarMateria() throws DaoException;

}
