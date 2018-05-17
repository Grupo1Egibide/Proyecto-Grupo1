package grupo1.egibide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static grupo1.egibide.JugadorBD.jugadores;

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

    private int codDuenyo;
    private Object objEquipo;
    private int equipoCodigo;
    private String nombreEquipo;


    public PantallaDuenyo1(String nombre) {
        // VISUALIZAR LA VENTANA
        JFrame frame = new JFrame("PantallaDuenyo1");
        frame.setContentPane(panelMenuDuenyo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // Para obtener el código del dueño
        codDuenyo = DuenyoBD.duenyo(nombre).getCodDuenyo();


        // COMBOBOX EQUIPO: RELLENARLO DE LOS EQUIPOS DEL DUEÑO
        List<Equipo> equiposDuenyo = EquipoBD.equipos1(codDuenyo);
        for (int i = 0; i < equiposDuenyo.size(); i++) {
            String nomEquipo = equiposDuenyo.get(i).getNombre();
            comboBoxEquipo.addItem(nomEquipo);
        }


        // BOTÓN PARA CONFECCIONAR EQUIPO
        botonEquipos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Para sacar el código del equipo que ha sido seleccionado he hecho esto
                int numEquipo = comboBoxEquipo.getSelectedIndex();
                equipoCodigo = equiposDuenyo.get(numEquipo).getCodEquipo();

                PantallaConfeccionar ventanaConfeccionar = new PantallaConfeccionar(equipoCodigo);
            }
        });


    }


}
