package grupo1.egibide;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.List;

public class ActualizarUsuario {
    private JPanel panelsito;
    private JPanel panel23;
    private JPanel panel10;
    private JList listaUsuarios;
    private List<Cuenta> usuarios;

    public ActualizarUsuario() {
        JFrame frame = new JFrame("ActualizarUsuario");
        frame.setContentPane(panelsito);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // Cargar los usuarios en la lista
        usuarios = CuentaBD.cuentas1();
        actualizarListaViajes();

        listaUsuarios.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) { //Al seleccionar un usuario de la lista
                ActualizarDatosUsuario pantallaPedirDatosAModificar = new ActualizarDatosUsuario
                        ((Cuenta) listaUsuarios.getSelectedValue()); //convertir de tipo Jugador a tipo objeto
                // para pasarle el parametro

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
