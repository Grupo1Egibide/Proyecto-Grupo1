package grupo1.egibide;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CuentaBD {

    public static List<Cuenta> cuentas() {

        List<Cuenta> lista = new ArrayList<>();
        Connection conexion = GestorBD.conectar();

        try {
            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM CUENTA";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                lista.add (
                        new Cuenta(rs.getString("nombre"),
                                rs.getString("contraseña"),
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


}
