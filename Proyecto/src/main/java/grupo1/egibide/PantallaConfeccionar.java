package grupo1.egibide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.List;

public class PantallaConfeccionar {
    private JPanel panelConfeccionar;
    private JLabel menuConfeccionar;
    private JPanel panelJugadoresDisponibles;
    private JPanel panelEquipo;
    private JPanel panelBotones;
    private JButton botonAgregar;
    private JButton botonQuitar;
    private JLabel tituloDisponibles;
    private JLabel tituloEquipo;
    private JList listaJugadores;
    private JList listaEquipo;
    private JButton botonGuardar;

    // MODELO PARA LA LISTA JUGADORES DISPONIBLES Y EQUIPO
    DefaultListModel modelo = new DefaultListModel();
    DefaultListModel modelo2 = new DefaultListModel();

    // ARRAY PARA GUARDAR LOS JUGADORES SELECCIONADOS (indice)
    int[] indices = listaJugadores.getSelectedIndices();


    public PantallaConfeccionar(final List<Jugador> jugadoresDisponibles) {
        JFrame frame = new JFrame("PantallaConfeccionar");
        frame.setContentPane(panelConfeccionar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

     for (int i = 0; i < jugadoresDisponibles.size(); i++) {

         modelo.addElement(jugadoresDisponibles.get(i).getNick());
     }

        listaJugadores.setModel(modelo);
        listaEquipo.setModel(modelo2);

        // BOTÓN AGREGAR JUGADOR
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String jugSelec = listaJugadores.getSelectedValue().toString();
            modelo2.addElement(jugSelec);

            modelo.remove(listaJugadores.getSelectedIndex());
            }

        });

        // BOTÓN QUITAR JUGADOR
        botonQuitar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jugSelec = listaEquipo.getSelectedValue().toString();
                modelo.addElement(jugSelec);

                modelo2.remove(listaEquipo.getSelectedIndex());
            }
        });

        // BOTÓN GUARDAR EQUIPO
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String equipoCompleto = listaEquipo.getSelectedValue().toString();

                // AQUI HABRIA QUE MODIFICAR EL "NUEVO" EQUIPO EN LA BASE DE DATOS
            }
        });
    }


}
