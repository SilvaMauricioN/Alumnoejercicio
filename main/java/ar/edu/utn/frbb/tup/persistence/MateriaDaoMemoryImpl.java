package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.persistence.exception.DaoException;

import java.util.HashMap;
import java.util.Map;

public class MateriaDaoMemoryImpl implements MateriaDao {

    private static Map<Integer, Materia> repositorioMaterias = new HashMap<>();
    private static MateriaDaoMemoryImpl INSTANCE;
    public static MateriaDaoMemoryImpl getInstance() throws DaoException {
        if (INSTANCE == null) {
            INSTANCE = new MateriaDaoMemoryImpl();
        }
        return INSTANCE;
    }
    private MateriaDaoMemoryImpl() throws DaoException {
        inicializarMateria();
    }
    private void inicializarMateria() throws DaoException {
        Profesor lucho = new Profesor("Luciano", "Salotto", "Lic. en Cs. de la Computacion" );
        Profesor marcos = new Profesor("Marco", "Ustarroz", "Ing en Sistemas");
        Profesor rafa = new Profesor("Rafael", "Martinez", "Lic en Cs. de la Computacion");
        Materia programacionI = new Materia("programacion I",1,2022,1,marcos);
        Materia programacionII = new Materia("programacion II", 2,2020,1,rafa);
        Materia programacionIII = new Materia("Programacion III",3,2023,2,lucho);

        saveMateria(programacionI);
        saveMateria(programacionII);
        programacionIII.agregarCorrelatividad(programacionI);
        programacionIII.agregarCorrelatividad(programacionII);
        saveMateria(programacionIII);
    }
    public void saveMateria(Materia materia) throws DaoException {
        if(repositorioMaterias.containsKey(materia.getId())){
            throw new DaoException("La materia ya Existe, no se puede guardar");
        }
        repositorioMaterias.put(materia.getId(), materia);
    }
    public Materia findMateria(int id){
        return repositorioMaterias.get(id);
    }
    public void actualizarMateria(Materia materia) throws DaoException {
        if(!repositorioMaterias.containsKey(materia.getId())){
            throw new DaoException("La materia no Existe, no se puede Actualizar");
        }
        repositorioMaterias.put(materia.getId(), materia);
    }
}
