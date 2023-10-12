package lesson_33._01_intro_lambdas.interfaces.impl;

import lesson_33._01_intro_lambdas.interfaces.Searchable;
import lesson_33._01_intro_lambdas.model.Breed;
import lesson_33._01_intro_lambdas.model.Cat;

public class BreedSearchable implements Searchable<Breed> {
    @Override
    public boolean test(Cat cat, Breed value) {
        return cat.getBreed().equals(value);
    }
}
