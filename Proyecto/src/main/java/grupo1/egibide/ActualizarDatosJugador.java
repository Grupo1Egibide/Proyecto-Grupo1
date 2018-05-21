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
    private JLabel error;
    private JLabel error2;
    private List<Jugador> jugadores;
    private List<Equipo> equipos = EquipoBD.equipos();

    public ActualizarDatosJugador(Jugador jugador) {
        JFrame frame = new JFrame("ActualizarDatosJugador");
        frame.setContentPane(panel11);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        dni.setText("111");
        nombre.setText("juan");
        edad.setText("1500"); //le damos un valor en String
        int edad2 = Integer.parseInt(edad.getText()); //lo convertimos a int
        poblacion.setText("murcia");
        fechaNacimieto.setText("01-03-97");

        String salario1 = Integer.toString(jugador.getSalario());
        //String codEquipo1 = Integer.toString(jugador.getEquipo().getCodEquipo());
        // System.out.println(jugador.getEquipo());

        int codJugadorEncontrado;

        // Cargar los usuarios en la lista
        jugadores = JugadorBD.jugadores();

        //Llenar el campo con los datos al principio
        nick.setText(jugador.getNick());
        salario.setText(salario1);
        fechaAlta.setText(jugador.getFechaAlta());
        //codEquipo.setText(codEquipo1);


        ModificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Al pulsar modificar
                int codEquipo2 = Integer.parseInt(codEquipo.getText());
                int salario2 = Integer.parseInt(salario.getText());

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

                if (Integer.parseInt(salario.getText()) > 736) { //RESTRICCION DEL SMI
                    if (EquipoBD.contarJugador(codEquipo2) < 6) { //RESTRICCION DE MAX. 6 Jugadores en equipo
                        if (JugadorBD.salarioTotal(codEquipo2) < 200000) { //Restriccion del salario max.

                            //Creamos el objeto tipo Jugador con los datos
                          /* Jugador crearJugador = new Jugador(dni, nombre, fechaNacimiento, edad1, poblacion,
                        nick.getText(), salario2, fechaAlta.getText(), posicion.getText(),
                        equipoEncontrado);*/
                            Jugador crearJugador = new Jugador(jugador.getCodJugador(), dni.getText(), nombre.getText(), fechaNacimieto.getText(), edad2,
                                    poblacion.getText(), nick.getText(), Integer.parseInt(salario.getText()), fechaAlta.getText(),
                                    posicion.getText(), equipoEncontrado);

                            //Lo guardamos en la BBDD
                            JugadorBD.guardar(crearJugador);

                            //Actualizamos la clase con la BBDD
                            jugadores = JugadorBD.jugadores();
                        } else {
                            error.setText("El salario del equipo no puede ser superior a 200.000€");
                        }
                    } else {
                        error2.setText("No puede haber más de 6 jugadores en un equipo");
                    }
                } else {
                    error.setText("El salario debe ser mayor que el SMI");
                }
            }
        });
    }

}


