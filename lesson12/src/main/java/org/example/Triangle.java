package org.example;

public class Triangle {
    public static double calculateTriangleSquare(int a, int b, int c) throws Exception {
        if (a <= 0 || b <= 0 | c <= 0) throw new Exception();
        if (a + b <= c || a + c <= b || b + c <= a)
            throw new Exception();
        double halfP = (a + b + c) / 2;
        return Math.sqrt(halfP * (halfP - a) * (halfP - b) * (halfP - c));
    }
}
