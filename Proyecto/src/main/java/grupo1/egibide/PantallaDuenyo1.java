package grupo1.egibide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PantallaDuenyo1 {
    private JPanel panelMenuDuenyo;
    private JLabel tituloMenu1;
    private JPanel panelEquipo;
    private JPanel panelResultados;
    private JLabel menuResultados;
    private JButton botonResultados;
    private JPanel panelJugadores;
    private JLabel menuEquipos;
    private JButton botonJugadores;
    private JButton botonEquipos;
    private JLabel menuConfeccionar;
    private JComboBox comboBoxEquipo;

    private final List<Equipo> equipos = new ArrayList<>();
    private List<Jugador> listaJugador = JugadorBD.jugadores();
    private List<Duenyo> listaDuenyo = DuenyoBD.duenyos();
    private List<Equipo> listaEquipos = EquipoBD.equipos();


    public PantallaDuenyo1(List<Duenyo> duenyos) {
        // VISUALIZAR LA VENTANA
        JFrame frame = new JFrame("PantallaDuenyo1");
        frame.setContentPane(panelMenuDuenyo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // BOTÓN PARA CONFECCIONAR EQUIPO
        botonEquipos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PantallaConfeccionar ventanita = new PantallaConfeccionar(listaJugador);
            }
        });

        // COMBOBOX EQUIPO: RELLENARLO DE LOS EQUIPOS DEL DUEÑO
        for (int i = 0; i < listaEquipos.size(); i++) {
            comboBoxEquipo.addItem(listaEquipos.get(i).getNombre());

        }

    }


}
