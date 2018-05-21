package grupo1.egibide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministrarDuenyo {
    private JPanel panel4;
    private JPanel panel2;
    private JLabel title;
    private JButton crearEquipoButton;
    private JButton verDueñosButton;
    private JButton actualizarDueñosButton;
    private JButton eliminarDueñoButton;

    public AdministrarDuenyo() {
        JFrame frame = new JFrame("AdministrarDuenyo");
        frame.setContentPane(panel4);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        crearEquipoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevoDuenyo pantallacrearduenyo = new NuevoDuenyo();
            }
        });
        verDueñosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VerDuenyo pantallaverdueños = new VerDuenyo();
            }
        });
        actualizarDueñosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActualizarDuenyo pantallaaztualizaduenyo = new ActualizarDuenyo();
            }
        });
        eliminarDueñoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarDuenyo panatllaborrarduenyo = new EliminarDuenyo();
            }
        });
    }

}
