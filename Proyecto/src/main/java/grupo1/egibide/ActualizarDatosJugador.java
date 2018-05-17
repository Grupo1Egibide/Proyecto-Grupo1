package grupo1.egibide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ActualizarDatosJugador {
    private JPanel panel11;
    private JTextField nombre;
    private JTextField nick;
    private JTextField salario;
    private JTextField fechaAlta;
    private JTextField codEquipo;
    private JButton ModificarButton;
    private JTextField posicion;
    private JTextField dni;
    private JTextField edad;
    private JTextField poblacion;
    private JTextField fechaNacimieto;
    private List<Jugador> jugadores;
    private List<Equipo> equipos = EquipoBD.equipos();

    public ActualizarDatosJugador(Jugador jugador) {
        JFrame frame = new JFrame("ActualizarDatosJugador");
        frame.setContentPane(panel11);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        String dni1 = dni.setText("111");
        String nombre1 = nombre.setText("juan");
        int edad1 = Integer.parseInt(edad.setText(15));
        String poblacion1 = poblacion.setText("murcia");

        String salario1 = Integer.toString(jugador.getSalario());
        String codEquipo1 = Integer.toString(jugador.getCodJugador());
        String fechaNacimiento = "123";
      /*  int edad1 = 0;
        String dni = "123";
        String nombre = "a";
        String poblacion = "murcia";*/
        int codJugadorEncontrado;

        // Cargar los usuarios en la lista
        jugadores = JugadorBD.jugadores();

        //Llenar el campo con los datos al principio
        nick.setText(jugador.getNick());
        salario.setText(salario1);
        fechaAlta.setText(jugador.getFechaAlta());
        codEquipo.setText(codEquipo1);

        int codEquipo2 = Integer.parseInt(codEquipo.getText());
        int salario2 = Integer.parseInt(salario.getText());

        ModificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Al pulsar modificar
                //Buscamos el equipo
                Equipo equipoEncontrado;
                int i = 0;

                while (i < equipos.size() && equipos.get(i).getCodEquipo() != codEquipo2) {
                    i++;
                }
                if (i < equipos.size()) {
                    //encontrado
                    equipoEncontrado = equipos.get(i);
                } else {
                    equipoEncontrado = null;
                }

                //Creamos el objeto tipo Jugador con los datos
               /* Jugador crearJugador = new Jugador(dni, nombre, fechaNacimiento, edad1, poblacion,
                        nick.getText(), salario2, fechaAlta.getText(), posicion.getText(),
                        equipoEncontrado);*/
                Jugador crearJugador = new Jugador(dni.getText(), nombre.getText(), fechaNacimieto.getText(), eda,
                        poblacion.getText(), nick.getText(), salario1, fechaAlta.getText(),
                        posicion.getText(), equipoEncontrado);

                System.out.println(crearJugador.getNombre());

                //Lo guardamos en la BBDD
                JugadorBD.guardar(crearJugador);

                //Actualizamos la clase con la BBDD
                jugadores = JugadorBD.jugadores();

            }
        });
    }

}
