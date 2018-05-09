package grupo1.egibide;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EquipoBD {

    public static List<Equipo> equipos() {

        // Lista para dejar los objetos
        List<Equipo> listaEquipos = new ArrayList<>();

        // Conexión a la BD
        Connection conexion = GestorBD.conectar();

        try {

            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM Equipo";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                listaEquipos.add(
                        new Equipo(
                                rs.getInt("codEquipo"),
                                rs.getString("nombre"),
                                rs.getInt("anyoFundacion")
                        )
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        GestorBD.desconectar();

        return listaEquipos;
    }

}

