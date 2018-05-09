package grupo1.egibide;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DuenyoBD {

    public static List<Duenyo> duenyos() {

        // Lista para dejar los objetos
        List<Duenyo> listaDuenyos = new ArrayList<>();

        // Conexión a la BD
        Connection conexion = GestorBD.conectar();

        try {

            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM Dueño";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                listaDuenyos.add(
                        new Duenyo(
                                rs.getString("nombre"),
                                rs.getInt("codDueño"),
                                rs.getString("Nombre")
                        )
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        GestorBD.desconectar();

        return listaDuenyos;
    }

}

