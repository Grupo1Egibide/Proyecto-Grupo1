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
    private List<Duenyo> duenyos;

    public NuevoDuenyo() {

        JFrame frame = new JFrame("NuevoDuenyo");
        frame.setContentPane(panel5);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Creamos el objeto de tipo DUEÑO con los datos
                Duenyo crearDuenyo=new Duenyo(nombre.getText());

                //Guardamos en la BBD
                DuenyoBD.guardar(crearDuenyo);
                //Actualizamos
                duenyos=DuenyoBD.duenyos();
            }
        });
    }
}
