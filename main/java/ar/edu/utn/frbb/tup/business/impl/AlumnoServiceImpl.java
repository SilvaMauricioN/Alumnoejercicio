package ar.edu.utn.frbb.tup.business.impl;

import ar.edu.utn.frbb.tup.business.AlumnoService;
import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.model.EstadoAsignatura;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.exception.EstadoIncorrectoException;
import ar.edu.utn.frbb.tup.persistence.AlumnoDao;
import ar.edu.utn.frbb.tup.persistence.AlumnoDaoMemoryImpl;
import ar.edu.utn.frbb.tup.persistence.exception.DaoException;
import ar.edu.utn.frbb.tup.presentation.AlumnoInputProcessor;

import java.util.List;

public class AlumnoServiceImpl implements AlumnoService {
    AsignaturaServiceImpl asignaturaService = new AsignaturaServiceImpl();
    MateriaServiceImpl materiaService = new MateriaServiceImpl();
    AlumnoDao repositorioAlumno = AlumnoDaoMemoryImpl.getInstance();

    public AlumnoServiceImpl() throws DaoException {
    }
    @Override
    public void cargarAlumno() throws DaoException {
        Alumno alumno = new Alumno();
        AlumnoInputProcessor procesarDatos = new AlumnoInputProcessor();
        procesarDatos.processInput(alumno);
        repositorioAlumno.saveAlumno(alumno);
    }
    @Override
    public Alumno buscarAlumno(Long dni) throws DaoException {
        return repositorioAlumno.findAlumno(dni);
    }
    @Override
    public void inicializarAsignatura(Asignatura asignatura,Long dni) throws DaoException {
        Alumno alumno = repositorioAlumno.findAlumno(dni);
        alumno.setAsignatura(asignatura);
        repositorioAlumno.actualizarAlumno(alumno);
    }
    @Override
    public void aprobarAsignatura(int materiaId, int nota, Long dni) throws EstadoIncorrectoException{
        List<Asignatura> listaAsignatura = buscarenRepositorioAsignaturas(dni);

        for(Asignatura asignatura:listaAsignatura){
            if(asignatura.getMateria().getId() == materiaId){
                if(chequearCorrelativas(materiaId,dni)){
                    asignaturaService.aprobarAsignatura(nota,asignatura);
                }
            }
        }
    }

    private boolean chequearCorrelativas(int materiaId, Long dni){

        List<Asignatura> listaAsignatura = buscarenRepositorioAsignaturas(dni);
        List<Materia> listaCorrelativa = materiaService.getMateriaCorrelativas(materiaId);

        if(listaCorrelativa == null || listaCorrelativa.isEmpty()){
            return true;
        }
        for(Materia correlativa : listaCorrelativa){
            boolean aprobada = false;
            for(Asignatura asignatura: listaAsignatura){
                if(asignatura.getNombreAsignatura().equals(correlativa.getNombre()) && EstadoAsignatura.APROBADA.equals(asignatura.getEstado())){
                    aprobada = true;
                    break;
                }
            }
            if(!aprobada){
                return false;
            }
        }
        return true;
    }
    private List<Asignatura> buscarenRepositorioAsignaturas(Long dni){
        Alumno alumno = repositorioAlumno.findAlumno(dni);
        return alumno.obtenerListaAsignaturas();
    }



}
