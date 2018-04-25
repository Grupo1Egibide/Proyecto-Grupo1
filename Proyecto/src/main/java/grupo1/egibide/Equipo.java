package grupo1.egibide;

import java.util.List;

public class Equipo {
    private int codEquipo;
    private String nombre;
    private int anyoFundacion;

    // ASOCIACIONES
    private Duenyo duenyo;
    private List<Jugador> jugadores;
    private Partido partido;
}
