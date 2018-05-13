package grupo1.egibide;

import com.mysql.cj.jdbc.PreparedStatement;

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
    public static void guardar(Jugador jugador) {

        Connection conexion = GestorBD.conectar();

        try {

            String sql;
            java.sql.PreparedStatement st;

                sql = "INSERT INTO Jugador VALUES (?,?,?,?,?,?)";
                st = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                st.setInt(1, jugador.getCodJugador());
                st.setString(2, pelicula.getTitulo());
                st.setDouble(3, pelicula.getPuntuacion());
                st.setInt(4, pelicula.getAnyo());



            int filasAfectadas = st.executeUpdate();
            if (pelicula.getId() == -1 && filasAfectadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    pelicula.setId(rs.getInt(1));
                }
            }

            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        GestorBD.desconectar();

    }


}


