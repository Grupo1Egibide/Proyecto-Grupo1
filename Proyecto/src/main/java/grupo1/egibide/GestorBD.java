package grupo1.egibide;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestorBD {
    private static Connection conexion;

    public static Connection conectar(){

        try{
            if (conexion==null || conexion.isClosed()){
                //Driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                //Cadena de conexión
                String servidor ="192.168.33.10";
                String puerto = "3306";
                String bd="mydb"; //cambiar por liga
                String login="root";
                String password="root";
                String opciones = "?verifyServerCertificate=false&useSSL=true&requireSSL=false";
                String url = "jdbc:mysql://" + servidor + ":" + puerto + "/" + bd + opciones;

                //Establecer conexion
                conexion = DriverManager.getConnection(url,login,password);


            }
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return conexion;
    }

    public static void desconectar(){
        if(conexion!= null) {
            try{
                conexion.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }


}
