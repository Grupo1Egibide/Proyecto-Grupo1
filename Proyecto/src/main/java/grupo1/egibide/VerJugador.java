package grupo1.egibide;


import grupo1.egibide.modelo.TablaJugadoresModel;

import javax.swing.*;
import java.util.List;

public class VerJugador {
    private JPanel panel9;
    private JList listaJugador;
    private JScrollPane panelJugadores;
    private JButton enviarButton;
    private List<Jugador> jugadores;
    private JTable tabla;

    public VerJugador() {
        JFrame frame = new JFrame("VerJugador");
        frame.setContentPane(panel9);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // Cargar los usuarios en la lista
        jugadores = JugadorBD.jugadores();
        ActualizarListaJugadores();

        //tabla vacia
        tabla = new JTable();
        tabla.setModel(new TablaJugadoresModel()); //asociar con el modelo

        panelJugadores.setViewportView(tabla);


    }

    public JPanel getPanel() {
        return panel9;
    }

    private void ActualizarListaJugadores() {
    }


}
