package io;

import java.util.Arrays;
import java.util.List;

public class Iterators
{
    public static void main( String[] args )
    {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);

        System.out.println( "----- EXTERNAL ITERATORS: FOR" );

        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        System.out.println( "----- EXTERNAL ITERATORS: FOREACH" );

        for (int current :numbers) {
            System.out.println(current);
        }

        System.out.println( "----- INTERNAL ITERATOR" );

        numbers.forEach(n -> System.out.println(n));

        System.out.println( "----- INTERNAL ITERATOR: WITH METHOD REFERENCE" );

        numbers.forEach(System.out::println);
    }
}
