package grupo1.egibide;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EquipoBD {

    // DEVUELVE LOS EQUIPOS QUE TIENE EL DUEÑO
    public static List<Equipo> equipos(int codDuenyo) {

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
        boolean estado=true;

        try {

            Statement st = conexion.createStatement();
            String sql = "select * from Equipo where codEquipo=" + codEquipo;
            ResultSet rs = st.executeQuery(sql);

            if(rs.next()){
                estado=true;
            }
            else{
                estado= false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return estado;

    }
}

