package grupo1.egibide;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EliminarJugador {
    private JPanel panel12;
    private JButton eliminarButton;
    private JList listaJugadores;
    private List<Jugador> jugadores;

    public EliminarJugador() {
        JFrame frame = new JFrame("EliminarJugador");
        frame.setContentPane(panel12);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        // Cargar los usuarios en la lista
        jugadores = JugadorBD.jugadores();
        actualizarListaViajes();

        listaJugadores.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) { //Al seleciconar un usuario de la lista
               /* ActualizarDatosJugador pantallaPedirDatosAModificar = new ActualizarDatosJugador
                        ((Jugador) listaJugadores.getSelectedValue()); *///convertir de tipo Jugador a tipo objeto
                // para pasarle el paratmetro


            }
        });
        listaJugadores.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                eliminarButton.setEnabled(true);
            }
        });
        eliminarButton.addActionListener(new ActionListener() { //Al PULSAR ELIMINAR
            @Override
            public void actionPerformed(ActionEvent e) {
                Jugador jugadorseleccionado = (Jugador) listaJugadores.getSelectedValue();
                //System.out.println(jugadorseleccionado.getCodJugador());

                JugadorBD.eliminar(jugadorseleccionado); //Lo borramos de la BBDD
                actualizarListaViajes();
                //Actualizamos la clase con los nuevos datos
                JugadorBD.jugadores();
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
