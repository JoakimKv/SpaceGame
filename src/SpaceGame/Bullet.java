
// Class: Bullet

package SpaceGame;

import java.awt.Graphics;
import java.awt.Rectangle;


public class Bullet extends GameObject implements EntityA {
     
   private Textures m_Textures;
   private SpaceGame m_SpaceGame;
  
   private Animation m_Animation;   
   
   public Bullet(double dX, double dY, Textures newTextures, 
                                                        SpaceGame spaceGame) {
       
       super(dX, dY);
       this.m_Textures = newTextures;
       this.m_SpaceGame = spaceGame;

       m_Animation = new Animation(1, m_Textures.m_pBullet, 3);       
       
   }
   
   public void tick() {
       
      m_dY -= 10;
      
      // if (Physics.Collision(this, m_SpaceGame.m_pEntitiesB)) {
      //   System.out.println("Collision detected!");         
      // }

      m_Animation.runAnimation();      
      
   }
   
   public void render(Graphics g) {
       
      // g.drawImage(m_Textures.m_pBullet[0], (int) m_dX, (int) m_dY, null);
      m_Animation.drawAnimation(g, m_dX, m_dY, 0);
       
   }
 
   public double getX() {
      return m_dX;
   } 
   
   public double getY() {
      return m_dY;
   }
   
   // Default object's size: iWidth = 32 and iHeight = 32.
   public Rectangle getBounds() {
      return new Rectangle((int) m_dX, (int) m_dY, 32, 32);
   }
   
   public Rectangle getBounds(int iWidth, int iHeight) {
      return new Rectangle((int) m_dX, (int) m_dY, iWidth, iHeight);   
   }
   
}
