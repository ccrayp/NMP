import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Math.*;

public class Iteration {
    public static void menu() {
        Scanner in = new Scanner(System.in);
        Double initApproximation = 0.0, accuracy = 0.0;

        System.out.print("\nВведите точку начального приближения и точность e: ");
        initApproximation = in.nextDouble();
        accuracy = in.nextDouble();

        Double root = findRoot(initApproximation, accuracy);
        System.out.println("\nКорень: " + root + "\nЗначение функции в этой точке: " + function(root));
    }

    public static Double findRoot(Double x1, Double accuracy) {
        Double x2 = phi(x1);

        Integer i = 0;
        while (Math.abs(x2 - x1) > accuracy) {
            x1 = x2;
            x2 = phi(x1);
        }

        return x2;
    }

    public static Double phi(Double x) {
        return -2 * sqrt(-sin(x));
    }

    public static Double function(Double x) {
        return pow(x, 2) + 4 * sin(x);
    }
}
