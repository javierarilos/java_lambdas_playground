package io;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class TotalNumbersStream {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);

        System.out.printf("Total sum higher order function: %d %n", totalSum(numbers, nr -> true));
        System.out.printf("Total sum Even higher order function: %d %n", totalSum(numbers, nr -> nr % 2 == 0));
        System.out.printf("Total sum Odd higher order function: %d %n", totalSum(numbers, nr -> nr % 2 != 0));
    }

    private static int totalSum(List<Integer> numbers, Predicate<Integer> filterPredicate) {
        return numbers.stream()
                .filter(filterPredicate)
                .mapToInt(nr -> nr)
                .sum();
    }
}
