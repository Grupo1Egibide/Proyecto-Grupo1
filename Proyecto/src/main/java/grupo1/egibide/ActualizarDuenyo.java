package grupo1.egibide;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.List;

public class ActualizarDuenyo {
    private JPanel panel10;
    private JList listaDuenyos;
    private JPanel panelsito;
    private List<Duenyo> duenyos;

    public ActualizarDuenyo() {
        JFrame frame = new JFrame("ActualizarDuenyo");
        frame.setContentPane(panelsito);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // Cargar los dueños en la lista
        duenyos = DuenyoBD.duenyos();
        actualizarListaViajes();
        listaDuenyos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                ActualizarDatosDuenyo pantallaPedirDatosAModificar = new ActualizarDatosDuenyo
                        ((Duenyo) listaDuenyos.getSelectedValue()); //convertir de tipo Jugador a tipo objeto
                // para pasarle el parametro
            }
        });
    }

    private void actualizarListaViajes() {
        DefaultListModel<Duenyo> modelo = new DefaultListModel<>();

        for (Duenyo j : duenyos) {
            modelo.addElement(j);
        }

        listaDuenyos.setModel(modelo);
    }
}
