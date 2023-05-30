package ar.edu.utn.frbb.tup.business.impl;
import java.util.List;

import ar.edu.utn.frbb.tup.business.MateriaService;
import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.persistence.MateriaDao;
import ar.edu.utn.frbb.tup.persistence.MateriaDaoMemoryImpl;
import ar.edu.utn.frbb.tup.persistence.exception.DaoException;
import ar.edu.utn.frbb.tup.presentation.AlumnoInputProcessor;
import ar.edu.utn.frbb.tup.presentation.MateriaInputProcessor;


public class MateriaServiceImpl implements MateriaService {
    MateriaDao repositorioMateria = MateriaDaoMemoryImpl.getInstance();
    public MateriaServiceImpl() throws DaoException {
    }
    public List<Materia> getMateriaCorrelativas(int id){
        Materia materia = repositorioMateria.findMateria(id);
        return materia.getCorrelativas();
    }
    public void setCorrelativa(int id, Materia materiaCorrelativa) throws DaoException {
        Materia materia = repositorioMateria.findMateria(id);
        materia.agregarCorrelatividad(materiaCorrelativa);
        repositorioMateria.actualizarMateria(materia);
    }
    public void cargarMateria() throws DaoException {
        Materia materia = new Materia();
        MateriaInputProcessor procesarDatos = new MateriaInputProcessor();
        procesarDatos.processInput(materia);
        repositorioMateria.saveMateria(materia);
    }

}
