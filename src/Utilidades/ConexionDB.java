
package Utilidades;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {
 
    public static Connection getConexion() {
        Connection cnx = null;
        try {
          //  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           // cnx = DriverManager.getConnection("jdbc:sqlserver://MARB:1433;databaseName=BD_CitasMedicas;user:sa;password=cenizo");
        	
        	Class.forName("com.mysql.jdbc.Driver");
        	cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/okoticket","root","");
            

        } catch (Exception e) {
            System.out.println(""+e.toString());
        }
        return cnx;
    }

}
