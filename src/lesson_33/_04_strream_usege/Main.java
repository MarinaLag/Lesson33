package lesson_33._04_strream_usege;


import lesson_33._04_strream_usege.model.Chicken;
import lesson_33._04_strream_usege.model.ChickenComporator;
import lesson_33._04_strream_usege.model.Dog;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Dog> dogs = Arrays.asList(
                new Dog("Bob", 2),
                new Dog("Tuz", 7),
                new Dog("Rex", 5),
                new Dog("Put", 3)
        );

        Stream<Dog> dogStream = dogs.stream()
                .filter(dog -> dog.getAge() >= 3)
                .filter(dog -> dog.getName().length() >= 3);

        dogStream.forEach(System.out::println);

        System.out.println("========================");
        dogs.stream()
                .map(Dog::getName)
                .forEach(System.out::println);

        System.out.println("=========================");
        dogs.stream()
                .sorted()
                .forEach(System.out::println);


        List<Chicken> chickens = Arrays.asList(
                new Chicken("Grill", 2),
                new Chicken("Fried", 7),
                new Chicken("Boiled", 2),
                new Chicken("Grill", 2)
        );
        chickens.stream()
                .sorted(new ChickenComporator())
                .forEach(System.out::println);

        System.out.println("===================");
        Stream<String> dogsObj = dogs.stream().map(Dog::getName);
        Stream<String> chickenObj = chickens.stream().map(Chicken::getName);
        Stream.concat(dogsObj, chickenObj).forEach(System.out::println);

        System.out.println("=====================");
        chickens.stream().distinct()
                .forEach(System.out::println);

        System.out.println("=====================");
        dogs.stream()
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        List<String> sortedNames = names.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sortedNames); // prints ["Alice", "Bob", "Charlie", "David"]
    }
}
