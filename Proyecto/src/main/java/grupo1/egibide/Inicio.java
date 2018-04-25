package grupo1.egibide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Inicio {
    private JPanel login;
    private JLabel titulo;
    private JButton administrador;
    private JButton duenyo;
    private JButton usuario;

    public Inicio() { //Al pulsar en los iconos del menú
        administrador.addActionListener(new ActionListener() { //ir a pantalla de admin
            public void actionPerformed(ActionEvent e) {

            }
        });
        duenyo.addActionListener(new ActionListener() { //ir a pantalla dueño
            public void actionPerformed(ActionEvent e) {

            }
        });
        usuario.addActionListener(new ActionListener() { //ir a pantalla usuario
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        JFrame frame = new JFrame("Inicio");
        frame.setContentPane(new Inicio().login);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
