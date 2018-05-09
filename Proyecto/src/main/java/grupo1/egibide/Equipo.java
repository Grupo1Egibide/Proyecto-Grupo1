package grupo1.egibide;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private int codEquipo;
    private String nombre;
    private int anyoFundacion;

    // CONSTRUCTORES
    public Equipo(int codEquipo, String nombre, int anyoFundacion, Duenyo duenyo, List<Jugador> jugadores, Partido partido) {
        this.codEquipo = codEquipo;
        this.nombre = nombre;
        this.anyoFundacion = anyoFundacion;
        this.duenyo = duenyo;
        this.jugadores = jugadores;
        this.partido = partido;
    }

    public Equipo(String nombre, int anyoFundacion, Duenyo duenyo, List<Jugador> jugadores, Partido partido) {
        this.codEquipo = -1;
        this.nombre = nombre;
        this.anyoFundacion = anyoFundacion;
        this.duenyo = duenyo;
        this.jugadores = jugadores;
        this.partido = partido;
    }

    public Equipo(int codEquipo, String nombre, int anyoFundacion){
        this.codEquipo = codEquipo;
        this.nombre = nombre;
        this.anyoFundacion = anyoFundacion;
    }

    // GETTERS Y SETTERS
    public int getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(int codEquipo) {
        this.codEquipo = codEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnyoFundacion() {
        return anyoFundacion;
    }

    public void setAnyoFundacion(int anyoFundacion) {
        this.anyoFundacion = anyoFundacion;
    }

    public Duenyo getDuenyo() {
        return duenyo;
    }

    public void setDuenyo(Duenyo duenyo) {
        this.duenyo = duenyo;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    // toString
    @Override
    public String toString() {
        return "Equipo{" +
                "codEquipo=" + codEquipo +
                ", nombre='" + nombre + '\'' +
                ", anyoFundacion=" + anyoFundacion +
                ", duenyo=" + duenyo +
                ", jugadores=" + jugadores +
                ", partido=" + partido +
                '}';
    }

    // ASOCIACIONES
    private Duenyo duenyo;
    private List<Jugador> jugadores;
    private Partido partido;

    private List<Jugador> listaJugadores = new ArrayList<>();
    private List<Duenyo> listaDuenyos = new ArrayList<>();

    public List<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public List<Duenyo> getListaDuenyos() {
        return listaDuenyos;
    }
}
