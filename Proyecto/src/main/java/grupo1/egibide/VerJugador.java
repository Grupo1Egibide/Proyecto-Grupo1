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
        actualizarListaViajes();

        //tabla vacia
        tabla = new JTable();
        tabla.setModel(new TablaJugadoresModel()); //asociar con el modelo

        panelJugadores.setViewportView(tabla);

    // Cuando se pulsa en un codigo, actualizar la lista de jugadores
        listaJugador.addListSelectionListener(e -> {

            Jugador j = (Jugador) listaJugador.getSelectedValue();

            if (j != null) {
                tabla.setModel(new TablaJugadoresModel(j.getCodJugador()));
            }
        });
    }

    private void actualizarListaViajes() {
        DefaultListModel<Jugador> modelo = new DefaultListModel<>();

        for (Jugador j : jugadores) {
            modelo.addElement(j);
        }

        listaJugador.setModel(modelo);
    }

    public JPanel getPanel() {
        return panel9;
    }




}
