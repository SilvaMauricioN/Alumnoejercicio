package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.persistence.exception.DaoException;

public interface MateriaDao {

    public void saveMateria(Materia materia) throws DaoException;
    public Materia findMateria(int id);
    public void actualizarMateria(Materia materia) throws DaoException;
}
