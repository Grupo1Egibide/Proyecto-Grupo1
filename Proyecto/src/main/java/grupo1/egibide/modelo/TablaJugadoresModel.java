package grupo1.egibide.modelo;

import grupo1.egibide.Jugador;
import grupo1.egibide.JugadorBD;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TablaJugadoresModel extends AbstractTableModel {

    private int jugador;

    public TablaJugadoresModel() {
        this.jugador = -1;
        jugadores = new ArrayList<>();
    }

    public TablaJugadoresModel(int codJugador) {
        this.jugador = jugador;
        jugadores = new ArrayList<>();
        jugadores.add(JugadorBD.buscarJugador(codJugador));
    }

    private String[] columnas = {"Codigo Jugador", "Nick", "Salario", "Fecha Alta","Posicion"};

    private List<Jugador> jugadores;

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

        return null;
    }

}