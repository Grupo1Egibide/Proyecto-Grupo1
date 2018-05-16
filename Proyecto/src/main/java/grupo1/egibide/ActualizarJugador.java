package grupo1.egibide;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.List;

public class ActualizarJugador {
    private JPanel panel10;
    private JList listaJugadores;
    private List<Jugador> jugadores;

    public ActualizarJugador() {
        JFrame frame = new JFrame("ActualizarJugador");
        frame.setContentPane(panel10);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // Cargar los usuarios en la lista
        jugadores = JugadorBD.jugadores();
        actualizarListaViajes();

        listaJugadores.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) { //Al seleccionar un usuario de la lista
                ActualizarDatosJugador pantallaPedirDatosAModificar = new ActualizarDatosJugador
                        ((Jugador) listaJugadores.getSelectedValue()); //convertir de tipo Jugador a tipo objeto
                // para pasarle el parametro

            }
        });
    }

    private void actualizarListaViajes() {
        DefaultListModel<Jugador> modelo = new DefaultListModel<>();

        for (Jugador j : jugadores) {
            modelo.addElement(j);
        }

        listaJugadores.setModel(modelo);
    }
}
