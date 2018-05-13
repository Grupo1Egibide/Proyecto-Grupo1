package grupo1.egibide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class NuevoJugador {
    private JPanel panel8;
    private JTextField nombre;
    private JTextField codJugador;
    private JTextField nick;
    private JTextField salario;
    private JTextField fechaAlta;
    private JTextField codEquipo;
    private JButton crearButton;
    private JTextField dni;
    private JTextField fechaNacimieto;
    private JTextField edad;
    private JTextField poblacion;
    private JTextField posicion;
    private JLabel error;


    public NuevoJugador() {
        JFrame frame = new JFrame("NuevoJugador");
        frame.setContentPane(panel8);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //Al pulsar crear
                //convertimos los datos que no son STRING a INT
                int edad1 = Integer.parseInt(edad.getText());
                int codJugador1 = Integer.parseInt(codJugador.getText());
                int salario1 = Integer.parseInt(salario.getText());
                int codEquipo1 = Integer.parseInt(codEquipo.getText());
                Equipo equipoEncontrado;
                //Buscamos el equipo
                List<Equipo> prueba = new ArrayList<>();
                int i = 0;
                while (i < prueba.size() && prueba.get(i).getCodEquipo() != codEquipo1) {
                    i++;
                }
                if (i < prueba.size()) {
                    //encontrado
                    equipoEncontrado = prueba.get(i);
                } else {
                    equipoEncontrado = null;
                }
                Jugador crearJugador = new Jugador(dni.getText(), nombre.getText(), fechaNacimieto.getText(), edad1,
                        poblacion.getText(), codJugador1, nick.getText(), salario1, fechaAlta.getText(),
                        posicion.getText(), equipoEncontrado);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
