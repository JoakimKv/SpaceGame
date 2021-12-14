
// Class: Enemy

package SpaceGame;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class Enemy extends GameObject implements EntityB {
   
   private Random m_Random = new Random();

   private Textures m_Textures;
   
   private int m_iSpeed = m_Random.nextInt(3) + 1;
   
   private Animation m_Animation;
   
   private SpaceGame m_SpaceGame;  
   private Controller m_Controller;
   
   
   public Enemy(double dX, double dY, Textures newTextures, 
                              Controller newController, SpaceGame spaceGame) {
      
      super(dX, dY);
      this.m_Textures = newTextures;
      this.m_Controller = newController;
      this.m_SpaceGame = spaceGame;
 
      m_Animation = new Animation(1, m_Textures.m_pEnemy, 3);
      
   }
   
   public void tick() {
      
       int iCount;
       
       m_dY += m_iSpeed; 

       if (m_dY > (SpaceGame.HEIGHT * SpaceGame.SCALE)) {
           
          // m_iSpeed = m_Random.nextInt(3) + 1; 
          
          m_dY = 0;
          m_dX = m_Random.nextInt(SpaceGame.WIDTH * SpaceGame.SCALE);
          
       }
       
       for (iCount = 0; iCount < m_SpaceGame.m_pEntitiesA.size(); ++iCount) {
       
          EntityA tempEntityA = m_SpaceGame.m_pEntitiesA.get(iCount);
          
          // The "this" variable is here an EntityB object (an Enemy object).
          // The TempEntityA is the Bullet object (EntityA objects).
          if (Physics.Collision(this, tempEntityA)) {
              
             m_Controller.removeEntity(tempEntityA);
             m_Controller.removeEntity(this);
             m_SpaceGame.setEnemyKilled(m_SpaceGame.getEnemyKilled() + 1);
             
          }
          
           
       }
       
       if (Physics.Collision(this, m_SpaceGame.m_pEntitiesA)) {
       
          m_Controller.removeEntity(this);
          m_SpaceGame.setEnemyKilled(m_SpaceGame.getEnemyKilled() + 1);
           
       }
       
       m_Animation.runAnimation();
       
   }
   
   public void render(Graphics g) {
       
      // g.drawImage(m_Textures.m_pEnemy[0], (int)m_dX, (int)m_dY, null);
      m_Animation.drawAnimation(g, m_dX, m_dY, 0);
       
   } 
   
   public double getX() {
      return m_dX;
   }
   
   public double getY() {
      return m_dY;
   }
   
   public void setX(double dX) {
      this.m_dX = dX;
   }
    
   public void setY(double dY) {
      this.m_dY = dY;
   }
   
   // Default object's size: iWidth = 32 and iHeight = 32.
   public Rectangle getBounds() {
      return new Rectangle((int) m_dX, (int) m_dY, 32, 32);
   }
   
   public Rectangle getBounds(int iWidth, int iHeight) {
      return new Rectangle((int) m_dX, (int) m_dY, iWidth, iHeight);   
   } 
   
}
