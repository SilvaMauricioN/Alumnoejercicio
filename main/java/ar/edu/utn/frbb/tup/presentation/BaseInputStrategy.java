package ar.edu.utn.frbb.tup.presentation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public abstract class BaseInputStrategy implements InputStrategy {

    protected abstract InputReadResult doRead(Scanner scanner);

    @Override
    public Object acceptInput(Scanner scanner) {
        InputReadResult input = doRead(scanner);
        while (!input.getReadResult()) {
            input = doRead(scanner);
        }
        return input.getInputeadRead();
    }

    @Override
    public boolean isValidInput(Object input) {
        return true;
    }

    private final static List<String> numericTypes = Arrays.asList(new String[]{"Integer", "int", "Long", "long", "Float", "float"});
    public static InputStrategy getStrategy(String inputType) {
        if ("String".equals(inputType)) {
            return TextInputStrategy.getInstance();
        } else if (numericTypes.contains(inputType)){
            return NumberInputStrategy.getInstance();
        }
        return TextInputStrategy.getInstance();
    }

    public class InputReadResult {
        private Boolean readResult;
        private Object inputeadRead;

        public Boolean getReadResult() {
            return readResult;
        }

        public InputReadResult setReadResult(Boolean readResult) {
            this.readResult = readResult;
            return this;
        }

        public Object getInputeadRead() {
            return inputeadRead;
        }

        public InputReadResult setInputeadRead(Object inputeadRead) {
            this.inputeadRead = inputeadRead;
            return this;
        }
    }
}
