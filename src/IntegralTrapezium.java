import java.util.Scanner;

public class IntegralTrapezium {
    private static double a = 0;
    private static double b = 0;
    private static double k = 0;
    private static int n = 0; // Изменено на int, так как n должно быть целым
    private static double h = 0.0;

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nМетод трапеций");
//        // Интегрирование x^k
//        System.out.printf("x^k:\n");
//        System.out.printf("a: ");
//        a = sc.nextDouble();
//        System.out.printf("b: ");
//        b = sc.nextDouble();
//        System.out.printf("n: ");
//        n = sc.nextInt(); // Изменено на nextInt
//        System.out.printf("k: ");
//        k = sc.nextDouble();
//
//        double trapezoidalResult1 = calc1();
//        double realValue1 = 1 / (k + 1);
//        System.out.println("Приближенное значение: " + trapezoidalResult1 +
//                "\nРеальное значение: " + realValue1 +
//                "\nРазница: " + Math.abs(realValue1 - trapezoidalResult1));

        // Интегрирование sin(x)
        System.out.printf("sin(x):\n");
        System.out.printf("a: ");
        a = sc.nextDouble();
        System.out.printf("b: ");
        b = sc.nextDouble();
        System.out.printf("n: ");
        n = sc.nextInt(); // Изменено на nextInt

        double trapezoidalResult2 = calc2();
        double realValue2 = func();
        System.out.println("Приближенное значение: " + trapezoidalResult2 +
                "\nРеальное значение: " + realValue2 +
                "\nРазница: " + Math.abs(realValue2 - trapezoidalResult2));
    }

    private static double func() {
        return Math.cos(a) - Math.cos(b);
    }

    private static double calc1() {
        double res = func1(a) + func1(b);
        h = (b - a) / n; // Пересчитываем h здесь
        res += (func1(a) + func1(b)) / 2; // Начальные значения
        double sigma = 0.0;
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sigma += func1(x);
        }
        res += 2*sigma;
        return h/2 * res;
    }

    private static double calc2() {
        double res = func2(a) + func2(b);
        h = (b - a) / n; // Пересчитываем h здесь
        res += (func2(a) + func2(b)) / 2; // Начальные значения
        double sigma = 0.0;
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sigma += func2(x);
        }
        res += 2*sigma;
        return h/2 * res;
    }

    private static double func1(double x) {
        return Math.pow(x, k);
    }

    private static double func2(double x) {
        return Math.sin(x);
    }
}