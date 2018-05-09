package grupo1.egibide;

import javax.swing.*;

public class PantallaAdmin {
    private JPanel panel;
    private JLabel mensaje;

    public PantallaAdmin() {
        JFrame frame = new JFrame("PantallaAdmin");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
