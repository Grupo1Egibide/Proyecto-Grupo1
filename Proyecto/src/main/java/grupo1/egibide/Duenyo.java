package grupo1.egibide;

import java.util.List;

public class Duenyo extends Persona {
    private int codDuenyo;
    private String nombre;

    public Duenyo(int codDuenyo, String nombre) {
        this.codDuenyo = codDuenyo;
        this.nombre = nombre;
    }

    public Duenyo(String nombre) {
        this.codDuenyo=-1;
        this.nombre = nombre;
    }
    /*
    public Duenyo(String dni, String nombre, String fechaNac, int edad, String poblacion, int codDuenyo, String nombre1, Cuenta cuenta) {
        super(dni, nombre, fechaNac, edad, poblacion);
        this.codDuenyo = codDuenyo;
        this.nombre = nombre1;
        this.cuenta = cuenta;
    }

        // CONSTRUCTORES
    public Duenyo(String nombre, int codDuenyo, String nombre1) {
        super(nombre);
        this.codDuenyo = codDuenyo;
        this.nombre = nombre1;
    }

   */


    // GETTERS Y SETTERS
    public int getCodDuenyo() {
        return codDuenyo;
    }

    public void setCodDuenyo(int codDuenyo) {
        this.codDuenyo = codDuenyo;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    // toString
    @Override
    public String toString() {
        return "Duenyo{" +
                "codDuenyo=" + codDuenyo +
                ", nombre='" + nombre + '\'' +
                ", cuenta=" + cuenta +
                ", equipos=" + equipos +
                '}';
    }

    // ASOCIACIONES
    private Cuenta cuenta;
    private List<Equipo> equipos;


}


