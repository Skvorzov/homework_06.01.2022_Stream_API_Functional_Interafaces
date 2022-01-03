package com.skvortsov;

import java.util.List;

public class Stream {

    public static void main(String[] args) {
        List<People> peopleList = List.of(new People("Вася", 16, Sex.MAN),
                new People("Петя", 23, Sex.MAN),
                new People("Елена", 42, Sex.WOMEN),
                new People("Иван", 69, Sex.MAN));

        // Военнообязанные мужчины
        peopleList.stream().filter(people -> people.getAge() >= 18 && people.getAge() <= 27).forEach(System.out::println);
        // Средний возраст мужчин
        System.out.println(peopleList.stream().filter(people -> people.getSex().equals(Sex.MAN)).mapToInt(x -> x.getAge()).average().getAsDouble());
        // Работоспособные люди
        peopleList.stream().filter(people -> (people.getSex().equals(Sex.MAN) &&
                people.getAge() >= 18 && people.getAge() < 60) ||
                (people.getSex().equals(Sex.WOMEN) && people.getAge() >= 18 && people.getAge() < 55)).forEach(System.out::println);
    }
}