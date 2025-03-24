import java.util.Scanner;

public class IterativeSolver {
    private final int N = 4;
    private double[][] A = {{-14.13, -3.82, 2.43, 3.20},
                            {1.91, -8.01, 4.28, 0.75},
                            {2.53, 4.15, -12.62, -1.03},
                            {0.18, -1.72, 1.86, -8.51}};
    private double[] B = {-24.78, 18.83, -1.90, 14.86};
//    private double[][] A = {{3, 1}, {1, 2}};
//    private double[] B = {4, 3};
    private double[] X1 = new double[N];
    private double[] X2 = new double[N];
    private double E = 0.000001;
    private double T;
    private Scanner scanner = new Scanner(System.in);

    public void menu() {
        T = calculateTeta(A);

        for (int i = 0; i < N; i++) {
            X2[i] = 0;
        }

        do {
            System.arraycopy(X2, 0, X1, 0, N);
            iterationStep(X1, X2);
        } while (calculateNorm(X1, X2) > E * (1 - T) / T);
        
        for (int i = 0; i < N; i++) {
            System.out.println("X(" + (i + 1) + ") = " + X2[i]);
        }

        //checkSolution();
    }

    private String print(double[] a) {
        String res = "";
        for(int i = 0; i < N; i++) {
            res += a[i] + " ";
        }
        res += "\n";
        return res;
    }

    private double calculateTeta(double[][] matrix) {
        double t = 0;
        for (int i = 0; i < N; i++) {
            double s = 0;
            for (int j = 0; j < N; j++) {
                s += Math.abs(matrix[i][j]);
            }
            s /= matrix[i][i];
            if (t < s) {
                t = s;
            }
        }
        return t - 1;
    }

    private double calculateNorm(double[] x, double[] y) {
        double d = 0;
        for (int i = 0; i < N; i++) {
            double s = Math.abs(x[i] - y[i]);
            if (s > d) {
                d = s;
            }
        }
        return d;
    }

    private void iterationStep(double[] x, double[] y) {
        for (int i = 0; i < N; i++) {
            y[i] = -B[i];
            for (int j = 0; j < N; j++) {
                y[i] += A[i][j] * x[j];
            }
            y[i] = x[i] - y[i] / A[i][i];
        }
    }

    private void checkSolution() {
        System.out.println("Проверка решения:");
        for (int i = 0; i < N; i++) {
            double s = 0;
            for (int j = 0; j < N; j++) {
                s += A[i][j] * X2[j];
            }
            System.out.println("Вычислено: " + s + " | Ожидалось: " + B[i]);
        }
    }
}