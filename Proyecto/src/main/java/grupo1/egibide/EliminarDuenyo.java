package grupo1.egibide;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EliminarDuenyo {
    private JPanel panelsito;
    private JPanel panel24;
    private JList listaDuenyo;
    private JButton eliminarButton;
    private List<Duenyo> duenyos;

    public EliminarDuenyo() {
        JFrame frame = new JFrame("EliminarDuenyo");
        frame.setContentPane(panelsito);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        //cargar dueños en la lista
        duenyos = DuenyoBD.duenyos();
        actualizarListaViajes();
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Duenyo duenyoSeleccionado = (Duenyo) listaDuenyo.getSelectedValue();
                DuenyoBD.eliminar(duenyoSeleccionado); //lo borramos de la BBDD
                //Actualizamos la lista
                actualizarListaViajes();
                DuenyoBD.duenyos();
            }
        });
        listaDuenyo.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                eliminarButton.setEnabled(true);
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
