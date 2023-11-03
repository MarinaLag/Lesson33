package lesson_39._01_training.utils;

import lesson_39._01_training.exception.TxtLineException;
import lesson_39._01_training.model.CatModel;

import java.util.Arrays;

public class CatFactory {
    public static final String DELIMITER = ",";

    public static CatModel getInstance(String catString) throws TxtLineException {
        String[] split = catString.split(DELIMITER);//получаем массив строк
        try {
            validateArrayLength(split.length);
            validateStringAsNumber(split[0], split[2]);// проверка что 1 и 2 это число
            int id = validateIdOrAge(Integer.parseInt(split[0]));
            String name = validateName(split[1]);
            int age = validateIdOrAge(Integer.parseInt(split[2]));
            return new CatModel(id,name,age);
        } catch (IllegalStateException e) {
            throw new TxtLineException(catString, e);
        }
    }
    // проверка на длинну массива
    private static void validateArrayLength(int length) {
        if (length != 3) {// если длинна массива не равно 3
            throw new IllegalStateException("Wrong line format"); // если нет - пробрассываем исключение
        }
    }
// проверка на числа
    private static void validateStringAsNumber(String... strings) {//,,, передаем много строк
        try {
            // передает нам массив
            Arrays.stream(strings).forEach(Integer::parseInt);
        } catch (NumberFormatException e) {
            throw new IllegalStateException("Id or age is not a number");
        }
    }
// проверка на пустое имя
    private static String validateName(String str) {
        if (str.isEmpty()) {
            throw new IllegalStateException("Name is empty");
        }
        return str;
    }
// проверка что число положительное
    private static int validateIdOrAge(int number) {
        if(number<0){
            throw new IllegalStateException("Id or Age is negative");
        }
        return number;
    }
}
