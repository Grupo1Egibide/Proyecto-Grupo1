package grupo1.egibide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class NuevoJugador {
    private JPanel panel8;
    private JTextField nombre;
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

    //asociación
    private List<Jugador> jugadores = JugadorBD.jugadores();
    private List<Equipo> equipos = EquipoBD.equipos();
    private List<Jugador> jugadores1 = new ArrayList<>();


    public NuevoJugador() {
        JFrame frame = new JFrame("NuevoJugador");
        frame.setContentPane(panel8);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        //Inicializar valores de persona
        dni.setText("111");
        edad.setText("1500"); //le damos un valor en String
        int edad2 = Integer.parseInt(edad.getText()); //lo convertimos a int
        poblacion.setText("murcia");
        fechaNacimieto.setText("01-03-97");

        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //Al pulsar crear

                //convertimos los datos que no son STRING a INT
                int edad1 = Integer.parseInt(edad.getText());
                //int codJugador1 = Integer.parseInt(codJugador.getText());
                int salario1 = Integer.parseInt(salario.getText());
                int codEquipo1 = -2;
                try {
                    codEquipo1 = Integer.parseInt(codEquipo.getText());
                } catch (NumberFormatException e1) {

                }
                Equipo equipoEncontrado;
                //Buscamos el equipo
                //List<Equipo> prueba = new ArrayList<>();
                //private List<Equipo> prueba;


                int i = 0;

                while (i < equipos.size() && equipos.get(i).getCodEquipo() != codEquipo1) {
                    i++;
                }
                if (i < equipos.size()) {
                    //encontrado
                    equipoEncontrado = equipos.get(i);
                } else {
                    equipoEncontrado = null;
                }

                if (Integer.parseInt(salario.getText()) > 736) { //RESTRICCION DEL SMI
                    if (equipoEncontrado != null && EquipoBD.contarJugador(equipoEncontrado.getCodEquipo()) < 6) { //RESTRICCION DE MAX. 6 Jugadores en equipo
                        if (equipoEncontrado != null && JugadorBD.salarioTotal(equipoEncontrado.getCodEquipo()) < 200000) { //Restriccion del salario max.
                            //Creamos el objeto tipo Jugador con los datos
                            Jugador crearJugador = new Jugador(dni.getText(), nombre.getText(), fechaNacimieto.getText(), edad1,
                                    poblacion.getText(), nick.getText(), salario1, fechaAlta.getText(),
                                    posicion.getText(), equipoEncontrado);

                            //Lo guardamos en la BBDD
                            JugadorBD.guardar(crearJugador);

                            //Actualizamos la clase con la BBDD
                            jugadores = JugadorBD.jugadores();

                        } else {
                            error.setText("El salario del equipo no puede ser superior a 200.000€");
                        }
                    } else {
                        error.setText("No puede haber más de 6 jugadores en un equipo");
                    }
                } else {
                    error.setText("El salario debe ser mayor que el SMI");
                }
            }
        });
    }


}
