package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.example.Triangle.calculateTriangleSquare;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;


class TriangleTests {
    @Test
    @DisplayName("Проверка площади треугольника")
    void squareCalcTest() throws Exception {
        double result = calculateTriangleSquare(3, 4, 5);
        Assertions.assertEquals(6.0, result);

    }

    @Test
    @DisplayName("Сторона не может быть отрицательной")
    void negativeSide() {
        assertThatExceptionOfType(Exception.class).isThrownBy(() -> calculateTriangleSquare(-2, 4, 5));
    }

    @Test
    @DisplayName("Сторона не может = 0")
    void zeroSide() {
        assertThatExceptionOfType(Exception.class).isThrownBy(() -> calculateTriangleSquare(0, 2, 2));
    }

    @Test
    @DisplayName("Такого треугольника не существует")
    void triangle() {
        assertThatExceptionOfType(Exception.class).isThrownBy(() -> calculateTriangleSquare(1, 2, 3));
    }
}
