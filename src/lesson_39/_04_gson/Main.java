package lesson_39._04_gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lesson_39._01_training.model.CatModel;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class Main {
    private static final Gson gson = new Gson();
    private static final Type TYPE = new TypeToken<List<CatModel>>(){}.getType();

    public static final String OUTPUT_FILE = "src/lesson_39/_04_gson/resources/output.json";

    public static void main(String[] args) {
        List<CatModel> cats = List.of(
                new CatModel(1,"Vasya",2),
                new CatModel(2,"Tom",1),
                new CatModel(3,"Masha",3),
                new CatModel(4,"Murka",2)
        );

        // превращаем нашу коллекцию в строку
        String listAsString = gson.toJson(cats);

        try {
            Writer writer = new FileWriter(OUTPUT_FILE);
            writer.write(listAsString); //запишет
            writer.flush(); // запустить
            System.out.println("Записал");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Считал из файла");
        try {
            List<CatModel> fromFile = gson.fromJson(new FileReader(OUTPUT_FILE),TYPE); //прочитает строку
            fromFile.forEach(System.out::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }
}
