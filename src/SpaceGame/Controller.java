
// Class: Controller

package SpaceGame;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;


public class Controller {
    
   private LinkedList<EntityA> m_pEntitiesA = new LinkedList<EntityA>();
   private LinkedList<EntityB> m_pEntitiesB = new LinkedList<EntityB>();
    
   Random m_Random = new Random(); 
      
   EntityA m_TempEntityA;
   EntityB m_TempEntityB;
   
   SpaceGame m_SpaceGame;
   Textures m_Textures;
   
   public Controller(SpaceGame spaceGame, Textures newTextures) {
              
      this.m_SpaceGame = spaceGame;
      this.m_Textures = newTextures;
            
      addEntity(new Enemy(m_Random.nextInt(SpaceGame.WIDTH * SpaceGame.SCALE), 
                                           0, newTextures, this, m_SpaceGame));      
      
   }
   
   public void tick() {
       
      int iCount; 
      
      // For EntityA (A class).
      
      for (iCount = 0; iCount < m_pEntitiesA.size(); ++iCount) {
         
         
         m_TempEntityA = m_pEntitiesA.get(iCount);
         
         if (m_TempEntityA.getY() < 0) {
            removeEntity(m_TempEntityA);
         }
         
         m_TempEntityA.tick();         
         
      }
      
      // For EntityB (B class).
      
      for (iCount = 0; iCount < m_pEntitiesB.size(); ++iCount) {
         
         
         m_TempEntityB = m_pEntitiesB.get(iCount);
         
         if (m_TempEntityB.getY() < 0) {
            removeEntity(m_TempEntityB);
         }
         
         m_TempEntityB.tick();         
         
      }
      
   } 
   
   public void render(Graphics g) {
       
      int iCount;
      
      // For EntityA (A class). 
      
      for (iCount = 0; iCount < m_pEntitiesA.size(); ++iCount) {
          
         m_TempEntityA = m_pEntitiesA.get(iCount);
                  
         m_TempEntityA.render(g);         
         
      }
      
      // For EntityB (B class).
      
      for (iCount = 0; iCount < m_pEntitiesB.size(); ++iCount) {
          
         m_TempEntityB = m_pEntitiesB.get(iCount);
                  
         m_TempEntityB.render(g);         
         
      }
      
   }
      
   public void addEntity(EntityA newEntityA) {
      m_pEntitiesA.add(newEntityA);
   }
   
   public void removeEntity(EntityA newEntityA) {
      m_pEntitiesA.remove(newEntityA);
   }    
 
   public void addEntity(EntityB newEntityB) {
      m_pEntitiesB.add(newEntityB);
   }
   
   public void removeEntity(EntityB newEntityB) {
      m_pEntitiesB.remove(newEntityB);
   }      
   
   public void createEnemy(int iEnemyCount) {
   
      int iCount;
      
      for (iCount = 0; iCount < iEnemyCount; ++iCount) {
          
         addEntity(new Enemy(m_Random.nextInt(SpaceGame.WIDTH * 
                 SpaceGame.SCALE), 0, m_Textures, this, m_SpaceGame));
         
      }
       
   }
   
   public LinkedList<EntityA> getEntityA() {
      return m_pEntitiesA;
   }
   
   public LinkedList<EntityB> getEntityB() {
      return m_pEntitiesB;
   }   
   
}
