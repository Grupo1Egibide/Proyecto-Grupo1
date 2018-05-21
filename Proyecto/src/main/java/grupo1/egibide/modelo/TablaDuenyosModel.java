package grupo1.egibide.modelo;

import grupo1.egibide.Duenyo;
import grupo1.egibide.DuenyoBD;
import grupo1.egibide.Equipo;
import grupo1.egibide.EquipoBD;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TablaDuenyosModel extends AbstractTableModel {
    private List<Duenyo> duenyos;
    private List<Equipo> equipos;
    private int equipo;

    public TablaDuenyosModel() {
       this.equipo=-1;
       equipos=new ArrayList<>();
    }

    public TablaDuenyosModel(int codDuenyo) {
        this.equipo = equipo;
        equipos = new ArrayList<>();
        equipos = DuenyoBD.buscarEquiposDuenyo(codDuenyo);
    }

    private String[] columnas = {"Codigo Equipo", "Nombre"};


    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public int getRowCount() {
        return equipos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Equipo e = equipos.get(rowIndex);

        try {
            switch (columnIndex) {
                case 0:
                    return e.getCodEquipo();
                case 1:
                    return e.getNombre();
            }
        } catch (java.lang.NullPointerException e1) {
            System.out.println("aa");

        }


        return null;
    }

}
