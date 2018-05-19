package grupo1.egibide;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DuenyoBD {
    //saber TODOS los dueños
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
    // Para saber el código del dueño
    public static Duenyo duenyo(String nombre) {
        Duenyo duenyo = null;

        // Conexión a la BD
        Connection conexion = GestorBD.conectar();

        try {

            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM Dueño where Cuenta_nombre = '" + nombre +"'";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {

                duenyo = new Duenyo(
                                rs.getInt("codDueño"),
                                rs.getString("Nombre")
                        );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        GestorBD.desconectar();

        return duenyo;
    }

    // Para saber los equipos que tiene el dueño


}

