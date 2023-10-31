package lesson_38._03_standart_compose;

import lesson_38._02_standart.Child;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static final String PATH_TO_OUTPUT = "src/lesson_38/_resources/output.file";

    public static void main(String[] args) {
        StandardCat vasya = new StandardCat("Vasya", new StandardBox(List.of("Ball", "Mouse")));

        try (FileOutputStream os = new FileOutputStream(PATH_TO_OUTPUT);
             ObjectOutputStream oos = new ObjectOutputStream(os);
             FileInputStream is = new FileInputStream(PATH_TO_OUTPUT);
             ObjectInputStream ois = new ObjectInputStream(is)) {
            //   ObjectInputStream input= new ObjectInputStream(new FileInputStream(PATH_TO_OUTPUT))

            oos.writeObject(vasya); // наш объект закидываем в файл
            StandardCat.staticField = "New Value";// просто изменили значение
            // чтобы убедиться что static поле не сериализуется

            StandardCat catFromField = (StandardCat) ois.readObject();
            // создаем нового кота из файла

            System.out.println(catFromField);
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }



    }
}
