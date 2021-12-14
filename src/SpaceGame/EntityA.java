
// Interface: EntityA

package SpaceGame;

import java.awt.Graphics;
import java.awt.Rectangle;


public interface EntityA {
    
   public void tick();
   public void render(Graphics g);
   
   // Default object's size: iWidth = 32 and iHeight = 32.
   public Rectangle getBounds();
   public Rectangle getBounds(int iWidth, int iHeight);   
   
   public double getX();
   public double getY();
   
}
