package grupo1.egibide;

import javax.swing.*;
import javax.swing.plaf.ListUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;
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

    int codJugDisponible;
    int codJugador;


    // MODELO PARA LA LISTA JUGADORES DISPONIBLES Y EQUIPO
    DefaultListModel modelo = new DefaultListModel();
    DefaultListModel modelo2 = new DefaultListModel();

    public PantallaConfeccionar(int codEquipo) {
        JFrame frame = new JFrame("PantallaConfeccionar");
        frame.setContentPane(panelConfeccionar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        // JUGADORES DEL EQUIPO (JUGADORES QUE TIENEN CODIGO DE EQUIPO)
        List<Jugador> jugadoresEquipo = JugadorBD.jugadores(codEquipo);

        // JUGADORES DISPONIBLES (JUGADORES QUE NO TIENEN CÓDIGO DE EQUIPO)
        List<Jugador> jugadoresDisponibles = JugadorBD.jugadoresDisponibles();


        // Relleno la lista de EQUIPO (CON EL OBJETO JUGADOR)
        for (int i = 0; i < jugadoresEquipo.size(); i++) {
            modelo2.addElement(jugadoresEquipo.get(i));
        }

        // Relleno la lista de JUGADORES DISPONIBLES (CON EL OBJETO JUGADOR)
        for (int i = 0; i < jugadoresDisponibles.size(); i++) {
            modelo.addElement(jugadoresDisponibles.get(i));
        }

        listaJugadores.setModel(modelo);
        listaEquipo.setModel(modelo2);

        // BOTÓN AGREGAR JUGADOR
        botonAgregar.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                // CASTING
                Jugador jugSelec = (Jugador) listaJugadores.getSelectedValue();
                modelo2.addElement(jugSelec);

                modelo.remove(listaJugadores.getSelectedIndex());

                codJugDisponible = jugSelec.getCodJugador();


                // ME ACTUALIZA EL JUGADOR PARA QUE TENGA EL CODIGO DEL EQUIPO
                JugadorBD.jugadorAdquirido(codJugDisponible, codEquipo);

            }

        });

        // BOTÓN QUITAR JUGADOR
        botonQuitar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jugador jugSelec = (Jugador) listaEquipo.getSelectedValue();
                modelo.addElement(jugSelec);

                modelo2.remove(listaEquipo.getSelectedIndex());

                codJugador = jugSelec.getCodJugador();

                // ME ACTUALIZA EL JUGADOR PARA QUE NO TENGA CÓDIGO DE EQUIPO
                JugadorBD.jugadorAbandonado(codJugador, codEquipo);

            }
        });

        // BOTÓN GUARDAR EQUIPO (PRUEBAS)
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // MUESTRO LOS JUGADORES QUE YA TIENEN EN EL EQUIPO
                for (int i = 0; i < modelo2.size(); i++) {
                    System.out.println(modelo2.get(i).toString());

                }

                // CONTROLAR QUE EL EQUIPO COMO MÁXIMO TENGA 6 JUGADORES
                // ESTO LO TENGO QUE CONTROLAR CUANDO LE DOY AL BOTÓN AGREGAR
                if (modelo2.size() > 6) {
                    System.out.println("No puede haber más de 6 miembros en el equipo.");
                } else {
                    System.out.println("Cantidad de los miembros del equipo: " + modelo2.size());
                }


                // CONTROLAR QUE EL SALARIO TOTAL DEL EQUIPO NO SEA SUPERIOR A 200.000 EUROS
                int total = 0;
                int salario = 0;
                int salarioMax = 200000;


                for (int i = 0; i < modelo2.size(); i++) {
                    Jugador jugSalario = (Jugador) listaEquipo.getSelectedValue();
                    salario = jugSalario.getSalario();

                    total = total + salario;

                }

                System.out.println(total);

            }
        });

    }


}
