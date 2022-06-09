/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arqui1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import text.Control;
import ziconos.FatalError;

public class Conexion1 {
    Connection Conexion1=null;
    private FatalError icono;
     public Conexion1(){
    icono =new FatalError();
    }
    public Connection conexion(){
        String sep = System.getProperty("line.separator");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion1=DriverManager.getConnection("jdbc:mysql://192.168.119.138:3306/pregrado2","user","1234");
        } catch (Exception e) {
             Logger.getLogger(Conexion1.class.getName()).log(Level.SEVERE, null, e);
             JOptionPane.showMessageDialog(null, "Error de Conexion, Al Parecer La Red (Wi-Fi)esta Baja en Conexion, Porfavor Intente Mas Tarde"+sep+"Si El problema Persiste Consulte Al Administrador del Servidor, El Programa se cerrara!!!", "", JOptionPane.WARNING_MESSAGE, icono);
            new Control().cerrarApp();
        }
        return Conexion1;
    }
    
}
