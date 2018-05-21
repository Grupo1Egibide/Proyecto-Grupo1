package grupo1.egibide.modelo;

import grupo1.egibide.*;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TablaEquiposModel extends AbstractTableModel {

    private int jugador;
    private List<Jugador> jugadores;
    private VerEquipo error;

    public TablaEquiposModel() {
        this.jugador = -1;
        jugadores = new ArrayList<>();
    }

    public TablaEquiposModel(int codEquipo) {
        this.jugador = jugador;
        jugadores = new ArrayList<>();
        jugadores = EquipoBD.buscarEquipos(codEquipo);
    }

    private String[] columnas = {"Codigo Jugador", "Nick", "Salario", "Fecha Alta", "Posicion"};


    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public int getRowCount() {
        return jugadores.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Jugador e = jugadores.get(rowIndex);

        try {
            switch (columnIndex) {
                case 0:
                    return e.getCodJugador();
                case 1:
                    return e.getNick();
                case 2:
                    return e.getSalario();
                case 3:
                    return e.getFechaAlta();
                case 4:
                    return e.getPosicion();
            }
        } catch (java.lang.NullPointerException e1) {
            error.sacarError();

        }


        return null;
    }

}
