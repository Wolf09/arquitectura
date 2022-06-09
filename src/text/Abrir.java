/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.JOptionPane;
import ziconos.Advertencia;
import ziconos.Lupa;

/**
 *
 * @author WildoJ
 */
public class Abrir {
    private Advertencia icono;
    private Lupa icono2;
    public Abrir(){
    icono= new Advertencia();
    icono2= new Lupa();
    JOptionPane.showMessageDialog(null, "Estamos Buscando su Documento, Esto puede tardar unos Minutos!!!","",JOptionPane.WARNING_MESSAGE,icono2);
    }

  public void launchFile(File file)
  {
    if(!Desktop.isDesktopSupported()) return;
    Desktop dt = Desktop.getDesktop();
    try
    {
      dt.open(file);
      //JOptionPane.showMessageDialog(null, "Estamos Buscando su Documento, Esto puede tardar unos minutos","",JOptionPane.WARNING_MESSAGE,icono2);
    } catch (IOException ex)
    {
      JOptionPane.showMessageDialog(null, "ERROR!!! Usted Aun no subio ningun Documento como Recurso","",JOptionPane.WARNING_MESSAGE,icono);
      launchFile(file.getPath());
    }
  }
  
  //this can launch both local and remote files
  public void launchFile(String filePath)
  {
    if(filePath == null || filePath.trim().length() == 0) return;
    if(!Desktop.isDesktopSupported()) return;
    Desktop dt = Desktop.getDesktop();
    try
    {      
       dt.browse(getFileURI(filePath));
    } catch (Exception ex)
    {
        JOptionPane.showMessageDialog(null, "ERROR!!! Usted Aun no subio ningun Documento como Recurso","",JOptionPane.WARNING_MESSAGE,icono);
      ex.printStackTrace();
     }
   }

  //generate uri according to the filePath
  private URI getFileURI(String filePath)
  {
    URI uri = null;
    filePath = filePath.trim();
    if(filePath.indexOf("http") == 0 || filePath.indexOf("\\") == 0)
    {
      if(filePath.indexOf("\\") == 0) filePath = "file:" + filePath;
      try
      {
        filePath = filePath.replaceAll(" ", "%20");
        URL url = new URL(filePath);
        uri = url.toURI();
      } catch (MalformedURLException ex)
      {
          JOptionPane.showMessageDialog(null, "ERROR!!! Usted Aun no subio ningun Documento como Recurso","",JOptionPane.WARNING_MESSAGE,icono);
        ex.printStackTrace();
      }
      catch (URISyntaxException ex)
      {
          JOptionPane.showMessageDialog(null, "ERROR!!! Usted Aun no subio ningun Documento como Recurso","",JOptionPane.WARNING_MESSAGE,icono);
        ex.printStackTrace();
      }
    }
    else
    {
      File file = new File(filePath);
      uri = file.toURI();
    }
    return uri;
  }
  

}
