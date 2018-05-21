package grupo1.egibide;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EliminarEquipo {
    private JPanel panel24;
    private JList listaEquipo;
    private JButton eliminarButton;
    private List<Equipo> equipos;

    public EliminarEquipo() {

        JFrame frame = new JFrame("EliminarEquipo");
        frame.setContentPane(panel24);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // Cargar los equipos en la lista
        equipos = EquipoBD.equipos();
        actualizarListaViajes();

        eliminarButton.addActionListener(new ActionListener() { //AL PULSAR ELIMINAR
            @Override
            public void actionPerformed(ActionEvent e) {
                Equipo equipoSeleccionado = (Equipo) listaEquipo.getSelectedValue();
                EquipoBD.eliminar(equipoSeleccionado); //Lo borramos de la BBDD
                //Actualizamos la lista
                actualizarListaViajes();
                EquipoBD.equipos();
            }
        });
        listaEquipo.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                eliminarButton.setEnabled(true);
            }
        });
    }

    private void actualizarListaViajes() {
        DefaultListModel<Equipo> modelo = new DefaultListModel<>();

        for (Equipo j : equipos) {
            modelo.addElement(j);
        }

        listaEquipo.setModel(modelo);
    }
}
