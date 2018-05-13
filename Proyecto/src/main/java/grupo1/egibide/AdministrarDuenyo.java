package grupo1.egibide;

import javax.swing.*;

public class AdministrarDuenyo {
    private JPanel panel4;
    private JPanel panel2;
    private JLabel title;
    private JButton crearEquipoButton;
    private JButton verDueñosButton;
    private JButton actualizarDueñosButton;
    private JButton eliminarDueñoButton;

    public AdministrarDuenyo() {
        JFrame frame = new JFrame("AdministrarDuenyo");
        frame.setContentPane(panel4);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
