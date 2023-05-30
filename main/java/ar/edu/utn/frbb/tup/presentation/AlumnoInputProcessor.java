package ar.edu.utn.frbb.tup.presentation;

import ar.edu.utn.frbb.tup.model.Alumno;

import java.util.Map;
import java.util.Scanner;

public class AlumnoInputProcessor {
    private Scanner scanner = new Scanner(System.in);

    public void processInput(Alumno inputObject) {
        Map<String, String> fields = AttributeInspector.getAttributeInputStrategy(Alumno.class);

        for (Map.Entry<String, String> entry:
                fields.entrySet()) {
            String tipoDeDatoALeer = entry.getValue();
            String nombreDeProperty = entry.getKey();
            InputStrategy inputStrategy = BaseInputStrategy.getStrategy(tipoDeDatoALeer);
            System.out.print("Ingrese su " + entry.getKey()+ ": ");
            Object consoleInput = inputStrategy.acceptInput(scanner);

            AttributeInspector.invokeSetter(inputObject, entry.getKey(), consoleInput);
        }
    }
}
