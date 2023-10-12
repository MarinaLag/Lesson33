package lesson_33._01_intro_lambdas.interfaces;


import lesson_33._01_intro_lambdas.model.Cat;
@FunctionalInterface
public interface Searchable<T> {
    boolean test(Cat cat, T value);
}
