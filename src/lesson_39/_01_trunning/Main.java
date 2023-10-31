package lesson_39._01_trunning;

import lesson_39._01_trunning.model.CatModel;

import static lesson_39._01_trunning.utils.CatUtils.*;

import java.util.List;

import static lesson_39._01_trunning.utils.CatUtils.extractFromFile;

public class Main {
    public static void main(String[] args) {
        List<CatModel> catModels = extractFromFile();
        printCats(catModels);
    }
}
