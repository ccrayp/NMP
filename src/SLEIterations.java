public class SLEIterations {
    public static void solve() {

    }

    public static void print() {

    }

    static final int N = 3;
    static double[][] A = new double[N][N];
    static double[] B = new double[N];
    static double[] X1 = new double[N];
    static double[] X2 = new double[N];
    static double E, T;

    public static void menu(String[] args) {
        T = calculateTeta(A);
        System.out.println("TETA = " + T);

        for (int i = 0; i < N; i++) {
            X2[i] = 0; // Начальный вектор
        }

        do {
            System.arraycopy(X2, 0, X1, 0, N); // Копируем X2 в X1
            step(X1, X2);
        } while (norm(X1, X2) <= E * (1 - T) / T);

        for (int i = 0; i < N; i++) {
            System.out.println("X(" + (i + 1) + ") = " + X2[i]);
        }

        checkSolution();
    }

    static double calculateTeta(double[][] A) {
        double T = 0;
        for (int i = 0; i < N; i++) {
            double S = 0;
            for (int j = 0; j < N; j++) {
                S += Math.abs(A[i][j]);
            }
            S /= A[i][i];
            if (T < S) {
                T = S;
            }
        }
        return T - 1;
    }

    static double norm(double[] X, double[] Y) {
        double D = 0;
        for (int i = 0; i < N; i++) {
            double S = Math.abs(X[i] - Y[i]);
            if (S > D) {
                D = S;
            }
        }
        return D;
    }

    static void step(double[] X, double[] Y) {
        for (int i = 0; i < N; i++) {
            Y[i] = -B[i];
            for (int j = 0; j < N; j++) {
                Y[i] += A[i][j] * X[j];
            }
            Y[i] = X[i] - Y[i] / A[i][i];
        }
    }

    static void checkSolution() {
        for (int i = 0; i < N; i++) {
            double S = 0;
            for (int j = 0; j < N; j++) {
                S += A[i][j] * X2[j];
            }
            System.out.println("Проверка: " + S + " = " + B[i]);
        }
    }
}
