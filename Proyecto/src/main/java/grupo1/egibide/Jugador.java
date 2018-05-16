package grupo1.egibide;

public class Jugador extends Persona {
    private int codJugador;
    private String nombre;
    private String nick;
    private int salario;
    private String fechaAlta;
    private String posicion;

    // CONSTRUCTORES
    public Jugador(int codJugador, String nombre, String nick, int salario, String fechaAlta, String posicion) {
        this.codJugador = codJugador;
        this.nombre = nombre;
        this.nick = nick;
        this.salario = salario;
        this.fechaAlta = fechaAlta;
        this.posicion = posicion;
    }

    // GETTERS Y SETTERS
    public int getCodJugador() {
        return codJugador;
    }

    public void setCodJugador(int codJugador) {
        this.codJugador = codJugador;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // toString (PONGO SOLO EL NOMBRE, PARA QUE EN LAS JLIST APAREZCA SOLO EL NOMBRE)
    @Override
    public String toString() {
        return nombre;
    }

    // ASOCIACIONES
    private Equipo equipo;

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
