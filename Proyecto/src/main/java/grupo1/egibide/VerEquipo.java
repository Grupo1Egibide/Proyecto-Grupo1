package grupo1.egibide;

import grupo1.egibide.modelo.TablaEquiposModel;

import javax.swing.*;
import java.util.List;

public class VerEquipo {
    private JPanel panel21;
    private JList listaEquipo;
    private JScrollPane panelJugadores;
    private JLabel error;
    private List<Equipo> equipos;
    private List<Jugador> jugadores;
    private JTable tabla;


    public VerEquipo() {
        JFrame frame = new JFrame("VerEquipo");
        frame.setContentPane(panel21);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        // Cargar los equipos en la lista
        equipos = EquipoBD.equipos();
        actualizarListaViajes();

        //tabla vacia
        tabla = new JTable();
        tabla.setModel(new TablaEquiposModel()); //asociar con el modelo

        panelJugadores.setViewportView(tabla);

        // Cuando se pulsa en un codigo, actualizar la lista de jugadores
        listaEquipo.addListSelectionListener(e -> {

            Equipo j = (Equipo) listaEquipo.getSelectedValue();

            if (j != null) {
                tabla.setModel(new TablaEquiposModel(j.getCodEquipo()));
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

    public JPanel getPanel() {
        return panel21;
    }

    public String sacarError(){
       String mensaje= "El equipo todavía no tiene usuarios";
       error.setText(mensaje);
       return mensaje;
    }
}


