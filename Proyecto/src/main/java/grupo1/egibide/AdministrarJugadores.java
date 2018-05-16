package grupo1.egibide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministrarJugadores {
    private JPanel panel3;
    private JPanel panel2;
    private JLabel title;
    private JButton creaJugadorButton;
    private JButton verJugadoresButton;
    private JButton actualizarJugadorButton;
    private JButton eliminarJugadorButton;


    public AdministrarJugadores() {
        JFrame frame = new JFrame("AdministrarJugadores");
        frame.setContentPane(panel3);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        creaJugadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevoJugador pantallaCrearJugador=new NuevoJugador();

            }
        });
        verJugadoresButton.addActionListener(new ActionListener() { //ver jugadores
            @Override
            public void actionPerformed(ActionEvent e) {
                VerJugador verjugadores=new VerJugador();
            }
        });
        actualizarJugadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActualizarJugador pantallaActualizarJugador=new ActualizarJugador();
            }
        });
        eliminarJugadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //Eliminar
                EliminarJugador pantallaborrarjugador=new EliminarJugador();
            }
        });
    }
}
