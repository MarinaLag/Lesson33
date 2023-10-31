package lesson_39._01_trunning.utils;

import lesson_39._01_trunning.exception.TxtLineException;
import lesson_39._01_trunning.model.CatModel;

import java.io.IOException;
import java.util.Arrays;

public class CatFactory {
    public static final String DELIMITER = ",";

    public static CatModel getInstance(String catString) throws TxtLineException {
        String[] split = catString.split(DELIMITER);
        try {
            validateArrayLength(split.length);
            validateStringAsNumber(split[0], split[2]);
            int id = validateIdOrAge(Integer.parseInt(split[0]));
            String name = validateName(split[1]);
            int age = validateIdOrAge(Integer.parseInt(split[2]));
            return new CatModel(id,name,age);
        } catch (IllegalStateException e) {
            throw new TxtLineException(catString, e);
        }
    }

    private static void validateArrayLength(int length) {
        if (length != 3) {
            throw new IllegalStateException("Wrong line format");
        }
    }

    private static void validateStringAsNumber(String... strings) {
        try {
            Arrays.stream(strings).forEach(Integer::parseInt);
        } catch (NumberFormatException e) {
            throw new IllegalStateException("Id or age is not a number");
        }
    }

    private static String validateName(String str) {
        if (str.isEmpty()) {
            throw new IllegalStateException("Name is empty");
        }
        return str;
    }

    private static int validateIdOrAge(int number) {
        if(number<0){
            throw new IllegalStateException("Id or Age is negative");
        }
        return number;
    }
}
