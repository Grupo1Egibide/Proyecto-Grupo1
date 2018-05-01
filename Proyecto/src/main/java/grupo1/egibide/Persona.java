package grupo1.egibide;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Persona {

    private String dni;
    private String nombre;
    private String fechaNac;
    private int edad;
    private String poblacion;

    Connection conexion=GestorBD.conectar();

    Statement st = conexion.createStatement();
    String sql= "SELECT * FROM JUGADOR";
    ResultSet rs=st.executeQuery(sql);

}
