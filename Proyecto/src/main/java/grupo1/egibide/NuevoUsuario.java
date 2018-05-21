package grupo1.egibide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class NuevoUsuario {
    private JPanel panel21;
    private JTextField nombre;
    private JButton crearButton;
    private JTextField contrasenya;
    private JPanel panelsito;
    private List<Cuenta> cuentas;

    public NuevoUsuario() {

        JFrame frame = new JFrame("NuevoUsuario");
        frame.setContentPane(panelsito);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //al pulsar crear
                //creamo el objeto de tipo Cuenta con los datos
                Cuenta usuario = new Cuenta(nombre.getText(), contrasenya.getText(), 3);
                //guardamos en la BBDD
                CuentaBD.guardar(usuario);

                //Actualizamos la clase con la BBDD
                cuentas = CuentaBD.cuentas();
            }
        });
    }
}
