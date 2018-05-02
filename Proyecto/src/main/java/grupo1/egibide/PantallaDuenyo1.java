package grupo1.egibide;

import javax.swing.*;
import java.util.List;

public class PantallaDuenyo1 {
    private JPanel panelMenuDuenyo;
    private JLabel tituloMenu1;
    private JPanel panelEquipo;
    private JPanel panelResultados;
    private JLabel menuEquipo;
    private JLabel menuResultados;
    private JButton botonEquipo;
    private JButton botonResultados;
    private JPanel panelJugadores;
    private JLabel menuEquipos;
    private JButton botonJugadores;

    public PantallaDuenyo1(List<Duenyo> duenyos) {
        // VISUALIZAR LA VENTANA
        JFrame frame = new JFrame("PantallaDuenyo1");
        frame.setContentPane(panelMenuDuenyo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
