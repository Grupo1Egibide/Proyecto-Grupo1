package grupo1.egibide;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private int codEquipo;
    private String nombre;
    private int anyoFundacion;
    private int dueño;
    private Duenyo duenyo1;

    public Duenyo getDuenyo1() {
        return duenyo1;
    }

    public void setDuenyo1(Duenyo duenyo1) {
        this.duenyo1 = duenyo1;
    }

    public int getDueño() {
        return dueño;
    }

    public void setDueño(int dueño) {
        this.dueño = dueño;
    }

    // CONSTRUCTORES
    public Equipo(int codEquipo, String nombre, int anyoFundacion, int duenyo) {
        this.codEquipo = codEquipo;
        this.nombre = nombre;
        this.anyoFundacion = anyoFundacion;
        this.duenyo = duenyo;
    }
//CONSTRUCTORES DIEGO


    public Equipo(int codEquipo, String nombre, Duenyo duenyo1) { //el equipo SI EXISTE
        this.codEquipo = codEquipo;
        this.nombre = nombre;
        this.duenyo1=duenyo1;
    }

    public Equipo(String nombre, Duenyo duenyo1) {//el equipo NO EXISTE
        this.codEquipo=-1;
        this.nombre = nombre;
        this.duenyo1 = duenyo1;
    }

    //FIN
    public Equipo(int codEquipo, String nombre) {
        this.codEquipo = codEquipo;
        this.nombre = nombre;
    }
/*
    public Equipo(int codEquipo, String nombre, int anyoFundacion, Duenyo duenyo, List<Jugador> jugadores, Partido partido) {
        this.codEquipo = codEquipo;
        this.nombre = nombre;
        this.anyoFundacion = anyoFundacion;
        this.duenyo = duenyo;
        this.jugadores = jugadores;
        this.partido = partido;
    }

    public Equipo(int codEquipo, String nombre) {
        this.codEquipo = codEquipo;
        this.nombre = nombre;
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

*/

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

    /*
    public Duenyo getDuenyo() {
        return duenyo;
    }

    public void setDuenyo(Duenyo duenyo) {
        this.duenyo = duenyo;
    }
*/
    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

   /* public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }*/

    // toString
    /*@Override
    public String toString() {
        return "Equipo{" +
                "codEquipo=" + codEquipo +
                ", nombre='" + nombre + '\'' +
                ", anyoFundacion=" + anyoFundacion +
                ", duenyo=" + duenyo +
                '}';
    }*/

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    // ASOCIACIONES
    private int duenyo;
    private List<Jugador> jugadores;
    // private Partido partido;


    private List<Jugador> listaJugadores = new ArrayList<>();
    private List<Duenyo> listaDuenyos = new ArrayList<>();

    public List<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public List<Duenyo> getListaDuenyos() {
        return listaDuenyos;
    }
}
