package grupo1.egibide;

import java.util.List;

public class Duenyo extends Persona {
    private int codDuenyo;
    private String nombre;
   // private int salario;

        /*
    public Duenyo(String dni, String nombre, String fechaNac, int edad, String poblacion, int codDuenyo, int salario, Equipo equipo) {
        super(dni, nombre, fechaNac, edad, poblacion);
        this.codDuenyo = codDuenyo;
        //this.salario = salario;
        this.equipo = equipo;
    }

    public Duenyo(int edad, String poblacion) {
        super(dni, nombre, fechaNac, edad, poblacion);
        this.codDuenyo = -1;
        //this.salario = salario;
        this.equipo = equipo;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
    */

        // CONSTRUCTORES
    public Duenyo(String nombre, int codDuenyo, String nombre1) {
        super(nombre);
        this.codDuenyo = codDuenyo;
        this.nombre = nombre1;
    }


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

    // toString
    @Override
    public String toString() {
        return "Duenyo{" +
                "codDuenyo=" + codDuenyo +
                ", nombre='" + nombre + '\'' +
                ", equipos=" + equipos +
                '}';
    }


    // ASOCIACIONES
    private List<Equipo> equipos;


}


