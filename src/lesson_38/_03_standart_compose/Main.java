package lesson_38._03_standart_compose;

import lesson_38._02_standart.Child;

import java.io.*;
import java.util.List;

public class Main {
    public static final String PATH_TO_OUTPUT = "src/lesson_38/_resources/output.file";

    public static void main(String[] args) {
        StandardCat vasya = new StandardCat("Vasya", new StandardBox(List.of("Ball", "Mouse")));

        try (FileOutputStream os = new FileOutputStream(PATH_TO_OUTPUT);
             ObjectOutputStream oos = new ObjectOutputStream(os);
             FileInputStream is = new FileInputStream(PATH_TO_OUTPUT);
             ObjectInputStream ois = new ObjectInputStream(is)) {

            oos.writeObject(vasya);
            StandardCat.staticField = "New Value";

            StandardCat catFromField = (StandardCat) ois.readObject();
            System.out.println(catFromField);
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }

    }
}
