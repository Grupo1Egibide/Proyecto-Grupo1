package grupo1.egibide;

import grupo1.egibide.modelo.TablaEquiposModel;
import grupo1.egibide.modelo.TablaUsuariosModel;

import javax.swing.*;
import java.util.List;

public class VerUsuario {

    private JPanel panelsito;
    private JPanel panel21;
    private JList listaUsuario;
    private JScrollPane panelUsuarios;
    private JLabel error;
    private JTable tabla;
    private List<Cuenta> usuarios;

    public VerUsuario() {
        JFrame frame = new JFrame("VerUsuario");
        frame.setContentPane(panelsito);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // Cargar los usuarios en la lista
       usuarios= CuentaBD.cuentas1();
        actualizarListaViajes();
        //tabla vacia
        tabla = new JTable();
        tabla.setModel(new TablaUsuariosModel()); //asociar con el modelo

        panelUsuarios.setViewportView(tabla);
        // Cuando se pulsa en un codigo, actualizar la lista de jugadores
        listaUsuario.addListSelectionListener(e -> {

            Cuenta j = (Cuenta) listaUsuario.getSelectedValue();

            if (j != null) {
                tabla.setModel(new TablaUsuariosModel(j.getNombre()));
            }
        });
    }

    private void actualizarListaViajes() {
        DefaultListModel<Cuenta> modelo = new DefaultListModel<>();

        for (Cuenta j : usuarios) {
            modelo.addElement(j);
        }

        listaUsuario.setModel(modelo);
    }

    }


