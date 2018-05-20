package grupo1.egibide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ActualizarDatosUsuario {
    private JPanel panelsito;
    private JPanel panel24;
    private JTextField nombre;
    private JButton modificarButton;
    private JTextField contrasenya;
    private List<Cuenta> usuarios;

    public ActualizarDatosUsuario(Cuenta usuario) {
        JFrame frame = new JFrame("ActualizarDatosUsuario");
        frame.setContentPane(panelsito);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        //cargar dueños en la lista
        usuarios = CuentaBD.cuentas1();
        //Llenar el campo con los datos al principio
        nombre.setText(usuario.getNombre());
        contrasenya.setText(usuario.getContrasenya());

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Creamos el objeto de tipo cuenta con los datos
                Cuenta crearUsuario = new Cuenta(1, nombre.getText(), contrasenya.getText(), 3);

                //Guardamos en la BBD
                CuentaBD.guardar1(nombre.getText(),crearUsuario);
                //Actualizamos
                usuarios = CuentaBD.cuentas1();
            }
        });
    }
}
