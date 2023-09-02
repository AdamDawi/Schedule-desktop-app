import javax.swing.*;
import java.awt.*;

public class App
{
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> 
        {
            JFrame frame = new JFrame("Schedule");
            JPanel panel = new MainPanel();

            panel.setPreferredSize(new Dimension(1500, 1000));
            panel.setLayout(null); //Setting own layout
            panel.setBackground(Color.WHITE);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(panel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
