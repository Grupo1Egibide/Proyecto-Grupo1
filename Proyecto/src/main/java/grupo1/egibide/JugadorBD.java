package grupo1.egibide;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JugadorBD {

    public static List<Jugador> jugadores() {

        // Lista para dejar los objetos
        List<Jugador> listaJugadores = new ArrayList<>();

        // Conexión a la BD
        Connection conexion = GestorBD.conectar();

        try {

            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM Jugador";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                listaJugadores.add(
                        new Jugador(
                                rs.getInt("codJugador"),
                                rs.getString("nombre"),
                                rs.getString("nick"),
                                rs.getInt("salario"),
                                rs.getString("fechaAlta"),
                                rs.getString("posicion"),
                                rs.getInt("Equipo_codEquipo")
                        )
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        GestorBD.desconectar();

        return listaJugadores;
    }

}
