package lesson_39._01_training;

import lesson_39._01_training.model.CatModel;

import static lesson_39._01_training.utils.CatUtils.*;

import java.util.List;

import static lesson_39._01_training.utils.CatUtils.extractFromFile;

public class Main {
    public static void main(String[] args) {
        List<CatModel> catModels = extractFromFile();
        printCats(catModels);
    }
}
