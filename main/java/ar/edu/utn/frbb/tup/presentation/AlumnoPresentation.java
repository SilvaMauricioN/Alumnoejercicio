package ar.edu.utn.frbb.tup.presentation;

import ar.edu.utn.frbb.tup.business.AlumnoService;
import ar.edu.utn.frbb.tup.business.MateriaService;
import ar.edu.utn.frbb.tup.business.impl.AlumnoServiceImpl;
import ar.edu.utn.frbb.tup.business.impl.AsignaturaServiceImpl;
import ar.edu.utn.frbb.tup.business.impl.MateriaServiceImpl;
import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.model.exception.CorrelatividadesNoAprobadasException;
import ar.edu.utn.frbb.tup.model.exception.EstadoIncorrectoException;
import ar.edu.utn.frbb.tup.persistence.exception.DaoException;


public class AlumnoPresentation {
    AlumnoService alumnoService = new AlumnoServiceImpl();
    AsignaturaServiceImpl asignaturaService = new AsignaturaServiceImpl();
    MateriaService materiaService = new MateriaServiceImpl();
    public AlumnoPresentation() throws DaoException {
    }
    public void aprobarMateria( int materiaId, int nota, Long dni) throws EstadoIncorrectoException, CorrelatividadesNoAprobadasException {

        if (validarnota(nota)) {
            alumnoService.aprobarAsignatura(materiaId,nota,dni);

        }else{
            throw new IllegalArgumentException("La nota debe estar entre 0 y 10");
        }
    }
    public void inicializarAsignatura(Asignatura asignatura,Long dni){
        try {
            alumnoService.inicializarAsignatura(asignatura,dni);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }
    public Alumno buscarAlumno(Long dni) throws DaoException {
       return alumnoService.buscarAlumno(dni);
    }
    public void cursarAsignatura(Long dni, Asignatura asignatura) throws DaoException {
        asignaturaService.cursarAsignatura(asignatura, dni);
    }
    public void cargarAlumno() throws DaoException {
        alumnoService.cargarAlumno();
    }
    public void cargarMateria() throws DaoException {
        materiaService.cargarMateria();

    }
    private boolean validarnota(int nota){
        return nota >= 0 && nota <= 10;
    }

}
