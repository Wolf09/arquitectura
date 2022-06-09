
package proyectos;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Abrir {
    //launch file
  public void abrirA(File file){
  try {
     Desktop.getDesktop().open(file);
}catch (IOException ex) {
     ex.printStackTrace();
}
  }
}
   /**public static void main(String args[]){
    File f= new File("\\\\172.16.34.141\\Documentos1");
    Abrir a= new Abrir();
    a.abrirA(f);
    }
}**/
