package grupo1.egibide;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.List;

public class ActualizarEquipo {
    private JPanel panel23;
    private JPanel panel10;
    private JList listaEquipos;
    private List<Equipo> equipos;

    public ActualizarEquipo() {
        JFrame frame = new JFrame("ActualizarEquipo");
        frame.setContentPane(panel23);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // Cargar los equipos en la lista
        equipos = EquipoBD.equipos();
        actualizarListaViajes();
        listaEquipos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {//Al seleccionar un equipo de la lista
                ActualizarDatosEquipo pantallaPedirDatosAModificar = new ActualizarDatosEquipo
                        ((Equipo) listaEquipos.getSelectedValue()); //convertir de tipo Jugador a tipo objeto
                // para pasarle el parametro

            }
        });
    }

    private void actualizarListaViajes() {
        DefaultListModel<Equipo> modelo = new DefaultListModel<>();

        for (Equipo j : equipos) {
            modelo.addElement(j);
        }

        listaEquipos.setModel(modelo);
    }
}
