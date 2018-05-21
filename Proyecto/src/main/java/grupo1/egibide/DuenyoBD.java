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

    //Guardamos un nuevo dueño
    public static void guardar(Duenyo duenyo) {

        Connection conexion = GestorBD.conectar();

        try {

            String sql;
            java.sql.PreparedStatement st;

            if (duenyo.getCodDuenyo() == -1) {
                sql = "INSERT INTO Dueño (`nombre`) " +
                        "VALUES (?)";
                st = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                //st.setString(1, jugador.getDni());
                st.setString(1, duenyo.getNombre());

            } else {
                sql = "UPDATE Dueño SET nombre=? " +
                        "WHERE codDueño =" + duenyo.getCodDuenyo();

                /* System.out.println(jugador.getNick());*/
                st = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                st.setString(1, duenyo.getNombre());


            }
            int filasAfectadas = st.executeUpdate();
            if (duenyo.getCodDuenyo() == -1 && filasAfectadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    duenyo.setCodDuenyo(rs.getInt(1));
                }
            }

            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        GestorBD.desconectar();

    }
//GUARDAR2
public static void guardar2(Duenyo duenyo,String nombre) {

    Connection conexion = GestorBD.conectar();

    try {

        String sql;
        java.sql.PreparedStatement st;

        if (duenyo.getCodDuenyo() == -1) {
            sql = "INSERT INTO Dueño (`nombre`,`Cuenta_nombre`) " +
                    "VALUES (?,?)";
            st = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            //st.setString(1, jugador.getDni());
            st.setString(1, duenyo.getNombre());
            st.setString(2, nombre);

        } else {
            sql = "UPDATE Dueño SET nombre=? Cuenta_nombre=?" +
                    "WHERE codDueño =" + duenyo.getCodDuenyo();

            /* System.out.println(jugador.getNick());*/
            st = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, duenyo.getNombre());
            st.setString(2, nombre);


        }
        int filasAfectadas = st.executeUpdate();
        if (duenyo.getCodDuenyo() == -1 && filasAfectadas > 0) {
            ResultSet rs = st.getGeneratedKeys();
            while (rs.next()) {
                duenyo.setCodDuenyo(rs.getInt(1));
            }
        }

        st.close();

    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    GestorBD.desconectar();

}

    //ELIMINAR
    public static void eliminar(Duenyo duenyo) {

        Connection conexion = GestorBD.conectar();

        try {

            String sql;
            java.sql.PreparedStatement st;

            sql = "DELETE FROM Dueño WHERE codDueño=" + duenyo.getCodDuenyo();

            st = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            int filasAfectadas = st.executeUpdate();
            if (duenyo.getCodDuenyo() == -1 && filasAfectadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    duenyo.setCodDuenyo(rs.getInt(1));
                }
            }

            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        GestorBD.desconectar();

    }


    //VER TODOS LOS EQUIPOS DE UN DUEÑO
    public static List<Equipo> buscarEquiposDuenyo(int codigo) {

        Equipo Equipo = null;
        List<Equipo> lista = new ArrayList<>();
        Connection conexion = GestorBD.conectar();

        try {

            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM Equipo where Dueño_codDueño =" + codigo;
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                lista.add(
                        new Equipo(
                                rs.getInt("codEquipo"),
                                rs.getString("Nombre")
                        ));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        GestorBD.desconectar();

        return lista;
    }

    // Para saber el código del dueño
    public static Duenyo duenyo(String nombre) {
        Duenyo duenyo = null;

        // Conexión a la BD
        Connection conexion = GestorBD.conectar();

        try {

            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM Dueño where Nombre = '" + nombre + "'";
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

