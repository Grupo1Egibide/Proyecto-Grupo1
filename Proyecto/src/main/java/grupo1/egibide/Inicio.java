package grupo1.egibide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Inicio {
    private JPanel panel;
    private JTextField usuario;
    private JTextField contraseña;
    private JButton enviar;

    public Inicio() {
        enviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Al pulsar enviar...
            }
        });
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        JFrame frame = new JFrame("Inicio");
        frame.setContentPane(new Inicio().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
