import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import static java.lang.Math.*;

public class Chord {
    public static void menu() {
        Scanner in = new Scanner(System.in);
        Double leftBorder = 0.0, rightBorder = 0.0, accuracy = 0.0;

        System.out.print("\nВведите границы a, b и точность e: ");
        leftBorder = in.nextDouble();
        rightBorder = in.nextDouble();
        accuracy = in.nextDouble();

        Double root = findRoot(leftBorder, rightBorder, accuracy);
        System.out.println("\nКорень: " + root + "\nЗначение функции в этой точке: " + function(root));
    }

    public static Double findRoot(Double leftBorder, Double rightBorder, Double accuracy) {
        Double x = 0.0;

        if (function(leftBorder) * functionDerivativeSecond(leftBorder) > 0.0)
            x = rightBorder;
        else
            x = leftBorder;

        if (Objects.equals(x, rightBorder)) {
            rightBorder = leftBorder;
            leftBorder = x;
        }

        double m = min(abs(function(leftBorder)), abs(function(rightBorder)));

        ArrayList<ArrayList<Double>> table = new ArrayList<>();

        Integer i = 0;
        while (abs(function(x)) / m > accuracy) {
            x = x - function(x) / (function(x) - function(rightBorder)) * (x - rightBorder);
            ArrayList<Double> row = new ArrayList<>();

            row.add(i.doubleValue()); i++;
            row.add(x);
            row.add(function(x));
            row.add(abs(function(x))/m);

            table.add(row);
        }

        GUITable.drawTable(table, new String[]{"i", "x", "f(x)", "|f(x)|/m"});
        return x;
    }

    public static Double function(Double x) {
        return sqrt(1 + x) * log(x) - 2;
    }

    private static Double functionDerivativeFirst(Double x) {
        return (log(x) / (2 * sqrt(1 + x))) + (sqrt(1 + x) / x);
    }

    private static Double functionDerivativeSecond(Double x) {
        return ((-1*pow(x, 2))*log(x)-4-4*x)/(4*pow(x, 2)*sqrt(1+x)*(1+x));
    }
}