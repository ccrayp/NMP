import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Math.*;

public class Tangent {
    public static void menu() {
        Double leftBorder = 0.0, rightBorder = 0.0, accuracy = 0.0;
        int choice = 0;
        Scanner in = new Scanner(System.in);
        while (choice != 3) {
            System.out.print("\n1. x^3 + 0.2x^2 + 0.5x - 1.2\n2. 3x - cos(x) - 1\n3. Выход\n>> ");
            choice = in.nextInt();

            if (choice == 1 || choice == 2) {
                System.out.print("\nВведите границы a, b и точность e: ");
                leftBorder = in.nextDouble();
                rightBorder = in.nextDouble();
                accuracy = in.nextDouble();
            }

            switch (choice) {
                case 1: {
                    Double root = Tangent.findRootFirst(leftBorder, rightBorder, accuracy);
                    System.out.println("\nКорень: " + root + "\nЗначение функции в этой точке: " + Tangent.functionFirst(root));
                }
                break;
                case 2: {
                    Double root = Tangent.findRootSecond(leftBorder, rightBorder, accuracy);
                    System.out.println("\nКорень: " + root + "\nЗначение функции в этой точке: " + Tangent.functionSecond(root));
                }
                break;
            }
        }
        in.close();
    }

    public static Double functionFirst(Double x) {
        return pow(x, 3) + 0.2 * pow(x, 2) + 0.5 * x - 1.2;
    }

    private static Double functionFirstDerivativeFirst(Double x) {
        return 3 * pow(x, 2) + 0.4 * x + 0.5;
    }

    private static Double functionFirstDerivativeSecond(Double x) {
        return 6 * x + 0.4;
    }

    public static Double findRootFirst(Double leftBorder, Double rightBorder, Double accuracy) {
        Double x = 0.0;
        if (functionFirst(leftBorder) * functionFirstDerivativeSecond(leftBorder) > leftBorder)
            x = leftBorder;
        else
            x = rightBorder;

        double m = min(abs(functionFirst(leftBorder)), abs(functionFirst(rightBorder)));

        ArrayList<ArrayList<Double>> table = new ArrayList<>();

        Integer i = 0;
        while (abs(functionFirst(x)) / m > accuracy) {
            x = x - functionFirst(x) / functionFirstDerivativeFirst(x);

            ArrayList<Double> row = new ArrayList<>();
            row.add(i.doubleValue()); i++;
            row.add(x);
            row.add(functionFirst(x));
            row.add(functionFirstDerivativeFirst(x));
            row.add(abs(functionFirst(x)) / m);

            table.add(row);
        }

        GUITable.drawTable(table, new String[]{"i", "x", "f(x)", "f'(x)", "|f(x)| / m"});
        return x;
    }

    public static Double functionSecond(Double x) {
        return 3*x - cos(x) - 1;
    }

    private static Double functionSecondDerivativeFirst(Double x) {
        return 3 + sin(x);
    }

    private static Double functionSecondDerivativeSecond(Double x) {
        return cos(x);
    }

    public static Double findRootSecond(Double leftBorder, Double rightBorder, Double accuracy) {
        Double x = 0.0;
        if (functionSecond(leftBorder) * functionSecondDerivativeSecond(leftBorder) > leftBorder)
            x = leftBorder;
        else
            x = rightBorder;

        double m = min(abs(functionSecond(leftBorder)), abs(functionSecond(rightBorder)));

        ArrayList<ArrayList<Double>> table = new ArrayList<>();

        Integer i = 0;
        while (abs(functionSecond(x)) / m > accuracy) {
            x = x - functionSecond(x) / functionSecondDerivativeFirst(x);

            ArrayList<Double> row = new ArrayList<>();
            row.add(i.doubleValue()); i++;
            row.add(x);
            row.add(functionSecond(x));
            row.add(functionSecondDerivativeFirst(x));
            row.add(abs(functionSecond(x)) / m);
            table.add(row);
        }

        GUITable.drawTable(table, new String[]{"i", "x", "f(x)", "f'(x)", "|f(x)| / m"});
        return x;
    }
}