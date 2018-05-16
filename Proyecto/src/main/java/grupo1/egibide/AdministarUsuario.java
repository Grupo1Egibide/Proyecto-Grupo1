package grupo1.egibide;

import javax.swing.*;

public class AdministarUsuario {
    private JPanel panel2;
    private JLabel title;
    private JButton crearEquipoButton;
    private JButton verEquiposButton;
    private JButton actualizarEquipoButton;
    private JButton eliminarEquipoButton;
    private JPanel panel4;

    public AdministarUsuario() {
        JFrame frame = new JFrame("AdministarUsuario");
        frame.setContentPane(panel4);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
