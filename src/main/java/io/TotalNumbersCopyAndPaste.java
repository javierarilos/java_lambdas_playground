package io;

import java.util.Arrays;
import java.util.List;

public class TotalNumbersCopyAndPaste {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);

        System.out.printf("Total sum: %d %n", totalSum(numbers));
        System.out.printf("Total sum even nrs: %d %n", totalSumEven(numbers));
        System.out.printf("Total sum odd nrs: %d %n", totalSumOdd(numbers));
    }

    private static int totalSum(List<Integer> numbers) {
        int total = 0;
        for (int nr : numbers) {
            total += nr;
        }
        return total;
    }

    private static int totalSumEven(List<Integer> numbers) {
        int total = 0;
        for (int nr : numbers) {
            if (nr % 2 == 0) {
                total += nr;
            }
        }
        return total;
    }

    private static int totalSumOdd(List<Integer> numbers) {
        int total = 0;
        for (int nr : numbers) {
            if (nr % 2 != 0) {
                total += nr;
            }
        }
        return total;
    }

}
