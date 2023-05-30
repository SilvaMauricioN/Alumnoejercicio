package ar.edu.utn.frbb.tup;

import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.persistence.exception.DaoException;
import ar.edu.utn.frbb.tup.presentation.AlumnoPresentation;
import ar.edu.utn.frbb.tup.presentation.MateriaInputProcessor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        Profesor lucho = new Profesor("Luciano", "Salotto", "Lic. en Cs. de la Computacion" );
        Profesor marcos = new Profesor("Marco", "Ustarroz", "Ing en Sistemas");
        Profesor rafa = new Profesor("Rafael", "Martinez", "Lic en Cs. de la Computacion");
        Profesor seba = new Profesor("Sebastian", "Zunini", "Lic en computación");

        Materia programacionI = new Materia("programacion I",1,2022,1,marcos);
        Materia programacion2 = new Materia("programacion II", 2,2022,1,rafa);
        Materia programacion3 = new Materia("Programacion III",3,2023,1,seba);



    }
}
