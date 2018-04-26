package grupo1.egibide;

import javax.swing.*;

public class PantallaAdmin1 {
    private JPanel panelMenuAdmin;
    private JPanel opcionesMenu;
    private JLabel tituloMenu1;
    private JLabel menuAdmin;
    private JLabel menuCalendario;
    private JLabel menuJornadas;
    private JButton botonJugador;
    private JButton botonEquipo;
    private JButton botonDuenyo;
    private JButton botonUsuario;
    private JButton botonCalendario;
    private JComboBox comboBoxJornadas;
    private JButton botonJornada;
    private JPanel panelAdmin;
    private JPanel panelCalendario;
    private JPanel panelJornadas;


    public static void main(String[] args) {
        JFrame frame = new JFrame("PantallaAdmin1");
        frame.setContentPane(new PantallaAdmin1().panelMenuAdmin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
