/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziconos;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
public class Lupa implements Icon{

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        try{
        Image imagen = new ImageIcon(getClass().getResource("/zimagenes/lupa4.jpg")).getImage();
        g.drawImage(imagen, 5, y, 150, 150, c);
        }catch(Exception e){
        System.out.println(e.getMessage());
        }
    }

    @Override
    public int getIconWidth() {
        return 150;
    }

    @Override
    public int getIconHeight() {
        return 150;
    }
 
}
