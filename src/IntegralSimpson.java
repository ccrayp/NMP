import java.util.Scanner;

public class IntegralSimpson {
    private static double a;
    private static double b;
    private static double k;
    private static int n; // Количество подынтервалов должно быть целым
    private static double h;

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nМетод Симпсона");
//        // Интегрирование функции x^k
//        System.out.println("Интегрирование функции x^k:");
//        System.out.print("a: ");
//        a = sc.nextDouble();
//        System.out.print("b: ");
//        b = sc.nextDouble();
//        System.out.print("m: ");
//        int m = sc.nextInt();
//        n = m * 2; // Увеличиваем n, умножая m на 2
//        if (n % 2 != 0) {
//            n++; // Увеличиваем n, чтобы оно было четным
//        }
//        System.out.print("k: ");
//        k = sc.nextDouble();
//        h = (b - a) / n;
//
//        double approxValue1 = calcPowerFunction();
//        double realValue1 = 1 / (k + 1);
//        System.out.println("Приближенное значение: " + approxValue1);
//        System.out.println("Реальное значение: " + realValue1);
//        System.out.println("Разница: " + Math.abs(realValue1 - approxValue1));
//        System.out.println();

        // Интегрирование функции sin(x)
        System.out.println("sin(x):");
        System.out.print("a: ");
        a = sc.nextDouble();
        System.out.print("b: ");
        b = sc.nextDouble();
        System.out.print("m: ");
        int m = sc.nextInt();
        n = m * 2; // Увеличиваем n, умножая m на 2
        if (n % 2 != 0) {
            n++; // Увеличиваем n, чтобы оно было четным
        }
        h = (b - a) / n;

        double approxValue2 = calcSinFunction();
        double realValue2 = funcSin();
        System.out.println("Приближенное значение: " + approxValue2);
        System.out.println("Реальное значение: " + realValue2);
        System.out.println("Разница: " + Math.abs(realValue2 - approxValue2));
    }

    private static double funcSin() {
        return Math.cos(a) - Math.cos(b);
    }

    private static double calcPowerFunction() {
        double res = 0.0;
        for (int i = 0; i <= n; i++) {
            double x = a + i * h;
            if (i == 0 || i == n) {
                res += funcPower(x); // Первый и последний элемент
            } else if (i % 2 == 0) {
                res += 2 * funcPower(x); // Четные индексы
            } else {
                res += 4 * funcPower(x); // Нечетные индексы
            }
        }
        return res * (h / 3); // Умножаем на h/3
    }

    private static double calcSinFunction() {
        double res = 0.0;
        for (int i = 0; i <= n; i++) {
            double x = a + i * h;
            if (i == 0 || i == n) {
                res += funcSin(x); // Первый и последний элемент
            } else if (i % 2 == 0) {
                res += 2 * funcSin(x); // Четные индексы
            } else {
                res += 4 * funcSin(x); // Нечетные индексы
            }
        }
        return res * (h / 3); // Умножаем на h/3
    }

    private static double funcPower(double x) {
        return Math.pow(x, k);
    }

    private static double funcSin(double x) {
        return Math.sin(x);
    }
}
