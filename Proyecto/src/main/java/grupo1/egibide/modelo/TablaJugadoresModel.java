package grupo1.egibide.modelo;

import grupo1.egibide.Jugador;
import grupo1.egibide.JugadorBD;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TablaJugadoresModel extends AbstractTableModel {

    private int viaje;

    public TablaJugadoresModel() {
        this.viaje = -1;
        jugadores = new ArrayList<>();
    }

   /* public TablaJugadoresModel(int viaje) {
        this.viaje = viaje;
        jugadores = JugadorBD.buscarJugador(viaje);
    }*/

    private String[] columnas = {"Nombre", "Nick", "Salario", "Fecha Alta"};

    private List<Jugador> jugadores;

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
                return e.getNombre();
            case 2:
                return e.getNick();
            case 3:
                return e.getSalario();
            case 4:
                return e.getFechaAlta();
        }

        return null;
    }

}
