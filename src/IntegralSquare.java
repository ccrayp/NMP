import java.util.Scanner;

public class IntegralSquare {
    private static double a = 0;
    private static double b = 0;
    private static double k = 0;
    private static double n = 0;
    private static double h = 0.0;

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Метод прямоугольников");
//        System.out.printf("x^k:\n");
//        System.out.printf("a: ");
//        a = sc.nextDouble();
//        System.out.printf("b: ");
//        b = sc.nextDouble();
//        System.out.printf("n: ");
//        n = sc.nextDouble();
//        System.out.printf("k: ");
//        k = sc.nextDouble();
//        h = (b - a) / n;
//        System.out.println("Приближенное значение: " + calc1() +"\nРеальное значение: " + (1/(k+1)) + "\nРазница: " + (Math.abs(((1/(k+1)) - calc1()))));

        System.out.printf("sin(x):\n");
        System.out.printf("a: ");
        a = sc.nextDouble();
        System.out.printf("b: ");
        b = sc.nextDouble();
        System.out.printf("n: ");
        n = sc.nextDouble();
        h = (b - a) / n;
        System.out.println("Приближенное значение: " + calc2() +"\nРеальное значение: " + func() + "\nРазница: " + Math.abs(func() - calc2()));
    }

    private static double func() {
        return Math.cos(a) - Math.cos(b);
    }

    private static double calc1() {
        double res = 0.0, x = 0.0, c = 0.0;
        for(int i = 1; i <= n; i++) {
            x = h*i + a;
            c = x - h/2;
            res += func1(c);
        }
        return res * h;
    }

    private static double calc2() {
        double res = 0.0, x = 0.0, c = 0.0;
        for(int i = 1; i <= n; i++) {
            x = h*i + a;
            c = x - h/2;
            res += func2(c);
        }
        return res * h;
    }

    private static double func1(double x) {
        return Math.pow(x, k);
    }

    private static double func2(double x) {
        return Math.sin(x);
    }
}
