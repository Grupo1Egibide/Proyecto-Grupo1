package grupo1.egibide;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EliminarUsuario {
    private JPanel panel2;
    private JPanel panel12;
    private JButton eliminarButton;
    private JList listaUsuarios;
    private List<Cuenta> usuarios;

    public EliminarUsuario() {
        JFrame frame = new JFrame("EliminarUsuario");
        frame.setContentPane(panel2);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // Cargar los usuarios en la lista
        usuarios = CuentaBD.cuentas1();
        actualizarListaViajes();

        listaUsuarios.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                eliminarButton.setEnabled(true);
            }
        });
        eliminarButton.addActionListener(new ActionListener() { //AL Pulsar ELIMINAR
            @Override
            public void actionPerformed(ActionEvent e) {
                Cuenta usuarioseleccionado = (Cuenta) listaUsuarios.getSelectedValue();
                //System.out.println(jugadorseleccionado.getCodJugador());

                CuentaBD.eliminar(usuarioseleccionado); //Lo borramos de la BBDD
                actualizarListaViajes();

                usuarios = CuentaBD.cuentas1();
            }
        });
    }

    private void actualizarListaViajes() {
        DefaultListModel<Cuenta> modelo = new DefaultListModel<>();

        for (Cuenta j : usuarios) {
            modelo.addElement(j);
        }

        listaUsuarios.setModel(modelo);
    }
}
