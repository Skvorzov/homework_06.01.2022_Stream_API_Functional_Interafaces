package com.skvortsov;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.function.*;

public class FunctionalInterface {
    public static void main(String[] args) {

        // Является ли число простым
        Predicate<Integer> isPrimeNumber = x -> {
            for (int i = 2; i < x; i++) {
                if (x % i == 0) {
                    return false;
                }
            }
            return true;
        };
        System.out.println(isPrimeNumber.test(77)); // 77 непростое число - результать false
        System.out.println(isPrimeNumber.test(11)); // 11 простое число - результат true

        // Сгенерировать случайное число от 0 до заданного
        Consumer<Integer> printRandomNumber = x -> System.out.println((int) (Math.random() * x));
        printRandomNumber.accept(10);

        // Определить день недели
        Supplier<DayOfWeek> getDayOfWeek = () -> {
            LocalDate date = LocalDate.now();
            return date.getDayOfWeek();
        };
        System.out.println(getDayOfWeek.get());

        // Округлить число по правилам математики
        Function<Double, Long> convertDoubleToLong = x -> {
            if (x >= 0) {
                if ((x - x.longValue()) < 0.5) {
                    return x.longValue();
                } else {
                    return x.longValue() + 1;
                }
            } else {
                if ((x - x.longValue()) > -0.5) {
                    return x.longValue();
                } else {
                    return x.longValue() - 1;
                }
            }
        };
        System.out.println(convertDoubleToLong.apply(2.3)); // 2.3 округляем до 2
        System.out.println(convertDoubleToLong.apply(2.5)); // 2.5 округляем до 3
        System.out.println(convertDoubleToLong.apply(-1.0)); // -1.0 округляем до -1
        System.out.println(convertDoubleToLong.apply(-1.6)); // -1.6 округляем до -2

        // Вычислить число Фибоначчи
        UnaryOperator<Integer> getFibonacciNumber = x -> {
            int[] array = new int[x + 2];
            array[0] = 0;
            array[1] = 1;
            for (int i = 2; i < array.length; i++) {
                array[i] = array[i - 1] + array[i - 2];
            }
            return array[x - 1];
        };                                                  // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233
        System.out.println(getFibonacciNumber.apply(1)); // первый элемент в последовательности Фибоначчи - 0
        System.out.println(getFibonacciNumber.apply(2)); // второй элемент в последовательности Фибоначчи - 1
        System.out.println(getFibonacciNumber.apply(5)); // пятый элемент в последовательности Фибоначчи - 3
    }
}