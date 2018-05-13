package grupo1.egibide;

public class Jugador extends Persona {
    private int codJugador;
    private String nick;
    private int salario;
    private String fechaAlta;
    private String posicion;


    // CONSTRUCTORES
    public Jugador(String dni, String nombre, String fechaNac, int edad, String poblacion, int codJugador, String nick, int salario, String fechaAlta, String posicion, Equipo equipo) {
        super(dni, nombre, fechaNac, edad, poblacion);
        this.codJugador = codJugador;
        this.nick = nick;
        this.salario = salario;
        this.fechaAlta = fechaAlta;
        this.posicion = posicion;
        this.equipo = equipo;
    }

    public Jugador(String nombre) {
        super(nombre);
    }

    public Jugador(int codJugador, String nombre, String nick, int salario, String fechaAlta, String posicion, int equipo_codEquipo) {
        super(nombre);
        this.codJugador = codJugador;
        this.nick = nick;
        this.salario = salario;
        this.fechaAlta = fechaAlta;
        this.posicion = posicion;
        this.equipo = equipo;

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



    // toString
    @Override
    public String toString() {
        return "Jugador{" +
                "codJugador=" + codJugador +
                ", nick='" + nick + '\'' +
                ", salario=" + salario +
                ", fechaAlta='" + fechaAlta + '\'' +
                ", posicion='" + posicion + '\'' +
                ", equipo=" + equipo +
                '}';
    }

    // ASOCIACIONES
    private Equipo equipo;
    private VerJugador verjugador1;
    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
