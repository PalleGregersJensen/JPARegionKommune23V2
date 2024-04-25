package com.example.jparegionkommune23v2.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Dagens første tests")
public class SimpleTest {

    @Test
    void test() {
        if (3 > 4) {
            fail("det går ikke");
        }
    }


    @Test
    void test2(){
        assertEquals("ABC", "ABC", "ABC");
    }


    @Test
    void testArr2(){
        int[] numbers = {12, 3, 4, 1};
        int[] expected= {1, 3, 4, 12};
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers, "Sortering af fire tal");
    }



    //Test flere datasæt på metoderne
    @DisplayName("Bruger fanzy parameter test")
    @ParameterizedTest
    @MethodSource("sortnumbersArguments")
    void testArr(int[] numbers, int[] expected){
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers, "Sortering af fire tal");
    }

    //Metode, der bruges i ovenstående test
    private static Stream<Arguments> sortnumbersArguments2() {
        return Stream.of(
                Arguments.of(IntStream.of(1,2,3).toArray(), IntStream.of(1,2,3).toArray()),
                Arguments.of(IntStream.of(1,2,3).toArray(), IntStream.of(1,2,3).toArray()),
                Arguments.of(IntStream.of(1,2,3).toArray(), IntStream.of(1,2,3).toArray())
        );
    }


    //Alternativ til ovenstående metode. Tester samme ting
    private static Stream<Arguments> sortnumbersArguments() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3}, IntStream.of(1,2,3).toArray()),
                Arguments.of(new int[]{1,2,3}, IntStream.of(1,2,3).toArray()));
    }
}
