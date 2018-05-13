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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        creaJugadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevoJugador pantallaCrearJugador=new NuevoJugador();

            }
        });
    }
}
