
package arqui1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import text.Control;
import ziconos.FatalError;

public class ConexionUser {
    Connection ConexionUser=null;
    private FatalError icono;
    public ConexionUser(){
    icono =new FatalError();
    }
    public Connection conexion(){
        String sep = System.getProperty("line.separator");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConexionUser=DriverManager.getConnection("jdbc:mysql://192.168.119.138:3306/usuarios","user","1234");
        } catch (Exception e) {
            Logger.getLogger(ConexionUser.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error de Conexion, Al Parecer La Red (Wi-Fi)esta Baja en Conexion, Porfavor Intente Mas Tarde"+sep+"Si El problema persiste Consulte Al Administrador del Servidor, El Programa se cerrara!!!", "", JOptionPane.WARNING_MESSAGE, icono);
            new Control().cerrarApp();
        }
        return ConexionUser;
    }
    
}