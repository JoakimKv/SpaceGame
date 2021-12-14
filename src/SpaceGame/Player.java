
// Class: Player

package SpaceGame;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Player extends GameObject implements EntityA {
  
   private double m_dVelX = 0;
   private double m_dVelY = 0;   
      
   private Textures m_Textures;
   
   private SpaceGame m_SpaceGame;
   private Controller m_Controller;
   
   private Animation m_Animation;
   
   public Player(double dX, double dY, Textures newTextures, 
                              SpaceGame spaceGame, Controller newController) {
      
      super(dX, dY);
      this.m_Textures = newTextures;
      this.m_SpaceGame = spaceGame;
      this.m_Controller = newController;
      
      m_Animation = new Animation(1, m_Textures.m_pPlayer, 3);
      
   }
   
   public void tick() {
       
      int iCount; 
       
      m_dX += m_dVelX; 
      m_dY += m_dVelY;    
      
      // Keep the player on screen.
      if (m_dX <= 0) {
         m_dX = 0;
      }
      
      if (m_dX > 640 - 26) {
         m_dX = 640 - 26;
      }      
      
      if (m_dY <= 0) {
         m_dY = 0;
      }
      
      if (m_dY > 480 - 32) {
         m_dY = 480 - 32;
      }            
      
      for (iCount = 0; iCount < m_SpaceGame.m_pEntitiesB.size(); ++iCount) {
      
         EntityB tempEntityB = m_SpaceGame.m_pEntitiesB.get(iCount);
         
         // Check if Collision between the Player (this) and an Enemy ship
         // (tempEntityB).
         if (Physics.Collision(this, tempEntityB)) {
         
            m_Controller.removeEntity(tempEntityB);
            SpaceGame.m_iHealth -= 10;
            m_SpaceGame.setEnemyKilled(m_SpaceGame.getEnemyKilled() + 1);
            
            // The Player is killed, finnish the game.
            if (SpaceGame.m_iHealth <= 0) {
                
               SpaceGame.m_iHealth = 0;
               m_SpaceGame.m_State = SpaceGame.STATE.GAMEOVER;
               
            }
            
         }         
          
      }
      
      m_Animation.runAnimation();
      
   }
   
   public void render(Graphics g) {
       
      // g.drawImage(m_Textures.m_pPlayer[0], (int)m_dX, (int)m_dY, null);
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

   public void setVelX(double dVelX) {
      this.m_dVelX = dVelX;
   } 
   
   public void setVelY(double dVelY) {
      this.m_dVelY = dVelY;
   }
   
   // Default object's size: iWidth = 32 and iHeight = 32.
   public Rectangle getBounds() {
      return new Rectangle((int) m_dX, (int) m_dY, 32, 32);
   }
   
   public Rectangle getBounds(int iWidth, int iHeight) {
      return new Rectangle((int) m_dX, (int) m_dY, iWidth, iHeight);   
   }  
   
}
