package grupo1.egibide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ActualizarDatosDuenyo {
    private JPanel panelsito;
    private JPanel panel24;
    private JTextField nombre;
    private JButton modificarButton;
    private JLabel contrasenya;
    private List<Duenyo> duenyos;
    private List<Cuenta> cuentas;

    public ActualizarDatosDuenyo(Duenyo duenyo) {
        JFrame frame = new JFrame("ActualizarDatosDuenyo");
        frame.setContentPane(panelsito);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        //cargar dueños en la lista
        duenyos = DuenyoBD.duenyos();
        //Llenar el campo con los datos al principio
        nombre.setText(duenyo.getNombre());
        contrasenya.setText("12345");

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Creamos el objeto de tipo equipo con los datos
                Duenyo crearDuenyo = new Duenyo(duenyo.getCodDuenyo(), nombre.getText());

                //Guardamos en la BBD
                DuenyoBD.guardar(crearDuenyo);
                //Actualizamos
                duenyos = DuenyoBD.duenyos();

                Cuenta crearcuenta = new Cuenta(nombre.getText(), contrasenya.getText(), 2);
                CuentaBD.guardar(crearcuenta);
                cuentas = CuentaBD.cuentas();

            }
        });
    }
}
