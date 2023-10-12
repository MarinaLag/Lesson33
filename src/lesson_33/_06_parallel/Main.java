package lesson_33._06_parallel;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of(
                "Tom", "Bob", "Tim", "Kate", "Sam", "Vasia"
        );

        list.stream()
                .filter(it -> it.length() == 3)
                .forEach(it -> System.out.print(it + " "));

        System.out.println();
        list.parallelStream() // по времени - хорошо, если ВАЖЕН порядок следования - плохо
                .filter(it -> it.length() == 3)
                .forEach(it -> System.out.print(it + " "));


    }
}
