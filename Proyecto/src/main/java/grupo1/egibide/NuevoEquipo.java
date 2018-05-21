package grupo1.egibide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class NuevoEquipo {
    private JPanel panel21;
    private JTextField nombre;
    private JTextField duenyo;
    private JButton crearButton;
    private List<Equipo> equipos = EquipoBD.equipos();
    private List<Duenyo> duenyos = DuenyoBD.duenyos();


    public NuevoEquipo() {
        JFrame frame = new JFrame("NuevoEquipo");
        frame.setContentPane(panel21);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //al pulsar crear

                Duenyo duenyoEncontrado;
                int codDuenyo = Integer.parseInt(duenyo.getText()); //convertirlo a int

                //Buscar si el dueño existe
                int i = 0;
                while (i < duenyos.size() && duenyos.get(i).getCodDuenyo() != codDuenyo) {
                    i++;
                }
                if (i < duenyos.size()) {
                    //encontrado
                    duenyoEncontrado = duenyos.get(i);
                } else {
                    duenyoEncontrado = null;
                }
                System.out.println(duenyoEncontrado.getCodDuenyo());
                //Creamos el objeto de tipo equipo con los datos
                Equipo crearEquipo = new Equipo(nombre.getText(), duenyoEncontrado);
                equipos = EquipoBD.equipos();
                //Guardamos en la BBD

                //Actualizamos
                equipos = EquipoBD.equipos();

            }
        });
    }
}
