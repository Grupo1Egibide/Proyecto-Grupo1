package grupo1.egibide;

import javax.swing.*;
import java.util.List;

public class PantallaUsuario {

    private JPanel panel;
    private JLabel bienvenido;
    private JButton botonResultado;
    private JButton botonClasificacion;
    private JPanel panelResultado;
    private JPanel panelClasificacion;
    private JPanel panelBienvenido;

    public PantallaUsuario(List<Cuenta> cuentas) {
        JFrame frame = new JFrame("PantallaUsuario");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        for (int i = 0; i < cuentas.size(); i++) {
            bienvenido.setText("¡BIENVENIDO "+cuentas.get(i).getNombre().toUpperCase()+"!");
        }
    }


}



