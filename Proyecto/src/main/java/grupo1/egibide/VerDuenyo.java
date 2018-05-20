package grupo1.egibide;

import grupo1.egibide.modelo.TablaDuenyosModel;
import grupo1.egibide.modelo.TablaEquiposModel;

import javax.swing.*;
import java.util.List;

public class VerDuenyo {
    private JPanel panel25;
    private JPanel panel21;
    private JList listaDuenyo;
    private JScrollPane panelJugadores;
    private JLabel error;
    private JTable tabla;
    private List<Duenyo> duenyos;
    private List<Equipo> equipos;

    public VerDuenyo() {
        JFrame frame = new JFrame("VerDuenyo");
        frame.setContentPane(panel25);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // Cargar los dueños en la lista
        duenyos = DuenyoBD.duenyos();
        actualizarListaViajes();

        //tabla vacia
        tabla = new JTable();
        tabla.setModel(new TablaDuenyosModel()); //asociar con el modelo
        panelJugadores.setViewportView(tabla);

        // Cuando se pulsa en un dueño, actualizar la lista de equipos
        listaDuenyo.addListSelectionListener(e -> {

            Duenyo j = (Duenyo) listaDuenyo.getSelectedValue();

            if (j != null) {
                tabla.setModel(new TablaDuenyosModel(j.getCodDuenyo()));
            }
        });
    }


    private void actualizarListaViajes() {
        DefaultListModel<Duenyo> modelo = new DefaultListModel<>();

        for (Duenyo j : duenyos) {
            modelo.addElement(j);
        }

        listaDuenyo.setModel(modelo);
    }
}
