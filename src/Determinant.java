public class Determinant {
    private static final int N = 2;
    private static double[][] A = {{2.37, 0.47, -0.67, -2.20},
                                   {3.21, -1.27, 0.66, 2.40},
                                   {-0.87, -3.27, 2.86, -1.87},
                                   {-2.44, -2.90, -2.62, -3.29}};
//    private static double[][] A = {{5, 5},
//                                   {2, 3}};
    private static double DET;

    public static void menu() {
        calculateDeterminant();
        System.out.println("△A = " + DET);
    }

    private static void calculateDeterminant() {
        double C;
        for (int K = 0; K < N - 1; K++) {
            if (A[K][K] == 0) {
                boolean found = false;
                for (int I = K + 1; I < N; I++) {
                    if (A[I][K] != 0) {
                        for (int J = K; J < N; J++) {
                            double temp = A[K][J];
                            A[K][J] = A[I][J];
                            A[I][J] = temp;
                        }
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    DET = 0;
                    return;
                }
            }
            for (int I = K + 1; I < N; I++) {
                for (int J = K + 1; J < N; J++) {
                    A[I][J] = A[I][J] - A[K][J] * A[I][K] / A[K][K];
                }
            }
        }
        C = 1;
        for (int I = 0; I < N; I++) {
            C *= A[I][I];
        }
        DET = C;
    }
}
