package grupo1.egibide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PantallaAdmin1 {
    private JPanel panelMenuAdmin;
    private JPanel opcionesMenu;
    private JLabel tituloMenu1;
    private JLabel menuAdmin;
    private JLabel menuCalendario;
    private JLabel menuJornadas;
    private JButton botonJugador;
    private JButton botonEquipo;
    private JButton botonDuenyo;
    private JButton botonUsuario;
    private JButton botonCalendario;
    private JComboBox comboBoxJornadas;
    private JButton botonJornada;
    private JPanel panelAdmin;
    private JPanel panelCalendario;
    private JPanel panelJornadas;

    private final List<Duenyo> duenyos = new ArrayList<>();
    private final List<Jugador> jugadores = new ArrayList<>();


    public PantallaAdmin1() {
        JFrame frame = new JFrame("PantallaAdmin1");
        frame.setContentPane(panelMenuAdmin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        botonJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //IR A CRUD DE JUGADORES
                AdministrarJugadores pantallajugador=new AdministrarJugadores();
            }
        });
        botonDuenyo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //IR A CRUD DE DUEÑOS
                AdministrarDuenyo pantallaDuenyo=new AdministrarDuenyo();

            }
        });
        botonUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //IR A CRUD DE USUARIOS
                AdministarUsuario pantallaUsuario=new AdministarUsuario();
            }
        });
        botonEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //CRUD EQUIPOS
                AdministrarEquipo pantallacrudequipo=new AdministrarEquipo();
            }
        });
        botonDuenyo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdministrarDuenyo pantalladuenyo=new AdministrarDuenyo();
            }
        });
    }
}