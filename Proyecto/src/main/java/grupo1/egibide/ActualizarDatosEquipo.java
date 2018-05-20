package grupo1.egibide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ActualizarDatosEquipo {
    private JPanel panel24;
    private JTextField nombre;
    private JTextField duenyo;
    private JButton modificarButton;
    private List<Equipo> equipos;
    private List<Duenyo> duenyos;

    public ActualizarDatosEquipo(Equipo equipo) {
        JFrame frame = new JFrame("ActualizarDatosEquipo");
        frame.setContentPane(panel24);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        //Cargar los usuarios en la lista
        equipos = EquipoBD.equipos();
        //Cargar dueños en la lista
        duenyos=DuenyoBD.duenyos();

        //Llenar el campo con los datos al principio
        nombre.setText(equipo.getNombre());


        //String codDuenyo2=Integer.toString(equipo.getDuenyo1().getCodDuenyo());


        //duenyo.setText(codDuenyo2);
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //al pulsar modificar
                int codDuenyo3=Integer.parseInt(duenyo.getText());
                //Buscamos el dueño

                Duenyo duenyoEncontrado;
                int i = 0;

                while (i < duenyos.size() && duenyos.get(i).getCodDuenyo() != codDuenyo3) {
                    i++;
                }
                if (i < duenyos.size()) {
                    //encontrado
                    duenyoEncontrado = duenyos.get(i);
                } else {
                    duenyoEncontrado = null;
                }
                //System.out.println(duenyoEncontrado);

                //Creamos el objeto tipo equipo con los datos
                Equipo crearEquipo=new Equipo(equipo.getCodEquipo(),nombre.getText(),duenyoEncontrado);

                //Lo guardamos en la BBDD
                EquipoBD.guardar(crearEquipo);

                //Actualizamos la clase con la BBDD
                equipos=EquipoBD.equipos();
            }
        });
    }
}
