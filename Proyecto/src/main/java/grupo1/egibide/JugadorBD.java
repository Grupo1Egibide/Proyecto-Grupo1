package grupo1.egibide;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JugadorBD {

    // SABER LOS JUGADORES QUE TIENE EL EQUIPO
    public static List<Jugador> jugadores(int codEquipo) {

        // Lista para dejar los objetos
        List<Jugador> listaJugadores = new ArrayList<>();

        // Conexión a la BD
        Connection conexion = GestorBD.conectar();

        try {

            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM Jugador WHERE Equipo_codEquipo = " + codEquipo;
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                listaJugadores.add(
                        new Jugador(
                                rs.getInt("codJugador"),
                                rs.getString("nombre"),
                                rs.getString("nick"),
                                rs.getInt("salario"),
                                rs.getString("fechaAlta"),
                                rs.getString("posicion")
                        )
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        GestorBD.desconectar();

        return listaJugadores;
    }

    // JUGADORES DISPONIBLES (NO TIENEN EQUIPO NI DUEÑO NI NADA)
    public static List<Jugador> jugadoresDisponibles() {

        // Lista para dejar los objetos
        List<Jugador> listaJugadores = new ArrayList<>();

        // Conexión a la BD
        Connection conexion = GestorBD.conectar();

        try {

            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM Jugador WHERE Equipo_codEquipo is null";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                listaJugadores.add(
                        new Jugador(
                                rs.getInt("codJugador"),
                                rs.getString("nombre"),
                                rs.getString("nick"),
                                rs.getInt("salario"),
                                rs.getString("fechaAlta"),
                                rs.getString("posicion")
                        )
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        GestorBD.desconectar();

        return listaJugadores;
    }

    // CAMBIAR EL CÓDIGO DEL EQUIPO A LOS JUGADORES DISPONIBLES
    public static void jugadorAdquirido(int codJugador, int codEquipo) {

        Jugador jugador = null;

        String sql;
        PreparedStatement st;

        Connection conexion = GestorBD.conectar();

        try {

            sql = "UPDATE Jugador " +
                    "SET Equipo_codEquipo = ? " +
                    "WHERE codJugador = ?";
            st = conexion.prepareStatement(sql);

            st.setInt(2, codJugador);
            st.setInt(1, codEquipo);

            st.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        GestorBD.desconectar();

    }

    // CAMBIAR EL CÓDIGO DEL EQUIPO A LOS JUGADORES DEL EQUIPO (A NULL)
    public static void jugadorAbandonado(int codJugador, int codEquipo) {

        Jugador jugador = null;

        String sql;
        PreparedStatement st;

        Connection conexion = GestorBD.conectar();

        try {

            sql = "UPDATE Jugador " +
                    "SET Equipo_codEquipo = null " +
                    "WHERE codJugador = ?";
            st = conexion.prepareStatement(sql);

            st.setInt(1, codJugador);


            st.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        GestorBD.desconectar();

    }


}

