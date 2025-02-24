import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

public class GUITable {
    public static void drawTable(ArrayList<ArrayList<Double>> table, String[] columns) {
        JFrame frame = new JFrame("Таблица итераций");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();

        final int frameHeight = (int)(dimension.getHeight() * 0.8);
        final int frameWidth = (int)(dimension.getWidth() * 0.8);
        final int yOrigin = (int)(dimension.getHeight()/2 - frameHeight/2);
        final int xOrigin = (int)(dimension.getWidth()/2 - frameWidth/2);
        frame.setBounds(xOrigin, yOrigin, frameWidth, frameHeight);
        frame.setMinimumSize(new Dimension(frameWidth, frameHeight));

        String[][] newTable = arrayListToArray(table);
        JTable jTable = new JTable(newTable, columns);
        jTable.setFont(new Font("Arial", Font.PLAIN, 14));
        jTable.setRowHeight(30);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        JScrollPane scrollPane = new JScrollPane(jTable);
        frame.add(scrollPane);

        frame.setVisible(true);
    }

    private static String[][] arrayListToArray(ArrayList<ArrayList<Double>> table) {
        String[][] newTable = new String[table.size()][];
        for(int i = 0; i < table.size(); i++) {
            ArrayList<Double> temp = table.get(i);
            newTable[i] = new String[temp.size()];
            newTable[i][0] = ((temp.get(0)).toString()).replace(".0", "");
            for(int j = 1; j < temp.size(); j++) {
                newTable[i][j] = temp.get(j).toString();
            }
        }

        return newTable;
    }
}