package ar.edu.utn.frbb.tup.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberInputStrategy extends BaseInputStrategy {

    private static NumberInputStrategy INSTANCE;

    private NumberInputStrategy() {
    }

    public static NumberInputStrategy getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new NumberInputStrategy();
        }
        return INSTANCE;
    }



    @Override
    protected InputReadResult doRead(Scanner scanner) {
        int result;
        try {
            result = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Sólo se aceptan numeros enteros");
            scanner.nextLine();
            return new InputReadResult().setReadResult(false).setInputeadRead(null);
        }
        return new InputReadResult().setReadResult(true).setInputeadRead(result);
    }

    @Override
    public boolean isValidInput(Object input) {
        return false;
    }
}
