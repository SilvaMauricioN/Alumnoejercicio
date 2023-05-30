package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.persistence.exception.DaoException;


import java.util.HashMap;
import java.util.Map;

public class AlumnoDaoMemoryImpl implements AlumnoDao {

    private static Map<Long, Alumno> repositorioAlumnos = new HashMap<>();
    private static AlumnoDaoMemoryImpl INSTANCE;
    public static AlumnoDaoMemoryImpl getInstance() throws DaoException {
        if (INSTANCE == null) {
            INSTANCE = new AlumnoDaoMemoryImpl();
        }
        return INSTANCE;
    }
    private AlumnoDaoMemoryImpl() throws DaoException {
        inicializarAlumno();
    }
    private void inicializarAlumno() throws DaoException {
        Alumno alumno = new Alumno("nicolas", "Silva",12345678);
        Profesor marcos = new Profesor("Marco", "Ustarroz", "Ing en Sistemas");
        Materia programacionI = new Materia("programacion I",1,2022,1,marcos);

        alumno.setAsignatura(new Asignatura(programacionI));
        saveAlumno(alumno);
    }
    @Override
    public void saveAlumno(Alumno alumno) throws DaoException {
        if(repositorioAlumnos.containsKey(alumno.getDni())){
            throw new DaoException("El alumno ya existe, no se puede registrar");
        }else{
            repositorioAlumnos.put(alumno.getDni(), alumno);
        }
    }
    public void actualizarAlumno(Alumno alumno)  {
        repositorioAlumnos.put(alumno.getDni(),alumno);
    }
    @Override
    public Alumno findAlumno(Long dni){
        // Retorna un objeto alumno si conincide, sino devuelve null
        return repositorioAlumnos.get(dni);
    }
}
