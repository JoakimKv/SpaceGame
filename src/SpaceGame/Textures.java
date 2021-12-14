
// Class: Textures

package SpaceGame;

import java.awt.image.BufferedImage;


public class Textures {
 
   public BufferedImage[] m_pPlayer = new BufferedImage[3];
   public BufferedImage[] m_pBullet = new BufferedImage[3];
   public BufferedImage[] m_pEnemy = new BufferedImage[3];
   
   private SpriteSheet m_SpriteSheet;
   
   public Textures(SpaceGame spaceGame) {
       
      m_SpriteSheet = new SpriteSheet(spaceGame.getSpriteSheet());
      
      getTextures();
      
   }
    
   private void getTextures() {
   
      int iCount;  
      
      for (iCount = 0; iCount < 3; ++iCount) {
          
         m_pPlayer[iCount] = m_SpriteSheet.grabImage(iCount + 1, 1, 32, 32);       
         m_pBullet[iCount] = m_SpriteSheet.grabImage(iCount + 1, 2, 32, 32);         
         m_pEnemy[iCount]  = m_SpriteSheet.grabImage(iCount + 1, 3, 32, 32);
         
      }
      
   }
   
}
