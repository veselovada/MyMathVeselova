package Math;


public class MyMathVeselova {
    private static final double PI = 3.141592653589793;
    public static final double E = 2.718281828459045;

    public static void main(String[] args) {

        System.out.println("Минимум из 5 и 10: " + min(5, 10));
        System.out.println("Минимум из 3.5 и 2.1: " + min(3.5, 2.1));
        System.out.println("Минимум из '20' и '15': " + min("20", "15"));
        //Арксинус/Арккосинус...
        System.out.println("arcsin(0.5): " + arcsin(0.5));
        System.out.println("arccos(0.5): " + arccos(0.5));
        System.out.println("arctan(1): " + arctan(1));
        System.out.println("2^3: " + power(2, 3));
        System.out.println("Площадь окружности с радиусом 5: " + circleArea(5));
        System.out.println("Длина окружности с радиусом 5: " + circleCircumference(5));
        // возращеник числа
        System.out.println(getNumberType("123"));          // int
        System.out.println(getNumberType("12345678901"));  // long
        System.out.println(getNumberType("123.45"));       // float
        System.out.println(getNumberType("123.456789"));
    }





    public static <T extends Comparable<T>> T min(T a, T b) {
        return (a == null) ? b : (b == null) ? a : (a.compareTo(b) < 0 ? a : b);
    }

    public static double arcsin(double x) { //Арксинус
        if (x < -1 || x > 1) {
            throw new IllegalArgumentException("Аргумент должен быть в диапазоне [-1, 1]");
        }
        double result = 0;
        double term = x;
        int n = 1;
        return result;
    }


    public static double arccos(double x) { //Аркосинус
        return PI / 2 - arcsin(x);
    }

    // Арктангенс
    public static double arctan(double x) {
        double result = 0;
        double term = x;
        int n = 0;

        while (Math.abs(term) > 1e-10) {
            if (n % 2 == 0) {
                result += term;
            } else {
                result -= term;
            }
            term *= x * x;
            term /= (2 * n + 2) * (2 * n + 3);
            n++;
        }
        return result;
    }

    // возведение числа в степень
    public static double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        double result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    // вычисление площади окружности
    public static double circleArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Радиус не может быть отрицательным");
        }
        return PI * power(radius, 2);
    }

    // вычисление длины окружности
    public static double circleCircumference(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Радиус не может быть отрицательным");
        }
        return 2 * PI * radius;
    }
    public static String getNumberType(String input) {
        try {

            Integer.parseInt(input);
            return "int";
        } catch (NumberFormatException e) {
            try {

                Long.parseLong(input);
                return "long";
            } catch (NumberFormatException e2) {
                try {
                    Float.parseFloat(input);
                    return "float";
                } catch (NumberFormatException e3) {

                    return "double";
                }
            }
        }
    }
}
