package grupo1.egibide;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CuentaBD {

    // Lista de todas las cuentas
    public static List<Cuenta> cuentas() {
        Inicio inicio;
        List<Cuenta> lista = new ArrayList<>();
        Connection conexion = GestorBD.conectar();

        try {
            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM Cuenta";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                lista.add(
                        new Cuenta(rs.getString("nombre"),
                                rs.getString("contrasena"),
                                rs.getInt("tipoCuenta")
                        )
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        GestorBD.desconectar();

        return lista;
    }

    //BUSCAR UN USUARIO DETERMINADO
    public static List<Cuenta> buscarUsuario(String nombre) {

        Cuenta CUENTA = null;
        List<Cuenta> lista = new ArrayList<>();
        Connection conexion = GestorBD.conectar();

        try {

            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM Cuenta where tipoCuenta=3 and nombre='" + nombre + "'";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                lista.add(
                        CUENTA = new Cuenta(
                                rs.getString("nombre"),
                                rs.getString("contrasena"),
                                rs.getInt("tipoCuenta")
                        ));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        GestorBD.desconectar();

        return lista;
    }

    // Lista de las cuentas que son tipo USUARIO
    public static List<Cuenta> cuentas1() {
        Inicio inicio;
        List<Cuenta> lista = new ArrayList<>();
        Connection conexion = GestorBD.conectar();

        try {
            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM Cuenta WHERE tipoCuenta=3";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                lista.add(
                        new Cuenta(rs.getString("nombre"),
                                rs.getString("contrasena"),
                                rs.getInt("tipoCuenta")
                        )
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        GestorBD.desconectar();

        return lista;
    }

    public static void guardar(Cuenta cuenta) {

        Connection conexion = GestorBD.conectar();

        try {

            String sql;
            java.sql.PreparedStatement st;

            if (cuenta.getCodCuenta() == -1) {
                sql = "INSERT INTO Cuenta  " +
                        "VALUES (?,?,?)";
                st = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                //st.setString(1, jugador.getDni());
                st.setString(1, cuenta.getNombre());
                st.setString(2, cuenta.getContrasenya());
                st.setInt(3, cuenta.getTipoCuenta());

            } else {
                sql = "UPDATE Cuenta SET nombre=?,contrasena=?,tipoCuenta=3 " +
                        "WHERE nombre ='" + cuenta.getNombre() + "'";

                /* System.out.println(jugador.getNick());*/
                st = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                st.setString(1, cuenta.getNombre());
                st.setString(2, cuenta.getContrasenya());


            }
            int filasAfectadas = st.executeUpdate();
            if (cuenta.getCodCuenta() == -1 && filasAfectadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    cuenta.setCodCuenta(rs.getInt(1));
                }
            }

            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        GestorBD.desconectar();

    }

    public static void guardar1(String nombreUsuario, Cuenta cuenta) {

        Connection conexion = GestorBD.conectar();

        try {

            String sql;
            java.sql.PreparedStatement st;

            if (cuenta.getCodCuenta() == -1) {
                sql = "INSERT INTO Cuenta  " +
                        "VALUES (?,?,?)";
                st = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                //st.setString(1, jugador.getDni());
                st.setString(1, cuenta.getNombre());
                st.setString(2, cuenta.getContrasenya());
                st.setInt(3, cuenta.getTipoCuenta());

            } else {
                sql = "UPDATE Cuenta SET nombre=?,contrasena=?,tipoCuenta=3 " +
                        "WHERE nombre ='" + nombreUsuario + "'";

                /* System.out.println(jugador.getNick());*/
                st = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                st.setString(1, cuenta.getNombre());
                st.setString(2, cuenta.getContrasenya());


            }
            int filasAfectadas = st.executeUpdate();
            if (cuenta.getCodCuenta() == -1 && filasAfectadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    cuenta.setCodCuenta(rs.getInt(1));
                }
            }

            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        GestorBD.desconectar();

    }

    //ELIMINAR UN JUGADOR
    public static void eliminar(Cuenta usuario) {

        Connection conexion = GestorBD.conectar();

        try {

            String sql;
            java.sql.PreparedStatement st;

            sql = "DELETE FROM Cuenta WHERE nombre='" + usuario.getNombre() + "'";
            st = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            int filasAfectadas = st.executeUpdate();
            if (usuario.getCodCuenta() == -1 && filasAfectadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    usuario.setCodCuenta(rs.getInt(1));
                }
            }

            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        GestorBD.desconectar();

    }

}
