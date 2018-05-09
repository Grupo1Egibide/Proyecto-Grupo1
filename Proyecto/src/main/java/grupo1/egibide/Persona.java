package grupo1.egibide;

public class Persona {

    private String dni;
    private String nombre;
    private String fechaNac;
    private int edad;
    private String poblacion;

    // CONSTRUCTORES
    public Persona(String dni, String nombre, String fechaNac, int edad, String poblacion) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.edad = edad;
        this.poblacion = poblacion;
    }

    public Persona(String nombre) {

    }


    // GETTERS Y SETTERS
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    // toString
    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaNac='" + fechaNac + '\'' +
                ", edad=" + edad +
                ", poblacion='" + poblacion + '\'' +
                '}';
    }
}
