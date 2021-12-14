
// Class: GameObject

package SpaceGame;

import java.awt.Rectangle;


public class GameObject {
    
   protected double m_dX;
   protected double m_dY;
   
   public GameObject(double dX, double dY) {
      
      this.m_dX = dX;
      this.m_dY = dY;
      
   }
   
   public Rectangle getBounds(int iWidth, int iHeight) {
       
      return new Rectangle((int) m_dX, (int) m_dY, iWidth, iHeight);
      
   }
   
}
