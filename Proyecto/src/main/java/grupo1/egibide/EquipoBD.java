package grupo1.egibide;

import grupo1.egibide.modelo.TablaJugadoresModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EquipoBD {

    // DEVUELVE TODOS LOS EQUIPOS
    public static List<Equipo> equipos(/*int codDuenyo*/) {

        List<Equipo> listaEquipos = new ArrayList<>();

        Connection conexion = GestorBD.conectar();

        try {
            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM Equipo" /*WHERE Dueño_codDueño = " + codDuenyo*/;
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                listaEquipos.add(
                        new Equipo(
                                rs.getInt("codEquipo"),
                                rs.getString("nombre")
                                /*rs.getInt("anyoFundacion"),
                                rs.getInt("Dueño_codDueño")*/
                        )
                );

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        GestorBD.desconectar();

        return listaEquipos;


    }

    //Guardamos un nuevo jugador
    public static void guardar(Equipo equipo) {

        Connection conexion = GestorBD.conectar();

        try {

            String sql;
            java.sql.PreparedStatement st;

            if (equipo.getCodEquipo() == -1) {
                sql = "INSERT INTO Equipo (`nombre`,`codDueño`) VALUES (?,?)";
                st = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                System.out.println(equipo.getNombre());
                System.out.println(equipo.getDuenyo1().getCodDuenyo());
                st.setString(1, equipo.getNombre());
                st.setInt(2, equipo.getDuenyo1().getCodDuenyo());
                //System.out.println(equipo.getDuenyo1().getCodDuenyo());
            } else {
                sql = "UPDATE Equipo SET nombre=?,codDueño=? " +
                        "WHERE codEquipo=" + equipo.getCodEquipo();

                st = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                st.setString(1, equipo.getNombre());
                //System.out.println(equipo.getDuenyo1().getCodDuenyo());
                st.setInt(2, equipo.getDuenyo1().getCodDuenyo());
                // st.setInt(2, equipo.getDuenyo1().getCodDuenyo());

            }
            int filasAfectadas = st.executeUpdate();
            if (equipo.getCodEquipo() == -1 && filasAfectadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    equipo.setCodEquipo(rs.getInt(1));
                }
            }

            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        GestorBD.desconectar();

    }

    //ELIMINAR
    public static void eliminar(Equipo equipo) {

        Connection conexion = GestorBD.conectar();

        try {

            String sql;
            java.sql.PreparedStatement st;

            sql = "DELETE FROM Equipo WHERE codEquipo=" + equipo.getCodEquipo();

            st = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            int filasAfectadas = st.executeUpdate();
            if (equipo.getCodEquipo() == -1 && filasAfectadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    equipo.setCodEquipo(rs.getInt(1));
                }
            }

            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        GestorBD.desconectar();

    }

    //SACAR TODOS LOS JUGADORES DE UN EQUIPO
    public static List<Jugador> buscarEquipos(int codigo) {

        Jugador JUGADOR = null;
        List<Jugador> lista = new ArrayList<>();
        Connection conexion = GestorBD.conectar();

        try {

            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM Jugador where Equipo_codEquipo =" + codigo;
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

              /*  JUGADOR = new Jugador(
                        rs.getInt("codJugador"),
                        rs.getString("Nombre"),
                        rs.getString("Nick"),
                        rs.getInt("Salario"),
                        rs.getString("FechaAlta"),
                        rs.getString("Posicion"),
                        rs.getInt("Equipo_codEquipo")
                );*/
                lista.add(
                        new Jugador(
                                rs.getInt("codJugador"),
                                rs.getString("Nombre"),
                                rs.getString("Nick"),
                                rs.getInt("Salario"),
                                rs.getString("FechaAlta"),
                                rs.getString("Posicion"),
                                rs.getInt("Equipo_codEquipo")
                        ));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        GestorBD.desconectar();

        return lista;
    }

    //METODOS IZARO
// DEVUELVE LOS EQUIPOS QUE TIENE EL DUEÑO
    public static List<Equipo> equipos1(int codDuenyo) {

        List<Equipo> listaEquipos = new ArrayList<>();

        Connection conexion = GestorBD.conectar();

        try {
            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM Equipo WHERE Dueño_codDueño = " + codDuenyo;
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                listaEquipos.add(
                        new Equipo(
                                rs.getInt("codEquipo"),
                                rs.getString("nombre"),
                                rs.getInt("anyoFundacion"),
                                rs.getInt("Dueño_codDueño")
                        )
                );

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        GestorBD.desconectar();

        return listaEquipos;
    }

    // DEVUELVE LAS PROPIEDADES DEL EQUIPO SELECCIONADO EN PANTALLADUENYO1
    public static Equipo equipo(int codDuenyo, String nombreEquipo) {

        Equipo equipo = null;

        Connection conexion = GestorBD.conectar();

        try {
            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM Equipo WHERE Dueño_codDueño = " + codDuenyo + " AND nombre = '" + nombreEquipo + "'";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                equipo = new Equipo(
                        rs.getInt("codEquipo"),
                        rs.getString("nombre"),
                        rs.getInt("anyoFundacion"),
                        rs.getInt("Dueño_codDueño")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        GestorBD.desconectar();

        return equipo;

    }

    public boolean buscarEquipo(int codEquipo) {
        Connection conexion = GestorBD.conectar();
        boolean estado = true;

        try {

            Statement st = conexion.createStatement();
            String sql = "select * from Equipo where codEquipo=" + codEquipo;
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                estado = true;
            } else {
                estado = false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return estado;

    }
}

