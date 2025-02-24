import java.util.Scanner;

public class Gauss {

    private static final int N = 100;
    //private static double[][] A = {{-0.47, 2.16, -2.90, 0.49},
//                                    {-2.42, -2.86, 0.75, 3.73},
  //                                  {2.54, -3.01, -3.36, -1.24},
    //                                {-2.78, -3.35, -0.11, -1.88}};
    //private static double[] B = {2.18, 4.41, 9.04, 0.70};
    private static double[][] A = new double[N][N];
    private static double[] B = new double[N];
    private static double[] X = new double[N];

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        start();
        solve();
        printSolution();
    }

    private static void start() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++)
                A[i][j] = 0;
        }

        for(int i = 0; i < N; i++) {
                A[i][i] = 5;
        }

        for(int i = 0; i < N; i++) {
            B[i] = 20;
        }
    }

    private static void solve() {
        for (int k = 0; k < N - 1; k++) {
            if (A[k][k] == 0) {
                int i = k + 1;
                while (A[i][k] == 0) {
                    i++;
                }
                reverse(k, i);
            }
            divide(k);
            for (int i = k + 1; i < N; i++) {
                clear(k, i);
            }
        }
        divide(N - 1);
        for (int i = N - 1; i >= 0; i--) {
            X[i] = B[i];
            for (int j = i + 1; j < N; j++) {
                X[i] -= A[i][j] * X[j];
            }
        }
    }

    private static String printMatrix() {
        String res = "";
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++)
                res += A[i][j] + " ";
            res += "\n";
        }
        return res;
    }

    private static void reverse(int k, int r) {
        for (int j = k; j < N; j++) {
            double temp = A[k][j];
            A[k][j] = A[r][j];
            A[r][j] = temp;
        }
        double temp = B[k];
        B[k] = B[r];
        B[r] = temp;
    }

    private static void divide(int k) {
        for (int j = k + 1; j < N; j++) {
            A[k][j] /= A[k][k];
        }
        B[k] /= A[k][k];
    }

    private static void clear(int k, int r) {
        for (int j = k + 1; j < N; j++) {
            A[r][j] -= A[k][j] * A[r][k];
        }
        B[r] -= B[k] * A[r][k];
    }

    private static void printSolution() {
        System.out.println("Решение системы:");
        for (int i = 0; i < N; i++) {
            System.out.println("X" + (i + 1) + " = " + X[i]);
        }
    }
}