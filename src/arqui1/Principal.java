
package arqui1;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import text.Control;

/**
 *
 * @author Jhonatan Barrientos
 */
public class Principal {
    public static void main(String args[]){
        if(new Control().comprobar()){
        try{
                JFrame.setDefaultLookAndFeelDecorated(true);
                JDialog.setDefaultLookAndFeelDecorated(true);
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                //UIManager.put("OptionPane.messageForeground", Color.white);
                UIManager.put("OptionPane.messageFont", new Font("Tahoma", Font.BOLD, 12));
                //new Font("Tahoma", Font.BOLD, 12)
                //UIManager.put("OptionPane.foreground", Color.white);
                //UIManager.put("nimbusBase", new Color(255,255,255));
                //UIManager.put("nimbusBlueGrey", new Color(255,255,255));
                UIManager.put("control", new Color(80,170,255));
                //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                 }
       catch (Exception e)
               {
                e.printStackTrace();
               }
        Usuario user1 = new Usuario();
       }
        else{
            System.exit(0);
        }
    }
}
