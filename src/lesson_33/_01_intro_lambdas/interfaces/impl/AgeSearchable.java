package lesson_33._01_intro_lambdas.interfaces.impl;

import lesson_33._01_intro_lambdas.interfaces.Searchable;
import lesson_33._01_intro_lambdas.model.Cat;

public class AgeSearchable implements Searchable<Integer> {
    @Override
    public boolean test(Cat cat, Integer value) {

        return cat.getAge()==value;
    }
}
