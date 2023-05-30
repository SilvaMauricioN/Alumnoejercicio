package ar.edu.utn.frbb.tup.persistence;
import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.persistence.exception.DaoException;

import java.util.ArrayList;
import java.util.List;

public class AsignaturaDaoMemoryImpl implements AsignaturaDao {

    private static  List<Asignatura> repositorioAsignatura = new ArrayList<>();

    public void saveAsignatura(Asignatura asignatura) throws DaoException {

        if(repositorioAsignatura.contains(asignatura)){
            throw new DaoException("La materia ya Existe, no se puede guardar");
        }
        repositorioAsignatura.add(asignatura);
    }
    public Asignatura findAsignatura(int id) throws DaoException {

        for(Asignatura asignatura: repositorioAsignatura){
            if(asignatura.getMateria().getId() == id){
                return asignatura;
            }
        }
        throw  new DaoException("La Asignatura no existe");
    }

    public void actualizarAsignatura(Asignatura asignatura) throws DaoException {

        if(!repositorioAsignatura.contains(asignatura)){
            throw new DaoException("La Asignatura no existe, no se puede actualizar");
        }
        repositorioAsignatura.add(asignatura);
    }


}
