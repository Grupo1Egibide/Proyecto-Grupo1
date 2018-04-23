package grupo1.egibide;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Inicio {
    private JPanel panel;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        JFrame frame = new JFrame("Inicio");
        frame.setContentPane(new Inicio().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
