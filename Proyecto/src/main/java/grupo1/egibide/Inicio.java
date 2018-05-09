package grupo1.egibide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Inicio {
    private JPanel panel;
    private JTextField usuario;
    private JTextField contraseña;
    private JButton enviar;
    private JLabel mensaje;

    // LISTA DE DUEÑOS
    private final List<Duenyo> duenyos = new ArrayList<>();

    public Inicio() { //Al pulsar en los iconos del menú
        administrador.addActionListener(new ActionListener() { //ir a pantalla de admin
            public void actionPerformed(ActionEvent e) {
    public Inicio() {
        Connection conexion = GestorBD.conectar();

            }
        });
        duenyo.addActionListener(new ActionListener() {
            // IR A LA PANTALLA DUEÑO
            public void actionPerformed(ActionEvent e) {
                PantallaDuenyo1 ventanaDuenyo = new PantallaDuenyo1(duenyos);
        List<Cuenta> cuentas = CuentaBD.cuentas();

        enviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Al pulsar enviar...

                //NO nos ha metido datos
                if(usuario.getText().equalsIgnoreCase("") && contraseña.getText().equalsIgnoreCase("")){
                    mensaje.setText("Introduce datos");
                }
                else {
                    int y = 0;
                    // usuario.getText();
                    //COMPROBAMOS QUE EL NOMBRE DE USUARIO ES CORRECTO (EXISTE)
                    while (y < cuentas.size() && !usuario.getText().equalsIgnoreCase(cuentas.get(y).getNombre())) {
                        y++;
                    }
                    //Porqué ha parado?
                    /*if (y < cuentas.size()) {
                      mensaje.setText("Nombre de usuario CORRECTO");
                    }else{
                        mensaje.setText("Error");
                    }*/

                    //Comprobamos que la contraseña es OK para ese USUARIO
                    int t = 0;

                    while (t < cuentas.size() && !contraseña.getText().equalsIgnoreCase(cuentas.get(t).getContrasenya())) {
                        t++;
                    }
                    //Porqué ha parado?
                    if (t < cuentas.size() && y<cuentas.size()) { //todo OK
                        mensaje.setText("TODO OK");
                        //SACAR PANTALLA SEGÚN USUARIO
                        

                    } else{
                        mensaje.setText("Error");
                    }

                }

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

        /*
        // PRUEBA: VER LOS JUGADORES DE LA BD
        List<Jugador> listaJugador = JugadorBD.jugadores();
        System.out.println(listaJugador);

        // PRUEBA: VER LOS EQUIPOS DE LA BD
        List<Equipo> listaEquipo = EquipoBD.equipos();
        System.out.println(listaEquipo);

        // PRUEBA: VER LOS DUEÑOS DE LA BD
        List<Duenyo> listaDuenyo = DuenyoBD.duenyos();
        System.out.println(listaDuenyo);
        */
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
