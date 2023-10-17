package lesson_33._02_intro_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5);
        //  System.out.println(getPositiveQuantity(numbers));
        System.out.println(
                numbers.stream()
                        .filter(it -> it > 0)
                        .count()
        );

    }

    private static int getPositiveQuantity(List<Integer> numbers) {
        int counter = 0;
        for (Integer number : numbers) {
            if (number > 0) {
                counter++;
            }
        }
        return counter;
    }
}
