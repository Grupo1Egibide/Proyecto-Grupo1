package grupo1.egibide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class NuevoDuenyo {
    private JPanel panel5;
    private JPanel panel21;
    private JTextField nombre;
    private JButton crearButton;
    private JTextField contrasenya;
    private List<Duenyo> duenyos;
    private List<Cuenta> cuentas;

    public NuevoDuenyo() {

        JFrame frame = new JFrame("NuevoDuenyo");
        frame.setContentPane(panel5);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cuenta crearcuenta = new Cuenta(nombre.getText(), contrasenya.getText(), 2);
                CuentaBD.guardar(crearcuenta);
                cuentas = CuentaBD.cuentas();


                //Creamos el objeto de tipo DUEÑO con los datos
                Duenyo crearDuenyo=new Duenyo(nombre.getText());

                //Guardamos en la BBD
                DuenyoBD.guardar2(crearDuenyo,nombre.getText());
                //Actualizamos
                duenyos=DuenyoBD.duenyos();
            }
        });
    }
}
