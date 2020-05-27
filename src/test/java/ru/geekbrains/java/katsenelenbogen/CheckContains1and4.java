package ru.geekbrains.java.katsenelenbogen;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckContains1and4 {
    @DisplayName("Проверка вывода элементов массива после 4")


    private static Stream<Arguments> arraysProvider() {
        return Stream.of(
                Arguments.of(new int[] {1,1,1,1,1,1}, false),
                Arguments.of(new int[] {1,1,1,1,1,4}, true),
                Arguments.of(new int[] {4,1,1,1,1,1}, true),
                Arguments.of(new int[] {4,4,4,4,4,4}, false),
                Arguments.of(new int[] {2,2,2,2,2,2}, false),
                Arguments.of(new int[] {1,1,1,4,1,1}, true)
        );
    }

    @DisplayName("Проверка вывода элементов массива после 4")
    @ParameterizedTest(name = "{index}й Массив: {0}, результат: {1}")
    @MethodSource("arraysProvider")
    public void arraysTest(int[] array, boolean result) {
        assertEquals(Array.checkArrayForNumbers(array), result);

    }
}
