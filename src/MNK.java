import java.awt.*;
import java.util.Arrays;
import javax.swing.*;
import static java.lang.Math.round;

public class MNK {
    private static final int N = 9;
    private static double[] X = {1.42, 1.56, 2.0, 3.19, 3.23, 3.85, 4.44, 6.0, 5.20};
    private static double[] Y = {1.5, 0.46, 0.14, 3.01, 6.09, 4.98, 5.82, 9.33, 6.78};
//    private static double[] X = {1.65, 1.69, 1.92, 2.33, 2.55, 3.84, 5.11, 4.91, 5.44, 0};
//    private static double[] Y = {8.12, 7.68, 9.16, 9.15, 10.64, 11.86, 16.64, 15.24, 17.94, 0};

    private static double A, B;

    public static void menu() {
        calculateCoefficients();
        drawGraph();
    }

    private static void calculateCoefficients() {
        double CX = 0, CXX = 0, CY = 0, CXY = 0;
        for (int i = 0; i < N; i++) {
            CX += X[i];
            CXX += X[i] * X[i];
            CY += Y[i];
            CXY += X[i] * Y[i];
        }
        double D = (N + 1) * CXX - CX * CX;
        A = ((N + 1) * CXY - CX * CY) / D;
        B = (CXX * CY - CX * CXY) / D;
        System.out.println(A+"x" + (B < 0 ? "" : "+") + B);
    }

    private static void drawGraph() {
        JFrame frame = new JFrame("График");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new GraphPanel());
        frame.setVisible(true);
    }

    static class GraphPanel extends JPanel {
        private static final int OFFSET = 400; // Смещение для центра графика
        private static final int SCALE = 20; // Масштаб

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawAxes(g);
            drawPoints(g);
            drawLine(g);
        }

        private void drawAxes(Graphics g) {
            g.setColor(Color.BLACK);
            // Ось X
            g.drawLine(0, OFFSET, getWidth(), OFFSET);
            // Ось Y
            g.drawLine(OFFSET, 0, OFFSET, getHeight());

            // Стрелки на осях
            g.drawLine(getWidth() - 10, OFFSET - 5, getWidth(), OFFSET); // Стрелка на оси X
            g.drawLine(getWidth() - 10, OFFSET + 5, getWidth(), OFFSET); // Стрелка на оси X
            g.drawLine(OFFSET - 5, 10, OFFSET, 0); // Стрелка на оси Y
            g.drawLine(OFFSET + 5, 10, OFFSET, 0); // Стрелка на оси Y

            // Подписи осей
            g.drawString("X", getWidth() - 20, OFFSET - 10);
            g.drawString("Y", OFFSET + 10, 20);
        }

        private void drawPoints(Graphics g) {
            g.setColor(Color.BLUE);
            for (int i = 0; i < N; i++) {
                int x = (int) (X[i] * SCALE + OFFSET);
                int y = (int) (OFFSET - Y[i] * SCALE);
                g.fillOval(x - 5, y - 5, 10, 10);
                g.drawString("(" + X[i] + ", " + Y[i] + ")", x + 5, y - 5); // Подпись точки
            }
        }

        private void drawLine(Graphics g) {
            g.setColor(Color.BLUE);
            int x1 = -OFFSET / SCALE;
            int y1 = (int) (A * x1 + B);
            int x2 = OFFSET / SCALE;
            int y2 = (int) (A * x2 + B);
            g.drawLine(x1 * SCALE + OFFSET, OFFSET - y1 * SCALE, x2 * SCALE + OFFSET, OFFSET - y2 * SCALE);
        }
    }
}