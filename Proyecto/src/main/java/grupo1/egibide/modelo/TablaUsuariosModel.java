package grupo1.egibide.modelo;

import grupo1.egibide.Cuenta;
import grupo1.egibide.CuentaBD;
import grupo1.egibide.EquipoBD;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TablaUsuariosModel extends AbstractTableModel {

    private int usuario;
    private List<Cuenta> usuarios;

    public TablaUsuariosModel() {
        this.usuario = -1;
        usuarios = new ArrayList<>();
    }

    public TablaUsuariosModel(String nombre) {
        this.usuario = usuario;
        usuarios = new ArrayList<>();
        usuarios = CuentaBD.buscarUsuario(nombre);
    }

    private String[] columnas = {"Nombre", "Contraseña"};


    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Cuenta e = usuarios.get(rowIndex);

        try {
            switch (columnIndex) {
                case 0:
                    return e.getNombre();
                case 1:
                    return e.getContrasenya();
            }
        } catch (java.lang.NullPointerException e1) {
            System.out.println("aa");

        }


        return null;
    }
}
