package lesson_33._01_intro_lambdas;

import lesson_33._01_intro_lambdas.interfaces.Searchable;
import lesson_33._01_intro_lambdas.interfaces.impl.AgeSearchable;
import lesson_33._01_intro_lambdas.interfaces.impl.BreedSearchable;
import lesson_33._01_intro_lambdas.model.Breed;
import lesson_33._01_intro_lambdas.model.Cat;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Cat> cats = Arrays.asList(
                new Cat("Cat1", 2, Breed.SIBERIAN),
                new Cat("Cat2", 1, Breed.SIAM),
                new Cat("Cat3", 3, Breed.GARBAGE),
                new Cat("Cat4", 2, Breed.SIBERIAN),
                new Cat("Cat5", 1, Breed.SIAM),
                new Cat("Cat6", 1, Breed.SIBERIAN)
        );
//        System.out.println(getByBreed(cats,Breed.SIBERIAN));
//        System.out.println(getByAge(cats,2));

//        System.out.println(getByCondition(cats,new BreedSearchable(),Breed.SIBERIAN));
//        System.out.println(getByCondition(cats,new AgeSearchable(),2));

    /*    System.out.println(getByCondition(cats, new Searchable<Breed>() {
            @Override
            public boolean test(Cat cat, Breed value) {
                return cat.getBreed().equals(value);
            }
        },Breed.SIBERIAN));

        System.out.println(getByCondition(cats, new Searchable<Integer>() {
            @Override
            public boolean test(Cat cat, Integer value) {
                return cat.getAge()==value;
            }
        },2));*/

        System.out.println(getByCondition(cats,(cat,value)->cat.getBreed().equals(value),Breed.SIBERIAN));
        System.out.println(getByCondition(cats,(cat,value)->cat.getAge()==value,2));

    }

    private static int getByBreed(List<Cat> cats, Breed breed) {
        int result = 0;
        for (Cat cat : cats) {
            if (cat.getBreed().equals(breed)) {
                result++;
            }
        }
        return result;
    }

    private static int getByAge(List<Cat> cats, int age) {
        int resuit = 0;
        for (Cat cat : cats) {
            if (cat.getAge() == age) {
                resuit++;
            }
        }
        return resuit;
    }

    private static <T> int getByCondition(List<Cat> cats, Searchable<T> function, T value){
        int result=0;
        for (Cat cat : cats) {
            if (function.test(cat,value)){
                result++;
            }
        }
        return result;
    }

}
