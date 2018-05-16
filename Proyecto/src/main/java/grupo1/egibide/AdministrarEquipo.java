package grupo1.egibide;

import javax.swing.*;

public class AdministrarEquipo {
    private JPanel panel2;
    private JLabel title;
    private JButton crearEquipoButton;
    private JButton verEquiposButton;
    private JButton actualizarEquipoButton;
    private JButton eliminarEquipoButton;



    public AdministrarEquipo() {
        JFrame frame = new JFrame("AdministrarEquipo");
        frame.setContentPane(panel2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
