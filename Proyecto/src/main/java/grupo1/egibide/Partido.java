package grupo1.egibide;

import java.util.List;

public class Partido {
    private int codPartido;
    private String resultado;
    private String fecha;
    private String hora;
    private String lugar;

    // ASOCIACIONES
    private List<Equipo> equipos;
    private Jornada jornada;
}
