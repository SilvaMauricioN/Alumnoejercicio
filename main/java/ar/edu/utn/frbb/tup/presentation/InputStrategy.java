package ar.edu.utn.frbb.tup.presentation;

import java.util.Scanner;

public interface InputStrategy {

    Object acceptInput(Scanner scanner);

    boolean isValidInput(Object input);



}
