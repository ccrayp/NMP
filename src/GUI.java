import javax.swing.*;
import java.awt.*;

public class GUI {
    public GUI() {
        JFrame frame = new JFrame("Нахождение корней функций одной переменнной");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();

        final int frameWidth = (int)(dimension.getWidth()*0.7);
        final int frameHeight = (int)(dimension.getHeight()*0.7);
        final int xOrigin = (int)(dimension.getWidth()/2 - frameWidth/2);
        final int yOrigin = (int)(dimension.getHeight()/2 - frameHeight/2);
        frame.setBounds(xOrigin, yOrigin, frameWidth, frameHeight);

        JPanel panel = new JPanel();

        String[] items = {"Метод деления отрезков", "Метод касательных #1", "Метод касательных #2"};
        JComboBox selectMethod = new JComboBox<>(items);
        selectMethod.setSize((int)(frameWidth - frameWidth*0.05), (int)(frameHeight*0.1));
        selectMethod.setLocation(10, 10);
        panel.add(selectMethod);

        JButton buttonStart = new JButton("Вычислить корень");
        buttonStart.setSize(100, 100);
        buttonStart.setLocation(frameWidth - buttonStart.getWidth(), frameHeight - buttonStart.getHeight());
        panel.add(buttonStart);

        frame.add(panel);

        frame.setVisible(true);
    }
}
