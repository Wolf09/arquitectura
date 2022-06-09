/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import text.Control;
import ziconos.FatalError;

/**
 *
 * @author root
 */
public class Conexion6 {
    Connection Conexion6=null;
    private FatalError icono;
   public Conexion6(){
    icono =new FatalError();
    }
    public Connection conexion(){
         String sep = System.getProperty("line.separator");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion6=DriverManager.getConnection("jdbc:mysql://167.157.17.39:3306/administracion1","user","cg01");
        } catch (Exception e) {
               Logger.getLogger(Conexion6.class.getName()).log(Level.SEVERE, null, e);
             JOptionPane.showMessageDialog(null, "Error de Conexion, Al Parecer La Red (Wi-Fi)esta Baja en Conexion, Porfavor Intente Mas Tarde"+sep+"Si El problema Persiste Consulte Al Administrador del Servidor, El Programa se cerrara!!!", "", JOptionPane.WARNING_MESSAGE, icono);
            new Control().cerrarApp();
        }
        return Conexion6;
    }
    
}
