package grupo1.egibide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministarUsuario {
    private JPanel panel2;
    private JLabel title;
    private JButton crearUsuarioButton;
    private JButton verUsuariosButton;
    private JButton actualizarUsuarioButton;
    private JButton eliminarUsuarioButton;
    private JPanel panel4;

    public AdministarUsuario() {
        JFrame frame = new JFrame("AdministarUsuario");
        frame.setContentPane(panel4);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        crearUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevoUsuario pantallacrearusuario=new NuevoUsuario();

            }
        });
        verUsuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VerUsuario pantallaverusuarios=new VerUsuario();
            }
        });
        actualizarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActualizarUsuario pantallaactualizarusuario=new ActualizarUsuario();
            }
        });
        eliminarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarUsuario pantallaborrarusuario=new EliminarUsuario();
            }
        });
    }

}
