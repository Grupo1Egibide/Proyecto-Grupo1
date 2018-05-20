package grupo1.egibide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministrarEquipo {
    private JPanel panel2;
    private JLabel title;
    private JButton crearEquipoButton;
    private JButton verEquiposButton;
    private JButton actualizarEquipoButton;
    private JButton eliminarEquipoButton;



    public AdministrarEquipo() {
        JFrame frame = new JFrame("AdministrarEquipo");
        frame.setContentPane(panel2);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        crearEquipoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //IR a Nuevo equipo
                NuevoEquipo pantalacrearequipo=new NuevoEquipo();
            }
        });

        verEquiposButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //IR a VER EQUIPOS
                VerEquipo pantallavereuqipos=new VerEquipo();
            }
        });
        actualizarEquipoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //IR a ACTUALIZAR EQUIPOS
                ActualizarEquipo pantallaactualizarequipo=new ActualizarEquipo();
            }
        });
        eliminarEquipoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //IR a ELIMINAR EQUIPOS
                EliminarEquipo pantallaborrarequipo=new EliminarEquipo();
            }
        });
    }
}
