package lesson_33._05_stream_terminal;

import javax.swing.text.html.Option;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("==============reduce 1==============");
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6);
        //     Optional<Integer> result = numbers.reduce((x, y)->x*y);
        //     System.out.println("Result = " + result.get());
        Optional<Integer> result = numbers.reduce((x, y) -> x + y);
        System.out.println("Result1 = " + result.get());

        System.out.println("================reduce 2========================");
        Stream<Integer> numbers1 = Stream.of(-4, -3, -2, 2, 3, 4);
        int identity = 1;  // если 0 - будет ноль
        Integer result1 = numbers1.reduce(identity, (x, y) -> x * y);
        System.out.println("result1 = " + result1);

        System.out.println("================reduce 3========================");
        List<PricedCat> cats = List.of(
                new PricedCat("Cat1", 5, 500),
                new PricedCat("Cat2", 3, 400),
                new PricedCat("Cat3", 3, 600),
                new PricedCat("Cat4", 1, 800),
                new PricedCat("Cat5", 4, 650)
        );

        // находим котов меньше 3 лет  x - результат у - кот
        int amount = cats.stream()
                .reduce(0,   // 1элемент - начальное значение т.е. сумма
                        (x, y) -> {  // 2 элемент - x=0, y=первый кот
                            if (y.getAge() < 3) {  // условие
                                return x + y.getPrice();
                            } else {
                                return x;
                            }
                        }, (x, y) -> x + y);  // 3 элемент считает х = накопление у = приходящий кот
        System.out.println("Amount = " + amount);

        int intejer = cats.stream()
                .filter(it -> it.getAge() > 3)
                .map(it -> it.getPrice())
                //  reduce(0, (x, y) -> x + y);
                .reduce(0, Integer::sum);
        System.out.println("Amount = " + amount);


        System.out.println("=======================================");
        cats.stream()
                .filter(it -> it.getAge() < 3)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("==========SET===============");
        cats.stream()
                .filter(it -> it.getAge() <= 3)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("==========MAP==============");
        cats.stream()
                .collect(Collectors.toMap(k -> k.getName(), v -> v))
                //к и v - это один и тот же кот
                .forEach((k, v) -> System.out.println(k + " " + v));

        System.out.println("========================");
        LinkedList<PricedCat> collect = cats.stream()
                .collect(Collectors.toCollection(LinkedList::new));


    }
// Вложенный класс
    private static class PricedCat {
        private String name;
        private int age;
        private int price;

        public PricedCat(String name, int age, int price) {
            this.name = name;
            this.age = age;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PricedCat pricedCat = (PricedCat) o;
            return age == pricedCat.age;
        }

        @Override
        public int hashCode() {
            return Objects.hash(age);
        }

        @Override
        public String toString() {
            return "PricedCat{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", price=" + price +
                    '}';
        }
    }
}
